/*
LeetCode: https://leetcode.com/problems/jump-game/
LintCode: http://www.lintcode.com/problem/jump-game/
JiuZhang: http://www.jiuzhang.com/solutions/jump-game/
ProgramCreek: http://www.programcreek.com/2014/03/leetcode-jump-game-java/
Analysis:

1.Dynamic Programming (Forward)

2. DP (backward)

3.DP looks like greedy

4.Greedy also must optimize carefully.

5.Greedy(better)

Scan from 0 to nums.length-1
Divide the scanning process into different phase -- [start, end]
Get the farthest pace could be reached in curr phase. 
The start of new phase is end+1 of last phase, end is farthest of last phase.
*/
class Solution {
    
    // 1.Dynamic Programming (Forward)
    // Space O(N)
    // Time O(N)
//     public boolean canJump(int[] nums) {
//         if(nums == null || nums.length == 0) return false;
//         if(nums.length <= 1) return true;
        
//         // means if curr pace can be reached
//         boolean[] dp = new boolean[nums.length];
//         dp[0] = true;
        
//         for(int i = 1; i < nums.length; i++){
//             for (int j = 0; j <= i; j++) {
//                 if (dp[j] && j + nums[j] >= i) {
//                     dp[i] = true;
//                     break;
//                 }
//             }
//         }
        
//         return dp[nums.length - 1];
//     }
    
    // 2. DP (backward)
    /* 
    very slow
    Runtime: 214 ms, faster than 19.91% of Java online submissions for Jump Game.
    Time O(N)
    Space O(N)
    */
//     public boolean canJump(int[] nums) {
//         if(nums == null || nums.length == 0) return false;
//         if(nums.length <= 1) return true;
        
//         // means if curr pace can be reached
//         boolean[] dp = new boolean[nums.length];
//         dp[0] = true;
        
//         for(int i = 0; i < nums.length; i++){
//             for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
//                 // means the jth block is reachable from ith, but we must ensure ith block itself is reachable.
//                 dp[j] = dp[i];
//             }
//         }
        
//         return dp[nums.length - 1];
//     }
    
    // 3.DP
//     public boolean canJump(int[] nums) {
//         if(nums == null || nums.length == 0) return false;
//         if(nums.length <= 1) return true;
        
//         // dp: means the max pace can be covered
//         int[] dp = new int[nums.length];
//         dp[0] = nums[0];
        
//         for (int i = 1; i < nums.length; i++) {
//             if (i > dp[i - 1]) return false;  // ensure i is reachable
//             dp[i] = Math.max(dp[i - 1], i + nums[i]);  // update dp matrix with the max place block i can reach
//             if (dp[i] >= nums.length - 1) return true;
//         }
        
//         return dp[nums.length - 1] >= nums.length - 1;
//     }
    
    // 4.Greedy
//     public boolean canJump(int[] nums) {
//         if(nums == null || nums.length == 0) return false;
//         if(nums.length <= 1) return true;
        
//         int max = nums[0];
        
//         for (int i = 1; i < nums.length; i++) {
//             if (i > max) return false;
//             max = Math.max(max, i + nums[i]);
//             if (max >= nums.length - 1) return true;
//         }
        
//         return max >= nums.length - 1;
//     }
    
    // 5. Greedy
    // Time O(N)
    // Space O(1)
    /*
    This one is super faster than the third solution, as it skipped a lot of calculation. This one should be the best solution I have ever saw.
    
    start is the start index, end is the end index of one step.
    
    each step go through the [start, end]
    
    end condition is:
    1.end >= nums.length - 1
    2.max <= end
    3.max >= nums.length - 1
    
    */
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        if(nums.length <= 1) return true;
        
        int start = 0, end = 0;
        while (end < nums.length - 1) {
            int max = end;
            for (int i = start; i <= end; i++) {
                max = Math.max(max, i + nums[i]);
            }
            
            // before proceed to next new [start, end], let's check the end condition.
            if (max <= end) return false; // means no step forward, we are blocking in current run
            if (max >= nums.length - 1) return true;
            
            // proceed to next new [start, end]
            start = end + 1;
            end = max;
        }
        
        return true;
    }
    
}
