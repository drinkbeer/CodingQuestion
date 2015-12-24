/*
LeetCode: https://leetcode.com/problems/jump-game/
LintCode: http://www.lintcode.com/problem/jump-game/
JiuZhang: http://www.jiuzhang.com/solutions/jump-game/
ProgramCreek: http://www.programcreek.com/2014/03/leetcode-jump-game-java/

Analysis:
1.DP will exceed time limit.
2.DP looks like greedy
3.Greedy also must optimize carefully.
4.Greedy(better)
Scan from 0 to nums.length-1
Divide the scanning process into different phase -- [start, end]
Get the farthest pace could be reached in curr phase. 
The start of new phase is end+1 of last phase, end is farthest of last phase.
*/
public class Solution {
    
    // 1.Dynamic Programming
    // Time Limit Exceeded
    // public boolean canJump(int[] nums) {
    //     if(nums == null || nums.length == 0) return false;
    //     if(nums.length <= 1) return true;
        
        // means if curr pace can be reached
    //     boolean[] state = new boolean[nums.length];
    //     state[0] = true;
        
    //     for(int i = 1; i < nums.length; i++){
    //         for(int j = 0; j < i; j++){
    //             if(state[j] && j + nums[j] >= i) {
    //                 state[i] = true;
    //                 break;       //optimize: here we must break as soon as we can jump from this j to i
    //             }
    //         }
    //     }
        
    //     return state[nums.length - 1];
        
    // }
    
    // 2.Dynamic Programming
    // public boolean canJump(int[] nums) {
    //     if (nums == null || nums.length == 0) return false;
    //     if (nums.length == 1) return true;
        
    //     // state: means the max pace can be covered
    //     int[] state = new int[nums.length];
    //     // init state
    //     state[0] = nums[0];
        
    //     for(int i = 1; i < nums.length; i++){
    //         if(i > state[i - 1]) return false;
            
    //         state[i] = Math.max(state[i - 1], i + nums[i]);
            
    //         if(state[i] >= nums.length - 1) return true;
    //     }
        
    //     return true;
    // }
    
    // 3.Greedy
    // public boolean canJump(int[] nums) {
    //     if(nums == null || nums.length == 0) return false;
    //     if(nums.length == 1) return true;
        
    //     int max = nums[0];
        
    //     for(int i = 1; i < nums.length; i++){
    //         if(max < i) return false;
            
    //         max = Math.max(max, i + nums[i]);
            
    //         if(max >= nums.length - 1) return true;
    //     }
    //     return true;
    // }
    
    // 4.Greedy
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        
        int start = 0, end = 0;
        
        while(end < nums.length - 1){
            int farthest = 0;
            for(int i = start; i <= end; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }
            if(farthest <= end) return false;
            if(farthest >= nums.length - 1) return true;
            start = end + 1; 
            end = farthest;
        }
        
        return true;
    }
    
    
    
}