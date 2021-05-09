/*
LeetCode:  https://leetcode.com/problems/clone-graph/
LintCode:  http://www.lintcode.com/problem/clone-graph/
JiuZhang:  http://www.jiuzhang.com/solutions/clone-graph/
ProgramCreek:  http://www.programcreek.com/2012/12/leetcode-clone-graph-java/
                Other: http://www.cnblogs.com/springfor/p/3874591.html

Analysis:  
Queue is used to BFS the original Graph.
HashMap is used to navigate the relationship between original Graph and new Graph.
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
//     // 1. BFS
//     public Node cloneGraph(Node node) {
//         if (node == null) return node;
        
//         HashMap<Node, Node> map = new HashMap<>();
//         Queue<Node> queue = new LinkedList<>();
        
//         Node newNode = new Node(node.val, new ArrayList<>());
//         map.put(node, newNode);
//         queue.add(node);
        
//         while(!queue.isEmpty()) {
//             Node curr = queue.poll();
            
//             for (Node n : curr.neighbors) {
//                 if (map.containsKey(n)) {
//                     //means n is already visited, just need to add relationship
//                     map.get(curr).neighbors.add(map.get(n));
//                 } else {
//                     // means n has not been visited
//                     Node newN = new Node(n.val, new ArrayList<>());
//                     map.get(curr).neighbors.add(newN);     //add to new Graph node's neighbor list
                    
//                     map.put(n, newN);
//                     queue.add(n);
//                 }
//             }
//         }
        
//         return newNode;
//     }
    
    
    // 2. DFS (visited set is not necessary
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        
        HashMap<Node, Node> map = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node, newNode);
        dfs(node, newNode, map, visited);
        return newNode;
    }
    
    private void dfs(Node curr, Node clone, Map<Node, Node> map, Set<Integer> visited) {
        if (visited.contains(curr.val)) return;
        
        visited.add(curr.val);
        for (Node adj : curr.neighbors) {
            if (map.containsKey(adj)) {
                clone.neighbors.add(map.get(adj));
            } else {
                Node cloneAdj = new Node(adj.val, new ArrayList<>());
                map.put(adj, cloneAdj);
                clone.neighbors.add(cloneAdj);
            }
            dfs(adj, map.get(adj), map, visited);
        }
    }
  
  // DFS
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node copy = new Node(node.val, new ArrayList<>());
        map.put(node, copy);
        
        recursive(node, map);
        return copy;
    }
    
    private void recursive(Node curr, HashMap<Node, Node> map) {
        Node copy = map.get(curr);
        
        for (Node nb : curr.neighbors) {
            if (map.containsKey(nb)) {
                // nb has already been visited
                copy.neighbors.add(map.get(nb));
            } else {
                Node nbCopy = new Node(nb.val, new ArrayList<>());
                map.put(nb, nbCopy);
                copy.neighbors.add(nbCopy);
                recursive(nb, map);
            }
        }
    }
}
