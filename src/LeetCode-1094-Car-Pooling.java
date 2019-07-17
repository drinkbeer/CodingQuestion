class Solution {
    // 1. One Way Scan
    /*
    https://leetcode.com/problems/car-pooling/discuss/317611/C%2B%2BJava-O(n)-Thousand-and-One-Stops
    */
//     public boolean carPooling(int[][] trips, int capacity) {
//         int[] stops = new int[10001];
//         for (int[] t : trips) {
//             stops[t[1]] += t[0];
//             stops[t[2]] -= t[0];
//         }
        
//         for (int i = 0; i < 10001; i++) {
//             capacity -= stops[i];
//             if (capacity < 0) return false;
//         }
//         return true;
//     }

    /*
    https://leetcode.com/problems/car-pooling/discuss/317887/Java-Clean-code-use-sort-and-PriorityQueue.
    
    Example:
    
    [[2,2,6],[2,4,7],[8,6,7]]
    11
    
    The PQ:
    2  2
    4  2
    6  8
    6  -2
    7  -8
    7  -2
    
    If one trip starts at 6, another trip ends at 6, we should let those ends be first (let passenger went down first), then let passenger of next trip went up.
    So the following PQ definition doesn't work:
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(t -> t[0]));
    
    */
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int[] t : trips) {
            pq.offer(new int[] {t[1], t[0]});
            pq.offer(new int[] {t[2], -t[0]});
        }
        // printPQ(pq);
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            capacity -= t[1];
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
    

}
