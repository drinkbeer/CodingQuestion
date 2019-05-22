/*
LeetCode: https://leetcode.com/problems/longest-substring-without-repeating-characters/
LintCode: 
JiuZhang: http://www.jiuzhang.com/solutions/longest-substring-without-repeating-characters/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-longest-substring-without-repeating-characters-java/
Other: http://fisherlei.blogspot.com/2012/12/leetcode-longest-substring-without.html


Analysis:
Use two pointers.
*/
public class Solution {
    // 1.Two Pointers, using a int[] as mask.
    // public int lengthOfLongestSubstring(String s) {
        
    //     int[] map = new int[256];   // map from character's ASCII to if it's visited
    //     java.util.Arrays.fill(map, -1);
        
    //     int slow = 0, result = 0;
        
    //     for(int fast = 0; fast < s.length(); fast++){
    //         int ch = s.charAt(fast);
    //         if(map[ch] >= slow){
    //             // map[ch]>=slow, means curr ch has visited, so distance is (fast-1)-slow+1 = fast-slow
    //             // if not visited, map[ch]==-1, must < slow
    //             result = Math.max(result, fast - slow);
    //             slow = map[ch] + 1; //slow record the pos of 'last repeat ch' pos + 1
    //         }
    //         map[ch] = fast;
    //     }
        
    //     return Math.max(result, s.length() - slow);
    // }
    
    // 2. Two Pointers, similar to JiuZhang's algorithm, using a int[] as mask.
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];   // map from character's ASCII to if it's visited        
        int result = Integer.MIN_VALUE;
        
        int slow = 0, fast = 0;
        for(; slow < s.length(); slow++){
            while (fast < s.length() && map[s.charAt(fast)] == 0) {
                map[s.charAt(fast)] = 1; 
                result = Math.max(result, fast - slow + 1);
                fast++;
            }
            map[s.charAt(slow)] = 0;
        }
        
        return result == Integer.MIN_VALUE ? 0 : result;
    }
    
    // 3. Two Pointers
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        
        HashSet<Character> set = new HashSet<Character>();
        
        int slow = 0, result = 0;
        for(int fast = 0; fast < s.length(); fast++){
            char ch = s.charAt(fast);
            if(set.contains(ch)){
                while(slow < fast && s.charAt(slow) != ch){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }else{
                set.add(s.charAt(fast));
                result = Math.max(result, fast - slow + 1);
            }
        }
        
        return result;
    }
    
    // 4. Two Pointers, using a Set as Mask.
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        
        int lo = 0, hi = 0, max = 0;
        while(hi < s.length()) {
            
            if (!set.contains(s.charAt(hi))) {
                set.add(s.charAt(hi));
                max = Math.max(max, hi - lo + 1);
                hi++;
            } else {
                set.remove(s.charAt(lo));
                lo++;
            }
        }
        
        return max;
    }
}
