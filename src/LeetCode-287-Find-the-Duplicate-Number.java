/*
http://www.cnblogs.com/grandyang/p/4843654.html
*/

class Solution {
    // Wrong Answer
    /*
    [7,9,7,4,2,8,7,7,1,5]
    
    sorted one: [1,2,4,5,7,7,7,7,8,9]
    
    */
    // public int findDuplicate(int[] nums) {
    //     Arrays.sort(nums);
    //     for (int i = 0; i < nums.length; i++) {
    //         if (nums[i] != i + 1) return nums[i];
    //     }
    //     return -1;
    // }
    
    // 1. Using Binary Search (always searching the "denser" half part)
    /*
    https://leetcode.com/problems/find-the-duplicate-number/discuss/72841/Java-O(1)space-using-Binary-Search
    
    Time O(NlogN)
    
    A quick explanation for these don't understand the idea behind the scenes. The binary search is utilizing the fact that the duplicate number could only occur in the "denser" half of the array (This is only true, we have no missing numbers from 1 to n). So we should set low or high to move towards the denser half. Eventually when low exceeds high we will get the duplicated number.
    */
//     public int findDuplicate(int[] nums) {
//         int n = nums.length;
//         int lo = 0, hi = n - 1;
//         while (lo <= hi) {
//             int mid = lo + (hi - lo) / 2;
            
//             int cnt = 0;
//             for (int i = 0; i < n; i++) {
//                 if (nums[i] <= mid) cnt++;
//             }
            
//             if (cnt <= mid) lo = mid + 1;
//             else hi = mid - 1;
//         }
//         return lo;
        
//     }
    
    // 2. Cycle detection solution
    /*
    https://leetcode.com/problems/find-the-duplicate-number/discuss/72846/My-easy-understood-solution-with-O(n)-time-and-O(1)-space-without-modifying-the-array.-With-clear-explanation.
    https://leetcode.com/problems/find-the-duplicate-number/discuss/72845/Java-O(n)-time-and-O(1)-space-solution.-Similar-to-find-loop-in-linkedlist.
    
    Similar to : https://leetcode.com/problems/linked-list-cycle-ii/
    
    Use two pointers the fast and the slow. The fast one goes forward two steps each time, while the slow one goes only step each time. They must meet the same item when slow==fast. In fact, they meet in a circle, the duplicate number must be the entry point of the circle when visiting the array from nums[0]. 
    
    Next we just need to find the entry point. We use a point(we can use the fast one before) to visit form begining with one step each time, do the same job to slow. When fast==slow, they meet at the entry point of the circle. The easy understood code is as follows.
    
    
    Mathetical Prove of the solution:
    
    To understand this solution, you just need to ask yourself these question.
Assume the distance from head to the start of the loop is x1
the distance from the start of the loop to the point fast and slow meet is x2
the distance from the point fast and slow meet to the start of the loop is x3

What is the distance fast moved? 2. What is the distance slow moved? 3. And their relationship?
x1 + x2 + x3 + x2
x1 + x2
x1 + x2 + x3 + x2 = 2 (x1 + x2)
Thus x1 = x3, that's the reason we reset fast to be 0.

Finally got the idea.
    */
//     public int findDuplicate(int[] nums) {
//         int n = nums.length;
        
//         int slow = nums[0];
//         int fast = nums[nums[0]];
//         while (slow != fast) {
//             slow = nums[slow];
//             fast = nums[nums[fast]];
//         }
        
//         slow = 0;
//         while (slow != fast) {
//             slow = nums[slow];
//             fast = nums[fast];
//         }
//         return slow;
//     }
    
    // 3. Bit Manipulation
    /*
    这道题还有一种位操作 Bit Manipulation 的解法，也十分的巧妙。思路是遍历每一位，然后对于 32 位中的每一个位 bit，我们都遍历一遍从0到 n-1，我们将0到 n-1 中的每一个数都跟 bit 相 ‘与’，若大于0，则计数器 cnt1 自增1。同时0到 n-1 也可以当作 nums 数组的下标，从而让 nums 数组中的每个数字也跟 bit 相 ‘与’，若大于0，则计数器 cnt2 自增1。最后比较若 cnt2 大于 cnt1，则将 bit 加入结果 res 中。这是为啥呢，因为对于每一位，0到 n-1 中所有数字中该位上的1的个数应该是固定的，如果 nums 数组中所有数字中该位上1的个数多了，说明重复数字在该位上一定是1，这样我们把重复数字的所有为1的位都累加起来，就可以还原出了这个重复数字，参见代码如下：
    
    */
    public int findDuplicate(int[] nums) {
        int n = nums.length, res = 0;
        
        for (int k = 0; k < 32; k++) {
            int bit = 1 << k, cnt1 = 0, cnt2= 0;
            
            for (int i = 0; i < n; i++) {
                if ((i & bit) > 0) cnt1++;
                if ((nums[i] & bit) > 0) cnt2++;
            }
            
            if (cnt2 > cnt1) res += bit;
        }
        return res;
    }
}
