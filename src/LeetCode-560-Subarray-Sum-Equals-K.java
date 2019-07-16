class Solution {
//     public int subarraySum(int[] nums, int k) {
//         if (nums == null || nums.length == 0) return 0;
        
//         int s = 0, e = 0, count = 0, sum = 0;
//         while (e < nums.length) {
//             if (sum < k) {
//                 sum += nums[e];
//             }
            
//             while (sum == k) {
//                 // we find a subarray sum equals to k
//                 count++;
                
//                 if (s < e) {
//                     sum -= nums[s];
//                 }
//             }
//         }
        
//     }
    
    
    // 2. Trying to search the right boundary of culmulative sum
    /*
    
    As the nums[] could have negative element, the culculative sum array could be decreasing. So binary search doesn't help a lot here, as the culculative sum is not always ascending.
    
    */
//     public int subarraySum(int[] nums, int k) {
//         if (nums == null || nums.length == 0) return 0;
        
//         int n = nums.length;
//         int[] sum = new int[n + 1];
//         for (int i = 0; i < n; i++) sum[i + 1] = sum[i] + nums[i];
        
//         int res = 0;
//         // i is exclusive in the Sliding Window as we are using the culmulative sum for searching
//         for (int i = 0; i < n; i++) {
//             // search the left most boundary that has sum[r] == sum[i] + k using Binary Search
//             int r = searchRight(sum, i + 1, sum[i] + k);
//             if (r != -1) {
//                 res++;
//             }
//         }
//         return res;
//     }
    
//     // Iterative Search
//     private int searchRight(int[] sum, int start, int target) {
//         int lo = start, hi = sum.length - 1;
//         for (int i = start; i < sum.length; i++) {
//             if (sum[i] == target) return i;
//         }
//         return -1;
//     }
    
    // Binary Search: search the left most boundary that has sum[r] == sum[i] + k using Binary Search (it's possible that it does not exist)
//     private int searchRight(int[] sum, int start, int target) {
//         int lo = start, hi = sum.length - 1;
//         System.out.println("lo: " + lo + "  hi: " + hi + "  sum: " + Arrays.toString(sum));
//         while (lo + 1 < hi) {
//             int mid = lo + (hi - lo) / 2;
//             if (sum[mid] == target) {
//                 return mid;
//             } else if (sum[mid] < target) {
//                 lo = mid;
//             } else {
//                 hi = mid;
//             }
//         }
        
//         System.out.println("target: " + target + "  sum[lo]: " + sum[lo] + "  sum[hi]: " + sum[hi]);
        
//         if (sum[lo] == target) return lo;
//         if (sum[hi] == target) return hi;
//         return -1;
//     }
    
    
    // 1. Brute Force for the culmulative sum array
    /*
    Time O(N^2)
    */
//     public int subarraySum(int[] nums, int k) {
//         if (nums == null || nums.length == 0) return 0;
        
//         int n = nums.length;
//         for (int i = 1; i < n; i++) nums[i] += nums[i - 1];
    
//         int res = 0;
//         for (int i = 0; i < n; i++) {
//             if (nums[i] == k) res++;
//             for (int j = i + 1; j < n; j++) {
//                 if (nums[i] + k == nums[j]) {
//                     res++;
//                 }
//             }
//         }
        
//         return res;
//     }
    
    // 2. HashMap to store culmulative sum frequency. So each time, we check if sum - k exists in the map.
    /*
    Time O(N)
    */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
}
