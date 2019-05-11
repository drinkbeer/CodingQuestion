/*
LeetCode: https://leetcode.com/problems/container-with-most-water/
LintCode: http://www.lintcode.com/problem/container-with-most-water/
JiuZhang: http://www.jiuzhang.com/solutions/container-with-most-water/
ProgramCreek: http://www.programcreek.com/2014/03/leetcode-container-with-most-water-java/
*/
public class Solution {
    public int maxArea(int[] height) {
        int result = Integer.MIN_VALUE, l = 0, r = height.length - 1;
         while (l < r) {
             result = Math.max(result, Math.min(height[l], height[r]) * (r - l));
             // To get the possibility of having a bigger size, we have to move the smaller one
             if (height[l] < height[r]) {
                 l++;
             } else {
                 r--;
             }
         }
        return result;
    }
}
