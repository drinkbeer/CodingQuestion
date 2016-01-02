/*
LeetCode: https://leetcode.com/problems/valid-anagram/
Other: http://www.cnblogs.com/grandyang/p/4694988.html
https://leetcode.com/discuss/49399/accepted-java-o-n-solution-in-5-lines

Analysis:
must check if s and t's length is same

1.Sort

2.Using an Array as map
*/
public class Solution {
    // 1.Sort
    // public boolean isAnagram(String s, String t) {
    //     if(s == null || t == null || s.length() != t.length()) return false;
        
    //     char[] sarr = s.toCharArray();
    //     char[] tarr = t.toCharArray();
        
    //     java.util.Arrays.sort(sarr);
    //     java.util.Arrays.sort(tarr);
        
    //     return java.util.Arrays.equals(sarr, tarr);
    // }
    
    // 2.Using an array as a map
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null || s.length() != t.length()) return false;
        
        int[] map = new int['z' - 'a' + 1];
        
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            map[ch - 'a']++;
        }
        
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map[ch - 'a']--;
        }
        
        for(int i : map){
            if(i != 0) return false;
        }
        return true;
    }
    
}