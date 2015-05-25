import org.junit.Test;

/**
 * Created by chen on 15/5/21.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * <p/>
 * Example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 */
public class LintCode_116_JumpGame {
    /**
     * Dynamic programming, bottom to top
     *
     * @param A: A list of integers
     * @return: The boolean answer
     */
    public boolean canJump(int[] A) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return false;
        }

        int n = A.length;
        boolean[] can = new boolean[n];
        can[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && A[j] + j >= i) {
                    can[i] = true;
                    break;
                }
            }
        }

        return can[n - 1];
    }

    /**
     * improve. 如果某一点可达，则此点前面所有点都是可达的。所以我们可以用一个boolean变量来代表是否前面所有点可达。如果不是前面所有点
     * 都可达，则return false，后面的点不需要再继续计算了。
     *
     * @param A
     * @return
     */
    public boolean canJump_improve(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        boolean can;
        int n = A.length;
        for (int i = 1; i < n; i++) {
            can = false;
            for (int j = 0; j < i; j++) {
                if (A[j] + j >= i) {
                    // improve: 只要在0-i中有一个点可以reach点i，就算i是reachable，下面就不需要再继续扫描了
                    can = true;
                    break;
                }
            }

            // improve: if in some case all nums between 0 and i are smaller than A[i], so it's impossible to jump to
            // A[i]
            if (!can) {
                return false;
            }
        }

        return true;
    }

    /**
     * Dynamic programming, top to bottom
     *
     * @param A
     * @return
     */
    public boolean canJump2(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int n = A.length;
        boolean[] can = new boolean[n];
        can[0] = true;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (can[j] && A[j] + j >= i) {
                    can[i] = true;
                    break;
                }
            }
        }

        return can[n - 1];
    }

    /**
     * Greedy Algorithm, bottom to top
     *
     * @param A
     * @return
     */
    public boolean canJump3(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int farthest = A[0];
        int n = A.length;
        for (int i = 1; i < n; i++) {
            if (i <= farthest && A[i] + i > farthest) {
                farthest = A[i] + i;
            } else if (i > farthest) {
                break;
            }
        }

        return farthest >= n - 1 ? true : false;
    }

    /**
     * another write method of Greedy Algorithm
     *
     * @param A
     * @return
     */
    public boolean canJump3_another(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int farthest = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            farthest = Math.max(farthest, A[i] + i);
            if (farthest == i) {
                // equals to: A[i] == 0
                return false;
            }
            if (farthest == n - 1) {
                // has already reach terminal, not need to go on search
                return true;
            }
        }
        return true;
    }

    /**
     * DFS: recursion
     *
     * @param A
     * @return
     */
    public boolean canJump4(int[] A) {
        if (A == null || A.length == 0) {
            return false;
        }

        int index = A.length;
        return canJump4(A, index - 1);
    }

    private boolean canJump4(int[] A, int index) {
        if (index == 0) {
            return true;
        }

        for (int i = 0; i < index; i++) {
            if (A[i] + i >= index) {
                // this means index can be reached from point i, but the prerequisite is point i is also reachable
                return canJump4(A, i);
            }
        }
        return false;
    }

    @Test
    public void test() {
        int[] a = {0, 8, 2, 0, 9};
        assert canJump(a) == false;
        assert canJump_improve(a) == false;
        assert canJump2(a) == false;
        assert canJump3(a) == false;
        assert canJump3_another(a) == false;
        assert canJump4(a) == false;


        int[] b = {4, 6, 9, 5, 9, 3, 0};
        assert canJump(b) == true;
        assert canJump_improve(b) == true;
        assert canJump2(b) == true;
        assert canJump3(b) == true;
        assert canJump3_another(b) == true;
        assert canJump4(b) == true;

    }
}
