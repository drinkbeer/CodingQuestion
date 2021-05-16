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
    TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        Set<Integer> targetNodes = new HashSet<>();
        for (int i = 0; i < nodes.length ; i++) {
            targetNodes.add(nodes[i].val);
        }
        dfs(root, targetNodes);
        return lca;
    }
    
    private int dfs(TreeNode root, Set<Integer> nodes) {
        if (root == null) return 0;
        
        int leftCount = dfs(root.left, nodes);
        int rightCount = dfs(root.right, nodes);
        int count = leftCount + rightCount;
        if (nodes.contains(root.val)) {
            count++;
        }
        
        if (count == nodes.size() && lca == null) {
            lca = root;
        }
        
        return count;
    }
}
