
The DP Path problem is finding the path in a graph (or abstract graph).

### 64. Minimum Path Sum
https://leetcode.com/problems/minimum-path-sum/  
https://www.1point3acres.com/bbs/thread-539867-1-1.html  
Search (without Memorization or Pruning) / DP

```
    // Recursive (will TLE)
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        return helper(grid, grid.length - 1, grid[0].length - 1);
    }
    
    private int helper(int[][] grid, int x, int y) {
        if (x == 0 && y == 0) return grid[0][0];
        
        if (x == 0) {
            return grid[0][y] + helper(grid, 0, y - 1);
        } else if (y == 0) {
            return grid[x][0] + helper(grid, x - 1, 0);
        } else {
            return grid[x][y] + Math.min(helper(grid, x, y - 1), helper(grid, x - 1, y));
        }
    }
```

```
    // 2. DP, inplace, Time O(M*N), Space O(M*N)
    public int minPathSum(int[][] grid) {
        if (grid == null) return 0;
        int n = grid.length, m = grid[0].length;
        if (m == 1 && n == 1) return grid[0][0];
    
        for (int i = 1; i < n; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        
        for (int j = 1; j < m; j++) {
            grid[0][j] += grid[0][j - 1];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        
        return grid[n - 1][m - 1];
    }
```

# Reference
1. https://github.com/tianyicui/DP-Book/blob/master/path.pdf
