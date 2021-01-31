

### 5. Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/

```
    // DP (2D array)
    /*
    
    https://leetcode.com/problems/longest-palindromic-substring/discuss/2921/Share-my-Java-solution-using-dynamic-programming
    
    
    subproblem:
    dp[i][j]    -   whether the substring [i, j] is palindromic string or not
    
    recurrence relation
    assume dp[0, i - 1][0, len] is optimized result
    dp[i][j] = true if char(i) == char(j) && dp[i + 1][j - 1] == true
    
    init:
    dp[0][0] = true // only one first char is a palindrome
    
    ans:
    longest (j - i + 1)
    
    because [i, j] depends on [i + 1, j - 1], so we should loop i from n - 1 to 0
    
    Runtime: 30 ms, faster than 47.95% of Java online submissions for Longest Palindromic Substring.
    Memory Usage: 38 MB, less than 54.30% of Java online submissions for Longest Palindromic Substring.
    */
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;
        
        // subproblem
        boolean[][] dp = new boolean[n][n];
        
        // init
        dp[0][0] = true;
        
        // recurrence relation
        int start = 0, maxLen = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && maxLen < j - i + 1) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        
        return s.substring(start, start + maxLen);
    }
    
    // DP (1D array) (best DP solution)
    /*
    Optimization: substring() is costy. It's better to record start index and length, and do one substring finally.
    */
    public String longestPalindrome(String s) {
        int n = s.length();
        if(n <= 1) return s;
        
        // subproblem
        boolean[] dp = new boolean[n];
        
        // init
        dp[0] = true;
        
        // recurrence relation
        int start = 0, maxLen = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= i; j--) {
                dp[j] = s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[j - 1]);
                if (dp[j] && maxLen < j - i + 1) {
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        
        return s.substring(start, start + maxLen);
    }
```

### 10. Regular Expression Matching
https://leetcode.com/problems/regular-expression-matching/

```
public boolean isMatch(String s, String p) {
        // subproblem
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // init
        dp[0][0] = true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                dp[0][j + 1] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != s.charAt(i)) {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i + 1][j - 1] || dp[i][j + 1]);
                    }
                }
            }
        }

        return dp[s.length()][p.length()];
    }
```

### 44. Wildcard Matching
https://leetcode.com/problems/wildcard-matching/

```
// Similar to: https://leetcode.com/problems/regular-expression-matching/
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];

        // init
        dp[0][0] = true;
        for (int i = 0; i < s.length(); i++) {
            dp[i + 1][0] = false;
        }
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*') {
                dp[0][j + 1] = true;
            } else {
                break;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }

                if (p.charAt(j) == '*') {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j];
                }
            }
        }

        return dp[s.length()][p.length()];
    }
```
