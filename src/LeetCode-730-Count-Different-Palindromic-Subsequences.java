class Solution {
    // 1. DP
    /*
    https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/109507/Java-96ms-DP-Solution-with-Detailed-Explanation
    https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/259568/Java-Simple-Code-just-rewrite-from-a-very-good-solution
    https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/112757/Java-solution-using-simple-DP.-O(n2)-run-time-and-O(n2)-space
    
    
    */
    public int countPalindromicSubsequences(String S) {
        long kMod = 1000000007;
        int n = S.length();
        int[][] dp = new int[n][n];
        
        // All single letters are palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        
        for (int len = 1; len < n; ++len) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                if (S.charAt(i) == S.charAt(j)) {
                    //eg :  aba, 'b' = 1. Contribution of 'b' in  'abc' are 'b', 'aba' so (contribution of 'b') * 2
                    dp[i][j] = dp[i + 1][j - 1] * 2;    
                    
                    // find the occurance of extreme characters with in the substring (excluding the extreme characters)
                    int l = i + 1;
                    int r = j - 1;
                    char ch = S.charAt(i);
                    while (l <= r && S.charAt(l) != ch) l++;
                    while (l <= r && S.charAt(r) != ch) r--;
                    
                    if (l == r) {
                        // if there is no occurrence then we need to add max possible unique palindrome count of 1 character, which is 
                        dp[i][j] += 1;
                    } else if (l > r) {
                        // if there is no occurrence then we need to add max possible unique palindrome count of 2 characters, which is 2
                        // e.g. 'a', 'a' can form 'a' and 'aa'
                        dp[i][j] += 2;
                    }
                    else {
                        // if there are two occurence then we need to remove the repetitive palindromes.
                        dp[i][j] -= dp[l + 1][r - 1];
                    }
                } else {
                    // Just preserve the max count so far.
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1]; 
                }
                
                // this is the modulus logic to prevent overflow.
                dp[i][j] = (int) ((dp[i][j] + kMod) % kMod);
            }
        }
        
        return dp[0][n - 1];
    }
    
    // 2. DFS + Memorization
    /*
    https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/109509/Accepted-Java-Solution-using-memoization
    */
}
