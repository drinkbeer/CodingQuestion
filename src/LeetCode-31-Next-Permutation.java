/*
https://discuss.leetcode.com/topic/30212/easiest-java-solution/2
http://www.programcreek.com/2014/06/leetcode-next-permutation-java/

The steps to solve this problem:
1) scan from right to left, find the first element that is less than its previous one.

4 5 6 3 2 1 
  |
  p

2) scan from right to left, find the first element that is greater than p.

4 5 6 3 2 1 
    |
    q

3) swap p and q

4 5 6 3 2 1 
swap
4 6 5 3 2 1 

4) reverse elements [p+1, nums.length]

4 6 1 2 3 5 



Analysis: 
https://blog.csdn.net/NoMasp/article/details/49913627

6 5 4 8 7 5 1
1
一开始没看对方的后面介绍，就自己在想这个排列的下一个排列是怎样的。

首先肯定从后面开始看，1和5调换了没有用。

7、5和1调换了也没有效果，因此而发现了8、7、5、1是递减的。

如果想要找到下一个排列，找到递增的位置是关键。

因为在这里才可以使其增长得更大。

于是找到了4，显而易见4过了是5而不是8或者7更不是1。

因此就需要找出比4大但在这些大数里面最小的值，并将其两者调换。

那么整个排列就成了：6 5 5 8 7 4 1

然而最后一步将后面的8 7 4 1做一个递增。
*/
// public class Solution {
//     public void nextPermutation(int[] nums) {
//         if(nums == null || nums.length == 0) return;
//         int i = nums.length - 2;
//         while(i >= 0 && nums[i] >= nums[i + 1]) i--;    //from right to left, find the first one violate descending
//         if(i >= 0){
//             int j = nums.length - 1;
//             while(nums[i] >= nums[j]) j--;  //from right to left, find the first num > nums[i]
//             swap(nums, i, j);
//         }
//         reverse(nums, i + 1, nums.length - 1);
//     }
    
//     private void swap(int[] nums, int i, int j){
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
    
//     private void reverse(int[] nums, int i, int j){
//         while(i < j) swap(nums, i++, j--);
//     }
// }


class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        
        // Here find the first Integer that is not increasing. It's index is "index - 1"
        int index = nums.length - 1;
        while (index > 0 && nums[index - 1] >= nums[index]) {
            index--;
        }
        
        if (index == 0) {
            // Arrays.sort(nums);
            // or we could use reverse helper function
            reverse(nums, 0, nums.length - 1);
            return;   // I forgot this line. For the special case, we will exit right now.
        }
        
        // Find a number that is larger than nums[index - 1], but is the smallest on the right of index - 1, and swap the number and index-1, and finally sort the numbers on the right of index - 1.
        int second = Integer.MAX_VALUE, secondIndex = Integer.MAX_VALUE;
        for(int i = nums.length - 1; i > index - 1; i--) {
            if (nums[i] > nums[index - 1] && nums[i] < second) {
                second = nums[i];
                secondIndex = i;
            }
        }
        
        // int temp = nums[index - 1];
        // nums[index - 1] = nums[secondIndex];
        // nums[secondIndex] = temp;
        // Using the swap helper function.
        swap(nums, index - 1, secondIndex);
        
        // Arrays.sort(nums, index, nums.length);
        // Using the reverse helper function
        reverse(nums, index, nums.length - 1);
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private void reverse(int[] nums, int i, int j) {
        while (i < j) swap(nums, i++, j--);
    }
  
  
     public void nextPermutation(int[] nums) {
        // 1.find the first increasing index from right to left
       int index1 = -1;
       for (int i = nums.length - 1; i > 0; i--) {
           if (nums[i - 1] < nums[i]) {
               index1 = i - 1;
               break;
           }
       }
       
       if (index1 == -1) {
           // all elements in nums are decreasing
           Arrays.sort(nums);
           return;
       }
       
       // 2.find the first element which is larger than index1 from right to left
       int index2 = -1;
       for (int i = nums.length - 1; i > index1; i--) {
           if (nums[i] > nums[index1]) {
               index2 = i;
               break;
           }
       }
       
       // swap index1 and index2
       int temp = nums[index1];
       nums[index1] = nums[index2];
       nums[index2] = temp;
       
       Arrays.sort(nums, index1 + 1, nums.length);
    }
}
