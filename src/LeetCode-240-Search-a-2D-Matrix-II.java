/*
https://leetcode.com/discuss/48852/my-concise-o-m-n-java-solution

We start search the matrix from top right corner, initialize the current position to top right corner, if the target is greater than the value in current position, then the target can not be in entire row of current position because the row is sorted, if the target is less than the value in current position, then the target can not in the entire column because the column is sorted too. We can rule out one row or one column each time, so the time complexity is O(m+n).

*/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        
        int row = 0, col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(matrix[row][col] == target) return true;
            else if(matrix[row][col] > target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
