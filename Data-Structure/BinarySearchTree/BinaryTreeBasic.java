package BinarySearchTree;

import java.util.NoSuchElementException;

/** https://algs4.cs.princeton.edu/32bst/BST.java.html */
public class BinaryTreeBasic<Key extends Comparable<Key>, Value> {
  private Node root;

  private class Node {
    private Key key; // sorted by key
    private Value val; // associated data
    private Node left, right; // left and right subtrees
    private int size; // number of nodes in subtree

    public Node(Key key, Value val, int size) {
      this.key = key;
      this.val = val;
      this.size = size;
    }
  }

  public BinaryTreeBasic() {}

  public boolean isEmpty() {
    return size() == 0;
  }

  public int size() {
    return size(root);
  }

  public int size(Node x) {
    if (x == null) return 0;
    else return x.size;
  }

  public boolean contains(Key key) {
    if (key == null) throw new IllegalArgumentException("argument to contains() is null");
    return get(key) != null;
  }

  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node x, Key key) {
    if (key == null) throw new IllegalArgumentException("calls to get() with a null key");
    if (x == null) return null;
    int cmp = key.compareTo(x.key);
    if (cmp < 0) return get(x.left, key);
    else if (cmp > 0) return get(x.right, key);
    else return x.val;
  }

  public void put(Key key, Value val) {
    if (key == null) throw new IllegalArgumentException("calls to put() with a null key");
    if (val == null) {
      delete(key);
      return;
    }
    root = put(root, key, val);
    assert check();
  }

  private Node put(Node x, Key key, Value val) {
    if (x == null) return new Node(key, val, 1);
    int cmp = key.compareTo(x.key);
    if (cmp < 0) x.left = put(x.left, key, val);
    if (cmp > 0) x.right = put(x.right, key, val);
    else x.val = val;
    x.size = 1 + size(x.left) + size(x.right);
    return x;
  }

  public void deleteMin() {
    if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
    root = deleteMin(root);
    assert check();
  }

  private Node deleteMin(Node x) {
    if (x.left == null) return x.right;
    x.left = deleteMin(x.left);
    x.size = size(x.left) + size(x.right) + 1;
    return x;
  }

  public void deleteMax() {
    if (isEmpty()) throw new NoSuchElementException("Symbol table underflow");
    root = deleteMax(root);
    assert check();
  }

  private Node deleteMax(Node x) {
    if (x.right == null) return x.left;
    x.right = deleteMax(x.right);
    x.size = size(x.left) + size(x.right) + 1;
    return x;
  }

  public void delete(Key key) {
    if (key == null) throw new IllegalArgumentException("calls delete() with a null key");
    root = delete(root, key);
    assert check();
  }

  private Node delete(Node x, Key key) {
    if (x == null) return null;

    int cmp = key.compareTo(x.key);
    if (cmp < 0) x.left = delete(x.left, key);
    else if (cmp > 0) x.right = delete(x.right, key);
    else {
      if (x.right == null) return x.left;
      if (x.left == null) return x.right;
      Node t = x;
      x = min(t.right);
      x.right = deleteMin(t.right);
      x.left = t.left;
    }
    x.size = size(x.left) + size(x.right) + 1;
    return x;
  }

  public Key min() {
    if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
    return min(root).key;
  }

  private Node min(Node x) {
    if (x.left == null) return x;
    else return min(x.left);
  }

  public Key max() {
    if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
    return max(root).key;
  }

  private Node max(Node x) {
    if (x.right == null) return x;
    else return max(x.right);
  }

  /**
   * Returns the largest key in the symbol table less than or equal to {@code key}.
   *
   * @param key the key
   * @return the largest key in the symbol table less than or equal to {@code key}
   */
  public Key floor(Key key) {
    if (key == null) throw new IllegalArgumentException("argument to floor() is null");
    if (isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
    Node x = floor(root, key);
    if (x == null) throw new NoSuchElementException("argument to floor() is too small");
    else return x.key;
  }

  private Node floor(Node x, Key key) {
    if (x == null) return null;
    int cmp = key.compareTo(x.key);
    if (cmp == 0) return x;
    if (cmp < 0) return floor(x.left, key);
    Node t = floor(x.right, key);
    if (t != null) return t;
    else return x;
  }

  public Key floor2(Key key) {
    Key x = floor2(root, key, null);
    if (x == null) throw new NoSuchElementException("argument to floor() is too small");
    else return x;
  }

  private Key floor2(Node x, Key key, Key best) {
    if (x == null) return best;
    int cmp = key.compareTo(x.key);
    if (cmp < 0) return floor2(x.left, key, best);
    else if (cmp > 0) return floor2(x.right, key, x.key);
    else return x.key;
  }

  /**
   * Returns the smallest key in the symbol table greater than or equal to {@code key}.
   *
   * @param key the key
   * @return the smallest key in the symbol table greater than or equal to {@code key}
   */
  public Key ceiling(Key key) {
    if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
    if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
    Node x = ceiling(root, key);
    if (x == null) throw new NoSuchElementException("argument to floor() is too large");
    else return x.key;
  }

  private Node ceiling(Node x, Key key) {
    if (x == null) return null;
    int cmp = key.compareTo(x.key);
    if (cmp == 0) return x;
    if (cmp < 0) {
      Node t = ceiling(x.left, key);
      if (t != null) return t;
      else return x;
    }
    return ceiling(x.right, key);
  }

  /**
   * Return the key in the symbol table of a given {@code rank}. This key has the property that
   * there are {@code rank} keys in the symbol table that are smaller. In other words, this key is
   * the ({@code rank}+1)st smallest key in the symbol table.
   *
   * @param rank the order statistic
   * @return the key in the symbol table of given {@code rank}
   */
  public Key select(int rank) {
    if (rank < 0 || rank >= size()) {
      throw new IllegalArgumentException("argument to select() is invalid: " + rank);
    }
    return select(root, rank);
  }

  // Return key in BST rooted at x of given rank.
  // Precondition: rank is in legal range.
  private Key select(Node x, int rank) {
    if (x == null) return null;
    int leftSize = size(x.left);
    if (leftSize > rank) return select(x.left, rank);
    else if (leftSize < rank) return select(x.right, rank - leftSize - 1);
    else return x.key;
  }

  /**
   * Return the number of keys in the symbol table strictly less than {@code key}.
   *
   * @return the number of keys in the symbol table strictly less than {@code key}
   */
  public int rank(Key key) {
    if (key == null) throw new IllegalArgumentException("argument to rank() is null");
    return rank(key, root);
  }

  // Number of keys in the subtree less than key.
  private int rank(Key key, Node x) {
    if (x == null) return 0;
    int cmp = key.compareTo(x.key);
    if (cmp < 0) return rank(key, x.left);
    else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
    else return size(x.left);
  }

  ////////// Check integrity of BST data structure. //////////
  private boolean check() {
    // TODO
    return true;
  }

  // does this binary tree satisfy symmetric order?
  // Note: this test also ensures that data structure is a binary tree since order is strict
  private boolean isBST() {
    // TODO
    return true;
  }

  // is the tree rooted at x a BST with all keys strictly between min and max
  // (if min or max is null, treat as empty constraint)
  // Credit: Bob Dondero's elegant solution
  private boolean isBST(Node x, Key min, Key max) {
    // TODO
    return true;
  }

  // is the tree rooted at x a BST with all keys strictly between min and max
  // (if min or max is null, treat as empty constraint)
  // Credit: Bob Dondero's elegant solution
  private boolean isSizeConsistent() {
    return isSizeConsistent(root);
  }

  private boolean isSizeConsistent(Node x) {
    if (x == null) return true;
    if (x.size != size(x.left) + size(x.right) + 1) return false;
    return isSizeConsistent(x.left) && isSizeConsistent(x.right);
  }
}
