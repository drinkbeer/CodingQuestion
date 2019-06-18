class Solution {
    
    // 1.Trie and DFS
    /*
    https://leetcode.com/problems/longest-word-in-dictionary/discuss/297614/Java-Code-%2B-Whiteboard-Youtube-Video-Explanation-accepted
    
    https://leetcode.com/problems/longest-word-in-dictionary/discuss/312468/4ms-Java-Trie-implementation-that-beats-100
    
    */
    private class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        int index = -1;
        
        public TrieNode() {}
        
        public TrieNode(char c) {
            this.c = c;
        }
    }
    
    private class Trie {
        
        TrieNode root;
        
        public Trie() {
            this.root = new TrieNode();
        }
        
        public void insert(String word, int index) {
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
                
                if (i == word.length() - 1) curr.index = index;
            }
        }
        
        private TrieNode getRoot() {
            return root;
        }
    }
    
    // first approach of DFS. Using a stasck.
//     private String dfs(TrieNode root, String[] words) {
//         Stack<TrieNode> stack = new Stack<>();
//         stack.push(root);
        
//         String longestStr = "";
//         while(!stack.isEmpty()) {
//             TrieNode curr = stack.pop();
//             /*
//             One key point here is: if the curr.index < 0, we will not update the longestStr.
//             */
//             if (curr.index >= 0) {
//                 // curr node is the end of a word path
//                 String currWord = words[curr.index];
//                 if (currWord.length() > longestStr.length() || (currWord.length() == longestStr.length() && currWord.compareTo(longestStr) < 0)) longestStr = currWord;
//             }


//             for (TrieNode n : curr.children.values()) {
//                 if (n.index < 0) continue;      // skip those which path has index < 0
//                 stack.push(n);
//             }
//         }
        
//         return longestStr;
//     }
    
    // second approach to DFS. Recall the method.
     private String dfs(TrieNode root, TrieNode curr, String[] words, String longestWord) {
         
         if (curr.index >= 0) {
             String currWord = words[curr.index];
            if (currWord.length() > longestWord.length() || (currWord.length() == longestWord.length() && currWord.compareTo(longestWord) < 0)) longestWord = currWord;
         }
         
         for (TrieNode n : curr.children.values()) {
             if (n.index < 0) continue;
             String currWord = dfs(root, n, words, longestWord);
             if (currWord.length() > longestWord.length() || (currWord.length() == longestWord.length() && currWord.compareTo(longestWord) < 0)) longestWord = currWord;
         }
         
         return longestWord;
     }
    
    public String longestWord(String[] words) {
        // build a Trie
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) trie.insert(words[i], i);
        
        // return dfs(trie.getRoot(), words);
        return dfs(trie.getRoot(), trie.getRoot(), words, "");
    }
    
    // 2. Sort and valid
//     public String longestWord(String[] words) {
//         Arrays.sort(words);
//         Set<String> validWords = new HashSet<>();
//         String res = "";
//         validWords.add("");     // for those only one character
        
//         for (String s : words) {
//             String prefix = s.substring(0, s.length() - 1);  // remove the last character
//             if (validWords.contains(prefix)) {
//                 validWords.add(s);
//                 if (res.length() < s.length()) res = s;
//             }
//         }
        
//         return res;
//     }
}
