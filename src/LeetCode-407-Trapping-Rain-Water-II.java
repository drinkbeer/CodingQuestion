class Solution {
    /*
    https://leetcode.com/problems/trapping-rain-water-ii/discuss/89472/Visualization-No-Code
    
    Time O(MN*log(MN))
    Space O(MN)
    */
    private static final int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0) return 0;
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        
        for (int i = 0; i < m; i++) {
            pq.offer(new int[] {i, 0, heightMap[i][0]});
            pq.offer(new int[] {i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        
        for (int j = 1; j < n; j++) {
            pq.offer(new int[] {0, j, heightMap[0][j]});
            pq.offer(new int[] {m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            
            for (int[] dir : dirs) {
                int x = dir[0] + cell[0], y = dir[1] + cell[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                res += Math.max(0, cell[2] - heightMap[x][y]);
                pq.offer(new int[] {x, y, Math.max(heightMap[x][y], cell[2])});
                visited[x][y] = true;
            }
        }
        
        return res;
    }
}
