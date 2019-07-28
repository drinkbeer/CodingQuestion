// 1. My Own Implementation, Wrong Answer
/*
["LFUCache","put","put","put","put","get","get","get","get","put","get","get","get","get","get"]
[[3],[1,1],[2,2],[3,3],[4,4],[4],[3],[2],[1],[5,5],[1],[2],[3],[4],[5]]

Output:
[null,null,null,null,null,4,3,2,-1,null,-1,2,-1,4,5]

Expected:
[null,null,null,null,null,4,3,2,-1,null,-1,2,3,-1,5]
*/
// class LFUCache {

//     HashMap<Integer, Integer> map;
//     PriorityQueue<Integer> pq;
//     HashMap<Integer, Integer> keyToVal;
//     int capacity;
//     public LFUCache(int capacity) {
//         map = new HashMap<>();
//         pq = new PriorityQueue<>((a, b) -> map.getOrDefault(a, 0) - map.getOrDefault(b, 0));
//         keyToVal = new HashMap<>();
//         this.capacity = capacity;
//     }
    
//     public int get(int key) {
//         // System.out.println(keyToVal.toString());
//         // System.out.println(map.toString());
//         // System.out.println(pq.toString());
//         // System.out.println("   ");
        
//         if (!keyToVal.containsKey(key)) return -1;
        
//         map.put(key, map.getOrDefault(key, 0) + 1);
//         pq.remove(key);
//         pq.offer(key);
//         return keyToVal.get(key);
//     }
    
//     public void put(int key, int value) {
//         if (capacity == 0) return;
//         if (keyToVal.containsKey(key)) {
//             keyToVal.put(key, value);
//             map.put(key, map.getOrDefault(key, 0) + 1);
//             pq.remove(key);
//             pq.offer(key);
//             return;
//         }
        
//         while (pq.size() >= capacity) {
//             int k = pq.poll();
//             map.remove(k);
//             keyToVal.remove(k);
//         }
        
//         map.put(key, map.getOrDefault(key, 0) + 1);
//         pq.offer(key);
//         keyToVal.put(key, value);
        
// //         System.out.println(keyToVal.toString());
// //         System.out.println(map.toString());
// //         System.out.println(pq.toString());
// //         System.out.println("   ");
//     }
// }


/*
https://leetcode.com/problems/lfu-cache/discuss/94521/JAVA-O(1)-very-easy-solution-using-3-HashMaps-and-LinkedHashSet

At first I didn't understand why we didn't need to care about nextMin and we just could add 1 to min. Now it makes sense that min will always reset to 1 when adding a new item. And also, min can never jump forward more than 1 since updating an item only increments it's count by 1.
*/
class LFUCache {

    
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToCount;
    HashMap<Integer, LinkedHashSet<Integer>> countToKeys;
    int capacity;
    int minCount;
    public LFUCache(int capacity) {
        keyToVal = new HashMap<>();
        keyToCount = new HashMap<>();
        countToKeys = new HashMap<>();
        this.capacity = capacity;
        this.minCount = Integer.MAX_VALUE;
    }
    
    public int get(int key) {
        if (!keyToVal.containsKey(key)) return -1;
        
        // Update count in keyToCount and countToKeys
        int count = keyToCount.getOrDefault(key, 0);
        removeCount(key);
        putCount(key, count + 1);
        
        return keyToVal.get(key);
    }
    
    public void put(int key, int value) {
        if (capacity <= 0) return;
        
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key);       // get key to update the count
            return;
        }
        
        if (keyToVal.size() >= capacity) {
            int minKey = countToKeys.get(minCount).iterator().next();
            keyToVal.remove(minKey);
            removeCount(minKey);
        }
        
        minCount = 1;
        keyToVal.put(key, value);
        get(key);
    }
    
    private void putCount(int key, int count) {
        keyToCount.put(key, count);
        countToKeys.computeIfAbsent(count, k -> new LinkedHashSet<>()).add(key);
    }
    
    private void removeCount(int key) {
        if (!keyToCount.containsKey(key)) return;
        
        int count = keyToCount.get(key);
        keyToCount.remove(key);
        countToKeys.get(count).remove(key);
        
        // Remove countToKeys entry if LinkedHashSet keys are empty (not necessary actually), Update minCount if necessary
        if (countToKeys.get(count).size() == 0) {
            countToKeys.remove(count);
            if (count == minCount) {
                minCount++;
            }
        }
    }
}



/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
