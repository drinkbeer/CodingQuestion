package Queue;

import Queue.DoublyLinkedList;

/*
A basic implementation of a queue using a doubly linked list.
http://algs4.cs.princeton.edu/43mst/Queue.java.html
*/
public class ListQueue {
    DoublyLinkedList list;

    public ListQueue(){
        list = new DoublyLinkedList();
    }

    public void enqueue(Object item){
        if(list.getSize() == 0){
            list.addFront(item);
        }else{
            list.addEnd(item);
        }
    }

    public Object dequeue(){
        try{
            return list.deleteFront().item;
        }catch(NullPointerException e){
            System.out.println("The queue is empty");
            return null;
        }
    }

    public int size(){
        return list.getSize();
    }

    public boolean isEmpty(){
        return list.getSize() == 0;
    }

    //????
    public boolean isFull(){
        throw new UnsupportedOperationException();
    }

    public String toString(){
        String s = list.toString();
        return s;
    }
}