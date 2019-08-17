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

```

```

