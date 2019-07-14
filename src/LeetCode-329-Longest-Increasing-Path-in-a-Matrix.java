class Solution {
    // 1. DFS (without any optimization) (TLE)
//     public int longestIncreasingPath(int[][] matrix) {
        
//         int[] max = new int[1];
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 recursive(matrix, i, j, Integer.MIN_VALUE, 0, max);
//             }
//         }
//         return max[0];
//     }
    
//     private void recursive(int[][] matrix, int i, int j, int prev, int currLen, int[] max) {
//         if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return;
        
//         if (matrix[i][j] == -1 || matrix[i][j] <= prev) return;
        
//         // We find an increment number
//         int temp = matrix[i][j];
//         matrix[i][j] = -1;
//         max[0] = Math.max(max[0], currLen + 1);
        
//         recursive(matrix, i - 1, j, temp, currLen + 1, max);
//         recursive(matrix, i + 1, j, temp, currLen + 1, max);
//         recursive(matrix, i, j - 1, temp, currLen + 1, max);
//         recursive(matrix, i, j + 1, temp, currLen + 1, max);
        
//         matrix[i][j] = temp;
//     }
    
    
    // 2. Recursive
    /*
    https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/78308/15ms-Concise-Java-Solution
    
    O(MN)
    */
//     private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//     public int longestIncreasingPath(int[][] matrix) {
//         if (matrix == null || matrix.length == 0) return 0;
        
//         int max = 0;
//         int[][] mem = new int[matrix.length][matrix[0].length];
//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 int len = recursive(matrix, i, j, mem);
//                 max = Math.max(max, len);
//             }
//         }
//         return max;
//     }
    
//     private int recursive(int[][] matrix, int i, int j, int[][] mem) {
//         if (mem[i][j] != 0) return mem[i][j];
        
//         int max = 1;    // curr [i][j] number
//         for (int[] dir : dirs) {
//             int x = i + dir[0], y = j + dir[1];
//             if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= matrix[i][j]) continue;
//             int len = 1 + recursive(matrix, x, y, mem);
//             max = Math.max(max, len);
//         }
        
//         mem[i][j] = max;
//         return max;
//     }
    
    // Similar to the above approach to write
    /*
    https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/78375/Easy-Java-Solution!
    */
    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        
        int max = 0;
        int[][] mem = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = recursive(matrix, i, j, Integer.MIN_VALUE, mem);
                max = Math.max(max, len);
            }
        }
        return max;
    }
    
    private int recursive(int[][] matrix, int i, int j, int prev, int[][] mem) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prev) return 0;
        if (mem[i][j] != 0) return mem[i][j];
        
        int max = 1;    // curr [i][j] number
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            int len = 1 + recursive(matrix, x, y, matrix[i][j], mem);
            max = Math.max(max, len);
        }
        
        mem[i][j] = max;
        return max;
    }
    
    // 3.Graph Theory
    /*
    https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/78336/Graph-theory-Java-solution-O(v2)-no-DFS
    https://leetcode.com/problems/longest-increasing-path-in-a-matrix/discuss/144558/Java-BFS-Topological-Sort
    */
}
