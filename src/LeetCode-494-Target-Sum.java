/*
1.DFS

2.DP (Pull)

3.DP (Push)

4.DP (convert to subset problem & Pull)

5.DP (convert to subset problem & Push)

*/
class Solution {
    // 1.DFS
    /*
    Time O(2^N)
    */
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
//         int[] res = new int[1];
//         DFS(nums, 0, S, res);
//         return res[0];
//     }

//     private void DFS(int[] nums, int idx, int S, int[] res) {
//         if (idx == nums.length) {
//             if (S == 0) res[0]++;
//             return;
//         }
        
//         DFS(nums, idx + 1, S + nums[idx], res);
//         DFS(nums, idx + 1, S - nums[idx], res);
//     }
    
    // 2. DP (Knacpsack problem) (pull from previous level)
    /*
    this is a classic knapsack problem
    in knapsack, we decide whether we choose this element or not
    in this question, we decide whether we add this element or minus it

    So start with a two dimensional array dp[i][j] which means the number of ways for first i-th element to reach a sum j

    we can easily observe that dp[i][j] = dp[i-1][j+nums[i]] + dp[i-1][j-nums[i],

    Another part which is quite confusing is return value, here we return dp[sum+S], why is that?
    because dp's range starts from -sum --> 0 --> +sum
    so we need to add sum first, then the total starts from 0, then we add S

    Actually most of Sum problems can be treated as knapsack problem, hope it helps
    */
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
    
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         if (S < -sum || S > sum) return 0;
        
//         /*
//         DP (pull)
        
//         sub problem:
//         int[][] state = new int[n + 1][2 * sum + 1];
//             -  state[i][j] means number of ways to sum to j using nums[0-i]
//         but the j could range from [-sum, sum], so total possible sum is 2*sum+1
        
//         sum value:      -sum    -  0    -  sum
//         index value:    0       -   sum -   2*sum
        
//         init:
//         state[0][sum] = 1;    // i==0 means it's empty set, so the sum value is 0, and we don't choose anything
        
//         output:
//         state[n][sum+S]
        
//         recurrence relation:
//         state[i][j] += state[i - 1][j + nums[i - 1]] if (j+nums[i - 1]) <= 2*sum
//         state[i][j] += state[i - 1][j - nums[i - 1]] if (j-nums[i - 1]) >= to 0
        
        
//         Time: O(N*sum) - N is number of elements, sum is the sum of elements
//         Space: O(N*sum)
        
//         */
//         int[][] state = new int[n + 1][2 * sum + 1];
        
//         // Init the state[0][sum] to be 1. sum means total value is 0, so if we select nothing, this is the only approach to get total value to be 1
//         state[0][sum] = 1;
        
//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j < 2 * sum + 1; j++) {
//                 if (j + nums[i - 1] <= 2 * sum) state[i][j] += state[i - 1][j + nums[i - 1]];
//                 if (j - nums[i - 1] >= 0) state[i][j] += state[i - 1][j - nums[i - 1]];
//             }
//         }
        
//         return state[n][sum + S];
//     }
    
    
    // DP (push to next level)
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
    
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         if (S < -sum || S > sum) return 0;
        
//         /*
//         DP (pull)
        
//         sub problem:
//         state[i][j] means number of ways to sum to j using nums[0-i]
        
//         sum value:      -sum    -  0    -  sum
//         index value:    0       -   sum -   2*sum
        
//         init:
//         state[0][sum] = 1;
        
//         output:
//         state[n][sum+S]
        
//         recurrence relation:
//         state[i][j] += state[i + 1][j + nums[i]] if (j+nums[i - 1]) <= 2*sum
//         state[i][j] += state[i + 1][j - nums[i]] if (j-nums[i - 1]) >= to 0
        
        
//         Time: O(N*sum) - N is number of elements, sum is the sum of elements
//         Space: O(N*sum)
        
//         */
//         int[][] state = new int[n + 1][2 * sum + 1];
        
//         // Init the state[0][sum] to be 1. sum means total value is 0, so if we select nothing, this is the only approach to get total value to be 1
//         state[0][sum] = 1;
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < 2 * sum + 1; j++) {
//                 if (j + nums[i] <= 2 * sum) state[i + 1][j] += state[i][j + nums[i]];
//                 if (j - nums[i] >= 0) state[i + 1][j] += state[i][j - nums[i]];
//             }
//         }
        
//         return state[n][sum + S];
//     }
    
    // 3.Optimized DP for space. Using one dimention array
    /*
    
    Time O(N*sum)
    Space O(sum)
    */
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
    
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         if (S < -sum || S > sum) return 0;
    
//         int[] dp = new int[2 * sum + 1];
//         dp[sum] = 1;
        
//         for (int i = 1; i <= n; i++) {
//             int[] tempDp = new int[2 * sum + 1];
//             for (int j = 0; j <= 2 * sum; j++) {
//                 if (j + nums[i - 1] <= 2 * sum) {
//                     tempDp[j] += dp[j + nums[i - 1]];
//                 }
//                 if (j - nums[i - 1] >= 0) {
//                     tempDp[j] += dp[j - nums[i - 1]];
//                 }
//             }
//             dp = tempDp;
//         }
        
//         return dp[sum + S];
//     }
    
    // 4. DP (subset & pull & 2D array)
    /*
    Split the array to be two parts, 
    Let P denotes a subset of nums have a + in front of it
    Let N denotes a subset of nums have a - in front of it
    
    P ∪ N = {a1, a2, ..., an}, P ∩ N = ∅
    
    sum(P) - sum(N) = target
    sum(P) - sum(N) + sum(P) + sum(N) = target + sum(P) + sum(N)
    2 * sum(p) = target + sum(P) + sum(N)    <-   Knapsack problem (find a subset has sum value equals to a special target)
    
    subproblem:
    dp[i][j]  -   the number of ways to nums[0 - i] elements or its subset to get sum to be j
    
    recurrence relation:
    dp[i][j] = dp[i-1][j] + dp[i-1][j - nums[i]] if j - nums[i] >= 0
    
    init:
    dp[0][sum] = 1
    
    ans:
    S = (S + sum) / 2       // update the new target
    dp[n][S]
    */
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
    
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         if (S < -sum || S > sum) return 0;
//         if ((S + sum) % 2 != 0) return 0;           // means we cannot fnid a subset P, which has 2 * sum(P) = target + sum, here target + sum must be even
//         S = (S + sum) / 2;
        
//         int[][] dp = new int[n + 1][sum + 1];       // means using [0, i] elements or its subset to get a sum to be j
        
//         dp[0][0] = 1;
        
//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j <= sum; j++) {
//                 dp[i][j] = dp[i - 1][j];
//                 if (j - nums[i - 1] >= 0) {
//                     dp[i][j] += dp[i - 1][j - nums[i - 1]];
//                 }
//             }
            
//             // System.out.println(Arrays.deepToString(dp));
//         }
//         return dp[n][S];
//     }
    
    // DP: Subset & Optimized to use One-Dimension array & Pull  (One of the best solution)
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
    
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         if (S < -sum || S > sum) return 0;
//         if ((S + sum) % 2 != 0) return 0;           // means we cannot fnid a subset P, which has 2 * sum(P) = target + sum, here target + sum must be even
//         S = (S + sum) / 2;
    
//         // subproblem: 
//         int[] dp = new int[sum + 1];
        
//         // init
//         dp[0] = 1;
        
//         // recurrence relation
//         for (int i = 1; i <= n; i++) {
//             for (int j = sum; j >= nums[i - 1]; j--) {
//                 if (j - nums[i - 1] >= 0) {
//                     dp[j] += dp[j - nums[i - 1]];
//                 }
//             }
//         }
        
//         // res
//         return dp[S];
//     }
    
    // DP (Pull && Subset problem && Optimized the Space)
     public int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0) return 0;
    
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        
        if (S < -sum || S > sum) return 0;
        if ((S + sum) % 2 != 0) return 0;           // means we cannot fnid a subset P, which has 2 * sum(P) = target + sum, here target + sum must be even
        S = (S + sum) / 2;
    
        // subproblem: 
        int[] dp = new int[S + 1];      // Optimized here, only need S
        
        // init
        dp[0] = 1;
        
        // recurrence relation
        for (int i = 1; i <= n; i++) {
            for (int j = S; j >= nums[i - 1]; j--) {
                if (j - nums[i - 1] >= 0) {
                    dp[j] += dp[j - nums[i - 1]];
                }
            }
        }
        
        // res
        return dp[S];
    }
    
    // 5. DP (subset & push & 2D array)
    /*
    subproblem:
    dp[i][j]    -       the sum of nums [0, i] or its subset is equal to j
    
    recurrence relation:
    dp[i + 1][j] += dp[i][j]
    dp[i + 1][j + nums[i + 1]] += dp[i][j]        // didn't select nums[i]
    
    */
//     public int findTargetSumWays(int[] nums, int S) {
//         if (nums == null || nums.length == 0) return 0;
    
//         int n = nums.length;
//         int sum = 0;
//         for (int num : nums) sum += num;
        
//         if (S < -sum || S > sum) return 0;
//         if ((S + sum) % 2 != 0) return 0;
        
//         S = (S + sum) / 2;  // update new specific target
    
//         // subproblem: the sum of nums [0, i] or its subset is equal to j
//         int[][] dp = new int[n + 1][sum + 1];
        
//         // init
//         dp[0][0] = 1;
        
//         // recurrence relation
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j <= sum; j++) {
//                 dp[i + 1][j] += dp[i][j];
//                 if (j + nums[i] <= sum) {
//                     dp[i + 1][j + nums[i]] += dp[i][j];
//                 }
//             }
//         }
        
//         // ans
//         return dp[n][S];
//     }
}
