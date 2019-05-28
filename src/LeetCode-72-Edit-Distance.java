/*
https://discuss.leetcode.com/topic/17639/20ms-detailed-explained-c-solutions-o-n-space
https://www.cnblogs.com/grandyang/p/4344107.html

https://www.youtube.com/watch?v=Q4i_rqON2-E

a b c d e f
a z c e d

b -> z
delete d
f -> d

Total 3 edits to convert "abcdef" to "azced"

Matrix
    a b c d e f 
  0 1 1 3 4 5 6
a 1 0 1 2 3 4 5
z 2 1 1 2 3 4 5
c 3 2 2 1 2 3 4
e 4 3 3 2 2 2 4
d 5 4 4 3 3 3 3

*/
public class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        
        // state matrix
        int[][] dp = new int[m + 1][n + 1];
        
        // init matrix
        for(int i = 1; i <= m; i++) dp[i][0] = i;
        for(int j = 1; j <= n; j++) dp[0][j] = j;
        
        // calculate matrix
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(word1.charAt(i) == word2.charAt(j)) dp[i + 1][j + 1] = dp[i][j];
                else dp[i + 1][j + 1] = Math.min(dp[i][j] + 1, Math.min(dp[i][j + 1] + 1, dp[i + 1][j] + 1));
            }
        }
        
        return dp[m][n];
    }
}
