/**
 * Created by chen on 15/6/24.
 * <p/>
 * Given an input string, reverse the string word by word.
 * <p/>
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * <p/>
 * Clarification
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 */
public class LintCode_53_ReverseWordsInString {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        if (s == null || s.length() == 0) {
            return "";
        }

        String[] strings = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; i--) {
            // note: 要先判断是否为“”
            if (!strings[i].equals("")) {
                sb.append(strings[i]).append(" ");
            }
        }

        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
    }
}
