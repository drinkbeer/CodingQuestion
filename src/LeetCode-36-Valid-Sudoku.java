/*
LeetCode: https://leetcode.com/problems/valid-sudoku/
LintCode: http://www.lintcode.com/problem/valid-sudoku/
JiuZhang: http://www.jiuzhang.com/solutions/valid-sudoku/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-valid-sudoku-java/

Analysis: 
1.Check each row
2.Check each column
3.Check each sub matrix

*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // check each row
        for(int row = 0; row < 9; row++){
            boolean[] checker = new boolean[9];
            for(int col = 0; col < 9; col++){
                if(board[row][col] != '.'){
                    if(checker[board[row][col] - '1']) return false;
                    checker[board[row][col] - '1'] = true;
                }
            }
        }
        
        // check each column
        for(int col = 0; col < 9; col++){
            boolean[] checker = new boolean[9];
            for(int row = 0; row < 9; row++){
                if(board[row][col] != '.'){
                    if(checker[board[row][col] - '1']) return false;
                    checker[board[row][col] - '1'] = true;
                }
            }
        }
        
        // check each sub matrix
        for(int block = 0; block < 9; block++){
            boolean[] checker = new boolean[9];
            for(int row = block / 3 * 3; row < block / 3 * 3 + 3; row++){
                for(int col = block % 3 * 3; col < block % 3 * 3 + 3; col++){
                    if(board[row][col] != '.'){
                        if(checker[board[row][col] - '1']) return false;
                        checker[board[row][col] - '1'] = true;
                    }
                }
            }
        }
        
        return true;
    }
}