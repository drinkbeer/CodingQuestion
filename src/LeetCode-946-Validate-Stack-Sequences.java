class Solution {
    // 1. Validate using a real stack
//     public boolean validateStackSequences(int[] pushed, int[] popped) {
//         Stack<Integer> stack = new Stack<>();
//         for (int i = 0, j = 0; j < popped.length;) {
//             // System.out.println(stack.toString() + "  " + i + "   " + j);
//             if (i >= pushed.length) {
                
//                 if (stack.peek() != popped[j]) return false;
//                 j++;
//                 stack.pop();
//                 continue;
//             }
            
//             stack.push(pushed[i]);
//             i++;
            
//             while (!stack.isEmpty() && stack.peek() == popped[j]) {
//                 stack.pop();
//                 j++;
//             }
//         }
        
//         return stack.isEmpty();
//     }
    
    // 2. A more concise solution
    /*
    https://leetcode.com/problems/validate-stack-sequences/discuss/197667/Java-straight-forward-stack-solution.
    */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        int i = 0;
        for (int p : pushed) {
            stk.push(p);
            while (!stk.isEmpty() && stk.peek() == popped[i]) {
                stk.pop();
                ++i;
            }
        }
        return stk.empty();
    }
}
