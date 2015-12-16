/*
LeetCode: https://leetcode.com/problems/spiral-matrix/
LintCode: http://www.lintcode.com/problem/spiral-matrix/
JiuZhang: http://www.jiuzhang.com/solutions/spiral-matrix/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/

Analysis:

*/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length < 1) return result;
        
        int m = matrix.length, n = matrix[0].length;
        
        if(m == 1 && m == n) {
            result.add(matrix[0][0]);
            return result;
        }
        
        int x = 0, y = 0;
        
        while(m > 0 && n > 0){
            // Consider how m == 1,n == 1 are handled.
            if(m == 1) {
                for(int i = 0; i < n; i++) result.add(matrix[x][y++]);
                break;
            } else if(n == 1) {
                for(int i = 0; i < m; i++) result.add(matrix[x++][y]);
                break;
            }
            
            // Be careful: consider carefully why n - 1 and m - 1 here.
            for(int i = 0; i < n - 1; i++) result.add(matrix[x][y++]);
            
            for(int j = 0; j < m - 1; j++) result.add(matrix[x++][y]);
            
            for(int i = 0; i < n - 1; i++) result.add(matrix[x][y--]);
            
            for(int j = 0; j < m - 1; j++) result.add(matrix[x--][y]);
            
            x++;
            y++;
            m = m - 2;
            n = n - 2;
        }
        
        return result;
    }
}