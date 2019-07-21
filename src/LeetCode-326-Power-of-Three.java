class Solution {
    // 1. Using While Loop
    // public boolean isPowerOfThree(int n) {
    //     if (n < 3 && n != 1) return false;
    //     if (n == 1) return true;
    //     while (n > 1) {
    //         if (n % 3 != 0) return false;
    //         n /= 3;
    //     }
    //     return true;
    // }
    
    // 2. Prepare possible Power of Three set ahead
    /*
    https://leetcode.com/problems/power-of-three/discuss/77876/**-A-summary-of-all-solutions-(new-method-included-at-15%3A30pm-Jan-8th)
    */
    public boolean isPowerOfThree(int n) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969, 14348907, 43046721, 129140163, 387420489, 1162261467));
        return set.contains(n);
    }
}
