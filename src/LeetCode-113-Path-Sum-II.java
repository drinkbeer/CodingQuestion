/*
LeetCode: https://leetcode.com/problems/path-sum-ii/
LintCode: http://www.lintcode.com/problem/path-sum-ii/
JiuZhang: http://www.jiuzhang.com/solutions/path-sum-ii/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-path-sum-ii-java/

Analysis:
DFS. Notice, the value the of sum, should - root.val.
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;     // sum could be positive or 0, for instance, sum=-5 [-2,null,-3]
                                            // sum=0 [7,0,null,-1,-6,null,1,null,null,-7]
        
        List<Integer> set = new ArrayList<Integer>();
        set.add(root.val);
        DFS(root, sum - root.val, result, set);
        return result;
    }
    
    private void DFS(TreeNode root, int sum, List<List<Integer>> result, List<Integer> set){
        // end condition
        if(sum == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<Integer>(set));
            return;
        }
        
        if(root.left != null){
            set.add(root.left.val);
            DFS(root.left, sum - root.left.val, result, set);
            set.remove(set.size() - 1);
        }
        
        if(root.right != null){
            set.add(root.right.val);
            DFS(root.right, sum - root.right.val, result, set);
            set.remove(set.size() - 1);
        }
    }
    
}