/*
http://www.cs.cmu.edu/~scandal/cacm/node9.html
http://www.itdadao.com/article/106102/

https://leetcode.com/discuss/71914/java-and-python-solutions-with-and-without-tables

// 1.Without Table
Time O(MNK)

2.With table


Follow up:
http://www.1point3acres.com/bbs/thread-146978-1-1.html

两个Sparse matrix，点乘；
1.Use HashMap to store non-zero value. Only calculate those non-zero value.

2.If two arrays are all sorted and one array is much larger than the second one. What can you optimize?
Scan the smaller array, if one value is non-zero, binary search the index in the larger array.

*/
class Solution {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Sparse Matrix Multiplication.
    Memory Usage: 37.1 MB, less than 99.44% of Java online submissions for Sparse Matrix Multiplication.
    
    Time O(MNK)
    */
    
//     public int[][] multiply(int[][] A, int[][] B) {
//         if (A == null || A[0] == null || B == null || B[0] == null) return null;
//         int m = A.length, n = A[0].length, l = B[0].length;
//         int[][] res = new int[m][l];
        
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (A[i][j] == 0) continue;  //skip redundancy
                
//                 for (int k = 0; k < l; k++) {
//                     if (B[j][k] == 0) continue;  //skip redundancy
                    
//                     res[i][k] += A[i][j] * B[j][k];
//                 }
//             }
//         }
        
//         return res;
//     }
    
    /*
    Runtime: 1 ms, faster than 46.72% of Java online submissions for Sparse Matrix Multiplication.
    Memory Usage: 37.5 MB, less than 99.44% of Java online submissions for Sparse Matrix Multiplication.
    */
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A[0] == null || B == null || B[0] == null) return null;
        int m = A.length, n = A[0].length, l = B[0].length;
        int[][] res = new int[m][l];
    
        // Three Integer: 1st is table's row index, 2nd is table's column index, 3rd is value
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

        // Store non-zero A into the HashMap
        for (int j = 0; j < n; j++) map.put(j, new HashMap<Integer, Integer>());
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) continue;
                map.get(j).put(i, A[i][j]);
            }
        }
        
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < l; k++) {
                if (B[j][k] == 0) continue;
                for (int i : map.get(j).keySet()) {
                    res[i][k] += B[j][k] * map.get(j).get(i);
                }
            }
        }
        
        return res;
        
        // store non-zero B into the HashMap
//         for (int j = 0; j < n; j++) map.put(j, new HashMap<Integer, Integer>());
        
//         for (int j = 0; j < n; j++) {
//             for (int k = 0; k < l; k++) {
//                 if (B[j][k] == 0) continue;
//                 map.get(j).put(k, B[j][k]);
//             }
//         }
        
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (A[i][j] == 0) continue;
//                 for (int k : map.get(j).keySet()) {
//                     res[i][k] += A[i][j] * map.get(j).get(k);
//                 }
//             }
//         }
//         return res;
    }
}
