class Solution {
    // Quick Sort
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

    // Merge Sort
    public int[] sortArray(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, temp, 0, nums.length - 1);
        
        return nums;
    }
    
    private void mergeSort(int[] nums, int[] temp, int lo, int hi) {
        if (lo >= hi) return;
        
        int mid = lo + (hi - lo) / 2;
        mergeSort(nums, temp, lo, mid);
        mergeSort(nums, temp, mid + 1, hi);
        merge(nums, temp, lo, mid, hi);
    }
    
    private void merge(int[] nums, int[] temp, int lo, int mid, int hi) {
        for (int k = lo; k <= hi; k++) {
            temp[k] = nums[k];
        }
        
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (j > hi || (i <= mid && temp[i] <= temp[j])) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
            }
        }
    }
    
    
}
