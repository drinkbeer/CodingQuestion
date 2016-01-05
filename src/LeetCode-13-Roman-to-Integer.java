/*
LeetCode: https://leetcode.com/problems/roman-to-integer/
LintCode: http://www.lintcode.com/problem/roman-to-integer/
JiuZhang: http://www.jiuzhang.com/solutions/roman-to-integer/
ProgramCreek: 

Analysis: 

*/

public class Solution {
    public int romanToInt(String s) {
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int ret = 0;
        int i = 0;
        int index = 0;
        while(i < s.length() && index < 13){
            String target = symbols[index];
            int end = (i + target.length()) < (s.length() - 1) ? i + target.length() : s.length() - 1;
            String curr = s.substring(i, end);
            if(target.equals(curr)){
                ret += values[index];
                i += target.length();
            }else{
                index++;
            }
        }
        
        return ret;
    }
}