/*
1.DFS
http://www.shuatiblog.com/blog/2014/12/17/Print-Binary-Tree-Vertically/

[5,1,6,null,3,null,null,2,4]    ==>     [[1,2],[5,3],[4,6]] should be [[1,2],[5,3],[6,4]]

2.BFS
https://leetcode.com/discuss/75054/5ms-java-clean-solution
https://leetcode.com/discuss/78228/3ms-java-solution-beats-100%25

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
    // 1.DFS
//     public List<List<Integer>> verticalOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         if(root == null) return result;
        
//         // 1.Find the range of left bound and right bound
//         int[] range = new int[2];
//         findRange(root, 0, range);
        
//         // 2.init result, calculate level of each vertical line
//         int rootIndex = 0 - range[0];
//         int columns = range[1] - range[0] + 1;
//         for(int i = 0; i < columns; i++){
//             result.add(new ArrayList<Integer>());
//         }
        
//         DFS(root, rootIndex, result);
        
//         return result;
//     }
    
//     private void DFS(TreeNode root, int level, List<List<Integer>> result){
//         // end condition
//         if(root == null) return;
        
//         result.get(level).add(root.val);
        
//         DFS(root.left, level - 1, result);
//         DFS(root.right, level + 1, result);
//     }
    
//     // Use DFS to find range
//     private void findRange(TreeNode root, int level, int[] range){
//         if(root == null) return;
        
//         if(level < range[0]) range[0] = level;
//         if(level > range[1]) range[1] = level;
        
//         findRange(root.left, level - 1, range);
//         findRange(root.right, level + 1, range);
//     }
    
    // 2.BFS
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null) return result;
        
        // 1.Find the range of left bound and right bound
        int[] range = new int[2];
        findRange(root, 0, range);
        
        // 2.init result, calculate level of each vertical line
        int rootIndex = 0 - range[0];
        int columns = range[1] - range[0] + 1;
        for(int i = 0; i < columns; i++){
            result.add(new ArrayList<Integer>());
        }
        
        // 3.Use BFS to calculate result
        Queue<TreeNode> nodes = new LinkedList<TreeNode>();
        Queue<Integer> levels = new LinkedList<Integer>();
        nodes.offer(root);
        levels.offer(rootIndex);
        
        while(!nodes.isEmpty() && !levels.isEmpty()){
            TreeNode curr = nodes.poll();
            int level = levels.poll();
            
            result.get(level).add(curr.val);
            
            if(curr.left != null){
                nodes.offer(curr.left);
                levels.offer(level - 1);
            }
            
            if(curr.right != null){
                nodes.offer(curr.right);
                levels.offer(level + 1);
            }
        }
        
        return result;
    }
    
    // Use DFS to find range
    private void findRange(TreeNode root, int level, int[] range){
        if(root == null) return;
        
        if(level < range[0]) range[0] = level;
        if(level > range[1]) range[1] = level;
        
        findRange(root.left, level - 1, range);
        findRange(root.right, level + 1, range);
    }
}
