/*
Time: O(N)
Space: O(N)
*/
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// public class NestedIterator implements Iterator<Integer> {

//     Queue<Integer> queue;
//     public NestedIterator(List<NestedInteger> nestedList) {
//         queue = new LinkedList<>();
//         recursive(nestedList, queue);
//     }
    
//     private void recursive(List<NestedInteger> list, Queue<Integer> queue) {
//         for (NestedInteger ni : list) {
//             if (ni.isInteger()) {
//                 queue.offer(ni.getInteger());
//             } else {
//                 recursive(ni.getList(), queue);
//             }
//         }
//     }

//     @Override
//     public Integer next() {
//         if (!queue.isEmpty()) {
//             return queue.poll();
//         }
//         return -1;
//     }

//     @Override
//     public boolean hasNext() {
//         return !queue.isEmpty();
//     }
// }

// 2. Lazy Load
/*
There are 1000000000 Integers in nestedList and the user only calls next() once. -> You have to put 1000000000 Integers into stack, but the user only takes the 1st one. Instead, we should push to stack "lazy".

*/
public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        recursive(nestedList, stack);
    }

    @Override
    public Integer next() {
        if (!hasNext()) throw new java.util.NoSuchElementException();
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            recursive(stack.pop().getList(), stack);
        }
        
        return !stack.isEmpty();
    }
    
    private void recursive(List<NestedInteger> list, Stack<NestedInteger> stack) {
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
