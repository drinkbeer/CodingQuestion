class Solution {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {-1, -1}, {1, 1}, {0, 1}, {0, -1}, {1, -1}, {-1, 1}};
    private static final int newDie = -1, newLive = -2;
    public void gameOfLife(int[][] board) {
        
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int countLives = 0;
                
                for (int[] dir : dirs) {
                    int x = dir[0] + i, y = dir[1] + j;
                    countLives += count(board, x, y);
                }
                
                if (board[i][j] == 1 && (countLives < 2 || countLives > 3)) {
                    board[i][j] = newDie;
                } else if (board[i][j] == 0 && countLives == 3) {
                    board[i][j] = newLive;
                }
                
            }
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == newDie) {
                    board[i][j] = 0;
                } else if (board[i][j] == newLive) {
                    board[i][j] = 1;
                }
            }
        }
    }
    
    private int count(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return 0;
        
        if (board[i][j] == 0 || board[i][j] == newLive) return 0;
        // if (board[i][j] == 1 || board[j][j] == newDie) return 1;
        
        return 1;
    }
    
    // Follow-up 2: 
    /*
    https://leetcode.com/problems/game-of-life/discuss/73217/Infinite-board-solution
    https://leetcode.com/problems/game-of-life/discuss/73286/How-to-answer-these-frequent-interview-follow-up-question-for-game-of-life
    
    Right，I think this is what follow up really means. You can never iterate a infinite board because it's just infinite.
    So it doesn't means to design a map, but you just need to update board the second time when your first time iterate is not finished. So you set the needed numbers for neighbors and once you done and get rid of the zone you update it right away.
    It doesn't matter where you start, if you start at a center, you do expand like a circle then update like a circle like design two waves.

    The hard part is do it using multithreads, way beyond scope. Consider t 1d infinite, you may wish do it in direction in infinite and set a batch size, the algorithm is
    describe like this
    1 ----- 2 ------3 --------4 ------5 -----6-------.....
    0 ----- 0 ------0 --------1 ----- 2 ------3 --------4 ------5 -----6-----....
    So you can reach part of solution when you are upadeting it. Now we need to do it multithreading way just 2 threads
    1 ----- 2 ------3 --------4 ------5 -----6-------.....
    0 ----- 0 ------0 --------1 ----- 2 ------3 --------4 ------5 -----6-----....
    7----- 8 ------9 --------10 ------11 -----12-------.....
    0 ----- 0 ------0 --------7----- 8 ------9 --------10 ------11 -----12-------.....

    But when we need to process line 6, line 7 may already been process, thus cause error, thus we need some extra handle on the boundary, but idk how to do it...
    
    
    
    
    In my opinion, If there are n threads, for each thread k, we scan the (k % n) th ,(k % n + n) th ... lines. But we use snapshot(or copy) instead of board in place. Than we merge the results.

    */
}
