/*
A method replaceValues(int arr[]) of class ArrayOperation accepts an array arr as an input and returns an array of the same length.
If the length of arr is odd, all the elements of arr are replaced by 1s and in case it is even, the elements are replaced by 0s.
For example: given the input array {0,1,2}, the function will return the array{1,1,1}.
The function compiles successfully but fails to return the desired result due to logical errors.
Your task is to debug the program to pass all the test cases.
*/
public class ArrayOperation{
    public static int[] replaceValues(int arr[]){
        int i, j, len = arr.length;
        if(len % 2 == 0){
            for(i = 0; i < len; i++){
                arr[i] = 0;
            }
        }else{
            for(j = 0; j < len; j++){
                arr[j] = 1;
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {3,5,5,2,9,2,7};
        int[] result = ArrayOperation.replaceValues(arr);
        for(int i : result){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}