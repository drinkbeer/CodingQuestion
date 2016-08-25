/**
 * Created by chen on 15/6/7.
 * There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays.
 * <p/>
 * Example
 * Given A=[1,2,3,4,5,6] and B=[2,3,4,5], the median is 3.5.
 * Given A=[1,2,3] and B=[4,5], the median is 3.
 * <p/>
 * Challenge
 * The overall run time complexity should be O(log (m+n)).
 */
public class LintCode_65_MedianSortedArray {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here

        int l = A.length + B.length;
        if (l % 2 == 0) {
            return (findKth(A, 0, B, 0, l / 2) + findKth(A, 0, B, 0, l / 2 + 1)) / 2;
        } else {
            return findKth(A, 0, B, 0, l / 2 + 1);
        }
    }

    private double findKth(int[] A, int A_start, int[] B, int B_start, int k) {
        if (A == null || B == null) {
            return 0;
        }

        if (A_start >= A.length) {
            return B[B_start + k - 1];
        }

        if (B_start >= B.length) {
            return A[A_start + k - 1];
        }

        if (k <= 1) {
            return Math.min(A[A_start], B[B_start]);
        }

        int A_key = A_start + k / 2 - 1 < A.length ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
        int B_key = B_start + k / 2 - 1 < B.length ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;

        if (A_key > B_key) {
            // note: here is not "B_start + k / 2 - 1"
            return findKth(A, A_start, B, B_start + k / 2, k - k / 2);
        } else {
            // note: here is not "A_start + k / 2 - 1"
            return findKth(A, A_start + k / 2, B, B_start, k - k / 2);
        }

    }
}