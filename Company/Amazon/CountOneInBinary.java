
class CountOneInBinary {

    public static void main(String[] args){
        System.out.println("1 : " + countOne(1));
        System.out.println("2 : " + countOne(2));
        System.out.println("3 : " + countOne(3));
        System.out.println("4 : " + countOne(4));
        System.out.println("5 : " + countOne(5));
        System.out.println("369 : " + countOne(369));   //101110001
        System.out.println("63 : " + countOne(63)); //2^6-1
        System.out.println("Integer Max Value : " + countOne(Integer.MAX_VALUE));
        
        System.out.println("-1 : " + countOne(-1));
        System.out.println("-2 : " + countOne(-2));
        System.out.println("-3 : " + countOne(-3));
        System.out.println("-4 : " + countOne(-4));
        System.out.println("-5 : " + countOne(-5));
        System.out.println("-369 : " + countOne(-369)); //101110001
        System.out.println("Integer Min Value : " + countOne(Integer.MIN_VALUE));
        // System.out.println(Integer.MIN_VALUE + " " + -1 * Integer.MIN_VALUE);
    }

    //Wrong Answer
    // public static int countOne(int num){
    //     int count = 0;
    //     if(num == Integer.MIN_VALUE) return 1;
        
    //     if(num < 0) num *= -1;

    //     while(num > 0){
    //         int temp = num;
    //         temp >>= 1;
    //         temp <<= 1;

    //         if(num - temp == 1) count++;
    //         num >>= 1;
    //     }
        
    //     return count;
    // }

    //Right Answer: https://zh.wikipedia.org/wiki/%E6%9C%89%E7%AC%A6%E8%99%9F%E6%95%B8%E8%99%95%E7%90%86
    //计算机中都是无符号二进制，负数是用补码的方式处理的。
    static int countOne(int input){
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((input & 1) != 0) count++;
            input >>= 1;
        }
        return count;
    }
}