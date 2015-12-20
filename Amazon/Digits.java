/*
A method countDigits(int num) of class Digits returns the remainder when the input argument num(num > 0) is divided by the number of digits in num.
The function compiles successfully but fails to return the desired result due to logical errors.
Your task is to debug the program to pass all the test cases.

*/
public class Digits{
    public static int countDigits(int num){
        int count = 0, temp = num;
        while(temp != 0){
            temp = temp / 10;
            count ++;
        }
        // at this time num==0, so we use a temp variable to put num int temp first
        return (num % count);
    }

    public static void main(String[] args){
        //assert Digits.countDigits(1) == 1;
        System.out.println(Digits.countDigits(1));      //count=1   ->  0
        System.out.println(Digits.countDigits(23));     //count=2   ->  1
        System.out.println(Digits.countDigits(34724));  //count=3   ->  4
    }
}