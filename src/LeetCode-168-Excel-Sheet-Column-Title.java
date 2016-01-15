/*
LeetCode:  https://leetcode.com/problems/excel-sheet-column-title/
LintCode:  http://www.lintcode.com/problem/excel-sheet-column-title/
JiuZhang:  http://www.jiuzhang.com/solutions/excel-sheet-column-title/
ProgramCreek:  http://www.programcreek.com/2014/03/leetcode-excel-sheet-column-title-java/

Analysis:  
A-Z = [0, 25]
AA-ZZ = [26-51]

1.Iterative

2.Recursive
*/
public class Solution {
    // 1.Iterative
    // public String convertToTitle(int n) {
    //     StringBuilder sb = new StringBuilder();
        
    //     //n=26, n%26=0, return 'Z'
        
    //     while(n > 0){
    //         n--;
    //         char ch = (char)(n % 26 + 'A');
    //         sb.append(ch);
    //         n /= 26;
    //     }
        
    //     return sb.reverse().toString();
    // }
    
    // 2.Recursive
    public String convertToTitle(int n) {
        if(n == 0) return "";
        
        return convertToTitle((n - 1) / 26) + (char)((n - 1) % 26 + 'A');
    }
}