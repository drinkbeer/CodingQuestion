

package java.util;

/**
 * An ordered collection.
 *
 * Unlike sets, lists typically allow duplicate elements.  More formally,
 * lists typically allow pairs of elements <tt>e1</tt> and <tt>e2</tt>
 * such that <tt>e1.equals(e2)</tt>, and they typically allow multiple
 * null elements if they allow null elements at all.  It is not inconceivable
 * that someone might wish to implement a list that prohibits duplicates, by
 * throwing runtime exceptions when the user attempts to insert them, but we
 * expect this usage to be rare.<p>
 *
 * The <tt>List</tt> interface places additional stipulations, beyond those
 * specified in the <tt>Collection</tt> interface, on the contracts of the
 * <tt>iterator</tt>, <tt>add</tt>, <tt>remove</tt>, <tt>equals</tt>, and
 * <tt>hashCode</tt> methods.  Declarations for other inherited methods are
 * also included here for convenience.<p>
 *
 * The <tt>List</tt> interface provides four methods for positional (indexed)
 * access to list elements.  Lists (like Java arrays) are zero based.  Note
 * that these operations may execute in time proportional to the index value
 * for some implementations (the <tt>LinkedList</tt> class, for
 * example). Thus, iterating over the elements in a list is typically
 * preferable to indexing through it if the caller does not know the
 * implementation.<p>
 *
 * The <tt>List</tt> interface provides a special iterator, called a
 * <tt>ListIterator</tt>, that allows element insertion and replacement, and
 * bidirectional access in addition to the normal operations that the
 * <tt>Iterator</tt> interface provides.  A method is provided to obtain a
 * list iterator that starts at a specified position in the list.<p>
 *
 * The <tt>List</tt> interface provides two methods to search for a specified
 * object.  From a performance standpoint, these methods should be used with
 * caution.  In many implementations they will perform costly linear
 * searches.<p>
 *
 * The <tt>List</tt> interface provides two methods to efficiently insert and
 * remove multiple elements at an arbitrary point in the list.<p>
 *
 * Note: While it is permissible for lists to contain themselves as elements,
 * extreme caution is advised: the <tt>equals</tt> and <tt>hashCode</tt>
 * methods are no longer well defined on such a list.
 */

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
