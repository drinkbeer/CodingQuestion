class Solution {
    public boolean isPerfectSquare(int num) {
        int lo = 1, hi = num;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (mid < num / mid) lo = mid + 1;
            else if (mid > num / mid) hi = mid - 1;
            else return num % mid == 0;
        }
        
        return false;
    }
    
    public boolean isPerfectSquare(int num) {
        if (num == 1 || num == 2 || num == 4) return true;
        if (num == 3) return false;
        int lo = 1, hi = num / 2;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (mid < num / mid) lo = mid + 1;
            else if (mid > num / mid) hi = mid - 1;
            else return num % mid == 0;
        }
        
        return false;
    }
    
}
