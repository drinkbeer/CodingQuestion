import java.util.ArrayList;

/**
 * Created by chen on 15/5/10.
 * Given a sorted array of n integers, find the starting and ending position of a given target value.
 * If the target is not found in the array, return [-1, -1].
 * <p/>
 * Example:
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * <p/>
 * Challenge:
 * O(log n) time.
 */
public class LintCode_61_SearchRange {
    private ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        int[] num = {-1, -1};
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(-1);
        result.add(-1);
        if (A == null || A.size() == 0) {
            return result;
        }

        // search for left bound
        int start = 0;
        int end = A.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // search for left bound, so when num in mid equals to target, put mid to right bound(end)
            if (target > A.get(mid)) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (A.get(start) == target) {
            result.clear();
            result.add(start);
        } else if (A.get(end) == target) {
            result.clear();
            result.add(end);
        } else {
            return result;
        }

        // search for right bound
        start = 0;
        end = A.size() - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // search for right bound, so when num in mid equals to target, put mid to left bound(start)
            if (target < A.get(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (A.get(end) == target) {
            result.add(end);
        } else if (A.get(start) == target) {
            result.add(start);
        } else {
            result.clear();
            result.add(-1);
            result.add(-1);
            return result;
        }

        return result;
    }
}
