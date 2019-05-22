/*
LeetCode: https://leetcode.com/problems/rotate-array/
LintCode: http://www.lintcode.com/problem/rotate-array/
JiuZhang: http://www.jiuzhang.com/solutions/rotate-array/
ProgramCreek: http://www.programcreek.com/2015/03/rotate-array-in-java/



https://leetcode.com/problems/rotate-array/discuss/54250/Easy-to-read-Java-solution

https://leetcode.com/problems/rotate-array/discuss/54308/Simple-and-Most-elegant-logic

*/
public class Solution {
//     public void rotate(int[] nums, int k) {
//         if(nums == null || nums.length <= 1 || k < 1)return;
        
//         k = k % nums.length;    // must ensure k <= length
        
//         reverse(nums, 0, nums.length - 1);
//         reverse(nums, 0, k - 1);
//         reverse(nums, k, nums.length - 1);
//     }
    
//     private void reverse(int[] nums, int lo, int hi){
//         while(lo < hi){
//             int temp = nums[lo];
//             nums[lo] = nums[hi];
//             nums[hi] = temp;
//             lo++;
//             hi--;
//         }
//     }
    
    /*
    https://leetcode.com/problems/rotate-array/discuss/54289/My-three-way-to-solve-this-problem-the-first-way-is-interesting(JAVA)
    */
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        //step each time to move
        int step = k % nums.length;
        int[] tmp = new int[step];
        for(int i = 0; i < step; i++){
            tmp[i] = nums[nums.length - step + i];
        }
        for(int i = nums.length - step - 1; i >= 0; i--){
            nums[i + step] = nums[i];
        }
        for(int i = 0; i < step; i++){
            nums[i] = tmp[i];
        }
        
    }
}
