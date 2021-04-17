package BinarySearchTree;

import java.util.Stack;

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

  private static void dfsInOrderUsingStack(Node root) {
    Stack<Node> stack = new Stack<>();
    Node curr = root;


  }

  ////////// DFS PostOrder Traversal //////////
  private static void dfsPostOrder(Node root) {
    if (root.left != null) dfsPostOrder(root.left);
    if (root.right != null) dfsPostOrder(root.right);
    System.out.print(root.val + " ");
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

    System.out.print("\nDFS PreOrder: \n");
    dfsPreOrder(root);

    System.out.print("\nDFS PreOrder Using Stack: \n");
    dfsPreOrderUsingStack(root);

    System.out.print("\nDFS InOrder: \n");
    dfsInOrder(root);


    System.out.print("\nDFS PostOrder: \n");
    dfsPostOrder(root);
  }
}
