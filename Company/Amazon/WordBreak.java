/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/
public class WordBreak{
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0) return false;

        boolean[] state = new boolean[s.length() + 1];
        state[0] = true;

        for(int i = 0; i < state.length; i++){
            if(!state[i]) continue;

            for(String str : wordDict){
                int end = i + str.length();
                if(end >= state.length) continue;

                if(state[end]) continue;

                if(str.equals(s.substring(i, end))) state[end] = true;
            }
        }

        return state[s.length()];
    }
}