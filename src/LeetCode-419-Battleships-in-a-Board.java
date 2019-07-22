/*
The input is guaranteed to be valid.
For instance, the following input is invalid, and will not appear:

[[".",".",".","X"],[".",".","X","X"],[".",".",".","X"]]
*/
class Solution {
    public int countBattleships(char[][] board) {
        int count = 0, m = board.length, n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') continue;
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                count++;
            }
        }
        
        return count;
    }
}
