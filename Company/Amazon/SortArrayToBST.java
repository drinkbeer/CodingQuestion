class SortArrayToBST{
    public static Node sortedArrayToBST(int[] arr, int lo, int hi){
        if(lo > hi) return null;
        
        int mid = lo + (hi - lo) / 2;
        Node newNode = new Node(arr[mid]);

        newNode.left = sortedArrayToBST(arr, lo, mid - 1);
        newNode.right = sortedArrayToBST(arr, mid + 1, hi);

        return newNode;
    }
    
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int n = arr.length;
        Node root = sortedArrayToBST(arr, 0, n - 1);
        System.out.println("Preorder traversal of constructed BST");
        preOrder(root);
    }

    // A binary tree node
    public static class Node {
         
        int data;
        Node left, right;
         
        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    /* A utility function to print preorder traversal of BST */
    private static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}