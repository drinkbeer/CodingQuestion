package Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/*
A basic implementation of a queue using a linked list.
http://algs4.cs.princeton.edu/43mst/Queue.java.html
*/
public class LinkedQueue<Item> implements Iterable<Item> {
  private Node<Item> first; // beginning of queue
  private Node<Item> last; // end of queue
  private int n; // number of elements on queue

  // helper linked list class
  private static class Node<Item> {
    private Item item;
    private Node<Item> next;
  }

  public LinkedQueue() {
    first = null;
    last = null;
    n = 0;
  }

  public void enqueue(Item item) {
    Node<Item> oldLast = last;
    last = new Node<Item>();
    last.item = item;
    last.next = null;
    if (isEmpty()) first = last;
    else oldLast.next = last;
    n++;
  }

  public Item dequeue() {
    if (isEmpty()) throw new NoSuchElementException("Queue underflow");
    Item item = first.item;
    first = first.next;
    n--;
    if (isEmpty()) last = null; // to avoid loitering
    return item;
  }

  public Item peek() {
    if (isEmpty()) throw new NoSuchElementException("Queue underflow");
    return first.item;
  }

  public int size() {
    return n;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Item item : this) {
      sb.append(item);
      sb.append(' ');
    }
    return sb.toString();
  }

  @Override
  public Iterator<Item> iterator() {
    return new LinkedIterator(first);
  }

  // an iterator, doesn't implement remove() since it's optional
  private class LinkedIterator implements Iterator<Item> {
    private Node<Item> current;

    public LinkedIterator(Node<Item> first) {
      current = first;
    }

    public boolean hasNext() {
      return current != null;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }

  public static void main(String[] args) {
    LinkedQueue<String> queue = new LinkedQueue<String>();
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
