/*
LeetCode:  https://leetcode.com/problems/excel-sheet-column-number/
LintCode:  not find
JiuZhang:  not find
ProgramCreek:  http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-number-java/

Analysis:  
1.Iterative

2.Recursive

*/
public class Solution {
    // 1.Iterative
    // public int titleToNumber(String s) {
    //     if(s == null || s.length() == 0) return 0;
        
    //     int result = 0;
    //     while(s.length() > 0){
    //         char ch = s.charAt(0);
    //         result = 26 * result + ch - 'A' + 1;
    //         s = s.substring(1);
    //     }
    //     return result;
    // }
    
    // 2.Recursive
    public int titleToNumber(String s) {
        if(s.equals("")) return 0;
        return 26 * titleToNumber(s.substring(0, s.length() - 1)) + s.charAt(s.length() - 1) - 'A' + 1;
    }
}