/*
LeetCode: https://leetcode.com/problems/isomorphic-strings/
LintCode: not find
JiuZhang: not find
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-isomorphic-strings-java/
Other: http://blog.csdn.net/fightforyourdream/article/details/17311575
        http://www.shuatiblog.com/blog/2015/02/11/isomorphic-strings/

Analysis: 
1.Two Maps
Use two maps, one put (c1, c2), another put (c2, c1)
Each time check in the two maps, if the corresponding relation is equal.
Time O(N)
Space O(N)

2.One Map (Wrong Answer, one map doesn't work)
E.g. Input "ab", "aa", put <a, a>, then put <b, a>, actually <b, a> shouldn't be put.

3.Sequence of first occurance of char (Best solution by now)
HashMap (char, firstOccuranceIndex) for each string. The encoding of firstOccuranceIndex should match.

E.g. Foo and app both encode to 011
     Abcd and hole both encode to 0123
Time O(N)
Space O(1)

*/
public class Solution {
    //1.Two Maps
    // public boolean isIsomorphic(String s, String t) {
    //     if(s == null && t == null) return true;
    //     if(s == null || t == null) return false;
    //     if(s.length() != t.length()) return false;
    //     if(s.length() == 0 && t.length() == 0) return true;
        
    //     HashMap<Character, Character> map1 = new HashMap<Character, Character>();
    //     HashMap<Character, Character> map2 = new HashMap<Character, Character>();
        
    //     for(int i = 0; i < s.length(); i++){
    //         char c1 = s.charAt(i);
    //         char c2 = t.charAt(i);
            
    //         if(map1.containsKey(c1)){
    //             if(map1.get(c1) != c2) return false;
    //         }
    //         if(map2.containsKey(c2)){
    //             if(map2.get(c2) != c1) return false;
    //         }
            
    //         map1.put(c1, c2);
    //         map2.put(c2, c1);
    //     }
        
    //     return true;
    // }
    
    // 2.One Map (Wrong Answer, one map doesn't work)
    // public boolean isIsomorphic(String s, String t) {
    //     if(s == null && t == null) return true;
    //     if(s == null || t == null) return false;
    //     if(s.length() != t.length()) return false;
    //     if(s.length() == 0 && t.length() == 0) return true;
        
    //     HashMap<Character, Character> map = new HashMap<Character, Character>();
        
    //     for(int i = 0; i < s.length(); i++){
    //         char c1 = s.charAt(i);
    //         char c2 = t.charAt(i);
            
    //         if(map.containsKey(c1)){
    //             if(map.get(c1) != c2) return false;
    //         }else{
    //             map.put(c1, c2);
    //         }
    //     }
    //     return true;
    // }
    
    // 3.Sequence of first occurance of char (best solution)
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        if(s.length() == 0 && t.length() == 0) return true;
        
        return getSequence(s).equals(getSequence(t));
    }
    
    private String getSequence(String str){
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(map.containsKey(ch)){
                sb.append(map.get(ch));
            }else{
                map.put(ch, i);
            }
        }
        
        return sb.toString();
    }
}