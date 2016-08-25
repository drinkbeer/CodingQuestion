import java.util.ArrayList;

/**
 * Created by chen on 15/6/7.
 * Given a rotated sorted array, recover it to sorted array in-place.
 * <p/>
 * Example
 * [4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
 * <p/>
 * Challenge
 * In-place, O(1) extra space and O(n) time.
 * <p/>
 * Clarification
 * What is rotated array?
 * <p/>
 * For example, the orginal array is [1,2,3,4], The rotated array of it can be [1,2,3,4], [2,3,4,1], [3,4,1,2], [4,1,2,3]
 * <p/>
 * Notes:
 * 三步翻转法
 * 一、找到临界点
 * 二、翻转临界点前和后两段
 * 三、翻转整个array
 */
public class LintCode_39_ReverseRotatedArray {
    /**
     * @param nums: The rotated sorted array
     * @return: void
     */
    public void LintCode_39_ReverseRotatedArray(ArrayList<Integer> nums) {
        // write your code
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                reverse(nums, 0, i);
                reverse(nums, i + 1, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
                return;
            }
        }
    }

    private void reverse(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}
