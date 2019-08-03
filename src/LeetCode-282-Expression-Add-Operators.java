/*
https://leetcode.com/discuss/58614/java-standard-backtrace-ac-solutoin-short-and-clear
https://leetcode.com/discuss/75308/java-simple-solution-beats-96-56%25

http://www.cnblogs.com/grandyang/p/4814506.html


Test case:
"105"  5    ->  ["1*0+5","1*5","10-5"]  should be  ["1*0+5","10-5"]



*/
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        if(num == null || num.length() == 0) return result;
        
        StringBuilder sb = new StringBuilder();
        DFS(num, target, 0, result, sb, 0, 0);
        // dfs(result, sb, num, 0, target, 0, 0);
        
        return result;
    }
    
    private void DFS(String num, int target, int start, List<String> result, StringBuilder sb, long val, long multed){
        // end condition
        if(start == num.length()){
            if(val == target){
                result.add(sb.toString());
            }
            return;
        }
        
        for(int i = start; i < num.length(); i++){
            // "105"  5    ->  ["1*0+5","1*5","10-5"]  should be  ["1*0+5","10-5"]
            // Careful: 1*05  this case should be elimited
            if(num.charAt(start) == '0' && i != start) break;
            
            long curr = Long.parseLong(num.substring(start, i + 1));
            int len = sb.length();  // used to remove new added chars in sb
            
            if(start == 0){
                // first num
                sb.append(curr);
                DFS(num, target, i + 1, result, sb, curr, curr);
                sb.setLength(len);      //erase the modification
            }else{
                sb.append("+").append(curr);
                DFS(num, target, i + 1, result, sb, val + curr, curr);
                sb.setLength(len);
                
                sb.append("-").append(curr);
                DFS(num, target, i + 1, result, sb, val - curr, -curr);
                sb.setLength(len);
                
                sb.append("*").append(curr);
                DFS(num, target, i + 1, result, sb, val - multed + multed * curr, multed * curr);
                sb.setLength(len);
            }
            
        }
    }
}
