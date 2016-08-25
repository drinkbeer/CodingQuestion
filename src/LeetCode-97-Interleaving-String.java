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
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1 == null && s2 == null && s3 == null) return true;
        if(s1.length() == 0 && s2.length() == 0 && s3.length()  == 0) return true;
        if(s3.length() != s1.length() + s2.length()) return false;
        
        // state
        int len1 = s1.length();
        int len2 = s2.length();
        boolean[][] state = new boolean[len1 + 1][len2 + 1];
        
        // init state
        state[0][0] = true;
        for(int i = 0; i < len1; i++){
            if(s1.charAt(i) == s3.charAt(i)){
                state[i + 1][0] = state[i][0];
            }
        }
        for(int j = 0; j < len2; j++){
            if(s2.charAt(j) == s3.charAt(j)){
                state[0][j + 1] = state[0][j];
            }
        }
        
        // calculate state
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                char ch = s3.charAt(i + j - 1);
                if(ch == s1.charAt(i - 1)){
                    // ch == s1.charAt(i - 1) means curr char can mark from i+j-1 in s3, but the problem is if 
                    // the previous char in s2 is equal to the previous char in s3? It's state[i-1][j] shows.
                    state[i][j] = state[i - 1][j] || state[i][j];
                }
                if(ch == s2.charAt(j - 1)){
                    // ch==s2.charAt(j-1) means curr char can mark from i+j-1 in s3, we need to make sure
                    // the previous char in s1 is equal to the previous char in s3. state[i][j-1] shows this.
                    state[i][j] = state[i][j - 1] || state[i][j];
                }
            }
        }
        return state[len1][len2];
    }
    
}