/*
http://www.programcreek.com/2014/06/leetcode-course-schedule-ii-java/


*/
public class Solution {
    
    // 1.BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites == null) return null;
        
        int[] result = new int[numCourses];
        // Note: don't forget that there is no prerequisite course
        if(prerequisites.length == 0 || prerequisites[0].length == 0){
            for(int i = 0; i < numCourses; i++){
                result[i] = i;
            }
            return result;
        }
        
        int[] indegree = new int[numCourses];   // the # of indegree of each course
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < prerequisites.length; i++){
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            
            if(!graph.containsKey(from)){
                graph.put(from, new ArrayList<Integer>());
            }
            
            indegree[to]++;
            graph.get(from).add(to);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
        
        // result[0] = 0;
        // return result;
        
        int index = 0, count = 0;
        while(!queue.isEmpty()){
            int from = queue.poll();
            count++;
            result[index++] = from;
            
            if(graph.containsKey(from)){
                for(int i : graph.get(from)){
                    indegree[i]--;
                    if(indegree[i] == 0){
                        // indegree==0 mens, all prerequisite course has been selected.
                        queue.offer(i);
                    }
                }
            }
        }
        
        return count == numCourses? result : new int[0];
    }
    
    // 2.DFS
    // public int[] findOrder(int numCourses, int[][] prerequisites) {
    //     if(prerequisites == null || prerequisites.length == 0) return null;
        
    //     HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
    //     for(int i = 0; i < prerequisites.length; i++){
    //         int from = prerequisites[i][1];
    //         int to = prerequisites[i][0];
            
    //         if(!graph.containsKey(from)){
    //             graph.put(from, new ArrayList<Integer>());
    //         }
            
    //         List<Integer> list = graph.get(from);
    //         list.add(to);
    //         graph.put(from, list);
    //     }
        
    //     int[] visited = new int[numCourses];
    //     for(int i = 0; i < numCourses; i++){
    //         if(visited[i] == 0){
    //             DFS();
    //         }
    //     }
        
    //     List<Integer> result = new ArrayList<Integer>();
        
    // }
    
    // private void DFS(int from, HashMap<Integer, List<Integer>> graph, int[] visited, List<Integer> result){
    //     // end condition
    //     if(visited.length == result.size()) return;
    //     visited[from] = 1;
        
    //     if(graph.containsKey(from)){
    //         for(int i : graph.get(from)){
    //             if(visited[i] == 0){
    //                 DFS(i, graph, visited, );
    //             }
    //         }
            
    //     }
    // }
}
