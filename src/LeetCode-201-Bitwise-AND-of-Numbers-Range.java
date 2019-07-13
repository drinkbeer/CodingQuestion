class Solution {
    
    // 1. Brute Force (TLE)
    /*
    5:  101
    6:  110
    7:  111
    */
    // public int rangeBitwiseAnd(int m, int n) {
    //     for (int i = m + 1; i <= n; i++) {
    //         m &= i;
    //     }
    //     return m;
    // }
    
    /*
    https://leetcode.com/problems/bitwise-and-of-numbers-range/discuss/56729/Bit-operation-solution(JAVA)
    
    The hardest part of this problem is to find the regular pattern.
    For example, for number 26 to 30
    Their binary form are:
    11010
    11011
    11100　　
    11101　　
    11110

    Because we are trying to find bitwise AND, so if any bit there are at least one 0 and one 1, it always 0. In this case, it is 11000.
    So we are go to cut all these bit that they are different. In this case we cut the right 3 bit.
    
    */
    public int rangeBitwiseAnd(int m, int n) {
        int i = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            i++;
        }
        return m << i;
    }
}
