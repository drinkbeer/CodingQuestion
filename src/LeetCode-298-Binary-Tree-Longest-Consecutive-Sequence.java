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
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        
        int[] globalMax = new int[]{0};
        longestConsecutive(root, 0, globalMax, root.val);
        return globalMax[0];
    }
    
    private void longestConsecutive(TreeNode root, int currMax, int[] globalMax, int target) {
        if (root.val == target) {
            currMax++;
        } else {
            currMax = 1;
        }
        
        globalMax[0] = Math.max(globalMax[0], currMax);
        
        if (root.left != null) longestConsecutive(root.left, currMax, globalMax, root.val + 1);
        if (root.right != null) longestConsecutive(root.right, currMax, globalMax, root.val + 1);
    }
}
