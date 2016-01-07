/*
LeetCode: https://leetcode.com/problems/divide-two-integers/
LintCode: http://www.lintcode.com/problem/divide-two-integers/
JiuZhang: http://www.jiuzhang.com/solutions/divide-two-integers/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-divide-two-integers-java/

Analysis: 
思路:
    
整数近似除法：32/3 = 10

显然求近似除法可以用乘法来二分查找：32 ~ 3*10 = 3*[1*(2^3) + 0*(2^2) + 1*(2^1) + 0*(2^0)]

res = 0

1. 先找到a使x*2^a <= y < x*2^(a+1)，res += 2^a，y = y - x*2^a

2. if(y >= x*2^(a-1) {res+=2^(a-1); y = y - x*2^(a-1);} 

3. if(y >= x*2^(a-2) {res+=2^(a-2); y = y - x*2^(a-2);}

...

但题目不允许用乘法，可以用移位代替：x*2^i = x<<i：
*/

public class Solution {
    
    
    public int divide(int dividend, int divisor) {
        long p = Math.abs((long)dividend);
        long q = Math.abs((long)divisor);
        int result = 0;
        
        while(p >= q){
            int counter = 0;
            while(p >= (q << counter)){
                counter++;
            }
            result += 1 << (counter - 1);
            p -= q << (counter - 1);
        }
        
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;     // -Integer.MIN_VALUE overflow
        
        if(dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0) return result;
        else return -result;
    }
}