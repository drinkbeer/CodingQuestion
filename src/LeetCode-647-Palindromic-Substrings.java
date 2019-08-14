class Solution {
    // 1. DP (2-dimension)
    /*
    Runtime: 7 ms, faster than 30.40% of Java online submissions for Palindromic Substrings.
    Memory Usage: 35.8 MB, less than 63.29% of Java online submissions for Palindromic Substrings.
    */
//     public int countSubstrings(String s) {
//         int len = s.length();
        
//         boolean[][] dp = new boolean[len][len];
//         int res = 0;
//         for (int j = 0; j < len; j++) {
//             for (int i = j; i >= 0; i--) {
//                 dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
//                 if (dp[i][j]) res++;
//             }
//         }
        
//         return res;
//     }
    
    // 2. DP (1-d Array)
    /*
    Runtime: 4 ms, faster than 47.16% of Java online submissions for Palindromic Substrings.
    Memory Usage: 34 MB, less than 100.00% of Java online submissions for Palindromic Substrings.
    */
    public int countSubstrings(String s) {
        int len = s.length();
        
        boolean[] dp = new boolean[len];
        int res = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = len - 1; j >= i; j--) {
                dp[j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[j - 1]);
                if (dp[j]) res++;
            }
        }
        
        return res;
    }
    
}
