/*
LeetCode: https://leetcode.com/problems/minimum-depth-of-binary-tree/
LintCode: 
JiuZhang: 
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-minimum-depth-of-binary-tree-java/

Analysis:
Depth: # of nodes from root to the leaf(leaf is node whose both right and left are null)

1.DFS(backstrap)
easy
2.BFS(Iterative)
level order traversal and find the first leaf's height (using a count variable as height).

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // DFS
    // public int minDepth(TreeNode root) {
    //     if(root == null) return 0;
        
    //     // Find leaf
    //     if(root.left == null && root.right == null) return 1;
        
    //     // if left or right is not null, so it's not leaf
    //     if(root.left == null) return  minDepth(root.right) + 1;
    //     else if(root.right == null) return minDepth(root.left) + 1;
    //     else return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    // }
    
    // BFS
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int count = 1;
        
        while(!queue.isEmpty()){
            // List<TreeNode> level = new ArrayList<TreeNode>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left == null && curr.right == null) return count;
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            count++;
        }
        
        return count;
    }
}
