class Solution {
    private static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {0, 0}};
    
    public int[][] imageSmoother(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0, sum = 0;
                for (int[] dir : dirs) {
                    
                    int x = i + dir[0], y = j + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) continue;
                    sum += M[x][y];
                    count++;
                    
                }
                
                res[i][j] = sum / count;
            }
        }
        
        return res;
    }
}
