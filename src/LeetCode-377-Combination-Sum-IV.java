class Solution {
    // 1. DP (Pull)
    /*
    https://leetcode.com/problems/combination-sum-iv/discuss/85036/1ms-Java-DP-Solution-with-Detailed-Explanation
    So we know that target is the sum of numbers in the array. Imagine we only need one more number to reach target, this number can be any one in the array, right? So the # of combinations of target, comb[target] = sum(comb[target - nums[i]]), where 0 <= i < nums.length, and target >= nums[i].

    In the example given, we can actually find the # of combinations of 4 with the # of combinations of 3(4 - 1), 2(4- 2) and 1(4 - 3). As a result, comb[4] = comb[4-1] + comb[4-2] + comb[4-3] = comb[3] + comb[2] + comb[1].

    Then think about the base case. Since if the target is 0, there is only one way to get zero, which is using 0, we can set comb[0] = 1.
    
    subproblem:
    dp[i]   -   the number of combinations sum up to i
    
    recurrence relation:
    dp[i] = sum{dp[i - nums[j]]}, j range [0, n - 1]
    
    */
//     public int combinationSum4(int[] nums, int target) {
//         int n = nums.length;
        
//         // subproblem
//         int[] dp = new int[target + 1];
        
//         // init
//         dp[0] = 1;
        
//         for (int i = 1; i <= target; i++) {
            
//             for (int j = 0; j < n; j++) {
//                 if (i - nums[j] >= 0) {
//                     dp[i] += dp[i - nums[j]];
//                 }
//             }
//         }
        
//         return dp[target];
//     }
    
    // 2. Recursive + HashMap
    public int combinationSum4(int[] nums, int target) {
        return helper(nums, target, new HashMap<Integer, Integer>());
    } 

    private int helper(int[] nums, int target, Map<Integer, Integer> map) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if (map.containsKey(target)) return map.get(target);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = helper(nums, target - nums[i], map);
            if (target >= nums[i]) map.put(target - nums[i], cnt);
            res += cnt;
        }
        return res;
    }    
}
