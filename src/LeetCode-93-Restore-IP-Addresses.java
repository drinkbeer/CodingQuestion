/*
LeetCode: https://leetcode.com/problems/restore-ip-addresses/
LintCode: http://www.lintcode.com/problem/restore-ip-addresses/
JiuZhang: http://www.jiuzhang.com/solutions/restore-ip-addresses/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-restore-ip-addresses-java/
Other: http://www.cnblogs.com/yuzhangcmu/p/4106686.html

Analysis: 

*/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() < 4 || s.length() > 12) return result;
        
        List<String> list = new ArrayList<String>();
        DFS(s, 0, result, list);
        return result;
    }
    
    private void DFS(String s, int start, List<String> result, List<String> list){
        // end condition
        if(list.size() == 4){
            if(start != s.length()) return;
            
            StringBuffer sb = new StringBuffer();
            for(String str : list){
                sb.append(str).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }
        
        for(int i = start; i < s.length() && i <= start + 3; i++){
            String tmp = s.substring(start, i + 1);
            if(isValid(tmp)){
                list.add(tmp);
                DFS(s, i + 1, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isValid(String s){
        if(s.charAt(0) == '0') return s.equals("0");    // to eliminate cases like "00", "10"
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
}