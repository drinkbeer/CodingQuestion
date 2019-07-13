public class Solution {
    // 1. Shift Bit Manipulation
    /*
    https://leetcode.com/problems/reverse-bits/discuss/54950/Concise-Java-Solution
    */
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n >>>= 1;       // unsigned right shift
        }
        return res;
    }
    
    /*
    Follow up: If this function is called many times, how would you optimize it?
    */
    
}
