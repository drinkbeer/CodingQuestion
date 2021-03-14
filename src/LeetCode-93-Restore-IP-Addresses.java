/*
LeetCode: https://leetcode.com/problems/restore-ip-addresses/
LintCode: http://www.lintcode.com/problem/restore-ip-addresses/
JiuZhang: http://www.jiuzhang.com/solutions/restore-ip-addresses/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-restore-ip-addresses-java/
Other: http://www.cnblogs.com/yuzhangcmu/p/4106686.html

Analysis: 

*/
class Solution {
    
    // 1.String operation
    /**
    Runtime: 2 ms, faster than 87.03% of Java online submissions for Restore IP Addresses.
    */
//     public List<String> restoreIpAddresses(String s) {
//         List<String> result = new ArrayList<>();
//         if (s == null || s.length() < 4 || s.length() > 12) return result;
//         int len = s.length();
//         for (int i = 1; i < 4; i++) {
//             for (int j = i + 1; j < i + 4; j++) {
//                 for (int k = j + 1; k < j + 4 && k < len; k++) {
//                     String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, len);
//                     if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
//                         result.add(s1 + "." + s2 + "." + s3 + "." + s4);
//                     }
//                 }
//             }
//         }
        
//         return result;
//     }
    
//     private boolean isValid(String str) {
//         if (str.length() > 1 && (str.charAt(0) == '0' || Integer.parseInt(str) > 255)) return false;
//         return true;
//     }
    
    // 2.DFS
    /*
    Runtime: 2 ms, faster than 87.03% of Java online submissions for Restore IP Addresses.

    */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12) return result;
        
        DFS(s, 0, result, new ArrayList<>());
        return result;
    }
    
    private void DFS(String s, int start, List<String> result, List<String> list) {
        // end condition
        if (list.size() == 4) {
            if (start != s.length()) return;
            
            StringBuilder sb = new StringBuilder();
            for (String str : list) {
                sb.append(str).append(".");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            return;
        }
        
        // substring [start, i], i is inclusive
        for (int i = start; i < s.length() && i <= start + 2; i++) {
            String tmp = s.substring(start, i + 1);
            if (isValid(tmp)) {
                list.add(tmp);
                DFS(s, i + 1, result, list);
                list.remove(list.size() - 1);
            }
        }
    }
    
    private boolean isValid(String s) {
        if (s.charAt(0) == '0') return s.equals("0");       // to eliminate cases like "00", "01"
        int digit = Integer.valueOf(s);
        return digit >= 0 && digit <= 255;
    }
    
}
