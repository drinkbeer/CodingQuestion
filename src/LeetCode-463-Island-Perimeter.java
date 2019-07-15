class Solution {
    private static final int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return recursive(grid, i, j);
                }
            }
        }
        return 0;
    }
    
    private int recursive(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return 1;
        
        if (grid[i][j] == -1) return 0;
        
        grid[i][j] = -1;
        int sum = 0;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            sum += recursive(grid, x, y);
        }
        return sum;
    }
}
