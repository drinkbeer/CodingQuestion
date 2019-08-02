https://www.1point3acres.com/bbs/thread-73742-1-1.html

再准备面试的时候总结了一下关于bit manipulation可能用到的东西。在这里和大家分享一下～

```
x ^ 0s = x      x & 0s = 0   x | 0s = x
x ^ 1s = ~x   x & 1s = x    x | 1s = 1s
x ^ x  = 0      x & x = x     x | x  = x

boolean getBit(int i, int num){
        return ( (num & (1 << i)) != 0 );
}

int setBit(int i, int num){
        return num | (1 << i);
}

int clearBit(int num, int i) {
        int mask = ~(1 << i);
        return num & mask;
}

int clearBitMSBthroughI(int num, int i){
        int mask = (1<< i) -1;
        return num & mask;
}

int clearBitsIThrough0(int i, int num) {
        int mask = ~( (1 << (i+1) )  -1 );
        return num & mask;
}

int updateBit(int i, int num, int v){
        int mask = ~(1 << i);
        return (num & mask) | (v << i);
}
```


常用技巧：
1. n & （n-1）能够消灭n中最右侧的一个1。
2.  右移：除以2， 左移：乘以2。
3. 异或性质：交换律，0^a=a, a^a=0;
4. 将常用字符、数字等均转为按位运算，可以节约空间。

The notation '0b' in front of a number is used as an indicator that what follows is represented in binary.    
"0b" - binary （二进制）   
"0" - octal (八进制)   
"0x" - hexadecimal （十六进制）    

#### Right Shift vs Unsigned Right Shift
https://javarevisited.blogspot.com/2015/02/difference-between-right-shift-and.html

Right Shift: `>>`   
Unsigned Right Shift: `>>>`   

If it's a negative number, `>>` will use 1 to fill left side, but `>>>` will use 0 to fill left side.
`>>>` is unsigned-shift; it'll insert 0. `>>` is signed, and will extend the sign bit.



#### 190. Reverse Bits
https://leetcode.com/problems/reverse-bits/

```
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
```

#### 191. Number of 1 Bits
https://leetcode.com/problems/number-of-1-bits/

```
// you need to treat n as an unsigned value
public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n >>>= 1;
        }
        return count;
}
```

#### 393. UTF-8 Validation
https://leetcode.com/problems/utf-8-validation/

```
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
```
