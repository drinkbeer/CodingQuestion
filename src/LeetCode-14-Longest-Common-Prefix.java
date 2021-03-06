/*
LeetCode: https://leetcode.com/problems/longest-common-prefix/
LintCode: http://www.lintcode.com/problem/longest-common-prefix/
JiuZhang: http://www.jiuzhang.com/solutions/longest-common-prefix/
ProgramCreek: http://www.programcreek.com/2014/02/leetcode-longest-common-prefix-java/

Analysis: 
Method 1, start from the first one, compare prefix with next string, until end;

Method 2, start from the first char, compare it with all string, and then the second char
*/
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        
        String prefix = strs[0];
        
        for(int i = 1; i < strs.length; i++){
            int j = 0;  // start of index in each string
            while(j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) j++;
            if(j == 0) return "";
            prefix = prefix.substring(0, j);
        }
        
        return prefix;
    }
    
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        
        String str = strs[0];
        int k = str.length() - 1;
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            while (j <= k && j < strs[i].length()) {
                if (str.charAt(j) != strs[i].charAt(j)) break;
                j++;
            }
            k = j - 1;
        }
        
        return str.substring(0, k + 1);
    }
}
