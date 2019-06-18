https://www.geeksforgeeks.org/trie-insert-and-search/
https://leetcode.com/problems/implement-trie-prefix-tree/

#### Implement Trie (prefix tree)

Trie is an efficient information re**Trie**val data structure. Using Trie, search complexities can be brought to optimal limit (key length). If we store keys in binary search tree, a well balanced BST will need time proportional to **M * log N**, where M is maximum string length and N is number of keys in tree. Using Trie, we can search the key in **O(M)** time. However the penalty is on Trie storage requirements.

Insert and search costs **O(M)** where M is the key length, however the memory requirements of Trie is **O(ALPHABET_SIZE * M * N)** where N is number of keys in Trie. There are efficient representation of trie nodes (e.g. compressed trie, ternary search tree, etc.) to minimize memory requirements of trie.



Example of trie:
```
                       root
                    /   \    \
                    t   a     b
                    |   |     |
                    h   n     y
                    |   |  \  |
                    e   s  y  e
                 /  |   |
                 i  r   w
                 |  |   |
                 r  e   e
                        |
                        r
```

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

#### DFS
```
    private void dfsUsingStack(TrieNode root) {
        Stack<TrieNode> stack = new Stack<>();
        stack.push(root);

        String longestStr = "";
        while(!stack.isEmpty()) {
            TrieNode curr = stack.pop();

            // do the operation to the curr here

            for (TrieNode n : curr.children.values()) {

                // filter out the nodes that we don't want to proceed in next level here

                stack.push(n);
            }
        }
    }

    private void dfsUsingRecall(TrieNode curr) {
        // end condition
        if (curr.isLeaf) return;

        // do the operation to the curr here

        for (TrieNode n : curr.children.values()) {

            // filter out the nodes that we don't want to proceed in next level here

            dfsUsingRecall(n);
        }
    }
```