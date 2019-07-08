class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int min = Integer.MAX_VALUE, p1 = -1, p2 = -1;
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            
            if (word1.equals(word2)) {
                if (word1.equals(str)) {
                    if (p1 < p2) {
                        p1 = i;
                    } else {
                        p2 = i;
                    }
                }
                
            } else {
                if (word1.equals(str)) {
                    p1 = i;
                }

                if (word2.equals(str)) {
                    p2 = i;
                }
            }
            
            if (p1 >= 0 && p2 >= 0) {
                min = Math.min(min, Math.abs(p1 - p2));
            }
        }
        
        return min;
    }
}
