class Solution {
    // 1. Using CharArray
    /*
    https://leetcode.com/problems/shortest-completing-word/discuss/110137/Java-Solution-using-character-Array
    
    Runtime: 2 ms, faster than 99.39% of Java online submissions for Shortest Completing Word.
    Memory Usage: 38.7 MB, less than 100.00% of Java online submissions for Shortest Completing Word.
    */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        
        int[] mask = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                mask[c - 'a']++;
            }
        }
        
        int minLen = Integer.MAX_VALUE;
        String res = null;
        for (String s : words) {
            if (matches(s, mask) && s.length() < minLen) {
                minLen = s.length();
                res = s;
            }
        }
        
        return res == null ? "" : res;
    }
    
    private boolean matches(String s, int[] mask) {
        int[] sMask = new int[26];
        for (char c : s.toCharArray()) {
            sMask[c - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (mask[i] > 0 && sMask[i] < mask[i]) return false;
        }
        
        return true;
    }
}
