/*
LeetCode: https://leetcode.com/problems/count-and-say/
LintCode: http://www.lintcode.com/problem/count-and-say/
JiuZhang: http://www.jiuzhang.com/solutions/count-and-say/
ProgramCreek: http://www.programcreek.com/2014/03/leetcode-count-and-say-java/
GeeksforGeeks: http://www.geeksforgeeks.org/look-and-say-sequence/
https://discuss.leetcode.com/topic/1296/please-change-the-misleading-description/7

Understand the question:
"Count and Say problem" Write a code to do following:

n String to print
1.     1
2.     11
3.     21
4.     1211
5.     111221 
6.     312211
7.     13112221
8.     1113213211
9.     31131211131221
10.   13211311123113112211
...
Base case: n = 0 print "1"
for n = 1, look at previous string and write number of times a digit is seen and the digit itself. In this case,
digit 1 is seen 1 time in a row... so print "1 1"
for n = 2, digit 1 is seen two times in a row, so print "2 1"
for n = 3, digit 2 is seen 1 time and then digit 1 is seen 1 so print "1 2 1 1"
for n = 4 you will print "1 1 1 2 2 1"

Consider the numbers as integers for simplicity. e.g. if previous string is "10 1" then the next will be "1 10 1 1" and the next one will be "1 1 1 10 2 1"


Analysis:
Test Case:
Input: n = 3
Output: 21

Input: n = 5
Output: 111221

The idea is simple, we generate all terms from 1 to n. First two terms are initialized as “1” and “11”, and all other terms are generated using previous terms. To generate a term using previous term, we scan the previous term. While scanning a term, we simply keep track of count of all consecutive characters. For sequence of same characters, we append the count followed by character to generate the next term.
*/
public class Solution {
    // 1.
    public String countAndSay(int n) {
        String oldString = "1";
        
        while(--n > 0){
            char[] oldChars = oldString.toCharArray();
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < oldChars.length; i++){
                int count = 1;
                while((i + 1) < oldChars.length && oldChars[i] == oldChars[i + 1]){
                    count++;
                    i++;
                }
                
                sb.append(count).append(oldChars[i]);
            }
            oldString = sb.toString();
        }
        
        return oldString;
    }
    
    // 2.
    public String countAndSay(int n) {
        String oldStr = "1";
        
        while (--n > 0) {
            int count = 1;
            String newStr = "";
            for (int i = 0; i < oldStr.length(); i++) {
                if (i < oldStr.length() - 1 && oldStr.charAt(i) == oldStr.charAt(i + 1)) {
                    count++;
                } else {
                    newStr += count;
                    newStr += oldStr.charAt(i);
                    count = 1;
                }
            }
            oldStr = newStr;
        }
        
        return oldStr;
    }
    
}
