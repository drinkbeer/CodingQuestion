import java.util.*;

class TreeDemo{
    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    
    public static void main(String[] args){
        
    }
    
    // 1. Calculate # of nodes
    public static int getNodeNumRec(TreeNode root){
        if(root == null) return 0;
        return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
    }

    public static int getNodeNumIte(TreeNode root){
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int result = 0;

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            result++;

            if(curr.left != null) queue.offer(curr.left);
            if(curr.right != null) queue.offer(curr.right);
        }
        return result;
    }

    // 2. Calculate the depth of tree (root depth = 0, tree's depth is the max leaf's depth)
    public static int getDepthRec(TreeNode root){
        if(root == null) return -1;     //Why -1? As root depth is 0, we need -1 finally.
        return Math.max(getDepthRec(root.left), getDepthRec(root.right)) + 1;
    }

    public static int getDepthIte(TreeNode root){
        if(root == null) return -1;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int depth = -1;  //Why -1? As root depth is 0, we need -1 first.
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            depth++;
        }
        return depth;
    }

    // 3. Preorder Traversal
    public static void preorderTraversalRec(TreeNode root){
        if(root == null) return;

        System.out.print(root.val + " ");
        preorderTraversalRec(root.left);
        preorderTraversalRec(root.right);
    }

    public static void preorderTraversalIte(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();

            System.out.print(curr.val + " ");
            if(root.right != null) stack.push(root.right);  //first right, as we need first pop left
            if(root.left != null) stack.push(root.left);
        }
    }

    // 4. Inorder Traversal
    public static void inorderTraversalRec(TreeNode root){
        if(root == null) return;

        if(root.left != null) inorderTraversalRec(root.left);
        System.out.print(root.val + " ");
        if(root.right != null) inorderTraversalRec(root.right);
    }

    public static void inorderTraversalIte(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                curr = stack.pop();
                System.out.print(curr.val + " ");
                curr = curr.right;
            }
        }
    }

    public static void inorderTraversalIte2(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }

    // 5. Postorder Traversal
    public void postorderTraversalRec(TreeNode root){
        if(root == null) return;

        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }

    // Wrong Solution
    // public void postorderTraversalIte(TreeNode root){
    //     if(root == null) return;

    //     Stack<TreeNode> stack = new Stack<TreeNode>();
    //     Stack<TreeNode> out = new Stack<TreeNode>();
    //     stack.push(root);

    //     while(!stack.isEmpty()){
    //         TreeNode curr = stack.pop();
    //         out.push(curr);

    //         if(curr.left != null) stack.push(curr.left);
    //         if(curr.right != null) stack.push(curr.right);
    //     }

    //     while(!out.isEmpty()) System.out.println(out.pop().val + " ");
    // }

    // http://www.programcreek.com/2012/12/leetcode-solution-of-iterative-binary-tree-postorder-traversal-in-java/
    public void postorderTraversalIte(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.peek();
            if(curr.left == null && curr.right == null){
                // curr is a leaf
                System.out.print(stack.pop().val + " ");
            }else{
                if(curr.right != null){
                    stack.push(curr.right);
                    curr.right = null;
                }

                if(curr.left != null){
                    stack.push(curr.left);
                    curr.left = null;
                }
            }
        }
    }

    // 6. Level Traversal
    public static void levelTraversalIte(TreeNode root){
//        if(root == null)return;
//
//        Queue<TreeNode> queue = new LinkedList<TreeNode>();
//        queue.offer(root);
//
//        while(!queue.isEmpty()){
//            TreeNode curr = queue.pop();
//            System.out.print(curr.val + " ");
//
//            queue.offer(curr.left);
//            queue.offer(curr.right);
//        }
    }

    // 7. Calculate the # of nodes in Kth Level
    public static int getNodeNumKthLevelIte(TreeNode root, int K){
        if(root == null || K == 0) return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()){
            level++;
            if(level == K) return queue.size();

            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }

        return 0;
    }

    //Calculate the # of nodes in Kth level
    public static int getNodeNumKthLevelRec(TreeNode root, int K){
        if(root == null || K == 0) return 0;

        if(K == 1) return 1;

        return getNodeNumKthLevelRec(root.left, K - 1) + getNodeNumKthLevelRec(root.right, K - 1);
    }

    // 8. Calculate the # of leaf nodes(All preorder iter, inorder iter, postorder iter can be used here.)
    public int getNodeNumLeafIte(TreeNode root){
        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        int count = 0;

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();

            if(curr.left == null && curr.right == null) {
                count++;
                continue;
            }
            if(curr.right != null) stack.push(curr);    // preorder must push right node first, as it needs pop left node first
            if(curr.left != null) stack.push(curr);
        }

        return count;
    }

    public static int getNodeNumLeafRec(TreeNode root){
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
    }

    //////////////////// Part 2. Mirror of Tree ////////////////////
    //9. If two trees are the same
    public static boolean isSameTreeRec(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;

        return r1.val == r2.val && isSameTreeRec(r1.left, r2.left) && isSameTreeRec(r1.right, r2.right);
    }

    public static boolean isSameTreeIte(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 == null || r2 == null) return false;

        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        stack1.push(r1);
        stack2.push(r2);

        while(!stack1.isEmpty() && !stack2.isEmpty()){
            TreeNode n1 = stack1.pop();
            TreeNode n2 = stack2.pop();

            if(n1.val != n2.val) return false;
            if((n1.left == null && n2.left != null) || (n1.left != null && n2.left == null)) return false;
            if((n1.right == null && n2.right != null) || (n1.right != null && n2.right == null)) return false;
            if(n1.left != null && n2.left != null){
                stack1.push(n1.left);
                stack2.push(n2.left);
            }
            if(n1.right != null && n2.right != null){
                stack1.push(n1.right);
                stack2.push(n2.right);
            }

        }

        if(!stack1.isEmpty() || !stack2.isEmpty()) return false;
        return true;
    }

    //10. Get mirror of Tree.(Original tree is destroyed)
    public static TreeNode mirrowRec(TreeNode root){
        if(root == null) return null;

        TreeNode temp = root.right;
        root.right = mirrowRec(root.left);
        root.left = mirrowRec(temp);

        return root;
    }
    // not destroy original tree
    public static TreeNode mirrowCopyRec(TreeNode root){
        if(root == null) return null;

        TreeNode rootCopy = new TreeNode(root.val);
        rootCopy.left = mirrowCopyRec(root.right);
        rootCopy.right = mirrowCopyRec(root.left);
        return rootCopy;
    }

    //Iterative like preorder traversal(will destroy original tree)
    public static TreeNode mirrowIte(TreeNode root){
        if(root == null) return null;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();

            //swap
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }

        return root;
    }

    //Iterative without destroying original tree
    public static TreeNode mirrowCopyIte(TreeNode root){
        if(root == null) return null;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        Stack<TreeNode> stackCopy = new Stack<TreeNode>();
        TreeNode rootCopy = new TreeNode(root.val);
        stackCopy.push(rootCopy);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            TreeNode currCopy = stackCopy.pop();

            if(curr.right != null){
                //Copy right node
                TreeNode leftCopy = new TreeNode(curr.right.val);
                currCopy.left = leftCopy;

                stack.push(curr.right);
                stackCopy.push(leftCopy);
            }

            if(curr.left != null){
                TreeNode rightCopy = new TreeNode(curr.left.val);
                currCopy.right = rightCopy;

                stack.push(curr.left);
                stackCopy.push(rightCopy);
            }
        }

        return rootCopy;
    }

    //Judge if two trees are mirror
    public static boolean isMirrorRec(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;

        if(r1 == null || r2 == null) return false;

        // If both are not null, they should be:
        // 1. have same value for root.
        // 2. R1's left tree is the mirror of R2's right tree;
        // 3. R2's right tree is the mirror of R1's left tree;
        return r1.val == r2.val && isMirrorRec(r1.left, r2.right) && isMirrorRec(r1.right, r2.left);
    }

    public static boolean isMirrorIte(TreeNode r1, TreeNode r2){
        if(r1 == null && r2 == null) return true;
        if(r1 != null || r2 != null) return false;

        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        s1.push(r1);
        s2.push(r2);

        while(!s1.isEmpty() && !s2.isEmpty()){
            TreeNode curr1 = s1.pop();
            TreeNode curr2 = s2.pop();

            if(curr1.val != curr2.val) return false;

            if(curr1.left != null && curr2.right != null){
                s1.push(curr1.left);
                s2.push(curr2.right);
            }else if(!(curr1.left == null && curr2 == null)){
                return false;
            }

            if(curr1.right != null && curr2.left != null){
                s1.push(curr1.right);
                s2.push(curr2.left);
            }else if(!(curr1.right == null && curr2.left == null)){
                return false;
            }
        }

        return true;
    }

    //////////////////// Part3. Lowest Common Ancestor(LCA) & Distance in Tree ////////////////////
    //11.Get Lowest Common Ancestor(LCA) in Binary Tree
    public static TreeNode LCARec(TreeNode root, TreeNode n1, TreeNode n2){
        if(root == null || n1 == null || n2 == null) return null;

        if(n1 == root || n2 == root) return root;

        TreeNode left = LCARec(root.left, n1, n2);
        TreeNode right = LCARec(root.right, n1, n2);

        // If not find in left tree, just return from right tree; not find in right tree, just return from left tree
        if(left == null) return right;
        else if(right == null) return left;

        // If both left and right find a node, return the root as common ancestor
        return root;
    }

    // Get LCA in Binary Search Tree
    public static TreeNode LCABstRec(TreeNode root, TreeNode n1, TreeNode n2){
        if(root == null || n1 == null || n2 == null) return null;

        if(n1 == root || n2 == root) return root;

        int min = Math.min(n1.val, n2.val);
        int max = Math.max(n1.val, n2.val);

        // If both values of two nodes are smaller than root value, LCA should in left tree.
        // If both values of two nodes are larger than root value, LCA should in right tree.
        if(root.val > max) return LCABstRec(root.left, n1, n2);
        else if(root.val < min) return LCABstRec(root.right, n1, n2);

        // If root is in the middle, just return the root.
        return root;
    }

    // LCA in Binary Tree Iteratively
    // http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
    // Record the path of root -> node
    public static TreeNode LCAIte(TreeNode root, TreeNode n1, TreeNode n2){
        if(root == null || n1 == null || n2 == null) return null;

        List<TreeNode> l1 = new ArrayList<TreeNode>();
        List<TreeNode> l2 = new ArrayList<TreeNode>();

        boolean find1 = LCAPathFinder(root, n1, l1);
        boolean find2 = LCAPathFinder(root, n2, l2);
        // If either node is not find, just return null
        if(!find1 || !find2) return null;

        // Notice: Iterator could accelerate the speed of List operation
        Iterator<TreeNode> iter1 = l1.iterator();
        Iterator<TreeNode> iter2 = l2.iterator();

        // Iterate from root to LCA, the first diff node's prev node is LCA
        TreeNode last = null;
        while(iter1.hasNext() && iter2.hasNext()){
            TreeNode tmp1 = iter1.next();
            TreeNode tmp2 = iter2.next();

            if(tmp1 != tmp2) return last;
            last = tmp1;
        }

        // If never find any node which is different, means Node1 and Node2 are the same one, so just return the last one.
        return last;
    }

    // Find the path from root->node, if found return true else return false. 
    public static boolean LCAPathFinder(TreeNode root, TreeNode node, List<TreeNode> path){
        if(root == null || node == null) return false;

        // First add root node.
        path.add(root);

        // If the node is in the left side.
        if(root != node && !LCAPathFinder(root.left, node, path) && !LCAPathFinder(root.right, node, path)){
            //Not find the node. remove the node added before
            path.remove(root);
            return false;
        }

        return true;
    }

    // 12. Get max distance in Binary Tree (There is bug in this algo, ignore it now)
    // public static int getMaxDistanceRec(TreeNode root){
    //     return getMaxDistanceRecHelp(root).maxDistance;
    // }

    // public static Result getMaxDistanceRecHelp(TreeNode root){
    //     Result ret = new Result(-1, -1);

    //     if(root == null) return ret;

    //     Result left = getMaxDistanceRecHelp(root.left);
    //     Result right = getMaxDistanceRecHelp(root.right);

    //     // depth+1 from the larger depth of either subtree (larger depth of left tree or right tree)
    //     ret.depth = Math.max(left.depth, right.depth) + 1;

    //     // HeiRenWenHaoLian??? Dist of cross root route. Left tree/ right tree to root'd distance should +1, so totally route from left to right should +1 (not understand here)
    //     int crossLen = left.depth + right.depth + 2;

    //     // HeiRenWenHaoLian??? Max dist is the maximum of cross root route dist, max dist of left subtree, max dist of right subtree
    //     ret.maxDistance = Math.max(left.maxDistance, right.maxDistance);
    //     ret.maxDistance = Math.max(ret.maxDistance, crossLen);

    //     return ret;
    // }

    // private static class Result{
    //     int depth;
    //     int maxDistance;
    //     public Result(int depth, int maxDistance){
    //         this.depth = depth;
    //         this.maxDistance = maxDistance;
    //     }
    // }

    // End before 13.Rebuild Binary Tree Recursively
}