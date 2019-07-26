/*
https://www.youtube.com/watch?v=-r1cL8lCLeM
https://leetcode.com/problems/utf-8-validation/discuss/87464/Bit-Manipulation-Java-6ms

Traverse the given int array, 
Find the number of bytes of that number, 
check the next n - 1 bytes start with 10, if not return false;
Finally, return true.

Analysis:

197

7   6   5   4   3   2   1   0
128 64  32  16  8   4   2   1
1   1   0   0   0   1   0   1

197 = 11000101

1 byte = 8 bits, so the range of 1 byte is [0, 255]

*/
class Solution {

    public boolean validUtf8(int[] data) {
        int count = 0;  // count means the number of bytes that are expected to start with "10"
        for (int d : data) {
            if (count == 0) {
                // means d is the first character, or the invalid case, like [110xxxxx, 10xxxxxx, 10xxxxxx]
                if ((d >> 5) == 0b110) {
                    count = 1;
                } else if ((d >> 4) == 0b1110) {
                    count = 2;
                } else if ((d >> 3) == 0b11110) {
                    count = 3;
                } else if ((d >> 7) != 0b0) {
                    // b should be the case [0xxxxxxx], if it doesn't start with "0", then it's wrong.
                    return false;
                }
            } else {
                // means d is not the first byte, we check current d if it starts with "10"
                if ((d >> 6) != 0b10) return false;
                else count--;
            }
        }
        return count == 0;
    }
}
