class Solution {
    // 1. Wrong Answer
    // public int kthSmallest(int[][] matrix, int k) {
    //     if (matrix == null || matrix.length == 0) return -1;
    //     k = k - 1;
    //     return matrix[k / matrix.length][k % matrix[0].length];
    // }
    
    // 1. Max Heap
    /*
    Time O(NlogK)
    */
//     public int kthSmallest(int[][] matrix, int k) {
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 pq.offer(matrix[i][j]);
//                 if (pq.size() > k) {
//                     pq.poll();
//                 }
//             }
//         }
        
//         return pq.poll();
//     }
    
    // 2. Binary Search + Counting
    /*
    https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85173/Share-my-thoughts-and-Clean-Java-Code
    
    Search the largest number that has it's smaller subset number <= K
    
    We are done here, but let's think about this problem in another way:
The key point for any binary search is to figure out the "Search Space". For me, I think there are two kind of "Search Space" -- index and range(the range from the smallest number to the biggest number). Most usually, when the array is sorted in one direction, we can use index as "search space", when the array is unsorted and we are going to find a specific number, we can use "range".

Let me give you two examples of these two "search space"

index -- A bunch of examples -- https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ ( the array is sorted)
range -- https://leetcode.com/problems/find-the-duplicate-number/ (Unsorted Array)

    The reason why we did not use index as "search space" for this problem is the matrix is sorted in two directions, we can not find a linear way to map the number and its index.
    */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        
        int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            // count the number of elements that <
            int count = 0;
            for (int i = 0; i < m; i++) {
                int j = n - 1;
                while (j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            
            if (count < k) {
                lo = mid + 1;
            } else {
                // if count == k, hi = mid - 1
                // if count > k, hi = mid - 1
                hi = mid - 1;
            }
        }
        
        return lo;
    }
}
