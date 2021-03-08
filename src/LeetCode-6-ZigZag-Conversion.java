/*
LeetCode: https://leetcode.com/problems/zigzag-conversion/
LintCode: http://www.lintcode.com/problem/zigzag-conversion/
JiuZhang: http://www.jiuzhang.com/solutions/zigzag-conversion/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-zigzag-conversion-java/

Analysis:
这道题就是看坐标的变化。并且需要分块处理。

 n=2时，字符串坐标变成zigzag的走法就是：

 0 2 4 6

 1 3 5 7

 n=3时的走法是：

 0     4     8

 1  3 5  7 9

 2     6    10 

 n=4时的走法是：

 0      6        12

 1   5  7    11  13

 2  4   8  10    14

 3      9        15 

 
 可以发现规律，画红色的长度永远是 2n-2 （想法是你试想把所有这些行压缩成两列，两边手挤一下，第二列永远的第一行和最后一行少字）。
 利用这个规律，可以按行填字，第一行和最后一行，就是按照2n-2的顺序一点点加的。
 其他行除了上面那个填字规则，就是还要处理斜着那条线的字，可以发现那条线的字的位置永远是当前列j+(2n-2)-2i(i是行的index）。 
 按照上面的规律就可以写出代码了。
 
 Step1 = 2n-2
 Step2 = j+(2n-2)-2i
*/
public class Solution {
    public String convert(String s, int numRows) {
        if(s == null || s.length() == 0 || numRows < 1) return "";
        if(numRows == 1) return s;  // this is important, because if numRows is 1, the step is 0, the loop will be dead loop.
        
        StringBuilder sb = new StringBuilder();
        int step = 2 * numRows - 2;
        
        for(int i = 0; i < numRows; i++){
            // each row
            for(int j = i; j < s.length(); j += step){
                sb.append(s.charAt(j));
                if(i != 0 && i != numRows - 1){
                    int step2 = j + step - 2 * i;
                    if(step2 < s.length()) sb.append(s.charAt(step2));
                }
            }
        }
        
        return sb.toString();
    }
}
