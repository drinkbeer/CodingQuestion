// 1. Using Two Stacks
/*
Runtime: 88 ms, faster than 30.97% of Java online submissions for Max Stack.
Memory Usage: 51.3 MB, less than 25.90% of Java online submissions for Max Stack.
*/
// class MaxStack {
//     Stack<Integer> stack;
//     Stack<Integer> maxStack;

//     /** initialize your data structure here. */
//     public MaxStack() {
//         this.stack = new Stack<>();
//         this.maxStack = new Stack<>();
//     }
    
//     public void push(int x) {
//         stack.push(x);
//         if (maxStack.isEmpty()) {
//             maxStack.push(x);
//         } else {
//             maxStack.push(Math.max(x, maxStack.peek()));
//         }
//     }
    
//     public int pop() {
//         maxStack.pop();
//         return stack.pop();
//     }
    
//     public int top() {
//         return stack.peek();
//     }
    
//     public int peekMax() {
//         return maxStack.peek();
//     }
    
//     public int popMax() {
//         if (stack.peek() == maxStack.peek()) {
//             stack.pop();
//             return maxStack.pop();
//         }
        
//         int maxOnTop = maxStack.peek();
        
//         Stack<Integer> temp = new Stack<>();
//         while(stack.peek() != maxOnTop) {
//             temp.push(this.pop());
//         }
        
//         stack.pop();
//         maxStack.pop();
        
//         while(!temp.isEmpty()) this.push(temp.pop());
//         return maxOnTop;
//     }
// }

// 2.Using a doubly-linkedlist
class MaxStack {
    private class ListNode {
        int val;
        ListNode prev = null, next = null, twin = null;
        
        public ListNode(int val) {
            this.val = val;
        }
    }

    ListNode top;
    ListNode topMax;
    
    /** initialize your data structure here. */
    public MaxStack() {
        this.top = new ListNode(Integer.MIN_VALUE);
        this.topMax = new ListNode(Integer.MIN_VALUE);
        topMax.twin = top;
    }
    
    public void push(int x) {
        ListNode curr = new ListNode(x);
        
        ListNode currMax;
        if (x >= topMax.val) {
            // we find a new max value
            currMax = new ListNode(x);
            currMax.twin = curr;
        } else {
            // the max value is still the same as existing topMax
            currMax = new ListNode(topMax.val);
            currMax.twin = topMax.twin;
        }
        
        top = addToTail(top, curr);
        topMax = addToTail(topMax, currMax);
        
    }
    
    public int pop() {
        int topVal = top.val;
        top = deleteNode(top);
        topMax = deleteNode(topMax);
        return topVal;
    }
    
    public int top() {
        return top.val;
    }
    
    public int peekMax() {
        return topMax.val;
    }
    
    public int popMax() {
        int max = this.peekMax();
        
        ListNode toBeDeleted = topMax.twin;
        top = deleteNode(toBeDeleted);
        while(topMax.twin == toBeDeleted) {
            topMax = deleteNode(topMax);
        }
        
        // construct the max stack after topMax
        while(top.next != null) {
            ListNode next = top.next;
            
            ListNode currMax;
            if (next.val >= topMax.val) {
                currMax = new ListNode(next.val);
                currMax.twin = next;
            } else {
                currMax = new ListNode(topMax.val);
                currMax.twin = topMax.twin;
            }
            
            top = next;
            topMax = addToTail(topMax, currMax);
        }
        
        return max;
    }
    
    private ListNode addToTail(ListNode tail, ListNode curr) {
        tail.next = curr;
        curr.prev = tail;
        return curr;
    }
    
    private ListNode deleteNode(ListNode node) {
        node.prev.next = node.next;
        if (node.next != null) node.next.prev = node.prev;
        return node.prev;
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
