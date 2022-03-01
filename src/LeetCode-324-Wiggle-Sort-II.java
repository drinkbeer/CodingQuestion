class Solution {
    // My Solution. Wrong Answer
//     public void wiggleSort(int[] nums) {
        
        
//         // PriorityQueue<Integer> pq = new PriorityQueue<>();
//         // for (int num : nums) {
//         //     pq.add(num);
//         // }
        
//         int[] temp = new int[nums.length];
//         for (int i = 0; i < nums.length; i++) {
//             temp[i] = nums[i];
//         }
//         Arrays.sort(temp);
        
        
//         int i = 0, j = nums.length / 2, k = 0;;
//         while (i < nums.length / 2 && j < nums.length) {
//             nums[k++] = temp[i++];
//             nums[k++] = temp[j++];
//         }
        
//         while (i < nums.length / 2) {
//             nums[k++] = temp[i++];
//         }
        
//         while (j < nums.length) {
//             nums[k++] = temp[j++];
//         }
        
        
//     }
    
    
    /*
    Split into half, and assign the value.
    
    Even count of array:
    [0, 1, 2, 3, 4]
           i     j
    
    [0, 1, 2, 3, 4, 5]
           i        j
    
    https://leetcode.jp/leetcode-324-wiggle-sort-ii-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
    */
    public void wiggleSort(int[] nums) {
        
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i] = nums[i];
        }
        Arrays.sort(temp);
        
        int mid = nums.length / 2;
        if (nums.length % 2 == 0) mid--;
        int i = mid, j = nums.length - 1, k = 0;
        
        
        while (i >= 0 && j > mid) {
            nums[k++] = temp[i--];
            nums[k++] = temp[j--];
        }
        
        while (i >= 0) {
            nums[k++] = temp[i--];
        }
        
        while (j > mid) {
            nums[k++] = temp[j--];
        }
    }
    
    /*
    https://leetcode.com/problems/wiggle-sort-ii/discuss/77677/O(n)%2BO(1)-after-median-Virtual-Indexing
    Find the kth element
    */
}
