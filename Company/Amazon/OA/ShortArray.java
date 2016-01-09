/*
A method removeElement(int arr[], int index) of class ShortArray takes an array arr as an input. It returns an array after removing the integer at the given index in the input array arr. If the given index is out of bounds, then this function returns the input array arr.

The function compiles successfully but fails to return the desired result due to logical errors.

Your task is to debug the program to pass all the test cases.
*/
public class ShortArray{
    public static int[] removeElement(int arr[], int index){
        int i, j, len = arr.length;
        if(index < len){
            for(i = index; i < len - 1; i++){
                arr[i] = arr[i + 1];
            }
            int rarr[] = new int[len - 1];
            for(i = 0; i < len - 1; i++){
                rarr[i] = arr[i];
            }
            return rarr;
        }else{
            return arr;
        }
    }

    public static void main(String[] args){
        int[] arr = {3,5,5,2,9,2,7};
        int[] result = ShortArray.removeElement(arr, 3);
        for(int i : result){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}