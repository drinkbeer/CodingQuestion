// 1. Using Fisher-Yates Shuffle Algorithm
/*
https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
*/
class Solution {
    
    private static final java.util.Random rand = new java.util.Random();
    int[] nums;
    
    public Solution(int[] nums) {
        this.nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        // int[] copy = Arrays.copyOf(nums, nums.length);
        int[] copy = nums.clone();
        for (int i = copy.length - 1; i > 0; i--) {
            int r = rand.nextInt(i + 1);    // get one random number in range [0, i]
            swap(copy, r, i);
        }
        return copy;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
