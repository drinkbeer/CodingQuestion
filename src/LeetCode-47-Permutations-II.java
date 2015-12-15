/*
LeetCode: https://leetcode.com/problems/permutations-ii/
LintCode: http://www.lintcode.com/problem/permutations-ii/
JiuZhang: http://www.jiuzhang.com/solutions/permutations-ii/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-permutations-ii-java/

Analysis:
We use DFS to solve this one, just as Permutations I. What should be careful is the optimization.
We must optimize it in loops!!!!!!

ProgramCreek's solution 2 is simple, but I don't understand the solution.
*/
public class Solution {
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
            result.add(new ArrayList<Integer>(set));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            /*
            Optimize: (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])
            It is essential here.
            For example, [1, 1, 1, 2, 2]. i = 0 is not visited, and now i = 1, actually, we would ignore
            as we scan from i = 0, so i = 0->i = 1 must has already be recorded in result. Also, as we optimized
            here, we don't need to check if it is already exisited in end consition.
            */
            if(visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) ) continue;
            visited[i] = true;
            set.add(nums[i]);
            DFS(nums, visited, result, set);
            set.remove(set.size() - 1);
            visited[i] = false;
        }
    }
}