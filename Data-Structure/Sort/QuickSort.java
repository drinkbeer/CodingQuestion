package Sort;

/*
Created by chen on 15/4/2.
QuickSort (Divide & Conquer)
Time average O(NlogN)
     worst O(N^2)

"Kth element" can be solved with quick sort or quick select or heap.

https://www.programcreek.com/2012/11/quicksort-array-in-java/
Analysis of partion using the last element:
Steps:
4   5   2   1   3
s,i             p       arr[i]>arr[p], i++
s   i           p       arr[i]>arr[p], i++
s       i       p       swap[s,i], start++, i++

2   5   4   1   3
    s       i   p       swap[s,i], start++, i++
2   1   4   5   3
        s       i,p     end as arr[i] == pivot

Final Step:
2   1   3   5   4       swap[s,p]

Analysis of partion using the middle element:
Steps:
4   5   2   1   3
i       p       j       arr[j] > arr[p], j--
i       p   j           swap[i,j], i++, j--

1   5   2   4   3
    i   p,j             arr[i] >= pivot, arr[j]<= pivot, swap[i,j], i++, j--
1   2   5   4   3
    p,j i


Reference: https://runestone.academy/runestone/books/published/pythonds/SortSearch/TheQuickSort.html
        https://www.geeksforgeeks.org/quick-sort/
        https://www.geeksforgeeks.org/java-program-for-quicksort/
        https://www.programiz.com/dsa/quick-sort

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

    // 1. Pivot in middle
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

    // 2. Partition with last element
    // https://www.programcreek.com/2012/11/quicksort-array-in-java/
    public static int partition2(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        for (int i = lo; i < hi; i++) {
            if (arr[i] < pivot) {
                int temp = arr[lo];
                arr[lo] = arr[i];
                arr[i] = temp;

                lo++;
            }
        }

        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;

        return lo;
    }

    // Anothter way to write partition with middle element
    // Partition with middle element
    private static void quickSort2(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = arr[lo + (hi - lo) / 2];

        int i = lo;
        int j = hi;

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        quickSort(arr, lo, j);
        quickSort(arr, i, hi);
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
