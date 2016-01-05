/*
LeetCode: https://leetcode.com/problems/set-matrix-zeroes/
LintCode: http://www.lintcode.com/problem/set-matrix-zeroes/
JiuZhang: http://www.jiuzhang.com/solutions/set-matrix-zeroes/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-set-matrix-zeroes-java/

Analysis: 

*/
public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstRowZeroes = false;
        boolean firstColumnZeroes = false;
        
        // set first row and column zero or not
        for(int i = 0; i < matrix[0].length; i++){
            if(matrix[0][i] == 0){
                firstRowZeroes = true;
                break;
            }
        }
        
        for(int j = 0; j < matrix.length; j++){
            if(matrix[j][0] == 0){
                firstColumnZeroes = true;
                break;
            }
        }
        
        // mark zeroes on first row and column
        for(int i = 1; i < matrix.length; i ++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // use mark to set elements
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] =0;
                }
            }
        }
        
        // set first row and column
        if(firstRowZeroes){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        
        if(firstColumnZeroes){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}