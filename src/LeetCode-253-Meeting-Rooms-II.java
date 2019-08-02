/*
LeetCode: https://leetcode.com/problems/meeting-rooms-ii/
LintCode: not
JiuZhang: not
ProgramCreek: not
http://buttercola.blogspot.com/2015/08/leetcode-meeting-rooms-ii.html
https://leetcode.com/discuss/74177/elegant-9-line-java-using-heap-%26-6-ms-greedy-java-92-03%25

Analysis: 
1.Use two arrays, one is start time, another is end time. Sort starts and ends. Compare start and end.
https://leetcode.com/discuss/65801/java-nlog-n-easy-solution-without-heap

https://leetcode.com/discuss/71846/super-easy-java-solution-beats-98-8%25
Explanation: https://leetcode.com/discuss/82292/explanation-super-easy-java-solution-beats-from-%40pinkfloyda
Given [[0, 30],[5, 10],[15, 20]],
return 2.
         0  5       15
start    |  |       |
end             |       |       |
                10      20      30
Initial i points to 0's pos in start array, j points to 10's pos in end array.
start<end, curr # of room++, means we need one more room
start>end, curr # of room--, means one meeting is end, we can get an empty room
during the scanning process from left to right, we use a max to check each curr # of rooms, find max # of rooms

2.Use MinHeap as curr needed rooms
https://leetcode.com/discuss/50911/ac-java-solution-using-min-heap

3.TreeMap
https://leetcode.com/discuss/68125/super-easy-java-solution-using-treemap

Facebook: Maximum number of overlapping intervals
http://buttercola.blogspot.com/2014/11/facebook-maximum-number-of-overlapping.html

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
    // 1.Greedy
    // public int minMeetingRooms(Interval[] intervals) {
    //     if(intervals == null || intervals.length == 0) return 0;
        
    //     int[] starts = new int[intervals.length];
    //     int[] ends = new int[intervals.length];
        
    //     for(int i = 0; i < intervals.length; i++){
    //         starts[i] = intervals[i].start;
    //         ends[i] = intervals[i].end;
    //     }
        
    //     java.util.Arrays.sort(starts);
    //     java.util.Arrays.sort(ends);
        
    //     int i = 0, j = 0, curr = 0, max = 0;
    //     while(i < starts.length && j < ends.length){
    //         if(starts[i] < ends[j]){
    //             curr++;
    //             max = Math.max(max, curr);
    //             i++;
    //         }else{
    //             curr--;
    //             j++;
    //         }
    //     }
    //     return max;
    // }
    
    // 2.Use MinHeap as curr needed rooms
//     public int minMeetingRooms(int[][] intervals) {
//         if (intervals == null || intervals.length == 0) return 0;
        
//         // Sort the array based on the start time.
//         Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        
//         // MinHeap to store the meeting rooms (and the meeting's start and end time) based on the end time of the meeting (sort by end time)
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
//         pq.offer(intervals[0]);
        
        
//         for (int i = 1; i < intervals.length; i++) {
//             //compare curr meeting's start time with the first ending meeting's end time
//             int[] curr = intervals[i];
//             int[] prev = pq.poll();
//             if (curr[0] < prev[1]) {
//                 // means prev and curr has overlapping, and we need a new room.
//                 pq.offer(curr);
//             } else {
//                 // means there is no overlapping, so we just reuse the prev's meeting room for curr
//                 prev[1] = Math.max(prev[1], curr[1]);
//             }
//             pq.offer(prev);
//         }
        
//         return pq.size();
//     }
    
    // 3.Use TreeMap.(not understand clearly)
        public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] iter : intervals) {
            map.put(iter[0], map.getOrDefault(iter[0], 0) + 1);
            map.put(iter[1], map.getOrDefault(iter[1], 0) - 1);
        }
        
        int max = 0, curr = 0;
        for (int k : map.keySet()) {
            curr += map.get(k);
            max = Math.max(max, curr);
        }
        
        return max;
    }
}
