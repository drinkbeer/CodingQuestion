class MyStack 
{
    Queue<Integer> queue;
    
    public MyStack()
    {
        this.queue=new LinkedList<Integer>();
    }
    
    // Push element x onto stack.
    public void push(int x) 
    {
       queue.add(x);
       for(int i=0;i<queue.size()-1;i++)
       {
           queue.add(queue.poll());
       }
    }

    // Removes the element on top of the stack.
    public int pop() 
    {
        return queue.poll();
    }

    // Get the top element.
    public int top() 
    {
        return queue.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() 
    {
        return queue.isEmpty();
    }
}


// 2. Deque (not allowed to use deque, as removeFirst() is not standard Queue operation)
// class MyStack {

//     Deque<Integer> dq;
    
//     /** Initialize your data structure here. */
//     public MyStack() {
//         dq = new ArrayDeque<>();
//     }
    
//     /** Push element x onto stack. */
//     public void push(int x) {
//         dq.offerFirst(x);
//     }
    
//     /** Removes the element on top of the stack and returns that element. */
//     public int pop() {
//         return dq.removeFirst();
//     }
    
//     /** Get the top element. */
//     public int top() {
//         return dq.peekFirst();
//     }
    
//     /** Returns whether the stack is empty. */
//     public boolean empty() {
//         return dq.isEmpty();
//     }
// }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
