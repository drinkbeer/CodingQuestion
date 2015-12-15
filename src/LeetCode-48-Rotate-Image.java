/*
LeetCode: https://leetcode.com/problems/rotate-image/
LintCode: http://www.lintcode.com/problem/rotate-image/
JiuZhang: http://www.jiuzhang.com/solutions/rotate-image/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-rotate-image-java/

Analysis:
Easy problem. Can draw the array in paper, and calculate.
*/
public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length <= 1 || matrix.length != matrix[0].length) return;
        
        int len = matrix.length;
        for(int i = 0; i < len / 2; i++){
            for(int j = 0; j < (len + 1) / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len - 1 - j][i];
                matrix[len - 1 - j][i] = matrix[len - 1 - i][len - 1 - j];
                matrix[len - 1 - i][len - 1 - j] = matrix[j][len - 1 - i];
                matrix[j][len - 1 - i] = temp;
            }
        }
    }
}