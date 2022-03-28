class Solution {
    // Traverse from two directions
    /*
    Time: O(M * N)
    Space: O(1)
    */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        
        int idx = 0;
        int i = 0, j = 0;
        boolean up = true;
        while (true) {
            res[idx++] = mat[i][j];
            
            if (i == m - 1 && j == n - 1) break;
            
            int x = 0, y = 0;
            
            if (up) {
                x = -1;
                y = 1;
                if (j == n - 1) {
                    // move down to [i + 1, n - 1]
                    x = 1;
                    y = 0;
                    
                    up = !up;
                } else if (i == 0) {
                    // move right to [0, j + 1]
                    x = 0;
                    y = 1;
                    
                    up = !up;
                }
            } else {
                x = 1;
                y = -1;
                if (i == m - 1) {
                    // move right to [m - 1, j + 1]
                    x = 0;
                    y = 1; 
                    
                    up = !up;
                } else  if (j == 0) {
                   // move down to [i + 1, 0]
                    x = 1;
                    y = 0;
                    
                    up = !up;
                }
            }
            
            i += x;
            j += y;
        }
        
        return res;
    }
    
    // Traverse from same direction
    /*
    Time: O(M*N)
    Space: O(min(M, N))
    */
//     public int[] findDiagonalOrder(int[][] mat) {
        
//         int m = mat.length, n = mat[0].length;
        
//         int[] res = new int[m * n];
//         int idx = 0;
//         boolean up = true;
//         for (int k = 0; k < m; k++) {
//             int i = k, j = 0;
            
//             idx = traverse(res, mat, i, j, idx, up);
//             up = !up;
//         }
        
//         for (int k = 1; k < n; k++) {
//             int i = m - 1, j = k;
//             idx = traverse(res, mat, i, j, idx, up);
//             up = !up;
//         }
        
//         return res;
//     }
    
//     private int traverse(int[] result, int[][] mat, int i, int j, int idx, boolean up) {
//         List<Integer> list = new ArrayList<>();
//         while (i < mat.length && i >= 0 && j < mat[0].length && j >= 0) {
//             list.add(mat[i--][j++]);
//         }
        
//         if (!up) {
//             Collections.reverse(list);
//         }
        
//         for (int num : list) {
//             result[idx++] = num;
//         }
        
//         return idx;
//     }
}
