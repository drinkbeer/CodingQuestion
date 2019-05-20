public class Solution {
    
    // 1.
    /*
    https://leetcode.com/problems/maximum-product-subarray/discuss/48252/Sharing-my-solution%3A-O(1)-space-O(n)-running-time
    https://leetcode.com/problems/maximum-product-subarray/discuss/48330/Simple-Java-code
    */
//     public int maxProduct(int[] nums) {
//         if (nums == null || nums.length == 0) return 0;

//         int min = nums[0], max = nums[0], result = nums[0];
//         for (int i = 1; i < nums.length; i++) {
//             int temp = max;
//             max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
//             min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);
//             result = Math.max(result, max);
//         }
//         return result;
//     }
    
    // 2.
    /*
    Inspired by: https://leetcode.com/problems/maximum-product-subarray/discuss/48230/Possibly-simplest-solution-with-O(n)-time-complexity
    
    */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int min = nums[0], max = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            result = Math.max(result, max);
        }
        return result;
    }

}
