/*
LeetCode: https://leetcode.com/problems/unique-binary-search-trees-ii/
LintCode: http://www.lintcode.com/problem/unique-binary-search-trees-ii/
JiuZhang: http://www.jiuzhang.com/solutions/unique-binary-search-trees-ii/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-unique-binary-search-trees-ii-java/

Analysis: 
Not understand thoroughly
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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<TreeNode>();
        
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        
        if(start > end){
            result.add(null);
            return result;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);
            
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    result.add(node);
                }
            }
        }
        
        return result;
    }
    
}