
- [ArrayList vs. LinkedList vs. Vector](#ArrayList vs. LinkedList vs. Vector)
- [HashSet vs. TreeSet vs. LinkedHashSet](#HashSet vs. TreeSet vs. LinkedHashSet)
- [HashMap vs. TreeMap vs. Hashtable vs. LinkedHashMap](#HashMap vs. TreeMap vs. Hashtable vs. LinkedHashMap)

The major characteristics of the top level interfaces in Java Collections Framwork (under java.util)

|          |Duplicates?|Nulls?|Insertion Order|Sub-interfaces|Implementations|
|----------|-----------|------|---------------|--------------|---------------|
|List      |Y|Y|Append at end or by specific position||ArrayList, LinkedList|
|Queue     |Y|N|FIFO|Deque|PriorityQueue, LinkedList, ArrayDeque|
|Deque     |Y|N|FIFO like a queue, or LIFO like a stack||ArrayDeque, LinkedList|
|Set       |N|At most one|Dependent|SortedSet, navigableSet|HashSet, LinkedHashSet, TreeSet|
|Map       |N(Keys),Y(Values)|Y(Key, null<=1), Y(Value)|Dependent|SortedMap, NavigableMap|HashMap, LinkedHashMap, TreeMap|

![Hierarchy Diagram](/Data-Structure/java-collection-hierarchy.jpeg)

<a name = "ArrayList vs. LinkedList vs. Vector"/>
###1.[ArrayList vs. LinkedList vs. Vector](http://www.programcreek.com/2013/03/arraylist-vs-linkedlist-vs-vector/)

They all implement List interface. They are very similar to use. Their main difference is their implementation which causes different performance for different operations.

ArrayList is implemented as a **resizable array**. As more elements are added to ArrayList, its size is increased dynamically. It's elements can be accessed directly by using the get and set methods, since ArrayList is essentially an array.

LinkedList is implemented as a **double linked list**. Its performance on add and remove is better than Arraylist, but worse on get and set methods.

Vector is similar with ArrayList, but it is **synchronized**.

ArrayList is a better choice if your program is thread-safe. Vector and ArrayList require more space as more elements are added. Vector each time doubles its array size, while ArrayList grow 50% of its size each time. 

LinkedList, however, also implements Queue interface which adds more methods than ArrayList and Vector, such as offer(), peek(), poll(), etc.

Note: The default initial capacity of an ArrayList is pretty small. It is a good habit to construct the ArrayList with a higher initial capacity. This can avoid the resizing cost.

####Performance

|   |ArrayList|LinkedList|
|---|--------|----------|
|get()|O(1)|O(n)|
|add()|O(1)|O(1) amortized|
|remove()|O(n)|O(n)|

+ ArrayList has O(n) time complexity for arbitrary indices of remove, but O(1) for operation at the end of list(get/add)

+ LinkedList has O(n) time complexity for arbitrary indices of add/remove, but O(1) for operation at end/beginning of list(add)

![arraylist-vs-linkedlist-performance](/Data-Structure/arraylist-vs-linkedlist-performance.png/)

Difference of performance is obvious. LinkedList is faster in add and remove, but slower in get. In brief, LinkedList is preferred if:
+ there are no large number of random access of element
+ there are a large number of add/remove operations

<a name = "HashSet vs. TreeSet vs. LinkedHashSet"/>
###2.[HashSet vs. TreeSet vs. LinkedHashSet](http://www.programcreek.com/2013/03/hashset-vs-treeset-vs-linkedhashset/)

A Set contains no duplicate elements.

When to use HashSet or TreeSet?
+ if you need a fast set, you should use HashSet
+ if you need a sorted set, then TreeSet should be used
+ if you need a set that can be store the insertion order, LinkedHashSet should be used.

HashSet is implemented by a hashtable. Elements are not ordered. The add, remove, and contains methods have constant time complexity O(1).

TreeSet is implemented using a tree structure(red-black tree in algorithm book). The elements in a set are sorted, but the add, remove, and contains methods has time complexity of O(log (n)). It offers several methods to deal with the ordered set like first(), last(), headSet(), tailSet(), etc.

LinkedHashSet is between HashSet and TreeSet. It is implemented as a hash table with a linked list running through it, so it provides the order of insertion. The time complexity of basic methods is O(1).

![hashset-treeset-linkedhashset-performance](/Data-Structure/hashset-treeset-linkedhashset-performance.png/)

TreeSet is much slower because it is sorted.

<a name = "HashMap vs. TreeMap vs. Hashtable vs. LinkedHashMap"/>
###3.[HashMap vs. TreeMap vs. Hashtable vs. LinkedHashMap](http://www.programcreek.com/2013/03/hashmap-vs-treemap-vs-hashtable-vs-linkedhashmap/)
![Map Hierarchy](/Data-Structure/java-map-hierarchy.jpg/)

+ HashMap
    - implemented as a hash table
    - no ordering on keys or values
+ TreeMap
    - implemented based on red-black tree structure
    - ordered by the key
+ LinkedHashMap
    - preserves the insertion order
+ Hashtable
    - synchronized (in contrast to HashMap)

The HashMap API is similar to Hashtable, difference:
+ HashMap is unsynchronized and not thread-safe, HashTable is synchronized and thread-safe.
+ HashMap allows one null keys and null values; HashTable not allow null keys and null values.
+ HashMap is much faster and use less memory than HashTable. (Unsynchronized objects are often much better in performance in compare to synchronized objects in single thread environment.)

When to use HashMap and Hashtable?
+ HashMap is preferred in unsynchronized or single threaded environment.
+ HashTable is preferred in multi-thread environment.

TreeMap is 
+ implemented by Red-Black tree
+ sorted according to the order of keys
+ guaranteed log(n) time cost for the containsKey(), get(), put() and remove()
+ Not synchronized


###Reference
[Java Collections Framework summary table](http://www.codejava.net/java-core/collections/java-collections-framework-summary-table)

[How to Check if an Array Contains a Value in Java Efficiently?](http://www.programcreek.com/2014/04/check-if-array-contains-a-value-java/)