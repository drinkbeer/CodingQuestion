/*
Some Test Cases:

["abcd","dcba","lls","s","sssll"]
[[0,1],[1,0],[2,4],[3,2]]

["a",""]
[[0,1],[1,0]]

["aa","a"]
[[0,1],[1,0]]
*/
class Solution {
    // 1. Trie
    /*
    https://leetcode.com/problems/palindrome-pairs/discuss/79195/O(n-*-k2)-java-solution-with-Trie-structure
    
    Time: O(N*L^2), N is total number of words, L is average length of words
    */
//     private class Node {
//         char c;
//         HashMap<Character, Node> children = new HashMap<>();
//         Integer idx = null;
//         List<Integer> palindromeIdx = new ArrayList<>();
        
//         public Node(char c) {
//             this.c = c;
//         }
//     }
    
//     private class Trie {
//         Node root;
//         public Trie() {
//             this.root = new Node('@');
//         }
        
//         public void insert(String[] words, int i) {
//             Node curr = root;
//             for (int k = words[i].length() - 1; k >= 0; k--) {
//                 if (isPalindrome(words[i], 0, k)) {
//                     curr.palindromeIdx.add(i);
//                 }
                
//                 char c = words[i].charAt(k);
//                 if (curr.children.containsKey(c)) {
//                     curr = curr.children.get(c);
//                 } else {
//                     Node newNode = new Node(c);
//                     curr.children.put(c, newNode);
//                     curr = newNode;
//                 }
//             }
//             curr.idx = i;
//         }
        
//         public void search(String[] words, int i, List<List<Integer>> res) {
//             String s = words[i];
//             Node curr = root;
//             // Search part 1: words[i] length > trie path length.
//             for (int j = 0; j < s.length(); j++) {
//                 // We reached one end in the trie path, check if the trie path matches prefix in the the words[i], and if the suffix of words[i] is palindrome
//                 if (curr.idx != null && curr.idx != i && isPalindrome(s, j, s.length() - 1)) {
//                     res.add(Arrays.asList(i, curr.idx));
//                 }
//                 if (!curr.children.containsKey(s.charAt(j))) {
//                     return;
//                 }
//                 curr = curr.children.get(s.charAt(j));
//             }
            
//             // Search part 2: words[i] length == trie path length
//             if (curr.idx != null && curr.idx != i) {
//                 res.add(Arrays.asList(i, curr.idx));
//             }
            
//             // words[i] length <= trie path length
//             for (int idx : curr.palindromeIdx) {
//                 if (i == idx) continue;
//                 res.add(Arrays.asList(i, idx));
//             }
//         }
        
//         public Node getRoot() {
//             return root;
//         }
//     }
    
//     public List<List<Integer>> palindromePairs(String[] words) {
//         Trie trie = new Trie();
//         for (int i = 0; i < words.length; i++) {
//             trie.insert(words, i);
//         }
        
//         List<List<Integer>> res = new ArrayList<>();
//         for (int i = 0; i < words.length; i++) {
//             trie.search(words, i, res);
//         }
        
//         return res;
//     }
    
//     private boolean isPalindrome(String str, int i, int j) {
//         while (i < j) {
//             if (str.charAt(i) != str.charAt(j)) return false;
//             i++;
//             j--;
//         }
//         return true;
//     }
    
    // 2. HashMap
    /*
    https://leetcode.com/problems/palindrome-pairs/discuss/79217/Accepted-short-Java-solution-using-HashMap
    
    First, put all Strings and their indices in Map. <String, Integer>
    For each String W in the array, reverse it (call reversed String "RVS"). Then use 2 pointers l and r to iterate all possible substrings of RVS. Note that either l==0 or r ==RVS.length() because otherwise the substring will definitely fail to form a palindrome with W.
    example, "sssll" and "lls" can pair
    reverse "sssll" => "llsss"
    l == 0, r==0
    r++ to iterate all substrings:"l","ll","lls".
    We found a substring "lls" in the Map. So we need to make sure the rest of the String ---- "ss" must be palindrome by it self
    Luckily "ss" is a palindrome, so we add index of "lls"and "sssll" in to the result.


    */
    public List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < words.length; i++) map.put(words[i], i);
        
        List<List<Integer>> res = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            String s = new StringBuilder(words[i]).reverse().toString();
            int l = 0, r = 0, len = s.length();
            while (l <= r) {
                
                Integer j = map.get(s.substring(l, r));
                if (j != null && i != j) {
                    if (l == 0 && isPalindrome(s, r, len - 1)) {
                        res.add(Arrays.asList(j, i));   // here we put shorter string in front of longer string
                    } else if (r == len && isPalindrome(s, 0, l - 1)) {
                        // Here we have to put into "else if", as ["abcd","dcba"] could add to result twich when we don't have "else" before if
                        res.add(Arrays.asList(i, j));
                    }
                }
                
                if (r < len) {
                    r++;
                } else {
                    l++;
                }
            }
        }
        return res;
    }
    
    private boolean isPalindrome(String str, int i, int j) {
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
