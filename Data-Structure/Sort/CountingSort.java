
/**
 * Counting sort is an algorithm that sorts the element by:
 * 1. Counting the frequency of each element. Put counting in a [0, max_value] sorted frequency array.
 * 2. Do incremental sum of the frequency array.
 * 3. The final position of a value is [frequency - 1].
 *
 * https://www.programiz.com/dsa/counting-sort
 * https://zhuanlan.zhihu.com/p/125126086
 *
 * Ave Time Complexity: O (N + K), N is number of elements, K is the range of elements (aka, max value - min value).
 * Space Complexity: O (max_value)
 */
public class CountingSort {

    public static void sort(int[] arr) {
        int[] tmp = new int[arr.length];
        int k = 100;    // assume all value in arr: 0 <= a && a < k
        int[] count = new int[k];
        countingSort(arr, tmp, count);
    }

    private static void countingSort(int[] arr, int[] tmp, int[] count) {
        // count
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            count[a] += 1;
        }

        // Sum up to be a prefix sum
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        // make the result
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            int a = tmp[i];
            arr[count[a] - 1] = a;
            count[a] -= 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
        sort(arr);
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }

}
