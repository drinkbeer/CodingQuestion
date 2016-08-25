/**
 * Created by chen on 15/5/21.
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p/>
 * Example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 */
public class LintCode_117_JumpGame_2 {
    /**
     * Greedy Algorithm:
     * @param A: A list of lists of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int n = A.length;
        int des = n - 1;
        int sum = 0;
        while (des > 0) {
            for (int i = 0; i < des; i++) {
                if (A[i] + i >= des) {
                    sum++;
                    // in point i we can reach destination, so we just need to ensure point i is also reachable
                    // actually point i is the first point to reach destination, this is important as we need to find
                    // the minimum steps to reach destination
                    des = i; // loop will end automately
                }
            }
        }

        return sum;
    }

    public int jump2(int[] A){

        return 0;
    }
}
