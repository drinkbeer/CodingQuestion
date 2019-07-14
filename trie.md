https://www.geeksforgeeks.org/trie-insert-and-search/  
https://leetcode.com/tag/trie/  
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

#### 212. Word Search II
https://leetcode.com/problems/word-search-ii/

```
class Solution {
    
    private class Node {
        char c;
        HashMap<Character, Node> children;
        boolean isLeaf = false;
        
        public Node(char c) {
            this.c = c;
            children = new HashMap<>();
        }
    }
    
    private class Trie {
        
        Node root;
        public Trie() {
            root = new Node('#');
        }
        
        public void add(String str) {
            Node curr = root;
            for (char c : str.toCharArray()) {
                if (curr.children.containsKey(c)) {
                    curr = curr.children.get(c);
                } else {
                    Node n = new Node(c);
                    curr.children.put(c, n);
                    curr = n;
                }
            }
            curr.isLeaf = true;
        }
        
        public Node getRoot() {
            return root;
        }
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String str : words) {
            trie.add(str);
        }
        
        Node root = trie.getRoot();
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!root.children.containsKey(board[i][j])) continue;
                recursive(board, i, j, root, res, "");
            }
        }
        return res;
    }
    
    private void recursive(char[][] board, int i, int j, Node prev, List<String> res, String s) {
        // if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        char c = board[i][j];
        if (c == '.' || !prev.children.containsKey(c)) return;

        Node curr = prev.children.get(c);
        if (curr.isLeaf) {
            /*
            // must do dedup here:
            Input
            [["a","a"]]
            ["a"]
            Output
            ["a","a"]
            Expected
            ["a"]
            */
            res.add(s + c);
            curr.isLeaf = false;    // dedut: remove the words from Trie
            // return;      // don't return here, as it could continue the path in the Trie to get words.
        }
        
        board[i][j] = '.';

        if (i > 0) recursive(board, i - 1, j, curr, res, s + c);
        if (i < board.length - 1) recursive(board, i + 1, j, curr, res, s + c);
        if (j > 0) recursive(board, i, j - 1, curr, res, s + c);
        if (j < board[0].length - 1) recursive(board, i, j + 1, curr, res, s + c);

        board[i][j] = c;
    }

}
```
