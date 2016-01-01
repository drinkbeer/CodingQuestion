/**
 * Created by chen on 15/4/1.
 */
public class MergeSort {

    public static void sort(Comparable[] a) {
        Comparable[] tmp = new Comparable[a.length];
        sort(a, tmp, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] tmp, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, tmp, lo, mid);          //sort left part
        sort(a, tmp, mid + 1, hi);      //sort right part
        merge(a, tmp, lo, mid, hi);     //merge left and right parts
    }
    
    public static void merge(Comparable[] a, Comparable[] tmp, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; k++) {
            tmp[k] = a[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            // if (i > mid)                        a[k] = tmp[j++];
            // else if (j > hi)                    a[k] = tmp[i++];
            // else if (tmp[i].compareTo(tmp[j]) < 0)  a[k] = tmp[i++];
            // else                                a[k] = tmp[j++];
            // Another version of code
            if(j > hi || (i <= mid && tmp[i].compareTo(tmp[j]) < 0)){
                a[k] = tmp[i++];
            }else{
                a[k] = tmp[j++];
            }
        }

    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo; i < hi - 1; i++) {
            if (a[i + 1].compareTo(a[i]) < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Integer[] a = {6, 3, 6, 4, 2, 3, 9, 5, 3, 2, 0};
        // Integer[] a = {2, 6, 3, 5, 1};
        sort(a);
        System.out.println(java.util.Arrays.toString(a));
    }

}
