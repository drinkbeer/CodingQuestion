class Solution {
    // Wrong Answer
    /*
    Input
    [1,3,6,7,9,4,10,5,6]
    Output
    5
    Expected
    6
    
    */
//     public int lengthOfLIS(int[] nums) {
//         Stack<Integer> stack = new Stack<>();
//         int max = Integer.MIN_VALUE;
//         for (int i = 0; i < nums.length; i++) {
//             if (stack.isEmpty()) {
//                 stack.push(nums[i]);
//             } else {
//                 while(!stack.isEmpty() && stack.peek() >= nums[i]) {
//                     stack.pop();
//                 }
//                 stack.push(nums[i]);
//             }
            
//             max = Math.max(max, stack.size());
//         }
//         return max == Integer.MIN_VALUE ? 0 : max;
//     }
    
    // 1. DP
    /*
    subproblem:
    dp[i]   -   the max Len til ith number in nums array
    
    recurrence relation:
    dp[i] = dp[j] + 1, dp[j] is max within dp[0, i - 1], nums[i] > nums[j]
    
    init:
    dp[0] = 1   only one element, so it must be increasing
    */
//     public int lengthOfLIS(int[] nums) {
//         if (nums == null || nums.length == 0) return 0;
        
//         int n = nums.length;
        
//         // subproblem
//         int[] dp = new int[n];
//         int max = 1;
        
//         // init
//         Arrays.fill(dp, 1);
        
//         // recurrence relation:
//         for (int i = 1; i < n; i++) {
//             for (int j = i - 1; j >= 0; j--) {
//                 if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
//                     dp[i] = dp[j] + 1;
//                 }
//             }
//             max = Math.max(max, dp[i]);
//         }
        
//         return max;
//     }
    
    // 2. Binary Search
    /*
    https://www.cnblogs.com/grandyang/p/4938187.html
    
    
    下面我们来看一种优化时间复杂度到O(nlgn)的解法，这里用到了二分查找法，所以才能加快运行时间哇。
    
    思路是，我们先建立一个数组ends，把首元素放进去，然后比较之后的元素，如果遍历到的新元素比ends数组中的首元素小的话，替换首元素为此新元素，如果遍历到的新元素比ends数组中的末尾元素还大的话，将此新元素添加到ends数组末尾(注意不覆盖原末尾元素)。如果遍历到的新元素比ends数组首元素大，比尾元素小时，此时用二分查找法找到第一个不小于此新元素的位置，覆盖掉位置的原来的数字，以此类推直至遍历完整个nums数组，此时ends数组的长度就是我们要求的LIS的长度，特别注意的是ends数组的值可能不是一个真实的LIS，比如若输入数组nums为{4, 2， 4， 5， 3， 7}，那么算完后的ends数组为{2， 3， 5， 7}，可以发现它不是一个原数组的LIS，只是长度相等而已，千万要注意这点。参见代码如下：


    https://segmentfault.com/a/1190000003819886 (讲解比较清晰，但是在Binary Search的时候，应该找的是 first number >= target而不是> target)
    
    */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
    
        // subproblem
        int[] dp = new int[n];
        
        // init
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = nums[0];      // make the dp to be [nums[0], max, ... , max] so it will be easy to do binary search
        
        for (int i = 1; i < n; i++) {
            int idx = binarySearch(dp, nums[i]);  // the first index which has nums[idx] > nums[i]
            dp[idx] = nums[i];
        }
        
        for (int j = n - 1; j >= 0; j--) {
            if (dp[j] != Integer.MAX_VALUE) return j + 1;
        }
        return 0;
    }
    
    // find the first number >= target
    private int binarySearch(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (nums[lo] >= target) return lo;
        return hi;
    }
}
