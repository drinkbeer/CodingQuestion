public class Solution {
    //1.DFS
    //Runtime Error Message: Line 43: java.lang.StackOverflowError
    // public void solve(char[][] board) {
    //     if(board == null || board.length <= 2 || board[0].length <= 2) return;
        
    //     int m = board.length;
    //     int n = board[0].length;
        
    //     for(int i = 0; i < m; i++){
    //         DFS(board, i, 0);
    //         DFS(board, i , n - 1);
    //     }
        
    //     for(int j = 0; j < n; j++){
    //         DFS(board, 0, j);
    //         DFS(board, m - 1, j);
    //     }
        
    //     for(int i = 0; i < m; i++){
    //         for(int j = 0; j < n; j++){
    //             if(board[i][j] == 'O'){
    //                 board[i][j] = 'X';
    //             }else if(board[i][j] == '*'){
    //                 board[i][j] = 'O';
    //             }
    //         }
    //     }
    // }
    
    // private void DFS(char[][] board, int i, int j){
    //     if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
    //     if(board[i][j] != 'O')return;
        
    //     board[i][j] = '*';
        
    //     DFS(board, i - 1, j);
    //     DFS(board, i + 1, j);
    //     DFS(board, i, j - 1);
    //     DFS(board, i, j + 1);
    // }
    
    //2.BFS
    private Queue<Integer> queue = new LinkedList<Integer>();
    
    public void solve(char[][] board) {
        if(board == null || board.length <= 2 || board[0].length <=2) return;
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++){
            BFS(board, i, 0);
            BFS(board, i, n - 1);
        }
        
        for(int j = 0; j < n; j++){
            BFS(board, 0, j);
            BFS(board, m - 1, j);
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }
    
    private void BFS(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        
        int m = board.length;
        int n = board[0].length;
        
        queue.offer(i*n + j);
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            int x = curr / n;
            int y = curr % n;
            
            FillCell(board, x, y);
        }
        
    }
    
    private void FillCell(char[][] board, int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j > board[0].length || board[i][j] != 'O') return;
        
        int n = board[0].length;
        
        board[i][j] = '*';
        
        queue.offer((i - 1) * n + j);
        queue.offer((i + 1) * n + j);
        queue.offer(i * n + j - 1);
        queue.offer(i * n + j + 1);
        
    }
}