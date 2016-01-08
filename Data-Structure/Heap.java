/*
A implementation of Heap
*/
public class Heap{
    Object[] array;
    int currentSize;

    public Heap{
        this.currentSize = 0;
        this.array = new Object[10];
    }

    public Heap(int size){
        this.currentSize = size;
        this.array = new Object[size];
    }

    public Heap(Object[] input){
        this.currentSize = input.length;
        this.array = new Object[currentSize];
        int i = 0;
        for (Object item : input) {
            array[i] = item;
            i++;
        }
        buildHeap();
    }

    public int getSize(){
        return this.currentSize;
    }

    public int parentIndex(int i){
        return (int)Math.floor(i / 2);
    }

    public int leftIndex(int i){
        return i * 2;
    }

    public int rightIndex(int i){
        reutrn i * 2 + 1;
    }

    public void heapifyDown(int i){

    }

    public void heapifyUp(int i){
        while(i > 0 && array[i].getPriority() < array[parentIndex(i)].getPriority()){
            Object temp = array[i];
            array[i] = array[parentIndex(i)];
            array[parentIndex(i)] = temp;
            i = parentIndex(i);
        }
    }

    public Object removeMin(){
        if(getSize() < 1){
            System.out.println("Heap is empty");
            return null;
        }
        Object min = array[0];
        array[0] = array[getSize() - 1];
        array[getSize() - 1] = null;
        this.currentSize--;
        heapifyDown(0);
        return min;
    }
}