/*
http://gongxuns.blogspot.com/2012/12/public-class-solution-public-boolean.html

*/
public class Solution {
    // 1.Wrong Solution
    // public boolean isInterleave(String s1, String s2, String s3) {
    //     if(s1 == null && s2 == null && s3 == null) return true;
    //     if(s1.length() == 0 && s2.length() == 0 && s3.length()  == 0) return true;
    //     if(s3.length() != s1.length() + s2.length()) return false;
    //     int[] map = new int['z' - 'a' + 1];
        
    //     for(int i = 0; i < s1.length(); i++){
    //         char ch = s1.charAt(i);
    //         map[ch - 'a']++;
    //     }
        
    //     for(int i = 0; i < s2.length(); i++){
    //         char ch = s2.charAt(i);
    //         map[ch - 'a']++;
    //     }
        
    //     for(int i = 0; i < s3.length(); i++){
    //         char ch = s3.charAt(i);
    //         map[ch - 'a']--;
    //     }
        
    //     for(int i = 0; i < map.length; i++){
    //         if(map[i] != 0) return false;
    //     }
    //     return true;
    // }
    
    // 2.DP
    /*
    subproblem
    dp[i][j]  -   whether s1 [0, i], s2 [0, j] could interleaving and construct s3 [0, i + j + 2]
    
    recurrence relation:
    dp[i][j] = dp[i - 1][j] or dp[i][j - 1] if s3.charAt(i + j + 2) == s1.charAt(i) || s3.charAt(i + j + 1) == s2.charAt(j)
    
    */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null || s1.length() + s2.length() != s3.length()) return false;
        
        int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
        
        // subproblem
        boolean[][] dp = new boolean[l1 + 1][l2 + 1];
        
        // init
        dp[0][0] = true;
        for (int i = 1; i <= l1; i++) {
            dp[i][0] = dp[i - 1][0] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int j = 1; j <= l2; j++) {
            dp[0][j] = dp[0][j - 1] && (s2.charAt(j - 1) == s3.charAt(j - 1));
        }
        
        // recurrence relation
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                // ch == s1.charAt(i - 1) means curr char can mark from i+j-1 in s3, but the problem is if 
                // the previous char in s2 is equal to the previous char in s3? It's state[i-1][j] shows.
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i - 1][j];
                }
                // ch==s2.charAt(j-1) means curr char can mark from i+j-1 in s3, we need to make sure
                // the previous char in s1 is equal to the previous char in s3. state[i][j-1] shows this.
                if (s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        
        return dp[l1][l2];
    }
    
}
