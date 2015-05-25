/**
 * Created by chen on 15/5/12.
 * There is an integer array which has the following features:
 * The numbers in adjacent positions are different.
 * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
 * <p/>
 * We define a position P is a peek if A[P] > A[P-1] && A[P] > A[P+1].
 * Find a peak element in this array. Return the index of the peak.
 * <p/>
 * Example:
 * [1, 2, 1, 3, 4, 5, 7, 6]
 * return index 1 (which is number 2)  or 6 (which is number 7)
 * <p/>
 * Note:
 * The array may contains multiple peeks, find any of them.
 * <p/>
 * Challenge:
 * Time complexity O(logN)
 */
public class LintCode_75_FindPeak {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A.length < 3) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1] && A[mid] > A[mid + 1]) {
                return mid;
            } else if (A[mid] > A[mid - 1]) {
                start = mid;
            } else {
                end = mid;
            }
        }

        return -1;
    }
}
