/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    /*
    https://leetcode.com/problems/binary-tree-cameras/discuss/211966/Super-Clean-Java-solution-beat-100-DFS-O(n)-time-complexity
    
    Time complexity is O(n), space complexity is O(logn) considering system stack space.
    
    https://leetcode.com/problems/binary-tree-cameras/discuss/211180/JavaC%2B%2BPython-Greedy-DFS
    
    
    */
    private int NONE = 0;
    private int COVERED_NO_CAMERA = 1;
    private int COVERED_CAMERA = 2;
    int res = 0;
    public int minCameraCover(TreeNode root) {
        int top = dfs(root);
        return res + (top == NONE ? 1 : 0);
    }
    
    private int dfs(TreeNode node) {
        if (node == null) return COVERED_NO_CAMERA;
        
        int left = dfs(node.left);
        int right = dfs(node.right);
        
        if (left == COVERED_NO_CAMERA && right == COVERED_NO_CAMERA) {
            return NONE;
        }
        if (left == NONE || right == NONE) {
            // means leaf
            res++;
            return COVERED_CAMERA;
        }
        return COVERED_NO_CAMERA;
    }
}
