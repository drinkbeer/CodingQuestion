class Solution {
    // 1. Brute Force Two Pointers
    /*
    Runtime: 2 ms, faster than 97.17% of Java online submissions for Sum of Square Numbers.
    Memory Usage: 33 MB, less than 7.14% of Java online submissions for Sum of Square Numbers.
    */
    public boolean judgeSquareSum(int c) {
        int lo = 0, hi = (int)Math.sqrt(c);
        while (lo <= hi) {
            double sum = lo * lo + hi * hi;
            if (sum == c) return true;
            else if (sum > c) {
                hi--;
            } else {
                lo++;
            }
        }
        
        return false;
    }
    
    // doesn't work for the case: "2, true"
//     public boolean judgeSquareSum(int c) {
//         HashSet<Double> set = new HashSet<>();
//         for (int i = 0; i <= Math.sqrt(c); i++) {
//             double val = i * i;
//             if (set.contains(c - val)) {
//                 return true;
//             } else {
//                 set.add(val);
//             }
//         }
        
//         return false;
//     }
    
    // 2. Using a HashSet
    /*
    https://leetcode.com/problems/sum-of-square-numbers/discuss/104932/HashSet-Java-quick-solution-one-for-loop
    */
//     public boolean judgeSquareSum(int c) {
//         HashSet<Integer> set = new HashSet<Integer>();
        
//         for (int i = 0; i <= Math.sqrt(c); i++) {
//             set.add(i * i);
//             if (set.contains(c - i * i)) {
//                 return true;
//             }
//         }
//         return false;
//     }
}
