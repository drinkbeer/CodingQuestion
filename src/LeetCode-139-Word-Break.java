/*
LeetCode: https://leetcode.com/problems/word-break/
LintCode: http://www.lintcode.com/problem/word-break/
JiuZhang: http://www.jiuzhang.com/solutions/word-break/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-solution-word-break/

Analysis: 
1.DFS
Time Limit Exceed
Time O(N^2*wordDict Size) ???

2.DP
Time O(N*dict size)
*/
public class Solution {
    
    // 2.DP
    public boolean wordBreak(String s, Set<String> wordDict) {
        // state
        boolean[] state = new boolean[s.length() + 1];
        state[0] = true;    //why initialized true? state[0] has function of dummy node in List problem
        
        // canculate state
        for(int i = 0; i <= s.length(); i++){
            if(!state[i]) continue;  //if start char is not true, don't need to continue calculating
            
            for(String word : wordDict){
                int len = word.length();
                int end = i + len;  //notice, i is start, end is the next char index of next word
                if(end > s.length()) continue;
                
                if(state[end]) continue;    //optimize: if has already true, we don't need to calculate
                
                if(s.substring(i, end).equals(word)){
                    state[end] = true;
                }
            }
        }
        
        return state[s.length()];
    }
    
    // 1.DFS
    // Time Limit Exceed
// 	public boolean wordBreak(String s, Set<String> wordDict) {
// 		return wordBreak(s, wordDict, 0);
// 	}
	
// 	private boolean wordBreak(String s, Set<String> wordDict, int start){
// 		// end condition
// 		if(start == s.length()) return true;
		
// 		for(int i = start; i < s.length(); i++){
			
// 			for(String str : wordDict){
// 				int end = i + str.length();     //Corner case: think carefully the end
				
// 				if(end > s.length()) continue;
				
// 				if(s.substring(i, end).equals(str)){
// 					if(wordBreak(s, wordDict, end)) return true;
// 				}
// 			}
// 		}
// 		return false;
// 	}
    
}



// // 1. Build Trie + DFS
// class Solution {
    
//     private class Node {
//         char c;
//         HashMap<Character, Node> children = new HashMap<>();
//         String word = null;
        
//         public Node (char c) {
//             this.c = c;
//         }
//     }
    
//     private class Trie {
//         Node root;
//         public Trie () {
//             root = new Node('#');
//         }
        
//         public void add(String s) {
//             Node curr = root;
//             for (char c : s.toCharArray()) {
//                 if (curr.children.containsKey(c)) {
//                     curr = curr.children.get(c);
//                 } else {
//                     Node newNode = new Node(c);
//                     curr.children.put(c, newNode);
//                     curr = newNode;
//                 }
//             }
//             curr.word = s;
//         }
        
//         public Node getRoot() {
//             return root;
//         }
//     }
    
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Trie trie = new Trie();
//         for (String str : wordDict) {
//             trie.add(str);
//         }
        
//         return recursive(s, trie.getRoot());
//     }
    
//     private boolean recursive(String s, Node root) {
//         if (s.length() == 0) return true;
        
//         Node curr = root;
//         for (char c : s.toCharArray()) {
//             if (!curr.children.containsKey(c)) return false;
            
//             curr = curr.children.get(c);
//             if (curr.word != null) {
//                 if (recursive(s.substring(curr.word.length()), root)){
//                     return true;
//                 }
//             }
//         }
        
//         return false;
//     }
// }


// 2. Build Trie + Memorized DFS
/*
https://leetcode.com/problems/word-break/discuss/181632/Java-Solution-%3A-Trie-%2B-memoization
*/
// class Solution {
    
//     private class Node {
//         char c;
//         HashMap<Character, Node> children = new HashMap<>();
//         String word = null;
        
//         public Node (char c) {
//             this.c = c;
//         }
//     }
    
//     private class Trie {
//         Node root;
//         public Trie () {
//             root = new Node('#');
//         }
        
//         public void add(String s) {
//             Node curr = root;
//             for (char c : s.toCharArray()) {
//                 if (curr.children.containsKey(c)) {
//                     curr = curr.children.get(c);
//                 } else {
//                     Node newNode = new Node(c);
//                     curr.children.put(c, newNode);
//                     curr = newNode;
//                 }
//             }
//             curr.word = s;
//         }
        
//         public Node getRoot() {
//             return root;
//         }
//     }
    
//     public boolean wordBreak(String s, List<String> wordDict) {
//         Trie trie = new Trie();
//         for (String str : wordDict) {
//             trie.add(str);
//         }
        
//         HashMap<String, Boolean> map = new HashMap<>();
//         map.put("", true);
//         return recursive(s, trie.getRoot(), map);
//     }
    
//     private boolean recursive(String s, Node root, HashMap<String, Boolean> map) {
//         if (map.containsKey(s)) return map.get(s);
        
//         Node curr = root;
//         for (char c : s.toCharArray()) {
//             if (!curr.children.containsKey(c)) return false;
            
//             curr = curr.children.get(c);
//             if (curr.word != null) {
//                 String next = s.substring(curr.word.length());
//                 if (recursive(next, root, map)) {
//                     map.put(next, true);
//                     return true;
//                 } else {
//                     map.put(next, false);
//                 }
//             }
//         }
        
//         return false;
//     }
// }


// 3. DP (pull)
/*
subproblem:
dp[i]   - if the s.substring(0, i + 1) could be break into words in wordDict

recurrence relation:
dp[i] |= dp[i - w.length()], w belongs to wordDict

init:
dp[0] = true;   // empty string

ans:
dp[n]
*/
// class Solution {
    
//     public boolean wordBreak(String s, List<String> wordDict) {
//         int n = s.length();
        
//         // subproblem
//         boolean[] dp = new boolean[n + 1];
        
//         // init
//         dp[0] = true;
        
//         // recurrence relation
//         for (int i = 1; i <= n; i++) {
//             for (String w : wordDict) {
//                 if (i < w.length()) continue;
//                 if (w.equals(s.substring(i - w.length(), i))) {
//                     if (dp[i - w.length()]) {
//                         dp[i] = true;
//                         continue;
//                     }
//                 }
//             }
//         }
        
//         // ans
//         return dp[n];
//     }
    
    
// }



// 4. DP (push)
/*
subproblem:
dp[i]   - if the s.substring(0, i + 1) could be break into words in wordDict

recurrence relation:
dp[i] |= dp[i - w.length()], w belongs to wordDict

init:
dp[0] = true;   // empty string

ans:
dp[n]
*/
class Solution {
    
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        
        // subproblem
        boolean[] dp = new boolean[n + 1];
        
        // init
        dp[0] = true;
        
        // recurrence relation
        for (int i = 0; i <= n; i++) {
            for (String w : wordDict) {
                if (dp[i] == false) continue;
                if (i + w.length() > n) continue;
                
                if (w.equals(s.substring(i, i + w.length()))) {
                    dp[i + w.length()] = true;
                    if (i + w.length() == n) return true;
                }
                
            }
        }
        
        // ans
        return dp[n];
    }
}
