class Solution {
    /*
    https://leetcode.com/problems/exclusive-time-of-functions/discuss/293215/Simple-Java-solution-using-Stack
    https://leetcode.com/problems/exclusive-time-of-functions/discuss/105084/How-is-function-1-executing-4-units-of-time
    
    */
//     public int[] exclusiveTime(int n, List<String> logs) {
//         if (n == 0 || logs.size() == 0) return new int[0];
        
//         List<Pair> pairs = new ArrayList<>();
//         for (String str : logs) {
//             pairs.add(parseLogs(str));
//         }
        
//         Stack<Pair> stack = new Stack<>();
//         int[] res = new int[n];
//         int prevStartTime = 0;
//         for (Pair p : pairs) {
//             if ("start".equals(p.sign)) {
//                 if (!stack.isEmpty()) {
//                     Pair prev = stack.peek();
//                     res[prev.id] += p.time - prevStartTime;
//                 }
                
//                 stack.push(p);
//                 prevStartTime = p.time;
//             } else {
//                 Pair start = stack.pop();   // start.id must equals p.id
//                 res[p.id] += p.time - prevStartTime + 1;
//                 prevStartTime = p.time + 1;
//             }
//         }
        
//         return res;
//     }
    
//     private Pair parseLogs(String log) {
//         String[] strs = log.split(":");
//         int id = Integer.parseInt(strs[0]);
//         String sign = strs[1];
//         int time = Integer.parseInt(strs[2]);
//         return new Pair(id, sign, time);
//     }
    
//     private class Pair {
//         int id;
//         String sign;
//         int time;
        
//         public Pair(int id, String sign, int time) {
//             this.id = id;
//             this.sign = sign;
//             this.time = time;
//         }
//     }
    
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0 || logs.size() == 0) return new int[0];
        
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevStartTime = 0;
        for (String s : logs) {
            String[] strs = s.split(":");
            int id = Integer.parseInt(strs[0]);
            int time =  Integer.parseInt(strs[2]);
            
            if ("start".equals(strs[1])) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += time - prevStartTime; // time should not be included
                }
                
                stack.push(id);
                prevStartTime = time;
            } else {
                res[stack.pop()] += time - prevStartTime + 1;
                prevStartTime = time + 1;
            }
        }
        
        return res;
    }
}
