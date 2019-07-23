class Solution {
//     // 1. BFS
//     public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
//         HashMap<Integer, Set<Integer>> map = new HashMap<>();   // <pid, children set>
        
//         for (int i = 0; i < pid.size(); i++) {
//             map.computeIfAbsent(ppid.get(i), k -> new HashSet<>()).add(pid.get(i));
//         }
        
//         List<Integer> res = new ArrayList<>();
//         Queue<Integer> queue = new LinkedList<>();
//         queue.offer(kill);
        
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 int curr = queue.poll();
//                 res.add(curr);
                
//                 if (map.containsKey(curr)) {
//                     for (int p : map.get(curr)) {
//                         queue.offer(p);
//                     }
//                 }
//             }
//         }
        
//         return res;
//     }
    
    
    // 2. DFS
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        HashMap<Integer, Set<Integer>> map = new HashMap<>();   // <pid, children set>
        
        for (int i = 0; i < pid.size(); i++) {
            map.computeIfAbsent(ppid.get(i), k -> new HashSet<>()).add(pid.get(i));
        }
        
        List<Integer> res = new ArrayList<>();
        recursive(map, kill, res);
        return res;
    }
    
    private void recursive(HashMap<Integer, Set<Integer>> map, int curr, List<Integer> res) {
        res.add(curr);
        if (!map.containsKey(curr)) return;
                
        for (int p : map.get(curr)) {
            recursive(map, p, res);
        }
    }
}
