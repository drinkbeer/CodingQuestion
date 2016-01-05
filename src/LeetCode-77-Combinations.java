/*
LeetCode: https://leetcode.com/problems/combinations/
LintCode: http://www.lintcode.com/problem/combinations/
JiuZhang: http://www.jiuzhang.com/solutions/combinations/
ProgramCreek: http://www.programcreek.com/2014/03/leetcode-combinations-java/

Analysis: 
DFS

*/
public class Solution {
    
    // 1.DFS(recursive)
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();

        if(n <= 0 || n < k) return result;
        if(n == k){
            for(int i = 0; i < n; i++){
                set.add(i + 1);
            }
            result.add(set);
            return result;
        }
        
        int start = 0;
        combine(n, k, start, result, set);
        return result;
    }
    
    private void combine(int n, int k, int start, List<List<Integer>> result, List<Integer> set){
        if(set.size() == k){
            result.add(new ArrayList<Integer>(set));
            return;
        }
        
        for(int i = start; i < n; i++){
            if(set.contains(i + 1)){
                continue;
            }
            set.add(i + 1);
            combine(n, k, i + 1, result, set);
            set.remove(set.size() - 1);
        }
    }
}