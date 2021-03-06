/*
LeetCode: https://leetcode.com/problems/implement-strstr/
LintCode: http://www.lintcode.com/problem/implement-strstr/
JiuZhang: http://www.jiuzhang.com/solutions/implement-strstr/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-implement-strstr-java/

Analysis: 
Be careful that if needle is empty, then no matter what haystack is, return 0.
If haystack is empty, then if needle is empty return 0, if needle is not empty return -1.

Edge cases:
"", ""
"", "a"
"a", ""
"a", "a"  <-- if make "i < haystack.length() - needle.length()", this case will fail

*/
public class Solution {
    // 1.Two Pointers
    // public int strStr(String haystack, String needle) {
    //     if(haystack == null || needle == null ) return 0;
    //     if(needle.length() == 0) return 0;
        
    //     for(int i = 0; i <=  haystack.length() - needle.length(); i++){
    //         int m = i;
    //         int j = 0;
    //         for(; j < needle.length(); j++){
    //             if(haystack.charAt(m) != needle.charAt(j)) break;
    //             m++;
    //         }
    //         if(j == needle.length()) return i;
    //     }
    //     return -1;
    // }
    
    // 2.Directly use String.indexOf(String). Perhaps we are not allowed to use it in interview.
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null ) return 0;
        if(needle.length() == 0) return 0;
        
        return haystack.indexOf(needle);
    }
    
    
}
