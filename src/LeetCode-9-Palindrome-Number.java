/*
LeetCode: https://leetcode.com/problems/palindrome-number/
LintCode: http://www.lintcode.com/problem/palindrome-number/
JiuZhang: http://www.jiuzhang.com/solutions/palindrome-number/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-palindrome-number-java/

Analysis: 
1.
Problems related with numbers are frequently solved by / and %. No need of extra space is required. This problem is similar with the Reverse Integer problem.

Note: no extra space here means do not convert the integer to string, since string will be a copy of the integer and take extra space. The space take by div, left, and right can be ignored.

2.Reverse

*/
public class Solution {
    // 1.
    // public boolean isPalindrome(int x) {
    //     if(x < 0) return false;
        
    //     int div = 1;
    //     while(x / div >= 10){
    //         div *= 10;
    //     }
        
    //     // Note: must consider clearly why x!=0 is OK, why x>=10 is wrong, 
    //     // For example, if x>=10, input 1000021, first left==1,right==1,pass;then x==2,left==2,right==2,pass.(Wrong here)
    //     //              if x != 0, input 1000021, first left==right==1, pass; then x==2, left==0, right ==2, not pass.(right here)
    //     while(x != 0){
    //         int left = x / div;
    //         int right = x % 10;
            
    //         if(left != right) return false;
            
    //         x = (x % div) / 10;
    //         div /= 100;
    //     }
        
    //     return true;
    // }
    
    // 2.Reverse
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
