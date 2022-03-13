class PhoneDirectory {
    int[] nums;
    int count;
    int i;
    public PhoneDirectory(int maxNumbers) {
        this.nums = new int[maxNumbers];
        this.count = 0;
        this.i = 0;
        
        Arrays.fill(nums, -1);
    }
    
    public int get() {
        if (count == nums.length) return -1;
        if (this.i == -1) return -1;
        
        int available = i;
        nums[i] = i;
        count++;
        this.i = -1;
        
        // find next available
        if (count < nums.length) {
            for (int k = 0; k < nums.length; k++) {
                if (k == this.i) continue;
                if (nums[k] == -1) {
                    this.i = k;
                    break;
                }
            }
        }
        
        return available;
    }
    
    public boolean check(int number) {
        return nums[number] == -1;
    }
    
    public void release(int number) {
        if (nums[number] == number) {
            nums[number] = -1;
            count--;
        }
        this.i = number;
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */
