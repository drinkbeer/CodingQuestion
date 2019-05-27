/*
LeetCode: https://leetcode.com/problems/add-binary/
LintCode: http://www.lintcode.com/problem/add-binary/
JiuZhang: http://www.jiuzhang.com/solutions/add-binary/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-add-binary-java/

Analysis: 

*/
public class Solution {
    // 1.
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;
        
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        String result = "";
        
        while(i >= 0 || j >= 0){
            int val = carry;
            if(i >= 0){
                int ai = Character.getNumericValue(a.charAt(i));
                val += ai;
                i--;
            }
            
            if(j >= 0){
                int bi = Character.getNumericValue(b.charAt(j));
                val += bi;
                j--;
            }
            
            result = val % 2 + result;
            carry = val / 2;
        }
        
        if(carry == 1) result = carry + result;
        
        return result;
    }
    
    // 2.
//     public String addBinary(String a, String b) {
//         int[] sum = new int[Math.max(a.length(), b.length())];
//         int k = sum.length - 1;
//         int carry = 0;
        
//         int i = a.length() - 1, j = b.length() - 1;
//         while (i >= 0 && j >= 0) {
//             int first = a.charAt(i) - '0';
//             int second = b.charAt(j) - '0';
//             int s = first + second + carry;
//             carry = s / 2;
//             sum[k--] = s % 2;
//             i--;
//             j--;
//         }
        
//         while (i >= 0) {
//             int first = a.charAt(i) - '0';
//             int s = first + carry;
//             carry = s / 2;
//             sum[k--] = s % 2;
//             i--;
//         }
        
//         while (j >= 0) {
//             int second = b.charAt(j) - '0';
//             int s = second + carry;
//             carry = s / 2;
//             sum[k--] = s % 2;
//             j--;
//         }
        
//         String res = "";
//         for (int num : sum) res += num;
//         if (carry > 0) {
//             res = carry + res;
//         }
//         return res;
//     }
}
