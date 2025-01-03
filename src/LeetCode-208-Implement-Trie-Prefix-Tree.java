// 1. Trie with a TrieNode
class Trie {
    private TrieNode root;
    
    private class TrieNode {
        char ch;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isLeaf = false;
        
        public TrieNode() {
            
        }
        
        public TrieNode(char ch) {
            this.ch = ch;
        }
    }

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        HashMap<Character, TrieNode> children = curr.children;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (children.containsKey(ch)) {
                curr = children.get(ch);
                children = curr.children;
            } else {
                TrieNode newNode = new TrieNode(ch);
                children.put(ch, newNode);
                curr = newNode;
                children = curr.children;
            }
            
            if (i == word.length() - 1) {
                curr.isLeaf = true;
            }
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

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
