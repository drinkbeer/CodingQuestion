/*
LeetCode: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
LintCode: http://www.lintcode.com/problem/binary-tree-zigzag-level-order-traversal/
JiuZhang: http://www.jiuzhang.com/solutions/binary-tree-zigzag-level-order-traversal/
ProgramCreek: not find

Analysis: 
BFS
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
    // BFS
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        boolean isNormal = true;
        currLevel.push(root);
        
        while(!currLevel.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            Stack<TreeNode> nextLevel = new Stack<TreeNode>();

            while(!currLevel.isEmpty()){
                TreeNode node = currLevel.pop();
                list.add(node.val);
                
                if(isNormal){
                    if(node.left != null) nextLevel.push(node.left);
                    if(node.right != null) nextLevel.push(node.right);
                }else{
                    if(node.right != null) nextLevel.push(node.right);
                    if(node.left != null) nextLevel.push(node.left);
                }
            }
            result.add(new ArrayList(list));
            isNormal = !isNormal;
            
            currLevel = nextLevel;
        }
        return result;
    }
}