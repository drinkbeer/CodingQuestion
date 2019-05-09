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
    
    // 1.Wrong Answer, as we need return the indices, not the value. So I cannot sort the array.
//     public int[] twoSum(int[] nums, int target) {
//         Arrays.sort(nums);
//         int[] result = new int[2];

//         int l = 0, r = nums.length - 1;
//         while (l < r) {
//         	if (nums[l] + nums[r] == target) {
//         		result[0] = l;
//         		result[1] = r;
//         		return result;
//         	} else if (nums[l] + nums[r] < target) {
//         		l++;
//         	} else {
//         		r--;
//         	}
//         }

//         return result;
//     }
    
    // 2.Correct Answer. Using a HashMap
    public int[] twoSum(int[] nums, int target) {
    	int[] result = new int[2];

    	HashMap<Integer, Integer> map = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
    		if (map.containsKey(nums[i])) {
    			result[0] = map.get(nums[i]);
    			result[1] = i;
    			return result;
    		}
            map.put(target - nums[i], i);
    	}
    	return null;
    }
    
}
