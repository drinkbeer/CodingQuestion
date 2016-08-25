import org.junit.Test;

/**
 * Created by chen on 15/5/18.
 * http://www.lintcode.com/en/problem/unique-paths-ii/#
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p/>
 * Example:
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 * [0,0,0],
 * [0,1,0],
 * [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * <p/>
 * Note:
 * m and n will be at most 100.
 */
public class LintCode_115_UniquePaths_2 {
    /**
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] sum = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (obstacleGrid[i][j] == 1) {
                    sum[i][j] = 0;
                } else if (i == m - 1 && j == n - 1) {
                    sum[i][j] = 1;
                } else if (i == m - 1) {
                    sum[i][j] = sum[i][j + 1];
                } else if (j == n - 1) {
                    sum[i][j] = sum[i + 1][j];
                } else {
                    sum[i][j] = sum[i + 1][j] + sum[i][j + 1];
                }
            }
        }

        return sum[0][0];
    }

    @Test
    public void test() {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println("Result: " + uniquePathsWithObstacles(obstacleGrid));
    }
}
