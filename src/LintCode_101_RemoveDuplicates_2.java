import org.junit.Test;

/**
 * Created by chen on 15/5/14.
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p/>
 * For example:
 * Given sorted array A = [1,1,1,2,2,3],
 * <p/>
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class LintCode_101_RemoveDuplicates_2 {
    /**
     * @param nums: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int len = 0;
        int i, j;
        for (i = 0; i < nums.length; ) {
            int now = nums[i];
            for (j = i; j < nums.length; j++) {
                if (nums[j] != now) {
                    break;
                }
                if (j - i < 2) {
                    nums[len++] = now;
                }
            }
            i = j;
        }

        return len;
    }

    @Test
    public void test() {
        int[] a = {-14, -14, -14, -14, -14, -14, -13};
        int len = removeDuplicates(a);
        System.out.println("length: " + len);
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
