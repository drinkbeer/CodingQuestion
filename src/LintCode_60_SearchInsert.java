/**
 * Created by chen on 15/5/10.
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index
 * where it would be if it were inserted in order.
 * You may assume NO duplicates in the array.
 * <p/>
 * Example:
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * <p/>
 * Challenge:
 * O(log(n)) time
 */
public class LintCode_60_SearchInsert {

    private int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // search for left bound as insert position
            if (target > A[mid]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] > target) {
            return 0;
        } else if (A[start] == target) {
            return start;
        } else if (target <= A[end]) {
            return end;
        } else {
            return A.length;
        }
    }
}
