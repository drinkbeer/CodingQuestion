/*
Many solutions to this question:

1.Preorder, use an array to mark # of nulls
http://blog.csdn.net/ljiabin/article/details/49474445
       5
      / \
     4   7
    /   /
   3   2
  /   /
 -1  9
 [5,4,7,3,null,2,null,-1,null,9,null,null,null,null,null,]
 左右孩子分别为 2*(i-num)+1 和 2*(i-num)+2
 
 2. Recursive
 
 3.Serialize to JSON (not do it)
 https://leetcode.com/discuss/66397/java-stack-based-solution-using-json

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
public class Codec {
    // 1.BFS (level order traversal)
    public String serialize(TreeNode root) {
        if (root == null) return "";
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        StringBuilder sb = new StringBuilder();
        
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();
            
            if(curr == null){
                sb.append("#").append(",");
            }else{
                sb.append(curr.val).append(",");
                queue.offer(curr.left);
                queue.offer(curr.right);
            }
        }
        
        if(sb.length() > 0) sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        
        String[] strs = data.split(",");
        
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        queue.offer(root);
        int count = 0;
        
        while (!queue.isEmpty()) {
            count++;
            TreeNode curr = queue.poll();
            if (!"#".equals(strs[count])) {
                curr.left = new TreeNode(Integer.parseInt(strs[count]));
                queue.offer(curr.left);
            }
            count++;
            if (!"#".equals(strs[count])) {
                curr.right = new TreeNode(Integer.parseInt(strs[count]));
                queue.offer(curr.right);
            }
        }
        
        return root;
    }
    
    // 2.Recursive
    
//     public String serialize(TreeNode root) {
//         if (root == null) return "#";
//         return root.val + "," + serialize(root.left) + "," + serialize(root.right);
//     }
    
//     public TreeNode deserialize(String data) {
//         String[] arr = data.split(",");
//         int[] loc = new int[1];
//         return deserialize(arr, loc);
//     }
    
//     private TreeNode deserialize(String[] arr, int[] loc) {
//         if ("#".equals(arr[loc[0]])) {
//             loc[0]++;
//             return null;
//         }
        
//         TreeNode curr = new TreeNode(Integer.parseInt(arr[loc[0]]));
//         loc[0]++;
        
//         curr.left = deserialize(arr, loc);
//         curr.right = deserialize(arr, loc);
        
//         return curr;
//     }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
