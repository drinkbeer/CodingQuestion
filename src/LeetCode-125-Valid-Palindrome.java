/*
LeetCode: https://leetcode.com/problems/valid-palindrome/
LintCode: http://www.lintcode.com/problem/valid-palindrome/
JiuZhang: http://www.jiuzhang.com/solutions/valid-palindrome/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/

Analysis: 


*/
public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        
        // \s is whitespace in regex, and we need \\ to express \ 
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        
        int lo = 0;
        int hi = s.length() - 1;
        
        while(lo < hi){
            if(s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }
        return true;
    }
}