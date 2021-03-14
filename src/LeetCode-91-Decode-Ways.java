/*
LeetCode: https://leetcode.com/problems/decode-ways/
LintCode: http://www.lintcode.com/problem/decode-ways/
JiuZhang: http://www.jiuzhang.com/solutions/decode-ways/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-decode-ways-java/

Analysis: 
DP
*/
public class Solution {
    // 1.DP
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
    
    // 2. DP, Time O(N), Space O(N)
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int[] dp = new int[s.length() + 1];     // index is the end of substring (exclusive). S.substring(start, i)
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;     // 1 -> substring(0, 1), the first character is '0' or a valid number
        
        
        for (int i = 2; i <= s.length(); i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));
            
            if (one >= 1 && one <= 9) dp[i] += dp[i - 1];
            if (two >= 10 && two <= 26) dp[i] += dp[i - 2];
        }
        
        return dp[dp.length - 1];
    }
    
    // 3. DP Time O(N), Space O(1)    
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int[] state = new int[3];
        state[0] = 1;
        state[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for (int i = 2; i <= s.length(); i++) {
            int one = Integer.parseInt(s.substring(i - 1, i));
            int two = Integer.parseInt(s.substring(i - 2, i));
            state[i % 3] = 0;
            if (one >= 1 && one <= 9) state[i % 3] += state[(i - 1) % 3];
            if (two >= 10 && two <= 26) state[i % 3] += state[(i - 2) % 3];
        }
        
        return state[s.length() % 3];
    }
}
