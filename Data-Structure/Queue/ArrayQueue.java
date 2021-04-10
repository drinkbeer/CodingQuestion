package Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
A basic implementation of a queue using an array
http://math.hws.edu/javanotes/c9/s3.html
http://eddmann.com/posts/implementing-a-queue-in-java-using-arrays-and-linked-lists/
https://algs4.cs.princeton.edu/13stacks/ResizingArrayQueue.java.html
*/
public class ArrayQueue<Item> implements Iterable<Item> {
  private static final int INIT_CAPACITY = 8;

  private Item[] q; // queue elements
  private int n; // number of elements on queue
  private int first; // index of first element of queue
  private int last; // index of next available slot

  public ArrayQueue() {
    q = (Item[]) new Object[INIT_CAPACITY];
    n = 0;
    first = 0;
    last = 0;
  }

  public ArrayQueue(int capacity) {}

  public void enqueue(Item item) {
    if (n == q.length) resize(2 * q.length); // double size of array if necessary
    q[last++] = item;
    if (last == q.length) last = 0; // wrap-around
    n++;
  }

  public Item dequeue() {
    if (isEmpty()) throw new NoSuchElementException("Queue underflow");
    Item item = q[first];
    q[first] = null;
    n--;
    first++;
    if (first == q.length) first = 0; // wrap-around
    if (n > 0 && n == q.length / 4) resize(q.length / 2); // shrink size of array if necessary
    return item;
  }

  public Item peek() {
    if (isEmpty()) throw new NoSuchElementException("Queue underflow");
    return q[first];
  }

  public int size() {
    return n;
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Item item : this) {
        sb.append(item);
        sb.append(' ');
    }
    return sb.toString();
  }

  private void resize(int capacity) {
    assert capacity >= n;
    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < n; i++) {
      copy[i] = q[(first + i) % q.length];
    }
    q = copy;
    first = 0;
    last = n;
  }

  @Override
  public Iterator<Item> iterator() {
    return new ArrayIterator();
  }

  // an iterator, doesn't implement remove() since it's optional
  private class ArrayIterator implements Iterator<Item> {
    private int i = 0;

    public boolean hasNext() {
      return i < n;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      Item item = q[(i + first) % q.length];
      i++;
      return item;
    }
  }

  public static void main(String[] args) {
    ArrayQueue<String> queue = new ArrayQueue<>();
    queue.enqueue("Item1");
    queue.enqueue("Item2");
    queue.enqueue("Item3");
    queue.enqueue("Item4");
    queue.enqueue("Item5");
    queue.enqueue("Item6");
    System.out.println("(" + queue.size() + " left on queue)");
    System.out.println(queue.toString());
  }
}
