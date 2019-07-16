class Solution {
    // There is problem with this solution
//     public int leastInterval(char[] tasks, int n) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (char c : tasks) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }
        
//         int res = 0;
//         while (!map.isEmpty()) {
//             int count = 0;
            
//             Set<Character> set = new HashSet<>(map.keySet());
//             for (char key : set) {
//                 if (map.get(key) == 1) {
//                     map.remove(key);
//                 } else {
//                     map.put(key, map.get(key) - 1);
//                 }
//                 count++;
//                 if (count == n + 1) break;
//             }
            
//             res += n + 1;
//         }
        
//         return res;
//     }
    
    // 1. Greedy
    /*
    Pretty Difficult to understand.
    
    https://leetcode.com/problems/task-scheduler/discuss/104496/concise-java-solution-on-time-o26-space
    https://www.cnblogs.com/grandyang/p/7098764.html
    https://blog.csdn.net/TheSnowBoy_2/article/details/73556561
    
    
    Ex1: (result == tasks.length == frame size)
    3 identical chunks "CE", "CE CE CE" <-- this is a frame
    insert 'A' among the gaps of chunks since it has higher frequency than 'B' ---> "CEACEACE"
    insert 'B' ---> "CEABCEACE" <----- result is tasks.length;

    Ex2: (res == tasks.length > frame size)
    3 identical chunks "CE", "CE CE CE" <--- this is a frame.
    Begin to insert 'A'->"CEA CEA CE"
    Begin to insert 'B'->"CEABCEABCE" <---- result is tasks.length;
    
    Ex3: (res > tasks.length, res < frame.size)
    3 identical chunks "CE", "CE CE CE" <-- this is a frame
    Begin to insert 'A' --> "CEACE CE" <-- result is (c[25] - 1) * (n + 1) + 25 -i = 2 * 3 + 2 = 8
    
    */
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }
        Arrays.sort(freq);  // sort the frequency ascending
        
        int numSlots = freq[25] - 1;
        int sizeSlots = n + 1;
        
        int i = 25, max = freq[25];
        while (i >= 0 && max == freq[i]) i--;
        int residue = 25 - i;
        
        return Math.max(tasks.length, numSlots * sizeSlots + residue);
    }
    
}
