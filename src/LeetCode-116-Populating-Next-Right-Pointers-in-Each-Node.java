/*
LeetCode: https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
LintCode: http://www.lintcode.com/problem/populating-next-right-pointers-in-each-node/
JiuZhang: http://www.jiuzhang.com/solutions/populating-next-right-pointers-in-each-node/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-populating-next-right-pointers-in-each-node-java/
Other: http://www.cnblogs.com/yuzhangcmu/p/4041341.html

Analysis: 

*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        
        TreeLinkNode parent = root;
        TreeLinkNode next = root.left;
        while(parent != null && next != null){
            TreeLinkNode prev = null;
            while(parent != null){
                if(prev == null){
                    prev = parent.left;
                }else{
                    prev.next = parent.left;
                    prev = prev.next;
                }
                prev.next = parent.right;
                prev = prev.next;
                parent = parent.next;
            }
            parent = next;
            next = parent.left;
        }
    }
    
    // 1. BFS (do level order traversal, but add a prev node)
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
