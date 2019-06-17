/*
This problem can be convert to check if there is cycle in graph.

1.DFS
http://blog.welkinlan.com/2015/05/09/course-schedule-leetcode-java-dfs/
Step1. Build graph. Put graph into HashMap<Integer, List<Integer>>
Step2. Run DFS to detect cycle
    - Using a int[] to mark course status: 0 not visited, 1 visited(used in DFS), -1 finish visited
    - Recursive to detect cycle. During recursive, if we find some course has already been visited, return true(contains cycle)

2.DFS(Using Matrix to store Graph)
TLE(Too many unuseful information, I think.)

2.BFS
https://leetcode.com/discuss/39456/java-dfs-and-bfs-solution

*/
public class Solution {
    // 1.DFS(HashMap to store graph)
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     if(prerequisites == null || prerequisites.length == 0) return true;
        
    //     // Construct graph
    //     HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    //     for(int i = 0; i < prerequisites.length; i++){
    //         int from = prerequisites[i][1];
    //         int to = prerequisites[i][0];
            
    //         if(!map.containsKey(from)){
    //             map.put(from, new ArrayList<Integer>());
    //         }
            
    //         List<Integer> list = map.get(from);
    //         list.add(to);
    //         map.put(from, list);
    //     }
        
    //     // detect cycle one by one using DFS: not visited && has cycle
    //     int[] visited = new int[numCourses];
    //     for(int from = 0; from < numCourses; from++){
    //         if(visited[from] == 0 && hasCycle(from, visited, map)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    
    // private boolean hasCycle(int from, int[] visited, HashMap<Integer, List<Integer>> map){
    //     if(visited[from] == 1) return true;  //from has already visited
    //     visited[from] = 1;
    
    //     // means from is several other courses' prerequisite
    //     if(map.containsKey(from)){
    //         for(Integer to : map.get(from)){
    //             if(visited[to] == 1) return true;   //to has already visited
    //             if(hasCycle(to, visited, map)) return true;    //to is in cycle
    //         }
    //     }
        
    //     visited[from] = -1;   // finish visit
    //     return false;
    // }
    
    // 2.DFS(Using Matrix to store Graph)
    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     if(prerequisites == null || prerequisites.length == 0) return true;
        
    //     // construct graph
    //     int[][] graph = new int[numCourses][numCourses];
    //     for(int i = 0; i < prerequisites.length; i++){
    //         int from = prerequisites[i][1];
    //         int to = prerequisites[i][0];
    //         graph[from][to] = 1;
    //     }
        
    //     // detect cycle recursive
    //     int[] visited = new int[numCourses];
    //     for(int from = 0; from < numCourses; from++){
    //         if(visited[from] == 0 && hasCycle(from, graph, visited)){
    //             return false;   //there is cycle
    //         }
    //     }
        
    //     return true;
    // }
    
    // private boolean hasCycle(int from, int[][] graph, int[] visited){
    //     if(visited[from] == 1) return true;     //has already visited from, there is cycle
    //     visited[from] = 1;
        
    //     for(int to = 0; to < graph[0].length; to++){
    //         if(graph[from][to] == 1){
    //             if(visited[to] == 1) return true;   //has already visited
    //             if(hasCycle(to, graph, visited)) return true;
    //         }
    //     }
        
    //     visited[from] = -1; //finish visited
    //     return false;
    // }
    
    // 3.BFS
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0) return true;
        
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            
            if(!graph.containsKey(from)){
                graph.put(from, new LinkedList<Integer>());
            }
            
            indegree[to]++; // means we have one node could reach to, indegree
            List<Integer> list = graph.get(from);
            list.add(to);
            graph.put(from, list);
        }
        
        // put those indegree = 0, into queue
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        int count = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            if(graph.containsKey(curr)){
                for(int i : graph.get(curr)){
                    indegree[i]--;  // minus 1 indegree
                    if(indegree[i] == 0){
                        
                        queue.offer(i);
                    }
                }
            }
            count++;
            
        }
        
        return count == numCourses;
    }
    
    
}
