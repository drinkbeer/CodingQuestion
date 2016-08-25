import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by chen on 15/6/7.
 * Merge two given sorted integer array A and B into a new sorted integer array.
 * <p/>
 * Example
 * A=[1,2,3,4]
 * B=[2,4,5,6]
 * return [1,2,2,3,4,4,5,6]
 * <p/>
 * Challenge
 * How can you optimize your algorithm if one array is very large and the other is very small?
 */
public class LintCode_6_MergeSortedArray_2 {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        for (int i = 0; i < B.size(); i++) {
            A.add(B.get(i));
        }
        Collections.sort(A);
        return A;
    }

    public ArrayList<Integer> mergeSortedArray2(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        int i = 0;
        int j = 0;

        while (i < A.size() || j < B.size()) {
            if (i == A.size()) {
                res.add(B.get(j++));
                continue;
            }
            if (j == B.size()) {
                res.add(A.get(i++));
                continue;
            }

            if (A.get(i) > B.get(j)) {
                res.add(B.get(j++));
            } else {
                res.add(A.get(i++));
            }
        }

        return res;
    }
}
