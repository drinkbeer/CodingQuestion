import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.NavigableMap;

/**
 * Created by chen on 15/5/18.
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p/>
 * Note:
 * You can only move either down or right at any point in time.
 */
public class LintCode_110_MinimumPathSum {
    /**
     * 从左上到右下遍历或者从右下到左上遍历（我的做法）
     *
     * @param grid: a list of lists of integers.
     * @return: An integer, minimizes the sum of all numbers along its path
     */
    public int minPathSum(int[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    sum[i][j] = grid[i][j];
                } else if (i == m - 1) {
                    sum[i][j] = sum[i][j + 1] + grid[i][j];
                } else if (j == n - 1) {
                    sum[i][j] = sum[i + 1][j] + grid[i][j];
                } else {
                    sum[i][j] = Math.min(sum[i][j + 1], sum[i + 1][j]) + grid[i][j];
                }
            }
        }


        return sum[0][0];
    }

    @Test
    public void test() {
        int[][] grid = {{0}};

        System.out.println("Result: " + minPathSum(grid));

        int[][] grid2 = {{1, 2}, {1, 1}};
        System.out.println("Result: " + minPathSum(grid2));
    }
}
