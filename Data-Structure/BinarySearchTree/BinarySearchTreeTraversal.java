package BinarySearchTree;

import java.util.Stack;

/**
 * Morris Traversal: https://leetcode.com/problems/binary-tree-postorder-traversal/discuss/45628/Morris-Traversal-Time-O(n)-Space-O(1)-inorder-preorder-postorder/182754/
 * The problem: https://www.1point3acres.com/bbs/thread-751052-1-1.html
 * Release a tree without extra sapce. (Solution: using Morris Post-order traversal)
 */
public class BinarySearchTreeTraversal {

  private static class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
      this.val = val;
    }
  }

  ////////// DFS PreOrder Traversal //////////

  private static void dfsPreOrder(Node root) {
    // process the root node
    System.out.print(root.val + " ");
    if (root.left != null) dfsPreOrder(root.left);
    if (root.right != null) dfsPreOrder(root.right);
  }

  private static void dfsPreOrderUsingStack(Node root) {
    Stack<Node> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node curr = stack.pop();

      System.out.print(curr.val + " ");

      if (curr.right != null) stack.push(curr.right);
      if (curr.left != null) stack.push(curr.left);
    }
  }

  ////////// DFS InOrder Traversal //////////
  private static void dfsInOrder(Node root) {
    if (root.left != null) dfsInOrder(root.left);
    System.out.print(root.val + " ");
    if (root.right != null) dfsInOrder(root.right);
  }

  /*

                     0
                  /    \
                 1      5
               /  \    /  \
              2    3  6    7
               \          /  \
               4         8    9

  curr - <stack>
  0 - <>
  1 - <0>
  2 - <0,1>
  null - <0,1,2>
  pop & process 2, curr = 4, <0,1>
  4, <0,1>
  null, <0,1,4>
  pop & process 4, curr = null, <0,1>
  pop & process 1, curr = 3, <0>
  3, <0>
  null, <0, 3>
  pop & process 3, curr = null, <0>
  pop & process 0, curr = 5, <>
  5, <>
  6, <5>
  null, <5, 6>
  pop & process 6, curr = null, <5>
  null, <5>
  pop & process 5, curr = 7, <>
  7, <>
  8, <7>
  null, <7,8>
  pop & process 8, curr = null, <7>
  null, <7>
  pop & process 7, curr = 9, <>
  9, <>
  null, <9>
  pop & process 9, curr = null, <>

  So finally result is: 2 4 1 3 0 6 5 8 7 9
  */
  private static void dfsInOrderUsingStack(Node root) {
    Stack<Node> stack = new Stack<>();
    Node curr = root;

    while (curr != null || !stack.isEmpty()) {
      if (curr != null) {
        stack.push(curr);
        curr = curr.left;
      } else {
        curr = stack.pop();
        // process curr
        System.out.print(curr.val + " ");
        curr = curr.right;
      }
    }
  }

  ////////// DFS PostOrder Traversal //////////
  private static void dfsPostOrder(Node root) {
    if (root.left != null) dfsPostOrder(root.left);
    if (root.right != null) dfsPostOrder(root.right);
    System.out.print(root.val + " ");
  }

  private static void dfsPostOrderUsingTwoStacks(Node root) {
    Stack<Node> stack = new Stack<>();
    Stack<Node> out = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      Node curr = stack.pop();
      out.push(curr);

      if (curr.left != null) stack.push(curr.left);
      if (curr.right != null) stack.push(curr.right);
    }

    while (!out.isEmpty()) {
      Node curr = out.pop();
      System.out.print(curr.val + " ");
    }
  }

  /*

                     0
                  /    \
                 1      5
               /  \    /  \
              2    3  6    7
               \          /  \
               4         8    9

  */
  private static Node buildTree() {
    Node root = new Node(0);
    Node n1 = new Node(1);
    Node n2 = new Node(2);
    Node n3 = new Node(3);
    Node n4 = new Node(4);
    Node n5 = new Node(5);
    Node n6 = new Node(6);
    Node n7 = new Node(7);
    Node n8 = new Node(8);
    Node n9 = new Node(9);

    root.left = n1;
    root.right = n5;
    n1.left = n2;
    n1.right = n3;
    n2.right = n4;
    n5.left = n6;
    n5.right = n7;
    n7.left = n8;
    n7.right = n9;

    return root;
  }

  public static void main(String[] args) {
    Node root = buildTree();

    System.out.print("\n\nDFS PreOrder: \n");
    dfsPreOrder(root);

    System.out.print("\n\nDFS PreOrder Using Stack: \n");
    dfsPreOrderUsingStack(root);

    System.out.print("\n\nDFS InOrder: \n");
    dfsInOrder(root);

    System.out.print("\n\nDFS InOrder Using Stack: \n");
    dfsInOrderUsingStack(root);

    System.out.print("\n\nDFS PostOrder: \n");
    dfsPostOrder(root);

    System.out.print("\n\nDFS PostOrder Using Two Stacks: \n");
    dfsPostOrderUsingTwoStacks(root);
  }

}
