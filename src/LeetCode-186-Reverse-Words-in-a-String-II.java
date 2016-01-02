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
}