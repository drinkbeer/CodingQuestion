
/*
Created by chen on 15/4/1.
Time O(NlogN)

https://zhuanlan.zhihu.com/p/124356219
 */
class MergeSort {

    // public static void sort(int[] arr) {
    //     int[] tmp = new int[arr.length];
    //     sort(arr, tmp, 0, arr.length - 1);
    // }

    // private static void sort(int[] arr, int[] tmp, int lo, int hi) {
    //     if (lo >= hi) return;
    //     int mid = lo + (hi - lo) / 2;
    //     sort(arr, tmp, lo, mid);                //sort left part
    //     sort(arr, tmp, mid + 1, hi);        //sort right part
    //     merge(arr, tmp, lo, mid, hi);           //merge left and right parts
    // }
    
    // public static void merge(int[] arr, int[] tmp, int lo, int mid, int hi) {
    //     for (int k = lo; k <= hi; k++) {
    //         tmp[k] = arr[k];
    //     }

    //     int i = lo;
    //     int j = mid + 1;
    //     for (int k = lo; k <= hi; k++) {
    //         // if (i > mid)                             a[k] = tmp[j++];
    //         // else if (j > hi)                         a[k] = tmp[i++];
    //         // else if (tmp[i].compareTo(tmp[j]) < 0)   a[k] = tmp[i++];
    //         // else                                     a[k] = tmp[j++];
    //         // Another version of code
    //         if(j > hi || (i <= mid && tmp[i] < tmp[j])){
    //             arr[k] = tmp[i++];
    //         }else{
    //             arr[k] = tmp[j++];
    //         }
    //     }
    // }

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, lo, mid);
        sort(arr, mid + 1, hi);
        merge(arr, lo, mid, hi);
    }

    private static void merge(int[] arr, int lo, int mid, int hi) {
        int[] tmp = new int[arr.length];
        for (int k = lo; k <= hi; k++) {
            tmp[k] = arr[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (j > hi || (i <= mid && tmp[i] < tmp[j])) {
                arr[k] = tmp[i++];
            } else {
                arr[k] = tmp[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 6, 4, 2, 3, 9, 5, 3, 2, 0};
        // int[] a = {2, 6, 3, 5, 1};
        sort(arr);
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }

}
