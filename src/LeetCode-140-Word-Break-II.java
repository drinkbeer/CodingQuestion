// 1. Build Trie + DFS (TLE)
/*
Time:
    - Build Trie: O(M*N)    -   M is length of the words in wordDict, N is number of words in wordDict
    - Search in Trie: O(M)  -   M is the length of the words in wordDict

Space:
    - Trie Size: O(ALPHABET_SIZE * M * N)   -   M is length of the words in wordDict, N is number of words in wordDict

*/
// class Solution {
    
//     private class Node {
//         char c;
//         HashMap<Character, Node> children = new HashMap<>();
//         String word = null;
        
//         public Node(char c, HashMap<Character, Node> children) {
//             this.c = c;
//             this.children = children;
//         }
//     }
    
//     private class Trie {
//         Node root;
        
//         public Trie() {
//             root = new Node('#', new HashMap<>());
//         }
        
//         public void add(String str) {
//             Node curr = root;
            
//             for (char c : str.toCharArray()) {
//                 if (curr.children.containsKey(c)) {
//                     curr = curr.children.get(c);
//                 } else {
//                     Node newNode = new Node(c, new HashMap<>());
//                     curr.children.put(c, newNode);
//                     curr = newNode;
//                 }
//             }
            
//             curr.word = str;
//         }
        
//         public Node getRoot() {
//             return this.root;
//         }
//     }
    
//     public List<String> wordBreak(String s, List<String> wordDict) {
//         Trie trie = new Trie();
//         for (String str: wordDict) {
//             trie.add(str);
//         }
        
//         List<String> res = new ArrayList<>();
//         recursive(s, 0, trie.getRoot(), trie.getRoot(), res, "");
//         return res;
//     }
    
//     private void recursive(String s, int start, Node root, Node prev, List<String> res, String currStr) {
//         // end condition
//         if (start >= s.length() || !prev.children.containsKey(s.charAt(start))) {
//             return;
//         }
        
//         Node curr = prev.children.get(s.charAt(start));
        
//         if (curr.word != null) {
//             String newStr = currStr + curr.word + " ";
//             if (start == s.length() - 1) {
//                 // we reached the end of the string, and we need check out the result, and stop the recursive
//                 res.add(newStr.trim());
//                 return;
//             }
            
//             // if it's not the end of the s, we should continue searching new word from root
//             recursive(s, start + 1, root, root, res, newStr);
//         }
        
//         // continue searching from curr node to check if there is a longer word 
//         recursive(s, start + 1, root, curr, res, currStr);
//     }
// }

// Trie + Memorized DFS 
class Solution {
    
    private class Node {
        char c;
        HashMap<Character, Node> children = new HashMap<>();
        String word = null;
        
        public Node(char c, HashMap<Character, Node> children) {
            this.c = c;
            this.children = children;
        }
    }
    
    private class Trie {
        Node root;
        
        public Trie() {
            root = new Node('#', new HashMap<>());
        }
        
        public void add(String str) {
            Node curr = root;
            for (char c : str.toCharArray()) {
                if (curr.children.containsKey(c)) {
                    curr = curr.children.get(c);
                } else {
                    Node newNode = new Node(c, new HashMap<>());
                    curr.children.put(c, newNode);
                    curr = newNode;
                }
            }
            curr.word = str;
        }
        
        public Node getRoot() {
            return this.root;
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        for (String str: wordDict) {
            trie.add(str);
        }
        
        HashMap<String, List<String>> map = new HashMap<>();
        map.put("", new ArrayList<>(Arrays.asList(""))); // init the enpty string with a list of enpty string
        recursive(s, trie.getRoot(), map);
        return map.get(s);
    }
    
    private void recursive(String s, Node root, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) return;
        
        List<String> res = new ArrayList<>();
        
        Node curr = root;
        for (char c : s.toCharArray()) {
            if (!curr.children.containsKey(c)) break;
            
            curr = curr.children.get(c);
            if (curr.word != null) {
                String next = s.substring(curr.word.length());
                // System.out.println("s: " + s + "  curr.word: " + curr.word + "  next: " + next + "  map: " + map.toString());
                recursive(next, root, map);
                
                for (String sub : map.get(next)) {
                    res.add(curr.word + (sub.length() == 0 ? "" : " " + sub));
                }
            }
        }
        
        map.put(s, res);
    }
}



// 2. Memorized DFS
/*
https://leetcode.com/problems/word-break-ii/discuss/44167/My-concise-JAVA-solution-based-on-memorized-DFS

Time: O(N ^ (S / M))   -   M is length of words in wordDict, N is number of words in wordDict, S is length of s string.
Worst Time: O(2^N)


Space: 


In the worst case the runtime of this algorithm is O(2^n).

Consider the input "aaaaaa", with wordDict = ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaa"]. Every possible partition is a valid sentence, and there are 2^n-1 such partitions. It should be clear that the algorithm cannot do better than this since it generates all valid sentences. The cost of iterating over cached results will be exponential, as every possible partition will be cached, resulting in the same runtime as regular backtracking. Likewise, the space complexity will also be O(2^n) for the same reason - every partition is stored in memory.

Where this algorithm improves on regular backtracking is in a case like this: "aaaaab", with wordDict = ["a", "aa", "aaa", "aaaa", "aaaaa", "aaaaa"], i.e. the worst case scenario for Word Break I, where no partition is valid due to the last letter 'b'. In this case there are no cached results, and the runtime improves from O(2^n) to O(n^2).
*/
// class Solution {
    
//     public List<String> wordBreak(String s, List<String> wordDict) {
//         return recursive(s, wordDict, new HashMap<>());
//     }
    
//     private List<String> recursive(String s, List<String> wordDict, HashMap<String, List<String>> map) {
//         if (map.containsKey(s)) {
//             return map.get(s);
//         }
        
//         List<String> res = new ArrayList<>();
//         for (String str : wordDict) {
//             if (s.startsWith(str)) {
//                 String next = s.substring(str.length());
                
//                 if (next.length() == 0) {
//                     res.add(str);
//                 } else {
//                     for (String sub : recursive(next, wordDict, map)) {
//                         res.add(str + " " + sub);
//                     }
//                 }
                
//             }
//         }
//         map.put(s, res);
//         return res;
//     }
// }
