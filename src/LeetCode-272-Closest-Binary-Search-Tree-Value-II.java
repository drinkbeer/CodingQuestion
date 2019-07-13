/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    /*
    https://leetcode.com/problems/closest-binary-search-tree-value-ii/discuss/186606/Deque-Solution-Java.-Definitely-easy-to-understand.
    
    Time O(N)
    */
//     public List<Integer> closestKValues(TreeNode root, double target, int k) {
//         Deque<Integer> dq = new ArrayDeque<>();
//         recursive(root, dq);
        
//         while (dq.size() > k) {
//             double t = Math.abs(dq.peekLast() - target);
//             double h = Math.abs(dq.peekFirst() - target);
            
//             if (t > h) {
//                 dq.pollLast();
//             } else {
//                 dq.pollFirst();
//             }
//         }
        
//         return new ArrayList<>(dq);
//     }
    
//     private void recursive(TreeNode root, Deque<Integer> dq) {
//         if (root.left != null) recursive(root.left, dq);
//         dq.addFirst(root.val);
//         if (root.right != null) recursive(root.right, dq);
//     }
    
    /*
    https://leetcode.com/problems/closest-binary-search-tree-value-ii/discuss/70511/AC-clean-Java-solution-using-two-stacks
    https://leetcode.com/problems/closest-binary-search-tree-value-ii/discuss/70503/O(logN)-Java-Solution-with-two-stacks-following-hint
    
    Must understand this one first: 
    https://leetcode.com/problems/inorder-successor-in-bst/
    
    
    The solution that really make stack valuable is the idea of using two stacks as two iterators (smaller and larger), the smaller stack will pop the next available largest element that is smaller then target, and larger stack will pop the next available smallest element that is larger or equal to the target. Those two stacks will not need to store all the nodes, but only number of nodes proportional to the height of the tree... an idea similar to Leetcode 173...if the tree is balanced, the time cost will be amortized O(k), and the space cost will be O(logN), but if the tree is not balanced, the worst space cost will be O(N), I post the solution below...

    Time O(K)
    Space O(logN)
    */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<TreeNode> smaller = new Stack<>();
        Stack<TreeNode> larger = new Stack<>();
        
        pushSmaller(root, target, smaller);
        pushLarger(root, target, larger);
        
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            if (smaller.isEmpty() || (!larger.isEmpty() && larger.peek().val - target < target - smaller.peek().val)) {
                TreeNode curr = larger.pop();
                res.add(curr.val);
                pushLarger(curr.right, target, larger);
            } else {
                TreeNode curr = smaller.pop();
                res.add(curr.val);
                pushSmaller(curr.left, target, smaller);
            }
        }
        return res;
    }
    
    private void pushSmaller(TreeNode curr, double target, Stack<TreeNode> smaller) {
        while (curr != null) {
            if (curr.val < target) {
                smaller.push(curr);
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
    }
    
    private void pushLarger(TreeNode curr, double target, Stack<TreeNode> larger) {
        while (curr != null) {
            if (curr.val >= target) {
                larger.push(curr);
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }
    
}
