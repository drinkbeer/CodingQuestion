/*
http://www.programcreek.com/2014/07/leetcode-product-of-array-except-self-java/
Test Case:  [0, 0]  ->  [0, 0]

1.Forward-Backward traversal
O(N) space

2.Forward-Backward traversal
Space   O(N)
*/
public class Solution {
    // 1.
    // public int[] productExceptSelf(int[] nums) {
    //     if(nums == null) return null;
        
    //     int[] result = new int[nums.length];
    //     int[] fromLeft = new int[nums.length];
    //     int[] fromRight = new int[nums.length];
    //     fromLeft[0] = 1;
    //     fromRight[nums.length - 1] = 1;
        
    //     for(int i = 1; i < nums.length; i++){
    //         fromLeft[i] = fromLeft[i - 1] * nums[i - 1];
    //     }
        
    //     for(int i = nums.length - 2; i >= 0; i--){
    //         fromRight[i] = fromRight[i + 1] * nums[i + 1];
    //     }
        
    //     for(int i = 0; i < nums.length; i++){
    //         result[i] = fromLeft[i] * fromRight[i];
    //     }
    //     return result;
    // }
    
    // 2.
//     public int[] productExceptSelf(int[] nums) {
//         if(nums == null) return null;
        
//         int[] result = new int[nums.length];
        
//         result[0] = 1;
//         for(int i = 1; i < nums.length; i++){
//             result[i] = result[i - 1] * nums[i - 1];
//         }
        
//         int right = 1;
//         for(int i = nums.length - 1; i >= 0; i--){
//             result[i] *= right;
//             right *= nums[i];   //be careful
//         }
        
//         return result;
//     }
    
    // 3.
    /* 
    https://leetcode.com/problems/product-of-array-except-self/discuss/65747/How-from-O(N)-to-O(1)
    
    O(1) Space
    */
    public int[] productExceptSelf(int[] nums) {
        if(nums == null) return null;
        
        int[] result = new int[nums.length];
        
        int left = 1, right = 1;
        Arrays.fill(result, 1);
        
        for (int i = 0; i < nums.length; i++) {
            result[i] *= left;
            result[nums.length - i - 1] *= right;
            left *= nums[i];
            right *= nums[nums.length - i - 1];
        }
        
        return result;
    }
    
}
