/*
LeetCode: https://leetcode.com/problems/unique-paths-ii/
LintCode: http://www.lintcode.com/problem/unique-paths-ii/
JiuZhang: http://www.jiuzhang.com/solutions/unique-paths-ii/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-unique-paths-ii-java/

Analysis: 
计算解个数的题多半是用DP
*/
public class Solution {
    //DP
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;
        paths[0][0] = 1;
        
        for(int i = 1; i < m; i++){
            if(obstacleGrid[i][0] != 1){
                paths[i][0] = paths[i - 1][0];      // here must be careful.
            }
        }
        
        for(int j = 1; j < n; j++){
            if(obstacleGrid[0][j] != 1){
                paths[0][j] = paths[0][j - 1];
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] != 1){
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        
        return paths[m - 1][n - 1];
    }
}