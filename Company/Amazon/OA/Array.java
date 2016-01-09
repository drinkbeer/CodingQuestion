/*
A method sortArray(int arr[]) of class Array accepts an integer array arr as an input and performs an inplace sort operation on it. The function is expected to return the input array sorted in desending order, but instead, it returns the array sorted in ascending order due to a bug in the code.
*/
public class Array{
    public static int[] sortArray(int arr[]){
        int len = arr.length;
        int small, pos, i, j, temp;

        for(i = 0; i <= len - 1; i++){
            for(j = i; j < len; j++){
                temp = 0;
                if(arr[i] < arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {3,5,5,2,9,2,7};
        int[] result = Array.sortArray(arr);
        for(int i : result){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}