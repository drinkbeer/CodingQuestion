/*
LeetCode: https://leetcode.com/problems/palindrome-partitioning/
LintCode: http://www.lintcode.com/problem/palindrome-partitioning/
JiuZhang: http://www.jiuzhang.com/solutions/palindrome-partitioning/
ProgramCreek: http://www.programcreek.com/2013/03/leetcode-palindrome-partitioning-java/

Analysis: 
1.DFS

2.DP???not sure if DP works

*/
public class Solution {
    // 1.DFS
    private boolean isPalindrome(String str){
        int lo = 0;
        int hi = str.length() - 1;
        
        while(lo < hi){
            if(str.charAt(lo) != str.charAt(hi)) return false;
            lo++;
            hi--;
        }
        
        return true;
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> set = new ArrayList<String>();
        
        if(s == null || s.length() == 0) return result;
        
        DFS(s, 0, result, set);
        return result;
    }
    
    private void DFS(String str, int start, List<List<String>> result, List<String> set){
        // stop condition
        if(start == str.length()){
            result.add(new ArrayList<String>(set));
            return;
        }
        
        for(int end = start + 1; end <= str.length(); end++){
            String s = str.substring(start, end);
            if(isPalindrome(s)){
                set.add(s);
                DFS(str, end, result, set);
                set.remove(set.size() - 1);
            }
        }
    }
    
}