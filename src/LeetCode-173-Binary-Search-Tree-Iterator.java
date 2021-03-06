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
In order traversal

*/
class BSTIterator {
    
    Stack<TreeNode> stack;
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        curr = root;
    }
    
    /** @return the next smallest number */
    public int next() {
        int next = 0;
        // This if is not necessary, as we are sure "curr" is out from a stack.
        // if (curr != null || !stack.isEmpty()) {
            // push all the left nodes into the stack
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            
            curr = stack.pop();
            next = curr.val;
            curr = curr.right;
        // }
        return next;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return curr != null || !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */


/**
Morris pre-order traversal

Space: O(1)
Time: O(N)
*/
class BSTIterator {
    TreeNode curr;

    public BSTIterator(TreeNode root) {
        curr = root;
    }
    
    public int next() {
        int next = 0;
        while (curr != null) {
            if (curr.left == null) {
                next = curr.val;
                curr = curr.right;
                break;
            } else {
                TreeNode predecessor = curr.left;
                while (predecessor.right != null && predecessor.right != curr) {
                    predecessor = predecessor.right;
                }
                
                if (predecessor.right == null) {
                    predecessor.right = curr;
                    curr = curr.left;
                } else {
                    next = curr.val;
                    predecessor.right = null;
                    curr = curr.right;
                    break;
                }
            }
        }
        return next;
        
    }
    
    public boolean hasNext() {
        return curr != null;
    }
}
