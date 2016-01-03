/*
LeetCode: https://leetcode.com/problems/binary-tree-right-side-view/
LintCode: 
JiuZhang: 
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-binary-tree-right-side-view-java/

Analysis: 
1.BFS(Two queues)

2.BFS(One queue)

3.DFS
HashMap.put(key, value), if the key is existed, the latter value will overwritten the former one
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
    // 1.BFS(Two queues)
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
    //     if(root == null) return result;
        
    //     Queue<TreeNode> currLevel = new LinkedList<TreeNode>();
    //     currLevel.offer(root);
        
    //     while(!currLevel.isEmpty()){
    //         Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
    //         int len = currLevel.size();
    //         result.add(currLevel.peek().val);
            
    //         for(int i = 0; i < len; i++){
    //             TreeNode curr = currLevel.poll();
    //             if(curr.right != null) nextLevel.offer(curr.right);
    //             if(curr.left != null) nextLevel.offer(curr.left);
    //         }
    //         currLevel = nextLevel;
    //     }
        
    //     return result;
    // }
    
    // 2.BFS(One queue)
    // public List<Integer> rightSideView(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
    //     if(root == null) return result;
        
    //     Queue<TreeNode> queue = new LinkedList<TreeNode>();
    //     queue.offer(root);
        
    //     while(!queue.isEmpty()){
    //         int len = queue.size();
    //         result.add(queue.peek().val);
            
    //         for(int i = 0; i < len; i++){
    //             TreeNode curr = queue.poll();
    //             if(curr.right != null) queue.offer(curr.right);
    //             if(curr.left != null) queue.offer(curr.left);
    //         }
    //     }
    //     return result;
    // }
    
    // 3.DFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        
        HashMap<Integer, Integer> depthToValue = new HashMap<Integer, Integer>();
        DFS(depthToValue, root, 1);
        
        int depth = 1;
        while(depthToValue.containsKey(depth)){
            result.add(depthToValue.get(depth));
            depth++;
        }
        return result;
    }
    
    private void DFS(HashMap<Integer, Integer> depthToValue, TreeNode root, int depth){
        if(root == null) return;
        
        depthToValue.put(depth, root.val);
        if(root.left != null) DFS(depthToValue, root.left, depth + 1);
        if(root.right != null) DFS(depthToValue, root.right, depth + 1);
    }
    
}