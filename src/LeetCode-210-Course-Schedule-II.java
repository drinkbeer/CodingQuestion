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
            
            indegree[to]++;
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        
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
//     public int[] findOrder(int numCourses, int[][] prerequisites) {
//         if(prerequisites == null) return null;
        
//         HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
//         for(int i = 0; i < prerequisites.length; i++){
//             int from = prerequisites[i][1];
//             int to = prerequisites[i][0];
            
//             graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
//         }
        
//         List<Integer> result = new ArrayList<Integer>();
//         int[] visited = new int[numCourses];
//         for(int from = 0; from < numCourses; from++){
//             if(visited[from] == 0 && hasCycle(from, graph, visited, result)){
//                 return new int[0];
//             }
//         }
        
//         return result.stream().mapToInt(i -> i).toArray();
//     }
    
//     private boolean hasCycle(int from, HashMap<Integer, List<Integer>> graph, int[] visited, List<Integer> result){
//         // end condition
//         if (visited[from] == 1) return true;
//         visited[from] = 1;
//         if(graph.containsKey(from)){
//             for(int to : graph.get(from)){
//                 if (visited[to] == 1) return true;
//                 if (visited[to] == 0 && hasCycle(to, graph, visited, result)) return true;
//             }
//         }
        
//         result.add(0, from);
//         visited[from] = -1;
//         return false;
//     }
}
