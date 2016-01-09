/*
A method reverseArray(int arr[]) of class SortArray accepts an input array arr as an argument. The function is expected to reverse the elements of the input array in-place.

For example, if the input arr is {20, 30, 10, 40, 50}, the function is expected to return {50, 40, 10, 30, 20}.

The function compiles successfully but fails to return the desired result due to logical errors.
*/
public class SortArray{
    public static int[] reverseArray(int arr[]){
        int i, temp, originallen = arr.length;
        int len = originallen;
        for(i = 0; i < originallen / 2; i++){
            temp = arr[len - 1];
            arr[len - 1] = arr[i];
            arr[i] = temp;
            len -= 1;
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {3,5,5,2,9,2,7};
        int[] result = SortArray.reverseArray(arr);
        for(int i : result){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}