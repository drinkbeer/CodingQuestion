/*
LeetCode: https://leetcode.com/problems/word-pattern/
LintCode: not find
JiuZhang: not find
ProgramCreek: not find

1.Sequence of first occurance

2.Use One Map
https://leetcode.com/discuss/62374/8-lines-simple-java
get through pattern letter and string array in parallel and compare the indice they last appear.

*/
public class Solution {
    // 1.Sequence of first occurance
    // public boolean wordPattern(String pattern, String str) {
    //     String[] strs = str.split(" ");
    //     if(pattern.length() != strs.length) return false;    //Notice, here we need to compare the array's length to pattern's
        
    //     return getSequence(pattern).equals(getSequence(strs));
    // }
    
    // private String getSequence(String str){
    //     HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
    //     StringBuilder sb = new StringBuilder();
    //     for(int i = 0; i < str.length(); i++){
    //         char ch = str.charAt(i);
    //         if(map.containsKey(ch)){
    //             sb.append(map.get(ch));
    //         }else{
    //             map.put(ch, i);
    //         }
    //     }
        
    //     return sb.toString();
    // }
    
    // private String getSequence(String[] strs){
    //     HashMap<String, Integer> map = new HashMap<String, Integer>();
        
    //     StringBuilder sb = new StringBuilder();
    //     for(int i = 0; i < strs.length; i++){
    //         String str = strs[i];
    //         if(map.containsKey(str)){
    //             sb.append(map.get(str));
    //         }else{
    //             map.put(str, i);
    //         }
    //     }
        
    //     return sb.toString();
    // }
    
    // 2.Use one map, last occurance
    // public boolean wordPattern(String pattern, String str) {
    //     String[] strs = str.split(" ");
    //     if(pattern.length() != strs.length) return false; //Notice, here we need to compare the array's length to pattern's
        
    //     Map map = new HashMap();
    //     // for(Integer i = 0; i < strs.length; i++){
    //     //     if(map.put(pattern.charAt(i), i) != map.put(strs[i], i)) return false;
    //     // }
        
    //     for(int i = 0; i < strs.length; i++){
    //         if(!Objects.equals(map.put(pattern.charAt(i), i), map.put(strs[i], i))) return false;
    //     }
    //     return true;
    // }
    
    // 3.One Map, first occurance
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if(pattern.length() != strs.length) return false; //Notice, here we need to compare the array's length to pattern's
        
        Map map = new HashMap();
        for(Integer i = 0; i < strs.length; i++){
            if(map.putIfAbsent(pattern.charAt(i), i) != map.putIfAbsent(strs[i], i)) return false;
        }
        
        // for(int i = 0; i < strs.length; i++){
        //     if(!Objects.equals(map.putIfAbsent(pattern.charAt(i), i), map.putIfAbsent(strs[i], i))) return false;
        // }
        return true;
    }
    
}