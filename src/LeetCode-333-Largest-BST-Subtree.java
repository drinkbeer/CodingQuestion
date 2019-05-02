/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/*
1. Left subtree and right subtree are all BST
2. root.val > left subtree max val
3. root.val < right subtree min val

max size = left size + right size + 1

*/
class Solution {
    //1.DFS
//     public int largestBSTSubtree(TreeNode root) {
//         if (root == null) return 0;
        
//         // count of nodes in largest subtree
//         int[] count = new int[] {0};
        
//         // Return value of largestBSTSubtree:
//         // int[0] -> size
//         // int[1] -> left subtree max val
//         // int[2] -> right subtree min val
//         largestBSTSubtree(root, count);
//         return count[0];
//     }
    
//     private int[] largestBSTSubtree(TreeNode root, int[] largest) {
//         if (root == null) {
//             return new int[] {0, Integer.MAX_VALUE, Integer.MIN_VALUE};
//         }
        
//         int[] l = largestBSTSubtree(root.left, largest);
//         int[] r = largestBSTSubtree(root.right, largest);
        
//         if (root.val > l[2] && root.val < r[1]) {
//             // find a new larger BST subtree
//             // get the new min and max val
//             int min = Math.min(root.val, l[1]);
//             int max = Math.max(root.val, r[2]);
//             int size = l[0] + r[0] + 1;
            
//             // update largest subtree val
//             largest[0] = Math.max(largest[0], size);
            
//             return new int[] {size, min, max};
//         }
        
//         // no new larger BST subtree found
//         return new int[] {0, Integer.MIN_VALUE, Integer.MAX_VALUE};
//     }
    
    // 2. Use a new class
    // https://leetcode.com/problems/largest-bst-subtree/discuss/78891/Share-my-O(n)-Java-code-with-brief-explanation-and-comments
    // JiuZhang: https://www.jiuzhang.com/solutions/largest-bst-subtree
    class Result {  // (size, rangeLower, rangeUpper) -- size of current tree, range of current tree [rangeLower, rangeUpper]
        int size;
        int lower;
        int upper;
        
        Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
    
    int max = 0;
    
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) { return 0; }    
        traverse(root);
        return max;
    }
    
    private Result traverse(TreeNode root) {
        if (root == null) { return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE); }
        Result left = traverse(root.left);
        Result right = traverse(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) {
            return new Result(-1, 0, 0);
        }
        int size = left.size + 1 + right.size;
        max = Math.max(size, max);
        return new Result(size, Math.min(left.lower, root.val), Math.max(right.upper, root.val));
    }
}
