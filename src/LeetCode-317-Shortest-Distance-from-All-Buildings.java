class Solution {
    // BFS from empty land to all houses
    /*
    Time Complexity: O(N^2*M^2)
    Space Complexity: O(N*M)
    */
    public int shortestDistance(int[][] grid) {
        int minDistance = Integer.MAX_VALUE;
        int m = grid.length, n = grid[0].length;
        
        int totalHouses = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) totalHouses++;
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    minDistance = Math.min(minDistance, BFS(grid, i, j, totalHouses));
                }
            }
        }
        
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }
    
    private int BFS(int[][] grid, int row, int col, int totalHouses) {
        int dirs[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        int m = grid.length, n = grid[0].length;
        int distance = 0;
        int housesReached = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});
        
        // Keep track of visited cells
        boolean[][] visited = new boolean[m][n];
        visited[row][col] = true;
        
        int steps = 0;
        while (!queue.isEmpty() && housesReached != totalHouses) {
            for (int k = queue.size(); k > 0; k--) {
                int[] curr = queue.poll();
                int i = curr[0];
                int j = curr[1];
                
                if (grid[i][j] == 1) {
                    distance += steps;
                    housesReached++;
                    continue;
                }
                
                for (int[] dir : dirs) {
                    int nextRow = i + dir[0];
                    int nextCol = j + dir[1];
                    
                    if (nextRow >= 0 && nextRow < m && nextCol >= 0 && nextCol < n) {
                        if (!visited[nextRow][nextCol] && grid[nextRow][nextCol] != 2) {
                            visited[nextRow][nextCol] = true;
                            queue.offer(new int[] {nextRow, nextCol});
                        }
                    }
                }
                
            }
            
            steps++;
        }
        
        // Optimization. If we did not reach all houses, then any cell visited also cannot reach all houses.
        // Set all cells visited to 2 so we did not check them again and return MAX_VALUE.
        if (housesReached != totalHouses) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 0 && visited[i][j]) {
                        grid[i][j] = 2;
                    }
                }
            }
            return Integer.MAX_VALUE;
        }
        
        return distance;
        
    }
}
