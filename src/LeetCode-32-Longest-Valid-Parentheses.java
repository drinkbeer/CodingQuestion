/*

Analysis:
1.O(n) with one Stack

2.Converting '(',')' into 1/0 code
https://discuss.leetcode.com/topic/37982/my-easy-o-n-java-solution-with-explanation

3.Forward and backward pass
https://discuss.leetcode.com/topic/22287/constant-space-o-n-time-with-forward-and-backward-pass

4.DP, O(n)
https://discuss.leetcode.com/topic/2289/my-o-n-solution-using-a-stack/6

*/
public class Solution {
    //1.O(n) with one Stack
    // public int longestValidParentheses(String s) {
    //     int max = 0;
    //     Stack<Integer> stack = new Stack<Integer>();
    //     int l = -1; // the (l+1,i) is the longest valid parentheses with s.charAt(i) as last char, so l is the index just left of valid parentheses
    //     for(int i = 0; i < s.length(); i++){
    //         if(s.charAt(i) == '(') stack.push(i);
    //         else{
    //             // now, s.charAt(i) == ')'
    //             if(stack.isEmpty()) l = i;
    //             else{
    //                 stack.pop();
    //                 if(stack.isEmpty()) max = Math.max(max, i - l);
    //                 else max = Math.max(max, i - stack.peek());
    //             }
    //         }
    //     }
    //     return max;
    // }
    
    // 1.Another O(n) with one Stack
    // public int longestValidParentheses(String s) {
    //     int max = 0;
    //     Stack<Integer> stack = new Stack<Integer>();
        
    //     stack.push(-1); //initialize Stack with index just left of curr index
    //     for(int i = 0; i < s.length(); i++){
    //         // here, stack.size() > 1 not '>= 1', as we initialized stack with -1
    //         if(s.charAt(i) == ')' && stack.size() > 1 && s.charAt(stack.peek()) == '('){
    //             stack.pop();
    //             max = Math.max(max, i - stack.peek());
    //         }else{
    //             stack.push(i);
    //         }
    //     }
    //     return max;
    // }
    
    //2.Convert '()(()' to '11011', and calculate the length longest '1' substring
    // public int longestValidParentheses(String s) {
    //     int max = 0;
    //     Stack<Integer> stack = new Stack<Integer>();
    //     int[] arr = new int[s.length()];
        
    //     // convert '('&')' to '1'&'0'
    //     for(int i = 0; i < s.length(); i++){
    //         char ch = s.charAt(i);
    //         if(ch == '(') stack.push(i);
    //         else{
    //             if(!stack.isEmpty()){
    //                 arr[i] = 1;
    //                 arr[stack.pop()] = 1;
    //             }
    //         }
    //     }
        
    //     // now we convert '()(()' to '11011', we need to calculate the max length of continuous 1
    //     int temp = 0;
    //     for(int i : arr){
    //         if(i == 1) temp++;
    //         else{
    //             max = Math.max(max, temp);
    //             temp = 0;
    //         }
    //     }
    //     // we cannot directly output max here, as it's possible that the last continuous 1 substring is the max one
    //     // e.g. "()" -> 2, if we directly return max, it would return 0
    //     return Math.max(max, temp);
    // }
    
    // 3.Forward and backward pass
    // public int longestValidParentheses(String s) {
    //     int max = 0;
    //     int extra = 0;
    //     int len = 0;
        
    //     // Forward pass
    //     for(int i = 0; i < s.length(); i++){
    //         if(s.charAt(i) == '('){
    //             extra++;
    //             len++;
    //         }else{
    //             if(extra > 0){
    //                 extra--;
    //                 len++;
    //                 if(extra == 0) max = Math.max(max, len);
    //             }else{
    //                 extra = 0;
    //                 len = 0;
    //             }
    //         }
    //     }
        
    //     // Backward pass
    //     extra = 0;
    //     len = 0;
    //     for(int i = s.length() - 1; i >= 0; i--){
    //         if(s.charAt(i) == ')'){
    //             extra++;
    //             len++;
    //         }else{
    //             if(extra > 0){
    //                 extra--;
    //                 len++;
    //                 if(extra == 0) max = Math.max(max, len);
    //             }else{
    //                 extra = 0;
    //                 len = 0;
    //             }
    //         }
    //     }
        
    //     return max;
    // }
    
    // 4.DP
    public int longestValidParentheses(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        int[] state = new int[chars.length];
        int open = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '(') open++;
            if(chars[i] == ')' && open > 0){
                // match found
                state[i] = 2 + state[i - 1];
                // add matches to previous
                if(i - state[i] > 0) state[i] += state[i - state[i]];
                open--;
            }
            max = Math.max(max, state[i]);
        }
        return max;
    }
}
