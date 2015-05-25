/**
 * Created by chen on 15/5/17.
 * Given two strings, find the longest common subsequence (LCS).
 * Your code should return the length of LCS.
 * <p/>
 * Example:
 * For "ABCD" and "EDCA", the LCS is "A" (or "D", "C"), return 1.
 * For "ABCD" and "EACB", the LCS is "AC", return 2.
 * <p/>
 * Clarification:
 * What's the definition of Longest Common Subsequence?
 * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
 * http://baike.baidu.com/view/2020307.htm
 */
public class LintCode_77_LongestCommonSubsequence {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        int m = A.length();
        int n = B.length();
        int[][] f = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(A.charAt(i) == B.charAt(j)){
                    f[i][j] = 1;
                }

            }
        }

        return 0;
    }
}
