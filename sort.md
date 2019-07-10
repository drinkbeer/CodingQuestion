

#### Bucket Sort

Top-K series problem could either use PriorityQueue or bucket sort to solve.

Examples:

https://leetcode.com/problems/top-k-frequent-words/

#### Quick Sort
https://www.geeksforgeeks.org/quick-sort/

#### Merge Sort
https://www.geeksforgeeks.org/merge-sort/




#### External Sort - an extersion of Merge Sort
https://www.geeksforgeeks.org/external-sorting/

External sorting is a sorting algorithm used to handle massive amounts of data, which cannot fit all into memory. Usually we store the data in external storage device (e.g. a hard drive), and read chunks of data into memory, sort, and write out to a temporary file. In the merge phase, the sorted sub-files are combined into a single larger file.

One example of external sorting is the external merge sort algorithm, which sorts chunks that each fit in RAM, then merges the sorted chunks together.

The external sort has two prerequisite algorithm:
* Merge Sort
* [Merge K Sorted Arrays](https://www.geeksforgeeks.org/merge-k-sorted-arrays/)

#### Cartesian Tree Sorting
https://www.geeksforgeeks.org/cartesian-tree/
https://www.geeksforgeeks.org/cartesian-tree-sorting/

Cartesian Sort is an adaptive sorting as it sorts the data faster if data is partially sorted.


## Reference
[Know Your Sorting Algorithm | Set 1 (Sorting Weapons used by Programming Languages)](https://www.geeksforgeeks.org/know-sorting-algorithm-set-1-sorting-weapons-used-programming-languages/)  
[Know Your Sorting Algorithm | Set 2 (Introsort- C++’s Sorting Weapon)](https://www.geeksforgeeks.org/know-your-sorting-algorithm-set-2-introsort-cs-sorting-weapon/)  
