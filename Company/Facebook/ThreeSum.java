/*
https://leetcode.com/problems/3sum/

*/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return result;

        java.util.Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++){

            if(i != 0 && nums[i - 1] == nums[i]) continue;  // skip same result

            int lo = i + 1, hi = nums.length - 1;
            int target = 0 - nums[i];
            while(lo < hi){
                if(target == nums[lo] + nums[hi]){
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(lo);
                    list.add(hi);

                    result.add(list);

                    while(lo < hi && nums[lo] == nums[lo + 1]) lo++;    //skip same result
                    while(lo < hi && nums[hi] == nums[hi - 1]) hi--;    //skip same result
                    lo++; hi--;
                }else if(target > nums[lo] + nums[hi]){
                    lo++;
                }else{
                    hi--;
                }
            }
        }

        return result;
    }
}