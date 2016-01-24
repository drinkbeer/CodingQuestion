/*
LeetCode:  https://leetcode.com/problems/insert-interval/
LintCode:  http://www.lintcode.com/problem/insert-interval/
JiuZhang:  http://www.jiuzhang.com/solutions/insert-interval/
ProgramCreek:  http://www.programcreek.com/2012/12/leetcode-insert-interval/

Analysis:  
1.Sort at first, then merge
Just like Merge Intervals

2.Do not sort.
If the original List has overlapping? Perhaps.
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
    // 1.Sort at first, then merge
    // public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    //     if(intervals == null) return intervals;
        
    //     List<Interval> result = new ArrayList<Interval>();
    //     intervals.add(newInterval);
    //     java.util.Collections.sort(intervals, new IntervalComparator());
        
    //     Interval prev = intervals.get(0);
    //     for(int i = 1; i < intervals.size(); i++){
    //         Interval curr = intervals.get(i);
    //         if(prev.end >= curr.start){
    //             //means prev and curr has overlapping
    //             //prev [0, 2], curr [1, 3]
    //             //prev [0, 5], curr [1, 3]
    //             prev.end = Math.max(prev.end, curr.end);
    //         }else{
    //             result.add(prev);
    //             prev = curr;
    //         }
    //     }
    //     result.add(prev);
    //     return result;
    // }
    
    // private class IntervalComparator implements Comparator<Interval>{
    //     public int compare(Interval p, Interval q){
    //         return p.start - q.start;
    //     }
    // }
    
    // 2.No need sort
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null) return intervals;
        
        List<Interval> result = new ArrayList<Interval>();
        for(Interval curr : intervals){
            if(curr.end < newInterval.start){
                //means no overlap
                result.add(curr);
            }else if(curr.start > newInterval.end){
                result.add(newInterval);    //curr is behind newInterval in result
                newInterval = curr;
            }else{
                //means exists overlap
                newInterval = new Interval(Math.min(newInterval.start, curr.start), Math.max(newInterval.end, curr.end));
            }
        }
        result.add(newInterval);
        return result;
    }
    
}