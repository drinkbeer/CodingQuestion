package Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** https://algs4.cs.princeton.edu/13stacks/LinkedStack.java.html */
public class LinkedStack<Item> implements Iterable<Item> {
  private int n;
  private Node first;

  private class Node {
    private Item item;
    private Node next;
  }

  public LinkedStack() {
    first = null;
    n = 0;
    assert check();
  }

  public void push(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    n++;
    assert check();
  }

  public Item pop() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    Item item = first.item;
    first = first.next;
    n--;
    assert check();
    return item;
  }

  public Item peek() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    return first.item;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Item item : this) {
      sb.append(item);
      sb.append(' ');
    }
    return sb.toString();
  }

  // check internal invariants
  private boolean check() {
    // check a few properties of instance variable 'first'
    if (n < 0) {
      return false;
    }
    if (n == 0) {
      if (first != null) return false;
    } else if (n == 1) {
      if (first == null) return false;
      if (first.next != null) return false;
    } else {
      if (first == null) return false;
      if (first.next == null) return false;
    }

    // check internal consistency of instance variable n
    int numberOfNodes = 0;
    for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
      numberOfNodes++;
    }
    if (numberOfNodes != n) return false;

    return true;
  }

  /**
   * Returns a string representation of this stack.
   *
   * @return the sequence of items in the stack in LIFO order, separated by spaces
   */
  @Override
  public Iterator<Item> iterator() {
    return new LinkedIterator();
  }

  // an iterator, doesn't implement remove() since it's optional
  private class LinkedIterator implements Iterator<Item> {
    private Node current = first;

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
    LinkedStack<String> stack = new LinkedStack<>();
    stack.push("Item1");
    stack.push("Item2");
    stack.push("Item3");
    stack.push("Item4");
    stack.push("Item5");
    System.out.println(stack.toString());
  }
}
