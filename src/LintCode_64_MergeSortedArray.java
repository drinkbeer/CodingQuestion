import org.junit.Test;

import javax.sound.midi.Soundbank;

/**
 * Created by chen on 15/5/15.
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 * <p/>
 * Example:
 * A = [1, 2, 3, empty, empty], B = [4, 5]
 * After merge, A will be filled as [1, 2, 3, 4, 5]
 * <p/>
 * Note:
 * You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B.
 * The number of elements initialized in A and B are m and n respectively.
 */
public class LintCode_64_MergeSortedArray {

    /**
     * @param A: sorted integer array A which has m elements,
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here

        int len = m + n;
        m--;
        n--;
        while (m > 0 && n > 0) {
            if (A[m] > B[n]) {
                A[--len] = A[m--];
            } else {
                A[--len] = B[n--];
            }
        }

        while (m > 0) {
            A[--len] = A[m--];
        }
        while (n > 0) {
            A[--len] = A[n--];
        }

    }

    @Test
    public void test() {
        int[] A = {1, 2, 3, 0, 0};
        int a = 3;
        int[] B = {4, 5};
        int b = 2;
        mergeSortedArray(A, a, B, b);
        for (int item : A) {
            System.out.print(item + " ");
        }
    }
}
