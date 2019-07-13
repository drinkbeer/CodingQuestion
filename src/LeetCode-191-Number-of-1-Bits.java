/*
https://leetcode.com/discuss/30605/simple-java-solution-bit-shifting

What's the difference between >> and >>>? http://www.geeksforgeeks.org/bitwise-shift-operators-in-java/
The signed left shift operator "<<" shifts a bit pattern to the left, and the signed right shift operator ">>" shifts a bit pattern to the right. The bit pattern is given by the left-hand operand, and the number of positions to shift by the right-hand operand. The unsigned right shift operator ">>>" shifts a zero into the leftmost position, while the leftmost position after ">>" depends on sign extension.
The operator ‘>>’ uses the sign bit (left most bit) to fill the trailing positions after shift. If the number is negative, then 1 is used as a filler and if the number is positive, then 0 is used as a filler.
In Java, the operator ‘>>>’ is unsigned right shift operator. It always fills 0 irrespective of the sign of the number.

while(n > 0)  or  while(n != 0) ?
It should be the latter. e.g. n =   2147483648 (10000000000000000000000000000000), which is < 0, so we can only use n!=0

*/
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
    }
}
