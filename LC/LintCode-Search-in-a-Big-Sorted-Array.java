/*
LeetCode: N
LintCode: http://www.lintcode.com/en/problem/search-in-a-big-sorted-array/
JiuZhang: http://www.jiuzhang.com/solutions/search-in-a-big-sorted-array/
ProgramCreek: N

Analysis:
1.Get the pointer prev < target and next >= target
2.Binary Search between prev and next
*/

/**
 * Definition of ArrayReader:
 * 
 * class ArrayReader {
 *      // get the number at index, return -1 if not exists.
 *      public int get(int index);
 * }
 */
public class Solution {
    /**
     * @param reader: An instance of ArrayReader.
     * @param target: An integer
     * @return : An integer which is the index of the target number
     */
    public int searchBigSortedArray(ArrayReader reader, int target) {
        // write your code here
        if(reader.get(0) == target) return 0;
        else if(reader.get(1) == target) return 1;
        
        int prev = 0, next = 1;
        while(reader.get(next) != -1 && reader.get(next) < target){
            prev = next;
            next *= 2;
        }
        
        while(prev + 1 < next){
            int mid = prev + (next - prev) / 2;
            
            if(reader.get(mid) < target) prev = mid;
            else next = mid;
        }
        
        if(reader.get(prev) == target) return prev;
        if(reader.get(next) == target) return next;
        return -1;
    }
}