import org.junit.Test;

/**
 * Created by chen on 15/5/14.
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 */
public class LintCode_63_SearchRotatedArray_2 {
    /**
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return false;
        }

        for (int i = 0; i < A.length; i++) {
            if(A[i] == target){
                return true;
            }
        }

        return false;
    }

    @Test
    public void test() {
        int[] array = {2, 2, 2, 3, 1};
        int target = 1;
        assert search(array, target) == true;

        int[] array2 = {2, 2, 3, 4, 1};
        int target2 = 2;
        assert search(array2, target2) == true;

        int[] array3 = {2, 2, 3, 4, 1};
        int target3 = 4;
        assert search(array3, target3) == true;

        int[] array4 = {2, 2, 3, 4, 1};
        int target4 = 1;
        assert search(array4, target4) == true;

        int[] array5 = {9,5,6,7,8,9,9,9,9,9,9};
        int target5 = 8;
        assert search(array4, target4) == true;
    }
}
