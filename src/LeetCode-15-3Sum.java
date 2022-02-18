/*
LeetCode: https://leetcode.com/problems/3sum/
LintCode: http://www.lintcode.com/problem/3sum/
JiuZhang: http://www.jiuzhang.com/solutions/3sum/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-3sum/

Analysis: 
KEY POINT: must filter duplicates in all three pointers: i, lo, hi

1.sort array
2.Pointer1 scan from left to right. Record the first number. (Must filter duplicates)
3.Pointer2 and 3 scan from P1+1 and Len-1, respectively, to center. 
    If P1+P2+P3 = 0, record the result. and continue(skip duplicate numbers)
    If P1+P2+P3 < 0, P2 right move, P3 not move
    If P1+P2+P3 > 0, P2 not move, P3 left move
    
Another way to dedup: use results.contains(list) to dedup. However, it will do a bit more unused computation.
*/
public class Solution {

    // O(N^2*LogN)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) return result;
        
        Arrays.sort(nums);
        
        for (int l = 0; l < nums.length - 2; l++) {
            if (l > 0 && nums[l - 1] == nums[l]) continue;
            
            for (int r = nums.length - 1; r > l; r--) {
                if (r < nums.length - 1 && nums[r] == nums[r + 1]) continue;
                
                int remainder = 0 - nums[l] - nums[r];
                
                int lo = l + 1, hi = r - 1;
                while (lo <= hi) {
                    int mid = lo + (hi - lo) / 2;

                    if (nums[mid] == remainder) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[l]);
                        list.add(nums[mid]);
                        list.add(nums[r]);
                        result.add(list);
                        break;
                    } else if (nums[mid] < remainder) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }

                }
                
            }
        }
        
        
        return result;
    }
    
    // O(N^2)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return result;
        
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            
            // We must skip the duplicates of "i"
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            
            int lo = i + 1, hi = nums.length - 1;
            int target = 0 - nums[i];

            while (lo < hi) {
                if (nums[lo] + nums[hi] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[lo]);
                    list.add(nums[hi]);
                    result.add(list);

                    lo++;
                    hi--;

                    // skip the duplicates of "lo"
                    while(lo < hi && nums[lo] == nums[lo - 1]) lo++;
                    // skip the duplicates of "hi"
                    while(lo < hi && nums[hi] == nums[hi + 1]) hi--;
                } else if (nums[lo] + nums[hi] < target) {
                    // should move lo to right;
                    lo++;

                    // not required to skipp duplicates here, as anyway it will not be added to result. But adding it has not harm.
                    // while(lo < hi && nums[lo] == nums[lo - 1]) lo++;

                } else {
                    // should move hi to left
                    hi--;

                    // not required to skipp duplicates here, as anyway it will not be added to result. But adding it has not harm.
                    // while(lo < hi && nums[hi] == nums[hi + 1]) hi--;
                }
            }
        }
        
        return result;
    }
}
