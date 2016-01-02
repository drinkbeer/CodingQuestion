package Sort;

import edu.princeton.cs.introcs.StdRandom;

/**
 * Created by chen on 15/4/2.
 */
public class QuickSort {

    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        do {
            while (less(a, ++i, lo)) if (i == hi) break;  //find the i that a[i] > a[0]
            while (less(a, lo, --j)) if (j == lo) break;  //find the j that a[j] < a[0], j == lo test is redundant

            exch(a, i, j);
        } while (i <= j);
        exch(a, lo, j);
        return j;
    }

    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) return;
        int val = partition(a, lo, hi);
        sort(a, lo, val - 1);
        sort(a, val + 1, hi);
    }

    private static boolean less(Comparable[] a, int i, int j) {
        return a[i].compareTo(a[j]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = a[i];
    }
}
