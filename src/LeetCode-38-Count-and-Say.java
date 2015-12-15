/*
LeetCode: https://leetcode.com/problems/count-and-say/
LintCode: http://www.lintcode.com/problem/count-and-say/
JiuZhang: http://www.jiuzhang.com/solutions/count-and-say/
ProgramCreek: http://www.programcreek.com/2014/03/leetcode-count-and-say-java/
GeeksforGeeks: http://www.geeksforgeeks.org/look-and-say-sequence/

Analysis:

*/
public class Solution {
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
}