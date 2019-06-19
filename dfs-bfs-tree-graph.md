
https://www.geeksforgeeks.org/bfs-vs-dfs-binary-tree/

https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

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

DFS
Time Complexity: **O(N)**  
Space Complexity: **O(H)** (H is the maximum height of the Tree. For a Binary Tree, the height is O(logN))

BFS
Time Complexity: **O(N)**  
Space Complexity: **O(W)** (W is the maximum width of the Tree)

DFS Template

```

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

