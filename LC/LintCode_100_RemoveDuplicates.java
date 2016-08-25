import org.junit.Test;

/**
 * Created by chen on 15/5/14.
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p/>
 * Example:
 * Given input array A = [1,1,2],
 * <p/>
 * Your function should return length = 2, and A is now [1,2].
 */
public class LintCode_100_RemoveDuplicates {
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
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[len]) {
                nums[++len] = nums[i];
            }
        }

        return len + 1;
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
