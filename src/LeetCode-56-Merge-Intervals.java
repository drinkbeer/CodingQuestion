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

class Solution {
    // 1.
    /*
    https://leetcode.com/problems/merge-intervals/discuss/21223/Beat-98-Java.-Sort-start-and-end-respectively
    
    Sort the start pointers and end pointers independently.
    Scan the end pointer array. Whenever we found a end[j] < start[j + 1], means we found a new non-overlapping interval.
    */
//     public int[][] merge(int[][] intervals) {
//         List<int[]> result = new ArrayList<>();
//         if (intervals == null || intervals.length == 0) return result.toArray(new int[0][]);
        
//         int n = intervals.length;
//         int[] start = new int[n];
//         int[] end = new int[n];
        
//         for (int i = 0; i < n; i++) {
//             start[i] = intervals[i][0];
//             end[i] = intervals[i][1];
//         }
        
//         Arrays.sort(start);
//         Arrays.sort(end);
        
//         /*
//         The idea here is keep on scaning the end.
        
//         When ever we found a end[j] < start[j + 1], that means we found an non-overlapping interval, add to result.
        
//         Be careful when we reached the last element of end, we have to add the last element to result.
//         */
//         // i is the index in start array, j is the index in end array.
//         for (int i = 0, j = 0; j < n; j++) {
//             if (j == n - 1 || start[j + 1] > end[j]) {
//                 // means we found a new non-overlapping interval
//                 result.add(new int[] {start[i], end[j]});
//                 i = j + 1;  // after we add a new non-overlapping interval, we have to let the start pointer sync up with end pointer
//             }
//         }
        
//         return result.toArray(new int[result.size()][]);
//     }
    
    // 2. A similar solution using two pointers.
//     public int[][] merge(int[][] intervals) {
//         List<int[]> result = new ArrayList<>();
//         if (intervals == null || intervals.length == 0) return result.toArray(new int[0][]);
        
//         int n = intervals.length;
//         int[] start = new int[n];
//         int[] end = new int[n];
        
//         for (int i = 0; i < n; i++) {
//             start[i] = intervals[i][0];
//             end[i] = intervals[i][1];
//         }
        
//         Arrays.sort(start);
//         Arrays.sort(end);
        
//         /*
//         The idea here is keep on scaning the end.
        
//         When ever we found a end[j] < start[j + 1], that means we found an non-overlapping interval, add to result.
        
//         Be careful when we reached the last element of end, we have to add the last element to result.
//         */
//         // i is the index in start array, j is the index in end array.
//         int i = 0, j = 0;
//         while (j < n) {
//             if (j == n - 1 || start[j + 1] > end[j]) {
//                 // means we found a new non-overlapping interval
//                 result.add(new int[] {start[i], end[j]});
//                 i = j + 1;  // after we add a new non-overlapping interval, we have to let the start pointer sync up with end pointer
//             }
//             j++;
//         }
        
//         return result.toArray(new int[result.size()][]);
//     }
    
    // 3. Sorting the whole intervals array.
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null || intervals.length == 0) return result.toArray(new int[0][]);
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int n = intervals.length;
        int start = intervals[0][0];
        int end = intervals[0][1];
        
        /*
        The idea here is keep on scaning the intervals.
        
        When ever we found a end[j] < start[j + 1], that means we found an non-overlapping interval, add to result.
        
        Be careful when we reached the last element of end, we have to add the last element to result.
        */
        // i is the index in start array, j is the index in end array.
        for (int[] interval : intervals) {
            if (interval[0] > end) {
                // means [start, end] is a new non-overlapping interval
                result.add(new int[]{start, end});
                start = interval[0];
                end = interval[1];
            } else {
                // [start, end] and current interval is overlapping, we need update the end
                end = Math.max(end, interval[1]);
            }
        }
        result.add(new int[]{start, end});
        
        return result.toArray(new int[result.size()][]);
    }
    
}
