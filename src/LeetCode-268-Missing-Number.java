/*
http://www.cnblogs.com/grandyang/p/4756677.html

[3,0,1] - 2
[1,2] - 0
[2,1] - 0
[1,0] - 2

*/
class Solution {
    // 1. Filling the nums to the correct location in the array
//     public int missingNumber(int[] nums) {
//         for (int i = 0; i < nums.length; ) {
//             if (nums[i] >= nums.length) {
//                 nums[i] = -1;
//                 i++;
//             } else if (nums[i] == i || nums[i] == -1) {
//                 i++;
//             } else {
//                 // nums[i] is not in the correct location
//                 swap(nums, i, nums[i]);     // swap nums in i, and nums[i]
//             }
//         }
        
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] != i) return i;
//         }
        
//         return nums[nums.length - 1] + 1;
//     }
    
//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
    
    // 2. sum{0,...,n} - sum(nums[0],...,nums[n-1])
    /*
    https://leetcode.com/problems/missing-number/discuss/69795/Java-solution-O(1)-space-and-O(n)-in-time
    */
//     public int missingNumber(int[] nums) {
//         int sum = 0;
//         for (int n : nums) sum += n;
        
//         return nums.length * (nums.length + 1) / 2 - sum;
//     }

    // 3.XOR
    /*
    https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination
    
    a^b^b=a
    
    idx {0, n-1}
    nums[i]  {0,n} but missed one
    
    so we could make a number XOR to all index {0, n}, and then XOR to all nums[0, n-1]
    
    Assume value is k
    So the process will be: k^0^0^1^1^...^n^n, finally the result is k
    */
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for (int i = 0; i < nums.length; i++) {
            res = res^i^nums[i];
        }
        return res;
    }
}
