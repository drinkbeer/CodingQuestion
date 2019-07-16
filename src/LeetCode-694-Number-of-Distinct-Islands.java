class Solution {
    
    // 1. Recursive (Using offset to encode an Island)
//     private static final int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
//     public int numDistinctIslands(int[][] grid) {
//         HashSet<String> set = new HashSet<>();
        
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] == 1) {
//                     set.add(recursive(grid, i, j, i, j));
//                 }
//             }
//         }
        
//         return set.size();
//     }
    
//     private String recursive(int[][] grid, int i, int j, int originalX, int originalY) {
//         if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return "";
        
//         grid[i][j] = 0;
//         String res = "" + (originalX - i) + (originalY - j);
//         for (int[] dir : dirs) {
//             int x = i + dir[0], y = j + dir[1];
//             res += recursive(grid, x, y, originalX, originalY);
//         }
        
//         return res;
//     }
    
    
    // 2. Recursive (Using UDLR to encode the island)
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "o"); // origin
                    grid[i][j] = 0;
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    private void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length 
           || grid[i][j] == 0) return;
        sb.append(dir);
        grid[i][j] = 0;
        dfs(grid, i-1, j, sb, "u");
        dfs(grid, i+1, j, sb, "d");
        dfs(grid, i, j-1, sb, "l");
        dfs(grid, i, j+1, sb, "r");
        sb.append("b"); // back
    }
}
