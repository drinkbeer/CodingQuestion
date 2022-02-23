class Solution {
    // My Solution with Merge Sort. Wrong Answer, cannot handle edge case: [0] 0 0
//     public int countRangeSum(int[] nums, int lower, int upper) {
//         List<Integer> sum = new ArrayList<>();
        
//         int[] tmp = new int[nums.length];
//         mergeSort(nums, lower, upper, 0, nums.length - 1, tmp, sum);
        
//         int count = 0;
//         for (int i : sum) {
//             System.out.print(i + " ");
//             if (i >= lower && i <= upper) {
//                 count++;
//             }
//         }
        
//         return count;
//     }
    
//     private void mergeSort(int[] nums, int lower, int upper, int lo, int hi, int[] tmp, List<Integer> sum) {
//         if (lo >= hi) {
//             // Edge case: [0] 0 0
//             // if (nums[lo] >= lower && nums[lo] <= upper) sum.add(nums[lo]);
//             return;
//         }
        
//         int mid = lo + (hi - lo) / 2;
//         mergeSort(nums, lower, upper, lo, mid, tmp, sum);
//         mergeSort(nums, lower, upper, mid + 1, hi, tmp, sum);
//         merge(nums, lower, upper, lo, mid, hi, tmp, sum);
//     }
    
//     private void merge(int[] nums, int lower, int upper, int lo, int mid, int hi, int[] tmp, List<Integer> sum) {
//         for (int k = lo; k <= hi; k++) {
//             tmp[k] = nums[k];
//         }
        
//         int i = lo, j = mid + 1;
//         int s = 0;
//         for (int k = lo; k <= hi; k++) {
//             if (j > hi || (i <= mid && tmp[i] <= tmp[j])) {
//                 nums[k] = tmp[i];
//                 i++;
//             } else {
//                 nums[k] = tmp[j];
//                 j++;
//             }
            
//             s += nums[k];
//             sum.add(s);
//         }
//     }
    
    // Merge Sort + Prefix Sum
    /*
    https://leetcode.com/problems/count-of-range-sum/discuss/77990/Share-my-solution
    This solution is a combination of Merge Sort and Prefix Sum. It basically does the merge sort in prefix sum array, and count during merge sort.
    
    Must use long[] for prefix sum array, as the sum result may exceeds the boundary.
    Edge case: [-2147483647,0,-2147483647,2147483647]       -564        3864
    Using long[] for prefix sum: sum: [0, -2147483647, -2147483647, -4294967294, -2147483647]
    Using int[] for prefix sum: prefixSum: [0, -2147483647, -2147483647, 2, -2147483647]
    
    */
    public int countRangeSum(int[] nums, int lower, int upper) {
        
        long[] prefixSum = new long[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        
        long[] tmp = new long[prefixSum.length];
        int[] result = new int[1];
        mergeSort(prefixSum, lower, upper, tmp, 0, prefixSum.length - 1, result);
        return result[0];
    }
    
    private void mergeSort(long[] prefixSum, int lower, int upper, long[] tmp, int lo, int hi, int[] result) {
        if (lo >= hi) return;
        
        int mid = lo + (hi - lo) / 2;
        // System.out.println("lo: " + lo + " mid: " + mid + " hi: " + hi);
        mergeSort(prefixSum, lower, upper, tmp, lo, mid, result);
        mergeSort(prefixSum, lower, upper, tmp, mid + 1, hi, result);
        merge(prefixSum, lower, upper, tmp, lo, mid, hi, result);
    }
    
    private void merge(long[] prefixSum, int lower, int upper, long[] tmp, int lo, int mid, int hi, int[] result) {
        for (int k = lo; k <= hi; k++) {
            tmp[k] = prefixSum[k];
        }
        
        // count the number of range in right subarray that have sum value fallen in [lower, upper]
        int lowerIndex = mid + 1, upperIndex = mid + 1; // [lowerIndex, upperIndex) is the range of data in the right array that are within [lower, upper]
        for (int k = lo; k <= mid; k++) {
            while (lowerIndex <= hi && tmp[lowerIndex] - tmp[k] < lower) lowerIndex++;
            while (upperIndex <= hi && tmp[upperIndex] - tmp[k] <= upper) upperIndex++;
            result[0] += upperIndex - lowerIndex; // upperIndex exclusive
        }
        
        // start merge now
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (j > hi || (i <= mid && tmp[i] <= tmp[j])) {
                prefixSum[k] = tmp[i++];
            } else {
                prefixSum[k] = tmp[j++];
            }
        }
    }
    
    
}
