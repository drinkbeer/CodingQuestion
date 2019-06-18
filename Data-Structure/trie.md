https://www.geeksforgeeks.org/trie-insert-and-search/

#### Implement Trie (prefix tree)

```
private class TrieNode {
    char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isLeaf;

    // Initialize your data structure here.
    public TrieNode() {}

    public TrieNode(char c) {
        this.c = c;
    }
}
```

```
class Trie {

    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();   // root is an empty TrieNode
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        HashMap<Character, TrieNode> children = curr.children;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (children.containsKey(ch)) {
                // ch exists, get the exist ch node, and prepare to search next char in exist ch node's chidlren
                curr = children.get(ch);
                children = curr.children;
            } else {
                TrieNode newNode = new TrieNode(ch);
                children.put(ch, newNode);
                curr = newNode;
                children = curr.children;
            }
            
            // set the last node's isLeaf to true
            if (i == word.length() - 1) curr.isLeaf = true;
        }
    }
    
    /** Returns if the word is in the trie. */
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
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
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
}
```
