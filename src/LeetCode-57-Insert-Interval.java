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



class Solution {
    // 1.Scan the intervals, and sort twice. It's slow, TimeComplexity O(NlogN), because the sorting.
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         List<int[]> result = new ArrayList<>();
//         if (intervals == null) return result.toArray(new int[0][]);
//         // Be careful that if the intervals is empty, we just insert newInterval into it, rather than result an empty.
        
//         int start = newInterval[0];
//         int end = newInterval[1];
        
//         for (int[] interval : intervals) {
            
//             if (interval[1] < start || interval[0] > end) {
//                 // means interval and newInterval are not overlapping, just add the inverval to result
//                 result.add(new int[]{interval[0], interval[1]});
//             } else {
//                 // means interval and newInterval are overlapping, need merge the interval and newInterval
//                 start = Math.min(start, interval[0]);
//                 end = Math.max(end, interval[1]);
//             }
//         }
//         result.add(new int[]{start, end});
        
//         Collections.sort(result, (a, b) -> Integer.compare(a[0], b[0]));
        
//         return result.toArray(new int[result.size()][]);
//     }
    
    // Similar to my solution, but without sorting.
    /*
    Inspired by: https://leetcode.com/problems/insert-interval/discuss/21600/Short-java-code
    https://leetcode.com/problems/insert-interval/discuss/21602/Short-and-straight-forward-Java-solution
    
    The basic idea is to set newInterval to be null to record if the newInterval has been merged or now.
    
    It's TimeComplexity is O(N), as we don't need sort the array.
    
    
___: current interval(i); _ _ _: newInterval

1) i.end < newInterval.start，then we can safely add i to result;
	newInterval still needs to be compared with latter intervals

	|________|
			       |_ _ _ _ _|
			
2) i.start > newInterval.end，then we can safely add both to result，
	and mark newInterval as null
	
			       |________|
	|_ _ _ _ _|
			
3) There is overlap between i and newInterval. We can merge i into newInterval, 
then use the updated newInterval to compare with latter intervals.

	
	|________|
		|_ _ _ _ _|
			
		|________|
	|_ _ _ _ _|
    */
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         List<int[]> result = new ArrayList<>();
//         if (intervals == null) return result.toArray(new int[0][]);
        
//         int start = newInterval[0];
//         int end = newInterval[1];
        
//         for (int[] interval : intervals) {
//             if (newInterval == null || interval[1] < start) {
//                 // means we already merged newInterval or we have not reached the correct place for newInterval, so just add the interval
//                 result.add(new int[]{interval[0], interval[1]});
//             } else if (interval[0] > end) {
//                 // interval[0] > end, which means interval has proceed the newInterval, we can add the [start, end] and the interval to result
//                 result.add(new int[]{start, end});
//                 result.add(new int[]{interval[0], interval[1]});
//                 newInterval = null;
//             } else {
//                 // means interval and [start, end] is overlapping, update the new start and end
//                 start = Math.min(start, interval[0]);
//                 end = Math.max(end, interval[1]);
//             }
//         }
        
//         if (newInterval != null) {
//             result.add(new int[]{start, end});
//         }
        
//         // Collections.sort(result, (a, b) -> Integer.compare(a[0], b[0]));
        
//         return result.toArray(new int[result.size()][]);
//     }
    
    // Similar to the above one.
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         List<int[]> result = new ArrayList<>();
//         if (intervals == null) return result.toArray(new int[0][]);
        
//         int start = newInterval[0];
//         int end = newInterval[1];
        
//         for (int[] interval : intervals) {
//             if (interval[1] < start) {
//                 // means we have not reached the correct place for newInterval, so just add the interval
//                 result.add(new int[]{interval[0], interval[1]});
//             } else if (interval[0] > end) {
//                 // interval[0] > end, which means interval has proceed the newInterval, we can add the [start, end] and the interval to result
//                 result.add(new int[]{start, end});
//                 start = interval[0];
//                 end = interval[1];
//             } else {
//                 // means interval and [start, end] is overlapping, update the new start and end
//                 start = Math.min(start, interval[0]);
//                 end = Math.max(end, interval[1]);
//             }
//         }
        
//         if (newInterval != null) {
//             result.add(new int[]{start, end});
//         }
        
//         // Collections.sort(result, (a, b) -> Integer.compare(a[0], b[0]));
        
//         return result.toArray(new int[result.size()][]);
//     }
    
    // 2. Split the intervals to start array and end array, and scan the end
    /*
    The idea here is:
    
    Split the intervals to start array and end array, and scan the end array.
    Whenever we find a start[j + 1] > end[j], means we find a new non-overlapping interval, add it to result.
    */
//     public int[][] insert(int[][] intervals, int[] newInterval) {
//         List<int[]> result = new ArrayList<>();
//         if (intervals == null) return result.toArray(new int[0][]);
        
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
//         int n = intervals.length;
//         int[] start = new int[n + 1];
//         int[] end = new int[n + 1];
        
//         for (int i = 0; i < n; i++) {
//             start[i] = intervals[i][0];
//             end[i] = intervals[i][1];
//         }
//         start[n] = newInterval[0];
//         end[n] = newInterval[1];
        
//         Arrays.sort(start);
//         Arrays.sort(end);
//         n = n + 1; // update n with the new length
        
//         // Then just do a merge intervals
        
//         // First approach to do merge intervals.
//         // for (int i = 0, j = 0; j < n; j++) {
//         //     if (j == n - 1 || start[j + 1] > end[j]) {
//         //         // means we found a new non-overlapping interval, add it to result
//         //         result.add(new int[] {start[i], end[j]});
//         //         i = j + 1;
//         //     }
//         // }
        
//         // Second approach to do merge intervals.
//         int i = 0, j = 0; // i and j are the index in the start and end
//         while (j < n) {
//             if (j == n - 1 || start[j + 1] > end[j]) {
//                 // means we found a new non-overlapping interval, add it to result
//                 result.add(new int[] {start[i], end [j]});
//                 i = j + 1;
//             }
//             j++;
//         }
        
//         return result.toArray(new int[result.size()][]);
//     }
    
    // 3.Do it with Binary Search.
    /*
    https://leetcode.com/problems/insert-interval/discuss/21659/My-Binary-Search-Approach-Implementation-2ms
    https://leetcode.com/problems/insert-interval/discuss/21698/Java-2ms-O(log-n)O(1)-binary-search-solution-beats-97.7-with-clear-explaination
    Analysis:
    
    [[1,3],[6,9]]
    [2,5]
    
    The BS result:
    Lift: 0  Right: 0
    
    */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        if (intervals == null) return result.toArray(new int[0][]);
        if (intervals.length == 0) {
            result.add(newInterval);
            return result.toArray(new int[1][]);
        }
        
        int left = searchStartPos(intervals, newInterval[0]);
        int right = searchEndPos(intervals, newInterval[1]);
        System.out.println("Left: " + left + "  Right: " + right);
        
        /*
        Process the search result:
        
        [[1,5]]
        [2,3]
        Left: 0  Right: 0
        Result:[[1,5]], should do merge
        
        [[1,5]]
        [0,3]
        Left: -1  Right: 0
        Result: [[0,5]], merge, and don't add anything
        
        [[4,5]]
        [2,3]
        Left: -1  Right: 0
        Result: [[2,3],[4,5]], don't merge, just directly add to the beginning
        
        [[1,5]]
        [6,8]
        Left: 0  Right: -1
        Result: [[1,5],[6,8]], add to right
        
        [[1,2],[3,5],[6,7],[8,10],[12,16]]
        [4,8]
        [[1,2],[3,10],[12,16]]
        Result: [[1,2],[3,10],[12,16]], merge and add
       
       My code is wrong in this case.
        [[1,3],[6,9]]
        [2,5]
        Left: 0  Right: 1
        [[1,5],[6,9]]
        
        Then we should insert newInterval to zero index
        */
        // add to the beginning, then continue adding everything left in the intervals by setting left and right to be 0
        if (left == -1 && right == -1) {
            // result.add(newInterval);
            left = 0;
            if (intervals[left][0] <= newInterval[1]) {
                // merge left with newInterval
                newInterval = new int[]{Math.min(newInterval[0], intervals[left][0]), Math.max(newInterval[1], intervals[left][1])};
                // don't reset right, let it be -1, so we will skip adding any thing.
            } else {
                right = -1; // after merged newInterval, we need start from 0 to add intervals
            }
        } else if (left == -1) {
            if (intervals[right][0] <= newInterval[1]) {
                // merge left with newInterval
                newInterval = new int[]{Math.min(newInterval[0], intervals[right][0]), Math.max(newInterval[1], intervals[right][1])};
                // don't reset right, let it be -1, so we will skip adding any thing.
            } else {
                right = left; // after merged newInterval, we need start from 0 to add intervals
            }
        } else if (right == -1) {
            if (intervals[left][1] >= newInterval[0]) {
                // merge left with newInterval
                newInterval = new int[]{Math.min(newInterval[0], intervals[left][0]), Math.max(newInterval[1], intervals[left][1])};
                // don't reset right, let it be -1, so we will skip adding any thing.
                // left = -1; // // after merged newInterval, we need start from 0 to add intervals in the left side
                // left++;
            } 
            else {
                left++; // after merged newInterval, we need start from 0 to add intervals
                right = left;
            }
        } else {
            if (intervals[right][1] >= newInterval[0]) {
                // merge newInterval with the intervals between left and right.
                newInterval = new int[]{Math.min(newInterval[0], intervals[left][0]), Math.max(newInterval[1], intervals[right][1])};
            } else {
                // no need merge, but need find the correct position to insert (insert before the left, or after the right)
                if (intervals[right][1] < newInterval[0]) {
                    // insert to the right of right.
                    left = left + 1;
                } 
                
                // if (intervals[right][0])
            }
        }
        
        // if (left == -1 && right == -1) {
        //     left = 0;
        //     right = 0;
        // }
        // if (left == -1) {
        //     left = right;
        // }
        // if (right == -1) {
        //     right = left;
        // }
        // start = Math.min(start, intervals[left][0]);
        // end = Math.max(end, intervals[left][1]);
        // start = Math.min(start, intervals[right][0]);
        // end = Math.max(end, intervals[right][1]);
//         if (right != -1) {
            
//         }
        
        int i = 0;
        while (i < left) {
            result.add(intervals[i]);
            i++;
        }
        
        result.add(newInterval);
        
        i = right + 1;
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
    
    // find the right most interval whose start is smaller than val
    private int searchStartPos(int[][] intervals, int val) {
        int lo = 0, hi = intervals.length - 1;
        
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (intervals[mid][0] == val) return mid;
            else if (intervals[mid][0] > val) hi = mid - 1;
            else lo = mid + 1;
        }
        
        if (intervals[hi][0] < val) return hi;
        if (intervals[lo][0] < val) return lo;
        return -1;
    }
    
    // find the left most interval whose end is larger or equal to val
    /*
    If we cannot find the left most interval whose end is smaller than val, e.g.
    
    [[1,5]]
    [2,3]
    
    we just return -1.
    
    If we cannot find a right boundary, then just use the 
    */
    private int searchEndPos(int[][] intervals, int val) {
        int lo = 0, hi = intervals.length - 1;
        
        while(lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            
            if (intervals[mid][1] == val) return mid;
            else if (intervals[mid][1] > val) hi = mid - 1;
            else lo = mid + 1;
        }
        
        if (intervals[lo][1] > val) return lo;
        if (intervals[hi][1] > val) return hi;
        
        return -1;
    }
}
