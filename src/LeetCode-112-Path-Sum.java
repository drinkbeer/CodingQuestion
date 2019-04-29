/*
LeetCode: https://leetcode.com/problems/path-sum/
LintCode: http://www.lintcode.com/problem/path-sum/
JiuZhang: http://www.jiuzhang.com/solutions/path-sum/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-path-sum/

Analysis: 
1.DFS

2.BFS
level order traversal, and find sum to the leaf
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
    // 1. DFS
    // public boolean hasPathSum(TreeNode root, int sum) {
    //     if(root == null) return false;
        
    //     return DFS(root, sum, root.val);
    // }
    
    // private boolean DFS(TreeNode root, int sum, int curr){
    //     if(root.left == null && root.right == null && sum == curr){
    //         return true;
    //     }
        
    //     boolean left = false;
    //     if(root.left != null) left = DFS(root.left, sum, curr + root.left.val);
    //     boolean right = false;
    //     if(root.right != null) right = DFS(root.right, sum, curr + root.right.val);
        
    //     return left || right;
    // }
    
    // 2.A simpler DFS
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        
        if(root.left == null && root.right == null && root.val == sum) return true;
        
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    
    // 3.BFS
    
}


class Solution {
    // 1.DFS
//     public boolean hasPathSum(TreeNode root, int sum) {
//         if (root == null) return false;
        
//         return hasPathSum(root, sum, 0);
//     }
    
//     private boolean hasPathSum(TreeNode root, int target, int preSum) {
        
//         // find leaf
//         if (root.left == null && root.right == null) {
//             if (root.val + preSum == target) return true;
//             else return false;
//         }
        
//         if (root.left == null) return hasPathSum(root.right, target, preSum + root.val);
//         if (root.right == null) return hasPathSum(root.left, target, preSum + root.val);
//         return hasPathSum(root.left, target, preSum + root.val) || hasPathSum(root.right, target, preSum + root.val);
//     }
    
    // 2.DFS(easier one)
//     public boolean hasPathSum(TreeNode root, int sum) {
//         if (root == null) return false;
        
//         if (root.left == null && root.right == null && root.val == sum) return true;
        
//         return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//     }
    
    // 3.BFS (level order traversal, and find sum to the leaf)
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> sumList = new LinkedList<>();
        queue.add(root);
        sumList.add(0);
        
        while(!queue.isEmpty()) {
            // process one level
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                int val = sumList.poll();
                
                if (curr.left == null && curr.right == null && (val + curr.val) == sum) return true;
                
                if (curr.left != null) {
                    queue.add(curr.left);
                    sumList.add(val + curr.val);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    sumList.add(val + curr.val);
                }
            }
        }
        
        return false;
    }
}
