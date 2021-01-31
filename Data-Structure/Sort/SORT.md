# Sorting Algorithms

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

+ Implementation

+ Analysis
    - Time `O(N^2)`

+ Application


### Insertion Sort
+ Idea
    - Each loop, let curr left move to the position that will make left subarray the correct order.
    - So the left subarray are always in the correct order. Each element in the left subarray is not necessary in the final position.

+ Implementation

+ Analysis
    - Time: `O(N^2)` in average case; `O(N^2)` in worst case(input reverse sorted)
    - Is insertion sort fast? Moderately so, for small N; Not at all, for large N.

+ Application
    

### Selection Sort
+ Idea
    - Each loop, select the smallest element in right subarray, and swap with curr.
    - So the left subarray are always in the correct order. Each element in the left subarray is the final position.

+ Implementation

+ Analysis
    - Time: `O(N^2)`

+ Application
    

### Merge Sort
* Idea
    - Using divide and conquer paradigm
    
* Implementation

+ Analysis
    - Time: `O(NlogN)`
    - Space: `O(NlogN)`

+ Application


### Heap Sort

+ Idea
    - Using divide and conquer paradigm

* Implementation


+ Analysis
    - Time: `O(NlogN)`
    - Space:

+ Application


### Quick Sort
* Idea

* Implementation


+ Analysis
    - Time: `O(NlogN)`
    - Space: 

+ Application


## Counting Sort
* Idea

* Implementation


+ Analysis
    - Time: `O(N + K)`, N is the number of elements, K is the range of elements.
    - Space: `O(max_value)`

+ Application


## Bucket Sort
* Idea

* Implementation

* Analysis
    - Time: `O(NlogN)`
    - Space:

* Application


