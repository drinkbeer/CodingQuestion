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
    // 1. DFS, similar to Maximum Depth of Tree: https://github.com/drinkbeer/CodingQuestion/blob/master/src/LeetCode-104-Maximum-Depth-of-Binary-Tree.java
    // http://rainykat.blogspot.com/2016/12/leetcodelinkedin-366-find-leaves-of.html
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        dfs(root, result);
        return result;
    }
    
    private int dfs(TreeNode root, List<List<Integer>> result) {
        if (root == null) return -1;
        
        int height = Math.max(dfs(root.left, result), dfs(root.right, result)) + 1;
        if (result.size() < height + 1) result.add(new ArrayList<Integer>());
        result.get(height).add(root.val);
        return height;
    }
}
