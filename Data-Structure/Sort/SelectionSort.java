/*
Created by chen on 15/3/25.
Selection Sort
Time O(N^2)
*/
class SelectionSort {
    public static void selectionSort(int arr[]) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++){
                if (arr[j] < arr[min]) min = j;
            }
            if(min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 6, 4, 2, 3, 9, 5, 3, 2, 0};
        // int[] arr = {2, 6, 3, 5, 1};
        selectionSort(arr);
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }
}
