/*
https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
*/
class Solution {
    
    // 1. Trie + DFS
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
