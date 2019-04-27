/*
LeetCode: https://leetcode.com/problems/spiral-matrix/
LintCode: http://www.lintcode.com/problem/spiral-matrix/
JiuZhang: http://www.jiuzhang.com/solutions/spiral-matrix/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-spiral-matrix-java/

Analysis:

*/
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) return result;
        
        // xRange is the length that could move in rows, rRange is the length taht could move in columns
        int xRange = matrix.length, yRange = matrix[0].length;
        
        if (xRange == 1 && yRange == 1) {
            result.add(matrix[0][0]);
            return result;
        }
        
        // x, y is the indices
        int x = 0, y = 0;
        
        while (xRange > 0 && yRange > 0) {
            if (xRange == 1) {
                // which means there is only one row
                for (int i = 0; i < yRange; i++) result.add(matrix[x][y++]);
                break;
            } else if (yRange == 1) {
                // means there is only one column
                for (int i = 0; i < xRange; i++) result.add(matrix[x++][y]);
                break;
            }
            
            // Should be xRange - 1 here, as we are using "x++", so in next line, it will use x as colume number.
            for (int i = 0; i < yRange - 1; i++) result.add(matrix[x][y++]);
            
            for (int i = 0; i < xRange - 1; i++) result.add(matrix[x++][y]);
            
            for (int i = 0; i < yRange - 1; i++) result.add(matrix[x][y--]);
            
            for (int i = 0; i < xRange - 1; i++) result.add(matrix[x--][y]);
            
            // Start point from [0, 0] to [1, 1]
            x++;
            y++;
            // One round will add the left most, and right most colume into result, so should be xRange - 2; the same thing for yRange
            xRange -= 2;
            yRange -= 2;
        }
        return result;
    }
}
