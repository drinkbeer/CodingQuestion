/**
 * Created by chen on 15/4/1.
 * 1.1 Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures.
 * <p/>
 * Tips:
 * 1.Use a boolean array to mark if this char is unique or not.
 * 2.Use a binary digit to mark if this char is unique or not.
 * <p/>
 * Notes:
 * 1. Array.length -> String.length()
 * 2. ASCII has 128 chars? why use 256
 * <p/>
 * Time complexity: 1.O(N) 2.O(N)   - N refers to the length of String
 * Space complexity: 1.O(1) 2.O(1)
 */
public class CC150_1_1 {

    public static boolean unique(String str) {
        boolean[] temp = new boolean[256];  // default is false

        if (str.length() > 256) return false;

        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i);
            if (temp[idx]) return false;
            else temp[idx] = true;
        }
        return true;
    }

    public static boolean uniqueChars(String str) {
        int checker = 0;

        if (str.length() > 256) return false;

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if ((checker & 1 << val) > 0) return false;
            checker |= 1 << val;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = {"esflkjk", "wedklfn"};
        for (String str : strs) {
            System.out.println("If the chars is unique: " + unique(str) + " - " + uniqueChars(str));
        }
    }
}
