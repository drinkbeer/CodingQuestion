class Solution {
    /*
    Sorting: O(NlogN)
    Scan: O(N)
    */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int s = intervals[0][0], e = intervals[0][1];
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (e <= intervals[i][0]) {
                // means there is no overlapping
                s = intervals[i][0];
                e = intervals[i][1];
            } else {
                // there is overlapping
                if (e > intervals[i][1]) {
                    // erase the original interval
                    s = intervals[i][0];
                    e = intervals[i][1];
                } else {
                    // remove current interval
                    // do nothing.
                }
                res++;
            }
        }
        
        return res;
    }
}
