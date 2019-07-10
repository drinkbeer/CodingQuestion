/*
https://github.com/drinkbeer/CodingQuestion/blob/master/heap.md
Similar to : https://leetcode.com/problems/top-k-frequent-words/
*/
class Solution {
    // 1. Using Max Heap
//     public List<Integer> topKFrequent(int[] nums, int k) {
//         List<Integer> res = new ArrayList<>();
        
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int n : nums) {
//             map.put(n, map.getOrDefault(n, 0) + 1);
//         }
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(map.get(b), map.get(a)));
//         for (int key : map.keySet()) {
//             pq.offer(key);
//         }
        
//         while(res.size() < k) {
//             res.add(pq.poll());
//         }
        
//         return res;
//     }
    
    // 2. Using Bucket
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : map.keySet()) {
            if (bucket[map.get(key)] == null) {
                bucket[map.get(key)] = new ArrayList<>();
            }
            
            bucket[map.get(key)].add(key);
        }
        
        for (int j = bucket.length - 1; j >= 0; j--) {
            if (bucket[j] == null) continue;
            
            for (int key : bucket[j]) {
                if (res.size() < k) {
                    res.add(key);
                } else {
                    break;
                }
            }
        }
        
        return res;
        
    }
}
