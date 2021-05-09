/*
LeetCode: https://leetcode.com/problems/path-sum-ii/
LintCode: http://www.lintcode.com/problem/path-sum-ii/
JiuZhang: http://www.jiuzhang.com/solutions/path-sum-ii/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-path-sum-ii-java/

Analysis:
DFS. Notice, the value the of sum, should - root.val.

The value could be negative value, e.g.
[-2,null,-3]
-5

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
    // 1.DFS (Recursive)
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        recursive(root, sum, result, new ArrayList<>());
        return result;
    }
    
    public void recursive(TreeNode curr, int sum, List<List<Integer>> result, List<Integer> list) {
        if (curr.left == null && curr.right == null) {
            if (curr.val == sum) {
                list.add(curr.val);
                result.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
            }
            return;
        }
        
        list.add(curr.val);
        if (curr.left != null) recursive(curr.left, sum - curr.val, result, list);
        if (curr.right != null) recursive(curr.right, sum - curr.val, result, list);
        list.remove(list.size() - 1);
    }

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
