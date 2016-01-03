/*
LeetCode: https://leetcode.com/problems/valid-parentheses/
LintCode: http://www.lintcode.com/problem/valid-parentheses/
JiuZhang: http://www.jiuzhang.com/solutions/valid-parentheses/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-valid-parentheses-java/

Analysis: 
A typical problem solved by using stack.
*/
public class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            
            if(map.keySet().contains(curr)){
                stack.push(curr);
            }else if(map.values().contains(curr)){
                if(!stack.empty() && map.get(stack.peek()) == curr){
                    stack.pop();
                }else{
                    return false;
                }
            }
            
        }
        
        return stack.empty();
    }
}