/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
/*

Inorder successor could be categorized to two types:

1.If it has right node, then inorder successor is the left most node in right tree.
2.If it doesn't have right node, then the inorder successor is the first ancestor node that is larger than the node.

Analysis: https://www.cnblogs.com/grandyang/p/10424982.html

Similar to : https://github.com/drinkbeer/CodingQuestion/blob/master/src/LeetCode-285-Inorder-Successor-in-BST.java
*/
class Solution {
    public Node inorderSuccessor(Node x) {
        if (x == null) return null;
        
        Node node = x;
        if (node.right == null) {
            // now it means node is in the left tree
            // find the first ancestor node that is larger than the node.
            while (node.parent != null) {
                if (node.parent.val > x.val) {
                    return node.parent;
                } else {
                    node = node.parent;
                }
            }
            return null;
        } else {
            // find the left most node in the right tree.
            if (node.right == null) return null;
            node = node.right;
            while (node.left != null) node = node.left;
            return node;
        }
    }
}
