/*
https://discuss.leetcode.com/topic/11327/straight-forward-java-solution-using-backtracking/2
http://www.cnblogs.com/yuzhangcmu/p/4067733.html

Analysis:
1.Backtracking (DFS)

摘抄部分解释：

典型DFS/递归/回溯/深搜题。对于DFS，说白了

1） 什么时候返回？在本题中，

1.当x>8或y>8 表示已经遍历完所有的格子，因此成功完成，返回true。
2.当下一个搜索（子搜索）返回true，说明已经找到，返回true。  
3.如果测试过本轮的所有可能解，但无一是对的，说明无解，返回false。  
4.如果当前空格不是空格，则改变x，y坐标后，继续下一个空格的尝试

2）DFS就是针对本轮的所有可能解进行逐一尝试，找到本轮的一个可能解后，这时要调用递归，基于本轮的解对下一轮（子问题）进行求解。如果下一轮（子问题）求解成功，则说明大功告成，及时返回true，停止之后的尝试。
否则如果下一轮（子问题）求解失败，则说明本轮的解不适合子问题，因此，必须换一个本轮的解，然后基于本轮的新解，继续尝试子问题。如果已经本轮所有的解都尝试过了，也都失败了，说明本问题无解，返回false。
当然在每次尝试子问题前和如果失败返回后，都要恢复原来的环境（撤销动作）。
所以，要想使DFS成功返回，条件就是找到满足本轮的解和这个解也要满足下一轮（子问题）。

另外：
1 每个backtracking的题目，最好都有独立判断isValid的程序，这样架构清楚。同时，valid判断函数在这里可以稍微研究一下。只要当前要判断的位置上的数值和本行没有重复，本列没有重复，九宫格没有重复就可以。一旦重复立即返回，减少判断次数。
2 backtracking的递归函数，怎么能没有返回值呢？因为要判断递归的方案正确与否，所以这里的递归一定是有返回值的（除非是combination那种没有正确错误概念的backtracking）
3 可以考虑“先放置，再判断”的方案。比如这里，首先判断当前位置是否为空，如果为空，那么放置一个元素，检查它是否正确。如果正确，就继续进行下面的递归（也就是第29行 isValid&&solveSudoku的作用）。当函数返回错误之后，将刚刚的数值变为空，再进行下一次尝试即可。
4 所有的方案（k从1到9）完毕之后，应该返回错误，这个是不应该被忽略的。
*/
public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0) return;
        solve(board);
    }
    
    private boolean solve(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.') continue;
                for(char c = '1'; c <= '9'; c++){ // trial. Try 1 through 9 for each cell
                    if(isValid(board, i, j, c)){
                        board[i][j] = c; // put c in this cell
                        
                        if(solve(board)) return true; // if it's the solution return true
                        else board[i][j] = '.'; // reset it back to '.'
                    }
                }
                // if board[i][j] fill '1'-'9', all failed, return false.
                return false;
            }
        }
        // if all cells in board is not '.', that means it originally is filled correct, return true
        return true;
    }
    
    private boolean isValid(char[][] board, int i, int j, char c){
        // check column
        for(int row = 0; row < 9; row++){
            if(board[row][j] == c) return false;
        }
        
        // check row
        for(int col = 0; col < 9; col++){
            if(board[i][col] == c) return false;
        }
        
        // check 3 x 3 sub block
        for(int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++){
            for(int col = (j / 3) * 3; col < (j / 3) * 3 + 3; col++){
                if(board[row][col] == c) return false;
            }
        }
        
        return true;
    }
    
    
}
