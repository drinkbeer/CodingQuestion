/*
A method sortArray(int arr[]) of class ArraySort accepts an integer array arr as an input and performs an inplace sort operation on it. This function is expected to return the input array sorted in desending order.

The function compiles successfully but fails to return the desired result due to logical errors.

Your task is to debug the program to pass all the test cases.
*/
public class ArraySort{
    public static int[] sortArray(int arr[]){
        int i, max, location, j, temp, len = arr.length;
        for(i = 0; i < len; i++){
            max = arr[i];
            location = i;
            for(j = i; j < len; j++){
                if(max < arr[j]){
                    max = arr[j];
                    location = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[location];
            arr[location] = temp;
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {3,5,5,2,9,2,7};
        int[] result = ArraySort.sortArray(arr);
        for(int i : result){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
