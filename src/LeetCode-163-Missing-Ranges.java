class Solution {
    // 1.
    /*
    https://leetcode.com/problems/missing-ranges/discuss/50476/Accepted-Java-solution-with-explanation
    
    This solution is not so intuitive and would be difficult to come up with during the interview.
    The top-submitted solution (beats 100%) is much easier to understand and implement in 3 simple steps.

    Find the range between lower and first element in the array.
    Find ranges between adjacent elements in the array.
    Find the range between upper and last element in the array.
    */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(formRange(lower, upper));
            return result;
        }
        
        // 1st step, add [lower, nums[0]]
        if (lower < nums[0]) {
            result.add(formRange(lower, nums[0] - 1));
        }
        
        // 2nd step
        /*
        Input
        [-2147483648,-2147483648,0,2147483647,2147483647]
        -2147483648
        2147483647
        Output
        ["-2147483647->-1","1->2147483646","-2147483648->2147483646"]
        Expected
        ["-2147483647->-1","1->2147483646"]
        
        
        We must check if "nums[i - 1] == nums[i]""
        */
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] != nums[i] && nums[i - 1] + 1 < nums[i]) {
                result.add(formRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        
        // 3rd step
        if (nums[nums.length - 1] < upper) {
            result.add(formRange(nums[nums.length - 1] + 1, upper));
        }
        
        return result;
    }
    
    private String formRange(int low, int hi) {
        return low == hi ? String.valueOf(low) : low + "->" + hi;
    }
    
    // 2. Similar
//      public List<String> findMissingRanges(int[] nums, int lower, int upper) {
//         List<String> result = new ArrayList<>();
//         if (nums == null || nums.length == 0){
//             result.add(formRange(lower,upper));
//             return result;
//         }

//         // 1st step
//         if (nums[0] > lower){
//             result.add(formRange(lower,nums[0]-1));
//         }

//         // 2nd step
//         for (int i = 0; i < nums.length-1; i++){
//             if (nums[i+1] != nums[i] && nums[i+1] > nums[i] +1) {
//                 result.add(formRange(nums[i]+1, nums[i+1]-1));
//             }
//         }

//        // 3rd step
//         if (nums[nums.length-1] < upper){
//             result.add(formRange(nums[nums.length-1]+1, upper));
//         }
//         return result;
//     }
    
//     public String formRange(int low, int high){
//         return low == high ? String.valueOf(low) : (low + "->" + high);
//     }
}
