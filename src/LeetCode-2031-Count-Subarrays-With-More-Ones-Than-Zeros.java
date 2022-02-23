class Solution {
//     // Merge Sort. My solution, doesn't work.
//     public int subarraysWithMoreZerosThanOnes(int[] nums) {
//         int[] prefixSum = new int[nums.length];
//         int count = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 0) nums[i] = -1;
//             if (i == 0) {
//                 prefixSum[i] = nums[i];
//             } else {
//                 prefixSum[i] = prefixSum[i - 1] + nums[i];
//             }
            
//             if (prefixSum[i] > 0) count++;
//         }
        
//         int[] temp = new int[prefixSum.length];
//         count += mergeSort(prefixSum, temp, 0, nums.length - 1);
//         return count;
//     }
    
//     private int mergeSort(int[] prefixSum, int[] temp, int lo, int hi) {
//         if (lo >= hi) return 0;
        
//         int mid = lo + (hi - lo) / 2, count = 0;
//         count += mergeSort(prefixSum, temp, lo, mid);
//         count += mergeSort(prefixSum, temp, mid + 1, hi);
//         count += mergeAndCount(prefixSum, temp, lo, mid, hi);
//         return count;
//     }
    
//     private int mergeAndCount(int[] prefixSum, int[] temp, int lo, int mid, int hi) {
//         for (int k = lo; k <= hi; k++) {
//             temp[k] = prefixSum[k];
//         }
        
//         // count
//         int i = lo, j = mid + 1, count = 0;
//         while (i <= mid && j <= hi) {
//             if (temp[i] >= temp[j]) {
//                 count += i - lo;
//                 j++;
//             } else {
//                 i++;
//             }
//         }
//         while (j <= hi) {
//             count += i - lo;
//             j++;
//         }
        
        
//         // merge
//         i = lo;
//         j = mid + 1;
//         for (int k = lo; k <= hi; k++) {
//             if (j > hi || (i <= mid && temp[i] < temp[j])) {
//                 prefixSum[k] = temp[i++];
//             } else {
//                 prefixSum[k] = temp[j++];
//             }
//         }
        
//         return count;
//     }
    
    /*
    Copied from: https://leetcode.com/problems/count-subarrays-with-more-ones-than-zeros/discuss/1522160/Java-merge-sort
    */
    private long res = 0, mod = 1000_000_007;
    public int subarraysWithMoreZerosThanOnes(int[] nums) {

        int[] prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) nums[i] = -1;
            if (i == 0) prefixSum[i] = nums[i];
            else prefixSum[i] = prefixSum[i-1] + nums[i];

            if (prefixSum[i] > 0) res++;
        }

        mergeSort(prefixSum, 0, nums.length-1);
        return (int) (res % mod);
    }

    public void mergeSort(int[] prefixSum, int left, int right) {
        if (left >= right) {
            return;
        }
        int middle = left + (right - left)/2;
        mergeSort(prefixSum, left, middle);
        mergeSort(prefixSum, middle+1, right);
        merge(prefixSum, left, middle, right);
    }
    
    private void merge(int[] prefixSum, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        
        // two pointers;
        int i = left;
        int j = middle+1;
        int index = 0;
        
        while (i <= middle && j <= right) {
            if (prefixSum[i] < prefixSum[j]) {
                temp[index++] = prefixSum[i++];
            } else {
                res += (i - left);
                temp[index++] = prefixSum[j++];
            }
        }
        
        while(i <= middle) temp[index++] = prefixSum[i++];
        while(j <= right) {
            res += (i - left);  // here, we make sure that prefixSum[left_last_element] < prefixSum[j];
            temp[index++] = prefixSum[j++];
        }
        
        for (int m = left; m <= right; m++) prefixSum[m] = temp[m-left];
    }
    
    
    // Another O(N) solution using counting
    
}
