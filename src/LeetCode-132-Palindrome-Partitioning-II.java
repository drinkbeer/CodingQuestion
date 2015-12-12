/*
LeetCode: https://leetcode.com/problems/palindrome-partitioning-ii/
LintCode: 
JiuZhang: http://www.jiuzhang.com/solutions/palindrome-partitioning-ii/
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-palindrome-partitioning-ii-java/
Others: http://blog.csdn.net/ljphhj/article/details/22573983

Analysis:
DP problem.
We need two array, 
    1.adjancy matrix of state, state[left][right] = true means s.substring(left, right + 1) is palindrome
    2.function array, f[i] means the minimum # of cuts of s.substring(0, i + 1)
Two situations the substring is a palindrome:
    1.s.charAt(left) == s.charAt(right) && right - left <=1
    2.s.charAt(left) == s.charAt(right) && state[left + 1][right - 1]
    these two situations are combined as s.charAt(left) == s.charAt(right) && (right - left <= 1 || state[left + 1][right - 1])
We can calculate state matrix first, or we can calculate it during calculating f[]

Time complexity: O(n^2)
*/
public class Solution {
    // public int minCut(String s) {
    //     if(s == null) return 0;
    //     int len = s.length();
        
    //     // state
    //     boolean[][] state = new boolean[len][len];
        
    //     //function
    //     int[] f = new int[len];
        
    //     for(int right = 0; right < len; right++){ 
    //         // initialize function
    //         f[right] = right;
    //         for(int left = 0; left <= right; left++){
                
    //             if(s.charAt(left) == s.charAt(right) && (right - left <= 1 || state[left + 1][right - 1])){
    //                 state[left][right] = true;  // initialize state
                    
    //                 if(left > 0) f[right] = Math.min(f[right], f[left - 1] + 1);
    //                 else f[right] = 0;
    //             }
    //         }
    //     }
        
    //     return f[len - 1];
    // }
    
    //Calculating state matrix first.
    public int minCut(String s) {
        if(s == null) return 0;
        int len = s.length();
        
        //state
        boolean[][] state = initializeState(s);
        
        //function, # of min cut
        int[] f = new int[len];
        
        //initialize function
        f[0] = 0;
        for(int i = 1; i < len; i++) f[i] = i;
        
        //calculate function
        for(int right = 1; right < len; right++){
            for(int left = 0; left <= right; left++){
                
                if(state[left][right]) {
                    if(left > 0) f[right] = Math.min(f[right], f[left - 1] + 1);
                    else f[right] = 0;
                }
            }
        }
        
        return f[len - 1];
    }
    
    private boolean[][] initializeState(String s){
        int len = s.length();
        
        boolean[][] state = new boolean[len][len];
        
        //calculate state matrix, 3 steps
        //1.length == 0
        for(int i = 0; i < len; i++) state[i][i] = true;
        
        //2.length == 1
        for(int i = 0; i < len - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)) state[i][i + 1] = true;
        }
        
        //3. 1 < length < len
        for(int length = 2; length < len; length++){
            for(int start = 0; start + length < len; start++){
                if(s.charAt(start) == s.charAt(start + length) && state[start + 1][start + length - 1]) state[start][start + length] = true;
            }
        }
        
        return state;
    }
}