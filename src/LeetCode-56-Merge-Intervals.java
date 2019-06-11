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
//     public int[][] merge(int[][] intervals) {
//         List<int[]> result = new ArrayList<>();
//         if (intervals == null || intervals.length == 0) return result.toArray(new int[0][]);
        
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//         int n = intervals.length;
//         int start = intervals[0][0];
//         int end = intervals[0][1];
        
//         /*
//         The idea here is keep on scaning the intervals.
        
//         When ever we found a end[j] < start[j + 1], that means we found an non-overlapping interval, add to result.
        
//         Be careful when we reached the last element of end, we have to add the last element to result.
//         */
//         // i is the index in start array, j is the index in end array.
//         for (int[] interval : intervals) {
//             if (interval[0] > end) {
//                 // means [start, end] is a new non-overlapping interval
//                 result.add(new int[]{start, end});
//                 start = interval[0];
//                 end = interval[1];
//             } else {
//                 // [start, end] and current interval is overlapping, we need update the end
//                 end = Math.max(end, interval[1]);
//             }
//         }
//         result.add(new int[]{start, end});
        
//         return result.toArray(new int[result.size()][]);
//     }
    
//     public int[][] merge(int[][] intervals) {
//      if (intervals == null || intervals.length <= 1) return intervals;
//         Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
//         int start = intervals[0][0];
//         int end = intervals[0][1];
//         List<int[]> res = new ArrayList<>();

//         for (int[] interval : intervals) {
//             if (interval[0] <= end) {
//                 end = Math.max(end, interval[1]);
//             } else {
//                 res.add(new int[]{start, end});
//                 start = interval[0];
//                 end = interval[1];
//             }
//         }
//         res.add(new int[]{start, end});

//         int[][] ans = new int[res.size()][2];

//         for (int i = 0; i < res.size(); i++) {
//             ans[i][0] = res.get(i)[0];
//             ans[i][1] = res.get(i)[1];
//         }

//         return ans;
//     }
    
    // Sorting the start array and end array.
    /*
    Runtime: 2 ms, faster than 99.79% of Java online submissions for Merge Intervals.
    */
     public int[][] merge(int[][] intervals) {
         if (intervals == null || intervals.length == 0 || intervals.length == 1) return intervals;
         
         int[] start = new int[intervals.length];
         int[] end = new int[intervals.length];
         for (int i = 0; i < intervals.length; i++) {
             start[i] = intervals[i][0];
             end[i] = intervals[i][1];
         }
         Arrays.sort(start);
         Arrays.sort(end);
         
         List<int[]> result = new ArrayList<>();
         int lo = start[0], hi = end[0];
         for (int i = 1; i < intervals.length; i++) {
             if (hi >= start[i]) {
                 // means we need merging
                 hi = end[i];
             } else {
                 result.add(new int[]{lo, hi});
                 lo = start[i];
                 hi = end[i];
             }
         }
         
         result.add(new int[]{lo, hi});
         return result.toArray(new int[result.size()][]);
     }
}
