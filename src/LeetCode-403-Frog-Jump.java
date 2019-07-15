class Solution {
    // DP (Push, TLE)
    /*
    subproblem:
    dp[i]   -   the number of jumps from the previous stone to curr stone, cound be more than one steps
    
    recurrence relation:
    
    Test Case:
    [0,1,3,6,10,15,16,21]
    [0]  [1]  [2]  []  []  []  []  []  ======
    [0]  [1]  [2]  [3]  []  []  []  []  ======
    [0]  [1]  [2]  [3]  [4]  []  []  []  ======
    [0]  [1]  [2]  [3]  [4]  [5]  []  []  ======
    [0]  [1]  [2]  [3]  [4]  [5]  []  [6]  ======
    16 is skipped. Frog directly jump to last stone.
    */
//     public boolean canCross(int[] stones) {
//         List<Integer>[] dp = new ArrayList[stones.length];
//         for (int i = 0; i < dp.length; i++) {
//             dp[i] = new ArrayList<>();
//         }
//         dp[0].add(0);
        
//         if (stones[1] != stones[0] + 1) return false;
//         dp[1].add(1);
        
//         for (int i = 1; i < stones.length; i++) {
//             if (dp[i].size() == 0) continue;
            
//             for (int step : dp[i]) {
//                 for (int j = i + 1; j < stones.length; j++) {
//                     if (stones[j] == stones[i] + step - 1) {
//                         dp[j].add(step - 1);
//                     } else if (stones[j] == stones[i] + step) {
//                         dp[j].add(step);
//                     } else if (stones[j] == stones[i] + step + 1) {
//                         dp[j].add(step + 1);
//                     }

//                     if (stones[j] >= stones[i] + step + 1) break;
//                     if (stones[i] + step + 1 >= stones[stones.length - 1]) return true;
//                 }
//             }
//             // for (List<Integer> l : dp) {
//             //     System.out.print(l + "  ");
//             // }
//             // System.out.println("======");
//         }
//         return dp[dp.length - 1].size() > 0;
//     }
    
    // 2. Push
    /*
    https://leetcode.com/problems/frog-jump/discuss/88824/Very-easy-to-understand-JAVA-solution-with-explanations
    
    subproblem:
    HashMap<stones[i], set>     -   the steps could be walked out from ith stone to next stones.
    
    recurrence relation:
    for (int step : set) {
        int reach = stones[i] + step;
        set = map.get(reach);
        
        set.add(step - 1);
        set.add(step);
        set.add(step + 1)
    }
    
    init:
    map.put(stones[0], set)
    set.add(1)
    
    ans:
    if any of the reach >= stoens[stones.length - 1], return true
    */
    public boolean canCross(int[] stones) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            map.put(stones[i], new HashSet<>());
        }
        map.get(stones[0]).add(1);
        
        for (int i = 0; i < stones.length - 1; i++) {
            int stone = stones[i];
            for (int step : map.get(stone)) {
                int reach = stone + step;
                if (reach == stones[stones.length - 1]) return true;
                if (!map.containsKey(reach)) continue;
                
                HashSet<Integer> set = map.get(reach);
                if (step - 1 > 0) set.add(step - 1);
                set.add(step);
                set.add(step + 1);
            }
        }
        return false;
    }
}
