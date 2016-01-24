/*
LeetCode:  https://leetcode.com/problems/3sum-smaller/
LintCode:  not find
JiuZhang:  not find
ProgramCreek:  not find

Analysis:  No need to filter duplicates
重复的解答都要计算在内, 比如说:
[0, 1, 1, 1], target = 3, 这样算3个解答 [index[0] , index[1], index[2]]   [index[0], index[1], index[3]] [index[0], index[2], index[3]]
*/
public class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        if(nums == null || nums.length < 3) return 0;
        int count = 0;
        
        java.util.Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            // if(i > 0 && nums[i] == nums[i - 1])continue;
            
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                
                if(sum < target){
                    count += hi - lo;   //for all hi in (lo, hi] satisfy the condition
                    lo++;
                    // hi--;
                    
                    // while(lo < hi && nums[lo] == nums[lo - 1]) lo++;
                    // while(lo < hi && nums[hi] == nums[hi + 1]) hi--;
                }else{
                    hi--;
                }
            }
        }
        
        return count;
    }
}