/*
LeetCode: https://leetcode.com/problems/palindrome-number/
LintCode: http://www.lintcode.com/problem/palindrome-number/
JiuZhang: http://www.jiuzhang.com/solutions/palindrome-number/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-palindrome-number-java/
*/
public class Solution {
    // public boolean isPalindrome(int x) {
    //     if(x < 0) return false;
        
    //     int div = 1;
    //     while(x / div >= 10){
    //         div *= 10;
    //     }
        
    //     while(x != 0){          // Note: must consider clearly why x!=0 is OK, why x<=10 is wrong
    //         int left = x / div;
    //         int right = x % 10;
            
    //         if(left != right) return false;
            
    //         x = (x % div) / 10;
    //         div /= 100;
    //     }
        
    //     return true;
    // }
    
    
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        return x == reverse(x);
    }
    
    private int reverse(int x){
        int result = 0;
        
        while(x > 0){
            result = 10 * result + x % 10;
            x = x / 10;
        }
        
        return result;
    }
}