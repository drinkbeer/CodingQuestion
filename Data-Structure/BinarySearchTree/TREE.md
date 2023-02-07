

# Contents

+ [Binary Tree]
+ [Binary Search Tree]
+ [Heap]
+ [Binary Index Tree]
+ [Segment Tree]
+ [B+ Tree]
+ [Read-Black Tree]
+ [AVL Tree]
+ [Cartesian Tree]
+ [Trie - Dictionary Tree]

## Binary Tree
+ Idea
    - A tree with at most 2 children.

+ Representative
    - Nodes with data, pointers to two children.
    - [Array implementation](https://www.geeksforgeeks.org/binary-tree-array-implementation/) (if root index starts from 0, left child index is `2*n + 1`, right child index is `2*n + 2`; if root index starts from 1, left child index is `2*n`, right index is `2*n + 1`)

+ [Properties](https://www.geeksforgeeks.org/binary-tree-set-2-properties/)
    - Level l, root level is 0. The maximum number of nodes on level l is the nth power of 2, `2^n`.
    - The height of a tree is the maximum number of ndoes on the root to leaf path. So the height of a tree with only one node is 1. The maximum number of nodes in a binary tree of height `h` is hth power of 2 minus 1, `2^h - 1`.
    - The height of binary tree, best case `O(LogN)`, worst case `O(N)`.
    - In a binary tree with N nodes, the minimum possible height is `Log2(N+1)`.
    - A binary tree with L leaves has a least `Log2(L) + 1` levels.
    - In a binary tree where every node has 0 or 2 children, the number of leaf nodes is always one more than nodes with two children. `S(n - 1) = 2^n - 1`，可以用公比为2的等比求和公式推导出来。

+ [Type of binary Tree](https://www.geeksforgeeks.org/binary-tree-set-3-types-of-binary-tree/)
    - Full Binary Tree
        - Every node has 0 or 2 children.
    - Complete Binary Tree
        - All levels are completely filled, except the last level, the last level has all nodes as left as possible.
    - Perfect Binary Tree
        - a tree that has all the internal nodes have two children and all leaf nodes are the the same level.
    - Balanced Binary Tree
        - A binary tree is balanced if the height of the tree is `O(logN)`. For Example, the AVL tree maintains O(Log n) height by making sure that the difference between the heights of the left and right subtrees is at most 1. Red-Black trees maintain O(Log n) height by making sure that the number of Black nodes on every root to leaf paths is the same and there are no adjacent red nodes. Balanced Binary Search trees are performance-wise good as they provide O(log n) time for search, insert and delete.
    - A degenerate (or pathological) tree
        - A degenerate (or pathological) tree A Tree where every internal node has one child. Such trees are performance-wise same as linked list.

+ Traversals
    - In-order traversal
    - Pre-order traversal
    - Post-order traversal
    - Level-order traversal
    - Time Complexity: All the four traversal is O(N)
    - Space Complexity: Level Order traversal requires O(W), W is the maximum width of Binary Tree. For In/Pre/Post order traversal, the Space Complexity is O(H), H is the height of the tree.

+ [BFS vs DFS in Binary Tree](https://www.geeksforgeeks.org/bfs-vs-dfs-binary-tree/)
    - Extra space allowed?
        - Usually, if a tree is balanced, level-order traversal requires more space, so in/pre/post order is better; if a tree is more pathological tree, then in/pre/post order traversal requires more space, so level-order traversal is better.
    - Recursive DFS requires function call overheads.
    - BFS starts visiting nodes from root, while DFS starts visiting nodes from leaves. So if our problem is to search something that is more likely to closer to root, we prefer BFS. If the target node is close to a leaf, we would prefer DFS.


+ Links
    - https://www.geeksforgeeks.org/binary-tree-data-structure/

## Binary Search Tree
+ Idea
    - All nodes in left tree with value smaller than the node's value
    - All nodes in right tree with value larger than the node's value
    - The left and right subtree must also be a binary search tree

+ Search
    - If implemented by array or nodes, searching in BST is the same as binary search.
    - Time Complexity: avg O(H), worst O(N)

+ Insertion
    - Search the value until hit a leaf, the new node is added as a child of the leaf.
    - Time Complexity: avg O(H), worst O(N)

+ Delete
    - If deleted node is leaf, simply remove from tree
    - If deleted node has one child, copy the child to the node, and delete the child. Or delete current node, and make child replace current node.
    - If deleted node has two children. Find the inorder successor of the node. Copy contents of the inorder successor to the node and delete the inorder successor. Another way is to replace current node with inorder predecessor.

+ [BST vs HashTable](https://www.geeksforgeeks.org/advantages-of-bst-over-hash-table/)
    - BST has all keys sorted by doing in-order traversal. It's difficult to sort in HashTbale.
    - Order statistics, find the closest lower and higher elements, doing range queries are easy in BST.
    - BST are easyer to implement than hashing.
    - Self-balanced BST (like Red-Black Tree, AVL Tree, Splay Tree), all operations are guaranteed O(LogN). Hashing can do Search/Insert/Delete in avg O(1), but the worst case is O(N^2), especially when table resizing happens.

+ Reference
    - https://www.geeksforgeeks.org/binary-search-tree-data-structure/


## Heap
+ Idea
    - Heap is a spacial complete binary tree with order.
    - For Max Heap, its value is larger than two children.
    - For Min Heap, its value is smaller than two children.

+ Analysis
    - Time:
        - Heapify operation is `O(LogN)`, so building a heap is `O(NLogN)`
        - Search: `O(N)`
        - Insert: `O(LogN)`
        - Delete: `O(LogN)`
        - Min Heap's Get Min: `O(1)`
    - Space:

+ Application
    - no

+ Implementation
See [Sort.md - Heap Sort](../Sort/SORT.md), and [Heap.java](../PriorityQueue/Heap.java)

+ Reference
    - https://www.geeksforgeeks.org/heap-data-structure/

## Trie
See [trie.md](../String/TRIE.md)


# Reference
1. https://www.programiz.com/dsa/trees
