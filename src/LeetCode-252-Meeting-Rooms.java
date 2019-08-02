/*
LeetCode: https://leetcode.com/problems/meeting-rooms/
LintCode: Not
JiuZhang: Not
ProgramCreek: Not
http://buttercola.blogspot.com/2015/08/leetcode-meeting-rooms.html

Analysis: 

*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
//     public boolean canAttendMeetings(Interval[] intervals) {
//         if(intervals == null || intervals.length <= 1) return true;
        
//         java.util.Arrays.sort(intervals, new IntervalComparator());
//         for(int i = 1; i < intervals.length; i++){
//             Interval prev = intervals[i - 1];
//             Interval curr = intervals[i];
//             if(prev.end > curr.start) return false;
//         }
        
//         return true;
//     }
    
//     private class IntervalComparator implements Comparator<Interval>{
//         public int compare(Interval p, Interval q){
//             return p.start - q.start;
//         }
//     }
    
    
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return true;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
        int e = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (e > intervals[i][0]) return false;
            e = intervals[i][1];
        }
        
        return true;
    }
}
