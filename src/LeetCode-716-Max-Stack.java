// 1. Using Two Stacks
/*
Runtime: 88 ms, faster than 30.97% of Java online submissions for Max Stack.
Memory Usage: 51.3 MB, less than 25.90% of Java online submissions for Max Stack.
*/
class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        this.stack = new Stack<>();
        this.maxStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty()) {
            maxStack.push(x);
        } else {
            maxStack.push(Math.max(x, maxStack.peek()));
        }
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        if (stack.peek() == maxStack.peek()) {
            stack.pop();
            return maxStack.pop();
        }
        
        int maxOnTop = maxStack.peek();
        
        Stack<Integer> temp = new Stack<>();
        while(stack.peek() != maxOnTop) {
            temp.push(this.pop());
        }
        
        stack.pop();
        maxStack.pop();
        
        while(!temp.isEmpty()) this.push(temp.pop());
        return maxOnTop;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
