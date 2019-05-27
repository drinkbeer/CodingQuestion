/*
https://discuss.leetcode.com/topic/22516/my-java-dp-solution-using-2d-table
https://discuss.leetcode.com/topic/3040/linear-runtime-and-constant-space-solution
http://www.programcreek.com/2014/06/leetcode-wildcard-matching-java/

One of the hardest question in LeetCode. Similar to 10. Regular Expression Matching, but a little easier than it.

Analysis:
1.DP (not totally understand)

2.Two Pointers


*/
class Solution {
    // 1.DP
    // public boolean isMatch(String s, String p) {
    //     boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        
    //     match[s.length()][p.length()] = true;
    //     for(int i=p.length()-1;i>=0;i--){
    //         if(p.charAt(i)!='*') break;
    //         else match[s.length()][i]=true;
    //     }
    //     for(int i = s.length() - 1; i >= 0; i--){
    //         for(int j = p.length() - 1; j >= 0; j--){
    //             if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
    //                     match[i][j] = match[i+1][j+1];
    //             else if(p.charAt(j) == '*')
    //                     match[i][j] = match[i+1][j] || match[i][j+1];
    //             else
    //                 match[i][j] = false;
    //         }
    //     }
    //     return match[0][0];
    // }
    
    // Another DP
    // public boolean isMatch(String s, String p) {
    //     int m = s.length(), n = p.length();
    //     boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        
    //     match[0][0] = true;
    //     for(int i = 0; i <= m; i++) match[i][0] = false;
        
    //     for(int j = 1; j <= n; j++){
    //         if(p.charAt(j - 1) == '*') match[0][j] = true;
    //         else break;
    //     }
        
    //     for(int i = 1; i <= m; i++){
    //         for(int j = 1; j <= n; j++){
    //             if(p.charAt(j - 1) != '*'){
    //                 match[i][j] = match[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?');
    //             }else{
    //                 match[i][j] = match[i - 1][j] || match[i][j - 1];
    //             }
    //         }
    //     }
        
    //     return match[m][n];
    // }
    
    // 2.Two Pointers
//     public boolean isMatch(String str, String pattern) {
//         int s = 0, p = 0, match = 0, starIdx = -1;            
//         while (s < str.length()){
//             // advancing both pointers
//             if (p < pattern.length()  && (pattern.charAt(p) == '?' || str.charAt(s) == pattern.charAt(p))){
//                 s++;
//                 p++;
//             }
//             // * found, only advancing pattern pointer
//             else if (p < pattern.length() && pattern.charAt(p) == '*'){
//                 starIdx = p;
//                 match = s;
//                 p++;
//             }
//            // last pattern pointer was *, advancing string pointer
//             else if (starIdx != -1){
//                 p = starIdx + 1;
//                 match++;
//                 s = match;
//             }
//            //current pattern pointer is not star, last patter pointer was not *
//             //characters do not match
//             else return false;
//         }
        
//         //check for remaining characters in pattern
//         while (p < pattern.length() && pattern.charAt(p) == '*')
//             p++;
        
//         return p == pattern.length();
//     }
    
    // https://segmentfault.com/a/1190000003786247
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        if (s.length() == 0 && p.length() == 0) return true;
        
        int idxs = 0, idxp = 0, idxstar = -1, idxmatch = 0;
        
        while (idxs < s.length()) {
            if (idxp < p.length() && (s.charAt(idxs) == p.charAt(idxp) || p.charAt(idxp) == '?')) {
                idxs++;
                idxp++;
            } else if (idxp < p.length() && p.charAt(idxp) == '*') {
                idxstar = idxp;
                idxmatch = idxs;
                idxp++;
            } else if (idxstar != -1) {
                idxp = idxstar + 1;
                idxmatch++;
                idxs = idxmatch;
            } else {
                return false;
            }
        }
        
        while (idxp < p.length() && p.charAt(idxp) == '*') {
            idxp++;
        }
        
        return idxp == p.length();
    }
}
