/*
1.Union Find

2.Union Find
*/
public class Solution {
    // 1. UF
//     public int countComponents(int n, int[][] edges) {
        
//         int[] nums = new int[n];
//         java.util.Arrays.fill(nums, -1);
        
//         for(int i = 0; i < edges.length; i++){
//             int x = find(edges[i][0], nums);
//             int y = find(edges[i][1], nums);
            
//             if(x != y) nums[x] = y;     //union
//         }
        
//         HashSet<Integer> set = new HashSet<Integer>();
//         for(int i = 0; i < n; i++){
//             int x = find(i, nums);
//             set.add(x);
//         }
//         return set.size();
//     }
    
//     // find
//     private int find(int u, int[] nums){
//         if(nums[u] == -1) return u;
//         int v = nums[u];
//         return find(v, nums);
//     }
    
    // 2. UF
//     public int countComponents(int n, int[][] edges) {
//         UnionFind uf = new UnionFind(n);
        
//         for (int[] edge : edges) {
//             int x = edge[0];
//             int y = edge[1];
//             uf.union(x, y);
//         }
        
//         return uf.size();
//     }
    
//     private class UnionFind {
        
//         int[] id, size;
//         int count;
        
//         public UnionFind(int n) {
//             id = new int[n];
//             size = new int[n];
            
//             for (int i = 0; i < n; i++) {
//                 id[i] = i;
//             }
            
//             Arrays.fill(size, 1);
            
//             count = n;
//         }
        
//         private int root(int x) {
//             while (x != id[x]) {
//                 x = id[x];
//             }
//             return x;
//         }
        
//         public int size() {
//             return count;
//         }
        
//         public void union(int x, int y) {
//             int xR = root(x);
//             int yR = root(y);
            
//             if (xR == yR) return;   // x, and y have already been connected
            
//             id[xR] = yR;    // yR is the new root of xR
//             size[yR] += size[xR];
//             count--;
//         }
//     }
    
    // 3.DFS in Graph
    /*
    https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/77583/Java-Union-find-and-DFS-and-BFS-Code-(very-clean)
    */
//     public int countComponents(int n, int[][] edges) {
//         if (n <= 1) {
//             return n;
//         }
//         List<List<Integer>> adjList = new ArrayList<List<Integer>>();
//         for (int i = 0; i < n; i++) {
//             adjList.add(new ArrayList<Integer>());
//         }
//         for (int[] edge : edges) {
//             adjList.get(edge[0]).add(edge[1]);
//             adjList.get(edge[1]).add(edge[0]);
//         }
//         boolean[] visited = new boolean[n];
//         int count = 0;
//         for (int i = 0; i < n; i++) {
//             if (!visited[i]) {
//                 count++;
//                 dfs(visited, i, adjList);
//             }
//         }
        
//         return count;
//     }
    
//     public void dfs(boolean[] visited, int index, List<List<Integer>> adjList) {
//         visited[index] = true;
//         for (int i : adjList.get(index)) {
//             if (!visited[i]) {
//                 dfs(visited, i, adjList);
//             }
//         }
//     }
    
    
    // 4. BFS in Graph
    /*
    https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/discuss/77583/Java-Union-find-and-DFS-and-BFS-Code-(very-clean)
    */
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                Queue<Integer> queue = new LinkedList<Integer>();
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int index = queue.poll();
                    visited[index] = true;
                    for (int next : adjList.get(index)) {
                        if (!visited[next]) {
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        
        return count;
    }
}
