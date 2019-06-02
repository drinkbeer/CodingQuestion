/*

1.Could be extended to K distinct characters

https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/49682/Simple-O(n)-java-solution-easily-extend-to-k-characters

*/
class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>(); // char and the right most index of the char in the substring 
        
        int begin = 0, end = 0, maxLen = Integer.MIN_VALUE;
        while (end < s.length()) {
            if (map.keySet().size() <= 2) {
                map.put(s.charAt(end), end);
                end++;
            }
            
            if (map.keySet().size() > 2) {
                int leftMost = Integer.MAX_VALUE;
                for (char ch : map.keySet()) leftMost = Math.min(leftMost, map.get(ch));
                map.remove(s.charAt(leftMost));
                begin = leftMost + 1;
            }
            
            maxLen = Math.max(maxLen, end - begin);
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
}
