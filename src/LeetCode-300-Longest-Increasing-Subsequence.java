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
    
    // 1. DP (pull)
    /*
    subproblem:
    dp[i]   -   the max Len til ith number in nums array
    
    recurrence relation:
    dp[i] = dp[j] + 1, dp[j] is max within dp[0, i - 1], nums[i] > nums[j]
    
    init:
    dp[0] = 1   only one element, so it must be increasing
    
    Time O(N^2)
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
//                 if (nums[j] < nums[i]) {
//                     dp[i] = Math.max(dp[i], dp[j] + 1);
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
    Time O(NlogN)
    
    Example: 
    [1,3,5,2,8,4,6], 当到6时，我们一共可以有四种
        (1)不同长度
        (2)且保证该升序序列在同长度升序序列中末尾最小
    的升序序列:
    
    1
    1,2
    1,3,4
    1,3,5,6
    
    这些序列都是未来有可能成为最长序列的候选人。这样，每来一个新的数，我们便按照以下规则更新这些序列:
    
    (1) 如果nums[i]比所有序列的末尾都大，或等于最大末尾，说明有一个新的不同长度序列产生，我们把最长的序列复制一个，并加上这个nums[i]。
    (2) 如果nums[i]比所有序列的末尾都小，说明长度为1的序列可以更新了，更新为这个更小的末尾。
    (3) 如果在中间，则更新那个末尾数字刚刚大于等于自己的那个序列，说明那个长度的序列可以更新了。
    
    比如这时，如果再来一个9，那就是第三种情况，更新序列为

    1
    1,2
    1,3,4
    1,3,5,6
    1,3,5,6,9

    如果再来一个3，那就是第二种情况，更新序列为
    1
    1,2
    1,3,3
    1,3,5,6
    
    如果再来一个0，那就是第一种情况，更新序列为
    0
    1,2
    1,3,3
    1,3,5,6


    前两种都很好处理，O(1)就能解决，主要是第三种情况，实际上我们观察直到6之前这四个不同长度的升序序列，他们末尾是递增的，所以可以用二分搜索来找到适合的更新位置。
    
    
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
