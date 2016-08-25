/**
 * Created by chen on 15/5/14.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * <p/>
 * Example:
 * Given [4, 5, 6, 7, 0, 1, 2] return 0
 * <p/>
 * Note:
 * You may assume no duplicate exists in the array.
 */
public class LintCode_159_FindMin {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return -1;
        }

        int start = 0;
        int end = num.length - 1;
        int min;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (num[mid] >= num[end]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return num[start] < num[end] ? num[start] : num[end];
    }
}
