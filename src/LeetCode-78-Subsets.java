public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return result;
        
        java.util.Arrays.sort(nums);  // not necessary
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

/*
1.Recursive

If the order doesn't matter and no duplicate, then don't need sort. For the combination sum, we may need sort.

2.Iterative.

Appending each value in nums to the existing lists in the result.
*/

class Solution {
    // 1. Recursive
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> result = new ArrayList<List<Integer>>();
//         if (nums == null) return result;
        
//         List<Integer> list = new ArrayList<>();
//         subsets(nums, 0, result, list);
//         return result;
//     }
    
//     private void subsets(int[] nums, int start, List<List<Integer>> result, List<Integer> list) {
//         result.add(new ArrayList<>(list));
        
//         for (int i = start; i < nums.length; i++) {
//             list.add(nums[i]);
//             subsets(nums, i + 1, result, list);
//             list.remove(list.size() - 1);
//         }
//     }
    
    // 2.Iterative
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        
        result.add(new ArrayList<>());
        
        for (int i : nums) {
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for (List<Integer> sub : result) {
                List<Integer> list = new ArrayList<>(sub);  // have to create a copy of the sub list, otherwise the next line will pollute the existing result.
                list.add(i);
                temp.add(list);
            }
            result.addAll(temp);  // we have to add the temp after we finished the above for-loop, as it's loop the result.
        }
        return result;
    }
}
