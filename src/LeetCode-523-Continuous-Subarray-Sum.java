class Solution {
    // Prefix Sum
    /*
        [23,2,4,6,7]
        [23, 25, 29, 35, 42]
        
        23 % 6 = 5
        
        29 % 6 = 5
    */
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;
            
            if (sum == 0 && i > 0) {
                return true;
            }
            
            if (map.containsKey(sum) && i - map.get(sum) > 1) {
                return true;
            }
            
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return false;
    }
}
