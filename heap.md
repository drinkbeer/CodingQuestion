
https://leetcode.com/tag/heap/  


#### Heap
https://www.geeksforgeeks.org/heap-data-structure/
https://stackoverflow.com/questions/12719066/priority-queue-remove-complexity-time

According to Oracle documentation: "Implementation note: this implementation provides O(log(n)) time for the enqueing and dequeing methods (offer, poll, remove() and add); linear time for the remove(Object) and contains(Object) methods; and constant time for the retrieval methods (peek, element, and size)."


#### Max Heap
https://www.geeksforgeeks.org/max-heap-in-java/

A max-heap is a complete binary tree in which the value in each internal node is greater than or equal to the values in the children of that node.

Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k+1 and its right child at index 2k+2.

#### Min Heap
https://www.geeksforgeeks.org/min-heap-in-java/

A Min-Heap is a complete binary tree in which the value in each internal node is greater than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.



Top-K series code could be resolved by either heap or bucket sort.

https://leetcode.com/problems/top-k-frequent-words/
