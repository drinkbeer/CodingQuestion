/*
1.Recursive (DFS)

2.Iterative (BFS) ??
*/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n <= 0) return result;
        
        DFS(result, "", 0, 0, n);
        return result;
    }
    
    private void DFS(List<String> result, String str, int open, int close, int max){
        //end condition
        if(str.length() == max * 2){
            result.add(str);
            return;
        }
        
        if(open < max) DFS(result, str + "(", open + 1, close, max);
        if(close < open) DFS(result, str + ")", open, close + 1, max);  //Notice: close < open, to avoid ")))((("
    }
}