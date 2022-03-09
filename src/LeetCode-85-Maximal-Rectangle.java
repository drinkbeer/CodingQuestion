class Solution {
    // 1.Monotonic Stack. Reuse the solution in the LeetCode-84-Largest-Rectangle-in-Histogram
    /*
    https://leetcode.com/problems/maximal-rectangle/discuss/29064/A-O(n2)-solution-based-on-Largest-Rectangle-in-Histogram
    
    Time O(M*N^2) - M is height, N is width
    */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
        int cLen = matrix[0].length, rLen = matrix.length;
        int[] heights = new int[cLen + 1];
        heights[cLen] = 0;
        
        int max = 0;
        for (int row = 0; row < rLen; row++) {
            // start processing one row and above
            Stack<Integer> s = new Stack<>();
            for (int i = 0; i <= cLen; i++) {
                // update the heights array first
                if (i < cLen) {
                    if (matrix[row][i] == '1') {
                        heights[i] += 1;
                    } else {
                        heights[i] = 0;
                    }
                }
                
                if (s.isEmpty() || heights[s.peek()] <= heights[i]) {
                    // adding i to stack will still keep the stack to be ascending stack (means the height in the index in stack is ascending)
                    s.push(i);
                } else {
                    // means adding i to the stack will make the index in stack not ascending
                    while(!s.isEmpty() && heights[s.peek()] > heights[i]) {
                        int currHeight = heights[s.pop()];
                        int prevIndex = s.isEmpty() ? -1 : s.peek();
                        max = Math.max(max, (i - prevIndex - 1) * currHeight);
                    }
                    s.push(i);
                }
            }
        }
        
        return max;
    }
    
    // 2. Brute Force solution
    /*
    https://leetcode.com/problems/maximal-rectangle/discuss/29172/My-O(n3)-solution-for-your-reference
    Time: O(M^2*N) - M is height, N is width
    
    Runtime: 11 ms, faster than 62.88% of Java online submissions for Maximal Rectangle.
    Memory Usage: 43 MB, less than 80.12% of Java online submissions for Maximal Rectangle.
    */
//     public int maximalRectangle(char[][] matrix) {
//         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
//         int rLen = matrix.length, cLen = matrix[0].length;
//         int max = 0;
//         int[][] rowArea = new int[rLen][cLen];      // value in i, j means the max consecutive '1' from j to it's left
        
//         for (int i = 0; i < rLen; i++) {
//             for (int j = 0; j < cLen; j++) {
//                 if (matrix[i][j] == '0') {
//                     rowArea[i][j] = 0;
//                 } else {
//                     if (j == 0) {
//                         rowArea[i][j] = 1;
//                     } else {
//                         rowArea[i][j] = rowArea[i][j - 1] + 1;
//                     }
                    
//                     // calculate the max area of matrix with (i, j) as the right down point
//                     int x = cLen;
//                     int y = 1;
//                     while (i - y + 1 >= 0 && matrix[i - y + 1][j] == '1') {
//                         x = Math.min(x, rowArea[i - y + 1][j]);
//                         max = Math.max(max, x * y);
//                         y++;
//                     }
                    
//                 }
//             }
//         }
//         return max;
//     }
    
    // 3. Brute Force DP solution (TLE)
    /*
    https://leetcode.com/problems/maximal-rectangle/discuss/254705/DP-Thinking-Process
    O(N^4)
    */
//     public int maximalRectangle(char[][] matrix) {
//         if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        
//         int rLen = matrix.length, cLen = matrix[0].length;
//         int max = 0;
//         for (int i = 0; i < rLen; i++) {
//             for (int j = 0; j < cLen; j++) {
//                 boolean[][] isValid = new boolean[rLen][cLen];
                
//                 for (int x = i; x < rLen; x++) {
//                     for (int y = j; y < cLen; y++) {
//                         if (matrix[x][y] != '1') continue;
//                         isValid[x][y] = true;
//                         if (x > i) isValid[x][y] = isValid[x][y] && isValid[x - 1][y];
//                         if (y > j) isValid[x][y] = isValid[x][y] && isValid[x][y - 1];
                        
//                         if (isValid[x][y]) {
//                             int area = (x - i + 1) * (y - j + 1);
//                             max = Math.max(max, area);
//                         }
//                     }
//                 }
//             }
//         }
//         return max;
//     }
    
}
