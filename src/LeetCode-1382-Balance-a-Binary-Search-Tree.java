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
    public TreeNode balanceBST(TreeNode root) {
        // In-order traversal
        List<Integer> nodes = new ArrayList<>();
        if (root == null) return null;
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                
                nodes.add(curr.val);
                curr = curr.right;
            }
        }
        
        Integer[] arr = nodes.toArray(new Integer[nodes.size()]);
        return buildTree(arr, 0, arr.length - 1);
    }
    
    private TreeNode buildTree(Integer[] arr, int i, int j) {
        if (i > j) return null;
        if (i == j) return new TreeNode(arr[i]);
        
        
        int mid = i + (j - i) / 2;
        TreeNode curr = new TreeNode(arr[mid]);
        curr.left = buildTree(arr, i, mid - 1);
        curr.right = buildTree(arr, mid + 1, j);
        
        return curr;
    }
    
}
