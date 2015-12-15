/*
LeetCode: https://leetcode.com/problems/combination-sum/
LintCode: 
JiuZhang: 
ProgramCreek:

Analysis:

*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) return result;
        
        List<Integer> set = new ArrayList<Integer>();
        // As "Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).", we must sort first
        java.util.Arrays.sort(candidates);
        DFS(candidates, target, 0, result, set);
        return result;
    }
    
    private void DFS(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> set){
        // end condition
        if(target == 0){
            result.add(new ArrayList<Integer>(set));
            return;
        }
        
        for(int i = start; i < candidates.length; i++){
            if(target < candidates[i]) return;
            
            set.add(candidates[i]);
            DFS(candidates, target - candidates[i], i, result, set);    // here we must start from i
            set.remove(set.size() - 1);
        }
        
    }
    
}