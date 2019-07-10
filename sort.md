


### Bubble Sort
+ Idea
    - Each loop get the highest element to the right side.

+ Implementation

+ Analysis
    - Time `O(N^2)`

+ Application


### Insertion Sort
+ Idea
    - Each loop, let curr left move to the final position.

+ Implementation

+ Analysis
    - Time: `O(N^2)` in average case; `O(N^2)` in worst case(input reverse sorted)
    - Is insertion sort fast? Moderately so, for small N; Not at all, for large N.

+ Application
    

### Selection Sort
+ Idea
    - Each loop, select the smallest ele in right subarray, and swap with curr.

+ Implementation

+ Analysis
    - Time: `O(N^2)`

+ Application
    



### Quick Sort
+ Idea
    - 

+ Implementation
    - 

+ Analysis
    - Time: `O(NlogN)`
    - Space: 

+ Application


### Heap Sort
+ Idea
    - Using divide and conquer paradigm

+ Implementation
    - 

+ Analysis
    - Time: `O(NlogN)`
    - Space: 

+ Application



### Bucket Sort

Top-K series problem could either use PriorityQueue or bucket sort to solve.

Examples:

https://leetcode.com/problems/top-k-frequent-words/

### Quick Sort
https://www.geeksforgeeks.org/quick-sort/  
https://www.geeksforgeeks.org/java-program-for-quicksort/  

```

```

### Merge Sort (Divide & Conquer)
https://www.geeksforgeeks.org/merge-sort/  
https://www.geeksforgeeks.org/java-program-for-merge-sort/

- Time: `O(NlogN)`
- Space: `O(NlogN)`

```
/*
Created by chen on 15/4/1.
Time O(NlogN)
 */
class MergeSort {
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

    public static void main(String[] args) {
        int[] arr = {6, 3, 6, 4, 2, 3, 9, 5, 3, 2, 0};
        sort(arr);
        for(int ele : arr){
            System.out.print(ele + " ");
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

### Cartesian Tree Sorting
https://www.geeksforgeeks.org/cartesian-tree/
https://www.geeksforgeeks.org/cartesian-tree-sorting/

Cartesian Sort is an adaptive sorting as it sorts the data faster if data is partially sorted.


## Reference
[Know Your Sorting Algorithm | Set 1 (Sorting Weapons used by Programming Languages)](https://www.geeksforgeeks.org/know-sorting-algorithm-set-1-sorting-weapons-used-programming-languages/)  
[Know Your Sorting Algorithm | Set 2 (Introsort- C++’s Sorting Weapon)](https://www.geeksforgeeks.org/know-your-sorting-algorithm-set-2-introsort-cs-sorting-weapon/)  
[Sorting in Java](https://www.geeksforgeeks.org/sorting-in-java/)  

