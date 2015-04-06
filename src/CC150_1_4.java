/**
 * Created by chen on 15/4/5.
 * 1.4 Write a method to replace all spaces in a string with'%20'. You may assume that
 * the string has sufficient space at the end of the string to hold the additional
 * characters, and that you are given the "true" length of the string. (Note: if implementing
 * in Java, please use a character array so that you can perform this operation
 * in place.)
 * <p/>
 * EXAMPLE
 * Input: "Mr John Smith"
 * Output: "Mr%20Dohn%20Smith"
 * <p/>
 * Tips:
 * 1. use a new char array to transfer chars from old array
 * 2. use a new String array to transfer Strings from old array
 * 3. use internal API: String.replaceAll()
 * <p/>
 * Notes:
 * 1. " " and ' ' is different in memory. " " can use equal(), ' ' can use =
 * <p/>
 * Time Complexity: 1. O(N)     2. O(N)     3. O(N)
 * Space Complexity: 1. O(N)    2. O(N)     3. O(1)
 */
public class CC150_1_4 {

    private static String replaceSpace(String str) {
        char[] chars = str.toCharArray();
        int newLens = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') newLens++;
        }

        char[] newChars = new char[newLens * 2 + chars.length];

        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                newChars[k++] = '%';
                newChars[k++] = '2';
                newChars[k++] = '0';
            } else
                newChars[k++] = chars[i];
        }

        return String.valueOf(newChars);
    }

    /*
    If we are not forced to use char array, we can use String array for instead.
     */
    private static String replaceSpace2(String str) {
        String[] strs = str.split(" ");
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            strBuffer.append("%20");
            strBuffer.append(strs[i]);
        }
        return strBuffer.toString();
    }

    /*
    If we are not forced to use array, we can use Java internal API: String.replaceAll()
     */
    private static String replaceSpace3(String str) {
        return str.replaceAll(" ", "%20");
    }

    public static void main(String[] args) {
        String str = "abc def gh";
        System.out.println(replaceSpace(str));
        System.out.println(replaceSpace2(str));
        System.out.println(replaceSpace3(str));
    }

}
