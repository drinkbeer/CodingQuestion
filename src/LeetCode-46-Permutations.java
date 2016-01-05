/*
LeetCode: https://leetcode.com/problems/permutations/
LintCode: http://www.lintcode.com/problem/permutations/
JiuZhang: http://www.jiuzhang.com/solutions/permutations/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-permutations-java/

Analysis:
1.DFS(recursive)

2.BFS(itertive)
*/
public class Solution {
    // 1.DFS(recursive)
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        
        helper(nums, result, set);
        return result;
    }
    
    // DFS search
    private void helper(int[] nums, List<List<Integer>> result, 
            List<Integer> set){
        
        if(set.size() == nums.length){
            // Be careful: here we must create a new set to add to result
            result.add(new ArrayList<Integer>(set));
        }
        
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
            helper(nums, result, set);
            set.remove(set.size() - 1);
        }
    }
    
    // 2.BFS(iterative)
}