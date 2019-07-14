class Solution {
    // 1. HashMap （Not O(1) Sppace, so it is not allowed here)
    /*
    Runtime: 10 ms, faster than 22.30% of Java online submissions for Majority Element II.
    Memory Usage: 39.8 MB, less than 97.25% of Java online submissions for Majority Element II.
    */
//     public List<Integer> majorityElement(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         List<Integer> res = new ArrayList<>();
        
//         int len = nums.length;
//         for (int n : nums) {
//             map.put(n, map.getOrDefault(n, 0) + 1);
//         }
        
//         for (int n : map.keySet()) {
//             if (map.get(n) > len / 3) {
//                 res.add(n);
//             }
//         }
        
//         return res;
//     }
    
    // 2. Moore Voting Algorithm
    /*
    https://www.cnblogs.com/grandyang/p/4606822.html
    https://leetcode.com/problems/majority-element-ii/discuss/63520/Boyer-Moore-Majority-Vote-algorithm-and-my-elaboration
    */
    public List<Integer> majorityElement(int[] nums) {
        int a = 0, b = 0, cnt1 = 0, cnt2 = 0, n = nums.length;
        
        // Step 1. Voting
        for (int num : nums) {
            if (a == num) {
                cnt1++;
            } else if (b == num) {
                cnt2++;
            } else if (cnt1 == 0) {
                cnt1++;
                a = num;
            } else if (cnt2 == 0) {
                cnt2++;
                b = num;
            } else {
                cnt1--;
                cnt2--;
            }
        }
        
        // Step 2. Validation
        cnt1 = 0;
        cnt2 = 0;
        for (int num : nums) {
            if (num == a) cnt1++;
            else if (num == b) cnt2++;
        }
        
        List<Integer> res = new ArrayList<>();
        if (cnt1 > n / 3) res.add(a);
        if (cnt2 > n / 3) res.add(b);
        
        return res;
    }
}
