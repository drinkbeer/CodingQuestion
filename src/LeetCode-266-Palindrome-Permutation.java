/*
LeetCode: https://leetcode.com/problems/palindrome-permutation/
LintCode: 
JiuZhang: Not find
ProgramCreek: Not find

Analysis: 
Use a HashMap to statisc the occurance of chars in String.
*/
public class Solution {
    public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }else{
                map.put(s.charAt(i), 1);
            }
        }
        
        int count = 0;
        Iterator iter = map.keySet().iterator();
        while(iter.hasNext()){
            char key = (char)iter.next();
            int value = (int)map.get(key);
            if(value % 2 == 1) count++;
            if(count > 1) return false;
        }
        
        return true;
    }
}