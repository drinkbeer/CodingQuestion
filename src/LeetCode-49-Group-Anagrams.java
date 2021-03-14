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
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (String str : strs) {
            String formatted = formatStr(str);
            map.putIfAbsent(formatted, new ArrayList<>());
            map.get(formatted).add(str);
        }
        
        for(List<String> l : map.values()) {
            result.add(l);
        }
        
        return result;
    }
    
    private String formatStr(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
