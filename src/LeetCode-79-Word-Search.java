/*
LeetCode: https://leetcode.com/problems/word-search/
LintCode: http://www.lintcode.com/problem/word-search/
JiuZhang: http://www.jiuzhang.com/solutions/word-search/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-word-search-java/
Other: http://www.cnblogs.com/yuzhangcmu/p/4040418.html

Analysis: 
DFS
*/
public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean result = false;
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(DFS(board, word, i, j ,0)){
                    result = true;
                }
            }
        }
        
        return result;
    }
    
    private boolean DFS(char[][] board, String word, int i, int j, int k){
        
        int m = board.length;
        int n = board[0].length;
        
        if(i < 0 || j < 0 || i >= m || j >= n) return false;
        
        if(board[i][j] == word.charAt(k)){
            char temp = board[i][j];    // to avoid to search back, for instance: ["aa"], "aaa" ==> should be false
            board[i][j] = '#';
            
            if(k == word.length() - 1){
                return true;
            }
            if(DFS(board, word, i - 1, j, k + 1) || DFS(board, word, i, j - 1, k + 1) || 
            DFS(board, word, i + 1, j, k + 1) || DFS(board, word, i, j + 1, k + 1)){
                return true;
            }
            
            board[i][j] = temp;
        }
        
        return false;
    }
}