package Sort;

/**
 * Created by chen on 15/3/25.
 * Shell Sort
 *
 * https://www.programiz.com/dsa/shell-sort
 */
public class ShellSort {
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 0;
        while (3 * h < N) h = h * 3 + 1;// h = 1, 4, 13, 40, 121, 364...

        while (h > 0) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
                    exchange(a, j, j - 1);
            }
            h = h / 3;
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
