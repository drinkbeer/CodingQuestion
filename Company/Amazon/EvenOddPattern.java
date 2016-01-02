/*
A method printPattern(int num) of class EvenOddPattern prints even or odd numbers based on the value of the input argument num (num>=0).

If the input number num is even, the function is expected to print the first num even whole numbers and in case it is odd, is expected to print the first num odd numbers. For example: given input 2, the function prints the string "0 2"(without quotes).

The function compiles successfully but fails to print the desired result due to logical errors.
*/
public class EvenOddPattern{
    public static void printPattern(int num){
        int i, print = 0;
        if(num % 2 == 0) {
            print = 0;
            for(i = 0; i < num; i++){
                System.out.print(print + " ");
                print += 2;
            }
            
        }else{
            print = 1;
            for(i = 0; i < num; i++){
                System.out.print(print + " ");
                print += 2;
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        EvenOddPattern.printPattern(2);
        
        EvenOddPattern.printPattern(3);

        EvenOddPattern.printPattern(11);
    }
}