/*
http://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/
Given a binary tree, print all root-to-leaf paths
For the below example tree, all root-to-leaf paths are: 
10 –> 8 –> 3
10 –> 8 –> 5
10 –> 2 –> 2


*/
import java.util.*;

class Node {
    int val;
    Node left, right;
    public Node(){
        left = null;
        right = null;
    }

    public Node(int val){
        this.val = val;
    }
}

class PrintPath{
    public void printPath(Node root){
        if(root == null) return;

        List<Node> path = new LinkedList<Node>();
        printPath(root, path);
    }

    public void printPath(Node node, List<Node> path){
        // end condition
        if(node == null){
            for(int i = 0; i < path.size(); i++){
                System.out.print(path.get(i).val + " ");
            }
            System.out.println();
            return;
        }

        path.add(node);

        if(node.left == null && node.right == null){
            printPath(null, path);
        }

        if(node.left != null){
            printPath(node.left, path);
        }
        
        if(node.right != null){
            printPath(node.right, path);
        }
         
        path.remove(path.size() - 1);     
    }

    // driver program to test above functions
    public static void main(String args[]) {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);

        PrintPath tree = new PrintPath();
        tree.printPath(root);
    }
}