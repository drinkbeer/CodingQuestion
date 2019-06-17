class Solution {
    // 1. Using the HEAP (PRIORITY QUEUE)
    // It will Memory Limit Exceeded.
//     public int smallestDistancePair(int[] nums, int k) {
//         Queue<Integer> queue = new PriorityQueue<>();
        
//         for (int i = 0; i < nums.length - 1; i++) {
//             for (int j = i + 1; j < nums.length; j++) {
//                 queue.add(Math.abs(nums[i] - nums[j]));
//             }
//         }
        
//         int res = 0;
//         for (int i = 0; i < k; i++) {
//             res = queue.poll();
//         }
//         return res;
//     }
    
    // 2. Bucket Sort solution.
    /*
    Create an array as bucket, used to count the frequency of distances.
    */
//     public int smallestDistancePair(int[] nums, int k) {
//         int len = nums.length;
//         int len2 = 1000000;
        
//         int[] bucket = new int[len2];
//         for (int i = 0; i < len - 1; i++) {
//             for (int j = i + 1; j < len; j++) {
//                 int diff = Math.abs(nums[i] - nums[j]);
//                 bucket[diff]++;
//             }
//         }
        
//         int sum = 0;
//         for (int i = 0; i < len2; i++) {
//             sum += bucket[i];
//             if (sum >= k) return i;
//         }
//         return -1;
//     }
    
    
    // 2.Binary Search
    /*
    https://leetcode.com/problems/find-k-th-smallest-pair-distance/discuss/109075/Java-solution-Binary-Search
    
    */
//     public int smallestDistancePair(int[] nums, int k) {
//         Arrays.sort(nums);
        
//         int N = nums.length;
//         int lo = 0, hi = nums[N - 1] - nums[0];
        
//         for (int i = 0; i < N - 1; i++) {
//             lo = Math.min(lo, nums[i + 1] - nums[i]);
//         }
        
//         while (lo < hi) {
//             int mid = lo + (hi - lo) / 2;
            
//             if (countPairs(nums, mid) < k) {
//                 lo = mid + 1;
//             } else {
//                 hi = mid;
//             }
//         }
        
//         return lo;
//     }
    
//     // count number of pairs that diff is smaller than or equals to mid
//     private int countPairs(int[] nums, int mid) {
//         int N = nums.length, count = 0;;
//         for (int i = 0; i < N - 1; i++) {
//             int j = i + 1;
//             while (j < N && nums[j] - nums[i] <= mid) j++;
//             count += j - i - 1;
//         }
//         return count;
//     }
    
    
    // 3. Binary Search
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int low = 0;
        int high = nums[nums.length - 1] - nums[0];

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (!enough(nums, mid, k)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public boolean enough(int[] nums, int mid, int k) {
        int count = 0;

        for (int right = 0, left = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) left++;
            count += right - left;
        }

        return count >= k;
    }
    
}
