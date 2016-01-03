/*
LeetCode: https://leetcode.com/problems/number-of-islands/
LintCode: http://www.lintcode.com/problem/numbers-of-islands/
JiuZhang: http://www.jiuzhang.com/solutions/numbers-of-islands/
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-number-of-islands-java/

Analysis: 
Removing adjacent island using DFS(recursive), each island removed, count++
*/
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    removeIsland(grid, i, j);
                }
            }
        }
        
        return count;
    }
    
    private void removeIsland(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if(grid[i][j] != '1') return;
        
        grid[i][j] = '0';
        removeIsland(grid, i - 1, j);
        removeIsland(grid, i + 1, j);
        removeIsland(grid, i, j - 1);
        removeIsland(grid, i, j + 1);
    }
}