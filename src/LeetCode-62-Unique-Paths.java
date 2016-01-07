/*
LeetCode: https://leetcode.com/problems/unique-paths/
LintCode: http://www.lintcode.com/problem/unique-paths/
JiuZhang: http://www.jiuzhang.com/solutions/unique-paths/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-unique-paths-java/

Analysis: 
1.DP

2.DFS


*/
public class Solution {
    // 1.DP
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        
        for(int i = 0; i < m; i++) paths[i][0] = 1;
        for(int j = 0; j < n; j++) paths[0][j] = 1;
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];    // DP 
            }
        }
        
        return paths[m - 1][n - 1];
    }
    
    // 2.DFS
    // Time Limit Exceeded
    // public int uniquePaths(int m, int n) {
    //     return DFS(m, n, 0, 0);
    // }
    
    // private int DFS(int m, int n, int i, int j){
    //     // end condition
    //     if(i == m - 1 && j == n - 1) return 1;
        
    //     if(i == m - 1) return DFS(m, n, i, j + 1);
        
    //     if(j == n - 1) return DFS(m, n, i + 1, j);
        
    //     if(i < m - 1 && j < n - 1) return DFS(m, n, i + 1, j) + DFS(m, n, i, j + 1);
        
    //     return 0;
    // }
}