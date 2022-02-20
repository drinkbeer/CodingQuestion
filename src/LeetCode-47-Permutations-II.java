/*
LeetCode: https://leetcode.com/problems/permutations-ii/
LintCode: http://www.lintcode.com/problem/permutations-ii/
JiuZhang: http://www.jiuzhang.com/solutions/permutations-ii/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-permutations-ii-java/

Analysis:
1.DFS(recursive)
We use DFS to solve this one, just as Permutations I. What should be careful is the optimization.
We must optimize it in loops!!!!!!

2.BFS(iterative)
ProgramCreek's solution 2 is simple, but I don't understand the solution.

*/
class Solution {
    
    // 1.DFS (recursive)
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null) return result;
        
        List<Integer> set = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        java.util.Arrays.sort(nums);
        
        DFS(nums, visited, result, set);
        return result;
    }
    
    private void DFS(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> set){
        // end condition
        if(set.size() == nums.length){
            // if(!result.contains(set)){
                result.add(new ArrayList<Integer>(set));
            // }
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            /*
            Optimize: (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])
            It is essential here.
            For example, [1, 1, 1, 2, 2]. i = 0 is not visited, and now i = 1, actually, we would ignore
            as we scan from i = 0, so i = 0->i = 1 must has already be recorded in result. Also, as we optimized
            here, we don't need to check if it is already exisited in end condition.
            */
            if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) ) continue;
            set.add(nums[i]);
            visited[i] = true;
            DFS(nums, visited, result, set);
            set.remove(set.size() - 1);
            visited[i] = false;
        }
    }
        
    // 2.BFS (iterative). Inserting the numbers row by row to different positions in the row.
//     public List<List<Integer>> permuteUnique(int[] nums) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         if (nums == null || nums.length == 0) return result;
        
//         result.add(new ArrayList<>());
        
//         // Start inserting the numbers in nums row by row
//         for (int i = 0; i < nums.length; i++) {
//             List<List<Integer>> tempResult = new ArrayList<List<Integer>>();
            
//             for (int insertPos = 0; insertPos <= i; insertPos++) {
                
//                 for (List<Integer> sub : result) {
//                     List<Integer> row = new ArrayList<>(sub);
//                     row.add(insertPos, nums[i]);
//                     if (tempResult.contains(row)) continue;
//                     tempResult.add(row);
//                 }
                
//             }
            
//             result = tempResult;
//         }
        
//         return result;
//     }
}
