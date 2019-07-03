https://www.geeksforgeeks.org/deque-interface-java-example/  

Deque is a linear collection that supports element insertion and removal at both ends. Most deque implementations place no fixed limits on the number of elements they may contain, but this interface supports capacity-restricted deques as well as those with no fixed size limit.

This interface defines methods to access the elements at both ends of the deque. Methods are provided to insert, remove and examine the element. Each of these methods exists in two forms: one throws an exception if the operation fails, the other returns a special value (either null or false, depending on the operation).

https://www.geeksforgeeks.org/deque-add-method-in-java/
```
public class GFG { 
    public static void main(String[] args) 
        throws IllegalStateException 
    { 
  
        // create object of De1ue 
        Deque<Integer> DQ = new LinkedList<Integer>(); 
  
        // Add numbers to end of Deque 
        DQ.add(7855642); 
        DQ.add(35658786); 
        DQ.add(5278367); 
        DQ.add(74381793); 
  
        // before removing print Deque 
        System.out.println("Deque: " + DQ); 
    } 
} 
```

```
public class GFG { 
    public static void main(String[] args) 
        throws IllegalStateException 
    { 
  
        // create object of De1ue 
        Deque<Integer> DQ = new ArrayDeque<Integer>(); 
  
        // Add numbers to end of Deque 
        DQ.add(7855642); 
        DQ.add(35658786); 
        DQ.add(5278367); 
        DQ.add(74381793); 
  
        // before removing print Deque 
        System.out.println("Deque: " + DQ); 
    } 
} 
```

#### Queue Related Operations

|Queue Method|Equivalent Deque Method|
|------------|-----------------------|
|add(e)|addLast(e)|
|offer(e)|offerLast(e)|
|remove()|removeFirst()|
|poll()|pollFirst()|
|peek()|peekFirst()|

#### Stack Related Operations

|Stack Method|Equivalent Deque Method|
|------------|-----------------------|
|push(e)|addFirst(e)|
|pop()|removeFirst()|
|peek()|peekFirst()|

#### 239. Sliding Window Maximum
https://leetcode.com/problems/sliding-window-maximum/

```
/*
https://leetcode.com/problems/sliding-window-maximum/discuss/65884/Java-O(n)-solution-using-deque-with-explanation

Runtime: 9 ms, faster than 82.32% of Java online submissions for Sliding Window Maximum.
Memory Usage: 41.2 MB, less than 85.19% of Java online submissions for Sliding Window Maximum.
O(N) time complexity.
The Window Range is [i - k + 1, i]

All these operations are to the head:
dq.peek();
dq.peekFirst();
dq.poll();
dq.pollFirst();

All these operations are to the tail:
dq.offer();
dq.add();
dq.peekLast();
dq.pollLast();
*/
public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) return new int[0];
    int[] res = new int[nums.length - k + 1];

    // Using Deque to store the index in the array
    // using res array to store the result value
    Deque<Integer> dq = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
        // the window index range is [i - k + 1, i]

        // Remove the element that is out of range k in the window
        if (!dq.isEmpty() && dq.peekFirst() < i - k + 1) {
            dq.pollFirst();
        }

        // Remote the smaller elements than nums[i] from right to left in the window
        // This is because if nums[x] <= nums[i], x < i, then nums[x] has no chance to become max
        // in [i - k + 1, i], or any other subsequent window: nums[i] would always be a better candidate
        while(!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
            dq.pollLast();
        }

        dq.offer(i);
        if (i - k + 1 >= 0) {
            res[i - k + 1] = nums[dq.peekFirst()];
        }
    }

    return res;
}
```

#### 654. Maximum Binary Tree
https://leetcode.com/problems/maximum-binary-tree/

```
// 2. Using a Deque based stack
/*
https://leetcode.com/problems/maximum-binary-tree/discuss/106156/Java-worst-case-O(N)-solution

Runtime: 8 ms, faster than 14.24% of Java online submissions for Maximum Binary Tree.
Memory Usage: 39.4 MB, less than 79.45% of Java online submissions for Maximum Binary Tree.

Worst Time O(N)

*/
 public TreeNode constructMaximumBinaryTree(int[] nums) {
     if (nums == null || nums.length == 0) return null;

     Deque<TreeNode> stack = new ArrayDeque<>();
     for (int i = 0; i < nums.length; i++) {
         TreeNode curr = new TreeNode(nums[i]);
         // traverse the nodes in the stack, and find the max-smaller one than nums[i], make it to be the left node of curr
         while(!stack.isEmpty() &&  stack.peek().val < nums[i]) {
             curr.left = stack.pop();
         }
         if (!stack.isEmpty() && stack.peek().val > nums[i]) {
             stack.peek().right = curr;
         }
         stack.push(curr);
     }

     return stack.isEmpty() ? null : stack.peekLast();
 }
```
