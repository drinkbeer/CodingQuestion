/*
LeetCode: https://leetcode.com/problems/length-of-last-word/
LintCode: http://www.lintcode.com/problem/length-of-last-word/
JiuZhang: http://www.jiuzhang.com/solutions/length-of-last-word/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-length-of-last-word-java/

Analysis:
Scan from tail to head. Notice if several tail character is ' '
*/
public class Solution {
    // 1.
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int length = 0;
        
        for(int i = s.length() - 1; i >= 0; i--){
            if(length == 0){
                if(s.charAt(i) == ' ') continue;
                else length++;
            }else{
                if(s.charAt(i) == ' ') break;
                else length++;
            }
        }
        return length;
    }
    
    // 2.
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        
        String[] strs = s.split(" ");
        if (strs.length > 0) {
            return strs[strs.length - 1].length();
        }
        
        return 0;
    }
    
    // 3.
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;        
    }
}
