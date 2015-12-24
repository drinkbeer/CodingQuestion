/*
Source: Data Structure and Algorithm Analysis in Java

This is an implementation of ArrayList generic class. We don't provide a Collection
or List interface; ArrayList class is standalone. Main details:
    1.ArrayList maintains the underlying array, the array capacity, and the current 
    number of items are stored.
    2.ArrayList will provide a mechanism to change the capacity of the underlying 
    array. The capacity is changed by obtaining a new array, copying the old array
    into the new array, and allowing the Java Virtual Machine(JVM) to reclaim the 
    old array.
    3.get() and set()
    4.Basic routines, such as size, isEmpty(), clear(), a version of remove(), two 
    versions of add().
    5.ArrayList will implement the Iterable interface. This class will store the 
    index of the next item in the iteration sequence and provide implementations of 
    next, hasNext, and remove. The ArrayList's iterator() will return a newly 
    constructed instance of the class that implements the Iterable interface.
*/
public class ArrayList<E> implements Iterable<E>{
    private static final int CAPACITY = 10;     // Default size is 10.

    private int size;       // the used # in array
    private E[] items;      // underlying array

    public ArrayList(){
        clearList();
    }

    public void clear(){
        clearList();
    }

    private void clearList(){
        size = 0;
        makeCapacity(CAPACITY);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public void trimToSize(){   // trim array to # it used
        makeCapacity(size());
    }

    public E get(int index){
        if(index < 0 || index >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[index];
    }

    public E set(int index, E newItem){
        if(index < 0 || index >= size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        E oldItem = items[index];
        items[index] = newItem;
        return oldItem;
    }

    public void makeCapacity(int capacity){
        if(capacity < size){
            return;
        }
        E[] temp = items;
        items = (E[])new Object[capacity];
        for(int i = 0; i < size(); i++){
            items[i] = temp[i];
        }
    }

    public boolean add(E item){
        add(size(), item);
        return true;
    }

    public void add(int index, E item){
        if(items.length == size()){
            makeCapacity(2 * size() + 1);
        }
        for(int i = size; i > index; i--){
            items[i] = items[i - 1];
        }
        items[index] = item;
        size++;
    }

    public E remove(int index){
        E removed = items[index];
        for(int i = index; i < size() - 1; i++){
            items[i] = items[i + 1];
        }
        size--;
        return removed;
    }

    public java.util.Iterator<E> iterator(){
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements java.util.Iterator<E>{
        private int currIdx = 0;

        public boolean hasNext(){
            return currIdx < size();
        }

        public E next(){
            if(!hasNext()){
                throw new java.util.NoSuchElementException();
            }
            return items[currIdx++];
        }

        public void remove(){
            ArrayList.this.remove(--currIdx);
        }
    }
}