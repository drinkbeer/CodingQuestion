
class ThreeIncreasing{
    public boolean increasingTriplet(int[] nums){
        if(nums == null || nums.length < 3) return false;

        int len = .length;
        int i = 1;
        while(i < len && nums[i - 1] >= nums[i]) i++;

        if(i == len - 1 || i == len - 2) return false;

        int a = i - 1;
        int b = i;
        int least = i - 1;
        for(i = n + 1; i < len; i++){
            if(nums[i] > nums[b]){
                int c = i;
                return true;
            }

            if(nums[i] > nums[a] && nums[i] < nums[b]){
                b = i;
            }else if(nums[i] > nums[least] && nums[i] < nums[b]){
                a = least;
                b = i;
            }
        }
        
        return false;
    }
}