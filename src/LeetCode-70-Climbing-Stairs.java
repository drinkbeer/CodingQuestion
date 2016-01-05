/*
LeetCode: https://leetcode.com/problems/climbing-stairs/
LintCode: http://www.lintcode.com/problem/climbing-stairs/
JiuZhang: http://www.jiuzhang.com/solutions/climbing-stairs/
ProgramCreek: 

Analysis: 

*/
public class Solution {
    public int climbStairs(int n) {
        // if(n <= 2) return n;
        // return climbStairs(n - 1) + climbStairs(n - 2);
        
        int[] arr = {0, 1, 2};
        if(n <= 2) return arr[n];
        
        int j = 2;
        while(true){
            j++;
            arr[j % 3] = arr[(j + 1) % 3] + arr[(j + 2) % 3];
            if(j == n) return arr[j % 3];
        }
    }
}