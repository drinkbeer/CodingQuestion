
/*
Created by chen on 15/3/25.
Insertion Sort
Time O(N^2)

https://zhuanlan.zhihu.com/p/122293204
*/
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int key = arr[i];
            while(j >= 0 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void insertionSort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args){
        int[] arr1 = new int[]{5,2,4,6,1,3};
        insertionSort2(arr1);
        for(int curr: arr1){
            System.out.print(curr + " ");
        }
    }
}
