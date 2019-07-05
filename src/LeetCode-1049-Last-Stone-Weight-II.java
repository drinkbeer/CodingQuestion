/*
Similar to: https://leetcode.com/problems/target-sum/


这题实际上就是在每个element前面加 +，-，然后求和。如果最后的和是负，那我们可以等价转换成整数，比如：
            [1,2,3]
            
            [-1,2,-3], sum -2, could be convert to:
            [1,-2,3], sum +2

所以我们就减少了一半的运算。



*/
class Solution {
    // 1.DFS without optimization (TLE)
    /*
    Adding + or - to each number, and get the value to be minimum.
    */
//     int min = Integer.MAX_VALUE;
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
//         /*
//         1 <= stones.length <= 30
//         1 <= stones[i] <= 100
        
//         sum     -3000   -   0       -   3000
//         index   0       -   3000    -   6000
        
//         subproblem:
//         mem[i][j]   -       means number of sum answers, using the nums [0, i] and add +,- to the element, and get the number of different sum
//         */
//         DFS(stones, 0, 0);
//         return min;
//     }
    
//     private void DFS(int[] stones, int idx, int sum) {
//         if (idx == stones.length) {
//             if (sum >= 0) {
//                 min = Math.min(min, sum);
//             }
//             return;
//         }
        
//         DFS(stones, idx + 1, sum + stones[idx]);
//         DFS(stones, idx + 1, sum - stones[idx]);
//     }
    
    // 2.DFS with optimization (using memorized array)
    /*
    https://leetcode.com/problems/last-stone-weight-ii/discuss/313051/Simple-Java-DFS%2BMemoization-Solution-Knapsacktarget-sum
    
    */
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
//         /*
//         1 <= stones.length <= 30
//         1 <= stones[i] <= 100
        
//         sum     -3000   -   0       -   3000
//         index   0       -   3000    -   6000
        
//         subproblem:
//         mem[i][j]   -       means the minimum lost weight of the nums [0, i] and add +,- to the elements
//         */
//         Integer[][] mem = new Integer[n + 1][6001];
//         return DFS(stones, 0, 0, mem);
//     }
    
//     private int DFS(int[] stones, int idx, int sum, Integer[][] mem) {
//         if (idx == stones.length) {
//             /*
//             the weight left must be negative
            
//             [1,2,3]
            
//             [-1,2,-3], sum -2, could be convert to:
//             [1,-2,3], sum +2
//             */
//             return Math.abs(sum);
//         }

//         int t = sum + 3000;     // making the sum + offset to get the real index
//         if (mem[idx][t] != null) return mem[idx][t];        // optimization
        
//         mem[idx][t] = Math.min(DFS(stones, idx + 1, sum + stones[idx], mem), DFS(stones, idx + 1, sum - stones[idx], mem));
        
//         return mem[idx][t];
//     }
    
    // 3.DP (pull, my own solution)
    /*
    
    subproblem:
    dp[i][j]    -   minimum weight by calculating the sum of nums [0, i], with adding +,- in front of each element
    
    recurrence relation:
    
    for (int i = 1; i <= n; i++) {
        for (k = 0; k <= sum; k++) {
            if (dp[i - 1][k] != Integer.MAX_VALUE) {
                int sumPlus = Math.abs(dp[i - 1][k] + stones[k - 1]);
                dp[i][sumPlus] = Math.min(dp[i][sumPlus], sumPlus);

                int sumMinus = Math.abs(dp[i - 1][k] - stones[k - 1]);
                dp[i][sumMinus] = Math.min(dp[i][sumMinus], sumMinus);
            }

        }
    }
    
    init
    d[0][0-sum] = Integer.MAX_VALUE
    
    ans
    min positive (d[[0][0-sum]])
    
    Time Complexity O(N*sum) - N is number of elements in array, sum is sum of all elements
    Space: O(N*sum)
    
    Runtime: 2 ms, faster than 73.85% of Java online submissions for Last Stone Weight II.
    Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Last Stone Weight II.
    */
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
        
//         int sum = 0;
//         for (int i : stones) sum += i;
        
//         // subproblem: dp[i][j] means the minimum lost weight by calculating the sum of nums [0, i], with +,- in front of each element
//         int[][] dp = new int[n + 1][sum + 1];
        
//         // init
//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j <= sum; j++) {
//                 dp[i][j] = Integer.MAX_VALUE;
//             }
//         }
//         dp[1][stones[0]] = stones[0];
        
//         // recurrence relation
//         for (int i = 2; i <= n; i++) {
//             for (int j = 0; j <= sum; j++) {
//                 if (dp[i - 1][j] != Integer.MAX_VALUE) {
//                     int sumPlus = Math.abs(dp[i - 1][j] + stones[i - 1]);
//                     dp[i][sumPlus] = Math.min(dp[i][sumPlus], sumPlus);
                    
//                     int sumMinus = Math.abs(dp[i - 1][j] - stones[i - 1]);
//                     dp[i][sumMinus] = Math.min(dp[i][sumMinus], sumMinus);
//                 }
//             }
//         }
        
//         int min = Integer.MAX_VALUE;
//         for (int j = 0; j <= sum; j++) {
//             min = Math.min(min, dp[n][j]);
//         }
//         return min;
//     }
    
    // 3.DP (push, my own solution)
    /*
    Runtime: 2 ms, faster than 73.85% of Java online submissions for Last Stone Weight II.
    Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for Last Stone Weight II.
    */
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
        
//         int sum = 0;
//         for (int i : stones) sum += i;
        
//         // subproblem: dp[i][j] means the minimum lost weight by calculating the sum of stones [0, i], with +,- in front of each element
//         int[][] dp = new int[n + 1][sum + 1];
        
//         // initialize
//         for (int i = 0; i <= n; i++) {
//             for (int j = 0; j <= sum; j++) {
//                 dp[i][j] = Integer.MAX_VALUE;
//             }
//         }
//         dp[1][stones[0]] = stones[0];
        
//         // recurrence relation
//         for (int i = 1; i <= n - 1; i++) {
//             for (int j = 0; j <= sum; j++) {
//                 if (dp[i][j] != Integer.MAX_VALUE) {
//                     int sumPlus = Math.abs(dp[i][j] + stones[i]);
//                     dp[i + 1][sumPlus] = Math.min(dp[i + 1][sumPlus], sumPlus);
                    
//                     int sumMinus = Math.abs(dp[i][j] - stones[i]);
//                     dp[i + 1][sumMinus] = Math.min(dp[i + 1][sumMinus], sumMinus);
//                 }
//             }
//         }
        
//         int min = Integer.MAX_VALUE;
//         for (int j = 0; j <= sum; j++) {
//             min = Math.min(min, dp[n][j]);
//         }
//         return min;
//     }
    
    // DP (pull && Optimized using Boolean)
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
        
//         int sum = 0;
//         for (int i : stones) sum += i;
        
//         // subproblem: dp[i][j] means using the elements stones [0, i], with adding +,- in front of each element, we could sum up to j (true if we could, false if we could not)
//         boolean[][] dp = new boolean[n + 1][sum + 1];
        
//         // init
//         dp[0][0] = true;
        
//         // recurrence relation
//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j <= sum; j++) {
//                 if (dp[i - 1][j]) {
//                     int sumPlus = Math.abs(j + stones[i - 1]);
//                     dp[i][sumPlus] |= dp[i - 1][j];
                    
//                     int sumMinus = Math.abs(j - stones[i - 1]);
//                     dp[i][sumMinus] |= dp[i - 1][j];
//                 }
//             }
//         }
        
//         // ans
//         for (int j = 0; j <= sum; j++) {
//             if (dp[n][j]) return j;
//         }
//         return -1;
//     }
    
//     // DP: Pull & Optimized using boolean & Using one dimension array
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
        
//         int sum = 0;
//         for (int i : stones) sum += i;
        
//         // subproblem: dp[j] means using the elements stones [0, i], with adding +,- in front of each element, we could sum up to j (true if we could, false if we could not)
//         boolean[] dp = new boolean[sum + 1];
        
//         // init
//         dp[0] = true;
        
//         // recurrence relation
//         for (int i = 1; i <= n; i++) {
//             boolean[] temp = new boolean[sum + 1];
//             for (int j = 0; j <= sum; j++) {
//                 if (dp[j]) {
//                     int sumPlus = Math.abs(j + stones[i - 1]);
//                     temp[sumPlus] |= dp[j];
                    
//                     int sumMinus = Math.abs(j - stones[i - 1]);
//                     temp[sumMinus] |= dp[j];
//                 }
//             }
//             dp = temp;
//         }
        
//         // ans
//         for (int j = 0; j <= sum; j++) {
//             if (dp[j]) return j;
//         }
//         return -1;
//     }
    
//     // Push (Optimized using boolean)
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
        
//         int sum = 0;
//         for (int i : stones) sum += i;
        
//         // subproblem: dp[i][j] means using the elements stones [0, i], with adding +,- in front of each element, we could sum up to j (true if we could, false if we could not)
//         boolean[][] dp = new boolean[n + 1][sum + 1];
        
//         // init
//         dp[0][0] = true;
        
//         // recurrence relation
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j <= sum; j++) {
//                 if (dp[i][j]) {
//                     int sumPlus = Math.abs(j + stones[i]);
//                     dp[i + 1][sumPlus] = true;
                    
//                     int sumMinus = Math.abs(j - stones[i]);
//                     dp[i + 1][sumMinus] = true;
//                 }
//             }
//         }
        
//         // ans
//         for (int j = 0; j <= sum; j++) {
//             if (dp[n][j]) return j;
//         }
//         return -1;
//     }
    
    
    //Push (Optimized using boolean && using 1-d array)
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
        
//         int sum = 0;
//         for (int i : stones) sum += i;
        
//         // subproblem: dp[j] means using the elements stones [0, i], with adding +,- in front of each element, we could sum up to j (true if we could, false if we could not)
//         boolean[] dp = new boolean[sum + 1];
        
//         // init
//         dp[0] = true;
        
//         // recurrence relation
//         for (int i = 0; i < n; i++) {
//             boolean[] temp = new boolean[sum + 1];
//             for (int j = 0; j <= sum; j++) {
//                 if (dp[j]) {
//                     int sumPlus = Math.abs(j + stones[i]);
//                     temp[sumPlus] = true;
                    
//                     int sumMinus = Math.abs(j - stones[i]);
//                     temp[sumMinus] = true;
//                 }
//             }
//             dp = temp;
//         }
        
//         // ans
//         for (int j = 0; j <= sum; j++) {
//             if (dp[j]) return j;
//         }
//         return -1;
//     }
    
    
    // 4. DP (Convert to subset problem)
    /*
    
    Use P to denote a subset, all elements add + in front of the elements
    Use N to denote a subset, all elements add - in front of the elements
    
    sum(P) - sum(N) = target (target is the minimum abs of positive or negative value, as a mentioned before negative sum could be equally convert to positive sum)
    sum(P) - sum(N) + sum(P) + sum(N) = target + sum(P) + sum(N)
    2 * sum(P) = target + sum   (target + sum must be an even number)
    so target = 2 * sum(P) - sum, making target to be minimuze abs positive or negative number
    
    We convert the problem to be find a subset, the sum is equal to (target + sum) / 2 to be minimum positive number. And the target is the returned value.
    
    subproblem:
    dp[i][j]    -       from the subset in nums [0,i], with adding +,- in front of each element, calculate the sum, which is j
    
    recurrence relation:
    dp[i][j] = dp[i - 1][j]
    dp[i][j] |= dp[i - 1][j - nums[i - 1]] if j - nums[i - 1] >= 0
    
    init:
    dp[0][0] = true
    
    ans:
    find the j that makes |2*j - sum| minimum, and return the minimum result
    */
//     public int lastStoneWeightII(int[] stones) {
//         int n = stones.length;
        
//         int sum = 0;
//         for (int i : stones) sum += i;
        
//         // subproblem: the sum of subset stones [0,j] with adding +,-, in front of each element, calculated sum is j
//         boolean[][] dp = new boolean[n + 1][sum + 1];
        
//         // init
//         dp[0][0] = true;
        
//         // recurrence relation
//         for (int i = 1; i <= n; i++) {
//             for (int j = 0; j <= sum; j++) {
//                 dp[i][j] = dp[i - 1][j];
//                 if (j - stones[i - 1] >= 0) {
//                     dp[i][j] |= dp[i - 1][j - stones[i - 1]];
//                 }
//             }
//         }
        
//         // ans
//         int minVal = Integer.MAX_VALUE;
//         for (int j = 0; j <= sum; j++) {
//             if (dp[n][j] && minVal > Math.abs(2 * j - sum)) {
//                 minVal = Math.abs(2 * j - sum);
//             }
//         }
        
//         return minVal;
//     }
    
    // DP (Subset && Optimized to use 1D array)
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        
        int sum = 0;
        for (int i : stones) sum += i;
        
        // subproblem: the sum of subset stones [0,j] with adding +,-, in front of each element, calculated sum is j
        boolean[] dp = new boolean[sum + 1];
        
        // init
        dp[0] = true;
        
        // recurrence relation
        for (int i = 1; i <= n; i++) {
            boolean[] temp = new boolean[sum + 1];
            for (int j = 0; j <= sum; j++) {
                temp[j] = dp[j];
                if (j - stones[i - 1] >= 0) {
                    temp[j] |= dp[j - stones[i - 1]];
                }
            }
            dp = temp;
        }
        
        // ans
        int minVal = Integer.MAX_VALUE;
        for (int j = 0; j <= sum; j++) {
            if (dp[j] && minVal > Math.abs(2 * j - sum)) {
                minVal = Math.abs(2 * j - sum);
            }
        }
        
        return minVal;
    }
    
    
}
