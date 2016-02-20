/*
http://www.1point3acres.com/bbs/thread-172143-1-1.html
https://leetcode.com/problems/maximum-depth-of-binary-tree/

Question: print max depth path of a binary tree

Still have some problems in printing.

*/
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class PrintLongestPath {
    public static void printLongestPath(TreeNode root){
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        List<Integer> list = new LinkedList<Integer>();
        DFS(root, 0, map, list);

        int max = Collections.max(map.keySet());
        List<Integer> maxList = map.get(max);

        for(int n : maxList){
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private static void DFS(TreeNode node, int len, HashMap<Integer, List<Integer>> map, List<Integer> list){
        // end condition
        if(node == null){
            return;
        } else if(node.left == null && node.right == null){
            list.add(node.val);
            map.put(len, list);

            // for(int n : list){
            //     System.out.print(n + " ");
            // }
            // System.out.println();

            list.remove(list.size() - 1);
            return;
        }

        list.add(node.val);

        DFS(node.left, len + 1, map, list);
        DFS(node.right, len + 1, map, list);

        list.remove(list.size() - 1);
    }

    /*
       10
  2        10
20  1          -25
            3     4

    */
    public static void main(String[] args){
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        printLongestPath(root);
    }
}