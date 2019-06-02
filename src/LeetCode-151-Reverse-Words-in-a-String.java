/*
LeetCode: https://leetcode.com/problems/reverse-words-in-a-string/
LintCode: http://www.lintcode.com/problem/reverse-words-in-a-string/
JiuZhang: http://www.jiuzhang.com/solutions/reverse-words-in-a-string/
ProgramCreek: http://www.programcreek.com/2014/02/leetcode-reverse-words-in-a-string-java/

Analysis: 

*/
class Solution {
    
    // 1.
    /*
    Runtime: 1 ms, faster than 99.93% of Java online submissions for Reverse Words in a String.
    */
//     public String reverseWords(String s) {
//         s = s.trim();
//         String[] arr = s.split(" ");
//         StringBuilder sb = new StringBuilder();
        
//         for (int i = arr.length - 1; i >= 0; i--) {
//             if ("".equals(arr[i])) continue;
            
//             sb.append(arr[i]);
//             if (i != 0) sb.append(" ");
//         }
        
//         return sb.toString();
//     }
    
    // 2.
    /*
    Runtime: 1 ms, faster than 99.93% of Java online submissions for Reverse Words in a String.
    */
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        
        s = s.trim();
        String[] strs = s.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length - 1; i >=0; i--){
            if(!strs[i].equals("")){
                sb.append(strs[i]).append(" ");
            }
        }
        
        return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);    //remove the last " "
    }
    
    
}
