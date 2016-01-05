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
public class Solution {
    
    private static double myPower(double x, int n){
        if(n == 0) return 1;
        
        double v = myPower(x, n/2);
        
        if(n % 2 == 0) return v * v;
        else return v * v * x;
    }
    
    public double myPow(double x, int n) {
        if(n < 0) return 1 / myPower(x, -n);
        return myPower(x, n);
    }
}