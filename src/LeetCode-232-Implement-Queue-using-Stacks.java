// class MyQueue {
//     Stack<Integer> head;
//     Stack<Integer> tail;
    
//     public MyQueue(){
//         head = new Stack<Integer>();
//         tail = new Stack<Integer>();
//     }
    
//     // Push element x to the back of queue.
//     public void push(int x) {
//         tail.push(x);
//     }

//     // Removes the element from in front of queue.
//     public int pop() {
//         if(empty()) return -1;
//         if(head.isEmpty()){
//             transfer(head, tail);
//         }
//         return head.pop();
//     }

//     // Get the front element.
//     public int peek() {
//         if(empty()) return -1;
//         if(head.isEmpty()){
//             transfer(head, tail);
//         }
//         return head.peek();
//     }

//     // Return whether the queue is empty.
//     public boolean empty() {
//         // if(head.isEmpty() && tail.isEmpty()) return true;
//         // return false;
//         return head.isEmpty() && tail.isEmpty();
//     }
    
//     private void transfer(Stack head, Stack tail){
//         while(!tail.isEmpty()){
//             head.push(tail.pop());
//         }
//     }
// }


/*
Queue: FIFO

Stack: LIFO

*/
class MyQueue {

    Stack<Integer> enqueue;
    Stack<Integer> dequeue;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        enqueue = new Stack<>();
        dequeue = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        enqueue.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return dequeue.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        
        if (dequeue.isEmpty()) {
            while (!enqueue.isEmpty()) {
                dequeue.push(enqueue.pop());
            }
        }
        
        return dequeue.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return dequeue.isEmpty() && enqueue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
