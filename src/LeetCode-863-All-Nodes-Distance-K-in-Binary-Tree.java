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
    
    // 1. Build Undirected Graph, and BFS
    /*
    Time: O(N)
    Space: O(N)
    */
//     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) return result;
        
//         Map<Integer, List<TreeNode>> graph = new HashMap<>();
//         buildGraph(root, null, graph);
        
//         // BFS
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(target);
//         Set<Integer> visited = new HashSet<>();
//         visited.add(target.val);
        
//         while (!queue.isEmpty()) {
//             int size = queue.size();
            
//             if (k == 0) {
//                 for (int i = 0; i < size; i++) result.add(queue.poll().val);
//                 return result;
//             }
            
//             for (int i = 0; i < size; i++) {
//                 TreeNode curr = queue.poll();
//                 visited.add(curr.val);
                
//                 if (!graph.containsKey(curr.val)) break;    // for the case that: [1] 1 3
                
//                 for (TreeNode child : graph.get(curr.val)) {
//                     if (visited.contains(child.val)) continue;
//                     queue.offer(child);
//                 }
//             }
            
//             k--;
//         }
        
//         return result;
//     }
    
//     // Build undirected graph with HashMap recursively.
//     private void buildGraph(TreeNode curr, TreeNode parent, Map<Integer, List<TreeNode>> graph) {
//         addEdge(curr, parent, graph);
        
//         if (curr.left != null) buildGraph(curr.left, curr, graph);
//         if (curr.right != null) buildGraph(curr.right, curr, graph);
//     }
    
//     private void addEdge(TreeNode from, TreeNode to, Map<Integer, List<TreeNode>> graph) {
//         if (from == null || to == null) return;
        
//         graph.putIfAbsent(from.val, new ArrayList<>());
//         graph.get(from.val).add(to);
//         graph.putIfAbsent(to.val, new ArrayList<>());
//         graph.get(to.val).add(from);
//     }
    
    // 2. Build Graph and DFS
    /*
    Time: O(N)
    Space: O(N)
    */
//     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) return result;
        
//         // Build Graph
//         Map<Integer, List<TreeNode>> graph = new HashMap<>();
//         buildGraph(root, null, graph);
        
//         // DFS
//         Set<Integer> visited = new HashSet<>();
//         visited.add(target.val);
//         dfs(target, 0, k, graph, visited, result);
        
//         return result;
//     }
    
//     // DFS
//     private void dfs(TreeNode curr, int len, int k, Map<Integer, List<TreeNode>> graph, Set<Integer> visited, List<Integer> result) {
//         if (len == k) {
//             result.add(curr.val);
//             return;
//         }
        
//         if (!graph.containsKey(curr.val)) return;   // for the case that: [1] 1 3
        
//         for (TreeNode next : graph.get(curr.val)) {
//             if (visited.contains(next.val)) continue;
//             visited.add(next.val);
//             dfs(next, len + 1, k, graph, visited, result);
//         }
//     }
    
//     // Build undirected graph with HashMap recursively.
//     private void buildGraph(TreeNode curr, TreeNode parent, Map<Integer, List<TreeNode>> graph) {
//         addEdge(curr, parent, graph);
        
//         if (curr.left != null) buildGraph(curr.left, curr, graph);
//         if (curr.right != null) buildGraph(curr.right, curr, graph);
//     }
    
//     private void addEdge(TreeNode from, TreeNode to, Map<Integer, List<TreeNode>> graph) {
//         if (from == null || to == null) return;
        
//         graph.putIfAbsent(from.val, new ArrayList<>());
//         graph.get(from.val).add(to);
//         graph.putIfAbsent(to.val, new ArrayList<>());
//         graph.get(to.val).add(from);
//     }
    
    // 3. 
    /*
    https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/143778/Simple-Solution-without-any-extra-data-structure
    
    Time: O(N)
    Space: O(1)
    */
//     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
//         List<Integer> result = new ArrayList<>();
//         if (root == null) return result;
        
//         distanceK(root, target, k, result);
//         return result;
//     }
    
//     private int distanceK(TreeNode curr, TreeNode target, int k, List<Integer> result) {
//         if (curr == null) return -1;
//         if (curr == target) {
//             getDownNodes(curr, k, result);
//             return 1;   // distance of prev (the node that comes to curr) and target
//         }
        
//         int left = distanceK(curr.left, target, k, result);     // left is the distance of curr node to target
//         if (left >= 0) {
//             if (left == k) {
//                 // distance of curr and target is k (the path is in left subtree of curr)
//                 result.add(curr.val);
//             } else {
//                 getDownNodes(curr.right, k - left - 1, result); // -1 is because we start from curr.right/curr.left.
//             }
//             return left + 1;    // the returned distance of prev (the node that comes to curr) to target
//         }
        
//         int right = distanceK(curr.right, target, k, result);
//         if (right >= 0) {
//             if (right == k) {
//                 // distance of curr and target is k (the path is in the right subtree of curr)
//                 result.add(curr.val);
//             } else {
//                 getDownNodes(curr.left, k - right - 1, result);
//             }
//             return right + 1;
//         }
        
//         return -1;
//     }
    
//     // Trace down the path
//     private void getDownNodes(TreeNode curr, int k, List<Integer> result) {
//         if (curr == null) return;
//         if (k == 0) {
//             result.add(curr.val);
//         }
//         getDownNodes(curr.left, k - 1, result);
//         getDownNodes(curr.right, k - 1, result);
//     }
    
    /*
    https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/discuss/163101/Java-Intuitive-Solutions
    Idea:
    1. Note the distances from target node to all the nodes up the path to root from target in a map.
    2. Apply pre-order traversal using the map above:
        a. If the node is present in the map, use the distance
        b. else assume `d+1` where d = distance for the parent.
    
    Time: O(N)
    Space: O(N) - the map that stores the distance from nodes in the root-target path to target
    */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, Integer> dist = new HashMap<>();
        findTargetPath(root, target, dist);
        preorder(root, 0, k, result, dist);
        return result;
    }
    
    private int findTargetPath(TreeNode curr, TreeNode target, Map<TreeNode, Integer> dist) {
        if (curr == null) return -1;
        if (curr == target) {
            dist.put(curr, 0);
            return 0;
        }
        
        int val = findTargetPath(curr.left, target, dist);
        if (val == -1) {
            val = findTargetPath(curr.right, target, dist);
        }
        if (val == -1) return -1;
        
        // find a target in this path
        // for parent
        val += 1;
        dist.put(curr, val);
        return val;
    }
    
    private void preorder(TreeNode curr, int d, int k, List<Integer> result, Map<TreeNode, Integer> dist) {
        if (curr == null) return;
        d = dist.getOrDefault(curr, d + 1);
        if (d == k) result.add(curr.val);
        preorder(curr.left, d, k, result, dist);
        preorder(curr.right, d, k, result, dist);
    }
}
