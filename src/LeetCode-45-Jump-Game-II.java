/*
LeetCode: https://leetcode.com/problems/jump-game-ii/
LintCode: http://www.lintcode.com/problem/jump-game-ii/
JiuZhang: http://www.jiuzhang.com/solutions/jump-game-ii/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-jump-game-ii-java/
Other: http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html

Analysis:
1.DP
TLE

2.Greedy(From JiuZhang)
Scan from 0 to end, and the scanning process is divided into severl phases -- [start, end]
In each [start, end], and farthest place could reach. Farthest is new end, oldEnd + 1 is new start.
Loop the above step until end reach nums.length-1.

3.Greedy(From ProgramCreek)
This is the same as Greedy2. But it's more difficult to understand.
Scan from 0 to end, the scanning process is divided into several phases -- [lastReach, newReach]
In each [lastReach, newReach], get the farthest could be reached. Farthest is a new newReach, lastReach is newReach+1
Loop the above step until newReach reach nums.length-1
*/
public class Solution {
    
    // 1.Dynamic Programming
    // Time Limit Exceeded 
    // public int jump(int[] nums) {
    //     if(nums == null || nums.length == 0) return 0;
        
    //     int[] steps = new int[nums.length];
    //     steps[0] = nums[0];
        
    //     for(int i = 1; i < nums.length; i++){
    //         for(int j = 0; j < i; j++){
    //             if(j + nums[j] > i) steps[i] = steps[j] + 1;
    //         }
    //     }
        
    //     return steps[nums.length - 1];
    // }
    
    // 2.Greedy (I think is the best solution)
    // public int jump(int[] nums) {
    //     if(nums == null || nums.length == 0) return 0;
        
    //     int start = 0, end = 0, steps = 0;
        
    //     while(end < nums.length - 1){
    //         steps++;
    //         int farthest = end;
    //         for(int i = start; i <= end; i++){
    //             farthest = Math.max(farthest, i + nums[i]);
    //         }
    //         start = end + 1;
    //         end = farthest;
    //     }
        
    //     return steps;
    // }
    
    // 3.Greedy
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int steps = 0;
        int max = nums[0];  // the max pace could be reached in curr phase
        int reach = 0;      // the max pace could be reached in last phase
        
        for(int i = 0; i < nums.length; i++){
            if(i > max) return 0;
            
            // start a new phase
            if(i > reach){
                steps++;
                reach = max;
            }
            
            // calculate max pace could be reached in every loop of curr phase
            max = Math.max(max, i + nums[i]);
        }
        return steps;
    }
}