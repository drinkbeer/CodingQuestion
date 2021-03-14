/*
LeetCode: https://leetcode.com/problems/reverse-words-in-a-string-ii/
LintCode: 
JiuZhang: 
ProgramCreek: 

Analysis: 
    1.Reverse the whole array
    2.Reverse the subarray seperated by ' '
Be careful, the last subarray should also be reversed. For example, "hi!" should be reversed in second step.
*/
public class Solution {
    // 1.
    public void reverseWords(char[] s) {
        if(s == null || s.length <= 1)return;
        reverseWords(s, 0, s.length - 1);
        
        int last = 0;
        for(int i = 0; i <= s.length; i++){
            if(i == s.length || s[i] == ' '){   // be careful about the last subarray
                reverseWords(s, last, i - 1);
                last = i + 1;
            }
        }
    }
    
    private void reverseWords(char[] s, int lo, int hi){
        while(lo < hi){
            char temp = s[lo];
            s[lo] = s[hi];
            s[hi] = temp;
            lo++;
            hi--;
        }
    }
    
    // 2.
//     public void reverseWords(char[] str) {
//         int begin = 0, end = 0;
//         while (end < str.length) {
//             if (str[end] == ' ') {
//                 reverse(str, begin, end - 1);
//                 begin = end + 1;
//                 end = begin;
//             } else {
//                 end++;
//             }
//         }
        
//         if (begin < end) reverse(str, begin, end - 1);
        
//         reverse(str, 0, str.length - 1);
//     }
    
//     private void reverse(char[] str, int i, int j) {
//         while(i < j) {
//             char temp = str[i];
//             str[i] = str[j];
//             str[j] = temp;
//             i++;
//             j--;
//         }
//     }
    
    // 3
    public void reverseWords(char[] s) {
        int begin = 0, end = 0;
        while (end < s.length) {
            while (end < s.length && s[end] != ' ') end++;
            
            if (begin != end) {
                reverse(s, begin, end - 1);
            }
            
            while (end < s.length && s[end] == ' ') end++;
            begin = end;
        }
        
        reverse(s, 0, s.length - 1);
    }
    
    private void reverse(char[] s, int l, int r) {
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            
            l++;
            r--;
        }
    }
    
}
