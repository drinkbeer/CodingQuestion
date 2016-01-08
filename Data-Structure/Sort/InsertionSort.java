package Sort;

/*
Created by chen on 15/3/25.
Insertion Sort
Time O(N^2)
*/
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int N = arr.length;
        for (int i = 1; i < N; i++) {
            int j = i - 1;
            int key = arr[i];
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args){
        int[] arr1 = new int[]{5,2,4,6,1,3};
        insertionSort(arr1);
        for(int curr: arr1){
            System.out.print(curr + " ");
        }
    }
}
