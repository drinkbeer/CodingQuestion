/*
LeetCode: https://leetcode.com/problems/string-to-integer-atoi/
LintCode: http://www.lintcode.com/problem/string-to-integer-atoi/
JiuZhang: http://www.jiuzhang.com/solutions/string-to-integer-atoi/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/

Analysis: 
Be careful to use double to store result

Test Cases:
"-2147483648" == -2^31      --> -2147483648
"2147483647" == 2^31 - 1    --> 2147483647
"-2147483649" == -(2^31+1)  --> -2147483648
"2147483648" == 2^31        --> 2147483647
"-0012a42"                  --> "-12"
"  "                        --> 0
*/
public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) return 0;
        str = str.trim();
        if (str.length() == 0) return 0;    // string with all empty character
        
        boolean isPositive = true;
        if(str.charAt(0) == '-'){
            isPositive = false;
            str = str.substring(1);
        }else if(str.charAt(0) == '+'){
            str = str.substring(1);
        }
        
        double val = 0;     //to ensure if the val is > than Integer.MAX_VALUE or < Integer.MIN_VALUE
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) - '0' < 0 || str.charAt(i) - '0' > 9) break;   // "-0012a42" --> "-12"
            val = val * 10 + (str.charAt(i) - '0');
        }
        
        if(!isPositive) val = -val;
        if(val > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(val < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)val;
    }
}
