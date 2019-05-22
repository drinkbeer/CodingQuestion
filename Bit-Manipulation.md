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
（1）n & （n-1）能够消灭n中最右侧的一个1。
（2） 右移：除以2， 左移：乘以2。
（3）异或性质：交换律，0^a=a, a^a=0;
（3）将常用字符、数字等均转为按位运算，可以节约空间。
