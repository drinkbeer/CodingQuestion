class Solution {
    // 1. Greedy
    /*
    https://leetcode.com/problems/can-place-flowers/discuss/103898/Java-Greedy-solution-O(flowerbed)-beats-100
    */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length && count < n; i++) {
            if (flowerbed[i] == 1) continue;
            
            int prev = i == 0 ? 0 : flowerbed[i - 1];
            int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            
            if (prev == 0 && next == 0) {
                flowerbed[i] = 1;
                count++;
                i++;    // Optimization: skip the next one if we plant at ith.
            }
        }
        return count == n;
    }
}
