package Sort;

/*
Created by chen on 15/4/2.
QuickSort (Divide & Conquer)
Time average O(NlogN)
     worst O(N^2)

Reference: https://runestone.academy/runestone/books/published/pythonds/SortSearch/TheQuickSort.html

*/
class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int val = partition(arr, lo, hi);
        quickSort(arr, lo, val - 1);
        quickSort(arr, val + 1, hi);
    }

    public static int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi;
        
        int pivot = arr[lo + (hi - lo) / 2];
        while(i <= j){
            while(arr[i] < pivot) i++;
            while(arr[j] > pivot) j--;
            
            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 6, 4, 2, 3, 9, 5, 3, 2, 0};
        // int[] arr = {2, 6, 3, 5, 1};
        quickSort(arr);
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }
}
