/*
LeetCode: https://leetcode.com/problems/powx-n/
LintCode: http://www.lintcode.com/problem/powx-n/
JiuZhang: http://www.jiuzhang.com/solutions/powx-n/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-powx-n/
Other: http://www.cnblogs.com/yuzhangcmu/p/4174683.html

Analysis: 
使用二分法。

1. 负数的情况，使用以下的公式转化为求正数power，另外，考虑到MIN_VALUE可能会造成越界的情况，我们先将负数+1：

X^(-n) = X^(n + 1) * X
X^n = 1/(x^(-n))

2. Base case: pow = 0, RESULT = 1;

3. 正数的时候，先求n/2的pow，再两者相乘即可。

当n = -2147483648 必须要特别处理，因为对这个数取反会得到相同的数（已经越界）
所以当n为负时，先加个1再说。具体可以看代码。

先计算出x的n/2次方，再自乘一下。另外，注意n%2如果为1，
记得再乘以x

如果n是负数，所有计算完成后，执行x=1/x就行
*/

/*
https://leetcode.com/problems/powx-n/discuss/19544/5-different-choices-when-talk-with-interviewers

Test Cases:

2.0,2 -> 4
2.0,-2 -> 0.25
2.0,0 -> 1.0

1.0,-2147483648 -> 取正 2147483648 是超过int的范围的 [2^32,2^32-1]所以不能直接取反。

*/
public class Solution {
    
    // 1.
//     private static double myPower(double x, int n){
//         if(n == 0) return 1;
        
//         double v = myPower(x, n/2);
        
//         if(n % 2 == 0) return v * v;
//         else return v * v * x;
//     }
    
//     public double myPow(double x, int n) {
//         if(n < 0) return 1 / myPower(x, -n);
//         return myPower(x, n);
//     }
    
    
    
    /*
    Base Case:
    
    n==0, return 1.0
    
    当n=Integer.MIN_VALUE (-2147483648，-2^32)时，我们是不能直接取反的，因为Integer.MAX_VALUE是 2147483647 (2^32-1)，直接取反会导致Integer Overflow。
    所以处理负数的正确方法是，把n变成 -(n+1)，然后当成正常的正数处理。最后返回结果的时候多乘一个x就行了。
    
    */
    public double myPow(double x, int n) {
        if (n == 0) return 1.0;
        
        boolean isPositive = true;
        if (n < 0) {
            isPositive = false;
            n = -(n + 1);
            x = 1 / x;
        }
        
        double v = 0;
        if (n % 2 == 0) v = myPow(x * x, n / 2);
        else v = x * myPow(x * x, n / 2);
        
        if (!isPositive) {
            return x * v;
        }
        return v;
    }
    
    // 简化版
    // double myPow(double x, int n) { 
    //     if (n < 0) {
    //         return 1 / x * myPow(1 / x, - (n + 1));
    //     }
    //     if(n==0) return 1;
    //     if (n % 2 == 0) {
    //         return myPow(x * x, n / 2);
    //     } else {
    //         return x * myPow(x * x, n / 2);
    //     }
    // }
    
    // double myPow(double x, int n) {
    //     if(n<0) return 1/x * myPow(1/x, -(n+1));
    //     if(n==0) return 1;
    //     if(n==2) return x*x;
    //     if(n%2==0) return myPow( myPow(x, n/2), 2);
    //     else return x*myPow( myPow(x, n/2), 2);
    // }
}
