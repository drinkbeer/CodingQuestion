class Solution {
    
    // 1. Using a HashMap
    /*
    Runtime: 11 ms, faster than 39.77% of Java online submissions for Majority Element.
    Too Slow
    Time O(N)
    Space O(N)
    */
//     public int majorityElement(int[] nums) {
//         Map<Integer, Integer> map = new HashMap<>();
        
//         for (int num : nums) {
//             map.put(num, map.getOrDefault(num, 0) + 1);
//             if (map.get(num) > nums.length / 2) return num;
//         }
        
//         // for (Integer key : map.keySet()) {
//         //     if (map.get(key) > nums.length / 2) return key;
//         // }
        
//         return -1;
//     }
    
    // 2. Sorting
    // public int majorityElement(int[] nums) {
    //     Arrays.sort(nums);
    //     return nums[nums.length / 2];
    // }
    
    // 3. Moore Voting Algorithm
    /*
    https://www.zhihu.com/question/49973163/answer/235921864
    https://leetcode.com/problems/majority-element/discuss/51611/Java-solutions-(sorting-hashmap-moore-voting-bit-manipulation).
    
    */
    // public int majorityElement(int[] nums) {
    //     int major = nums[0], count = 1;
    //     for (int i = 1; i < nums.length; i++) {
    //         if (count == 0) {
    //             major = nums[i];
    //             count = 1;
    //         } else if (major == nums[i]) {
    //             count++;
    //         } else {
    //             count--;
    //         }
    //     }
    //     return major;
    // }
    
    // 4. Bit Manipulation
    // public int majorityElement(int[] nums) {
    //     int[] bit = new int[32];
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = 0; j < 32; j++) {
    //             bit[j] += (nums[i] >> j) & 1;
    //         }
    //     }
    //     int majority = 0;
    //     for (int j = 0; j < 32; j++) {
    //         bit[j] = bit[j] > (nums.length / 2)? 1 : 0;
    //         majority += bit[j] << j;
    //     }
    //     return majority;
    // }
    
    /*
    https://stackoverflow.com/questions/41323936/bit-manipulation-solution-for-majority-element-in-an-array
    
The algorithm first determines the frequency of each bit in the input array. If there is a number with a majority in the input (i.e. it makes up more than half of the input), then the frequency of all its set bits will be in the majority, and the frequency of all its unset bits will be in the minority.

The majority number can be recreated from the frequency table by masking together all the majority bits. This relies on there being a majority. If there is not guaranteed to be a majority a second pass to check the result is required.
    
    */
//     public static int majorityElement(int[] nums) {
//         // Bit frequency table 
//         int[] bit = new int[32];

//         // Work out bit frequency
//         for (int num : nums)
//             for (int i = 0; i < 32; i++)   // for each bit
//                 if ((num & 1 << i) != 0)   // is bit i set?
//                     bit[i]++;              // increment frequency

//         // Recreate the majority number 
//         int ret = 0;
//         for (int i = 0; i < 32; i++)       // for each bit   
//             if (bit[i] > nums.length / 2)  // is bit i in the majority?
//                 ret |= 1 << i;             // mask bit i into the result
//         return ret;
//     }
    
    
    /*
    https://www.cnblogs.com/grandyang/p/4233501.html
    下面这种解法利用到了位操作 Bit Manipulation 来解，将中位数按位来建立，从0到31位，每次统计下数组中该位上0和1的个数，如果1多，那么我们将结果res中该位变为1，最后累加出来的res就是过半数了，相当赞的方法，参见代码如下：


    */
    public int majorityElement(int[] nums) {
        int res = 0, n = nums.length;
        for (int i = 0; i < 32; ++i) {
            int ones = 0, zeros = 0;
            for (int num : nums) {
                if (ones > n / 2 || zeros > n / 2) break;
                if ((num & (1 << i)) != 0) ++ones;
                else ++zeros;
            }
            if (ones > zeros) res |= (1 << i);
        }
        return res;
    }

}
