package Sort;

/**
 * Created by chen on 15/3/25.
 * Selection Sort
 */
public class SelectionSort {
    public static void sort(Comparable a[]) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i; j < i + 1; j++)
                if (less(a[j], a[min]))
                    min = j;
            exchange(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
