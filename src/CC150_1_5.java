/**
 * Created by chen on 15/4/5.
 * <p/>
 * 1.5 Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become
 * a2blc5a3. If the "compressed" string would not become smaller than the original
 * string, your method should return the original string.
 * <p/>
 * Tips:
 * Use two pointer to make the begin of repeat String snippet and current char, and
 * a counter to mark the num of the repeat String snippet
 * <p/>
 * Notes: none
 * <p/>
 * Time complexity: O(N)
 * Space complexity: O(N)
 */
public class CC150_1_5 {

    private static String stringCompression(String str) {
        char[] chars = str.toCharArray();
        StringBuffer strBuffer = new StringBuffer();
        int k = 0;
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[k]) {
                strBuffer.append(chars[k]).append(count);
                k = i;
                count = 1;
            } else {
                count++;
            }
        }
        strBuffer.append(chars[k]).append(count);

        if (strBuffer.length() > str.length()) return str;
        return strBuffer.toString();
    }

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        String str2 = "aab";
        System.out.println("Compression: " + stringCompression(str));
        System.out.println("Compression: " + stringCompression(str2));
    }
}
