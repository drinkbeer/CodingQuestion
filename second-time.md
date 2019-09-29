DFS, BFS, BinarySearch, Two Pointers, 
Data Structure: Heap, List, Tree, Union Find

DP 和 Greedy一般比较好的公司都要面的。如果想去GG和FB，DP一定会考。

Hot Problems:

word search12， word break12，word ladder12，

LIS，sort color，

LRU，LFU, insert & delete in O1，min/max heap

rob house123，234sum这种题要达到闭眼秒杀的程度，

bucket sort，topological sort，binary sort

pre/in/post/level 遍历

combination/permutation


|Question		|Tags		|
|---------------|-----------|
|[1. Two Sum](https://leetcode.com/problems/two-sum/)|HashMap|
|[2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)|List, carry, dummy node|
|[3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)|Two Pointers. array or HashSet to record|
|[4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)|getKth smallest value|
|[5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)|from center to expand to get longest Palindrome|
|[6. ZigZag Conversion](https://leetcode.com/problems/zigzag-conversion/)|step1=2n-2, step2=j+step1-2i|
|[7. Reverse Integer](https://leetcode.com/problems/reverse-integer/)|Math, Integer out range, use Double|
|[8. String to Integer (atoi)](https://leetcode.com/problems/string-to-integer-atoi/)|Math, Integer out range, use Double|
|[9. Palindrome Number](https://leetcode.com/problems/palindrome-number/)|Math, Reverse Integer, use Double|
|[10. Regular Expression Matching](https://leetcode.com/problems/regular-expression-matching/)|1.Backtracking,2.DP. discuss "a*"|
|[11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)|Two Pointers. comparing with #42|
|[12. Integer to Roman](https://leetcode.com/problems/integer-to-roman/)|Array to store symbol and value|
|[13. Roman to Integer](https://leetcode.com/problems/roman-to-integer/)|HashMap to store symbol and value|
|[14. Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)|First str as prefix, compare one by one|
|[15. 3Sum](https://leetcode.com/problems/3sum/)|Sort first, one scan outer, other two inner pointers, skip duplicates|
|[16. 3Sum Closest](https://leetcode.com/problems/3sum-closest/)|use diff|
|[17. Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)|DFS|
|[18. 4Sum](https://leetcode.com/problems/4sum/)|Two Pointers|
|[19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)|Fast-Slow Pointers, Count to find Kth pointer|
|[20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)|HashMap to record|
|[21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)|Iterative, Recursive|
|[22. Generate Parentheses](https://leetcode.com/problems/generate-parentheses/)|Open-Close pointers|
|[23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)|1.Merge Sort 2.PQ|
|[24. Swap Nodes in Pairs](https://leetcode.com/problems/swap-nodes-in-pairs/)|Fast-Slow Pointers|
|[25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)|Recursive|
|[26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)|Fast-Slow Pointers|
|[27. Remove Element](https://leetcode.com/problems/remove-element/)|Fast-Slow Pointers|
|[28. Implement strStr()](https://leetcode.com/problems/implement-strstr/)|Two Pointers|
|[29. Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)|Binary Search|
|[30. Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)|Sliding Window|
|[31. Next Permutation](https://leetcode.com/problems/next-permutation/)|Array|
|[32. Longest Valid Parentheses](https://leetcode.com/problems/longest-valid-parentheses/)|DP|
|[33. Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)|Binary Search, Ite, Rec|
|[34. Search for a Range](https://leetcode.com/problems/search-for-a-range/)|Binary Search|
|[35. Search Insert Position](https://leetcode.com/problems/search-insert-position/)|Binary Search|
|[36. Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)|Array|
|[37. Sudoku Solver](https://leetcode.com/problems/sudoku-solver/)|DFS|
|[38. Count and Say](https://leetcode.com/problems/count-and-say/)|String|
|[39. Combination Sum](https://leetcode.com/problems/combination-sum/)|DFS|
|[40. Combination Sum II](https://leetcode.com/problems/combination-sum-ii/)|DFS|
|[41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/)|Array|
|[42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)|Two Pointers/Stack. comparing with #11|
|[43. Multiply Strings](https://leetcode.com/problems/multiply-strings/)|Math, String|
|[44. Wildcard Matching](https://leetcode.com/problems/wildcard-matching/)|DP/Two Pointers, see #10|
|[45. Jump Game II](https://leetcode.com/problems/jump-game-ii/)|Greedy|
|[46. Permutations](https://leetcode.com/problems/permutations/)|DFS|
|[47. Permutations II](https://leetcode.com/problems/permutations-ii/)|DFS|
|[48. Rotate Image](https://leetcode.com/problems/rotate-image/)|Array|
|[49. Group Anagrams](https://leetcode.com/problems/anagrams/)|Sort and HashMap|
|[50. Pow(x, n)](https://leetcode.com/problems/powx-n/)|Binary Search, see #29|

Common Snippets:
+ `reverse(int x)`
+ `isPalindrome(String str)`
+ `swap(int[], int i, int j)`

FB & GG intersection List:

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
17
18
19
20
21
22
23
24
25
26
27
28
29
30
31
32
33
34
36
37
38
39
41
42
43
44
46
48
49
50
51
52
53
54
55
56
57
59
60
62
63
65
66
67
68
69
70
71
72
73
74
75
76
77
78
79
80
81
84
85
88
91
92
94
98
99
100
101
102
103
104
105
106
107
108
109
110
111
112
113
114
116
117
118
121
122
123
124
125
126
127
128
129
130
133
136
137
138
139
140
141
143
144
145
146
148
151
152
153
154
155
157
158
159
160
161
162
163
166
167
168
169
173
175
176
180
181
184
185
189
190
191
195
198
199
200
202
206
207
208
209
210
211
212
214
215
218
220
221
222
224
226
227
228
230
234
235
236
238
239
240
242
246
247
248
249
251
252
253
257
259
261
265
266
268
269
270
271
273
274
277
278
279
280
281
282
283
285
286
287
291
295
296
297
298
300
301
303
304
305
307
308
310
311
314
315
316
317
319
322
324
325
326
327
329
332
334
336
337
340
341
344
345
346
347
348
349
350
358
359
360
361
363
371
377
378
380
381
382
383
384
386
387
392
393
394
395
398
399
402
403
404
407
408
410
412
413
414
415
416
417
419
426
428
435
438
440
443
445
448
449
450
452
463
468
480
489
490
493
494
496
498
505
518
523
524
525
528
529
535
536
540
543
545
549
556
560
564
567
568
572
617
621
622
628
632
636
637
640
642
647
653
658
662
665
674
678
680
681
686
687
688
689
692
694
695
703
708
713
714
716
721
722
724
726
733
743
745
750
752
766
767
772
785
791
792
794
843
844
852
863
872
889
935
938
939
968
973
977
981
986
987
1027
