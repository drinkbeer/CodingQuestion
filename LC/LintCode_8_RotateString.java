import org.junit.Test;

/**
 * Created by chen on 15/6/24.
 * <p/>
 * Given a string and an offset, rotate string by offset. (rotate from left to right)
 * <p/>
 * Example
 * Given "abcdefg".
 * offset=0 => "abcdefg"
 * offset=1 => "gabcdef"
 * offset=2 => "fgabcde"
 * offset=3 => "efgabcd"
 * <p/>
 * Challenge
 * Rotate in-place with O(1) extra memory.
 */
public class LintCode_8_RotateString {

    /*
     * param A: A string
     * param offset: Rotate string with offset.
     * return: Rotated string.
     */
    public char[] rotateString(char[] A, int offset) {
        // wirte your code here
        if (A == null || A.length == 0) {
            return A;
        }

        offset = offset % A.length;
        int start = 0;
        int end = A.length - 1;
        reverse(A, start, A.length - offset - 1);
        reverse(A, A.length - offset, end);
        reverse(A, start, end);
        return A;
    }

    private void reverse(char[] A, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            char temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }

    @Test
    public void test() {
        char[] A = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        int offset = 2;
        rotateString(A, offset);

        for (char c : A) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}
