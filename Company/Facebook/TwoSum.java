public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0) return null;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int[] result = new int[2];
        for(int i = 0; i < nums; i++){
            if(map.containsKey(nums[i])){
                result[0] = map.get(nums[i]);
                result[1] = i;
                break;
            }else{
                map.put(target - nums[i], i);
            }
        }

        return result;
    }
}