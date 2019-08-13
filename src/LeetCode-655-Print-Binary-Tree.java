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
    // 1. Recursive
    /*
    https://leetcode.com/problems/print-binary-tree/discuss/106239/Java-Recursive-Solution
    */
//     public List<List<String>> printTree(TreeNode root) {
//         int row = getHeight(root);
//         int col = (int) Math.pow(2, row) - 1;
        
//         List<List<String>> res = new ArrayList<>();
//         List<String> ans = new ArrayList<>();
//         for (int i = 0; i < col; i++) ans.add("");
//         for (int i = 0; i < row; i++) res.add(new ArrayList<>(ans));
        
//         populateResult(root, res, 0, row, 0, col - 1);
//         return res;
//     }
    
//     private void populateResult(TreeNode root, List<List<String>> res, int currRow, int totalRow, int i, int j) {
//         if (root == null || currRow == totalRow) return;    // we reached the last line or we reached a null node
//         int idx = (i + j) / 2;
//         res.get(currRow).set(idx, String.valueOf(root.val));
//         populateResult(root.left, res, currRow + 1, totalRow, i, idx - 1);
//         populateResult(root.right, res, currRow + 1, totalRow, idx + 1, j);
//     }
    
//     private int getHeight(TreeNode root) {
//         if (root == null) return 0;
//         return 1 + Math.max(getHeight(root.left), getHeight(root.right));
//     }
    
    // 2. BFS (Level Order Traversal)
    /*
    https://leetcode.com/problems/print-binary-tree/discuss/106269/Java-Iterative-Level-Order-Traversal-with-Queue
    */
    public List<List<String>> printTree(TreeNode root) {
        int row = getHeight(root);
        int col = (int) Math.pow(2, row) - 1;
        
        List<List<String>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < col; i++) ans.add("");
        for (int i = 0; i < row; i++) res.add(new ArrayList<>(ans));
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<int[]> indexQ = new LinkedList<>();
        queue.offer(root);
        indexQ.offer(new int[]{0, col - 1});
        
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                int[] indices = indexQ.poll();
                
                int l = indices[0], r = indices[1];
                int mid = l + (r - l) / 2;
                res.get(level).set(mid, String.valueOf(curr.val));
                
                if (curr.left != null) {
                    queue.offer(curr.left);
                    indexQ.offer(new int[] {l, mid - 1});
                }
                
                if (curr.right != null) {
                    queue.offer(curr.right);
                    indexQ.offer(new int[] {mid + 1, r});
                }
            }
            level++;
        }
        
        return res;
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
