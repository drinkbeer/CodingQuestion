public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return result;
        
        java.util.Arrays.sort(nums);
        List<Integer> set = new ArrayList<Integer>();
        int start = 0;
        subset(nums, result, set, start);
        return result;
    }
    
    private void subset(int[] nums, List<List<Integer>> result, List<Integer> set, int start){
        result.add(new ArrayList<Integer>(set));
        
        for(int i = start; i < nums.length; i++){
            // if(set.contains(nums[i])){   // don't need, because it's distinct array
            //     continue;
            // }
            set.add(nums[i]);
            subset(nums, result, set, i + 1);
            set.remove(set.size() - 1);
        }
    }
}