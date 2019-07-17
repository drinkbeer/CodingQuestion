class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    private void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int val = partition(nums, lo, hi);
        quickSort(nums, lo, val - 1);
        quickSort(nums, val + 1, hi);
    }
    
    private int partition(int[] nums, int lo, int hi) {
        int pivot = nums[hi];
        
        for (int i = lo; i < hi; i++) {
            if (nums[i] < pivot) {
                int temp = nums[lo];
                nums[lo] = nums[i];
                nums[i] = temp;
                
                lo++;
            }
        }
        
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
        
        return lo;
    }
    
    
}
