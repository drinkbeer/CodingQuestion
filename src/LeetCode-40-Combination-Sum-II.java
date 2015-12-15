/*
LeetCode: https://leetcode.com/problems/combination-sum-ii/
LintCode: http://www.lintcode.com/problem/combination-sum-ii/
JiuZhang: http://www.jiuzhang.com/solutions/combination-sum-ii/
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-combination-sum-ii-java/

Analysis:
Just looks like Combination Sum I, but not duplicates here.
Optimize in 2 places:
1.In end condition, judge if set is contained in result
2.Judge target is smaller than next element. (quite essential)
*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) return result;
        
        java.util.Arrays.sort(candidates);
        List<Integer> set = new ArrayList<Integer>();
        DFS(candidates, target, 0, result, set);
        return result;
    }
    
    private void DFS(int[] candidates, int target, int start, List<List<Integer>> result, List<Integer> set){
        // end condition
        if(target == 0){
            if(!result.contains(set)){
                result.add(new ArrayList<Integer>(set));
            }
            return;
        }
        
        for(int i = start; i < candidates.length; i++){
            if(target < candidates[i]) return;    // an optimizing here, it's crucial!!!!!!
            
            set.add(candidates[i]);
            DFS(candidates, target - candidates[i], i + 1, result, set);
            set.remove(set.size() - 1);
        }
    }
}