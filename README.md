# Interview Preparation
Sharing some common interview preparation materials through this reporsity.

## Preparation Areas
1. Data Structure
2. Algorithm
3. Java Concepts, APIs, best practice, JVM mechanism & turning
4. System Design && Object-Oriented Design
5. Behavior Question & Project/Technical Knowledge Dive Deep

## Data Structure & Algorithm Preparation Strategy

Strategies:
1. Easy + Medium first, then hard.
2. In preparation stage, categories based strategy; in final stage (one or two weeks before interviewing), company tag (or Interview Sharing) based.
3. Think 10 - 20 minutes, if no clues, read the discussions. No more than 30 minutes for each problem.
4. Write all solutions.
5. Summarize similar problems.

Categories (Data Structure & Algorithms):
1. Array & Matrix (2d array or higher dimension array)
2. String
3. LinkedList
4. Tree
5. Backtracking
6. DFS & BFS
7. Binary Search
8. Dynamic Programming
9. Graph
10. Topological Sort
11. Stack & PriorityQueue
12. Trie
13. Union Find

Others (Algorithms & Design):
1. Bit Manipulation
2. Math
3. Random
4. Design

Plans: 
1. Array (two pointers, sort, binary search, sliding window), String, List, Tree (basic tree, BST, DFS, BFS, not include the advanced tree, e.g. BIT, Segment Tree), understand recursive and iterative.
2. Basic Search (Binary Search) + Memorized Search + basic Dynamic Programming
3. Advanced DP (knacpack, minimax)
4. Frequently used Data Structure: Stack, Queue, PriorityQueue, Deque; List, Map, HashTable; Heap, Trie.
5. Advanced Tree (Binary Index Tree, Segment Tree, B/B+, AVL Tree, Red-black Tree)
6. Hot topics: Union Find, Graph, Greedy, Bit Manipulation，Topological Sort.


### Array
Array includes N-Sum series, operation to array(rotate or pivot). DFS or BFS search a subset of array, e.g combination.  
Binary Search is also a hot topic for sorted array. When see the coding problem requires O(logN) time complexity to search something in a sorted array, then it's probably using Binary Search.  
Give an array, always ask interview: if the array is sorted? Could we sort the array if necessary? If the array is empty or null? If that could be huge array that will be out of memory?

Note:
1. If a topic is about DP or Greedy, it's put to DP section, e.g. [45. Jump Game II](https://leetcode.com/problems/jump-game-ii/).

[K-Sum problem summary](http://blog.csdn.net/suwei19870312/article/details/12857103)


|Question|Solution|Tags|
|--------|--------|----|
|[★1.Two Sum](https://leetcode.com/problems/two-sum/)|[LeetCode-1-Two-Sum.java](src/LeetCode-1-Two-Sum.java)|Array, HashMap|
|[4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)|[LeetCode-4-Median-of-Two-Sorted-Arrays.java](src/LeetCode-4-Median-of-Two-Sorted-Arrays.java)|Array|
|[11 Container With Most Water](https://leetcode.com/problems/container-with-most-water/)|[LeetCode-11-Container-With-Most-Water.java](src/LeetCode-11-Container-With-Most-Water.java)|Array, Two Pointers|
|[★15.3Sum](https://leetcode.com/problems/3sum/)|[LeetCode-15-3Sum.java](src/LeetCode-15-3Sum.java)|Array, Three Pointers|
|[16 3Sum Closest](https://leetcode.com/problems/3sum-closest/)|[LeetCode-16-3Sum-Closest.java](src/LeetCode-16-3Sum-Closest.java)|Array, Three Pointers|
|[18.4Sum](https://leetcode.com/problems/4sum/)|[LeetCode-18-4Sum.java](src/LeetCode-18-4Sum.java)|Four Pointers|
|[26.Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)|[LeetCode-26-Remove-Duplicates-from-Sorted-Array.java](src/LeetCode-26-Remove-Duplicates-from-Sorted-Array.java)|One Pointers, LC80|
|[27.Remove Element](https://leetcode.com/problems/remove-element/)|[LeetCode-27-Remove-Element.java](src/LeetCode-27-Remove-Element.java)|One or Two Pointers|
|[31.Next Permutation](https://leetcode.com/problems/next-permutation/)|[LeetCode-31-Next-Permutation.java](src/LeetCode-31-Next-Permutation.java)|Array, Hard to Understand|
|[33.Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)|[LeetCode-33-Search-in-Rotated-Sorted-Array.java](src/LeetCode-33-Search-in-Rotated-Sorted-Array.java)|Binary Search, LC81|
|[34.Search for a Range](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)|[LeetCode-34-Search-for-a-Range.java](src/LeetCode-34-Search-for-a-Range.java)|Binary Search|
|[35 Search Insert Position](https://leetcode.com/problems/search-insert-position/)|[LeetCode-35-Search-Insert-Position.java](src/LeetCode-35-Search-Insert-Position.java)|Binary Search|
|[36. Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)|[LeetCode-36-Valid-Sudoku.java](src/LeetCode-36-Valid-Sudoku.java)|Array|
|[37. Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)|[LeetCode-37-Sudoku-Solver.java](src/LeetCode-37-Sudoku-Solver.java)|Array, DFS|
|[39.Combination Sum I](https://leetcode.com/problems/combination-sum/)|[LeetCode-39-Combination-Sum-I.java](src/LeetCode-39-Combination-Sum-I.java)|DFS|
|[40.Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)|[LeetCode-40-Combination-Sum-II.java](src/LeetCode-40-Combination-Sum-II.java)|DFS|
|[41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/)|[LeetCode-41-First-Missing-Positive.java](src/LeetCode-41-First-Missing-Positive.java)|Array, rearrange the array|
|[42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)|[LeetCode-42-Trapping-Rain-Water.java](src/LeetCode-42-Trapping-Rain-Water.java)|Two Pointers, Two Way Scanning|
|[46.Permutations](https://leetcode.com/problems/permutations/)|[LeetCode-46-Permutations.java](src/LeetCode-46-Permutations.java)|DFS, BFS|
|[47.Permutations II](https://leetcode.com/problems/permutations-ii/)|[LeetCode-47-Permutations-II.java](src/LeetCode-47-Permutations-II.java)|DFS, BFS|
|[48 Rotate Image](https://leetcode.com/problems/rotate-image/)|[LeetCode-48-Rotate-Image.java](src/LeetCode-48-Rotate-Image.java)|Array|
|[51. N-Queens](https://leetcode.com/problems/n-queens/)|[LeetCode-51-N-Queens.java](src/LeetCode-51-N-Queens.java)|Array|
|[54 Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)|[LeetCode-54-Spiral-Matrix.java](src/LeetCode-54-Spiral-Matrix.java)|Array|
|[59 Spiral Matrix II](https://leetcode.com/problems/spiral-matrix-ii/)|[LeetCode-59-Spiral-Matrix-II.java](src/LeetCode-59-Spiral-Matrix-II.java)|Array|
|[56.Merge Intervals](https://leetcode.com/problems/merge-intervals/)|[LeetCode-56-Merge-Intervals.java](src/LeetCode-56-Merge-Intervals.java)|Array|
|[57.Insert Interval](https://leetcode.com/problems/insert-interval/)|[LeetCode-57-Insert-Interval.java](src/LeetCode-57-Insert-Interval.java)|Array|
|[73.Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)|[LeetCode-73-Set-Matrix-Zeroes.java](src/LeetCode-73-Set-Matrix-Zeroes.java)|Array|
|[74.Search a 2D Matrix](https://leetcode.com/problems/set-matrix-zeroes/)|[LeetCode-74-Search-a-2D-Matrix.java](src/LeetCode-74-Search-a-2D-Matrix.java)|Array, Binary Search|
|[75 Sort Colors](https://leetcode.com/problems/sort-colors/)|[LeetCode-75-Sort-Colors.java](src/LeetCode-75-Sort-Colors.java)|Array, Two Pointers|
|[79.Word Search](https://leetcode.com/problems/word-search/)|[LeetCode-79-Word-Search.java](src/LeetCode-79-Word-Search.java)|Array, DFS|
|[80.Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)|[LeetCode-80-Remove-Duplicates-from-Sorted-Array-II.java](src/LeetCode-80-Remove-Duplicates-from-Sorted-Array-II.java)|Array, One Pointer, LC26|
|[81.Search in Rotated Sorted Array II](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/)|[LeetCode-81-Search-in-Rotated-Sorted-Array-II.java](src/LeetCode-81-Search-in-Rotated-Sorted-Array-II.java)|Array, Binary Search, LC33|
|[84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)|[LeetCode-84-Largest-Rectangle-in-Histogram.java](src/LeetCode-84-Largest-Rectangle-in-Histogram.java)|Array, Stack, Two Way Scan|
|[88.Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)|[LeetCode-88-Merge-Sorted-Array.java](src/LeetCode-88-Merge-Sorted-Array.java)|Array, Two Pointers|
|[118.Pascal's Triangle](https://leetcode.com/problems/pascals-triangle/)|[LeetCode-118-Pascals-Triangle.java](src/LeetCode-118-Pascals-Triangle.java)|Array|
|[119.Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/)|[LeetCode-119-Pascals-Triangle-II.java](src/LeetCode-119-Pascals-Triangle-II.java)|Array|
|[153. Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)|[LeetCode-153-Find-Minimum-in-Rotated-Sorted-Array.java](src/LeetCode-153-Find-Minimum-in-Rotated-Sorted-Array.java)|Array|
|[154. Find Minimum in Rotated Sorted Array II](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/)|[LeetCode-154-Find-Minimum-in-Rotated-Sorted-Array-II.java](src/LeetCode-154-Find-Minimum-in-Rotated-Sorted-Array-II.java)|Array|
|[162. Find Peak Element](https://leetcode.com/problems/find-peak-element/)|[LeetCode-162-Find-Peak-Element.java](src/LeetCode-162-Find-Peak-Element.java)|Array, Binary Search|
|[163. Missing Ranges](https://leetcode.com/problems/missing-ranges/)|[LeetCode-163-Missing-Ranges.java](src/LeetCode-163-Missing-Ranges.java)|Array|
|[167.Two Sum II - Input array is sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)|[LeetCode-167-Two-Sum-II-Input-array-is-sorted.java](src/LeetCode-167-Two-Sum-II-Input-array-is-sorted.java)|Two Pointers|
|[170.Two Sum III - Data structure design](https://leetcode.com/problems/two-sum-iii-data-structure-design/)|[LeetCode-170-Two-Sum-III-Data-structure-design.java](src/LeetCode-170-Two-Sum-III-Data-structure-design.java/)|HashMap|
|[259.3Sum Smaller](https://leetcode.com/problems/3sum-smaller/)|[LeetCode-259-3Sum-Smaller.java](src/LeetCode-259-3Sum-Smaller.java)|Two Pointers|
|[169. Majority Element](https://leetcode.com/problems/majority-element/)|[LeetCode-169-Majority-Element.java](src/LeetCode-169-Majority-Element.java)|Array, Bit Manipulation|
|[189.Rotate Array](https://leetcode.com/problems/rotate-array/)|[LeetCode-189-Rotate-Array.java](src/LeetCode-189-Rotate-Array.java)|Array|
|[200.Number of Islands](https://leetcode.com/problems/number-of-islands/)|[LeetCode-200-Number-of-Islands.java](src/LeetCode-200-Number-of-Islands.java)|DFS|
|[209.Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)|[LeetCode-209-Minimum-Size-Subarray-Sum.java](src/LeetCode-209-Minimum-Size-Subarray-Sum.java)|Array, Two Pointers, Binary Search|
|[212.Word Search II](https://leetcode.com/problems/word-search-ii/)|[LeetCode-212-Word-Search-II.java](src/LeetCode-212-Word-Search-II.java)|Not yet, hard|
|[229. Majority Element II](https://leetcode.com/problems/majority-element-ii/)|[LeetCode-229-Majority-Element-II.java](src/LeetCode-229-Majority-Element-II.java)|Array, Moore Voting|
|[238.Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)|[LeetCode-238-Product-of-Array-Except-Self.java](src/LeetCode-238-Product-of-Array-Except-Self.java)|Array|
|[240.Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/)|[LeetCode-240-Search-a-2D-Matrix-II.java](src/LeetCode-240-Search-a-2D-Matrix-II.java)|Array|
|[243. Shortest Word Distance](https://leetcode.com/problems/shortest-word-distance/)|[LeetCode-243-Shortest-Word-Distance.java](src/LeetCode-243-Shortest-Word-Distance.java)|Array|
|[244. Shortest Word Distance II](https://leetcode.com/problems/shortest-word-distance-ii/)|[LeetCode-244-Shortest-Word-Distance-II.java](src/LeetCode-244-Shortest-Word-Distance-II.java)|Array, Design|
|[245. Shortest Word Distance III](https://leetcode.com/problems/shortest-word-distance-iii/)|[LeetCode-245-Shortest-Word-Distance-III.java](src/LeetCode-245-Shortest-Word-Distance-III.java)|Array|
|[252.Meeting Rooms](https://leetcode.com/problems/meeting-rooms/)|[LeetCode-252-Meeting-Rooms.java](src/LeetCode-252-Meeting-Rooms.java)|Array, LC 56|
|[253.Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)|[LeetCode-253-Meeting-Rooms-II.java](src/LeetCode-253-Meeting-Rooms-II.java)|Array, Heap, LC 56|
|[268.Missing Number](https://leetcode.com/problems/missing-number/)|[LeetCode-268-Missing-Number.java](src/LeetCode-268-Missing-Number.java)|Array|  
|[277. Find the Celebrity](https://leetcode.com/problems/find-the-celebrity/)|[LeetCode-277-Find-the-Celebrity.java](src/LeetCode-277-Find-the-Celebrity.java)|Array|
|[283.Move Zeroes](https://leetcode.com/problems/move-zeroes/)|[LeetCode-283-Move-Zeroes.java](src/LeetCode-283-Move-Zeroes.java)|Array|
|[287.Find the Duplicate Number](https://leetcode.com/problems/find-the-duplicate-number/)|[LeetCode-287-Find-the-Duplicate-Number.java](src/LeetCode-287-Find-the-Duplicate-Number.java)|Array|  
|[289. Game of Life](https://leetcode.com/problems/game-of-life/)|[LeetCode-289-Game-of-Life.java](src/LeetCode-289-Game-of-Life.java)|Array|  
|[296. Best Meeting Point](https://leetcode.com/problems/best-meeting-point/)|[LeetCode-296-Best-Meeting-Point.java](src/LeetCode-296-Best-Meeting-Point.java)|Array|
|[★315. Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)|[LeetCode-315-Count-of-Smaller-Numbers-After-Self.java](src/LeetCode-315-Count-of-Smaller-Numbers-After-Self.java)|Array, MergeSort, BST, BIT|
|[329. Longest Increasing Path in a Matrix](https://leetcode.com/problems/longest-increasing-path-in-a-matrix/)|[LeetCode-329-Longest-Increasing-Path-in-a-Matrix.java](src/LeetCode-329-Longest-Increasing-Path-in-a-Matrix.java)|Array, DFS|
|[339. Nested List Weight Sum](https://leetcode.com/problems/nested-list-weight-sum/)|[LeetCode-339-Nested-List-Weight-Sum.java](src/LeetCode-339-Nested-List-Weight-Sum.java)|Recursive|
|[341. Flatten Nested List Iterator](https://leetcode.com/problems/flatten-nested-list-iterator/)|[LeetCode-341-Flatten-Nested-List-Iterator.java](src/LeetCode-341-Flatten-Nested-List-Iterator.java)|Array|
|[349. Intersection of Two Arrays](https://leetcode.com/problems/intersection-of-two-arrays/)|[LeetCode-349-Intersection-of-Two-Arrays.java](src/LeetCode-349-Intersection-of-Two-Arrays.java)|Array|
|[350. Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/)|[LeetCode-350-Intersection-of-Two-Arrays-II.java](src/LeetCode-350-Intersection-of-Two-Arrays-II.java)|Array|
|[352. Data Stream as Disjoint Intervals](https://leetcode.com/problems/data-stream-as-disjoint-intervals/)|[LeetCode-352-Data-Stream-as-Disjoint-Intervals.java](src/LeetCode-352-Data-Stream-as-Disjoint-Intervals.java)|Array, TreeMap|
|[364. Nested List Weight Sum II](https://leetcode.com/problems/nested-list-weight-sum-ii/)|[LeetCode-364-Nested-List-Weight-Sum-II.java](src/LeetCode-364-Nested-List-Weight-Sum-II.java)|Recursive, Iterative|
|[378. Kth Smallest Element in a Sorted Matrix](https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/)|[LeetCode-378-Kth-Smallest-Element-in-a-Sorted-Matrix.java](src/LeetCode-378-Kth-Smallest-Element-in-a-Sorted-Matrix.java)|Heap, Binary Search|
|[384. Shuffle an Array](https://leetcode.com/problems/shuffle-an-array/)|[LeetCode-384-Shuffle-an-Array.java](src/LeetCode-384-Shuffle-an-Array.java)|Array|
|[412. Fizz Buzz](https://leetcode.com/problems/fizz-buzz/)|[LeetCode-412-Fizz-Buzz.java](src/LeetCode-412-Fizz-Buzz.java)|Iterative|
|[419. Battleships in a Board](https://leetcode.com/problems/battleships-in-a-board/)|[LeetCode-419-Battleships-in-a-Board.java](src/LeetCode-419-Battleships-in-a-Board.java)|Iterative|
|[435. Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)|[LeetCode-435-Non-overlapping-Intervals.java](src/LeetCode-435-Non-overlapping-Intervals.java)|Iterative|
|[463. Island Perimeter](https://leetcode.com/problems/island-perimeter/)|[LeetCode-463-Island-Perimeter.java](src/LeetCode-463-Island-Perimeter.java)|Recursive|
|[448. Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)|[LeetCode-448-Find-All-Numbers-Disappeared-in-an-Array.java](src/LeetCode-448-Find-All-Numbers-Disappeared-in-an-Array.java)|Arraay|
|[★493. Reverse Pairs](https://leetcode.com/problems/reverse-pairs/)|[LeetCode-493-Reverse-Pairs.java](src/LeetCode-493-Reverse-Pairs.java)|Array, MergeSort, BST, BIT|
|[540. Single Element in a Sorted Array](https://leetcode.com/problems/single-element-in-a-sorted-array/)|[LeetCode-540-Single-Element-in-a-Sorted-Array.java](src/LeetCode-540-Single-Element-in-a-Sorted-Array.java)|Binary Search|
|[560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/)|[LeetCode-560-Subarray-Sum-Equals-K.java](src/LeetCode-560-Subarray-Sum-Equals-K.java)|Culmulative Sum|
|[661. Image Smoother](https://leetcode.com/problems/image-smoother/)|[LeetCode-661-Image-Smoother.java](src/LeetCode-661-Image-Smoother.java)|Array|
|[674. Longest Continuous Increasing Subsequence](https://leetcode.com/problems/longest-continuous-increasing-subsequence/)|[LeetCode-674-Longest-Continuous-Increasing-Subsequence.java](src/LeetCode-674-Longest-Continuous-Increasing-Subsequence.java)|Array|
|[670. Maximum Swap](https://leetcode.com/problems/maximum-swap/)|[LeetCode-670-Maximum-Swap.java](src/LeetCode-670-Maximum-Swap.java)|Array|
|[694. Number of Distinct Islands](https://leetcode.com/problems/number-of-distinct-islands/)|[LeetCode-694-Number-of-Distinct-Islands.java](src/LeetCode-694-Number-of-Distinct-Islands.java)|Recursive|
|[698. Partition to K Equal Sum Subsets](https://leetcode.com/problems/partition-to-k-equal-sum-subsets/)|[LeetCode-698-Partition-to-K-Equal-Sum-Subsets.java](src/LeetCode-698-Partition-to-K-Equal-Sum-Subsets.java)|Recursive|
|[719. Find K-th Smallest Pair Distance](https://leetcode.com/problems/find-k-th-smallest-pair-distance/)|[LeetCode-719-Find-K-th-Smallest-Pair-Distance.java](src/LeetCode-719-Find-K-th-Smallest-Pair-Distance.java)|Array, Binary Search|
|[724. Find Pivot Index](https://leetcode.com/problems/find-pivot-index/)|[LeetCode-724-Find-Pivot-Index.java](src/LeetCode-724-Find-Pivot-Index.java)|Array|
|[744. Find Smallest Letter Greater Than Target](https://leetcode.com/problems/find-smallest-letter-greater-than-target/)|[LeetCode-744-Find-Smallest-Letter-Greater-Than-Target.java](src/LeetCode-744-Find-Smallest-Letter-Greater-Than-Target.java)|Array, Binary Search|
|[911. Online Election](https://leetcode.com/problems/online-election/)|[LeetCode-911-Online-Election.java](src/LeetCode-911-Online-Election.java)|Array, Binary Search, TreeMap|
|[912. Sort an Array](https://leetcode.com/problems/sort-an-array/)|[LeetCode-912-Sort-an-Array.java](src/LeetCode-912-Sort-an-Array.java)|Array, Sort|
|[915. Partition Array into Disjoint Intervals](https://leetcode.com/problems/partition-array-into-disjoint-intervals/)|[LeetCode-915-Partition-Array-into-Disjoint-Intervals.java](src/LeetCode-915-Partition-Array-into-Disjoint-Intervals.java)|Array|
|[977. Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)|[LeetCode-977-Squares-of-a-Sorted-Array.java](src/LeetCode-977-Squares-of-a-Sorted-Array.java)|Two Pointers|


|[★78.Subsets](https://leetcode.com/problems/subsets/)|[LeetCode-78-Subsets.java](src/LeetCode-78-Subsets.java)|DFS|
|[90.Subsets II](https://leetcode.com/problems/subsets-ii/)|[LeetCode-90-Subsets-II.java](src/LeetCode-90-Subsets-II.java)|DFS|



### String 
String includes Parentheness series, Palindrome series, Anagram series, some statistic problems.  

[回文串问题总结](http://blog.csdn.net/fangjian1204/article/details/38084165)  
[LeetCode总结 —— Palindrome 回文总结](http://mm.fancymore.com/reading/%E5%9B%9E%E6%96%87%E9%97%AE%E9%A2%98.html)  
[最长回文字符串、二重循环](http://aniylj.leanote.com/post/f4405becd46c)  
[「LeetCode」试题总结 - 回文数汇总](http://nillhex.com/2015/06/12/leetcode-palindrome-summary/)  

|Question|Solution|Tags|
|--------|--------|----|
|[3 Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)|[LeetCode-3-Longest-Substring-Without-Repeating-Characters.java](src/LeetCode-3-Longest-Substring-Without-Repeating-Characters.java)|Two Pointers|
|[5.Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)|[LeetCode-5-Longest-Palindromic-Substring.java](src/LeetCode-5-Longest-Palindromic-Substring.java)|String|
|[6 ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)|[LeetCode-6-ZigZag-Conversion.java](src/LeetCode-6-ZigZag-Conversion.java)|String|
|[8.String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/)|[LeetCode-8-String-to-Integer.java](src/LeetCode-8-String-to-Integer.java)|String|
|[10. Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/)|[LeetCode-10-Regular-Expression-Matching.java](src/LeetCode-10-Regular-Expression-Matching.java)|String|
|[12.Integer to Roman](https://leetcode.com/problems/integer-to-roman/)|[LeetCode-12-Integer-to-Roman.java](src/LeetCode-12-Integer-to-Roman.java)|String|
|[13.Roman to Integer](https://leetcode.com/problems/roman-to-integer/)|[LeetCode-13-Roman-to-Integer.java](src/LeetCode-13-Roman-to-Integer.java)|String|
|[14 Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)|[LeetCode-14-Longest-Common-Prefix.java](src/LeetCode-14-Longest-Common-Prefix.java)|String|
|[17.Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)|[LeetCode-17-Letter-Combinations-of-a-Phone-Number.java](src/LeetCode-17-Letter-Combinations-of-a-Phone-Number.java)|DFS, BFS|
|[★20.Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)|[LeetCode-20-Valid-Parentheses.java](src/LeetCode-20-Valid-Parentheses.java)|HashMap, Stack|
|[★22.Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)|[LeetCode-22-Generate-Parentheses.java](src/LeetCode-22-Generate-Parentheses.java)|DFS, BFS|
|[28.Implement strStr()](https://leetcode.com/problems/implement-strstr/)|[LeetCode-28-Implement-strStr.java](src/LeetCode-28-Implement-strStr.java)|String, Two Pointers|
|[38 Count and Say](https://leetcode.com/problems/count-and-say/)|[LeetCode-38-Count-and-Say.java](src/LeetCode-38-Count-and-Say.java)|String|
|[44. Wildcard Matching](https://leetcode.com/problems/wildcard-matching/)|[LeetCode-44-Wildcard-Matching.java](src/LeetCode-44-Wildcard-Matching.java)|String|
|[49.Group Anagrams](https://leetcode.com/problems/anagrams/)|[LeetCode-49-Group-Anagrams.java](src/LeetCode-49-Group-Anagrams.java)|String, HashMap|
|[58.Length of Last Word](https://leetcode.com/problems/length-of-last-word/)|[LeetCode-58-Length-of-Last-Word.java](src/LeetCode-58-Length-of-Last-Word.java)|String|
|[65. Valid Number](https://leetcode.com/problems/valid-number/)|[LeetCode-65-Valid-Number.java](src/LeetCode-65-Valid-Number.java)|String|
|[★68. Text Justification](https://leetcode.com/problems/text-justification/)|[LeetCode-68-Text-Justification.java](src/LeetCode-68-Text-Justification.java)|String|
|[71.Simplify Path](https://leetcode.com/problems/simplify-path/)|[LeetCode-71-Simplify-Path.java](src/LeetCode-71-Simplify-Path.java)|String|
|[★76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)|[LeetCode-76-Minimum-Window-Substring.java](src/LeetCode-76-Minimum-Window-Substring.java)|String|
|[93.Restore IP Addresses](https://leetcode.com/problems/restore-ip-addresses/)|[LeetCode-93-Restore-IP-Addresses.java](src/LeetCode-93-Restore-IP-Addresses.java)|String, DFS|
|[★125.Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)|[LeetCode-125-Valid-Palindrome.java](src/LeetCode-125-Valid-Palindrome.java)|Two Pointers|
|[★126.Word Ladder II](https://leetcode.com/problems/word-ladder-ii/)|[LeetCode-126-Word-Ladder-II.java](src/LeetCode-126-Word-Ladder-II.java)|DFS+BFS|
|[★127.Word Ladder](https://leetcode.com/problems/word-ladder/)|[LeetCode-127-Word-Ladder.java](src/LeetCode-127-Word-Ladder.java)|BFS|
|[139.Word Break](https://leetcode.com/problems/word-break/)|[LeetCode-139-Word-Break.java](src/LeetCode-139-Word-Break.java)|DFS, DP|
|[140.Word Break II](https://leetcode.com/problems/word-break-ii/)|[LeetCode-140-Word-Break-II.java](src/LeetCode-140-Word-Break-II.java)|DP, Trie, Recursive|
|[151.Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)|[LeetCode-151-Reverse-Words-in-a-String.java](src/LeetCode-151-Reverse-Words-in-a-String.java)|String|
|[★157.Read N Characters Given Read4](https://leetcode.com/problems/read-n-characters-given-read4/)|[LeetCode-157-Read-N-Characters-Given-Read4.java](src/LeetCode-157-Read-N-Characters-Given-Read4.java)|String|
|[★158.Read N Characters Given Read4 II - Call multiple times](https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times/)|[LeetCode-158-Read-N-Characters-Given-Read4II-Call-multiple-times.java](src/LeetCode-158-Read-N-Characters-Given-Read4II-Call-multiple-times.java)|String|
|[159. Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/)|[LeetCode-159-Longest-Substring-with-At-Most-Two-Distinct-Characters.java](src/LeetCode-159-Longest-Substring-with-At-Most-Two-Distinct-Characters.java)|String, SubString|
|[161. One Edit Distance](https://leetcode.com/problems/one-edit-distance/)|[LeetCode-161-One-Edit-Distance.java](src/LeetCode-161-One-Edit-Distance.java)|String|
|[165.Compare Version Numbers](https://leetcode.com/problems/compare-version-numbers/)|[LeetCode-165-Compare-Version-Numbers.java](src/LeetCode-165-Compare-Version-Numbers.java)|String|
|[179. Largest Number](https://leetcode.com/problems/largest-number/)|[LeetCode-179-Largest-Number.java](src/LeetCode-179-Largest-Number.java)|String|
|[186.Reverse Words in a String II](https://leetcode.com/problems/reverse-words-in-a-string-ii/)|[LeetCode-186-Reverse-Words-in-a-String-II.java](src/LeetCode-186-Reverse-Words-in-a-String-II.java)|String|
|[249. Group Shifted Strings](https://leetcode.com/problems/group-shifted-strings/)|[LeetCode-249-Group-Shifted-Strings.java](src/LeetCode-249-Group-Shifted-Strings.java)|String|
|[273. Integer to English Words](https://leetcode.com/problems/integer-to-english-words/)|[LeetCode-273-Integer-to-English-Words.java](src/LeetCode-273-Integer-to-English-Words.java)|String|
|[282. Expression Add Operators](https://leetcode.com/problems/expression-add-operators/)|[LeetCode-282-Expression-Add-Operators.java](src/LeetCode-282-Expression-Add-Operators.java)|String|
|[340. Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)|[LeetCode-340-Longest-Substring-with-At-Most-K-Distinct-Characters.java](src/LeetCode-340-Longest-Substring-with-At-Most-K-Distinct-Characters.java)|String|
|[344. Reverse String](https://leetcode.com/problems/reverse-string/)|[LeetCode-344-Reverse-String.java](src/LeetCode-344-Reverse-String.java)|String|
|[383. Ransom Note](https://leetcode.com/problems/ransom-note/)|[LeetCode-383-Ransom-Note.java](src/LeetCode-383-Ransom-Note.java)|String|
|[387. First Unique Character in a String](https://leetcode.com/problems/first-unique-character-in-a-string/)|[LeetCode-387-First-Unique-Character-in-a-String.java](src/LeetCode-387-First-Unique-Character-in-a-String.java)|String|
|[443. String Compression](https://leetcode.com/problems/string-compression/)|[LeetCode-443-String-Compression.java](src/LeetCode-443-String-Compression.java)|String|
|[468. Validate IP Address](https://leetcode.com/problems/validate-ip-address/)|[LeetCode-468-Validate-IP-Address.java](src/LeetCode-468-Validate-IP-Address.java)|String|
|[557. Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)|[LeetCode-557-Reverse-Words-in-a-String-III.java](src/LeetCode-557-Reverse-Words-in-a-String-III.java)|String|
|[709. To Lower Case](https://leetcode.com/problems/to-lower-case/)|[LeetCode-709-To-Lower-Case.java](src/LeetCode-709-To-Lower-Case.java)|String|
|[736. Parse Lisp Expression](https://leetcode.com/problems/parse-lisp-expression/)|[LeetCode-736-Parse-Lisp-Expression.java](src/LeetCode-736-Parse-Lisp-Expression.java)|String|
|[748. Shortest Completing Word](https://leetcode.com/problems/shortest-completing-word/)|[LeetCode-748-Shortest-Completing-Word.java](src/LeetCode-748-Shortest-Completing-Word.java)|String|
|[771. Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)|[LeetCode-771-Jewels-and-Stones.java](src/LeetCode-771-Jewels-and-Stones.java)|String|
|[796. Rotate String](https://leetcode.com/problems/rotate-string/)|[LeetCode-796-Rotate-String.java](src/LeetCode-796-Rotate-String.java)|String|
|[804. Unique Morse Code Words](https://leetcode.com/problems/unique-morse-code-words/)|[LeetCode-804-Unique-Morse-Code-Words.java](src/LeetCode-804-Unique-Morse-Code-Words.java)|String|
|[833. Find And Replace in String](https://leetcode.com/problems/find-and-replace-in-string/)|[LeetCode-833-Find-And-Replace-in-String.java](src/LeetCode-833-Find-And-Replace-in-String.java)|String|
|[890. Find and Replace Pattern](https://leetcode.com/problems/find-and-replace-pattern/)|[LeetCode-890-Find-and-Replace-Pattern.java](src/LeetCode-890-Find-and-Replace-Pattern.java)|String|
|[929. Unique Email Addresses](https://leetcode.com/problems/unique-email-addresses/)|[LeetCode-929-Unique-Email-Addresses.java](src/LeetCode-929-Unique-Email-Addresses.java)|String|
|[937. Reorder Log Files](https://leetcode.com/problems/reorder-log-files/)|[LeetCode-937-Reorder-Log-Files.java](src/LeetCode-937-Reorder-Log-Files.java)|String|


|[242.Valid Anagram](https://leetcode.com/problems/valid-anagram/)|[LeetCode-242-Valid-Anagram.java](src/LeetCode-242-Valid-Anagram.java)|Sort, Array Map|
|[32.Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)|[LeetCode-32-Longest-Valid-Parentheses.java](src/LeetCode-32-Longest-Valid-Parentheses.java)|Not Yet|
|[241.Different Ways to Add Parentheses](https://leetcode.com/problems/different-ways-to-add-parentheses/)|[LeetCode-241.Different Ways to Add Parentheses.java](src/LeetCode-32-Longest-Valid-Parentheses.java)|Not Yet|
|[301.Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/)|[LeetCode-301.Remove Invalid Parentheses.java](src/LeetCode-32-Longest-Valid-Parentheses.java)|Not Yet|
|[9 Palindrome Number](https://leetcode.com/problems/palindrome-number/)|[LeetCode-9-Palindrome-Number.java](src/LeetCode-9-Palindrome-Number.java)|Math|
|[234.Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)|[LeetCode-234-Palindrome-Linked-List.java](src/LeetCode-234-Palindrome-Linked-List.java)|LinkedList|
|[131.Palindrome Partitioning](https://leetcode.com/problems/palindrome-partitioning/)|[LeetCode-131-Palindrome-Partitioning.java](src/LeetCode-131-Palindrome-Partitioning.java)|DFS|
|[★132.Palindrome Partitioning II](https://leetcode.com/problems/palindrome-partitioning-ii/)|[LeetCode-132-Palindrome-Partitioning-II.java](src/LeetCode-132-Palindrome-Partitioning-II.java)|DP|
|[214.Shortest Palindrome](https://leetcode.com/problems/shortest-palindrome/)|[LeetCode-214-Shortest-Palindrome.java](src/LeetCode-132-Palindrome-Partitioning-II.java)|Not Yet, Hard|
|[266.Palindrome Permutation](https://leetcode.com/problems/palindrome-permutation/)|[LeetCode-266-Palindrome-Permutation.java](src/LeetCode-234-Palindrome-Linked-List.java)|HashMap|
|[267.Palindrome Permutation II](https://leetcode.com/problems/palindrome-permutation-ii/)|[LeetCode-267-Palindrome-Permutation-II.java](src/LeetCode-267-Palindrome-Permutation-II.java)|Not Yet|
|[288.Unique Word Abbreviation](https://leetcode.com/problems/unique-word-abbreviation/)|[LeetCode-288-Unique-Word-Abbreviation.java](src/LeetCode-288-Unique-Word-Abbreviation.java)|String|

|[680. Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)|[LeetCode-680-Valid-Palindrome-II.java](src/LeetCode-680-Valid-Palindrome-II.java)|Not Yet|


### Dynamic Programming

|Question|Solution|Tags|
|--------|--------|----|
|[★★★55.Jump Game](https://leetcode.com/problems/jump-game/)|[LeetCode-55-Jump-Game.java](src/LeetCode-55-Jump-Game.java)|DP, Greedy|
|[45.Jump Game II](https://leetcode.com/problems/jump-game-ii/)|[LeetCode-45-Jump-Game-II.java](src/LeetCode-45-Jump-Game-II.java)|DP, Greedy|
|[★53.Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)|[LeetCode-53-Maximum-Subarray.java](src/LeetCode-53-Maximum-Subarray.java)|DP, Greedy|
|[Maximum Subarray II](http://www.lintcode.com/en/problem/maximum-subarray-ii/)|[LintCode-Maximum-Subarray-II.java](src/LintCode-Maximum-Subarray-II.java)|DP, Greedy|
|[Maximum Subarray III](http://www.lintcode.com/en/problem/maximum-subarray-iii/)|[LintCode-Maximum-Subarray-III.java](src/LintCode-Maximum-Subarray-III.java)|not yet, hard|
|[★62.Unique Paths](https://leetcode.com/problems/unique-paths/)|[LeetCode-62-Unique-Paths.java](src/LeetCode-62-Unique-Paths.java)|DP|
|[63.Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)|[LeetCode-63-Unique-Paths-II.java](src/LeetCode-63-Unique-Paths-II.java)|DP|
|[64.Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)|[LeetCode-64-Minimum-Path-Sum.java](src/LeetCode-64-Minimum-Path-Sum.java)|DP|
|[70.Climbing Stairs](https://leetcode.com/problems/climbing-stairs/)|[LeetCode-70-Climbing-Stairs.java](src/LeetCode-70-Climbing-Stairs.java)|DP|
|[72. Edit Distance](https://leetcode.com/problems/edit-distance/)|[LeetCode-72-Edit-Distance.java](src/LeetCode-72-Edit-Distance.java)|DP|
|[91.Decode Ways](https://leetcode.com/problems/decode-ways/)|[LeetCode-91-Decode-Ways.java](src/LeetCode-91-Decode-Ways.java)|DP|
|[97.Interleaving String](https://leetcode.com/problems/interleaving-string/)|[LeetCode-97-Interleaving-String.java](src/LeetCode-97-Interleaving-String.java)|DP|
|[★★★120.Triangle](https://leetcode.com/problems/triangle/)|[LeetCode-120-Triangle.java](src/LeetCode-120-Triangle.java)|DP, Array|
|[121.Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)|[LeetCode-121-Best-Time-to-Buy-and-Sell-Stock.java](src/LeetCode-121-Best-Time-to-Buy-and-Sell-Stock.java)|DP, Greedy|
|[122.Best Time to Buy and Sell Stock II](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)|[LeetCode-122-Best-Time-to-Buy-and-Sell-Stock-II.java](src/LeetCode-122-Best-Time-to-Buy-and-Sell-Stock-II.java)|Array|
|[123.Best Time to Buy and Sell Stock III](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/)|[LeetCode-123-Best-Time-to-Buy-and-Sell-Stock-III.java](src/LeetCode-123-Best-Time-to-Buy-and-Sell-Stock-III.java)|hard,not yet???|
|[188.Best Time to Buy and Sell Stock IV](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/)|[LeetCode-188-Best-Time-to-Buy-and-Sell-Stock-IV.java](src/LeetCode-188-Best-Time-to-Buy-and-Sell-Stock-IV.java)|hard, not yet???|
|[309.Best Time to Buy and Sell Stock with Cooldown](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/)|[LeetCode-309-Best-Time-to-Buy-and-Sell-Stock-with-Cooldown.java](src/LeetCode-309-Best-Time-to-Buy-and-Sell-Stock-with-Cooldown.java)|not yet???|
|[135. Candy](https://leetcode.com/problems/candy/)|[LeetCode-135-Candy.java](src/LeetCode-135-Candy.java)|Greedy|
|[152. Maximum Product Subarray](https://leetcode.com/problems/maximum-product-subarray/)|[LeetCode-152-Maximum-Product-Subarray.java](src/LeetCode-152-Maximum-Product-Subarray.java)|DP|
|[★★★198. House Robber](https://leetcode.com/problems/house-robber/)|[LeetCode-198-House-Robber.java](src/LeetCode-198-House-Robber.java)|DP|
|[213. House Robber II](https://leetcode.com/problems/house-robber-ii/)|[LeetCode-213-House-Robber-II.java](src/LeetCode-213-House-Robber-II.java)|DP|
|[★★★256. Paint House](https://leetcode.com/problems/paint-house/)|[LeetCode-256-Paint-House.java](src/LeetCode-256-Paint-House.java)|DP|
|[265. Paint House II](https://leetcode.com/problems/paint-house-ii/)|[LeetCode-265-Paint-House-II.java](src/LeetCode-265-Paint-House-II.java)|DP|
|[★★★276. Paint Fence](https://leetcode.com/problems/paint-fence/)|[LeetCode-276-Paint-Fence.java](src/LeetCode-276-Paint-Fence.java)|DP|
|[279. Perfect Squares](https://leetcode.com/problems/perfect-squares/)|[LeetCode-279-Perfect-Squares.java](src/LeetCode-279-Perfect-Squares.java)|DP|
|[★★★300. Longest Increasing Subsequence](https://leetcode.com/problems/longest-increasing-subsequence/)|[LeetCode-300-Longest-Increasing-Subsequence.java](src/LeetCode-300-Longest-Increasing-Subsequence.java)|DP, Binary Search|
|[303. Range Sum Query - Immutable](https://leetcode.com/problems/range-sum-query-immutable/)|[LeetCode-303-Range-Sum-Query-Immutable.java](src/LeetCode-303-Range-Sum-Query-Immutable.java)|DP|
|[304. Range Sum Query 2D - Immutable](https://leetcode.com/problems/range-sum-query-2d-immutable/)|[LeetCode-304-Range-Sum-Query-2D-Immutable.java](src/LeetCode-304-Range-Sum-Query-2D-Immutable.java)|DP|
|[316. Remove Duplicate Letters](https://leetcode.com/problems/remove-duplicate-letters/)|[LeetCode-316-Remove-Duplicate-Letters.java](src/LeetCode-316-Remove-Duplicate-Letters.java)|Greedy|
|[★★★322. Coin Change](https://leetcode.com/problems/coin-change/)|[LeetCode-322-Coin-Change.java](src/LeetCode-322-Coin-Change.java)|DP|
|[338. Counting Bits](https://leetcode.com/problems/counting-bits/)|[LeetCode-338-Counting-Bits.java](src/LeetCode-338-Counting-Bits.java)|DP, Math|
|[375. Guess Number Higher or Lower II](https://leetcode.com/problems/guess-number-higher-or-lower-ii/)|[LeetCode-375-Guess-Number-Higher-or-Lower-II.java](src/LeetCode-375-Guess-Number-Higher-or-Lower-II.java)|DP|
|[377. Combination Sum IV](https://leetcode.com/problems/combination-sum-iv/)|[LeetCode-377-Combination-Sum-IV.java](src/LeetCode-377-Combination-Sum-IV.java)|DP|
|[403. Frog Jump](https://leetcode.com/problems/frog-jump/)|[LeetCode-403-Frog-Jump.java](src/LeetCode-403-Frog-Jump.java)|DP|
|[416. Partition Equal Subset Sum](https://leetcode.com/problems/partition-equal-subset-sum/)|[LeetCode-416-Partition-Equal-Subset-Sum.java](src/LeetCode-416-Partition-Equal-Subset-Sum.java)|DP|
|[486. Predict the Winner](https://leetcode.com/problems/predict-the-winner/)|[LeetCode-486-Predict-the-Winner.java](src/LeetCode-486-Predict-the-Winner.java)|DP|
|[★★★494. Target Sum](https://leetcode.com/problems/target-sum/)|[LeetCode-494-Target-Sum.java](src/LeetCode-494-Target-Sum.java)|DP|
|[516. Longest Palindromic Subsequence](https://leetcode.com/problems/longest-palindromic-subsequence/)|[LeetCode-516-Longest-Palindromic-Subsequence.java](src/LeetCode-516-Longest-Palindromic-Subsequence.java)|DP|
|[★★★518. Coin Change 2](https://leetcode.com/problems/coin-change-2/)|[LeetCode-518-Coin-Change-2.java](src/LeetCode-518-Coin-Change-2.java)|DP|
|[605. Can Place Flowers](https://leetcode.com/problems/can-place-flowers/)|[LeetCode-605-Can-Place-Flowers.java](src/LeetCode-605-Can-Place-Flowers.java)|Greedy|
|[621. Task Scheduler](https://leetcode.com/problems/task-scheduler/)|[LeetCode-621-Task-Scheduler.java](src/LeetCode-621-Task-Scheduler.java)|Greedy|
|[647. Palindromic Substrings](https://leetcode.com/problems/palindromic-substrings/)|[LeetCode-647-Palindromic-Substrings.java](src/LeetCode-647-Palindromic-Substrings.java)|DP|
|[730. Count Different Palindromic Subsequences](https://leetcode.com/problems/count-different-palindromic-subsequences/)|[LeetCode-730-Count-Different-Palindromic-Subsequences.java](src/LeetCode-730-Count-Different-Palindromic-Subsequences.java)|DP|
|[805. Split Array With Same Average](https://leetcode.com/problems/split-array-with-same-average/)|[LeetCode-805-Split-Array-With-Same-Average.java](src/LeetCode-805-Split-Array-With-Same-Average.java)|DP|
|[968. Binary Tree Cameras](https://leetcode.com/problems/binary-tree-cameras/)|[LeetCode-968-Binary-Tree-Cameras.java](src/LeetCode-968-Binary-Tree-Cameras.java)|DP, Greedy|
|[★★★983. Minimum Cost For Tickets](https://leetcode.com/problems/minimum-cost-for-tickets/)|[LeetCode-983-Minimum-Cost-For-Tickets.java](src/LeetCode-983-Minimum-Cost-For-Tickets.java)|DP|
|[1049. Last Stone Weight II](https://leetcode.com/problems/last-stone-weight-ii/)|[LeetCode-1049-Last-Stone-Weight-II.java](src/LeetCode-1049-Last-Stone-Weight-II.java)|DP|
|[1094. Car Pooling](https://leetcode.com/problems/car-pooling/)|[LeetCode-1094-Car-Pooling.java](src/LeetCode-1094-Car-Pooling.java)|DP|








### Tree Search(Tree, Binary Search, DFS, BFS)
Search in Tree, in Binary Tree, Binary Search Tree, in String, in Array  
Search a required set, search Maximum/Minimu result  

[Tree大总结](https://github.com/yuzhangcmu/LeetCode_algorithm/blob/master/tree/TreeDemo.java)  
1. 求二叉树中的节点个数: getNodeNumRec（递归），getNodeNum（迭代）  
2. 求二叉树的深度: getDepthRec（递归），getDepth   
3. ★★★前序遍历，中序遍历，后序遍历: preorderTraversalRec, preorderTraversal, inorderTraversalRec, postorderTraversalRec  
4. ★★★分层遍历二叉树（按层次从上往下，从左往右）:levelTraversal, levelTraversalRec（递归解法）  
5. 将二叉查找树变为有序的双向链表: convertBST2DLLRec, convertBST2DLL  
6. 求二叉树第K层的节点个数：getNodeNumKthLevelRec, getNodeNumKthLevel  
7. 求二叉树中叶子节点的个数：getNodeNumLeafRec, getNodeNumLeaf  
8. 判断两棵二叉树是否相同的树：isSameRec, isSame  
9. 判断二叉树是不是平衡二叉树：isAVLRec  
10. 求二叉树的镜像（破坏和不破坏原来的树两种情况）：  
     mirrorRec, mirrorCopyRec  
     mirror, mirrorCopy  
10.1 判断两个树是否互相镜像：isMirrorRec isMirror  
11. 求二叉树中两个节点的最低公共祖先节点：  
         LAC        求解最小公共祖先, 使用list来存储path  
         LCABstRec  递归求解BST树  
         LCARec     递归算法  
12. 求二叉树中节点的最大距离：getMaxDistanceRec  
13. 由前序遍历序列和中序遍历序列重建二叉树：rebuildBinaryTreeRec  
14. 判断二叉树是不是完全二叉树：isCompleteBinaryTree, isCompleteBinaryTreeRec  
15. 找出二叉树中最长连续子串(即全部往左的连续节点，或是全部往右的连续节点）: findLongest  

[面试大总结之二：Java搞定面试中的二叉树题目](http://blog.csdn.net/fightforyourdream/article/details/16843303)  
[轻松搞定面试中的二叉树题目](http://blog.csdn.net/luckyxiaoqiang/article/details/7518888)  
[算法大全(3)二叉树](http://www.cnblogs.com/Jax/archive/2009/12/28/1633691.html)  

|Question|Solution|Tags|
|--------|--------|----|
|[130.Surrounded Region](https://leetcode.com/problems/surrounded-regions/)|[LeetCode-130-Surrounded-Regions.java](src/LeetCode-130-Surrounded-Regions.java)|BFS,DFS|
|[216.Combination Sum III](https://leetcode.com/problems/combination-sum-iii/)|[LeetCode-216-Combination-Sum-III.java](src/LeetCode-216-Combination-Sum-III.java)|Not yet|
|[77.Combinations](https://leetcode.com/problems/combinations/)|[LeetCode-77-Combinations.java](src/LeetCode-77-Combinations.java)|DFS|
|[278.First Bad Version](https://leetcode.com/problems/first-bad-version/)|[LeetCode-278-First-Bad-Version.java](src/LeetCode-278-First-Bad-Version.java)|Binary Search|
|[86.Partition List](https://leetcode.com/problems/partition-list/)|[LeetCode-86-Partition-List.java](src/LeetCode-86-Partition-List.java)|Two Pointers|
|[205.Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/)|[LeetCode-205-Isomorphic-Strings.java](src/LeetCode-205-Isomorphic-Strings.java)|HashMap|
|[290.Word Pattern](https://leetcode.com/problems/word-pattern/)|[LeetCode-290-Word-Pattern.java](src/LeetCode-290-Word-Pattern.java)|HashMap|
|[291.Word Pattern II](https://leetcode.com/problems/word-pattern-ii/)|[LeetCode-291-Word-Pattern-II.java](src/LeetCode-291-Word-Pattern-II.java)|Not yet, hard|
|[94.Binary Tree Inorder Traversal](https://leetcode.com/problems/binary-tree-inorder-traversal/)|[LeetCode-94-Binary-Tree-Inorder-Traversal.java](src/LeetCode-94-Binary-Tree-Inorder-Traversal.java)|DFS, BFS|
|[95.Unique Binary Search Trees II](https://leetcode.com/problems/unique-binary-search-trees-ii/)|[LeetCode-95-Unique-Binary-Search-Trees-II.java](src/LeetCode-95-Unique-Binary-Search-Trees-II.java)|DFS|
|[96.Unique Binary Search Trees](https://leetcode.com/problems/unique-binary-search-trees/)|[LeetCode-96-Unique-Binary-Search-Trees.java](src/LeetCode-96-Unique-Binary-Search-Trees.java)|DP|
|[98.Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)|[LeetCode-98-Validate-Binary-Search-Tree.java](src/LeetCode-98-Validate-Binary-Search-Tree.java)|DFS, BFS|
|[100.Same Tree](https://leetcode.com/problems/same-tree/)|[LeetCode-100-Same-Tree.java](src/LeetCode-100-Same-Tree.java)||
|[101.Symmetric Tree](https://leetcode.com/problems/symmetric-tree/)|[LeetCode-101-Symmetric-Tree.java](src/LeetCode-101-Symmetric-Tree.java)|Recursive, Iterative|
|[★102.Binary Tree Level Order Traversal I](https://leetcode.com/problems/binary-tree-level-order-traversal/)|[LeetCode-102-Binary-Tree-Level-Order-Traversal-I.java](src/LeetCode-102-Binary-Tree-Level-Order-Traversal-I.java)|BFS, DFS|
|[103.Binary Tree Zigzag Level Order Traversal](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)|[LeetCode-103-Binary-Tree-Zigzag-Level-Order-Traversal.java](src/LeetCode-103-Binary-Tree-Zigzag-Level-Order-Traversal.java)|BFS|
|[104.Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)|[LeetCode-104-Maximum-Depth-of-Binary-Tree.java](src/LeetCode-104-Maximum-Depth-of-Binary-Tree.java)|DFS|
|[105.Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)|[LeetCode-105-Construct-Binary-Tree-from-Preorder-and-Inorder-Traversal.java](src/LeetCode-105-Construct-Binary-Tree-from-Preorder-and-Inorder-Traversal.java)|DFS|
|[106.Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)|[LeetCode-106-Construct-Binary-Tree-from-Inorder-and-Postorder-Traversal.java](src/LeetCode-106-Construct-Binary-Tree-from-Inorder-and-Postorder-Traversal.java)|DFS|
|[107.Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)|[LeetCode-107-Binary-Tree-Level-Order-Traversal-II.java](src/LeetCode-107-Binary-Tree-Level-Order-Traversal-II.java)|BFS, DFS|
|[108.Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)|[LeetCode-108-Convert-Sorted-Array-to-Binary-Search-Tree.java](src/LeetCode-108-Convert-Sorted-Array-to-Binary-Search-Tree.java)|DFS|
|[109.Convert Sorted List to Binary Search Tree](https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/)|[LeetCode-109-Convert-Sorted-List-to-Binary-Search-Tree.java](src/LeetCode-109-Convert-Sorted-List-to-Binary-Search-Tree.java)|DFS|
|[110.Balanced Binary Tree](https://leetcode.com/problems/balanced-binary-tree/)|[LeetCode-110-Balanced-Binary-Tree.java](src/LeetCode-110-Balanced-Binary-Tree.java)|DFS|
|[111.Minimum Depth of Binary Tree](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)|[LeetCode-111-Minimum-Depth-of-Binary-Tree.java](src/LeetCode-111-Minimum-Depth-of-Binary-Tree.java)|DFS, BFS|
|[★112.Path Sum](https://leetcode.com/problems/path-sum/)|[LeetCode-112-Path-Sum.java](src/LeetCode-112-Path-Sum.java)|DFS, BFS|
|[113.Path Sum II](https://leetcode.com/problems/path-sum-ii/)|[LeetCode-113-Path-Sum-II.java](src/LeetCode-113-Path-Sum-II.java)|DFS|
|[114.Flatten Binary Tree to Linked List](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/)|[LeetCode-114-Flatten-Binary-Tree-to-Linked-List.java](src/LeetCode-114-Flatten-Binary-Tree-to-Linked-List.java)|DFS|
|[116.Populating Next Right Pointers in Each Node](https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)|[LeetCode-116-Populating-Next-Right-Pointers-in-Each-Node.java](src/LeetCode-116-Populating-Next-Right-Pointers-in-Each-Node.java)|BFS, DFS|
|[117.Populating Next Right Pointers in Each Node II](https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/)|[LeetCode-117-Populating-Next-Right-Pointers-in-Each-Node-II.java](src/LeetCode-117-Populating-Next-Right-Pointers-in-Each-Node-II.java)|BFS, DFS|
|[124.Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)|[LeetCode-124-Binary-Tree-Maximum-Path-Sum.java](src/LeetCode-124-Binary-Tree-Maximum-Path-Sum.java)|DFS|
|[129.Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/)|[LeetCode-129-Sum-Root-to-Leaf-Numbers.java](src/LeetCode-129-Sum-Root-to-Leaf-Numbers.java)|DFS|
|[144.Binary Tree Preorder Traversal](https://leetcode.com/problems/binary-tree-preorder-traversal/)|[LeetCode-144-Binary-Tree-Preorder-Traversal.java](src/LeetCode-144-Binary-Tree-Preorder-Traversal.java)|DFS, BFS|
|[145.Binary Tree Postorder Traversal](https://leetcode.com/problems/binary-tree-postorder-traversal/)|[LeetCode-145-Binary-Tree-Postorder-Traversal.java](src/LeetCode-145-Binary-Tree-Postorder-Traversal.java)|DFS, BFS|
|[156. Binary Tree Upside Down](https://leetcode.com/problems/binary-tree-upside-down/)|[LeetCode-156-Binary-Tree-Upside-Down.java](src/LeetCode-156-Binary-Tree-Upside-Down.java)|BFS, DFS|
|[173. Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/)|[LeetCode-173-Binary-Search-Tree-Iterator.java](/src/LeetCode-173-Binary-Search-Tree-Iterator.java)|BFS|
|[199.Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)|[LeetCode-199-Binary-Tree-Right-Side-View.java](src/LeetCode-199-Binary-Tree-Right-Side-View.java)|BFS, DFS|
|[222. Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)|[LeetCode-222-Count-Complete-Tree-Nodes.java](src/LeetCode-222-Count-Complete-Tree-Nodes.java)|BFS, DFS|
|[226. Invert Binary Tree](https://leetcode.com/problems/invert-binary-tree)|[LeetCode-226-Invert-Binary-Tree.java](src/LeetCode-226-Invert-Binary-Tree.java)|BFS, DFS|
|[230. Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)|[LeetCode-230-Kth-Smallest-Element-in-a-BST.java](src/LeetCode-230-Kth-Smallest-Element-in-a-BST.java)|BFS, DFS|
|[235.Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/)|[LeetCode-235-Lowest-Common-Ancestor-of-a-Binary-Search-Tree.java](src/LeetCode-235-Lowest-Common-Ancestor-of-a-Binary-Search-Tree.java)|Tree, Recursive|
|[236.Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)|[LeetCode-236-Lowest-Common-Ancestor-of-a-Binary-Tree.java](src/LeetCode-236-Lowest-Common-Ancestor-of-a-Binary-Tree.java)|Tree, Recursive|
|[Search in a Big Sorted Array](http://www.lintcode.com/en/problem/search-in-a-big-sorted-array/)|[LintCode-Search-in-a-Big-Sorted-Array.java](src/LintCode-Search-in-a-Big-Sorted-Array.java)|Binary Search|
|[250. Count Univalue Subtrees](https://leetcode.com/problems/count-univalue-subtrees/)|[LeetCode-250-Count-Univalue-Subtrees.java](src/LeetCode-250-Count-Univalue-Subtrees.java)|DFS|
|[255. Verify Preorder Sequence in Binary Search Tree](https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/submissions/)|[LeetCode-255-Verify-Preorder-Sequence-in-Binary-Search-Tree.java](src/LeetCode-255-Verify-Preorder-Sequence-in-Binary-Search-Tree.java)|DFS|
|[257.Binary Tree Paths](https://leetcode.com/problems/binary-tree-paths/)|[LeetCode-257-Binary-Tree-Paths.java](src/LeetCode-257-Binary-Tree-Paths.java)|not yet|
|[270.Closest Binary Search Tree Value](https://leetcode.com/problems/closest-binary-search-tree-value/)|[LeetCode-270-Closest-Binary-Search-Tree-Value.java](src/LeetCode-270-Closest-Binary-Search-Tree-Value.java)|BFS, DFS, Traversal|
|[272. Closest Binary Search Tree Value II](https://leetcode.com/problems/closest-binary-search-tree-value-ii/)|[LeetCode-272-Closest-Binary-Search-Tree-Value-II.java](src/LeetCode-272-Closest-Binary-Search-Tree-Value-II.java)|BFS, DFS, Traversal|
|[285. Inorder Successor in BST](https://leetcode.com/problems/inorder-successor-in-bst/)|[LeetCode-285-Inorder-Successor-in-BST.java](src/LeetCode-285-Inorder-Successor-in-BST.java)|BFS|
|[297. Serialize and Deserialize Binary Tree](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/)|[LeetCode-297-Serialize-and-Deserialize-Binary-Tree.java](src/LeetCode-297-Serialize-and-Deserialize-Binary-Tree.java)|BFS, DFS|
|[298. Binary Tree Longest Consecutive Sequence](https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/)|[LeetCode-298-Binary-Tree-Longest-Consecutive-Sequence.java](src/LeetCode-298-Binary-Tree-Longest-Consecutive-Sequence.java)|DFS|
|[314.Binary Tree Vertical Order Traversal](https://leetcode.com/problems/binary-tree-vertical-order-traversal/)|[LeetCode-314-Binary-Tree-Vertical-Order-Traversal.java](src/LeetCode-314-Binary-Tree-Vertical-Order-Traversal.java)|not yet|
|[333. Largest BST Subtree](https://leetcode.com/problems/largest-bst-subtree/)|[LeetCode-333-Largest-BST-Subtree.java](src/LeetCode-333-Largest-BST-Subtree.java)|DFS|
|[337. House Robber III](https://leetcode.com/problems/house-robber-iii/)|[LeetCode-337-House-Robber-III.java](src/LeetCode-337-House-Robber-III.java)|DFS|
|[366. Find Leaves of Binary Tree](https://leetcode.com/problems/find-leaves-of-binary-tree/)|[LeetCode-366-Find-Leaves-of-Binary-Tree.java.java](src/LeetCode-366-Find-Leaves-of-Binary-Tree.java.java)|DFS|
|[374. Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/)|[LeetCode-374-Guess-Number-Higher-or-Lower.java](src/LeetCode-374-Guess-Number-Higher-or-Lower.java)|Binary Search|
|[404. Sum of Left Leaves](https://leetcode.com/problems/sum-of-left-leaves/)|[LeetCode-404-Sum-of-Left-Leaves.java](src/LeetCode-404-Sum-of-Left-Leaves.java)|DFS|
|[427. Construct Quad Tree](https://leetcode.com/problems/construct-quad-tree/)|[LeetCode-427-Construct-Quad-Tree.java](src/LeetCode-427-Construct-Quad-Tree.java)|Recursive|
|[428. Serialize and Deserialize N-ary Tree](https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/)|[LeetCode-428-Serialize-and-Deserialize-N-ary-Tree.java](src/LeetCode-428-Serialize-and-Deserialize-N-ary-Tree.java)|Recursive|
|[437. Path Sum III](https://leetcode.com/problems/path-sum-iii/)|[LeetCode-437-Path-Sum-III.java](src/LeetCode-437-Path-Sum-III.java)|DFS|
|[450. Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/)|[LeetCode-450-Delete-Node-in-a-BST.java](src/LeetCode-450-Delete-Node-in-a-BST.java)|DFS|
|[501. Find Mode in Binary Search Tree](https://leetcode.com/problems/find-mode-in-binary-search-tree/)|[LeetCode-501-Find-Mode-in-Binary-Search-Tree.java](src/LeetCode-501-Find-Mode-in-Binary-Search-Tree.java)|DFS|
|[508. Most Frequent Subtree Sum](https://leetcode.com/problems/most-frequent-subtree-sum/)|[LeetCode-508-Most-Frequent-Subtree-Sum.java](src/LeetCode-508-Most-Frequent-Subtree-Sum.java)|DFS, similar to 501|
|[510. Inorder Successor in BST II](https://leetcode.com/problems/inorder-successor-in-bst-ii/)|[LeetCode-510-Inorder-Successor-in-BST-II.java](src/LeetCode-510-Inorder-Successor-in-BST-II.java)|DFS, similar to 285|
|[513. Find Bottom Left Tree Value](https://leetcode.com/problems/find-bottom-left-tree-value/)|[LeetCode-513-Find-Bottom-Left-Tree-Value.java](src/LeetCode-513-Find-Bottom-Left-Tree-Value.java)|DFS, BFS|
|[515. Find Largest Value in Each Tree Row](https://leetcode.com/problems/find-largest-value-in-each-tree-row/)|[LeetCode-515-Find-Largest-Value-in-Each-Tree-Row.java](src/LeetCode-515-Find-Largest-Value-in-Each-Tree-Row.java)|DFS, BFS|
|[530. Minimum Absolute Difference in BST](https://leetcode.com/problems/minimum-absolute-difference-in-bst/)|[LeetCode-530-Minimum-Absolute-Difference-in-BST.java](src/LeetCode-530-Minimum-Absolute-Difference-in-BST.java)|DFS, BFS|
|[538. Convert BST to Greater Tree](https://leetcode.com/problems/convert-bst-to-greater-tree/)|[LeetCode-538-Convert-BST-to-Greater-Tree.java](src/LeetCode-538-Convert-BST-to-Greater-Tree.java)|inorder traversal|
|[543. Diameter of Binary Tree](https://leetcode.com/problems/diameter-of-binary-tree/)|[LeetCode-543-Diameter-of-Binary-Tree.java](src/LeetCode-543-Diameter-of-Binary-Tree.java)|DFS|
|[545. Boundary of Binary Tree](https://leetcode.com/problems/boundary-of-binary-tree/)|[LeetCode-545-Boundary-of-Binary-Tree.java](src/LeetCode-545-Boundary-of-Binary-Tree.java)|Recursive|
|[582. Kill Process](https://leetcode.com/problems/kill-process/)|[LeetCode-582-Kill-Process.java](src/LeetCode-582-Kill-Process.java)|BFS, DFS|
|[654. Maximum Binary Tree](https://leetcode.com/problems/maximum-binary-tree/)|[LeetCode-654-Maximum-Binary-Tree.java](src/LeetCode-654-Maximum-Binary-Tree.java)|Recursive, Deque|
|[655. Print Binary Tree](https://leetcode.com/problems/print-binary-tree/)|[LeetCode-655-Print-Binary-Tree.java](src/LeetCode-655-Print-Binary-Tree.java)|BFS, DFS|
|[671. Second Minimum Node In a Binary Tree](https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/)|[LeetCode-671-Second-Minimum-Node-In-a-Binary-Tree.java](src/LeetCode-671-Second-Minimum-Node-In-a-Binary-Tree.java)|Recursive|
|[701. Insert into a Binary Search Tree](https://leetcode.com/problems/insert-into-a-binary-search-tree/)|[LeetCode-701-Insert-into-a-Binary-Search-Tree.java](src/LeetCode-701-Insert-into-a-Binary-Search-Tree.java)|Recursive, Iterative|
|[958. Check Completeness of a Binary Tree](https://leetcode.com/problems/check-completeness-of-a-binary-tree/)|[LeetCode-958-Check-Completeness-of-a-Binary-Tree.java](src/LeetCode-958-Check-Completeness-of-a-Binary-Tree.java)|DFS|










### List
Change Order(Reverse, Swap) & Remove  
The use of dummy node, use pointer Next to store next node(Merge Two Sort Lists, Merge K Sorted Lists, Reverse List, Reverse Nodes in K-groups)  
Find/Remove Kth biggest node from end: use two pointers, one run k step, and then two pointers run parallelly until one reach null.
Find the middle of a list: fast-slow pointers, one run one step, another run two steps. Be carefully of initialization, slow = header, fast = header.next.(Find intersection point, Detect circle)   

[面试大总结之链表](http://blog.csdn.net/fightforyourdream/article/details/16353519)  
[轻松搞定面试中的链表题目](http://blog.csdn.net/luckyxiaoqiang/article/details/7393134)  
[算法大全（1）单链表](http://www.cnblogs.com/jax/archive/2009/12/11/1621504.html)  

|Question|Solution|Tags|
|--------|--------|----|
|[19.Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)|[LeetCode-19-Remove-Nth-Node-From-End-of-List.java](src/LeetCode-19-Remove-Nth-Node-From-End-of-List.java)|Two Pointers|
|[21.Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)|[LeetCode-21-Merge-Two-Sorted-Lists.java](src/LeetCode-21-Merge-Two-Sorted-Lists.java)|Recursive, Iterative|
|[★23.Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)|[LeetCode-23-Merge-k-Sorted-Lists.java](src/LeetCode-23-Merge-k-Sorted-Lists.java)|Merge Sort, Priority Queue|
|[24.Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)|[LeetCode-24-Swap-Nodes-in-Pairs.java](src/LeetCode-24-Swap-Nodes-in-Pairs.java)|LinkedList|
|[25.Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)|[LeetCode-25-Reverse-Nodes-in-k-Group.java](src/LeetCode-25-Reverse-Nodes-in-k-Group.java)|LinkedList|
|[61 Rotate List](https://leetcode.com/problems/rotate-list/)|[LeetCode-61-Rotate-List.java](src/LeetCode-61-Rotate-List.java)|Two Pointers|
|[83.Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)|[LeetCode-83-Remove-Duplicates-from-Sorted-List.java](src/LeetCode-83-Remove-Duplicates-from-Sorted-List.java)|LinkedList|
|[82.Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)|[LeetCode-82-Remove-Duplicates-from-Sorted-List-II.java](src/LeetCode-82-Remove-Duplicates-from-Sorted-List-II.java)|LinkedList|
|[92.Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)|[LeetCode-92-Reverse-Linked-List-II.java](src/LeetCode-92-Reverse-Linked-List-II.java)|LinskedList|
|[138. Copy List with Random Pointer](https://leetcode.com/problems/copy-list-with-random-pointer/)|[LeetCode-138-Copy-List-with-Random-Pointer.java](src/LeetCode-138-Copy-List-with-Random-Pointer.java)|LinkedList|
|[141.Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)|[LeetCode-141-Linked-List-Cycle.java](src/LeetCode-141-Linked-List-Cycle.java)|Two Pointers|
|[142.Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)|[LeetCode-142-Linked-List-Cycle-II.java](src/LeetCode-142-Linked-List-Cycle-II.java)|Two Pointers|
|[147. Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/)|[LeetCode-147-Insertion-Sort-List.java](src/LeetCode-147-Insertion-Sort-List.java)|Two Pointers|
|[160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)|[LeetCode-160-Intersection-of-Two-Linked-Lists.java](src/LeetCode-160-Intersection-of-Two-Linked-Lists.java)|Two Pointers|
|[203.Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)|[LeetCode-203-Remove-Linked-List-Elements.java](src/LeetCode-203-Remove-Linked-List-Elements.java)|LinkedList|
|[206.Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)|[LeetCode-206-Reverse-Linked-List.java](src/LeetCode-206-Reverse-Linked-List.java)|LinskedList|
|[237. Delete Node in a Linked List](https://leetcode.com/problems/delete-node-in-a-linked-list/)|[LeetCode-237-Delete-Node-in-a-Linked-List.java](src/LeetCode-237-Delete-Node-in-a-Linked-List.java)|LinskedList|



### Trie
|Question|Solution|Tags|
|--------|--------|----|
|[208. Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)|[LeetCode-208-Implement-Trie-Prefix-Tree.java](src/LeetCode-208-Implement-Trie-Prefix-Tree.java)|Trie|
|[212. Word Search II](https://leetcode.com/problems/word-search-ii/)|[LeetCode-212-Word-Search-II.java](src/LeetCode-212-Word-Search-II.java)|Trie|
|[336. Palindrome Pairs](https://leetcode.com/problems/palindrome-pairs/)|[LeetCode-336-Palindrome-Pairs.java](src/LeetCode-336-Palindrome-Pairs.java)|Trie|
|[720. Longest Word in Dictionary](https://leetcode.com/problems/longest-word-in-dictionary/)|[LeetCode-720-Longest-Word-in-Dictionary.java](src/LeetCode-720-Longest-Word-in-Dictionary.java)|Trie|


### Heap or TreeMap

PriorityQueue.

|Question|Solution|Tags|
|--------|--------|----|
|[218. The Skyline Problem](https://leetcode.com/problems/the-skyline-problem/)|[LeetCode-218-The-Skyline-Problem.java](src/LeetCode-218-The-Skyline-Problem.java)|Heap, TreeMap|
|[239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)|[LeetCode-239-Sliding-Window-Maximum.java](src/LeetCode-239-Sliding-Window-Maximum.java)|Heap, Deque|
|[295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)|[LeetCode-295-Find-Median-from-Data-Stream.java](src/LeetCode-295-Find-Median-from-Data-Stream.java)|Heap|
|[347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)|[LeetCode-347-Top-K-Frequent-Elements.java](src/LeetCode-347-Top-K-Frequent-Elements.java)|Heap, Deque|
|[373. Find K Pairs with Smallest Sums](https://leetcode.com/problems/find-k-pairs-with-smallest-sums/)|[LeetCode-373-Find-K-Pairs-with-Smallest-Sums.java](src/LeetCode-373-Find-K-Pairs-with-Smallest-Sums.java)|Heap|
|[407. Trapping Rain Water II](https://leetcode.com/problems/trapping-rain-water-ii/)|[LeetCode-407-Trapping-Rain-Water-II.java](src/LeetCode-407-Trapping-Rain-Water-II.java)|Heap|
|[451. Sort Characters By Frequency](https://leetcode.com/problems/sort-characters-by-frequency/)|[LeetCode-451-Sort-Characters-By-Frequency.java](src/LeetCode-451-Sort-Characters-By-Frequency.java)|String, Heap, Bucket Sort|
|[692. Top K Frequent Words](https://leetcode.com/problems/top-k-frequent-words/)|[LeetCode-692-Top-K-Frequent-Words.java](src/LeetCode-692-Top-K-Frequent-Words.java)|Heap|
|[729. My Calendar I](https://leetcode.com/problems/my-calendar-i/)|[LeetCode-729-My-Calendar-I.java](src/LeetCode-729-My-Calendar-I.java)|TreeMap|
|[973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)|[LeetCode-973-K-Closest-Points-to-Origin.java](src/LeetCode-973-K-Closest-Points-to-Origin.java)|Heap, QuickSelect|
|[1046. Last Stone Weight](https://leetcode.com/problems/last-stone-weight/)|[LeetCode-1046-Last-Stone-Weight.java](src/LeetCode-1046-Last-Stone-Weight.java)|Max Heap|



### Graph

|Question|Solution|Tags|
|--------|--------|----|
|[133.Clone Graph](https://leetcode.com/problems/clone-graph/)|[LeetCode-133-Clone-Graph.java](src/LeetCode-133-Clone-Graph.java)|Graph, BFS, DFS|
|[207. Course Schedule](https://leetcode.com/problems/course-schedule/)|[LeetCode-207-Course-Schedule.java](src/LeetCode-207-Course-Schedule.java)|Graph, Topological Sort|
|[210. Course Schedule II](https://leetcode.com/problems/course-schedule-ii/)|[LeetCode-210-Course-Schedule-II.java](src/LeetCode-210-Course-Schedule-II.java)|Graph, Topological Sort|
|[269. Alien Dictionary](https://leetcode.com/problems/alien-dictionary/)|[LeetCode-269-Alien-Dictionary.java](src/LeetCode-269-Alien-Dictionary.java)|Graph, Topological Sort|
|[785. Is Graph Bipartite?](https://leetcode.com/problems/is-graph-bipartite/)|[LeetCode-785-Is-Graph-Bipartite.java](src/LeetCode-785-Is-Graph-Bipartite.java)|Graph, Topological Sort|



### Math
Prime  
Operations between strings, between big numbers(larger than RAM: First external sorting (split into several parts), then K-way merge.)  

|Question|Solution|Tags|
|--------|--------|----|
|[2.Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)|[LeetCode-2-Add-Two-Numbers.java](src/LeetCode-2-Add-Two-Numbers.java)|LinkedList|
|[7.Reverse Integer](https://leetcode.com/problems/reverse-integer/)|[LeetCode-7-Reverse-Integer.java](src/LeetCode-7-Reverse-Integer.java)|Integer|
|[43.Multiply Strings](https://leetcode.com/problems/multiply-strings/)|[LeetCode-43-Multiply-Strings.java](src/LeetCode-43-Multiply-Strings.java)|String|
|[67.Add Binary](https://leetcode.com/problems/add-binary/)|[LeetCode-67-Add-Binary.java](src/LeetCode-67-Add-Binary.java)|String|
|[29.Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)|[LeetCode-29-Divide-Two-Integers.java](src/LeetCode-29-Divide-Two-Integers.java)|Binary Search|
|[50.Pow(x, n)](https://leetcode.com/problems/powx-n/)|[LeetCode-50-Pow-n.java](src/LeetCode-50-Pow-n.java)|Binary Search|
|[66.Plus One](https://leetcode.com/problems/plus-one/)|[LeetCode-66-Plus-One.java](src/LeetCode-66-Plus-One.java)|Array|
|[69.Sqrt(x)](https://leetcode.com/problems/sqrtx/)|[LeetCode-69-Sqrt-x.java](src/LeetCode-69-Sqrt-x.java)|Binary Search|
|[89 Gray Code](https://leetcode.com/problems/gray-code/)|[LeetCode-89-Gray-Code.java](src/LeetCode-89-Gray-Code.java)|Math|
|[149. Max Points on a Line](https://leetcode.com/problems/max-points-on-a-line/)|[LeetCode-149-Max-Points-on-a-Line.java](src/LeetCode-149-Max-Points-on-a-Line.java)|Math|
|[150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)|[LeetCode-150-Evaluate-Reverse-Polish-Notation.java](src/LeetCode-150-Evaluate-Reverse-Polish-Notation.java)|Math|
|[202. Happy Number](https://leetcode.com/problems/happy-number/)|[LeetCode-202-Happy-Number.java](src/LeetCode-202-Happy-Number.java)|Math|
|[204.Count Primes](https://leetcode.com/problems/count-primes/)|[LeetCode-204-Count-Primes.java](src/LeetCode-204-Count-Primes.java)|Math|
|[227. Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/)|[LeetCode-227-Basic-Calculator-II.java](src/LeetCode-227-Basic-Calculator-II.java)|Math|
|[233. Number of Digit One](https://leetcode.com/problems/number-of-digit-one/)|[LeetCode-233-Number-of-Digit-One.java](src/LeetCode-233-Number-of-Digit-One.java)|Math|
|[254. Factor Combinations](https://leetcode.com/problems/factor-combinations/)|[LeetCode-254-Factor-Combinations.java](src/LeetCode-254-Factor-Combinations.java)|Recursive|
|[311. Sparse Matrix Multiplication](https://leetcode.com/problems/sparse-matrix-multiplication/)|[LeetCode-311-Sparse-Matrix-Multiplication.java](src/LeetCode-311-Sparse-Matrix-Multiplication.java)|Math|
|[319. Bulb Switcher](https://leetcode.com/problems/bulb-switcher/)|[LeetCode-319-Bulb-Switcher.java](src/LeetCode-319-Bulb-Switcher.java)|Math|
|[326. Power of Three](https://leetcode.com/problems/power-of-three/)|[LeetCode-326-Power-of-Three.java](src/LeetCode-326-Power-of-Three.java)|Math|
|[367. Valid Perfect Square](https://leetcode.com/problems/valid-perfect-square/)|[LeetCode-367-Valid-Perfect-Square.java](src/LeetCode-367-Valid-Perfect-Square.java)|Math, Binary Search|
|[369. Plus One Linked List](https://leetcode.com/problems/plus-one-linked-list/)|[LeetCode-369-Plus-One-Linked-List.java](src/LeetCode-369-Plus-One-Linked-List.java)|Math|
|[415. Add Strings](https://leetcode.com/problems/add-strings/)|[LeetCode-415-Add-Strings.java](src/LeetCode-415-Add-Strings.java)|Math|
|[445. Add Two Numbers II](https://leetcode.com/problems/add-two-numbers-ii/)|[LeetCode-445-Add-Two-Numbers-II.java](src/LeetCode-445-Add-Two-Numbers-II.java)|LinkedList, Stack|
|[479. Largest Palindrome Product](https://leetcode.com/problems/largest-palindrome-product/)|[LeetCode-479-Largest-Palindrome-Product.java](src/LeetCode-479-Largest-Palindrome-Product.java)|Math|
|[593. Valid Square](https://leetcode.com/problems/valid-square/)|[LeetCode-593-Valid-Square.java](src/LeetCode-593-Valid-Square.java)|Math|
|[633. Sum of Square Numbers](https://leetcode.com/problems/sum-of-square-numbers/)|[LeetCode-633-Sum-of-Square-Numbers.java](src/LeetCode-633-Sum-of-Square-Numbers.java)|Math|
|[1017. Convert to Base -2](https://leetcode.com/problems/convert-to-base-2/)|[LeetCode-1017-Convert-to-Base--2.java](src/LeetCode-1017-Convert-to-Base--2.java)|Math|
|[1073. Adding Two Negabinary Numbers](https://leetcode.com/problems/adding-two-negabinary-numbers/)|[LeetCode-1073-Adding-Two-Negabinary-Numbers.java](src/LeetCode-1073-Adding-Two-Negabinary-Numbers.java)|Math|



|[60.Permutation Sequence](https://leetcode.com/problems/permutation-sequence/)|[LeetCode-60-Permutation-Sequence.java](src/LeetCode-60-Permutation-Sequence.java)|Math|
|[168.Excel Sheet Column Title](https://leetcode.com/problems/excel-sheet-column-title/)|[LeetCode-168-Excel-Sheet-Column-Title.java](src/LeetCode-168-Excel-Sheet-Column-Title.java)|Math|
|[171.Excel Sheet Column Number](https://leetcode.com/problems/excel-sheet-column-number/)|[LeetCode-171-Excel-Sheet-Column-Number.java](src/LeetCode-171-Excel-Sheet-Column-Number.java)|Math|

### Bit Manipulation

|Question|Solution|Tags|
|--------|--------|----|
|[187. Repeated DNA Sequences](https://leetcode.com/problems/repeated-dna-sequences/)|[LeetCode-187-Repeated-DNA-Sequences.java](src/LeetCode-187-Repeated-DNA-Sequences.java)|Bit Manipulation|
|[190. Reverse Bits](https://leetcode.com/problems/reverse-bits/)|[LeetCode-190-Reverse-Bits.java](src/LeetCode-190-Reverse-Bits.java)|Bit Manipulation|
|[191. Number of 1 Bits](https://leetcode.com/problems/number-of-1-bits/)|[LeetCode-191-Number-of-1-Bits.java](src/LeetCode-191-Number-of-1-Bits.java)|Bit Manipulation|
|[201. Bitwise AND of Numbers Range](https://leetcode.com/problems/bitwise-and-of-numbers-range/)|[LeetCode-201-Bitwise-AND-of-Numbers-Range.java](src/LeetCode-201-Bitwise-AND-of-Numbers-Range.java)|Bit Manipulation|
|[260.Single Number III](https://leetcode.com/problems/single-number-iii/)|[LeetCode-260-Single-Number-III.java](src/LeetCode-260-Single-Number-III.java)|Bit Manipulation|
|[318. Maximum Product of Word Lengths](https://leetcode.com/problems/maximum-product-of-word-lengths/)|[LeetCode-318-Maximum-Product-of-Word-Lengths.java](src/LeetCode-318-Maximum-Product-of-Word-Lengths.java)|Math|
|[393. UTF-8 Validation](https://leetcode.com/problems/utf-8-validation/)|[LeetCode-393-UTF-8-Validation.java](src/LeetCode-393-UTF-8-Validation.java)|Math|



### Stack

https://leetcode.com/tag/stack/

|Question|Solution|Tags|
|--------|--------|----|
|[394. Decode String](https://leetcode.com/problems/decode-string/)|[LeetCode-394-Decode-String.java](src/LeetCode-394-Decode-String.java)|Stack|
|[636. Exclusive Time of Functions](https://leetcode.com/problems/exclusive-time-of-functions/)|[LeetCode-636-Exclusive-Time-of-Functions.java](src/LeetCode-636-Exclusive-Time-of-Functions.java)|Stack|
|[946. Validate Stack Sequences](https://leetcode.com/problems/validate-stack-sequences/)|[LeetCode-946-Validate-Stack-Sequences.java](src/LeetCode-946-Validate-Stack-Sequences.java)|Stack|



### Union-Find

|Question|Solution|Tags|
|--------|--------|----|
|[128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)|[LeetCode-128-Longest-Consecutive-Sequence.java](src/LeetCode-128-Longest-Consecutive-Sequence.java)|Array, Union-Find|
|[261. Graph Valid Tree](https://leetcode.com/problems/graph-valid-tree/)|[LeetCode-261-Graph-Valid-Tree.java](src/LeetCode-261-Graph-Valid-Tree.java)|Graph, Union-Find, DFS, BFS|
|[323. Number of Connected Components in an Undirected Graph](https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/)|[LeetCode-323-Number-of-Connected-Components-in-an-Undirected-Graph.java](src/LeetCode-323-Number-of-Connected-Components-in-an-Undirected-Graph.java)|Graph, Union-Find, DFS, BFS|
|[547. Friend Circles](https://leetcode.com/problems/friend-circles/)|[LeetCode-547-Friend-Circles.java](src/LeetCode-547-Friend-Circles.java)|Union-Find, DFS|


### Reservoir Sampling
|Question|Solution|Tags|
|--------|--------|----|
|[382. Linked List Random Node](https://leetcode.com/problems/linked-list-random-node/)|[LeetCode-382-Linked-List-Random-Node.java](src/LeetCode-382-Linked-List-Random-Node.java)|Reservoir Sampling|


### Segment Tree
|Question|Solution|Tags|
|--------|--------|----|
|[715. Range Module](https://leetcode.com/problems/range-module/)|[LeetCode-715-Range-Module.java](src/LeetCode-715-Range-Module.java)|Segment Tree, TreeMap|

### Design

|Question|Solution|Tags|
|--------|--------|----|
|[★146.LRU Cache](https://leetcode.com/problems/lru-cache/)|[LeetCode-146-LRU-Cache.java](src/LeetCode-146-LRU-Cache.java)|HashMap, List|
|[155.Min Stack](https://leetcode.com/problems/min-stack/)|[LeetCode-155-Min-Stack.java](src/LeetCode-155-Min-Stack.java)|Two Stacks|
|[225.Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)|[LeetCode-225-Implement-Stack-using-Queues.java](src/LeetCode-225-Implement-Stack-using-Queues.java)|Queue|  
|[232.Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)|[LeetCode-232-Implement-Queue-using-Stacks.java](src/LeetCode-232-Implement-Queue-using-Stacks.java)|Stack|  
|[251. Flatten 2D Vector](https://leetcode.com/problems/flatten-2d-vector/)|[LeetCode-251-Flatten-2D-Vector.java](src/LeetCode-251-Flatten-2D-Vector.java)|Two Pointers|
|[281.Zigzag Iterator](https://leetcode.com/problems/zigzag-iterator/)|[LeetCode-281-Zigzag-Iterator.java](src/LeetCode-281-Zigzag-Iterator.java)|LinkedList|
|[284.Peeking Iterator](https://leetcode.com/problems/peeking-iterator/)|[LeetCode-284-Peeking-Iterator.java](src/LeetCode-284-Peeking-Iterator.java)|Cache|  
|[346. Moving Average from Data Stream](https://leetcode.com/problems/moving-average-from-data-stream/)|[LeetCode-346-Moving-Average-from-Data-Stream.java](src/LeetCode-346-Moving-Average-from-Data-Stream.java)|LinkedList|
|[348. Design Tic-Tac-Toe](https://leetcode.com/problems/design-tic-tac-toe/)|[LeetCode-348-Design-Tic-Tac-Toe.java](src/LeetCode-348-Design-Tic-Tac-Toe.java)|Array|
|[353. Design Snake Game](https://leetcode.com/problems/design-snake-game/)|[LeetCode-353-Design-Snake-Game.java](src/LeetCode-353-Design-Snake-Game.java)|Array|
|[★362. Design Hit Counter](https://leetcode.com/problems/design-hit-counter/)|[LeetCode-362-Design-Hit-Counter.java](src/LeetCode-362-Design-Hit-Counter.java)|Deque, Array|
|[★380. Insert Delete GetRandom O(1)](https://leetcode.com/problems/insert-delete-getrandom-o1/)|[LeetCode-380-Insert-Delete-GetRandom-O(1).java](src/LeetCode-380-Insert-Delete-GetRandom-O(1).java)|LinkedList|
|[381. Insert Delete GetRandom O(1) - Duplicates allowed](https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/)|[LeetCode-381-Insert-Delete-GetRandomO(1)-Duplicates-allowed.java](src/LeetCode-381-Insert-Delete-GetRandomO(1)-Duplicates-allowed.java)|LinkedList|
|[★432. All O one Data Structure](https://leetcode.com/problems/all-oone-data-structure/)|[LeetCode-432-All-O-one-Data-Structure.java](src/LeetCode-432-All-O-one-Data-Structure.java)|HashMap, LinkedList|
|[★460. LFU Cache](https://leetcode.com/problems/lfu-cache/)|[LeetCode-460-LFU-Cache.java](src/LeetCode-460-LFU-Cache.java)|HashMap|
|[535. Encode and Decode TinyURL](https://leetcode.com/problems/encode-and-decode-tinyurl/)|[LeetCode-535-Encode-and-Decode-TinyURL.java](src/LeetCode-535-Encode-and-Decode-TinyURL.java)|HashMap|
|[706. Design HashMap](https://leetcode.com/problems/design-hashmap/)|[LeetCode-706-Design-HashMap.java](src/LeetCode-706-Design-HashMap.java)|HashMap|
|[716. Max Stack](https://leetcode.com/problems/max-stack/)|[LeetCode-716-Max-Stack.java](src/LeetCode-716-Max-Stack.java)|Two Stacks|




[173.Binary Search Tree Iterator](https://leetcode.com/problems/binary-search-tree-iterator/)  



[301.Remove Invalid Parentheses](https://leetcode.com/problems/remove-invalid-parentheses/)





[136.Single Number](https://leetcode.com/problems/single-number/)  
[137.Single Number II](https://leetcode.com/problems/single-number-ii/)  



[30.Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)  


/*
LeetCode: 
LintCode: 
JiuZhang: 
ProgramCreek: 

Analysis: 

*/

[地里2016年度所有Facebook面试题总结](http://www.1point3acres.com/bbs/thread-203983-1-1.html)  

[Category](http://www.mitbbs.com/article_t/JobHunting/32564237.html)  
[经典面试题总结 —— Binary Search 及其变种](http://blog.csdn.net/hopeztm/article/details/7880646)  
[BFS/DFS总结](http://cuijing.org/2013/07/summary-of-dfs-and-bfs-in-leetcode/)  
[转一些我blog上一些常见的二叉树面试问题和总结 (更新)](http://smartlhc.blogspot.com/2012/10/repost-blog.html)  

[Here is a 10-line template that can solve most 'substring' problems](https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems)  

[Backtracking Porblems总结(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning)](https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning))

[O(N) template for Minimum Size Subarray Sum & Minimum Window Substring & Longest Substring Without Repeating Characters](https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59110/O(N)-template-for-Minimum-Size-Subarray-Sum-and-Minimum-Window-Substring-and-Longest-Substring-Without-Repeating-Characters)



刷题总结：
http://joshuablog.herokuapp.com/Leetcode-%E6%80%BB%E7%BB%93.html

### Reference
[LeetCode](https://leetcode.com/)   |   [LintCode](http://www.lintcode.com/)    |   [JiuZhang](http://www.jiuzhang.com/)  
[Top 10 Algorithms for Coding Interview](http://www.programcreek.com/2012/11/top-10-algorithms-for-coding-interview/)  
[Top 10 algorithms in Interview Questions(G4G)](http://www.geeksforgeeks.org/top-10-algorithms-in-interview-questions/)  
[Simple Java](http://www.programcreek.com/simple-java/)
[Data Structure Summary](https://www.1point3acres.com/bbs/thread-699816-1-1.html)
