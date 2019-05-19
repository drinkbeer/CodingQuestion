/*
LeetCode: https://leetcode.com/problems/search-a-2d-matrix/
LintCode: http://www.lintcode.com/problem/search-a-2d-matrix/
JiuZhang: http://www.jiuzhang.com/solutions/search-a-2d-matrix/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-search-a-2d-matrix-java/

Analysis: 

*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        
        int m = matrix.length, n = matrix[0].length;
        int lo = 0, hi = m * n - 1;

        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(matrix[mid / n][mid % n ] == target) return true;
            if(matrix[mid / n][mid % n ] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        
        // if(m == 1 && n == 1){
        //     if(matrix[0][0] == target) return true;
        // }
        
        // while(lo + 1 < hi){
        //     int mid = lo + (hi - lo) / 2;
            
        //     if(matrix[mid / n][mid % n] == target) return true;
        //     else if(matrix[mid / n][mid % n] < target) lo = mid;
        //     else hi = mid;
        // }
        
        return false;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int lo = 0, hi = m * n - 1;
        
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            
            int i = mid / m;
            int j = mid % m;
            
            if (matrix[i][j] == target) {
                return true;
            }
            
            if (matrix[i][j] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        
        if (matrix[lo / m][lo % m] == target) return true;
        if (matrix[hi / m][hi % m] == target) return true;
        return false;
    }
    
}
