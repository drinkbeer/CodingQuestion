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


class Solution {
    // 1.DFS
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        
        pathSum(root, sum - root.val, result, list);
        
        return result;
    }
    
    private void pathSum(TreeNode node, int sum, List<List<Integer>> result, List<Integer> list) {
        if (node.left == null && node.right == null && sum == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        
        if (node.left != null) {
            list.add(node.left.val);
            pathSum(node.left, sum - node.left.val, result, list);
            list.remove(list.size() - 1);
        }
        
        if (node.right != null) {
            list.add(node.right.val);
            pathSum(node.right, sum - node.right.val, result, list);
            list.remove(list.size() - 1);
        }
    }
    
    
    // 2.DFS (a bit complex)
//     public List<List<Integer>> pathSum(TreeNode root, int sum) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         if (root == null) return result;
        
//         pathSum(root, sum, result, new ArrayList<Integer>());
//         return result;
//     }
    
//     private void pathSum(TreeNode node, int sum, List<List<Integer>> result, List<Integer> list) {
//         if (node.left == null && node.right == null) {
//             // node is a leaf
//             if (sum == node.val) {
//                 list.add(node.val);
//                 result.add(new ArrayList<Integer>(list));
//                 list.remove(list.size() - 1);
//             }
            
//             return;
//         }
        
//         // node is not a leaf, proceed to next level
//         list.add(node.val);
//         if (node.left != null) {
//             pathSum(node.left, sum - node.val, result, list);
//         }
//         if (node.right != null) {
//             pathSum(node.right, sum - node.val, result, list);
//         }
//         // remove the node from the list, so we could forback
//         list.remove(list.size() - 1);
//     }
    
    // 3.BFS
    /*
    We have to use a queue to do level order traversal, and using another queue to record every path.
    The queue to record every path is too Space Consuming. So BFS is not a good solution here.
    */
}
