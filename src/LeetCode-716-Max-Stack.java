class MaxStack {

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
    
    // 2. Doubly-LinkedList + TreeMap
    /*
    https://leetcode.com/problems/max-stack/discuss/129922/Java-simple-solution-with-strict-O(logN)-push()popMax()pop()
    
    Store values nodes in Doubly-LinkedList,
    Using TreeMap as a <Sorted Value, List of Nodes> pair. As TreeMap could do GET/PUT/DELETE in O(logN), so 
    pop()/push()/popMax() Time  O(logN)
    
    <-   (prev) curr (next)  ->  <- (prev)  head   (next) ->  
    
    */
    private class Node {
        int val;
        Node prev, next;
        
        public Node (int val) {
            this.val = val;
        }
    }
    
    private Node head;
    private TreeMap<Integer, LinkedList<Node>> map;
    
    /** initialize your data structure here. */
    public MaxStack() {
        head = new Node(-1);
        map = new TreeMap<>();
    }
    
    public void push(int x) {
        Node curr = new Node(x);
        addToHead(curr);
        map.computeIfAbsent(x, k -> new LinkedList<>()).add(curr);
    }
    
    public int pop() {
        Node curr = head.prev;
        if (curr == null) return -1;    // no element exist
        deleteNode(curr);
        
        // since it's pop(), we are always sure that the last element in the map's value list will be the tail
        map.get(curr.val).removeLast();
        if (map.get(curr.val).isEmpty()) {
            map.remove(curr.val);
        }
        return curr.val;
    }
    
    public int top() {
        return head.prev.val;
    }
    
    public int peekMax() {
        return map.lastKey();
    }
    
    public int popMax() {
        int maxVal = peekMax();
        Node max = map.get(maxVal).removeLast();
        deleteNode(max);
        if (map.get(maxVal).isEmpty()) {
            map.remove(maxVal);
        }
        return maxVal;
    }
    
    private void addToHead(Node curr) {
        curr.next = head;
        curr.prev = head.prev;
        if (head.prev != null) head.prev.next = curr;
        head.prev = curr;
    }
    
    private void deleteNode(Node curr) {
        if (curr.prev != null) curr.prev.next = curr.next;
        if (curr.next != null) curr.next.prev = curr.prev;
        curr.next = null;
        curr.prev = null;
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
