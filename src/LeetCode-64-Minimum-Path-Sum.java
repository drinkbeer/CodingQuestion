/*
LeetCode: https://leetcode.com/problems/minimum-path-sum/
LintCode: http://www.lintcode.com/problem/minimum-path-sum/
JiuZhang: http://www.jiuzhang.com/solutions/minimum-path-sum/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-minimum-path-sum-java/

Analysis: 
DP
*/

public class Solution {
    // DP
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] paths = new int[m][n];
        paths[0][0] = grid[0][0];
        for(int i = 1; i < m; i++){
            paths[i][0] = paths[i - 1][0] + grid[i][0];
        }
        for(int j = 1; j < n; j++){
            paths[0][j] = paths[0][j - 1] + grid[0][j];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                paths[i][j] = Math.min(paths[i - 1][j] + grid[i][j], paths[i][j - 1] + grid[i][j]);
            }
        }
        
        return paths[m - 1][n - 1];
    }
    
        // 1. DP, Time O(M*N), Space O(M*N)
//     public int minPathSum(int[][] grid) {
//         if (grid == null) return 0;
//         int n = grid.length, m = grid[0].length;
//         if (m == 1 && n == 1) return grid[0][0];
        
//         int[][] path = new int[n][m];
//         path[0][0] = grid[0][0];
        
//         for (int i = 1; i < n; i++) {
//             path[i][0] = path[i - 1][0] + grid[i][0];
//         }
        
//         for (int j = 1; j < m; j++) {
//             path[0][j] = path[0][j - 1] + grid[0][j];
//         }
        
//         for (int i = 1; i < n; i++) {
//             for (int j = 1; j < m; j++) {
//                 path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];
//             }
//         }
        
//         return path[n - 1][m - 1];
//     }
    
    // 2. DP, inplace, Time O(M*N), Space O(M*N)
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int n = grid.length, m = grid[0].length;
        if (m == 1 && n == 1) return grid[0][0];
    
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        
        for (int j = 1; j < m; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        
        return grid[n - 1][m - 1];
    }
}
