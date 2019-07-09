/*
Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree? No

According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

Analysis: this problem can be converted into detecting cycle in undirected graph

1.DFS
https://leetcode.com/discuss/52568/ac-java-graph-dfs-solution-with-adjacency-list
Detect cycle in undirected graph. Use DFS to detect cycle, scan each v, two conditions mean there are cycles
    1.v is visited, and v is not u's parent. That means except from u, there is another way to visit v
    2.v is not visited, but from v there is a cycle
    
2.BFS (not finish it)

3.Union Find

*/
class Solution {
    
    // 1. Build Undirected Graph + DFS
//     public boolean validTree(int n, int[][] edges) {
//         if (edges == null) return false;
//         if (edges.length == 0) {
//             if (n == 1) return true;
//             else return false;
//         }
        
//         // Build undirected graph.
//         HashMap<Integer, List<Integer>> map = new HashMap<>();
//         for (int i = 0; i < edges.length; i++) {
//             int from = edges[i][0];
//             int to = edges[i][1];
            
//             if (!map.containsKey(from)) {
//                 map.put(from, new ArrayList<>());
//             }
            
//             if (!map.containsKey(to)) {
//                 map.put(to, new ArrayList<>());
//             }
            
//             map.get(from).add(to);
//             map.get(to).add(from);
//         }
        
//         // DFS (start from a random point, to detect cycle, and then check if all points are visited from this point)
//         boolean[] visited = new boolean[n];
//         if (hasCycle(edges[0][0], -1, map, visited)) return false;
//         for (int i = 0; i < n; i++) {
//             if (visited[i] == false) return false;
//         }
        
//         return true;
//     }
    
//     private boolean hasCycle(int curr, int parent, HashMap<Integer, List<Integer>> map, boolean[] visited) {
//         // if (visited[curr]) return true;
//         // if (!map.containsKey(curr)) return true; // not necessary, as we start from edge[0][0]
        
//         visited[curr] = true;
        
//         for (int next : map.get(curr)) {
//             if (next == parent) continue;                               // skip trace back
//             if (visited[next]) return true;                             // has already visited next, means there is cycle
//             if (hasCycle(next, curr, map, visited)) return true;        // has cycles
//         }
        
//         return false;
//     }
    
    
    // 2. Build Undirected Graph + BFS
//     public boolean validTree(int n, int[][] edges) {
//         if (edges == null) return false;
//         if (edges.length == 0) {
//             if (n == 1) return true;
//             else return false;
//         }
        
//         // Build undirected graph.
//         HashMap<Integer, List<Integer>> map = new HashMap<>();
//         for (int i = 0; i < edges.length; i++) {
//             int from = edges[i][0];
//             int to = edges[i][1];
            
//             if (!map.containsKey(from)) {
//                 map.put(from, new ArrayList<>());
//             }
            
//             if (!map.containsKey(to)) {
//                 map.put(to, new ArrayList<>());
//             }
            
//             map.get(from).add(to);
//             map.get(to).add(from);
//         }
        
//         // BFS
//         Queue<Integer> queue = new LinkedList<>();
//         boolean[] visited = new boolean[n];
//         queue.offer(edges[0][0]);
        
//         int count = 0;
//         while(!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 int curr = queue.poll();
                
//                 if (visited[curr]) return false;   // means curr has already been visited in the uppper level

//                 count++;
//                 visited[curr] = true;
                
//                 for (int next : map.get(curr)) {
//                     if (visited[next]) continue;    // skip trace back to parent.
//                     queue.offer(next);
//                 }
//             }
//         }
        
//         return count == n;
//     }
    
    // 3. Union-Find
    public boolean validTree(int n, int[][] edges) {
        if (edges == null) return false;
        if (edges.length == 0) {
            if (n == 1) return true;
            else return false;
        }
        if (n - 1 != edges.length) return false;
        
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
    
        for (int i = 0; i < edges.length; i++) {
            int x = find(edges[i][0], nums);
            int y = find(edges[i][1], nums);
            
            if (x == y) return false;
            
            nums[x] = y;    // union u and v
        }
        
        return true;
    }
    
    private int find(int u, int[] nums) {
        if (nums[u] == -1) return u;
        int v = nums[u];
        return find(v, nums);
    }
}
