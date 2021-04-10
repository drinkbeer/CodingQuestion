package PriorityQueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * https://algs4.cs.princeton.edu/24pq/MaxPQ.java.html
 *
 * <p>Notes: 1. Create an array with length capacity + 1, use 1 ... N, ignore position 0.
 */
public class MaxPQ<Key> implements Iterable<Key> {
  private Key[] pq;
  private int n;
  private Comparator<Key> comparator;

  public MaxPQ(int capacity) {
    pq = (Key[]) new Object[capacity + 1];
    n = 0;
  }

  public MaxPQ() {
    this(1);
  }

  public MaxPQ(int capacity, Comparator<Key> comparator) {
    this.comparator = comparator;
    pq = (Key[]) new Object[capacity + 1];
    n = 0;
  }

  public MaxPQ(Comparator<Key> comparator) {
    this(1, comparator);
  }

  public MaxPQ(Key[] keys) {
    n = keys.length;
    pq = (Key[]) new Object[n + 1];
    for (int i = 0; i < n; i++) {
      pq[i + 1] = keys[i];
    }
    for (int k = n / 2; k >= 1; k--) sink(k);
    assert isMaxHeap();
  }

  public boolean isEmpty() {
    return n == 0;
  }

  public int size() {
    return n;
  }

  public Key Max() {
    if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
    return pq[1];
  }

  public void insert(Key x) {
    if (n == pq.length - 1) resize(2 * pq.length);

    pq[++n] = x;
    swim(n);
    assert isMaxHeap();
  }

  public Key delMax() {
    if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
    Key max = pq[1];
    exch(1, n--);
    sink(1);
    pq[n + 1] = null; // to avoid loitering and help with garbage collection
    if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
    assert isMaxHeap();
    return max;
  }

  // Helper functions

  /*
  Opposite operation to sink. The idea is to keep on comparing k / 2, and k, if k / 2 < k, swap k / 2 and k.
   */
  private void swim(int k) {
    while (k > 1 && less(k / 2, k)) {
      exch(k, k / 2);
      k = k / 2;
    }
  }

  /*
  The idea is to compare k with max(2 * k, 2 * k + 1), and swap is k < max(2 * k , 2 * k + 1)
   */
  private void sink(int k) {
    while (2 * k <= n) {
      int j = 2 * k;
      if (j < n && less(j, j + 1)) j++;
      if (!less(k, j)) break;
      exch(k, j);
      k = j;
    }
  }

  private boolean less(int i, int j) {
    if (comparator == null) {
      return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
    } else {
      return comparator.compare(pq[i], pq[j]) < 0;
    }
  }

  private void exch(int i, int j) {
    Key swap = pq[i];
    pq[i] = pq[j];
    pq[j] = swap;
  }

  // is pq[1..n] a max heap?
  private boolean isMaxHeap() {
    for (int i = 1; i <= n; i++) {
      if (pq[i] == null) return false;
    }
    for (int i = n + 1; i < pq.length; i++) {
      if (pq[i] != null) return false;
    }
    if (pq[0] != null) return false;

    return isMaxHeapOrdered(1);
  }

  // is subtree of pq[1..n] rooted at k a max heap?
  private boolean isMaxHeapOrdered(int k) {
    if (k > n) return true;
    int left = 2 * k;
    int right = 2 * k + 1;
    if (left <= n && less(k, left)) return false;
    if (right <= n && less(k, right)) return false;
    return isMaxHeapOrdered(left) && isMaxHeapOrdered(right);
  }

  private void resize(int capacity) {
    assert capacity > n;
    Key[] temp = (Key[]) new Object[capacity];
    for (int i = 1; i <= n; i++) {
      temp[i] = pq[i];
    }
    pq = temp;
  }

  // Iterator
  /**
   * Returns an iterator that iterates over the keys on this priority queue in descending order. The
   * iterator doesn't implement {@code remove()} since it's optional.
   *
   * @return an iterator that iterates over the keys in descending order
   */
  @Override
  public Iterator<Key> iterator() {
    return new HeapIterator();
  }

  private class HeapIterator implements Iterator<Key> {

    // create a new pq
    private MaxPQ<Key> copy;

    // add all items to copy of heap
    // takes linear time since already in heap order so no keys move
    public HeapIterator() {
      if (comparator == null) copy = new MaxPQ<Key>(size());
      else copy = new MaxPQ<Key>(size(), comparator);
      for (int i = 1; i <= n; i++) copy.insert(pq[i]);
    }

    public boolean hasNext() {
      return !copy.isEmpty();
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Key next() {
      if (!hasNext()) throw new NoSuchElementException();
      return copy.delMax();
    }
  }

  public static void main(String[] args) {
    MaxPQ<String> pq = new MaxPQ<>(10);
    pq.insert("this");
    pq.insert("is");
    pq.insert("a");
    pq.insert("test");
    while (!pq.isEmpty()) {
      System.out.println(pq.delMax());
    }
  }
}
