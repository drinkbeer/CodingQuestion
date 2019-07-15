class Solution {
    /*
    https://leetcode.com/problems/single-element-in-a-sorted-array/discuss/100754/Java-Binary-Search-short-(7l)-O(log(n))-w-explanations
    */
    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid % 2 == 0) {
                // mid is even
                if (nums[mid] == nums[mid + 1]) {
                    lo = mid + 2;
                } else {
                    hi = mid;
                }
            } else {
                // mid is odd
                if (nums[mid] == nums[mid - 1]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
        }
        
        return nums[lo];
    }
}
