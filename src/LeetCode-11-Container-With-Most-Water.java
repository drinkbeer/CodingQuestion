/*
LeetCode: https://leetcode.com/problems/container-with-most-water/
LintCode: http://www.lintcode.com/problem/container-with-most-water/
JiuZhang: http://www.jiuzhang.com/solutions/container-with-most-water/
ProgramCreek: http://www.programcreek.com/2014/03/leetcode-container-with-most-water-java/
*/
public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length <2) return 0;
        
        int result = 0, left = 0;
        int right = height.length - 1;
        
        while(left < right){
            result = Math.max(result, (right - left) * Math.min(height[left], height[right]));
            if(height[left] < height[right]) left++;
            else right--;
        }
        return result;
    }
}