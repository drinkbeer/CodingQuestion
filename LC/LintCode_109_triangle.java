import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by chen on 15/5/17.
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p/>
 * Example:
 * For example, given the following triangle
 * <p/>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */
public class LintCode_109_triangle {
    /**
     * Bottom-Up search (DP)
     * 有很多种变种，比如把二维数组sum改用一个一位数组，或者不用数组直接把每行数读出来放到ArrayList中计算然后把此位置的sum直接放到这个
     * ArrayList中去。
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // write your code here
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();
        int[][] sum = new int[n][n];

        for (int i = 0; i < n; i++) {
            sum[n - 1][i] = triangle.get(n - 1).get(i);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                sum[i][j] = Math.min(sum[i + 1][j], sum[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }

        return sum[0][0];
    }

    /**
     * Memorize Search (Divide & Conquer, Dynamic Programming)
     */
    public int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int n = triangle.size();
        int[][] sum = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum[i][j] = Integer.MAX_VALUE;
            }
        }

        return minSearch(0, 0, triangle, sum);
    }

    private int minSearch(int x, int y, ArrayList<ArrayList<Integer>> triangle, int[][] sum) {

        if (x >= triangle.size()) {
            return 0;
        }

        if (sum[x][y] != Integer.MAX_VALUE) {
            // means sum[x][y] has already been calculated, the core point of memorize search
            return sum[x][y];
        }

        sum[x][y] = Math.min(minSearch(x + 1, y, triangle, sum), minSearch(x + 1, y + 1, triangle, sum)) +
                triangle.get(x).get(y);
        return sum[x][y];
    }

    @Test
    public void test() {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        ArrayList<Integer> b = new ArrayList<Integer>();
        b.add(2);
        b.add(3);
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        triangle.add(a);
        triangle.add(b);

//        System.out.println("Result: " + minimumTotal(triangle));

        System.out.println("Result: " + minimumTotal2(triangle));

        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(-10);
        ArrayList<ArrayList<Integer>> triangle2 = new ArrayList<ArrayList<Integer>>();
        triangle2.add(a1);
        System.out.println("Result: " + minimumTotal2(triangle2));

    }

}
