class Solution {
    // 1. Sliding Window (My Own solution using the Sliding Window Template, similar to Maximum Substring problem)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int start = 0, end = 0, maxStart = -1, maxLen = Integer.MIN_VALUE;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            if (map.size() <= k && end - start + 1 > maxLen) {
                maxStart = start;
                maxLen = end - start + 1;
            }
            
            while (start <= end && map.size() > k) {
                c = s.charAt(start);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                start++;
            }
            
            end++;
        }
        
        return maxStart == -1 ? 0 : maxLen;
    }
}
