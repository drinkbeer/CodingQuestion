/*

1. Using a List to hold interval

addNum
Time O(N)   -   N is number of intervals
Space O(N)

2. Using a TreeMap to hold interval

addNum
Time O(logN)
Space O(N)

Follow-up:What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
https://leetcode.com/problems/data-stream-as-disjoint-intervals/discuss/123414/Change-3-lines-switch-from-original-to-follow-up
lots of merges -> add() cannot be too costy
the number of disjoint intervals are small -> get() can be costy

to reduce add, use O(logn) for insertion of points (no merge), and maintain order
get will have to calculate the disjoint intervals on the fly (do a merge on get)





*/
class SummaryRanges {

    // 1. List based implementation.
//     List<int[]> list;
    
//     /** Initialize your data structure here. */
//     public SummaryRanges() {
//         list = new ArrayList<>();
//     }
    
//     public void addNum(int val) {
//         int start = val, end = val;
        
//         List<int[]> res = new ArrayList<>();
//         for (int[] interval : list) {
//             if (interval[1] + 1 < start) {
//                 // means we have not reached the [val, val]
//                 res.add(interval);
//             } else if (end + 1 < interval[0]) {
//                 // means curr interval has already passed the range [start, end]
//                 res.add(new int[] {start, end});
//                 start = interval[0];
//                 end = interval[1];
//             } else {
//                 // means there is overlapping between [start, end] and interval
//                 start = Math.min(start, interval[0]);
//                 end = Math.max(end, interval[1]);
//             }
//         }
//         res.add(new int[] {start, end});
//         list = res;
//     }
    
//     public int[][] getIntervals() {
//         return list.toArray(new int[list.size()][]);
//     }
    
    // 2. TreeMap based implementation.
    /*
    https://leetcode.com/problems/data-stream-as-disjoint-intervals/discuss/82553/Java-solution-using-TreeMap-real-O(logN)-per-adding.
    
    Time O(log(N))
    */
    TreeMap<Integer, Integer> map;
    public SummaryRanges() {
        map = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if (map.containsKey(val)) return;
        
        Integer l = map.lowerKey(val);  // the key that is just lower than val, could be null if no exist
        Integer h = map.higherKey(val); // the key that is just higher than val, could be null if no exist
        
        if (l != null && h != null && map.get(l) + 1 == val && val + 1 == h) {
            // means [l, lv], [val, val], [h, hv] could be merged
            map.put(l, map.get(h));
            map.remove(h);
        } else if (l != null && map.get(l) + 1 >= val) {
            // means [l, lv], [val, val] has overlap
            map.put(l, Math.max(map.get(l), val));
        } else if (h != null && val + 1 >= h) {
            // means [val, val] [h, hv] has overlap
            map.put(val, map.get(h));
            map.remove(h);
        } else {
            // means [l, lv], [val, val], [h, hv] have no overlapping
            map.put(val, val);
        }
    }
    
    public int[][] getIntervals() {
        int[][] res = new int[map.size()][2];
        
        int i = 0;
        for (Map.Entry e : map.entrySet()) {
            res[i][0] = (int) e.getKey();
            res[i++][1] = (int) e.getValue();
        }
        
        return res;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
