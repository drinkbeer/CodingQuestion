/*
LeetCode: https://leetcode.com/problems/minimum-path-sum/
LintCode: http://www.lintcode.com/problem/minimum-path-sum/
JiuZhang: http://www.jiuzhang.com/solutions/minimum-path-sum/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-minimum-path-sum-java/

Analysis: 
DP
*/

public class Solution {
    // Recursive (will TLE)
//     public int minPathSum(int[][] grid) {
//         if (grid == null || grid.length == 0) return 0;
        
//         return helper(grid, grid.length - 1, grid[0].length - 1);
//     }
    
//     private int helper(int[][] grid, int x, int y) {
//         if (x == 0 && y == 0) return grid[0][0];
        
//         if (x == 0) {
//             return grid[0][y] + helper(grid, 0, y - 1);
//         } else if (y == 0) {
//             return grid[x][0] + helper(grid, x - 1, 0);
//         } else {
//             return grid[x][y] + Math.min(helper(grid, x, y - 1), helper(grid, x - 1, y));
//         }
//     }
    
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
