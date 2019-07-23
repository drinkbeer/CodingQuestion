class Solution {
    // 1. DP (Pull)
    /*
    https://www.youtube.com/watch?v=_nCsPn7_OgI
    https://leetcode.com/problems/longest-palindromic-substring/
    
    subproblem:
    dp[i][j]    - the longest palindromic subsequence for substring [i, j]
    */
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        
        for (int i = 0; i <= len - 1; i++) {
            dp[i][i] = 1;
        }
        
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[0][len - 1];
    }
}
