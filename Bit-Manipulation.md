https://www.1point3acres.com/bbs/thread-73742-1-1.html

再准备面试的时候总结了一下关于bit manipulation可能用到的东西。在这里和大家分享一下～
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
