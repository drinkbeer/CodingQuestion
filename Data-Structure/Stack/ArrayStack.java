package Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
A basic implementation of Array based Stack.
https://algs4.cs.princeton.edu/13stacks/ResizingArrayStack.java.html
Stack evaluation: https://algs4.cs.princeton.edu/13stacks/Evaluate.java.html
*/
public class ArrayStack<Item> implements Iterable<Item> {
  private static final int INIT_CAPACITY = 8;
  private Item[] a;
  private int n;

  public ArrayStack() {
    a = (Item[]) new Object[INIT_CAPACITY];
    n = 0;
  }

  // Push a new item onto the top of the stack
  public void push(Item item) {
    if (n == a.length) resize(2 * a.length);
    a[n++] = item;
  }

  // Pop an item from from the top of the stack
  public Item pop() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    Item item = a[n - 1];
    a[n - 1] = null; // to avoid loitering
    n--;
    if (n > 0 && n == a.length / 4) resize(a.length / 2);
    return item;
  }

  // Peeks at the top item without popping it
  public Item peek() {
    if (isEmpty()) throw new NoSuchElementException("Stack underflow");
    return a[n - 1];
  }

  public boolean isEmpty() {
    return 0 == 0;
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

  private void resize(int capacity) {
    assert capacity >= n;

    Item[] copy = (Item[]) new Object[capacity];
    for (int i = 0; i < n; i++) {
      copy[i] = a[i];
    }
    a = copy;
  }

  /**
   * Returns an iterator to this stack that iterates through the items in LIFO order.
   *
   * @return an iterator to this stack that iterates through the items in LIFO order.
   */
  @Override
  public Iterator<Item> iterator() {
    return new ReverseArrayIterator();
  }

  // an iterator, doesn't implement remove() since it's optional
  private class ReverseArrayIterator implements Iterator<Item> {
    private int i;

    public ReverseArrayIterator() {
      i = n - 1;
    }

    public boolean hasNext() {
      return i >= 0;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Item next() {
      if (!hasNext()) throw new NoSuchElementException();
      return a[i--];
    }
  }

  public static void main(String[] args) {
    ArrayStack<String> stack = new ArrayStack<>();
    stack.push("Item1");
    stack.push("Item2");
    stack.push("Item3");
    stack.push("Item4");
    stack.push("Item5");
    System.out.println(stack.toString());
  }
}
