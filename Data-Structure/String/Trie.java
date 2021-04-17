package String;

import java.util.HashMap;

public class Trie {
  private TrieNode root;

  private class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;

    public TrieNode() {}

    public TrieNode(char c) {
      this.c = c;
    }
  }

  public Trie() {
    this.root = new TrieNode();
  }

  public void insert(String word) {
    TrieNode curr = root;
    HashMap<Character, TrieNode> children = curr.children;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (children.containsKey(ch)) {
        // ch exists, get the exist ch node, and prepare to search next char in exist ch node's
        // children
        curr = children.get(ch);
        children = curr.children;
      } else {
        TrieNode newNode = new TrieNode(ch);
        children.put(ch, newNode);
        curr = newNode;
        children = curr.children;
      }

      if (i == word.length() - 1) curr.isLeaf = true;
    }
  }

  public boolean search(String word) {
    TrieNode curr = root;
    HashMap<Character, TrieNode> children = curr.children;

    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      if (children.containsKey(ch)) {
        curr = children.get(ch);
        children = curr.children;
      } else {
        return false;
      }
    }

    return curr.isLeaf;
  }

  public boolean startsWith(String prefix) {
    TrieNode curr = root;
    HashMap<Character, TrieNode> children = curr.children;

    for (int i = 0; i < prefix.length(); i++) {
      char ch = prefix.charAt(i);
      if (children.containsKey(ch)) {
        curr = children.get(ch);
        children = curr.children;
      } else {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("their");
    trie.insert("there");
    trie.insert("answer");
    trie.insert("any");
    trie.insert("bye");

    System.out.println("their exists: " + trie.search("their"));
    System.out.println("theirs exist: " + trie.search("theirs"));
    System.out.println("the prefix: " + trie.startsWith("the"));
  }
}
