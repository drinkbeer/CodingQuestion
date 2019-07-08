class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String s = tokens[i];
            if ("+".equals(s)) {
                int o2 = stack.pop(), o1 = stack.pop();
                stack.push(o1 + o2);
            } else if ("-".equals(s)) {
                int o2 = stack.pop(), o1 = stack.pop();
                stack.push(o1 - o2);
            } else if ("*".equals(s)) {
                int o2 = stack.pop(), o1 = stack.pop();
                stack.push(o1 * o2);
            } else if ("/".equals(s)) {
                int o2 = stack.pop(), o1 = stack.pop();
                stack.push((int) (o1 / o2));
            } else {
                int val = Integer.parseInt(s);
                stack.push(val);
            }
        }
        
        return stack.pop();
    }
}
