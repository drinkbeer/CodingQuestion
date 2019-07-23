class Solution {
    // 1. DFS
    /*
    The proof is the following: A bipartite graph can be divided into two sets of vertices which are disjoint and exhaustive such that there are no edges between the two sets.

    Assign one colour each to the set. This is possible because there are no edges between vertices in the same set in a bipartite graph.

    Hence, if we arrive at an edge which is between two different colours, we return false, else return true.
    */
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
        
//         int[] colors = new int[n];
//         for (int i = 0; i < n; i++) {
//             if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
//                 return false;
//             }
//         }
//         return true;
//     }
    
//     private boolean validColor(int[][] graph, int[] colors, int color, int node) {
//         if (colors[node] != 0) {
//             return colors[node] == color;
//         }
        
//         colors[node] = color;
//         for (int to : graph[node]) {
//             if (!validColor(graph, colors, -color, to)) {
//                 return false;
//             }
//         }
//         return true;
//     }
    
    // 2. BFS
//     public boolean isBipartite(int[][] graph) {
//         int n = graph.length;
//         int[] colors = new int[n];

//         for (int i = 0; i < n; i++) {
//             if (colors[i] != 0) continue;
            
//             Queue<Integer> queue = new LinkedList<>();
//             queue.offer(i);
//             colors[i] = 1;
            
//             while (!queue.isEmpty()) {
//                 int size = queue.size();
//                 for (int j = 0; j < size; j++) {
//                     int curr = queue.poll();
//                     for (int to : graph[curr]) {
//                         if (colors[to] == 0) {
//                             colors[to] = -colors[curr];
//                             queue.offer(to);
//                         } else if (colors[to] != -colors[curr]) {
//                             return false;
//                         }
//                     }
//                 }
//             }
//         }
//         return true;
//     }
    
    // BFS (Optimized by removing the size)
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) continue;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1;
            
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int to : graph[curr]) {
                    if (colors[to] == 0) {
                        colors[to] = -colors[curr];
                        queue.offer(to);
                    } else if (colors[to] != -colors[curr]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
