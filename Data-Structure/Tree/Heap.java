package Tree;

/*
A basic implementation of MaxHeap with int array.
*/
public class Heap {
    private static int DEFAULT_SIZE = 10;
    int[] array;
    int currentSize;

    public Heap() {
        this.currentSize = 0;
        this.array = new int[DEFAULT_SIZE];
    }

    public Heap(int size) {
        this.currentSize = size;
        this.array = new int[size];
    }

    public Heap(int[] arr) {
        this.currentSize = arr.length;
        this.array = new int[currentSize];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        buildHeap();
    }

    public int getSize() {
        return this.currentSize;
    }

    public int parentIndex(int i) {
        return (int) Math.floor(i / 2);
    }

    public int leftIndex(int i) {
        return i * 2;
    }

    public int rightIndex(int i) {
        return i * 2 + 1;
    }

    public void heapifyDown(int i) {

    }

    public void heapifyUp(int i) {
        while (i > 0 && array[i] < array[parentIndex(i)]) {
            int temp = array[i];
            array[i] = array[parentIndex(i)];
            array[parentIndex(i)] = temp;
            i = parentIndex(i);
        }
    }

    public int removeMin() {
        if (getSize() < 1) {
            throw new UnsupportedOperationException("Heap is empty");
        }
        int min = array[0];
        array[0] = array[getSize() - 1];
        array[getSize() - 1] = -1;
        this.currentSize--;
        heapifyDown(0);
        return min;
    }
}