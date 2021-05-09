
https://www.geeksforgeeks.org/bfs-vs-dfs-binary-tree/
https://github.com/drinkbeer/CodingQuestion/blob/master/src/LeetCode-144-Binary-Tree-Preorder-Traversal.java
https://github.com/drinkbeer/CodingQuestion/blob/master/src/LeetCode-94-Binary-Tree-Inorder-Traversal.java
https://github.com/drinkbeer/CodingQuestion/blob/master/src/LeetCode-145-Binary-Tree-Postorder-Traversal.java
https://github.com/drinkbeer/CodingQuestion/blob/master/src/LeetCode-199-Binary-Tree-Right-Side-View.java


```

              1
            /    \
          2        3
        /   \
      4       5



BFS and DFSs of above Tree

Breadth First Traversal : 1 2 3 4 5

Depth First Traversals:
      Preorder Traversal : 1 2 4 5 3 
      Inorder Traversal  :  4 2 5 1 3 
      Postorder Traversal : 4 5 2 3 1
```

BFS：
1.用来判断可行解的存在性问题(存在一个解，任务完成)
2.可行解的解空间的最小性问题(我们会像Binary Tree 的BFS的过程，也是得到了一个path，BFS可以用来处理path的最小长度，Leetcode - 127 Word Ladder就是一个很好的例子)

DFS：
用来在全部的解空间中寻找所有的可行解(或许需要满足一定性质的可行解)

即DFS侧重于解的完备性，BFS侧重解的存在性与长度最短(当然对于遍历数据结构这样不求解的过程其实没什么差异)

## DFS
Time Complexity: **O(N)**  
Space Complexity: **O(H)** (H is the maximum height of the Tree. For a Binary Tree, the height is O(logN))

The follow types of problems can be solved by DFS:
1. Return a series of data (an array, a list): return all possible results/paths.
2. State change: from one node to another node, and the change can be revoked back. (In memory, using a Stack structure)

BFS/DFS is most likely happens in Tree/Graph/Array/List, however it could also happens in String.

Key:
1. Optimization Strategy (Pruning)
2. Memorization (using extra space)
3. Divide & Conquer

## BFS
Time Complexity: **O(N)**  
Space Complexity: **O(W)** (W is the maximum width of the Tree)

Key:
1. Extend BFS to level order traversal, unweighted shortest path (in Graph)
2. BFS in Graph could extend to Shortest Path Faster Algorithm (SPFA), Dijkstra (with Heap).

## Template

```
    private class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }
```

DFS PreOrder Traversal Template

```
    private void dfsPreOrder(Node root) {
        // process the root node
        if (root.left != null) dfsPreOrder(root.left);
        if (root.right != null) dfsPreOrder(root.right);
    }

    private void dfsPreOrderUsingStack(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            Node curr = stack.pop();

            // process the curr Node now, e.g. result.add(curr.val);

            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }
```

DFS InOrder Traversal Template
```
    private void dfsInOrder(Node root) {
        if (root.left != null) dfsPreOrder(root.left);
        // process the root node
        if (root.right != null) dfsPreOrder(root.right);
    }

    private void dfsInOrderUsingStack(Node root) {
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while(curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();

                // process the curr Node now, e.g. result.add(curr.val);

                curr = curr.right;
            }
        }
    }
```

DFS PostOrder Traversal Template
```
    private void dfsPostOrder(Node root) {
        if (root.left != null) dfsPreOrder(root.left);
        if (root.right != null) dfsPreOrder(root.right);
        // process the root node
    }

    private void dfsPostOrderUsingTwoStacks(Node root) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> out = new Stack<>();
        stack.push(root);

        // The input order of "stack" is: root -> left -> right
        // The input order of "out" is: root -> right tree -> left tree, so the output order of "out" is: left -> right -> root
        while(!stack.isEmpty()) {
            Node curr = stack.pop();
            out.push(curr);

            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }

        while(!out.isEmpty()) {
            // do the operation to the elements in out here. e.g. result.add(out.pop().val);
        }
    }
```

BFS Template

```
    private void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();

            // do the operation to curr Node

            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
        }
    }
```

```
    private void bfsRecursive(Node root) {
        bfsRecursive(root, 0);
    }

    private void bfsRecursive(Node curr, int level) {
        // process the curr node, e.g. result.add(level, root.val);

        if (curr.left != null) bfsRecursive(curr.left, level + 1);
        if (curr.right != null) bfsRecursive(curr.right, level + 1);
    }
```

### Build Graph

https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

Building a graph represented by HashMap<Integer, List<Integer>>.
```
    private HashMap<Integer, List<Integer>> buildGraph(int[][] prerequisites) {
        // Construct graph
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];

            if (!map.containsKey(from)) {
                map.put(from, new ArrayList<Integer>());
            }

            List<Integer> list = map.get(from);
            list.add(to);
            map.put(from, list);
        }

        return map;
    }
```

Building a graph represented by int[][] array.
```

```

#### 785. Is Graph Bipartite?
https://leetcode.com/problems/is-graph-bipartite/

```
class Solution {
    // 1. DFS
    /*
    The proof is the following: A bipartite graph can be divided into two sets of vertices which are disjoint and exhaustive such that there are no edges between the two sets.

    Assign one colour each to the set. This is possible because there are no edges between vertices in the same set in a bipartite graph.

    Hence, if we arrive at an edge which is between two different colours, we return false, else return true.
    */
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
        
//         int[] colors = new int[n];
//         for (int i = 0; i < n; i++) {
//             if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
//                 return false;
//             }
//         }
//         return true;
//     }
    
//     private boolean validColor(int[][] graph, int[] colors, int color, int node) {
//         if (colors[node] != 0) {
//             return colors[node] == color;
//         }
        
//         colors[node] = color;
//         for (int to : graph[node]) {
//             if (!validColor(graph, colors, -color, to)) {
//                 return false;
//             }
//         }
//         return true;
//     }
    
    // 2. BFS
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
//         int[] colors = new int[n];

//         for (int i = 0; i < n; i++) {
//             if (colors[i] != 0) continue;
            
//             Queue<Integer> queue = new LinkedList<>();
//             queue.offer(i);
//             colors[i] = 1;
            
//             while (!queue.isEmpty()) {
//                 int size = queue.size();
//                 for (int j = 0; j < size; j++) {
//                     int curr = queue.poll();
//                     for (int to : graph[curr]) {
//                         if (colors[to] == 0) {
//                             colors[to] = -colors[curr];
//                             queue.offer(to);
//                         } else if (colors[to] != -colors[curr]) {
//                             return false;
//                         }
//                     }
//                 }
//             }
//         }
//         return true;
//     }
    
    // BFS (Optimized by removing the size)
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) continue;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;
            
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int to : graph[curr]) {
                    if (colors[to] == 0) {
                        colors[to] = -colors[curr];
                        queue.offer(to);
                    } else if (colors[to] != -colors[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
```

# Reference
1. https://www.1point3acres.com/bbs/thread-556386-1-1.html
