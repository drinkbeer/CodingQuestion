/*
LeetCode: https://leetcode.com/problems/longest-palindromic-substring/
LintCode: http://www.lintcode.com/problem/longest-palindromic-substring/
JiuZhang: http://www.jiuzhang.com/solutions/longest-palindromic-substring/
ProgramCreek: http://www.programcreek.com/2013/12/leetcode-solution-of-longest-palindromic-substring-java/

1.Naive Approach: loops to get each substring
Time Complexity: O(n^3)
Time Limit Exceeded

2.Dynamic Programming
Time Complexity: O(n^2)
Time Limit Exceeded

3.From center to expand to get palindrome
Time Complexity: O(n^2)
Space Complexity: O(1)
*/
class Solution {
    // 1. Native solution
//     public String longestPalindrome(String s) {
//         int max = Integer.MIN_VALUE;
//         String result = "";
//         for (int i = 0; i < s.length(); i++) {
//             for (int j = i + 1; j <= s.length(); j++) {
//                 if (isPalindromic(s, i, j - 1)) {
//                     if (max < j - i) {
//                         max = j - i;
//                         result = s.substring(i, j);
//                     }
//                 }
//             }
//         }
//         return result;
//     }
    
//     private boolean isPalindromic(String s, int lo, int hi) {
//         while (lo < hi) {
//             if (s.charAt(lo++) != s.charAt(hi--)) return false;
//         }
//         return true;
//     }
    
    // 2. Native solution
    /*
    Time Limit Exceeded
    
    */
//     public String longestPalindrome(String s) {
//         String result = "";
//         int maxLen = 0;
//         if(s == null || s.length() <= 1) return s;
        
//         int len = s.length();
        
//         // Here must be right "<=", as substring method in Java will excluse the right bound.
//         for(int right = 0; right <= len; right++){
//             for(int left = 0; left <= right; left++){
//                 String curr = s.substring(left, right);
//                 if(isPalindrome(curr) && curr.length() > maxLen){
//                     maxLen = curr.length();
//                     result = curr;
//                 }
//             }
//         }
        
//         return result;
//     }
    
//     private boolean isPalindrome(String s){
//         int start = 0, end = s.length() - 1;
//         while(start < end){
//             if(s.charAt(start) != s.charAt(end)) return false;
//             start++;
//             end--;
//         }
//         return true;
//     }
    
    // 3. Extend
//     public String longestPalindrome(String s) {
//         String result = "";
//         int max = 0;
//         if(s == null || s.length() <= 1) return s;
        
//         // sub string in odd length
//         for (int i = 0; i < s.length(); i++) {
//             String temp = getLongestStr(s, i, i);
//             if (temp.length() > max) {
//                 result = temp;
//                 max = temp.length();
//             }
//         }
        
//         for (int i = 0; i < s.length() - 1; i++) {
//             String temp = getLongestStr(s, i, i + 1);
//             if (temp.length() > max) {
//                 result = temp;
//                 max = temp.length();
//             }
//         }
        
//         return result;
//     }
    
//     private String getLongestStr(String s, int i, int j) {
//         String res = "";
//         while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
//             res = s.substring(i, j + 1);
//             i--;
//             j++;
//         }
//         return res;
//     }
    
    // extend
    // private int lo, maxLen;
//     public String longestPalindrome(String s) {
//         int len = s.length();
//         if (len < 2)
//             return s;

//         for (int i = 0; i < len-1; i++) {
//             extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
//             extendPalindrome(s, i, i+1); //assume even length.
//         }
//         return s.substring(lo, lo + maxLen);
//     }

//     private void extendPalindrome(String s, int j, int k) {
//         while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
//             j--;
//             k++;
//         }
//         if (maxLen < k - j - 1) {
//             lo = j + 1;
//             maxLen = k - j - 1;
//         }
//     }
    
    // DP (2D array)
    /*
    
    https://leetcode.com/problems/longest-palindromic-substring/discuss/2921/Share-my-Java-solution-using-dynamic-programming
    
    
    subproblem:
    dp[i][j]    -   whether char at i and char at j are equal, and s [i + 1, j - 1] is a palindrome
    
    recurrence relation
    assume dp[0, i - 1][0, len] is optimized result
    dp[i][j] = true if char(i) == char(j) && dp[i + 1][j - 1] == true
    
    init:
    dp[0][0] = true // only one first char is a palindrome
    
    ans:
    longest (j - i + 1)
    
    */
//     public String longestPalindrome(String s) {
//         int len = s.length();
//         if (len < 2) {
//             return s;
//         }
        
//         // subproblem
//         boolean[][] dp = new boolean[len][len];
        
//         // init
//         dp[0][0] = true;
        
//         // recurrence relation
//         int start = 0, maxLen = 0;
//         for (int i = len - 1; i >= 0; i--) {
//             for (int j = i; j < len; j++) {
                
//                 dp[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[i + 1][j - 1]);
                
//                 if (dp[i][j] && maxLen <= j - i + 1) {
//                     start = i;
//                     maxLen = j - i + 1;
//                 }
//             }
//         }
        
//         return s.substring(start, start + maxLen);
//     }
    
    // DP (1D array) (best DP solution)
    /**
    Optimization: substring() is costy. It's better to record start index and length, and do one substring finally.
    
    "abcba"
    j = 4
    - - - - T
    
    j = 3
    - - - T F
    
    j = 2
    _ _ T F F
    
    j = 1
    _ T F T F
    
    j = 0
    T F F F T   <-  the last "True" is the one with maximum length
    
    */
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;        
        boolean dp[] = new boolean[len];
        int start = 0;
        int maxLen = 0;
        
        for(int i = len - 1; i >= 0; i--){
            for(int j = len - 1; j >= i; j--){
            // for (int j = i; j < len; j++) {    // doesn't work, because the dp array records the [i + 1, j] palindomic information. If we scan j from i to len - 1, the information will be overwritten.
                dp[j] = (s.charAt(i) == s.charAt(j)) && (j - i < 3 || dp[j - 1]);
                
                if(dp[j] && maxLen <= j - i + 1){
                    start = i;
                    maxLen = j - i + 1;
                }
            }
        }
        return s.substring(start, start + maxLen); 
    }
}
