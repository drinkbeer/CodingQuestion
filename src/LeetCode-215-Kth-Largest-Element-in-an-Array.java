/*
1.Sort
Time: O(NlogN) (quick sort)

2.Max Heap
Time: 
    build heap O(N)
    delete Max one O(KlogN)
    Total: O(N + KlogN)

3.Quick Select
http://massivealgorithms.blogspot.com/2015/05/leetcode-215-kth-largest-element-in.html
Time Complext of Quick Select: average O(N)
                                worst O(N^2)

*/
public class Solution {
    // 1.Sort first, and get Kth largest num
    // public int findKthLargest(int[] nums, int k) {
    //     if(nums == null || nums.length == 0) return 0;
        
    //     java.util.Arrays.sort(nums);
    //     return nums[nums.length - k];
    // }
    
    // 2.put into max heap
    // public int findKthLargest(int[] nums, int k) {
    //     if(nums == null || nums.length == 0) return 0;
        
    //     IntegerComparator comparator = new IntegerComparator();
    //     Queue<Integer> queue = new PriorityQueue<Integer>(nums.length, comparator);
    //     for(int i = 0; i < nums.length; i++){
    //         queue.offer(nums[i]);
    //     }
        
    //     int i = 1;
    //     while(i < k){
    //         queue.poll();
    //         i++;
    //     }
        
    //     return queue.poll();
    // }
    
    // private class IntegerComparator implements Comparator<Integer>{
    //     public int compare(Integer i1, Integer i2){
    //         return i2 - i1;
    //     }
    // }
    
    // 3.Quick Select
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 1 || k > nums.length) return 0;
        
        return findKthLargest(nums, k - 1, 0, nums.length - 1);
    }
    
    private int findKthLargest(int[] nums, int k, int lo, int hi){
        int pos = partition(nums, lo, hi);
        
        if(k == pos) return nums[pos];
        else if(pos > k) return findKthLargest(nums, k, lo, pos - 1);
        return findKthLargest(nums, k, pos + 1, hi);
    }
    
    private int partition(int[] nums, int lo, int hi){
        int pivot = nums[hi];
        int p = lo;
        
        for(int i = lo; i < hi; i++){
            if(nums[i] > pivot){
                // swap i and p, and then p++
                swap(nums, i, p++);
            }
        }
        swap(nums, p, hi);
        return p;
    }
    
    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
