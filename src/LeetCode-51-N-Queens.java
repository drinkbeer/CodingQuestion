/*
https://discuss.leetcode.com/topic/24329/share-my-java-dfs-solution-very-easy-to-understand/2

Can we use boolean[] to replace Set<Integer>?
*/
public class Solution {
    // 1.
//     private Set<Integer> col = new HashSet<Integer>();
//     private Set<Integer> diag1 = new HashSet<Integer>();
//     private Set<Integer> diag2 = new HashSet<Integer>();
    
//     public List<List<String>> solveNQueens(int n) {
//         List<List<String>> result = new ArrayList<List<String>>();
//         DFS(n, 0, result, new ArrayList<String>());
//         return result;
//     }
    
//     private void DFS(int n, int row, List<List<String>> result, List<String> list){
//         // end condition
//         if(n == row){
//             result.add(new ArrayList<String>(list));
//             return;
//         }
        
//         // place queue
//         for(int i = 0; i < n; i++){
//             if(col.contains(i) || diag1.contains(row + i) || diag2.contains(row - i)) continue;
            
//             char[] charArray = new char[n];
//             java.util.Arrays.fill(charArray, '.');
//             charArray[i] = 'Q';
//             String rowString = new String(charArray);
            
//             list.add(rowString);
//             col.add(i);
//             diag1.add(row + i);
//             diag2.add(row - i);
            
//             DFS(n, row + 1, result, list);
            
//             list.remove(list.size() - 1);
//             col.remove(i);
//             diag1.remove(row + i);
//             diag2.remove(row - i);
//         }
//     }
    
    
    
    // 1. Recursive
    /*
    https://leetcode.com/problems/n-queens/discuss/19808/Accepted-4ms-c%2B%2B-solution-use-backtracking-and-bitmask-easy-understand.
    */
    public List<List<String>> solveNQueens(int n) {
        char[][] chess = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chess[i][j] = '.';
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        solve(0, chess, res);
        return res;
    }
    
    private void solve(int row, char[][] chess, List<List<String>> res) {
        if (row == chess.length) {
            construct(chess, res);
            return;
        }
        
        for (int j = 0; j < chess[0].length; j++) {
            if (isValid(chess, row, j)) {
                chess[row][j] = 'Q';
                solve(row + 1, chess, res);
                chess[row][j] = '.';
            }
        }
    }
    
    private boolean isValid(char[][] chess, int row, int col) {
        // validate col
        for (int i = 0; i < chess.length; i++) {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }
        
        // validate 45 degree
        for (int i = row - 1, j = col + 1; i >= 0 && j <= chess[0].length - 1; i--, j++) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        
        // validate 135 degree
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }
        
        return true;
    }
    
    private void construct(char[][] chess, List<List<String>> res) {
        List<String> temp = new ArrayList<>();
        for (int i = 0; i < chess.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < chess[0].length; j++) {
                sb.append(chess[i][j]);
            }
            temp.add(sb.toString());
        }
        res.add(temp);
    }
    
}

