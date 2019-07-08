/*
https://leetcode.com/discuss/30020/java-o-n-solution-space-o-1
1.Use state matrix
Space   O(N)

2.Use two variable
Space   O(1)
*/
public class Solution {
    // 1.Use state matrix
    // public int rob(int[] nums) {
    //     if(nums == null || nums.length == 0) return 0;
        
    //     // state
    //     //in each row, state[i][0] is the max money not robber i, state[i][1] is max money that robber i
    //     int[][] state = new int[nums.length + 1][2];  
        
    //     // init state matrix
    //     state[0][0] = 0;
    //     state[0][1] = nums[0];
        
    //     for(int i = 1; i < nums.length; i++){
    //         state[i][0] = Math.max(state[i - 1][0], state[i - 1][1]);   // if not robber curr house
    //         state[i][1] = state[i - 1][0] + nums[i];
    //     }
        
    //     return Math.max(state[nums.length - 1][0], state[nums.length - 1][1]);
    // }
    
    // 2.Use two variable
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int prevNo = 0, prevYes = nums[0];
        for(int i = 1; i < nums.length; i++){
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = temp + nums[i];
        }
        
        return Math.max(prevNo, prevYes);
    }
}
