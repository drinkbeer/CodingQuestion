/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // 1. DFS + Global Sorting
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        
        List<int[]> nodes = new ArrayList<>();
        DFS(root, 0, 0, nodes);
        
        Comparator<int[]> cmp = new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    if (arr1[1] == arr2[1]) {
                        return arr1[2] - arr2[2];
                    } else {
                        return arr1[1] - arr2[1];
                    }
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        };
        
        Collections.sort(nodes, cmp);
        
        List<Integer> currColumn = new ArrayList<>();
        int colIndex = nodes.get(0)[0];
        
        for (int[] arr : nodes) {
            int col = arr[0], row = arr[1], val = arr[2];
            
            if (col == colIndex) {
                currColumn.add(val);
            } else {
                result.add(currColumn);
                colIndex = col;
                currColumn = new ArrayList<>();
                currColumn.add(val);
            }
        }
        result.add(currColumn);
        
        return result;
    }
    
    
    private void DFS(TreeNode curr, int row, int col, List<int[]> nodes) {
        int[] arr = new int[3];
        arr[0] = col;
        arr[1] = row;
        arr[2] = curr.val;
        
        nodes.add(arr);
        
        if (curr.left != null) DFS(curr.left, row + 1, col - 1, nodes);
        if (curr.right != null) DFS(curr.right, row + 1, col + 1, nodes);
    }
}
