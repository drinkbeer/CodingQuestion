/*
LeetCode: https://leetcode.com/problems/combination-sum/
LintCode: 
JiuZhang: 
ProgramCreek:
Analysis:
*/
class Solution {
    // Backtrack solution without sort
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) return res;
        
        backtrack(candidates, target, 0, res, new ArrayList<>());
        return res;
    }
    
    private void backtrack(int[] candidates, int target, int start, List<List<Integer>> res, List<Integer> list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, res, list);
            list.remove(list.size() - 1);
        }
        
    }
    
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         if (candidates == null || candidates.length == 0) return result;
        
//         Arrays.sort(candidates);         // As "Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).", we must sort first

//         List<Integer> list = new ArrayList<>();
//         backtrack(candidates, target, 0, result, list);
//         return result;
//     }
    
//     public void backtrack(int[] nums, int target, int start, List<List<Integer>> result, List<Integer> list) {
//         if (target == 0) {
//             result.add(new ArrayList<>(list));
//             return;
//         }
        
//         for (int i = start; i < nums.length; i++) {
//             if (nums[i] > target) return;
            
//             list.add(nums[i]);
//             backtrack(nums, target - nums[i], i, result, list);
//             list.remove(list.size() - 1);
//         }
//     }
}
