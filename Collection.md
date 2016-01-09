
Comparision
- [ArrayList vs. LinkedList vs. Vector](#ArrayList vs. LinkedList vs. Vector)
- [HashSet vs. TreeSet vs. LinkedHashSet](#HashSet vs. TreeSet vs. LinkedHashSet)
- [HashMap vs. TreeMap vs. Hashtable vs. LinkedHashMap](#HashMap vs. TreeMap vs. Hashtable vs. LinkedHashMap)

The major characteristics of the top level interfaces in Java Collections Framwork (under java.util)

|          |Duplicates?|Nulls?|Insertion Order|Implementations|
|----------|-----------|------|---------------|---------------|
|List      |Y|Y|Append at end or by specific position|ArrayList, LinkedList|
|Queue     |Y|N|FIFO|PriorityQueue, LinkedList, ArrayDeque|
|Deque     |Y|N|FIFO like a queue, or LIFO like a stack|ArrayDeque, LinkedList|
|Set       |N|At most one|Dependent|HashSet, LinkedHashSet, TreeSet|
|Map       |N(Keys),Y(Values)|Y(Key, null<=1), Y(Value)|Dependent|HashMap, LinkedHashMap, TreeMap|

###ArrayList
+ Implemented by array
+ Advantage
    - Randomly access(get and set) is constant time
+ Disadvantage
    - Modification(add and remove) is expensive, except changes are at end of arraylist
    - Search is inefficient
+ Complexity
    - Randomly access(get and set): O(1)
    - Insertion(add to front) and removal: O(n)

###LinkedList
+ Implemented by list of nodes
+ Advantage
    - Modification(add and remove) is constant time, when position if known
+ Disadvantage
    - Randomly access(add and set) is expensive
    - Search is inefficient
    - Indexable is not easy
+ Complexity
    - Randomly access(get, set): O(n)
    - Add, remove: O(1)

###Stack
+ FIFO: operation is all in top of stack. (push and pop)
+ Could be implemented by LinkedList, ArrayList
    - List: push to front of list, pop is remove front node of list
    - Array: use a pointer top(initilized as -1), push is arr[++top], pop is arr[top--]  (use top==-1 to check is empty)
+ Complexity
    - Push: O(1)
    - Pop: O(1)
+ Application
    + Balance symbols
    + Postfix expression
    + Method calls

###Queue
+ FILO: offer() is at end, poll() is at front
+ Could be implemented by DoubleLinkedList, array
    - List: Not finished
+ COmplexity:
    - Enqueue: O(1)
    - Dequeue: O(1)

###Set
#####Overview
+ A collection of non-duplicate values

#####Type
+ TreeSet(Sorted Set): value is sorted. Worst time O(logN)


###Map
#####Overview
+ A collection of entries, entry is Key-Value pair.
+ Key is unique, value could duplicate
+ Map itself doesn't provide iterator, but could iterate through Key Set/Value Set/Entry Set's iterator

#####Type
+ TreeMap(Sorted Map): keep keys in sorted order


### HashTable/[HashMap](http://www.cnblogs.com/skywang12345/p/3310835.html)

#####Overview
+ Perform **insert, delete, search in average O(1)**
+ Print in sorted order in O(n) not supported
+ Load factor: ratio of # of elements in hash table to table size

#####Hash Function
+ Determinism: given same input, always generate same hash code
+ Uniformity: map inputs as evenly as possible over its output range
+ Defined range: desirable that outputs has fixed size
+ Continuity: two inputs differing a little should be mapped to nearly equal hash values
+ Non-invertible: impossible to reconstruct input from hash code

#####Collision
+ Different input map to the same hash code
+ Solution: **Bucket(use a list to put elements with same hash code)**
    - insertion: first search for input's hash code, if exists, insert into the front of the existing list; if not, create a new list. (Why insert into front? Because recently inserted elements are more likely to be used in the near future.)

#####Probing???

#####Rehash
+ When # of elements in hash table beyond load factor, we enlarge hash table
+ Solution: build another table with twice size, copy elements to new table

###PriorityQueue(Heap)

#####Overview
+ Heap is a binary tree that is completely filled(except bottom level)
+ Height: O(logN)
+ For element in array index i
    - Left child: 2i
    - Right child: 2i + 1
    - Parent: floor((i-1)/2)

#####Property
+ Smallest element at root(Min Heap) or largest at root(Max Heap)
+ Min Heap: parent <= two children
+ Max Heap: parent >= two children
+ findMin() in Min Heap is O(1)

#####Application???


###Binary Tree
General Tree(From Java API-String)
```Java
public class Tree<T> {
    private Node<T> root;

    public Tree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }

    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private List<Node<T>> children;
    }
}
```

Binary Tree Node
```Java
class BinaryNode{
    Object element;
    BinaryNode left;
    BinaryNode right;
}
````

#####Overview
+ Average depth: O(sqrt(N)), worst depth: N-1

Binary Search Tree
#####Overview
+ Values in left subtree <= root value
+ Values in right subtree >= root value
+ Time: O(logN)


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