/*
LeetCode: https://leetcode.com/problems/spiral-matrix-ii/
LintCode: http://www.lintcode.com/problem/spiral-matrix-ii/
JiuZhang: http://www.jiuzhang.com/solutions/spiral-matrix-ii/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-spiral-matrix-ii-java/

Analysis:
Easy problem. Be careful of corner case.
    1.The most center 'one'
    2.The last element of each scan.
*/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if(n < 1) return result;
        
        int x = 0, y = 0;
        int count = 1;
        
        while(n > 0){
            // Top row: from left to right
            for(int i = 0; i < n - 1; i++) result[x][y++] = count++;
            
            // Right column: from top to bottom
            for(int i = 0; i < n - 1; i++) result[x++][y] = count++;
            
            // Bottom row: from right to left
            for(int i = 0; i < n - 1; i++) result[x][y--] = count++;
            
            // Left column: from bottom to top
            for(int i = 0; i < n - 1; i++) result[x--][y] = count++;
            
            if(n == 1) result[x][y] = count;
            
            n -= 2;
            x++;
            y++;
        }
        
        return result;
    }
    
    
    
    public int[][] generateMatrix(int n) {
        if (n <= 0) return new int[0][0];
        int[][] result = new int[n][n];
        
        int x = 0, y = 0; // the start point
        int num = 1;
        
        while (n > 0) {
            
            if (n == 1) {
                result[x][y] = num++;
                return result;
            }
            
            for (int i = 0; i < n - 1; i++) result[x][y++] = num++;
            
            for (int i = 0; i < n - 1; i++) result[x++][y] = num++;
            
            for (int i = 0; i < n - 1; i++) result[x][y--] = num++;
            
            for (int i = 0; i < n - 1; i++) result[x--][y] = num++;
            
            n -= 2;
            x++;
            y++;
        }
        
        return result;
    }
}
