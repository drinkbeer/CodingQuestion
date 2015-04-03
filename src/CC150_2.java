/**
 * Created by chen on 15/4/1.
 * 1.2 Implement a function void reverse(char* str) in C or C++
 * which reverses a nullterminated string.
 * <p/>
 * Tips:
 * 1. Use Java API StringBuffer to reverse String Object
 * 2. Convert String to char[] and swap each char
 * <p/>
 * Notes:
 * 1. String object in Java is immutable, which is different from that in C++
 * 2. In Java, StringBuffer is Threadsafe(recommend), StringBuilder is not Threadsafe(faster than StringBuffer)
 * <p/>
 * Time Complexity: 1. O(N)     2. O(N)
 * Space Complexity: 1. O(N)    2. O(N)
 */
public class CC150_2 {

    private static String reverseString(String str) {
        return new StringBuffer(str).reverse().toString();
    }

    private static String reverseString2(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        int N = chars.length;
        while (i < N / 2) {
            swap(chars, i, N - i);
        }
        return chars.toString();
    }

    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = a[i];
    }
}
