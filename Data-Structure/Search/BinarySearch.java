package Search;

import java.util.Arrays;

/*
Created by chen on 15/2/1.
[1, 2, 2, 2, 3, 4, 5] target = 2, 要找第一个index，答案应该是1. 我的算法是错的，因为找到的是3，不是第一个index
*/
class BinarySearch {

    // general binary search, cannot detect equality
    private static int binarySearch(int[] arr, int target){
        int lo = 0;
        int hi = arr.length - 1;
      
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;

            if(arr[mid] < target) lo = mid + 1;
            else if(arr[mid] > target) hi = mid - 1;
            else return mid;
        }
        return -1;
    }

    // deferred binary search, can detect equality, return lo. Doesn't work for the case that target doesn't exist in array, for example [0, 1], target=2
    private static int binarySearch2(int[] arr, int target){
        int lo = 0;
        int hi = arr.length - 1;
        
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;

            if(arr[mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }

        //no need deferred test for equality
        // if((lo == hi) && (arr[lo] == target)) return lo;
        return lo;
    }

    /**
     * Find the first element that is >= target
     * http://www.jiuzhang.com/solutions/binary-search/
     */
    public static int binarySearch3(int[] arr, int target) {
        int lo = 0, hi = arr.length - 1;
        
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        
        // System.out.println(lo + " - " + hi);
        if (arr[lo] == target) return lo;
        if (arr[hi] == target) return hi;
        return -1;
    }

    // In a sorted, duplicated array, search the first element >= target
    private static int binarySearch4(int[] arr, int target){
        int lo = 0;
        int hi = arr.length - 1;

        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;

            if(arr[mid] < target) lo = mid;
            else hi = mid;
        }

        if (arr[lo] == target) return lo;
        if (arr[hi] == target) return hi;
        return -1;
    }

    // In a sorted, duplicated array, search the last element <= target
    private static int binarySearch5(int[] arr, int target){
        int lo = 0;
        int hi = arr.length - 1;

        while(lo + 1 < hi){
            int mid = lo + (hi - lo) / 2;

            if(arr[mid] > target) hi = mid;
            else lo = mid;
        }

        if (arr[hi] == target) return hi;
        if (arr[lo] == target) return lo;
        return -1;
    }


    public static void main(String[] args){
        int[] arr1 = {1, 2, 2, 2, 3, 4, 5};
        int[] arr2 = {0, 1};
        int[] arr3 = {3, 4};
        int target = 2;

        int[][] arr = {arr1, arr2, arr3};
        for (int[] ints : arr) {
            System.out.println("array: " + Arrays.toString(ints) + "  Target's location in binarySearch1: " + binarySearch(ints, target));
            System.out.println("array: " + Arrays.toString(ints) + "  Target's location in binarySearch2: " + binarySearch2(ints, target));
            System.out.println("array: " + Arrays.toString(ints) + "  Target's location in binarySearch3: " + binarySearch3(ints, target));
            System.out.println("array: " + Arrays.toString(ints) + "  Target's location in binarySearch4: " + binarySearch4(ints, target));
            System.out.println("array: " + Arrays.toString(ints) + "  Target's location in binarySearch5: " + binarySearch5(ints, target));
        }
    }
}