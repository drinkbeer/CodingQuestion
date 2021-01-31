# Sorting Algorithms Cheatsheet

Contents: 

+ [Bubble Sort](#Bubble Sort)
+ [Insertion Sort](#Insertion Sort)
+ [Selection Sort](#Selection Sort)

+ [Merge Sort](#Merge Sort)
+ [Heap Sort](#Heap Sort)
+ [Quick Sort](#Quick Sort)

+ [Counting Sort](#Counting Sort)
+ [Bucket Sort](#Bucket Sort)


### Bubble Sort
+ Idea
    - Each loop get the highest element to the right side.

+ Analysis
    - Time `O(N^2)`

+ Application
    - no

+ Implementation
```
    public static void bubbleSort(int[] arr){
        if(arr == null || arr.length == 0) return;

        for(int i = arr.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
```

### Insertion Sort
+ Idea
    - Each loop, let curr left move to the position that will make left subarray the correct order.
    - So the left subarray are always in the correct order. Each element in the left subarray is not necessary in the final position.

+ Analysis
    - Time: `O(N^2)` in average case; `O(N^2)` in worst case(input reverse sorted)
    - Is insertion sort fast? Moderately so, for small N; Not at all, for large N.

+ Application
    - no

+ Implementation
```
public static void insertionSort(int[] arr) {
    int N = arr.length;
    for (int i = 1; i < N; i++) {
        int j = i - 1;
        int key = arr[i];
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}
```

### Selection Sort
+ Idea
    - Each loop, select the smallest element in right subarray, and swap with curr.
    - So the left subarray are always in the correct order. Each element in the left subarray is the final position.

+ Analysis
    - Time: `O(N^2)`

+ Application
    - no

+ Implementation
```
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min]) min = j;
            }
            if(min != i){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
    }
```

### Merge Sort
+ Idea
    - Using **Divide & Conquer** paradigm
    - Split and array to left subarray, and right subarray, sort each one recursively, and merge them.
    
+ Analysis
    - Time: `O(NlogN)`
    - Space: `O(NlogN)`

+ Application

##### 315. Count of Smaller Numbers After Self
https://leetcode.com/problems/count-of-smaller-numbers-after-self/

```
    // 1. Merge Sort
    /*
    https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/76584/Mergesort-solution
    */
    private class Pair {
        int val;
        int idx;
        
        public Pair (int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Pair[] tmp = new Pair[n];
        int[] res = new int[n];
        
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        
        mergeSort(pairs, 0, n - 1, tmp, res);
        // System.out.println(Arrays.toString(res));
        // System.out.println(Arrays.stream(pairs).map(p -> p.val).collect(Collectors.toList()).toString());
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
    
    private void mergeSort(Pair[] pairs, int lo, int hi, Pair[] tmp, int[] res) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(pairs, lo, mid, tmp, res);
        mergeSort(pairs, mid + 1, hi, tmp, res);
        merge(pairs, lo, mid, hi, tmp, res);
    }
    
    private void merge(Pair[] pairs, int lo, int mid, int hi, Pair[] tmp, int[] res) {
        if (lo >= hi) return;
        for (int k = lo; k <= hi; k++) {
            tmp[k] = pairs[k];
        }
        
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (j > hi || (i <= mid && tmp[i].val <= tmp[j].val)) {
                pairs[k] = tmp[i];
                // System.out.println("i: " + i + "  j: " + j + "  tmp[i].idx: " + tmp[i].idx + "  tmp[i].val: " + tmp[i].val + "  lo: " + lo + "  hi: " + hi);
                // mid + 1 is the init index of the right array. j - (mid + 1) is the length of the subarray of right array that each element smaller than current i.
                res[tmp[i].idx] += j - (mid + 1);
                i++;
            } else {
                pairs[k] = tmp[j];
                j++;
            }
        }
    }
```

+ Implementation
```
    public static void sort(int[] arr) {
        int[] tmp = new int[arr.length];
        sort(arr, tmp, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int[] tmp, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi - lo) / 2;
        sort(arr, tmp, lo, mid);                //sort left part
        sort(arr, tmp, mid + 1, hi);        //sort right part
        merge(arr, tmp, lo, mid, hi);           //merge left and right parts
    }
    
    public static void merge(int[] arr, int[] tmp, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            tmp[k] = arr[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if(j > hi || (i <= mid && tmp[i] < tmp[j])){
                arr[k] = tmp[i++];
            }else{
                arr[k] = tmp[j++];
            }
        }
    }
```

### External Sort - an extersion of Merge Sort
https://www.geeksforgeeks.org/external-sorting/

External sorting is a sorting algorithm used to handle massive amounts of data, which cannot fit all into memory. Usually we store the data in external storage device (e.g. a hard drive), and read chunks of data into memory, sort, and write out to a temporary file. In the merge phase, the sorted sub-files are combined into a single larger file.

One example of external sorting is the external merge sort algorithm, which sorts chunks that each fit in RAM, then merges the sorted chunks together.

The external sort has two prerequisite algorithm:
* Merge Sort
* [Merge K Sorted Arrays](https://www.geeksforgeeks.org/merge-k-sorted-arrays/)

+ Application
https://leetcode.com/problems/intersection-of-two-arrays-ii/
Follow-up 3: What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
Answer: Apply external sort to nums2, and then find intersection chunk by chunk.

### Heap Sort

+ Idea
    - Using divide and conquer paradigm

+ Analysis
    - Time: `O(NlogN)`
    - Space:

+ Application
    - no

+ Implementation
```
    private static void heapSort(int[] arr){
        int len = arr.length;
        buildMaxHeap(arr, len);
        for(int i = len - 1; i > 0; i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            maxHeapify(arr, 1, i);
        }
    }

    private static void buildMaxHeap(int[] arr, int heapSize){
        for(int i = heapSize / 2; i > 0; i--){
            maxHeapify(arr, i, heapSize);
        }
    }

    private static void maxHeapify(int[] arr, int index, int heapSize){
        int l = index * 2;
        int r = l + 1;
        int largest;

        if(l <= heapSize && arr[l - 1] > arr[index - 1]){
            largest = l;
        }else{
            largest = index;
        }

        if(r <= heapSize && arr[r - 1] > arr[largest - 1]){
            largest = r;
        }

        if(largest != index){
            int temp = arr[index - 1];
            arr[index - 1] = arr[largest - 1];
            arr[largest - 1] = temp;
            maxHeapify(arr, largest, heapSize);
        }
    }
```

### Quick Sort
+ Idea
    - Select an element as pivot, each look, put smaller elements to left subarray, put larger elements to right subarray, put pivot element at the final position.

+ Analysis
    - Time: average `O(NlogN)`, worst `O(N^2)`
    - Space: `O(1)`

+ Application
    - "Kth element" problem can use "Quick Sort" or "Quick Select" (an transformation of quick sort) or heap to solve.

+ Implementation
You can select any element as partition element. We select last element (easier to implement) or middle element as partition. See the code.

## Counting Sort
+ Idea
1. Counting the frequency of each element. Put counting in a [0, max_value] sorted frequency array.
2. Do incremental sum of the frequency array.
3. The final position of a value is [frequency - 1].

+ Implementation
    - No

+ Analysis
    - Time: `O(N + K)`, N is the number of elements, K is the range of elements.
    - Space: `O(max_value)`

+ Application
    - No

## Bucket Sort
+ Idea
    - Split elements into Buckets, and sort elements in Buckets using other sorting algorithms, finally merge the sorted buckets.

+ Implementation
    - No

+ Analysis
    - Time: `O(NlogN)`?
    - Space: 

+ Application
    - MapReduce (?)
    - "Top-K" series problem could either use **PriorityQueue** or **Bucket Sort** or **Quick Select** to solve.

Examples:

https://leetcode.com/problems/top-k-frequent-words/


### Cartesian Tree Sorting
https://www.geeksforgeeks.org/cartesian-tree/
https://www.geeksforgeeks.org/cartesian-tree-sorting/

Cartesian Sort is an adaptive sorting as it sorts the data faster if data is partially sorted.

Details of Cartesian Tree, please check [cartesian-tree.md](../Tree/cartesian-tree.md).

## Reference
[Know Your Sorting Algorithm | Set 1 (Sorting Weapons used by Programming Languages)](https://www.geeksforgeeks.org/know-sorting-algorithm-set-1-sorting-weapons-used-programming-languages/)  
[Know Your Sorting Algorithm | Set 2 (Introsort- C++’s Sorting Weapon)](https://www.geeksforgeeks.org/know-your-sorting-algorithm-set-2-introsort-cs-sorting-weapon/)  
[Sorting in Java](https://www.geeksforgeeks.org/sorting-in-java/)  

