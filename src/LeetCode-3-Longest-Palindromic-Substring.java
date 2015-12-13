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
public class Solution {
    
    // 1.Naive Approach
    // public String longestPalindrome(String s) {
    //     String result = "";
    //     int maxLen = 0;
    //     if(s == null || s.length() <= 1) return s;
        
    //     int len = s.length();
        
    //     for(int right = 0; right < len; right++){
    //         for(int left = 0; left <= right; left++){
    //             String curr = s.substring(left, right);
    //             if(isPalindrome(curr) && curr.length() > maxLen){
    //                 maxLen = curr.length();
    //                 result = curr;
    //             }
    //         }
    //     }
        
    //     return result;
    // }
    
    // private boolean isPalindrome(String s){
    //     int start = 0, end = s.length() - 1;
    //     while(start < end){
    //         if(s.charAt(start) != s.charAt(end)) return false;
    //         start++;
    //         end--;
    //     }
    //     return true;
    // }
    
    // 2.Dynamic Programming
    // public String longestPalindrome(String s) {
    //     String result = "";
    //     if(s == null || s.length() <= 1) return s;
    //     int len = s.length();
    //     int maxLen = 0;
        
    //     // state matrix
    //     int[][] state = new int[len][len];
        
    //     // calculate state matrix
    //     // if length == 1
    //     for(int i = 0; i < len; i++) state[i][i] = 1;
        
    //     // if length == 2
    //     for(int i = 0; i < len - 1; i++) if(s.charAt(i) == s.charAt(i + 1)) state[i][i + 1] = 1;
        
    //     for(int right = 0; right < len; right ++){
    //         for(int left = 0; left <= right; left++){
    //             if(s.charAt(left) == s.charAt(right)){
    //                 state[left][right] = 1;
    //                 int l = right - left + 1;
    //                 if(l > maxLen){
    //                     result = s.substring(left, right + 1);
    //                 }
    //             }else{
    //                 state[left][right] = 0;
    //             }
    //         }
    //     }
    //     return result;
    // }
    
    //3.
    public String longestPalindrome(String s) {
        if(s == null || s.length() <= 1) return s;
        int len = s.length();
        int maxLen = 0;
        String result = s.substring(0, 1);
        
        // get longest palindrome with center of i
        for(int i = 0; i < len; i++){
            String temp = getLongestStr(s, i, i);
            if(temp.length() >maxLen ){
                maxLen = temp.length();
                result = temp;
            }
        }
        
        // get longest palindrome with center of i and i+1
        for(int i = 0; i < len - 1; i++){
            String temp = getLongestStr(s, i, i + 1);
            if(temp.length() > maxLen){
                maxLen = temp.length();
                result = temp;
            }
        }
        return result;
    }
        
    private String getLongestStr(String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return s.substring(start + 1, end);     // must consider clearly why [start+1, end]
    }
}