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
    /*
    Time: O(NlogN)
    Space: O(N)
    */
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

    // Min Priority Queue. Better than above one.
    /*
    Time: O(NLogK)
    Space: O(K)
    
    PQ time complexity:
    * enqueue and dequeue methods (offer, poll, remove, add): O(logN), because need to rebuild the pq
    * retrieval methods (peek, element, size): O(1), because only need to touch the head
    
    Build Min Heap of length K, average height is logK. The build heap operations perform N time, so time complexity is O(NlogK).
    */
    // public int findKthLargest(int[] nums, int k) {
    //     if (nums == null || nums.length < k) return -1;
        
    //     PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        
    //     for (int num : nums) {
    //         pq.offer(num);
    //         if (pq.size() > k) pq.poll();
    //     }
        
    //     return pq.peek();
    // }
    
    // 3.Quick Select (Best Solution)
    /*
    Time: O(logN)
    Time complexity : O(N) in the average case, O(N^2) in the worst case.
    Space complexity : O(1).

    Hence the array is now split into two parts. If that would be a quicksort algorithm, one would proceed recursively to use quicksort for the both parts that would result in O(NlogN) time complexity. Here there is no need to deal with both parts since now one knows in which part to search for N - kth smallest element, and that reduces average time complexity to O(N).
    */
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
