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
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        
        Arrays.sort(S);
        for(int i : S) {
            List<List<Integer>> tmp = new ArrayList<>();
            for(List<Integer> sub : res) {
                List<Integer> a = new ArrayList<>(sub);
                a.add(i);
                tmp.add(a);
            }
            res.addAll(tmp);
        }
        return res;
    }
}
