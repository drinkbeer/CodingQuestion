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
    // 1.BFS (Using two stacks to store each level)
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         if(root == null) return result;
        
//         Stack<TreeNode> currLevel = new Stack<TreeNode>();
//         boolean isNormal = true;
//         currLevel.push(root);
        
//         while(!currLevel.isEmpty()){
//             List<Integer> list = new ArrayList<Integer>();
//             Stack<TreeNode> nextLevel = new Stack<TreeNode>();

//             while(!currLevel.isEmpty()){
//                 TreeNode node = currLevel.pop();
//                 list.add(node.val);
                
//                 if(isNormal){
//                     if(node.left != null) nextLevel.push(node.left);
//                     if(node.right != null) nextLevel.push(node.right);
//                 }else{
//                     if(node.right != null) nextLevel.push(node.right);
//                     if(node.left != null) nextLevel.push(node.left);
//                 }
//             }
//             result.add(new ArrayList(list));
//             isNormal = !isNormal;
            
//             currLevel = nextLevel;
//         }
//         return result;
//     }

    // 2.BFS (Using two stacks, and level number)
    /*
    Stack:
    [3] - 0 - [3]
    [9, 20] - 1 - [20 -> 9]
    [15, 7] - 2
    
    if level is even, push to stack from left child to right child (pop: right -> left)
    if level is odd, push to stack from right child to left child (pop: left -> right)
    */
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         if (root == null) return result;
        
//         Stack<TreeNode> currLevel = new Stack<>();
//         currLevel.push(root);
        
//         while (!currLevel.isEmpty()) {
//             int level = result.size(); // 1
//             int levelSize = currLevel.size();
//             List<Integer> levelResult = new ArrayList<>();
//             Stack<TreeNode> nextLevel = new Stack<>();
            
//             for (int i = 0; i < levelSize; i++) {
//                 TreeNode curr = currLevel.pop();
//                 if (level % 2 == 0) {
//                     // odd level
//                     if (curr.left != null) nextLevel.push(curr.left);
//                     if (curr.right != null) nextLevel.push(curr.right);
//                 } else {
//                     // even level
//                     if (curr.right != null) nextLevel.push(curr.right);
//                     if (curr.left != null) nextLevel.push(curr.left);
//                 }
//                 levelResult.add(curr.val);
//             }
            
//             result.add(levelResult);
//             currLevel = nextLevel;
//         }
        
//         return result;
//     }
    
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         List<List<Integer>> result = new ArrayList<>();
//         if (root == null) return result;
        
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);
//         boolean isNormal = true;
        
//         while(!queue.isEmpty()) {
//             int size = queue.size();
//             List<Integer> levelResult = new ArrayList<>();
            
//             for (int i = 0; i < size; i++) {
//                 TreeNode curr = queue.poll();
                
//                 if (isNormal) {
//                     levelResult.add(curr.val);
//                 } else {
//                     levelResult.add(0, curr.val);
//                 }
                
//                 if (curr.left != null) queue.offer(curr.left);
//                 if (curr.right != null) queue.offer(curr.right);
//             }
            
//             isNormal = !isNormal;
//             result.add(levelResult);
//         }
        
//         return result;
//     }
    
    // 2. BFS (Recursive)
    /*
    Level starts from 0.
    If even level, add result from left to right,
    if odd level, add result from right to left (add the value at the beginning of the list)
    
    https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/discuss/278680/Java-recursive-beats-100
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        
        zigzagLevelOrder(root, 0, result);
        
        return result;
    }
    
    public void zigzagLevelOrder(TreeNode node, int level, List<List<Integer>> result) {
        if (result.size() == level) {
            result.add(new ArrayList<Integer>());
        }
        
        if (level % 2 == 0) {
            result.get(level).add(node.val);
        } else {
            result.get(level).add(0, node.val);
        }
        
        if (node.left != null) zigzagLevelOrder(node.left, level + 1, result);
        if (node.right != null) zigzagLevelOrder(node.right, level + 1, result);
        // If both left and right child are null, then we return to the above level
    }
}
