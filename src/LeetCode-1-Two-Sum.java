/*
LeetCode: https://leetcode.com/problems/two-sum/
LintCode: http://www.lintcode.com/problem/two-sum/
JiuZhang: http://www.jiuzhang.com/solutions/two-sum/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-solution-of-two-sum-in-java/

Analysis:
Use HashMap to record visited nodes.
Be careful, index starts from 1, not 0.
*/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length < 2) return result;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int idx = map.get(nums[i]);
                result[0] = idx + 1;
                result[1] = i + 1;
                break;
            }else{
                map.put(target - nums[i], i);
            }
        }
        return result;
        
    }
}