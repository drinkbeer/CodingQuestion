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
*/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) return result;
        
        java.util.Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            // filter duplicate numbers
            if(i == 0 || nums[i] > nums[i - 1]){
                int neg = -nums[i];
                
                int lo = i + 1;
                int hi = nums.length - 1;
                
                while(lo < hi){
                    if(nums[lo] + nums[hi] == neg){
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[lo]);
                        temp.add(nums[hi]);
                        result.add(temp);
                        
                        lo++;
                        hi--;
                        
                        while(lo < hi && nums[lo] <= nums[lo-1]){
                            lo++;
                        }
                        while(lo < hi && nums[hi] >= nums[hi+1]){
                            hi--;
                        }
                    }else if(nums[lo] + nums[hi] > neg){
                        hi--;
                    }else if(nums[lo] + nums[hi] < neg){
                        lo++;
                    }
                }
            }
        }
        return result;
    }
}
