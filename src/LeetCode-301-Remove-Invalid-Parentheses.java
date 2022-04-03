/*
http://codingmelon.com/2015/12/13/remove-invalid-parentheses-leetcode-301/
1.DFS (without pruning)
left: the # of '(' to remove; right: the # of ')' to remove.
leftRemain: means # of '(' in result that are not pair. When removing ')', we need to know how many '(' has already in result.
            include one '(', leftRemain++; include one ')', leftRemain--;

Test Cases:
    ""  ->  [""]
    "n" ->  ["n"]
    "())"   ->  ["()"]
    "(()"   ->  ["()"]
    "()()"  ->  ["()()"]

DFS+Pruning: https://leetcode.com/discuss/67919/java-optimized-dfs-solution-3-ms
https://leetcode.com/discuss/72208/easiest-9ms-java-solution

2.BFS   
https://leetcode.com/discuss/67842/share-my-java-bfs-solution

            "())()"
 remove 1   "))()"     "()()"   "()()"    "()))"        "())("
 remove 2   ")()"      .................................
            ................
 
 Test Case: "()())()"   ->  ["(())()","()()()"]
                    wrong answer:   ["(())()","()()()","()()","(())","()",""]

 
*/
public class Solution {
    // 1.DFS
    // public List<String> removeInvalidParentheses(String s) {
    //     List<String> result = new ArrayList<String>();
    //     if(s == null) return result;
        
    //     int left = 0, right = 0;    // left: the # of '(' to remove; right: the # of ')' to remove.
    //     for(int i = 0; i < s.length(); i++){
    //         char ch = s.charAt(i);
    //         if(ch == '(') left++;
    //         else if(ch == ')'){
    //             if(left == 0) right++;
    //             else left--;    //means it's pair of '(' and ')'
    //         }
    //     }
        
    //     DFS(s, result, new StringBuilder(), 0, left, right, 0);
    //     return result;
    // }
    
    // private void DFS(String s, List<String> result, StringBuilder sb, int index, int left, int right, int leftRemain){
    //     // end condition
    //     if(index == s.length()){
    //         if(left == 0 && right == 0 && leftRemain == 0){
    //             String str = sb.toString();
    //             if(!result.contains(str)) result.add(str);
    //         }
    //         return;
    //     }
        
    //     if(s.charAt(index) != '(' && s.charAt(index) != ')') {
    //         sb.append(s.charAt(index));
    //         DFS(s, result, sb, index + 1, left, right, leftRemain); // just append, and move index+1
    //         sb.deleteCharAt(sb.length() - 1);
    //         return;
    //     }
        
    //     if(s.charAt(index) == '('){
    //         if(left > 0){
    //             // means we can remove current '(' and DFS
    //             DFS(s, result, sb, index + 1, left - 1, right, leftRemain);
    //         }
    //         // continue to try: append curr '(' to result, and continue DFS
    //         sb.append('(');
    //         DFS(s, result, sb, index + 1, left, right, leftRemain + 1);
    //         sb.deleteCharAt(sb.length() - 1);
    //     }else{
    //         if(right > 0){
    //             // remove curr ')' and DFS
    //             DFS(s, result, sb, index + 1, left, right - 1, leftRemain);
    //         }
    //         if(leftRemain > 0){
    //             // append curr ')', and DFS
    //             sb.append(')');
    //             DFS(s, result, sb, index + 1, left, right, leftRemain -1);
    //             sb.deleteCharAt(sb.length() - 1);
    //         }
    //     }
    // }
    
    // 2.BFS
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null) return result;
        
        Queue<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        queue.offer(s);
        visited.add(s);
        
        boolean found = false;
        while(!queue.isEmpty()){
            String str = queue.poll();
            
            if(isValid(str)){
                // find an answer, add to result
                result.add(str);
                found = true;
            }
            
            if(found) continue;     // currend string is already a valid string, we don't need to remove further
            
            // generate all possible substrings
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) != '(' && str.charAt(i) != ')') continue;
                
                String tmp = str.substring(0, i) + str.substring(i + 1);
                if(!visited.contains(tmp)){
                    // for each state, if it is not visited, add to queue
                    queue.offer(tmp);
                    visited.add(tmp);
                }
            }
        }
        
        return result;
    }
    
    private boolean isValid(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            
            if(ch == '(') count++;
            else if(ch == ')'){
                count--;
                if(count < 0) return false;
            }
        }
        return count == 0;
    }
    
}
