class Solution {
    // public int findLengthOfLCIS(int[] nums) {
    //     if (nums == null || nums.length == 0) return 0;
    //     int max = 1;
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         int j = i;
    //         while (j < nums.length - 1 && nums[j] < nums[j + 1]) j++;
    //         max = Math.max(max, j - i + 1);
    //     }
    //     return max;
    // }
    
    
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0) return 0;
        int max = 1, count = 1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i+1]) {
                count++;
                max = Math.max(max, count);
            }
            else count=1; 
        }
        return max;
    }
}
