https://www.geeksforgeeks.org/deque-interface-java-example/  

Deque is a linear collection that supports element insertion and removal at both ends. Most deque implementations place no fixed limits on the number of elements they may contain, but this interface supports capacity-restricted deques as well as those with no fixed size limit.

This interface defines methods to access the elements at both ends of the deque. Methods are provided to insert, remove and examine the element. Each of these methods exists in two forms: one throws an exception if the operation fails, the other returns a special value (either null or false, depending on the operation).

```
Deque<Integer> queue = new LinkedList<>();
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

