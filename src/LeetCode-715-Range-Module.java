// 1. Using TreeMap
/*
https://leetcode.com/problems/range-module/discuss/108910/Java-TreeMap

Runtime: 108 ms, faster than 49.64% of Java online submissions for Range Module.
Memory Usage: 51.3 MB, less than 100.00% of Java online submissions for Range Module.
*/
class RangeModule {
    
    TreeMap<Integer, Integer> map;
    public RangeModule() {
        map = new TreeMap<>();
    }
    
    public void addRange(int left, int right) {
        Integer start = map.floorKey(left);     // get the key <= left
        Integer end = map.floorKey(right);
        
        if (start != null && map.get(start) >= left) {
            // the interval [start, end_of_start) and [Left, right) has overlapping or just connected
            left = start;
        }
        
        if (end != null && map.get(end) > right) {
            // the interval [end, end_of_end) and [left, right) has overlapping
            right = map.get(end);
        }
        
        map.put(left, right);
        map.subMap(left, false, right, true).clear();
    }
    
    public boolean queryRange(int left, int right) {
        
        Integer start = map.floorKey(left);
        if (start == null) return false;
        return map.get(start) >= right;
    }
    
    public void removeRange(int left, int right) {
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        
        // we have to remove range from right to left, in the case start == end, if we process left first, we will put(start, right), which will overwrite the interval [start, end_of_start)
        if (end != null && map.get(end) > right) {
            // [end, end_of_end) and [left, right) has overlapping
            map.put(right, map.get(end));
        }
        
        if (start != null && map.get(start) > left) {
            // [start, end_of_start) and [left, right) has overlapping, just connnected ( == left) is not necessary to remove
            map.put(start, left);   // put [start, left)
        }
        
        map.subMap(left, true, right, false).clear();
    }
}

// 2. Segment Tree (Not Finish)
/*
https://leetcode.com/problems/range-module/discuss/108925/Java-Segment-Tree
https://leetcode.com/problems/range-module/discuss/185132/Java-Segment-tree-solution
https://leetcode.com/problems/range-module/discuss/121069/Java-Segment-Tree-Solution
https://leetcode.com/problems/range-module/discuss/175663/Java-Segment-Tree-with-Lazy-Propagation

*/
// class RangeModule {
//     public RangeModule() {
        
//     }
    
//     public void addRange(int left, int right) {
        
//     }
    
//     public boolean queryRange(int left, int right) {
        
//     }
    
//     public void removeRange(int left, int right) {
        
//     }
    
// }



/**
 * Your RangeModule object will be instantiated and called as such:
 * RangeModule obj = new RangeModule();
 * obj.addRange(left,right);
 * boolean param_2 = obj.queryRange(left,right);
 * obj.removeRange(left,right);
 */
