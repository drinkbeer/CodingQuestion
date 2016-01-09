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

    // deferred binary search, can detect equality, return lo
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


    public static void main(String[] args){
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        System.out.println("Target's location: " + binarySearch(arr, target));

        System.out.println("Target's location: " + binarySearch2(arr, target));

        System.out.println("Target's location: " + binarySearch3(arr, target));
    }
}