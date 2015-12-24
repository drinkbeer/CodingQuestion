/*
LeetCode: https://leetcode.com/problems/triangle/
LintCode: http://www.lintcode.com/problem/triangle/
JiuZhang: http://www.jiuzhang.com/solutions/triangle/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-triangle-java/

Analysis:
1.Dynamic Programming(top-down)

2.Dynamic Programming(bottom-up)


*/
public class Solution {
    // 1.Dynamic Programming(top-down)
    // public int minimumTotal(List<List<Integer>> triangle) {
    //     if(triangle == null || triangle.size() == 0) return -1;
    //     if(triangle.get(0) == null || triangle.get(0).size() == 0) return -1;
        
    //     // state
    //     int n = triangle.size();
    //     int[][] f = new int[n][n];
        
    //     // init state
    //     f[0][0] = triangle.get(0).get(0);
    //     for(int i = 1; i < n; i++){
    //         f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
    //         f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
    //     }
        
    //     // calculate state top-down
    //     for(int i = 1; i < n; i++){
    //         for(int j = 1; j < i; j++){
    //             f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
    //         }
    //     }
        
    //     int min = f[n - 1][0];
    //     for(int i = 1; i < n; i++){
    //         min = Math.min(min, f[n - 1][i]);
    //     }
    //     return min;
    // }
    
    // 2.Dynamic Programming(bottom-up)
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return -1;
        if(triangle.get(0) == null || triangle.get(0).size() == 0) return -1;
        
        // state
        int n = triangle.size();
        int[][] f = new int[n][n];
        
        // init state
        for(int i = 0; i < n; i++) f[n - 1][i] = triangle.get(n - 1).get(i);
        
        // calculate state (bottom-up)
        for(int i = n - 2; i >=0; i--){
            for(int j = 0; j <= i; j++){
                f[i][j] = Math.min(f[i + 1][j], f[i + 1][j + 1]) + triangle.get(i).get(j); 
            }
        }
        
        return f[0][0];
    }
}