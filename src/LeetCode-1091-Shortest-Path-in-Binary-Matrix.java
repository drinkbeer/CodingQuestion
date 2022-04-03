class Solution {
    // DFS (TLE)
//     public int shortestPathBinaryMatrix(int[][] grid) {
//         if (grid == null && grid.length == 0) return 0;
        
//         int[] res = new int[1];
//         res[0] = Integer.MAX_VALUE;
        
//         if (grid[0][0] != 0) return -1;
        
//         DFS(grid, 0, 0, 1, res);
//         return res[0] == Integer.MAX_VALUE ? -1 : res[0];
//     }
    
//     private void DFS(int[][] grid, int i, int j, int len, int[] res) {
//         if (len >= res[0]) return;
        
//         if (i == grid.length -1 && j == grid[0].length - 1) {
//             res[0] = len;
//             return;
//         }
        
//         grid[i][j] = -1;
//         int[] directions = new int[] {-1, 0, 1};
//         for (int x : directions) {
//             for (int y : directions) {
//                 if (isValid(i + x, j + y, grid) && grid[i + x][j + y] == 0) {
//                     DFS(grid, i + x, j + y, len + 1, res);
//                 }
//             }
//         }
//         grid[i][j] = 0;
//     }
    
//     private boolean isValid(int i, int j, int[][] grid) {
//         if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;
//         return true;
//     }
    
    // 2. BFS, level order traversal without visited array (need update the grid array)
    /*
    Runtime: 9 ms, faster than 99.89% of Java online submissions for Shortest Path in Binary Matrix.
    Memory Usage: 43.6 MB, less than 88.80% of Java online submissions for Shortest Path in Binary Matrix.
    */
//     public int shortestPathBinaryMatrix(int[][] grid) {
//         if (grid == null && grid.length == 0) return 0;
//         if (grid[0][0] == 1) return -1;
        
//         int n = grid.length;
//         if (grid[n - 1][n - 1] == 1) return -1;
        
//         Queue<int[]> queue = new LinkedList<>();
//         queue.offer(new int[]{0, 0});
//         grid[0][0] = 1;
        
//         int len = 0;
//         int[] directions = new int[] {-1, 0, 1};
//         while (queue.size() > 0) {
//             len++;
            
//             int size = queue.size();
            
//             for (int k = 0; k < size; k++) {
//                 int[] curr = queue.poll();
//                 int i = curr[0], j = curr[1];
//                 if (i == n - 1 && j == n - 1) return len;
                
//                 for (int x : directions) {
//                     for (int y : directions) {
//                         if (isValid(i + x, j + y, grid) && grid[i + x][j + y] == 0) {
//                             queue.offer(new int[]{i + x, j + y});
//                             grid[i + x][j + y] = 1;
//                         }
//                     }
//                 }
//             }
//         }
        
//         return -1;
//     }
    
//     private boolean isValid(int i, int j, int[][] grid) {
//         if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;
//         return true;
//     }
    
    // BFS, level order traversal, with visited array, (don't need to update the grid array)
//     public int shortestPathBinaryMatrix(int[][] grid) {
//         if (grid == null && grid.length == 0) return 0;
//         if (grid[0][0] == 1) return -1;
        
//         int n = grid.length;
//         if (grid[n - 1][n - 1] == 1) return -1;
        
//         Queue<int[]> queue = new LinkedList<>();
//         queue.offer(new int[]{0, 0});
//         boolean[][] visited = new boolean[n][n];
//         visited[0][0] = true;
        
//         int len = 0;
//         int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};
//         while (queue.size() > 0) {
//             len++;
            
//             int size = queue.size();
            
//             for (int k = 0; k < size; k++) {
//                 int[] curr = queue.poll();
//                 int i = curr[0], j = curr[1];
//                 if (i == n - 1 && j == n - 1) return len;
                
//                 for (int l = 0; l < 8; l++) {
//                     int x = dir[l][0], y = dir[l][1];
//                     if (isValid(i + x, j + y, grid) && !visited[i + x][j + y] && grid[i + x][j + y] == 0) {
//                         queue.offer(new int[]{i + x, j + y});
//                         visited[i + x][j + y] = true;
//                     }
//                 }
//             }
//         }
        
//         return -1;
//     }
    
//     private boolean isValid(int i, int j, int[][] grid) {
//         if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return false;
//         return true;
//     }
    
    // private int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

//     public int shortestPathBinaryMatrix(int[][] grid) {

//         int m = grid.length;
//         int n = grid[0].length;

//         if(grid[0][0]==1 || grid[m-1][n-1]==1) {
//             return -1;
//         }

//         boolean[][] visited = new boolean[m][n];
//         visited[0][0] = true;
//         Queue<int[]> queue = new LinkedList<>();
//         queue.add(new int[]{0,0});

//         int ans=0;
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for(int i=0;i<size;i++) {
//                 int[] pop = queue.remove();
//                 if(pop[0]==m-1 && pop[1]==n-1) {
//                     return ans+1;
//                 }
//                 for (int k=0;k<8;k++) {
//                     int nextX = dir[k][0]+pop[0];
//                     int nextY = dir[k][1]+pop[1];

//                     if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && !visited[nextX][nextY] && grid[nextX][nextY]==0) {
//                         queue.add(new int[]{nextX,nextY});
//                         visited[nextX][nextY]=true;
//                     }

//                 }
//             }
//             ans++;
//         }

//         return -1;
//     }
    
    // 3. A* (A Star) Search Algorithm
    public int shortestPathBinaryMatrix(int[][] grid) {
        
    }
}
