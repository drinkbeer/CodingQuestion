/*
LeetCode:  https://leetcode.com/problems/merge-intervals/
LintCode:  http://www.lintcode.com/problem/merge-intervals/
JiuZhang:  http://www.jiuzhang.com/solutions/merge-intervals/
ProgramCreek:  http://www.programcreek.com/2012/12/leetcode-merge-intervals/

Analysis:  
If intervals are sorted by start? No, you need to write a comparator to sort by yourself.

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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0) return intervals;
        List<Interval> result = new ArrayList<Interval>();
        
        java.util.Collections.sort(intervals, new IntervalComparator());
        Interval prev = intervals.get(0);
        for(int i = 1; i < intervals.size(); i++){
            Interval curr = intervals.get(i);
            // if(curr.start <= prev.end){
            //     //merge
            //     // Be careful: [[1,4],[2,3]]    ->  [[1,4]] not [[1,3]]
            //     Interval merge = new Interval(prev.start, Math.max(prev.end, curr.end));
            //     prev = merge;
            // }else{
            //     //no need merge
            //     result.add(prev);
            //     prev = curr;
            // }
            
            if(curr.start <= prev.end){
                //modify prev's end
                prev.end = Math.max(prev.end, curr.end);
            }else{
                //merge
                result.add(prev);
                prev = curr;
            }
        }
        result.add(prev);
        
        return result;
    }
    
    private class IntervalComparator implements Comparator<Interval>{
        public int compare(Interval p, Interval q){
            return p.start - q.start;
        }
    }
}

// https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparing((int[] arr) -> arr[0]));
        
        int start = intervals[0][0], end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (end >= interval[0]) {
                // means the [start, end] and interval is overlapped, we could merge them
                end = Math.max(end, interval[1]);
            } else {
                // means the [start, end] and interval is not overlapping, we could add the result to 
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            }
        }
        
        result.add(new int[]{start, end});
        
        // Convert List<int[]> result to int[][]
        int[][] r = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            r[i] = result.get(i);
        }
        
        return r;
    }
}
