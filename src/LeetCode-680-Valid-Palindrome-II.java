/*
https://www.1point3acres.com/bbs/thread-527856-1-1.html

*/
class Solution {
    public boolean validPalindrome(String s) {
        return isValid(s, 0, s.length() - 1, true);
    }
    
    private boolean isValid(String s, int lo, int hi, boolean flag) {
        if (lo >= hi) return true;
        
        if (s.charAt(lo) == s.charAt(hi)) {
            return isValid(s, lo + 1, hi - 1, flag);
        }
        
        if (!flag) return false;
        
        return isValid(s, lo, hi - 1, false) || isValid(s, lo + 1, hi, false);
    }
}
