/*
LeetCode: https://leetcode.com/problems/valid-palindrome/
LintCode: http://www.lintcode.com/problem/valid-palindrome/
JiuZhang: http://www.jiuzhang.com/solutions/valid-palindrome/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-valid-palindrome-java/

Analysis: 


*/
public class Solution {
    // 1. Two Pointers
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
    
    // 2. Two Pointers
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            if (!Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
            } else if (!Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
            } else {
                if (Character.toLowerCase(s.charAt(lo)) != Character.toLowerCase(s.charAt(hi))) return false;
                lo++;
                hi--;
            }
        }
        
        return true;
    }
    
    // Another Two Pointers
    public boolean isPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            while(lo < hi && !isValid(s.charAt(lo))) lo++;
            while(lo < hi && !isValid(s.charAt(hi))) hi--;
            
            if (lo < hi) {
                if (!isPalindrome(s.charAt(lo), s.charAt(hi))) return false;
            }
            
            lo++;
            hi--;
        }
        return true;
    }
    
    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
    
    private boolean isPalindrome(char c1, char c2) {
        return Character.toLowerCase(c1) == Character.toLowerCase(c2);
    }
    
    // 3.Reverse and Compare
    // https://leetcode.com/problems/valid-palindrome/discuss/39981/My-three-line-java-solution
    // public boolean isPalindrome(String s) {
    //     String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    //     String rev = new StringBuffer(actual).reverse().toString();
    //     return actual.equals(rev);
    // }
    
    // 4.
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            
            while (lo < hi && !(s.charAt(lo) >= 'a' && s.charAt(lo) <= 'z') && !(s.charAt(lo) >= '0' && s.charAt(lo) <= '9')) {
                lo++;
            }
            
            while(lo < hi && !(s.charAt(hi) >= 'a' && s.charAt(hi) <= 'z') && !(s.charAt(hi) >= '0' && s.charAt(hi) <= '9')) {
                hi--;
            }
            
            System.out.println(lo + "  " + hi);
            if (s.charAt(lo) != s.charAt(hi)) return false;
            lo++;
            hi--;
        }
        
        return true;
    }
}
