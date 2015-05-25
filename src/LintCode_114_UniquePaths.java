/**
 * Created by chen on 15/5/18.
 * http://www.lintcode.com/en/problem/unique-paths/
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right
 * corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * <p/>
 * Note
 * m and n will be at most 100.
 */
public class LintCode_114_UniquePaths {
    /**
     * 从左上向右下搜索或从右下向左上搜索
     * @param n, m: positive integer (1 <= n ,m <= 100)
     * @return an integer
     */
    public int uniquePaths(int m, int n) {
        // write your code here
        int[][] sum = new int[m][n];
        if (m == 0 || n == 0) {
            return m == 0 ? n : m;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 || j == n - 1) {
                    sum[i][j] = 1;
                } else {
                    sum[i][j] = sum[i + 1][j] + sum[i][j + 1];
                }
            }
        }

        return sum[0][0];
    }
}
