
https://leetcode.com/tag/heap/  


#### Heap
https://www.geeksforgeeks.org/heap-data-structure/ . 
https://www.geeksforgeeks.org/binary-heap/  
https://stackoverflow.com/questions/12719066/priority-queue-remove-complexity-time . 

According to Oracle documentation: "Implementation note: this implementation provides O(log(n)) time for the enqueing and dequeing methods (offer, poll, remove() and add); linear time for the remove(Object) and contains(Object) methods; and constant time for the retrieval methods (peek, element, and size)."

Remove/add the max/min element from heap complexity is `O(logN)`, remove/search a random element is `O(N)`

#### Max Heap
https://www.geeksforgeeks.org/max-heap-in-java/

A max-heap is a complete binary tree in which the value in each internal node is greater than or equal to the values in the children of that node.

Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index `2k+1` and its right child at index `2k+2`.


```
public class MaxHeap {

    private int[] heap;
    private int size;
    private int maxSize;

    public MaxHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        heap = new int[this.maxSize + 1];
        heap[0] = Integer.MAX_VALUE;
    }

    // Return the index of parent
    private int parent(int pos) {
        return pos / 2;
    }

    // Return the index of left child
    private int leftChild(int pos) {
        return 2 * pos;
    }

    // Return the index of right child
    private int rightChild(int pos) {
        return 2 * pos + 1;
    }

    private boolean isLeaf(int pos) {
        return pos >= size / 2 && pos <= size;
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    /**
     * A recursive function to max heapify the given subtree.
     * This function assumes the left and right subtrees are already heapified, we only need to fix the root.
     */
    private void heapify(int pos) {
        if (isLeaf(pos)) return;

        if (heap[pos] < heap[leftChild(pos)] || heap[pos] < heap[rightChild(pos)]) {
            if (heap[leftChild(pos)] > heap[rightChild(pos)]) {
                swap(pos, leftChild(pos));
                heapify(leftChild(pos));
            } else {
                swap(pos, rightChild(pos));
                heapify(rightChild(pos));
            }
        }
    }

    /**
     * Insert a new element to the heap, and fix the violated element
     */
    private void insert(int element) {
        heap[++size] = element;
        int curr = size;
        while(heap[curr] > heap[parent(curr)]) {
            swap(curr, parent(curr));
            curr = parent(curr);
        }
    }

    /**
     * Remove element from the max heap.
     */
    private int pollMax() {
        int polled = heap[1];
        heap[1] = heap[size--];
        heapify(1);
        return polled;
    }

    public static void main(String[] args) {
        System.out.println("The Max Heap is ");
        MaxHeap maxHeap = new MaxHeap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        System.out.println("The max val is " + maxHeap.pollMax());
    }

    private void print() {
        for (int i = 1; i <= size / 2; i++) {
            System.out.print(" PARENT : " + heap[i] + " LEFT CHILD : " +
                    heap[2 * i] + " RIGHT CHILD :" + heap[2 * i + 1]);
            System.out.println();
        }
    }
}

```

#### Min Heap
https://www.geeksforgeeks.org/min-heap-in-java/

A Min-Heap is a complete binary tree in which the value in each internal node is greater than or equal to the values in the children of that node.
Mapping the elements of a heap into an array is trivial: if a node is stored a index k, then its left child is stored at index 2k + 1 and its right child at index 2k + 2.



Top-K series code could be resolved by either heap or bucket sort.

https://leetcode.com/problems/top-k-frequent-words/
