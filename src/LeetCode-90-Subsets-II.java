/*
LeetCode: https://leetcode.com/problems/subsets-ii/
LintCode: http://www.lintcode.com/problem/subsets-ii/
JiuZhang: http://www.jiuzhang.com/solutions/subsets-ii/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-subsets-ii-java/

Analysis:
DFS. Notice the two ways to filter duplicates. It's more efficient to filter duplicates in loop.
*/
class Solution {
    // 1.DFS
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         if (nums == null) return result;
        
//         Arrays.sort(nums);
//         List<Integer> list = new ArrayList<>();
//         subsetsWithDup(nums, 0, result, list);
//         return result;
//     }
    
//     private void subsetsWithDup(int[] nums, int start, List<List<Integer>> result, List<Integer> list) {
//         if (!result.contains(list)) {
//             result.add(new ArrayList<>(list));
//         }
        
//         for (int i = start; i < nums.length; i++) {
//             // if (i > start && nums[i - 1] == nums[i]) continue;
//             list.add(nums[i]);
//             subsetsWithDup(nums, i + 1, result, list);
//             list.remove(list.size() - 1);
//         }
//     }
    
    
    // 2.DFS
//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         if(nums == null || nums.length < 1) return result;
        
//         java.util.Arrays.sort(nums);
//         List<Integer> set = new ArrayList<Integer>();
//         DFS(nums, 0, result, set);
//         return result;
//     }
    
//     private void DFS(int[] nums, int start, List<List<Integer>> result, List<Integer> set){
//         // First way: Filter duplicates in result
//         // if(!result.contains(set)){
//             result.add(new ArrayList<Integer>(set));
//         // }
        
        
//         for(int i = start; i < nums.length; i++){
//             // Wrong way to filter duplicates. For instance, nums=[1,1], result[[1],[1,1]]
//             // if(set.contains(nums[i])){
//             //     continue;
//             // }
//             // Second way: Another better way to filter duplicates in loop:
//             if(i != start && nums[i - 1] == nums[i]) continue;
//             set.add(nums[i]);
//             DFS(nums, i + 1, result, set);
//             set.remove(set.size() - 1);
//         }
//     }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        
        result.add(new ArrayList<>());
        
        Arrays.sort(nums);  // have to sort here is we want to skip duplicates
        for (int i : nums) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            
            for (List<Integer> sub : result) {
                List<Integer> list = new ArrayList<>(sub);  // have to create a new list to avoid polluating the existing results
                list.add(i);
                
                if (result.contains(list)) continue;  // have to skip the duplicates
                
                temp.add(list);
            }
            
            result.addAll(temp);
        }
        
        return result;
    }
}
