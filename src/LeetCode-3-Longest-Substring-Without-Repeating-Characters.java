/*
LeetCode: https://leetcode.com/problems/longest-substring-without-repeating-characters/
LintCode: 
JiuZhang: http://www.jiuzhang.com/solutions/longest-substring-without-repeating-characters/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/

Analysis:
Use two pointers.
*/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int[] map = new int[256];   // map from character's ASCII to if it's visited
        java.util.Arrays.fill(map, -1);
        
        int slow = 0, result = 0;
        
        for(int fast = 0; fast < s.length(); fast++){
            int ch = s.charAt(fast);
            if(map[ch] >= slow){
                result = Math.max(result, fast - slow);
                slow = map[ch] + 1;
            }
            map[ch] = fast;
        }
        
        return Math.max(result, s.length() - slow);
    }
}