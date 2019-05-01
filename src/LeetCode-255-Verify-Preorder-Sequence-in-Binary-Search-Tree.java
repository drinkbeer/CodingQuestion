/*

preorder    root | left | right

preorder[0] is root
left < root < right


https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/discuss/68142/Java-O(n)-and-O(1)-extra-space
*/

class Solution {
    
    // 1.Divide & Conquer
    // Space O(1)
//     public boolean verifyPreorder(int[] preorder) {
//         if (preorder == null || preorder.length <= 2) return true;
        
//         return verifyPreorder(preorder, 0, preorder.length - 1);
//     }
    
//     private boolean verifyPreorder(int[] arr, int start, int end) {
//         // We get convergenced.
//         if (start >= end) return true;
        
//         int root = arr[start];
//         // Verify left tree
//         int i = start + 1;
//         for (; i <= end; i++) {
//             if (arr[i] == root) return false;
//             if (arr[i] > root) break;
//         }
        
//         // Verify right tree
//         int j = i;
//         for (; j <= end; j++) {
//             if (arr[j] <= root) return false;
//         }
        
//         // i == start + 1, means the left tree is null, so we only need to verify right tree
//         if (i == start + 1) return verifyPreorder(arr, start + 1, end);
        
//         // we need verify both left tree and right tree.
//         return verifyPreorder(arr, start + 1, i - 1) && verifyPreorder(arr, i, end);
//     }
    
    // 2.DFS

}
