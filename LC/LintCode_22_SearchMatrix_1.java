import org.junit.Test;

/**
 * Created by chen on 15/5/11.
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * <p/>
 * Example:
 * Consider the following matrix:
 * [
 * [1, 3, 5, 7],
 * [10, 11, 16, 20],
 * [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * <p/>
 * Challenge:
 * O(log(n) + log(m)) time
 */
public class LintCode_22_SearchMatrix_1 {

    private boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int start = 0;
        int end = matrix.length - 1;
        int row = matrix.length;
        int col = matrix[0].length;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // search for the left bound
            if (target == matrix[mid][0]) {
                return true;
            } else if (target > matrix[mid][0]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (matrix[end][0] <= target) {
            row = end;
        } else if (matrix[start][0] <= target) {
            row = start;
        } else {
            return false;
        }

        start = 0;
        end = matrix[row].length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target == matrix[row][mid]) {
                return true;
            } else if (target > matrix[row][mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (target == matrix[row][start] || target == matrix[row][end]) {
            return true;
        }

        return false;
    }

    @Test
    public void test1() {
        int[][] matrix1 = {{1, 4, 8, 15, 20, 22, 25, 32, 36, 43, 49, 51, 53, 55, 59, 65, 69, 73, 80},
                {100, 116, 136, 148, 169, 188, 207, 222, 245, 266, 283, 299, 323, 347, 363, 384, 406, 431, 447},
                {460, 477, 494, 512, 532, 548, 562, 582, 604, 617, 630, 643, 663, 675, 690, 713, 735, 758, 783},
                {805, 819, 839, 855, 868, 878, 890, 909, 927, 941, 961, 971, 985, 1000, 1024, 1037, 1061, 1086, 1101},
                {1124, 1135, 1157, 1182, 1198, 1221, 1235, 1254, 1267, 1277, 1294, 1319, 1342, 1361, 1382, 1400, 1419, 1440, 1453},
                {1472, 1495, 1517, 1542, 1554, 1567, 1588, 1603, 1625, 1642, 1661, 1680, 1690, 1702, 1713, 1725, 1748, 1771, 1793}};
        int target1 = 81;
        assert searchMatrix(matrix1, target1) == false;
    }
}
