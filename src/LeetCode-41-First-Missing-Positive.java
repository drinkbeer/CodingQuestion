/*
LeetCode:  https://leetcode.com/problems/first-missing-positive/
LintCode:  http://www.lintcode.com/en/problem/first-missing-positive/
JiuZhang:  http://www.jiuzhang.com/solutions/first-missing-positive/
ProgramCreek:  http://www.programcreek.com/2014/05/leetcode-first-missing-positive-java/
Other: http://www.cnblogs.com/yuzhangcmu/p/4200096.html

Analysis:  
Hard problem.
[3, 4, -1, 1]       // while(), not if()
[1, 1]              // if(temp == nums[i]) break;
[-1,4,2,1,9,10]     // nums[i] <= nums.length



1.Brute Force, using a HashSet

这道题让我们找缺失的首个正数，由于限定了O(n)的时间，所以一般的排序方法都不能用，最开始我没有看到还限制了空间复杂度，所以想到了用HashSet来解，
这个思路很简单，第一遍遍历数组把所有的数都存入HashSet中，并且找出数组的最大值，下次循环从1开始递增找数字，哪个数字找不到就返回哪个数字，
如果一直找到了最大的数字，则返回最大值+1.




2.Rearrange the array


https://leetcode.com/problems/first-missing-positive/discuss/17083/O(1)-space-Java-Solution


基本思路就是把数组中的数值处于[1,n]的数，重新防止到[0,n-1]这些index的位置中。防止好了之后检查一下nums[i]是否等于i+1，第一个不满足条件的index，那么返回的值就是index+1.


扫描数组中每个数，有下面这些情况：

1. 如果A[i]<=0或者A[i]>n。说明A[i]一定不是first missing positive。跳过
2. 如果A[i] = i+1，说明A[i]已经在正确的位置，跳过
3. 如果A[i]!=i+1，且0<A[i]<=n，应当将A[i]放到A[A[i]-1]的位置，所以可以交换两数。
这里注意，当A[i] = A[A[i]-1]时会陷入死循环。这种情况下直接跳过。
这里交换之前需要检查一下我们交换的destination是不是已经在正确的位置了：
我们要把i和A[i]-1的数进行swap，那么A[i]-1就是destination的index，desitination的value就是A[i]

*/
public class Solution {
//     public int firstMissingPositive(int[] nums) {
//         if(nums == null || nums.length == 0) return 1;
        
//         for(int i = 0; i < nums.length; i++){
//             // 1.nums[i] not in its place
//             // 2.nums[i]-1 should in index range
//             while(nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length){
//                 int temp = nums[nums[i] - 1];
//                 if(temp == nums[i]) break;
//                 nums[nums[i] - 1] = nums[i];
//                 nums[i] = temp;
//             }
//         }
        
//         for(int i = 0; i < nums.length; i++){
//             if(nums[i] != i + 1) return i + 1;
//         }
        
//         return nums.length + 1;
//     }
    
    // 1.Brute Force, using a HashSet, Space O(N)
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length) {
                set.add(nums[i]);
            }
        }
        
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)) return i;
        }
        
        return nums.length + 1;
    }
    
    // 2.Space O(1), rearrange the array
//     public int firstMissingPositive(int[] nums) {
//         if (nums == null || nums.length == 0) return 1;
        
//         int i = 0;
//         while (i < nums.length) {
//             if (nums[i] <= 0 || nums[i] > nums.length || nums[i] == i + 1){
//                 i++;
//             } else if (nums[nums[i] - 1] != nums[i]) {
//                 // check if the destination (nums[i] - 1) is eligible for swapping
//                 // if the destination already has the value to be nums[i], then we don't swap it.
//                 // Destination Index: nums[i] - 1, destination target value: nums[i]
//                 swap(nums, i, nums[i] - 1);
//             } else {
//                 // which means the destination has already been in the correct value, we just "continue" here.
//                 i++;
//             }
//         }
        
//         i = 0;
//         while (i < nums.length && nums[i] == i + 1) i++;
        
//         return i + 1;
//     }
    
//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
}
