class TicTacToe {

    
//     int[][] board;
//     int n;
    
//     /** Initialize your data structure here. */
//     public TicTacToe(int n) {
//         this.board = new int[n][n];
//         this.n = n;
//     }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    
    /*
    Time: O(N^2)
    */
//     public int move(int row, int col, int player) {
//         board[row][col] = player;
        
//         boolean vertical = true;
//         for (int i = 0; i < n; i++) {
//             if (board[i][col] != player) {
//                 vertical = false;
//                 break;
//             }
//         }
//         if (vertical) return player;
        
//         boolean horizontal = true;
//         for (int j = 0; j < n; j++) {
//             if (board[row][j] != player) {
//                 horizontal = false;
//                 break;
//             }
//         }
//         if (horizontal) return player;
        
//         if (row == col || row + col == n - 1) {
//             boolean diag = true;
//             for (int i = 0; i < n; i++) {
//                 if (board[i][i] != player) {
//                     diag = false;
//                     break;
//                 }
//             }
//             if (diag) return player;
            
//             diag = true;
//             for (int i = 0; i < n; i++) {
//                 if (board[i][n - i - 1] != player) {
//                     diag = false;
//                     break;
//                 }
//             }
//             if (diag) return player;
//         }
        
//         return 0;
//     }
    
    
    
    
    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;
    int n;
    
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.diag = 0;
        this.antiDiag = 0;
        this.n = n;
    }
    /*
    Time: O(1)
    Space: O(N)
    */
    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;
        
        rows[row] += toAdd;
        cols[col] += toAdd;
        
        if (row == col) {
            diag += toAdd;
        }
        
        if (row == n - col - 1) {
            antiDiag += toAdd;
        }
        
        if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n || Math.abs(diag) == n || Math.abs(antiDiag) == n) {
            return player;
        }
        
        return 0;
    }
    
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
