/*
Time O(N + L + K)
Space O(N)
*/
class WordDistance {

    HashMap<String, List<Integer>> map = new HashMap<>();
    
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<>());
            }
            map.get(words[i]).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        
        int p1 = 0, p2 = 0, min = Integer.MAX_VALUE;
        while(p1 < l1.size() && p2 < l2.size()) {
            min = Math.min(min, Math.abs(l1.get(p1) - l2.get(p2)));
            
            if (l1.get(p1) < l2.get(p2)) {
                p1++;
            } else {
                p2++;
            }
        }
        
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
