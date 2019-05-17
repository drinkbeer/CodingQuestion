/*
LeetCode: https://leetcode.com/problems/jump-game-ii/
LintCode: http://www.lintcode.com/problem/jump-game-ii/
JiuZhang: http://www.jiuzhang.com/solutions/jump-game-ii/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-jump-game-ii-java/
Other: http://www.cnblogs.com/lichen782/p/leetcode_Jump_Game_II.html

Analysis:
1.DP
TLE

2.Greedy(From JiuZhang)
Scan from 0 to end, and the scanning process is divided into severl phases -- [start, end]
In each [start, end], and farthest place could reach. Farthest is new end, oldEnd + 1 is new start.
Loop the above step until end reach nums.length-1.

3.Greedy(From ProgramCreek)
This is the same as Greedy2. But it's more difficult to understand.
Scan from 0 to end, the scanning process is divided into several phases -- [lastReach, newReach]
In each [lastReach, newReach], get the farthest could be reached. Farthest is a new newReach, lastReach is newReach+1
Loop the above step until newReach reach nums.length-1
*/
public class Solution {
    
    // 1.Dynamic Programming
    // Time Limit Exceeded 
    // public int jump(int[] nums) {
    //     if(nums == null || nums.length == 0) return 0;
        
    //     int[] steps = new int[nums.length];
    //     steps[0] = nums[0];
        
    //     for(int i = 1; i < nums.length; i++){
    //         for(int j = 0; j < i; j++){
    //             if(j + nums[j] > i) steps[i] = steps[j] + 1;
    //         }
    //     }
        
    //     return steps[nums.length - 1];
    // }
    
    // 2.Greedy (I think is the best solution)
    // public int jump(int[] nums) {
    //     if(nums == null || nums.length == 0) return 0;
        
    //     int start = 0, end = 0, steps = 0;
        
    //     while(end < nums.length - 1){
    //         steps++;
    //         int farthest = end;
    //         for(int i = start; i <= end; i++){
    //             farthest = Math.max(farthest, i + nums[i]);
    //         }
    //         start = end + 1;
    //         end = farthest;
    //     }
        
    //     return steps;
    // }
    
    // 3.Greedy
    public int jump(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int steps = 0;
        int max = nums[0];  // the max pace could be reached in curr phase
        int reach = 0;      // the max pace could be reached in last phase
        
        for(int i = 0; i < nums.length; i++){
            if(i > max) return 0;
            
            // start a new phase
            if(i > reach){
                steps++;
                reach = max;
            }
            
            // calculate max pace could be reached in every loop of curr phase
            max = Math.max(max, i + nums[i]);
        }
        return steps;
    }
}

class Solution {
//     public int jump(int[] nums) {
//         if (nums == null || nums.length == 0) return -1;
//         if (nums.length <= 1) return 1;
        
//         int[] steps = new int[nums.length];
//         steps[0] = nums[0];
        
//         for (int i = 0; i < steps.length; i++) steps[i] = Integer.MAX_VALUE;
        
//         for (int i = 1; i < nums.length; i++) {
//             for (int j = 0; j <= i; j++) {
//                 if (j + nums[j] > i) steps[i] = Math.min(steps[i], steps[j] + 1);
//             }
//         }
        
//         return steps[steps.length - 1];
//     }
    
    // 1. DP (backward)
    // https://leetcode.com/problems/jump-game-ii/discuss/292783/Java-DP-First-Thought
    /*
    DP backward. Using current status to calculate the status afterward.
    
    Time O(N^2)
    
    current status -> status afterward
    
    This solution is slow.
    Runtime: 272 ms, faster than 19.79% of Java online submissions for Jump Game II.
    */
//     public int jump(int[] nums) {
//         if(nums == null || nums.length == 0) return 0;
        
//         int[] steps = new int[nums.length];     // means the min step to reach the ith block
//         Arrays.fill(steps, Integer.MAX_VALUE);  // As the problem assumes that we can always reach the last index
//         steps[0] = 0;
        
//         for (int i = 0; i < nums.length; i++){
//             for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
//                 steps[j] = Math.min(steps[j], steps[i] + 1); // j is in the reachable range from i
//             }
//         }
        
//         return steps[nums.length - 1];
//     }
    
    // 2. DP (forward)
    // Time Limit Exceeded
    /*
    DP forward. Using the status in the forward to calculate current status.
    
    Time O(N^2)
    
    forward status -> current status
    
    */
//     public int jump(int[] nums) {
//         if(nums == null || nums.length == 0) return 0;

//         int[] steps = new int[nums.length];     // means the min step to reach the ith block
//         Arrays.fill(steps, Integer.MAX_VALUE);  // As the problem assumes that we can always reach the last index
//         steps[0] = 0;
        
//         for (int i = 1; i < nums.length; i++){
//             for (int j = 0; j <= i; j++) {
//                 if (j + nums[j] >= i) steps[i] = Math.min(steps[i], steps[j] + 1); // j is in the reachable range from i
//             }
//         }
        
//         return steps[nums.length - 1];
//     }
    
    // 3. Greedy
    /*
    start is the start index
    end is the end index
    
    each step is [start, end], including start and end
    
    end condition is 
    
    1.end >= nums.length - 1.
    2.fastest <= end.
    3.fastest >= nums.length - 1
    
    注意这里end == nums.length - 1就可以结束了，因为==意思是已经到最后一个block了，不需要再跳一次了。
    
    */
//     public int jump(int[] nums) {
//         if(nums == null || nums.length == 0) return 0;
        
//         int start = 0, end = 0, steps = 0;
        
//         while (end < nums.length - 1) {
//             steps++;
//             int fastest = end;
//             for (int i = start; i <= end; i++) {
//                 fastest = Math.max(fastest, i + nums[i]);
//             }
            
//             // Before proceeding to next new [start, end], let's check some end condition.
//             if (fastest <= end) return -1;
//             if (fastest >= nums.length - 1) return steps;
            
//             // proceed to next new [start, end]
//             start = end + 1;
//             end = fastest;
//         }
        
//         return steps;
//     }
    
    // 4.BSF
    /*
    https://leetcode.com/problems/jump-game-ii/discuss/18028/O(n)-BFS-solution
    
    similar to the 3rd Greedy solution.
    
    Each [start, end] is one level (one step), each time we go through one level, and find the fastest block can be reached from this block.
    
    End condition is, we cannot find a new max (i > currMax).
    
    */
    public int jump(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        
        int currMax = 0;  // mark the index of the last element in current level (the fastest block current level could reach), in each level traverse [first i in the level, currMax]
        int i = 0, level = 0;
        
        while (i <= currMax) {
            level++;
            
            int fastest = currMax; // fastest to mark the last element in the next level
            for(; i <= currMax; i++){	//traverse current level , and update the max reach of next level
                fastest = Math.max(fastest, nums[i] + i);
                if(fastest >= nums.length - 1) return level;   // if last element is in level+1,  then the min jump=level 
             }
             currMax = fastest;
        }
        
        return 0;
    }
    
    // similar to the BFS solution.
//     public int jump(int[] A) {
       
//        if (A.length < 2)
//            return 0;
       
//         Map<Integer, Integer> map = new HashMap<>();
        
//         Queue<Integer> q = new LinkedList<>();
//         int n = A.length;
        
//         q.add(0);
//         map.put(0, 0);
        
//         while (q.size() != 0)
//         {
//             int index = q.remove();            
//             int count = map.get(index);

//             for(int i=A[index]; i > 0; i--)
//             {
//                 int next = index + i;
//                 if (next >= n - 1)
//                     return count + 1;

//                 if (!map.containsKey(next))
//                 {
//                     map.put(next, count + 1);
//                     q.add(next);
//                 }                    
//             }
//         }
//         return -1;
//     }
}
