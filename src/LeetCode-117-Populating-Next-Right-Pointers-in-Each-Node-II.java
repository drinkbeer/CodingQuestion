/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    // BFS
    // Do level order traversal, the same solution as  (https://leetcode.com/problems/populating-next-right-pointers-in-each-node/)
    public Node connect(Node root) {
        if (root == null) return null;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            Node prev = null;
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                Node curr = queue.poll();
                if (prev != null) {
                    prev.next = curr;
                }
                prev = curr;
                
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                
                curr.next = null;
            }
            
        }
        
        return root;
    }
}
