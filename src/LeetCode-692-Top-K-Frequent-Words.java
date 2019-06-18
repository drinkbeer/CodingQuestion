class Solution {
    // 1. HashMap frequency + bucket sort
    /*
    Time O(N)
    Space O(N)
    
    https://leetcode.com/problems/top-k-frequent-words/discuss/309702/My-simple-Java-solution-using-Bucket
    
    */
//     public List<String> topKFrequent(String[] words, int k) {
//         HashMap<String, Integer> frequencyMap = new HashMap<>();
//         for (String w : words) frequencyMap.put(w, frequencyMap.getOrDefault(w, 0) + 1);
        
//         List<String>[] bucket = new List[words.length + 1];     // index is frequency
//         for (String w : frequencyMap.keySet()) {
//             int frequency = frequencyMap.get(w);
//             if (bucket[frequency] == null) bucket[frequency] = new ArrayList<>();
            
//             // {love=2, coding=1, i=2, leetcode=1}
//             bucket[frequency].add(w);
//         }
        
//         System.out.println(frequencyMap.toString());
//         System.out.println(Arrays.toString(bucket));
        
//         List<String> res = new ArrayList<>();
//         for (int i = bucket.length - 1; i >= 0; i--) {
//             if (bucket[i] == null) continue;
            
//             Collections.sort(bucket[i]);
            
//             for (String w : bucket[i]) {
//                 if (res.size() < k) {
//                     res.add(w);
//                 }
//             }
//         }
        
//         return res;
//     }
    
    // 2. HashMap frequency + PriorityQueue frequency
    /*
    https://leetcode.com/problems/top-k-frequent-words/discuss/302048/Plain-and-simple
    */
    public List<String> topKFrequent(String[] words, int k) {
        // Arrays.sort(words, Collections.reverseOrder());
        
        // build frequency map
        HashMap<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
        
        // build frequency priority queue - Max Heap
        // be careful, here we must make the pq to be descending. If the frequency is the same, then alphabet order
        PriorityQueue<String> queue = new PriorityQueue(new Comparator<String>(){
            public int compare(String s1, String s2) {
                if (map.get(s1) == map.get(s2)) return s1.compareTo(s2);
                return map.get(s2) - map.get(s1);
            }
        });
        for (String w : map.keySet()) queue.offer(w);
        
        // get result from frequency pq
        List<String> res = new ArrayList<>();
        for (int i = 0; i < k; i++) res.add(queue.poll());
        
        return res;
    }
    
}
