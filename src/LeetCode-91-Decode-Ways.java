/*
LeetCode: https://leetcode.com/problems/decode-ways/
LintCode: http://www.lintcode.com/problem/decode-ways/
JiuZhang: http://www.jiuzhang.com/solutions/decode-ways/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-decode-ways-java/

Analysis: 
DP
*/
public class Solution {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;
        
        int[] nums = new int[s.length() + 1];
        nums[0] = 1;    // 1-9 must be valid msg letter
        
        if(isValid(s.substring(0, 1))){     // s.substring(0, 2), which will happen if 2 is out of boundary?
            nums[1] = 1;
        }else{
            nums[1] = 0;
        }
        
        for(int i = 2; i <= s.length(); i++){
            if(isValid(s.substring(i - 2, i))){
                nums[i] += nums[i - 2];
            }
            if(isValid(s.substring(i - 1, i))){     // even it's only 1 digit, we must sure it's not 0 through isValid()
                nums[i] += nums[i - 1];
            }
            
        }
        
        return nums[s.length()];
    }
    
    private boolean isValid(String s){
        if(s.charAt(0) == '0') return false;
        int val = Integer.parseInt(s);
        if(val >= 1 && val <= 26) return true;
        return false;
    }
}