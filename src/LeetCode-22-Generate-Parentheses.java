/*
1.Recursive (DFS)

2.Iterative (BFS)

3.DP
*/
public class Solution {
    // 1. DFS
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
        
    // 2.BFS
    /*
    https://leetcode.com/problems/generate-parentheses/discuss/10337/My-accepted-JAVA-solution
    Runtime: 2 ms, faster than 21.72% of Java online submissions for Generate Parentheses.

    slow
    */ 
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) {
            result.add("");
        } else {
            for (int i = n - 1; i >= 0; i--) {
                List<String> insertSub = generateParenthesis(i);
                List<String> tailSub = generateParenthesis(n - 1 - i);
                
                // System.out.println(insertSub);
                // System.out.println(tailSub);
                // System.out.println(result);
                
                for (String insert : insertSub) {
                    for (String tail : tailSub) {
                        result.add("(" + insert + ")" + tail);
                    }
                }

            }
        }
        return result;
    }
    
    
    // 3.DP
    /*
    https://leetcode.com/problems/generate-parentheses/discuss/10162/*Java*-Easy-to-understand-recursive-DP-method-with-explanations
    */
}
