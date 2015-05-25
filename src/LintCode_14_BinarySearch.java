import org.junit.Test;

/**
 * Created by chen on 15/5/10.
 * Link: http://www.lintcode.com/en/problem/binary-search
 * <p/>
 * For a given sorted array (ascending order) and a target number, find the first index of this number in O(log n)
 * time complexity.
 * If the target number does not exist in the array, return -1.
 * <p/>
 * Example:
 * If the array is [1, 2, 3, 3, 4, 5, 10], for given target 3, return 2.
 * <p/>
 * Challenge:
 * If the count of numbers is bigger than 2^32, can your code work properly?
 */
public class LintCode_14_BinarySearch {

    private static int binarySearch(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int mid;

        // find the left bound of list (if num in mid equals to target, put mid in end)
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (target > nums[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (nums[start] == target) {
            return start;
        } else if (nums[end] == target) {
            return end;
        }

        return -1;
    }

    @Test
    public void testCase() {

        int[] nums1 = {2, 6, 8, 13, 15, 17, 17, 18, 19, 20};
        int target1 = 15;
        assert binarySearch(nums1, target1) == 4;

        int[] nums2 = {2, 6, 8, 17, 17, 17, 17, 18, 19, 20};
        int target2 = 17;
        assert binarySearch(nums2, target2) == 3;

        int[] nums3 = {};
        int target3 = 2;
        assert binarySearch(nums3, target3) == -1;

        int[] nums4 = {2, 2, 2, 13, 15, 17, 17, 18, 19, 20};
        int target4 = 2;
        assert binarySearch(nums4, target4) == 0;

    }
}
