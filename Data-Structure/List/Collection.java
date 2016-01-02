package java.util;

/**
 * The root interface in the <i>collection hierarchy</i>.  A collection
 * represents a group of objects, known as its <i>elements</i>.  Some
 * collections allow duplicate elements and others do not.  Some are ordered
 * and others unordered.  The JDK does not provide any <i>direct</i>
 * implementations of this interface: it provides implementations of more
 * specific subinterfaces like <tt>Set</tt> and <tt>List</tt>.  This interface
 * is typically used to pass collections around and manipulate them where
 * maximum generality is desired.
 *
 * <p><i>Bags</i> or <i>multisets</i> (unordered collections that may contain
 * duplicate elements) should implement this interface directly.
 *
 * <p>All general-purpose <tt>Collection</tt> implementation classes (which
 * typically implement <tt>Collection</tt> indirectly through one of its
 * subinterfaces) should provide two "standard" constructors: a void (no
 * arguments) constructor, which creates an empty collection, and a
 * constructor with a single argument of type <tt>Collection</tt>, which
 * creates a new collection with the same elements as its argument.  In
 * effect, the latter constructor allows the user to copy any collection,
 * producing an equivalent collection of the desired implementation type.
 * There is no way to enforce this convention (as interfaces cannot contain
 * constructors) but all of the general-purpose <tt>Collection</tt>
 * implementations in the Java platform libraries comply.
 */

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
