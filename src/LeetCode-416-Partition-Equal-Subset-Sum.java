class Solution {
    // Wrong Answer
    /*
    [3,3,3,4,5]
    This case doesn't work.
    */
//     public boolean canPartition(int[] nums) {
//         Arrays.sort(nums);
//         int s1 = 0, s2 = 0;
//         for (int i = nums.length - 1; i >= 0; i--) {
//             if (s1 <= s2) {
//                 s1 += nums[i];
//             } else {
//                 s2 += nums[i];
//             }
//         }
        
//         return s1 == s2;
//     }
    
    // 1. Recursive DFS without Memorization Optimization (TLE)
    /*
    https://leetcode.com/problems/partition-equal-subset-sum/discuss/90588/Concise-C%2B%2B-Solution-summary-with-DFS-DP-BIT
    
    DFS could be optimized by using memorized solution, and pass the OJ. See the above link.
    */
//     public boolean canPartition(int[] nums) {
//         int[] res = new int[2];
//         return recursive(nums, 0, res);
//     }
    
//     private boolean recursive(int[] nums, int i, int[] res) {
//         if (i == nums.length - 1) {
//             if (res[0] + nums[i] == res[1] || res[0] == res[1] + nums[i]) {
//                 return true;
//             } else {
//                 return false;
//             }
//         }
        
//         if (recursive(nums, i + 1, new int[] {res[0] + nums[i], res[1]}) || recursive(nums, i + 1, new int[] {res[0], res[1] + nums[i]})) {
//             return true;
//         }
//         return false;
//     }
    
    // 2. DP (Pull)
    /*
    Knacpack problem. We convert this problem to either add "+" or "-" in each element, and make the final sum to be 0.
    
    subproblem:
    dp[i][j]  - whether we could using the elements in [0, i] to get the sum j
    
    recurrence relation:
    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j + nums[i]]
    
    init:
    dp[0][sum] = true   // empty set, the sum value is 0, it's true
    sum:    -sum    0       sum
    idx:    0       sum     2*sum
    
    ans:
    return dp[n][sum]
    */
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         // subproblem
//         boolean[][] dp = new boolean[n + 1][2*sum + 1];
        
//         // init
//         dp[0][sum] = true;
//         // dp[0][sum + nums[0]] = true;
        
//         // recurrence relation
//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j <= 2 * sum; j++) {
//                 if (j - nums[i - 1] >= 0) {
//                     dp[i][j] |= dp[i - 1][j - nums[i - 1]];
//                 }
//                 if (j + nums[i - 1] <= 2 * sum) {
//                     dp[i][j] |= dp[i - 1][j + nums[i - 1]];
//                 }
//             }
//         }
        
//         return dp[n][sum];
//     }
    
    // 2. DP (Push)
    /*
    Knacpack problem. We convert this problem to either add "+" or "-" in each element, and make the final sum to be 0.
    
    subproblem:
    dp[i][j]  - whether we could using the elements in [0, i] to get the sum j
    
    recurrence relation:
    dp[i][j] = dp[i][j - nums[i]] || dp[i][j + nums[i]]
    
    init:
    dp[0][sum] = true
    sum:    -sum    0       sum
    idx:    0       sum     2*sum
    
    ans:
    return dp[n][sum]
    */
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         // subproblem
//         boolean[][] dp = new boolean[n + 1][2*sum + 1];
        
//         // init
//         dp[0][sum] = true;
//         // dp[0][sum + nums[0]] = true;
        
//         // recurrence relation
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j <= 2 * sum; j++) {
//                 if (dp[i][j]) {
//                     if (j - nums[i] >= 0) {
//                         dp[i + 1][j - nums[i]] = true;
//                     }
//                     if (j + nums[i] <= 2 * sum) {
//                         dp[i + 1][j + nums[i]] = true;
//                     }
//                 }
                
//             }
//         }
        
//         return dp[n][sum];
//     }
    
    // 3. DP (Pull && 1D array)
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;
        
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         boolean[] dp = new boolean[2 * sum + 1];
        
//         // init
//         dp[sum] = true;
        
//         // recurrence relation
//         for (int i = 1; i <= n; i++) {
//             boolean[] tempDP = new boolean[2 * sum + 1];
//             for (int j = 0; j <= 2 * sum; j++) {
//                 if (j - nums[i - 1] >= 0) {
//                     tempDP[j] |= dp[j - nums[i - 1]];
//                 }
//                 if (j + nums[i - 1] <= 2 * sum) {
//                     tempDP[j] |= dp[j + nums[i - 1]];
//                 }
//             }
//             dp = tempDP;
//         }
        
//         return dp[sum];
//     }
    
    // 4. DP (Subset & Pull & 2D Array)
    /*
    Split the array to two parts:
    Let P denotes a subset of nums have a + in front of it
    Let N denotes a subset of nums have a - in front of it
    
    P ∪ N = {a1, a2, ..., an}, P ∩ N = ∅
    
    sum(P) + sum(N) = sum
    sum(P) - sum(N) = 0
    
    sum(P) = sum / 2;
    
    so the problem becomes find a subset with sum to be sum / 2;
    
    subproblem:
    dp[j]   -   if it's possible to get sum j using the elements before ith
    */
//     public boolean canPartition(int[] nums) {
//         int n = nums.length;
        
//         int sum = 0;
//         for (int num : nums) sum += num;
//         if (sum % 2 != 0) return false;
//         sum = sum / 2;
        
//         boolean[] dp = new boolean[sum + 1];
        
//         // init
//         dp[0] = true;   // in empty set, the sum to be 0 is true
        
//         for (int i = 1; i <= n; i++) {
//             boolean[] tempDP = new boolean[sum + 1];
            
//             for (int j = 0; j <= sum; j++) {
//                 tempDP[j] |= dp[j]; // not plus nums[i - 1]
//                 if (j - nums[i - 1] >= 0) {
//                     // plus nums[i - 1]
//                     tempDP[j] |= dp[j - nums[i - 1]];
//                 }
//             }
//             dp = tempDP;
//         }
        
//         return dp[sum];
//     }
    
    // DP (Subset & Pull & 2D Array) - further optimized by not using a copy array
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        
        boolean[] dp = new boolean[sum + 1];
        
        // init
        dp[0] = true;   // in empty set, the sum to be 0 is true
        
        for (int i = 1; i <= n; i++) {
            for (int j = sum; j >= 0; j--) {
                if (j - nums[i - 1] >= 0) {
                    // plus nums[i - 1] from the previous j - nums[i - 1]
                    dp[j] |= dp[j - nums[i - 1]];
                }
            }
        }
        
        return dp[sum];
    }
}
