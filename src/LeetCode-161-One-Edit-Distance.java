/*
LeetCode:  https://leetcode.com/problems/one-edit-distance/
LintCode:  
JiuZhang:  
ProgramCreek:  
https://leetcode.com/discuss/54087/easy-understood-java-solution
http://www.danielbit.com/blog/puzzle/leetcode/leetcode-one-edit-distance

Analysis:  
"" and "", false
All lower case letters? No. "a" and "A"
If s equals t? False. It's zero distance.

"", "" -> false
"a", "" ->  true
"", "a" ->  true
"a", "A" -> true
"ab", "ba"  ->  false
*/
public class Solution {
    // public boolean isOneEditDistance(String s, String t) {
    //     if(s == null || t == null || Math.abs(s.length() - t.length()) > 1) return false;
        
    //     if(s.length() == t.length()) return isOneModify(s, t);
    //     return isOneDel(s, t);
    // }
    
    // private boolean isOneModify(String s, String t){
    //     int diff = 0;
    //     for(int i = 0; i < s.length(); i++){
    //         if(s.charAt(i) != t.charAt(i)) diff++;
    //     }
    //     return diff == 1;
    // }
    
    // private boolean isOneDel(String s, String t){
    //     for(int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++){
    //         if(s.charAt(i) != t.charAt(j)){
    //             //compare the lest substring equals?
    //             return s.substring(i).equals(t.substring(j + 1)) || s.substring(i + 1).equals(t.substring(j));
    //         }
    //     }
    //     return true;
    // }
    
    // 2.Two Pointers
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null || Math.abs(s.length() - t.length()) > 1) return false;
        
        int m = s.length(), n = t.length();
        if(m < n) return isOneEditDistance(t, s);
        
        int i = 0;
        while(i < n){
            // "abcd", "abd"; "abcd", "abed"
            if(s.charAt(i) != t.charAt(i)) return s.substring(i + 1).equals(t.substring(i)) || s.substring(i + 1).equals(t.substring(i + 1));
            i++;
        }
        //t reach end
        return m - n == 1;
    }
}
