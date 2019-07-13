


### Bubble Sort

Each loop get the highest element to the right side.

+ Analysis
    - Time `O(N^2)`


### Insertion Sort
Each loop, let curr left move to the final position.
https://www.geeksforgeeks.org/insertion-sort/

+ Analysis
    - Time: `O(N^2)` in average case; `O(N^2)` in worst case(input reverse sorted)
    - Is insertion sort fast? Moderately so, for small N; Not at all, for large N.

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

Each loop, select the smallest ele in right subarray, and swap with curr.
+ Analysis
    - Time: avg `O(N^2)`


### Heap Sort
Using divide and conquer paradigm

+ Analysis
    - Time: `O(NlogN)`
    - Space: 




### Bucket Sort

Top-K series problem could either use PriorityQueue or bucket sort to solve.

Examples:

https://leetcode.com/problems/top-k-frequent-words/

### Quick Sort
https://www.geeksforgeeks.org/quick-sort/  
https://www.geeksforgeeks.org/java-program-for-quicksort/  

- Time: `O(NlogN)`, worst `O(N^2)`
- Space: `O(1)`
    
```
/*
Created by chen on 15/4/2.
QuickSort (Divide & Conquer)
Time average O(NlogN)
     worst O(N^2)

https://www.programcreek.com/2012/11/quicksort-array-in-java/
Analysis of partion using the last element:
Steps:
4   5   2   1   3
s,i             p       arr[i]>arr[p], i++
s   i           p       arr[i]>arr[p], i++
s       i       p       swap[s,i], start++, i++

2   5   4   1   3
    s       i   p       swap[s,i], start++, i++
2   1   4   5   3
        s       i,p     end as arr[i] == pivot

Final Step:
2   1   3   5   4       swap[s,p]

Analysis of partion using the middle element:
Steps:
4   5   2   1   3
i       p       j       arr[j] > arr[p], j--
i       p   j           swap[i,j], i++, j--

1   5   2   4   3
    i   p,j             arr[i] >= pivot, arr[j]<= pivot, swap[i,j], i++, j--
1   2   5   4   3
    p,j i


*/
class QuickSort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    // Partition with middle element
    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = arr[lo + (hi - lo) / 2];

        int i = lo;
        int j = hi;

        while (i <= j) {
            while (arr[i] < pivot) i++;
            while (arr[j] > pivot) j--;

            if (i <= j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        quickSort(arr, lo, j);
        quickSort(arr, i, hi);
    }

    // Partition with last element
    // https://www.programcreek.com/2012/11/quicksort-array-in-java/

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int val = partition(arr, lo, hi);
        quickSort(arr, lo, val - 1);
        quickSort(arr, val + 1, hi);
    }

    public static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        for (int i = lo; i < hi; i++) {
            if (arr[i] < pivot) {
                int temp = arr[lo];
                arr[lo] = arr[i];
                arr[i] = temp;

                lo++;
            }
        }

        int temp = arr[lo];
        arr[lo] = arr[hi];
        arr[hi] = temp;

        return lo;
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 6, 4, 2, 3, 9, 5, 3, 2, 0};
        quickSort(arr);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
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

