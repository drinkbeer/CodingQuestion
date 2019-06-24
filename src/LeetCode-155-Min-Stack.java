/*
LeetCode: https://leetcode.com/problems/min-stack/
LintCode: http://www.lintcode.com/problem/min-stack/
JiuZhang: http://www.jiuzhang.com/solutions/min-stack/
ProgramCreek: http://www.programcreek.com/2014/02/leetcode-min-stack-java/
GeeksForGeeks: http://www.geeksforgeeks.org/design-and-implement-special-stack-data-structure/

Analysis: 
Use two stacks, one for actual values, another for mininum values.
The idea is to do push and pop operation for top of minStack always be minimum.

Push(int x) // inserts an element x to Special Stack 
1) push x to the first stack (the stack with actual elements)
2) compare x with the top element of the second stack (the auxiliary stack). Let the top element be y.
…..a) If x is smaller than y then push x to the auxiliary stack.
…..b) If x is greater than y then push y to the auxiliary stack.

int Pop() // removes an element from Special Stack and return the removed element 
1) pop the top element from the auxiliary stack.
2) pop the top element from the actual stack and return it.

The step 1 is necessary to make sure that the auxiliary stack is also updated for future operations.

int getMin() // returns the minimum element from Special Stack 
1) Return the top element of auxiliary stack.

All above operation is O(1)

*/
// 1.Two stacks.
// class MinStack {
//     private Stack<Integer> stack;
//     private Stack<Integer> minStack;
    
//     public MinStack(){
//         this.stack = new Stack<Integer>();
//         this.minStack = new Stack<Integer>();
//     }
    
//     public void push(int x) {
//         stack.push(x);
//         if(minStack.isEmpty()){
//             minStack.push(x);
//         }else{
//             minStack.push(Math.min(x, minStack.peek()));
//         }
//     }

//     public void pop() {
//         minStack.pop();
//         stack.pop();
//     }

//     public int top() {
//         return stack.peek();
//     }

//     public int getMin() {
//         return minStack.peek();
//     }
// }

// 2.Two stacks. This one will save a little space. Time is also O(1)
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    
    public MinStack(){
        this.stack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }
    
    public void push(int x){
        stack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        }else{
            if(minStack.peek() >= x) minStack.push(x);
        }
    }
    
    public void pop(){
        if(stack.peek() == minStack.peek())minStack.pop();
        stack.pop();
    }
    
    public int top(){
        return stack.peek();
    }
    
    public int getMin(){
        return minStack.peek();
    }
}


// 3.Using a self-defined inner class
/*
Runtime: 47 ms, faster than 69.03% of Java online submissions for Min Stack.

*/
class MinStack {
    private class Pair {
        int val;
        int min;
        
        public Pair(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Stack<Pair> stack;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        int min = x;
        if (!stack.isEmpty()) {
            min = Math.min(min, stack.peek().min);
        }
        Pair p = new Pair(x, min);
        stack.push(p);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().min;
    }
}
