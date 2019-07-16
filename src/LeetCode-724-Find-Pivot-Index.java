class Solution {
    // Wrong Answer, as nums could be negative
//     public int pivotIndex(int[] nums) {
//         int lo = 1, hi = nums.length - 2;
//         int sL = nums[0], sR = nums[nums.length - 1];
//         while (lo < hi) {
//             if (sL < sR) {
//                 sL += nums[lo];
//                 lo++;
//             } else {
//                 sR += nums[hi];
//                 hi--;
//             }
//         }
        
//         return sL == sR ? lo : -1;
//     }
    
    // Using two extra array to hold the sum except itself: Time O(N), Space O(N)
//     public int pivotIndex(int[] nums) {
        
//         int[] left = new int[nums.length];      // the culmulative sum not include itself
//         for (int i = 1; i < nums.length; i++) {
//             left[i] += left[i - 1] + nums[i - 1];
//         }
        
//         int[] right = new int[nums.length];
//         for (int i = nums.length - 2; i >= 0; i--) {
//             right[i] = right[i + 1] + nums[i + 1];
//         }
        
//         System.out.println(Arrays.toString(left) + "  " + Arrays.toString(right));
        
//         for (int i = 0; i < nums.length; i++) {
//             if (left[i] == right[i]) return i;
//         }
        
//         return -1;
//     }
    
    // Time O(N), Space O(1)
    public int pivotIndex(int[] nums) {
        
        int r = 0;
        for (int n : nums) r += n;
        
        int l = 0;
        for (int i = 0; i < nums.length; i++) {
            r -= nums[i];
            
            if (l == r) return i;
            
            l += nums[i];
        }
        
        return -1;
    }
}
