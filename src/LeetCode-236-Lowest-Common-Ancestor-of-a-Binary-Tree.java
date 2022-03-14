/*
LeetCode: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
LintCode: http://www.lintcode.com/problem/lowest-common-ancestor/
JiuZhang: http://www.jiuzhang.com/solutions/lowest-common-ancestor/
ProgramCreek: http://www.programcreek.com/2014/07/leetcode-lowest-common-ancestor-of-a-binary-tree-java/


https://www.cnblogs.com/grandyang/p/4641968.html


这道求二叉树的最小共同父节点的题是之前那道 Lowest Common Ancestor of a Binary Search Tree 的Follow Up。跟之前那题不同的地方是，
这道题是普通是二叉树，不是二叉搜索树，所以就不能利用其特有的性质，所以我们只能在二叉树中来搜索p和q，然后从路径中找到最后一个相同的节点即为父节点，
我们可以用递归来实现，在递归函数中，我们首先看当前结点是否为空，若为空则直接返回空，若为p或q中的任意一个，也直接返回当前结点。否则的话就对其左右
子结点分别调用递归函数，由于这道题限制了p和q一定都在二叉树中存在，那么如果当前结点不等于p或q，p和q要么分别位于左右子树中，要么同时位于左子树，
或者同时位于右子树，那么我们分别来讨论：

若p和q要么分别位于左右子树中，那么对左右子结点调用递归函数，会分别返回p和q结点的位置，而当前结点正好就是p和q的最小共同父结点，直接返回当前结
点即可，这就是题目中的例子1的情况。

若p和q同时位于左子树，这里有两种情况，一种情况是left会返回p和q中较高的那个位置，而right会返回空，所以我们最终返回非空的left即可，这就是题
目中的例子2的情况。还有一种情况是会返回p和q的最小父结点，就是说当前结点的左子树中的某个结点才是p和q的最小父结点，会被返回。

若p和q同时位于右子树，同样这里有两种情况，一种情况是right会返回p和q中较高的那个位置，而left会返回空，所以我们最终返回非空的right即可，还有
一种情况是会返回p和q的最小父结点，就是说当前结点的右子树中的某个结点才是p和q的最小父结点，会被返回，写法很简洁，代码如下：


Analysis: 
1.Divide & Conquer (Recursive)
    Find p and q's Lowest Common Ancestor in tree with root
    1.  If p or q == root, return root.
        else find LCA in left tree and right tree.
    2.  If left and right both not null(means one in left tree, one in right tree), means root is LCA.
        else if right not null, return right; if left not null, return left.
        else if both left and right are null, return null
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
    
    // 1.Divide & Conquer (Recursive)
    /*
    Time: O(N)
    Space: O(1)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        if(root == p || root == q) return root;
        
        // Divide
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        // Conquer
//        if(left != null && right != null) return root;
//        if(left != null) return left;
//        if(right != null) return right;
//        return null;

        return left != null && right != null ? root : left != null ? left : right;
    }
}
