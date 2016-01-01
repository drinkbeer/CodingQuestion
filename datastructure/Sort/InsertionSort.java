package Sort;

/**
 * Created by chen on 15/3/25.
 * Insertion Sort
 */
public class InsertionSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j++)
                if (less(a[j], a[j - 1]))
                    exchange(a, j, j - 1);
                else break;
        }
    }

    //eliminate the else break
    public static void sort2(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exchange(a, j, j - 1);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
    }
}
