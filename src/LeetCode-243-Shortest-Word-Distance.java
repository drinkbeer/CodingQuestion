class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int n = words.length;
        int min = Integer.MAX_VALUE, l1 = -1, l2 = -1;
        for (int i = 0; i < n; i++) {
            if (word1.equals(words[i])) {
                l1 = i;
            }
            
            if (word2.equals(words[i])) {
                l2 = i;
            }
            
            if (l1 != -1 && l2 != -1) {
                min = Math.min(min, Math.abs(l1 - l2));
            }
        }
        
        return min;
    }
}
