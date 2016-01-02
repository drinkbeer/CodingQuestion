/*
LeetCode: https://leetcode.com/problems/anagrams/
LintCode: http://www.lintcode.com/problem/anagrams/
JiuZhang: http://www.jiuzhang.com/solutions/anagrams/
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-anagrams-java/

Analysis: 
Using HashMap as map.
*/
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0) return null;
        
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        java.util.Arrays.sort(strs);        // to ensure result is sorted
        
        for(String str : strs){
            char[] chars = str.toCharArray();
            java.util.Arrays.sort(chars);
            String s = new String(chars);
            if(map.containsKey(s)){
                map.get(s).add(str);
            }else{
                List<String> l = new ArrayList<String>();
                l.add(str);
                map.put(s, l);
            }
        }
        
        for(List<String> l : map.values()){
            result.add(l);
        }
        return result;
    }
}