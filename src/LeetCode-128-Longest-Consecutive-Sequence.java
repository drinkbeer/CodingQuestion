class Solution {
    /*
    https://www.programcreek.com/2013/01/leetcode-longest-consecutive-sequence-java/
    
    Using a HashSet to store nums, and remove based on range (range means remove from one number to down side, and remove from one number to up side).
    
     Time complexity looks more than O(n). If we take a closer look, we can notice that it is O(n) under the assumption that hash insert and search take O(1) time. The function S.find() inside the while loop is called at most twice for every element.
    
    */
    // 1. Using HashSet
//     public int longestConsecutive(int[] nums) {
//         int result = 0;
//         Set<Integer> set = new HashSet<>();
//         for (int i = 0; i < nums.length; i++) set.add(nums[i]);
        
//         for (int num : nums) {
//             int count = 1;
            
//             int down = num - 1;
//             while(set.contains(down)) {
//                 set.remove(down);
//                 down--;
//                 count++;
//             }
            
//             int up = num + 1;
//             while(set.contains(up)) {
//                 set.remove(up);
//                 up++;
//                 count++;
//             }
            
//             result = Math.max(result, count);
//         }
        
//         return result;
//     }
    
    // 2. Using HashTable
    /*
    
    https://leetcode.com/problems/longest-consecutive-sequence/discuss/41055/My-really-simple-Java-O(n)-solution-Accepted
    
    
    */ 
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length 
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }
    
    /*
    Wrong Answer
    
    
    Input
    [1,2,0,1]
    Output
    2
    Expected
    3
    
    
    */
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] + 1 == nums[i]) {
                // find one consecutive number
                count++;
                result = Math.max(result, count);
                continue;
            }
            count = 0;
        }
        
        return result;
    }
    
}
