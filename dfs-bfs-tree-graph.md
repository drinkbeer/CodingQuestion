
https://www.geeksforgeeks.org/bfs-vs-dfs-binary-tree/
https://github.com/drinkbeer/CodingQuestion/blob/master/src/LeetCode-144-Binary-Tree-Preorder-Traversal.java
https://github.com/drinkbeer/CodingQuestion/blob/master/src/LeetCode-94-Binary-Tree-Inorder-Traversal.java
https://github.com/drinkbeer/CodingQuestion/blob/master/src/LeetCode-145-Binary-Tree-Postorder-Traversal.java


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

https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
