class Solution {
    public String largestNumber(int[] nums) {
        // Arrays.sort(nums, (s1, s2) -> (s1+s2).compareTo(s2+s1));
        String[] strs = new String[nums.length];
		for(int i = 0; i < nums.length; i++) strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (s1, s2) -> ((s2 + "") + s1).compareTo((s1 + "") +s2));
        
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }
}
