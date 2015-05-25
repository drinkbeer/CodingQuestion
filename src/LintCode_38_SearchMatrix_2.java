/**
 * Created by chen on 15/5/12.
 * Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * Integers in each column are sorted from up to bottom.
 * No duplicate integers in each row or column.
 * <p/>
 * Example:
 * Consider the following matrix:
 * [
 * [1, 3, 5, 7],
 * [2, 4, 7, 8],
 * [3, 5, 9, 10]
 * ]
 * Given target = 3, return 2.
 * <p/>
 * Challenge:
 * O(m+n) time and O(1) extra space
 */
public class LintCode_38_SearchMatrix_2 {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        int count = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return count;
        }

        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            if (target == matrix[row][col]) {
                count++;
                row--;
                col++;
            } else if (target < matrix[row][col]) {
                row--;
            } else {
                col++;
            }
        }

        return count;
    }
}
