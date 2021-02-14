/*
LeetCode: https://leetcode.com/problems/palindrome-partitioning/
LintCode: http://www.lintcode.com/problem/palindrome-partitioning/
JiuZhang: http://www.jiuzhang.com/solutions/palindrome-partitioning/
ProgramCreek: http://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/

Analysis: 
1.Pure DFS
Time: O(N*2^N)

2.DFS + DP
Time: O(2^N)
https://leetcode.com/problems/palindrome-partitioning/discuss/41982/Java-DP-%2B-DFS-solution

3. Pure DP
Time: O(2^N), in worst case, all chars are the same, so total 2^(N-1) combination, and every step copy the whole result set again, so the worst time complexity is O(2^N).
https://leetcode.com/problems/palindrome-partitioning/discuss/41974/My-Java-DP-only-solution-without-recursion.-O(n2)
*/
public class Solution {
    // 1.Pure DFS
//     public List<List<String>> partition(String s) {
//         List<List<String>> result = new ArrayList<List<String>>();
//         List<String> list = new ArrayList<String>();
        
//         if(s == null || s.length() == 0) return result;
        
//         DFS(s, 0, result, list);
//         return result;
//     }
    
//     private void DFS(String s, int start, List<List<String>> result, List<String> list){
//         // stop condition
//         if(start == s.length()){
//             result.add(new ArrayList<String>(list));
//             return;
//         }
        
//         for(int end = start; end < s.length(); end++){
//             if(isPalindrome(s, start, end)){
//                 list.add(s.substring(start, end + 1));
//                 DFS(s, end + 1, result, list);
//                 list.remove(list.size() - 1);
//             }
//         }
//     }
    
//     private boolean isPalindrome(String s, int lo, int hi) {
//         while (lo < hi) {
//             if (s.charAt(lo) != s.charAt(hi)) return false;
//             lo++;
//             hi--;
//         }
//         return true;
//     }
    
    // 2. DFS + DP (Memorized DFS)
//     public List<List<String>> partition(String s) {
//         List<List<String>> result = new ArrayList<List<String>>();
//         List<String> list = new ArrayList<String>();
//         boolean[][] dp = new boolean[s.length()][s.length()];
        
//         if(s == null || s.length() == 0) return result;
        
//         helper(s, 0, dp, result, list);
//         return result;
//     }
    
//     private void helper(String s, int start, boolean[][] dp, List<List<String>> result, List<String> list) {
//         if (start == s.length()) {
//             result.add(new ArrayList<>(list));
//             return;
//         }
        
//         for (int end = start; end < s.length(); end++) {
//             // "abca", start = 0, end = 3, so "a"=="a" -> ok
//             if (s.charAt(start) != s.charAt(end)) continue;
//             // "abca", start + 1 = 1, end - 1= 2, so "b"!="c" -> continue
//             if (start + 1 < end - 1 && !dp[start + 1][end - 1]) continue;
            
//             dp[start][end] = true;
//             list.add(s.substring(start, end + 1));
//             helper(s, end + 1, dp, result, list);
//             list.remove(list.size() - 1);
//         }
//     }
    
    // 3. Pure DP
    public List<List<String>> partition(String s) {
        if(s == null || s.length() == 0) return new ArrayList<>();
        
        int len = s.length();
        List<List<String>>[] result = new List[len + 1];    // dp results from 0 length to actual length
        result[0] = new ArrayList<>();
        result[0].add(new ArrayList<>());
        
        boolean[][] dp = new boolean[len][len];
        
        for (int r = 0; r < len; r++) {
            result[r + 1] = new ArrayList<>();
            
            for (int l = 0; l <= r; l++) {
                // First approach
//                 if (s.charAt(l) != s.charAt(r)) continue;
//                 if(l + 1 < r - 1 && !dp[l + 1][r - 1]) continue;
                
//                 dp[l][r] = true;
//                 String sSub = s.substring(l, r + 1);
//                 for(List<String> sub : result[l]) {
//                     List<String> temp = new ArrayList<>(sub);
//                     temp.add(sSub);
//                     result[r + 1].add(temp);
//                 }
                
                // Second approach
                if (s.charAt(l) != s.charAt(r)) continue;
                if(l + 1 < r - 1 && !dp[l + 1][r - 1]) continue;
                
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    String sSub = s.substring(l, r + 1);
                    for(List<String> sub : result[l]) {
                        List<String> temp = new ArrayList<>(sub);
                        temp.add(sSub);
                        result[r + 1].add(temp);
                    }
                }
            }
        }
        
        return result[len];
    }
    
}
