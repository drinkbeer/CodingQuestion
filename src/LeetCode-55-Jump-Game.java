/*
LeetCode: https://leetcode.com/problems/jump-game/
LintCode: http://www.lintcode.com/problem/jump-game/
JiuZhang: http://www.jiuzhang.com/solutions/jump-game/
ProgramCreek: http://www.programcreek.com/2014/03/leetcode-jump-game-java/

Analysis:
DP will exceed time limit.
Greedy also must optimize carefully.
*/
public class Solution {
    
    // 1.Dynamic Programming
    // Time Limit Exceeded
    // public boolean canJump(int[] nums) {
    //     if(nums == null || nums.length == 0) return false;
    //     boolean[] state = new boolean[nums.length];
    //     state[0] = true;
        
    //     for(int i = 1; i < nums.length; i++){
    //         for(int j = 0; j < i; j++){
    //             if(state[j] && j + nums[j] >= i) {
    //                 state[i] = true;
    //                 break;      //optimize: here we must break as soon as we can jump from this j to i
    //             }
    //         }
    //     }
    //     return state[nums.length - 1];
    // }
    
    // 2.Greedy
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        if(nums.length <= 1) return true;
        
        int max = nums[0];
        for(int i = 0; i < nums.length; i++){
            if(max <= i && nums[i] == 0) return false;
            
            max = Math.max(max, i + nums[i]);
            
            if(max >= nums.length - 1) return true;
        }
        return false;
    }
}