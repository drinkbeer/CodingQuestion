
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


1.ArrayList vs. LinkedList vs. Vector
![Hierarchy Diagram](/Data-Structure/java-collection-hierarchy.jpeg)



###Reference
[Java Collections Framework summary table](http://www.codejava.net/java-core/collections/java-collections-framework-summary-table)
