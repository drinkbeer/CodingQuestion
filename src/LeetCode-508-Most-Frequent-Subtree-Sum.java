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
    // DFS, similar to: https://leetcode.com/problems/find-mode-in-binary-search-tree/
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) return new int[0];
        
        Map<Integer, Integer> map = new HashMap<>();
        int[] max = new int[] {0};
        dfs(root, map, max);
        
        List<Integer> res = new ArrayList<Integer>();
        for (int key : map.keySet()) {
            if (map.get(key) == max[0]) {
                res.add(key);
            }
        }
        
        return res.stream().mapToInt(i -> i).toArray();
    }
    
    private int dfs(TreeNode root, Map<Integer, Integer> map, int[] max) {
        if (root == null) return 0;
        int sum = dfs(root.left, map, max) + dfs(root.right, map, max) + root.val;
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max[0] = Math.max(max[0], map.get(sum));
        return sum;
    }
}
