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
//     public Node connect(Node root) {
//         if (root == null) return root;
        
//         Queue<Node> queue = new LinkedList<>();
//         queue.offer(root);
        
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             Node prev = null;
            
//             for (int i = 0; i < size; i++) {
//                 Node curr = queue.poll();
//                 if (prev != null) {
//                     prev.next = curr;
//                 }
//                 prev = curr;
                
//                 if (curr.left != null) queue.offer(curr.left);
//                 if (curr.right != null) queue.offer(curr.right);
//             }
//         }
        
//         return root;
//     }
    
    // Level order traversal
    public Node connect(Node root) {
        if (root == null) return root;
        
        Node levelCurr = root;
        while (levelCurr != null) {
            Node dummy = new Node(-1);
            Node prev = dummy;
            
            while (levelCurr != null) {
                if (levelCurr.left != null) {
                    prev.next = levelCurr.left;
                    prev = prev.next;
                }
                if (levelCurr.right != null) {
                    prev.next = levelCurr.right;
                    prev = prev.next;
                }
                
                levelCurr = levelCurr.next;
            }
            
            levelCurr = dummy.next;
        }
        
        return root;
    }
}
