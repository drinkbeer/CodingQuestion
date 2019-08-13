class Solution {
    // 1. Binary Search (find the first letter > target)
    public char nextGreatestLetter(char[] letters, char target) {
        
        int lo = 0, hi = letters.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (letters[mid] <= target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (letters[lo] > target) return letters[lo];
        return letters[hi] > target ? letters[hi] : letters[0];
    }
    
}
