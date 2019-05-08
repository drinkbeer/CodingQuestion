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
    // 1.Using a HashMap + inorder traversal DFS, Space O(N)
//     public int[] findMode(TreeNode root) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) return new int[0];
        
//         Map<Integer, Integer> map = new HashMap<>();
//         int[] max = new int[] {0};
        
//         inorderTraversal(root, map, max);
        
//         for (int key : map.keySet()) {
//             if (map.get(key) == max[0]) {
//                 result.add(key);
//             }
//         }
//         // return result.stream().mapToInt(i -> i).toArray();
//         int[] arr = new int[result.size()];
//         for (int i = 0; i < result.size(); i++) {
//             arr[i] = result.get(i);
//         }
//         return arr;
//     }
    
//     private void inorderTraversal(TreeNode root, Map<Integer, Integer> map, int[] max) {
//         if (root == null) return;
        
//         inorderTraversal(root.left, map, max);
//         map.put(root.val, map.getOrDefault(root.val, 0) + 1);
//         max[0] = Math.max(max[0], map.get(root.val));
//         inorderTraversal(root.right, map, max);
//     }
    
    
    // 2.Using variables, two pass solution, Space O(1)
    Integer prev = null;
    int count = 1;
    int max = 0;
    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        
        if (prev != null) {
            // prev is not null, means root is not the first one in inorder traversal array
            // prev is null, means root is the first one
            if (root.val == prev) {
                count++;
            } else {
                count = 1;
            }
        }
        
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        
        prev = root.val;
        inorder(root.right, list);
    }
    
}
