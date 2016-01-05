
The major characteristics of the top level interfaces in Java Collections Framwork (under java.util)

|          |Duplicates?|Nulls?|Insertion Order|Sub-interfaces|Implementations|
|----------|-----------|------|---------------|--------------|---------------|
|List      |Y|Y|Append at end or by specific position||ArrayList, LinkedList|
|Queue     |Y|N|FIFO|Deque|PriorityQueue, LinkedList, ArrayDeque|
|Deque     |Y|N|FIFO like a queue, or LIFO like a stack||ArrayDeque, LinkedList|
|Set       |N|At most one|Dependent|SortedSet, navigableSet|HashSet, LinkedHashSet, TreeSet|
|Map       |N(Keys),Y(Values)|Y(Key, null<=1), Y(Value)|Dependent|SortedMap, NavigableMap|HashMap, LinkedHashMap, TreeMap|

All interfaces, except Collection, share one thing in common: all concrete implementations are resizable, meaning they have an initial capacity that can hold x elements before resizing.


Get, Add, Remove Time Complexity


###1.[ArrayList vs. LinkedList vs. Vector](http://www.programcreek.com/2013/03/arraylist-vs-linkedlist-vs-vector/)
![Hierarchy Diagram](/Data-Structure/java-collection-hierarchy.jpeg)

They all implement List interface. `They are very similar to use. Their main difference is their implementation which causes different performance for different operations.`

ArrayList is implemented as a `resizable array`. As more elements are added to ArrayList, its size is increased dynamically. It's elements can be accessed directly by using the get and set methods, since ArrayList is essentially an array.

LinkedList is implemented as a `double linked list`. Its performance on add and remove is better than Arraylist, but worse on get and set methods.

Vector is similar with ArrayList, but it is `synchronized`.

ArrayList is a better choice if your program is thread-safe. Vector and ArrayList require more space as more elements are added. Vector each time doubles its array size, while ArrayList grow 50% of its size each time. LinkedList, however, also implements Queue interface which adds more methods than ArrayList and Vector, such as offer(), peek(), poll(), etc.

Note: The default initial capacity of an ArrayList is pretty small. It is a good habit to construct the ArrayList with a higher initial capacity. This can avoid the resizing cost.

####Performance

|   |ArrayList|LinkedList|
|---|--------|----------|
|get()|O(1)|O(n)|
|add()|O(1)|O(1) amortized|
|remove()|O(n)|O(n)|

+ArrayList has O(n) time complexity for arbitrary indices of remove, but O(1) for operation at the end of list(get/add)

+LinkedList has O(n) time complexity for arbitrary indices of add/remove, but O(1) for operation at end/beginning of list(add)

![arraylist-vs-linkedlist-performance](/Data-Structure/arraylist-vs-linkedlist-performance.png/)

Difference of performance is obvious. LinkedList is faster in add and remove, but slower in get. In brief, LinkedList is preferred if:
+ there are no large number of random access of element
+ there are a large number of add/remove operations

###Reference
[Java Collections Framework summary table](http://www.codejava.net/java-core/collections/java-collections-framework-summary-table)

[How to Check if an Array Contains a Value in Java Efficiently?](http://www.programcreek.com/2014/04/check-if-array-contains-a-value-java/)