https://www.geeksforgeeks.org/deque-interface-java-example/  

Deque is a linear collection that supports element insertion and removal at both ends. Most deque implementations place no fixed limits on the number of elements they may contain, but this interface supports capacity-restricted deques as well as those with no fixed size limit.

This interface defines methods to access the elements at both ends of the deque. Methods are provided to insert, remove and examine the element. Each of these methods exists in two forms: one throws an exception if the operation fails, the other returns a special value (either null or false, depending on the operation).

```
Deque<Integer> queue = new LinkedList<>();
```

|Queue Method|Equivalent Deque Method|
|------------|-----------------------|
|add(e)|addLast(e)|
|offer(e)|offerLast(e)|
|remove()|removeFirst()|
|poll()|pollFirst()|
|peek()|peekFirst()|


