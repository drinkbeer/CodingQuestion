/*
LeetCode: https://leetcode.com/problems/permutations/
LintCode: http://www.lintcode.com/problem/permutations/
JiuZhang: http://www.jiuzhang.com/solutions/permutations/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-permutations-java/

Analysis:
1.DFS(recursive)

2.BFS(itertive)
*/
class Solution {
    // 1.DFS(recursive)
//     public List<List<Integer>> permute(int[] nums) {
//         if(nums == null || nums.length == 0) return null;
        
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         List<Integer> set = new ArrayList<Integer>();
        
//         helper(nums, result, set);
//         return result;
//     }
    
//     private void helper(int[] nums, List<List<Integer>> result, List<Integer> set) {
//         if (set.size() == nums.length) {
//             // Be careful: here we must create a new set to add to result
//             result.add(new ArrayList<>(set));
//             return;
//         }
        
//         for (int i = 0; i < nums.length; i++) {
//             if (set.contains(nums[i])) continue; // skip duplicates
//             set.add(nums[i]);
//             helper(nums, result, set);
//             set.remove(set.size() - 1);
//         }
//     }
    
    // 2.BFS(iterative)
    
    /*
    https://leetcode.com/problems/permutations/discuss/18237/My-AC-simple-iterative-javapython-solution
    Analysis
    TimeComplexity: O(N!) it's N's factorial time complexity
    
    Insert 1:
    [1]
    
    Insert 2:
    [2, 1]
    [1, 2]
    
    Insert 3:
    [3, 2, 1]
    [3, 1, 2]
    [2, 3, 1]
    [1, 3, 2]
    [2, 1, 3]
    [1, 2, 3]
    
    */
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        
        // Gradually insert the numbers to the result row by row
        for (int i = 0; i < nums.length; i++) {
            // start insertion of the first row
            List<List<Integer>> tempResult = new ArrayList<List<Integer>>();
            
            for (int insertPos = 0; insertPos <= i; insertPos++) {
                // the insertPos could be at the beginning of the existing list, it could also be the end of the existing list,
                // so the insertPos could be "i"
                
                for (List<Integer> sub : result) {
                    List<Integer> row = new ArrayList<>(sub);
                    row.add(insertPos, nums[i]);
                    tempResult.add(row);
                }
                
            }
            result = tempResult;
        }
        
        return result;
    }
    
}
