Design a time-based task dispatcher.

## Using Java DelayQueue

#### Understand how Java DelayQueue works

DelayQueue is a PriorityBlockingQueue ordered based on the delay times.

```
public class DelayQueue<E extends Delayed> extends AbstractQueue<E>
    implements BlockingQueue<E> {

    private final transient ReentrantLock lock = new ReentrantLock();
    private final PriorityQueue<E> q = new PriorityQueue<E>();

    /**
     * Thread designated to wait for the element at the head of
     * the queue.  This variant of the Leader-Follower pattern
     * (http://www.cs.wustl.edu/~schmidt/POSA/POSA2/) serves to
     * minimize unnecessary timed waiting.  When a thread becomes
     * the leader, it waits only for the next delay to elapse, but
     * other threads await indefinitely.  The leader thread must
     * signal some other thread before returning from take() or
     * poll(...), unless some other thread becomes leader in the
     * interim.  Whenever the head of the queue is replaced with
     * an element with an earlier expiration time, the leader
     * field is invalidated by being reset to null, and some
     * waiting thread, but not necessarily the current leader, is
     * signalled.  So waiting threads must be prepared to acquire
     * and lose leadership while waiting.
     */
    private Thread leader;

    /**
     * Condition signalled when a newer element becomes available
     * at the head of the queue or a new thread may need to
     * become leader.
     */
    private final Condition available = lock.newCondition();
    
    /**
     * Inserts the specified element into this delay queue.
     * If q.peek() equals to e, which means the queue is empty() before this put, and all other threads should be 
     * sleeping. Now we empty leader, and signal all threads through available. These threads will try to become leader
     * and call take() method.
     */
    public boolean offer(E e) {
        final ReentrantLock lock = this.lock;
        lock.lock();
        try {
            q.offer(e);
            if (q.peek() == e) {
                leader = null;
                available.signal();
            }
            return true;
        } finally {
            lock.unlock();
        }
    }
    
    /**
     * Retrieves and removes the head of this queue, waiting if necessary
     * until an element with an expired delay is available on this queue.
     *
     * Try to get the head of the queue. If get (queue is not empty), check if the expiration time eclapsed.
     * If yes, then return the head for current thread to execute.
     * If no, means delayed time has not eclapsed. Now check the if the leader is empty, if not empty which means there is 
     * another thread has already been waiting for executing this head task, make current thread sleep.
     * If leader is empty, make current thread to be leader, and wait the pending wait time. Once the pending wait time 
     * elapsed, call take() again to execute the task. If finished executing the task, it will empty the leader, and signal 
     * all other consumer to race to become leader to execute next jobs.
     */
    public E take() throws InterruptedException {
        final ReentrantLock lock = this.lock;
        lock.lockInterruptibly();
        try {
            for (;;) {
                E first = q.peek();
                if (first == null)
                    available.await();
                else {
                    long delay = first.getDelay(NANOSECONDS);
                    if (delay <= 0L)
                        return q.poll();
                    first = null; // don't retain ref while waiting
                    if (leader != null)
                        available.await();
                    else {
                        Thread thisThread = Thread.currentThread();
                        leader = thisThread;
                        try {
                            available.awaitNanos(delay);
                        } finally {
                            if (leader == thisThread)
                                leader = null;
                        }
                    }
                }
            }
        } finally {
            if (leader == null && q.peek() != null)
                available.signal();
            lock.unlock();
        }
    }
}
```

One scenario: Thread A become a Leader of Task 1 (delay time: curr + 50ms). Thread B - D are awaiting now. At curr + 10ms, producer offered a new Task 2, which has delay curr + 10 ms (this curr is the original curr + 10, so this deleay time is original curr + 20 ms, which is higher than the original Task 1), and become a new head. Now producer found Task 2 is the same as the task he enqueued, so he signals all Thread A - D, and let them race for the job. (be careful that when Thread A is waiting "available.awaitNanos(delay);", it will release the leader at the finally block, so that other threads could race for leader).

Task: 
```
package TaskDispatcher;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Task implements Delayed {

    private String name;
    private long startTime;

    public Task(String name, long delay) {
        this.name = name;
        this.startTime = System.currentTimeMillis() + delay;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return (int) (this.startTime - ((Task) o).getStartTime());
    }

    private long getStartTime() {
        return this.startTime;
    }


    @Override
    public String toString() {
        return "task: " + name + " at " + startTime;
    }
}

```

Producer:
```
package TaskDispatcher;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.DelayQueue;

public class TaskProducer implements Runnable{

    private final Random rand = new Random();
    private DelayQueue<Task> queue;

    public TaskProducer(DelayQueue<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                int delay = rand.nextInt(10000);
                Task task = new Task(UUID.randomUUID().toString(), delay);
                System.out.println("Put " + task);
                queue.offer(task);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

```

Consumer
```
package TaskDispatcher;

import java.util.concurrent.DelayQueue;

public class TaskConsumer implements Runnable {

    private DelayQueue<Task> queue;

    public TaskConsumer(DelayQueue<Task> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Task task = queue.take();
                System.out.println("Take " + task);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

```

Scheduler:
```
package TaskDispatcher;

import java.util.concurrent.DelayQueue;

public class TaskScheduler {
    public static void main(String[] args) {
        DelayQueue<Task> queue = new DelayQueue<>();
        new Thread(new TaskProducer(queue), "Producer Thread").start();
        new Thread(new TaskConsumer(queue), "Consumer Thread").start();
    }
}

```

## HashedWheelTimer

Netty's implementation of HashedWheelTimer: https://github.com/netty/netty/blob/4.1/common/src/main/java/io/netty/util/HashedWheelTimer.java


#### Understand Redis ZSet and Skiplist
https://zsr.github.io/2017/07/03/redis-zset%E5%86%85%E9%83%A8%E5%AE%9E%E7%8E%B0/

## Reference
* https://soulmachine.gitbooks.io/system-design/cn/task-scheduler.html
* DelayQueue: https://www.geeksforgeeks.org/delayqueue-class-in-java-with-example/

