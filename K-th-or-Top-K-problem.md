https://leetcode.com/problems/k-closest-points-to-origin/discuss/220235/Java-Three-solutions-to-this-classical-K-th-problem.

#### 973. K Closest Points to Origin

1. Sort or QuickSort or QuickSelect

```
    // 3. Sort
    /*
    Time: O(NlogN)
    */
    // public int[][] kClosest(int[][] points, int K) {
    //     Arrays.sort(points, (p1, p2) -> p1[0] * p1[0] + p1[1] * p1[1] - p2[0] * p2[0] - p2[1] * p2[1]);
    //     return Arrays.copyOfRange(points, 0, K);
    // }
    
    // 4. QuickSort -> migrate to QuickSelect
    /*
    Time O(NlogN)
    */
//     public int[][] kClosest(int[][] points, int K) {
//         quickSort(points, 0, points.length - 1);
        
//         int[][] res = new int[K][2];
//         while (K - 1 >= 0) {
//             res[K - 1] = points[K - 1];
//             K--;
//         }
//         return res;
//     }
    
//     public void quickSort(int[][] points, int lo, int hi) {
//         if (lo >= hi) return;
//         int partition = partition(points, lo, hi);
//         quickSort(points, lo, partition - 1);
//         quickSort(points, partition + 1, hi);
//     }
    
//     private int partition(int[][] points, int lo, int hi) {
//         int pivot = points[hi][0] * points[hi][0] + points[hi][1] * points[hi][1];
//         int s = lo;
//         for (int i = lo; i < hi; i++) {
//             if (points[i][0] * points[i][0] + points[i][1] * points[i][1] < pivot) {
//                 // swap i and s
//                 int[] temp = points[s];
//                 points[s] = points[i];
//                 points[i] = temp;
                
//                 s++;
//             }
//         }
        
//         // swap hi with s
//         int[] temp = points[s];
//         points[s] = points[hi];
//         points[hi] = temp;
        
//         return s;
//     }
    
    // QuickSelect
    /*
    Avg Time: O(N)
    Worst Time: O(N^2)
    */
    public int[][] kClosest(int[][] points, int K) {
        quickSort(points, K, 0, points.length - 1);
        
        int[][] res = new int[K][2];
        while (K - 1 >= 0) {
            res[K - 1] = points[K - 1];
            K--;
        }
        return res;
    }
    
    public void quickSort(int[][] points, int K, int lo, int hi) {
        if (lo >= hi) return;
        int partition = partition(points, lo, hi);
        if (partition == K) {
            return;
        } else if (partition < K) {
            quickSort(points, K, partition + 1, hi);
        } else {
            quickSort(points, K, lo, partition - 1);
        }
    }
    
    private int partition(int[][] points, int lo, int hi) {
        int pivot = points[hi][0] * points[hi][0] + points[hi][1] * points[hi][1];
        int s = lo;
        for (int i = lo; i < hi; i++) {
            if (points[i][0] * points[i][0] + points[i][1] * points[i][1] < pivot) {
                // swap i and s
                int[] temp = points[s];
                points[s] = points[i];
                points[i] = temp;
                
                s++;
            }
        }
        
        // swap hi with s
        int[] temp = points[s];
        points[s] = points[hi];
        points[hi] = temp;
        
        return s;
    }
```

2. TreeMap
```
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
```

3. Heap

```
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
```
