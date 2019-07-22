/*
http://www.cnblogs.com/grandyang/p/6222149.html
https://github.com/drinkbeer/CodingQuestion/blob/master/src/LeetCode-41-First-Missing-Positive.java
*/
class Solution {
//     public List<Integer> findDisappearedNumbers(int[] nums) {
//         List<Integer> res = new ArrayList<>();
        
//         int i = 0;
//         while (i < nums.length) {
//             if (nums[i] == i + 1) {
//                 i++;
//             } else if (nums[nums[i] - 1] != nums[i]) {
//                 swap(nums, i, nums[i] - 1);
//             } else {
//                 i++;
//             }
//         }
        
//         for (i = 0; i < nums.length; i++) {
//             if (nums[i] != i + 1) {
//                 res.add(i + 1);
//             }
//         }
        
//         return res;
//     }
    
//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
    
    // 2. Another approach
    /*
    https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/discuss/92956/Java-accepted-simple-solution
    The basic idea is that we iterate through the input array and mark elements as negative using nums[nums[i] -1] = -nums[nums[i]-1]. In this way all the numbers that we have seen will be marked as negative. In the second iteration, if a value is not marked as negative, it implies we have never seen that index before, so just add it to the return list.

    */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                ret.add(i+1);
            }
        }
        return ret;
    }
}
