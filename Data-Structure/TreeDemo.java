import java.util.*;

class TreeDemo{
    private class TreeNode{
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
    
    //Calculate the # of nodes
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

    //Calculate the depth of tree (root depth = 0, tree's depth is the max leaf's depth)
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

    // Preorder Traversal
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

    // Inorder Traversal
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

    // Postorder Traversal
    public void postorderTraversalRec(TreeNode root){
        if(root == null) return;

        postorderTraversalRec(root.left);
        postorderTraversalRec(root.right);
        System.out.print(root.val + " ");
    }

    public void postorderTraversalIte(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<TreeNode> out = new Stack<TreeNode>();
        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            out.push(curr);

            if(curr.left != null) stack.push(curr.left);
            if(curr.right != null) stack.push(curr.right);
        }

        while(!out.isEmpty()) System.out.println(out.pop().val + " ");
    }

    //Level Traversal
    public void levelTraversalIte(TreeNode root){
        if(root == null)return;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.pop();
            System.out.print(curr.val + " ");

            queue.offer(curr.left);
            queue.offer(curr.right);
        }
    }

    //Calculate the # of nodes in Kth Level
    public stack int getNodeNumKthLevelIte(TreeNode root, int K){
        if(root == null || K == 0) return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 0;

        while(!queue.isEmpty()){
            level++;
            if(level == K) return queue.size();

            int size = queue.size();
            for(int i = 0; i < size; i++){
                ListNode curr = queue.poll();
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }

        return 0;
    }

    //Calculate the # of nodes in Kth level
    public stack int getNodeNumKthLevelRec(TreeNode root, int K){
        if(root == null || K == 0) return 0;

        if(K == 1) return 1;

        return getNodeNumKthLevelRec(root.left, K - 1) + getNodeNumKthLevelRec(root.right, K - 1);
    }

    //Calculate the # of leaf nodes
    public stack int getNodeNumLeafIte(TreeNode root){
        if(root == null) return 0;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.offer(root);
        int count = 0;

        while(!stack.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                ListNode curr = stack.poll();
                if(curr.left == null && curr.right == null)count++;
                if(curr.left != null)queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
        return count;
    }

    public stack int getNodeNumLeafRec(TreeNode root){
        if(root == null) return 0;

        if(root.left == null && root.right == null) return 1;

        return getNodeNumLeafRec(root.left) + getNodeNumLeafRec(root.right);
    }

    //If two trees are the same
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
        stack1.offer(r1);
        stack2.offer(r2);

        while(!stack1.isEmpty() && !stack2.isEmpty()){
            TreeNode n1 = stack1.poll();
            TreeNode n2 = stack2.poll();

            if(n1.val != n2.val) return false;
            if((n1.left == null && n2.left != null) || (n1.left != null && n2.left == null)) return false;
            if((n1.right == null && n2.right != null) || (n1.right != null && n2.right == null)) return false;
            if(n1.left != null && n2.left != null){
                stack1.offer(n1.left);
                stack2.offer(n2.left);
            }
            if(n1.right != null && n2.right != null){
                stack1.offer(n1.right);
                stack2.offer(n2.right);
            }

        }

        if(!stack1.isEmpty() || !stack2.isEmpty()) return false;
        return true;
    }

    //Get mirror of Tree.(Original tree is destroyed)
    public static TreeNode mirrowRec(TreeNode root){
        if(root == null) return null;

        TreeNode temp = root.right;
        TreeNode root.right = mirrowRec(root.left);
        TreeNode root.left = mirrowRec(temp);

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
            TreeNode curr1 = stack1.pop();
            TreeNode curr2 = stack2.pop();

            if(curr1.val != curr2.val) return false;

            if(curr1.left != null && curr2.right != null){
                stack1.push(curr1.left);
                stack2.push(curr2.right);
            }else if(!(curr1.left == null && curr2 == null)){
                return false;
            }

            if(curr1.right != null && curr2.left != null){
                stack1.push(curr1.right);
                stack2.push(curr2.left);
            }else if(!(curr1.right == null && curr2.left == null)){
                return false;
            }
        }

        return true;
    }

    //End before LCA

}