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