/*
LeetCode: https://leetcode.com/problems/3sum-closest/
LintCode: http://www.lintcode.com/en/problem/3sum-closest/
JiuZhang: http://blog.sina.com.cn/s/blog_eb52001d0102v2de.html
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-3sum-closest-java/

Analysis: 
Looks like 3Sum, but easier than 3Sum, as we don't need skip duplicates(as not need return List)
*/
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length < 3) return -1;
        
        int min = Integer.MAX_VALUE;
        int result = 0;
        
        java.util.Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int lo = i + 1, hi = nums.length - 1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum == target) return sum;
                
                int diff = Math.abs(sum - target);

                if(diff < min){
                    // update min and result
                    min = diff;
                    result = sum;
                }
                if(sum <= target) lo++;
                else hi--;
            }
        }
        
        return result;
    }
}
