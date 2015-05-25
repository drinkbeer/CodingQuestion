import org.junit.Test;

/**
 * Created by chen on 15/5/19.
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p/>
 * Example:
 * Given an example n=3 , 1+1+1=2+1=1+2=3
 * return 3
 */
public class LintCode_111_ClimbingStairs {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int climbStairs(int n) {
        // write your code here
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * 用动态规划填表法
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] result = new int[n];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }

    /**
     * 为了节省空间，可以用一个int[3]来存放所有倒数三个result，因为我们只需要用到倒数三个result
     */
    public int climbStairs3(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] result = new int[3];
        result[0] = 1;
        result[1] = 2;
        for (int i = 2; i < n; i++) {
            result[i % 3] = result[(i - 1) % 3] + result[(i - 2) % 3];
        }
        return result[(n - 1) % 3];
    }

    /**
     * 用三个变量来表示需要存储的三个数字
     *
     * @param n
     * @return
     */
    public int climbStairs4(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int last1 = 1;
        int last2 = 2;
        int result = last2;
        for (int i = 2; i < n; i++) {
            result = last1 + last2;
            last1 = last2;
            last2 = result;
        }
        return result;
    }

    @Test
    public void test() {
        int n = 44;
        assert climbStairs(n) == 1134903170;

        int n2 = 3;
        assert climbStairs2(n2) == 3;
    }
}
