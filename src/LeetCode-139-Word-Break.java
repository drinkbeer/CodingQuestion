/*
LeetCode: https://leetcode.com/problems/word-break/
LintCode: http://www.lintcode.com/problem/word-break/
JiuZhang: http://www.jiuzhang.com/solutions/word-break/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-solution-word-break/

Analysis: 
1.DFS
Time Limit Exceed
Time O(N^2*wordDict Size) ???

2.DP
Time O(N*dict size)
*/
public class Solution {
    
    // 2.DP
    public boolean wordBreak(String s, Set<String> wordDict) {
        // state
        boolean[] state = new boolean[s.length() + 1];
        state[0] = true;    //why initialized true? state[0] has function of dummy node in List problem
        
        // canculate state
        for(int i = 0; i <= s.length(); i++){
            if(!state[i]) continue;  //if start char is not true, don't need to continue calculating
            
            for(String word : wordDict){
                int len = word.length();
                int end = i + len;  //notice, i is start, end is the next char index of next word
                if(end > s.length()) continue;
                
                if(state[end]) continue;    //optimize: if has already true, we don't need to calculate
                
                if(s.substring(i, end).equals(word)){
                    state[end] = true;
                }
            }
        }
        
        return state[s.length()];
    }
    
    // 1.DFS
    // Time Limit Exceed
// 	public boolean wordBreak(String s, Set<String> wordDict) {
// 		return wordBreak(s, wordDict, 0);
// 	}
	
// 	private boolean wordBreak(String s, Set<String> wordDict, int start){
// 		// end condition
// 		if(start == s.length()) return true;
		
// 		for(int i = start; i < s.length(); i++){
			
// 			for(String str : wordDict){
// 				int end = i + str.length();     //Corner case: think carefully the end
				
// 				if(end > s.length()) continue;
				
// 				if(s.substring(i, end).equals(str)){
// 					if(wordBreak(s, wordDict, end)) return true;
// 				}
// 			}
// 		}
// 		return false;
// 	}
    
}
