class Solution {
    // 1. TreeMap
    /*
    Time: O(NlogN)
    */
//     public int[][] kClosest(int[][] points, int K) {
//         TreeMap<Integer, Set<int[]>> map = new TreeMap<>();
        
//         for (int[] p : points) {
//             int d = p[0] * p[0] + p[1] * p[1];
//             map.computeIfAbsent(d, k -> new HashSet<>()).add(p);
//         }
        
//         int[][] res = new int[K][];
//         int i = 0;
//         while (i < K) {
//             Set<int[]> set = map.pollFirstEntry().getValue();
//             for (int[] p : set) {
//                 res[i++] = p;
                
//                 if (i >= K) break;
//             }
//         }
        
//         return res;
//     }
    
    // 2. Max Heap
    /*
    Time: O(NlogK)
    https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.
    */
//     public int[][] kClosest(int[][] points, int K) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);
//         for (int[] p : points) {
//             pq.offer(p);
//             if (pq.size() > K) {
//                 pq.poll();
//             }
//         }
        
//         int[][] res = new int[K][2];
//         while (K > 0) {
//             res[--K] = pq.poll();
//         }
        
//         return res;
//     }
    
    // 3. Sort
    /*
    Time: O(NlogN)
    */
    // public int[][] kClosest(int[][] points, int K) {
    //     Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
    //     return Arrays.copyOfRange(points, 0, K);
    // }
    
    // 4. QuickSelect
}
