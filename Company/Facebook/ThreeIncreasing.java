
class ThreeIncreasing{
    public boolean increasingTriplet(int[] nums){
        if(nums == null || nums.length < 3) return false;

        int min = Integer.MAX_VALUE, mid = Integer.MAX_VALUE;

        for(int n : nums){
            if(n < min) min = n;
            else if(n < mid){
                mid = n;
            }else{
                return true;
            }
        }

        return false;
    }
}