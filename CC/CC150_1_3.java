import java.util.Arrays;

/**
 * Created by chen on 15/4/3.
 * 1.3 Given two strings, write a method to decide if one is a permutation of the other.
 * Tips:
 * 1&2. Convert String to char array first, then quick sort the array, finally to judge the if two arrays are equal
 * 3. Use an int array to count the number of each char in two strings
 * <p/>
 * Time Complexity: 1&2. O(N*log(N))     3. O(N^2)
 * Space Complexity: 1&2&3. O(N)
 */
public class CC150_1_3 {

    private static void quickSort(char[] a, int lo, int hi) {
        if (lo >= hi) return;

        swap(a, lo, lo + (int) (Math.random() * (hi - lo)));     //get a random pivot
        int k = lo;
        for (int i = lo + 1; i <= hi; i++) {
            if (a[i] < a[lo]) swap(a, ++k, i);
        }
        //System.out.println(lo + " - " + k);
        swap(a, lo, k);

        quickSort(a, lo, k - 1);
        quickSort(a, k + 1, hi);
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    private static boolean isPermutation(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        quickSort(chars1, 0, str1.length() - 1);
        quickSort(chars2, 0, str2.length() - 1);

        /*
        Another way:
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] != chars2[i]) return false;
        }
        return true;
         */

        int checker = 0;
        for (int i = 0; i < chars1.length; i++) {
            checker ^= chars1[i] ^ chars2[i];
        }
        return checker == 0;
    }

    /*
    Array.sort()  of primitive type array is an application of Quick Sort,
    For objects array, it's application of Merge Sort.
    Arrays.equals() is also the package of the for-loop I written above.
    So the Time Complexity of both isPermutation and isPermutation2 is the time complexity of Quick Sort,
    which is O(N*log(N))
    Space complexity is O(N), as quick sort is in-place algorithms.
     */
    private static boolean isPermutation2(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        Arrays.sort(chars1);
        Arrays.sort(chars2);

        return Arrays.equals(chars1, chars2);
    }

    /*
    use a int array as counter
     */
    private static boolean isPermutation3(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        int[] counter = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            int val = str1.charAt(i);
            ++counter[val];
        }

        for (int i = 0; i < str2.length(); i++) {
            int val = str2.charAt(i);
            --counter[val];
            if (counter[val] < 0) return false;
        }

        for (int i = 0; i < 256; i++) {
            if (counter[i] != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "qwertyuiop";
        String str2 = "tyrueiwoqp";

        System.out.println("If " + str1 + " and " + str2 + " is permutation according to isPermutation? " + isPermutation(str1, str2));
        System.out.println("If " + str1 + " and " + str2 + " is permutation according to isPermutation2? " + isPermutation2(str1, str2));
        System.out.println("If " + str1 + " and " + str2 + " is permutation according to isPermutation3? " + isPermutation3(str1, str2));

        String str3 = "qwertyuiop";
        String str4 = "oyrueiwoqp";
        System.out.println("If " + str3 + " and " + str4 + " is permutation according to isPermutation? " + isPermutation(str3, str4));
        System.out.println("If " + str3 + " and " + str4 + " is permutation according to isPermutation2? " + isPermutation2(str3, str4));
        System.out.println("If " + str3 + " and " + str4 + " is permutation according to isPermutation3? " + isPermutation3(str3, str4));

    }

    private static void XORtest() {
        String str1 = "acbd";
        char[] a = str1.toCharArray();
        int i = 2;
        int j = 2;
        a[i] ^= a[j];
        a[j] ^= a[i];
        a[i] ^= a[j];
        System.out.println(String.valueOf(a)); // acd

        String str2 = "acbd";
        char[] b = str2.toCharArray();
        int i2 = 1;
        int j2 = 2;
        b[i2] ^= b[j2];
        b[j2] ^= b[i2];
        b[i2] ^= b[j2];
        System.out.println(String.valueOf(b)); // abcd

        int[] c = {1, 3, 3, 4};
        int i3 = 1;
        int j3 = 1;
        c[i3] ^= c[j3];
        c[j3] ^= c[i3];
        c[i3] ^= c[j3];
        for (int val : c) { // 1 0 3 4
            System.out.print(val + " ");
        }
        System.out.println(c[i3] == c[j3 + 1]);

        int[] d = {1, 3, 2, 4};
        int i4 = 1;
        int j4 = 2;
        d[i4] ^= d[j4];
        d[j4] ^= d[i4];
        d[i4] ^= d[j4];
        for (int val : d) { // 1 2 3 4
            System.out.print(val + " ");
        }
        System.out.println();

        int i5 = 2;
        i5 ^= i5;
        i5 ^= i5;
        i5 ^= i5;
        System.out.println(i5);
    }
}
