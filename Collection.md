
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

####Collection.java
The root interface in the collection hierarchy. All data structures in Java (List, Set, Map, etc).
```Java
public interface Collection<E> extends Iterable<E> {
    // a.Query Operations
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    // Returns an iterator over the elements in this collection.  
    // There are no guarantees of order
    Iterator<E> iterator();
    // Returns an array containing all of the elements in this collection.
    // This method acts as bridge between array-based and collection-based APIs.
    Object[] toArray();
    <T> T[] toArray(T[] a);

    // b.Modification Operations
    boolean add(E e);
    boolean remove(Object o);

    // c.Bulk Operations
    boolean containsAll(Collection<?> c);
    boolean addAll(Collection<? extends E> c);
    boolean removeAll(Collection<?> c);
    // Retains elements in this collection, removes elements not contained
    boolean retainAll(Collection<?> c);
    void clear();

    // d.Comparison and hashing
    //  Compares the specified object with this collection for equality.
    boolean equals(Object o);
    int hashCode();
}
```

####List.java(Interface)
An unordered and duplicates-allowed collection. 

Implemented by `LinkedList`, `ArrayList`, `Vector`, `Stack`.
```Java
public interface List<E> extends Collection<E> {
    // a.Query Operations
    int size();
    boolean isEmpty();
    boolean contains(Object o);
    // Returns an iterator over the elements in this list in *proper sequence*.
    Iterator<E> iterator();
    // Returns an array containing all of the elements in this list in proper
    // sequence (from first to last element).
    Object[] toArray();
    <T> T[] toArray(T[] a);


    // b.Modification Operations
    boolean add(E e);
    boolean remove(Object o);


    // c.Bulk Modification Operations
    boolean containsAll(Collection<?> c);
    // Appends all elements to the end of this list, in the origin order
    boolean addAll(Collection<? extends E> c);
    // Inserts all elements into this list at the specified position.
    boolean addAll(int index, Collection<? extends E> c);
    boolean removeAll(Collection<?> c);
    boolean retainAll(Collection<?> c);
    void clear();


    // d.Comparison and hashing
    boolean equals(Object o);
    int hashCode();


    // e.Positional Access Operations
    E get(int index);
    // Replaces the element at specific position
    E set(int index, E element);
    // Inserts element at specified position, Shifts the element currently to right
    void add(int index, E element);
    // Removes the element at specified position
    E remove(int index);

    // f.Search Operations
    // Returns index of first occurrence of the element, or -1 if not contain
    int indexOf(Object o);
    // Returns index of last occurrence of the element, or -1 if not contain
    int lastIndexOf(Object o);

    // g.List Iterators
    // Returns iterator in proper sequence
    ListIterator<E> listIterator();
    // Returns iterator in proper sequence, starting at specified position
    ListIterator<E> listIterator(int index);

    // h.View
    // Returns a view of list, >=fromIndex && <toIndex
    List<E> subList(int fromIndex, int toIndex);
}
```


###Reference
[Java Collections Framework summary table](http://www.codejava.net/java-core/collections/java-collections-framework-summary-table)
