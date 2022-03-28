/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<Integer> level = new ArrayDeque<>();
        
        queue.offer(root);
        level.offer(0);
        
        int max = 0;
        while (!queue.isEmpty() && !level.isEmpty()) {
            max = Math.max(max, level.peekLast() - level.peekFirst() + 1);
            
            int len = queue.size();
            
            for (int i = 0; i < len; i++) {
                TreeNode curr = queue.poll();
                int l = level.poll();
                
                if (curr.left != null) {
                    queue.offer(curr.left);
                    level.offer(l * 2);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    level.offer(l * 2 + 1);
                }
            }
        }
        
        return max;
    }
}
