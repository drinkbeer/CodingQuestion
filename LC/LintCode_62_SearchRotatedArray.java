import org.junit.Test;

/**
 * Created by chen on 15/5/14.
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * <p/>
 * Example:
 * For [4, 5, 1, 2, 3] and target=1, return 2.
 * For [4, 5, 1, 2, 3] and target=0, return -1.
 * <p/>
 * Challenge:
 * O(logN) time
 */
public class LintCode_62_SearchRotatedArray {
    /**
     * @param A      : an integer rotated sorted array
     * @param target :  an integer to be searched
     *               return : an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if(target == A[mid]){
                return mid;
            }

            if(A[start] < A[mid]){
                if(A[start] <= target && target < A[mid]){
                    end = mid;
                }else {
                    start = mid;
                }
            }else {
                if(A[mid] < target && target <= A[end]){
                    start = mid;
                }else {
                    end = mid;
                }
            }
        }

        if (target == A[start]) {
            return start;
        }
        if (target == A[end]) {
            return end;
        }

        return -1;
    }

    @Test
    public void test() {
        int[] array = {0, 1, 2, -10, -9, -8, -7, -6, -5, -4, -3, -2, -1};
        int target = -9;

        assert search(array, target) == 4;

        int[] array2 = {1, 2, 3, 4, 5, 9};
        int target2 = 9;

        assert search(array2, target2) == 5;

        int[] array3 = {9, 5, 4, 3, 2, 1};
        int target3 = 9;
        assert search(array3, target3) == 0;

        int[] array4 = {9, 5, 4, 3, 2, 1};
        int target4 = 3;
        assert search(array4, target4) == 3;
    }
}
