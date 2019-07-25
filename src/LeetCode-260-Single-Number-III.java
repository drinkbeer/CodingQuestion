class Solution {
    // 1. Using HashSet
    /*
    Time: O(N)
    Space: O(N)
    */
//     public int[] singleNumber(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();
//         for(int num : nums) {
//             if (set.contains(num)) {
//                 set.remove(num);
//             } else {
//                 set.add(num);
//             }
//         }
        
//         int[] res = new int[2];
//         Iterator iter = set.iterator();
//         res[0] = (int) iter.next();
//         res[1] = (int) iter.next();
//         return res;
//     }
    
    // 2. Bit Manipulation
    /*
    3: 0011
    5: 0101
    
    3^5 = 1001 = 
    
    
    Finally understand it.

        Let a and b be the two unique numbers
        XORing all numbers gets you (a xor b)
        (a xor b) must be non-zero otherwise they are equal
        If bit_i in (a xor b) is 1, bit_i at a and b are different.
        Find bit_i using the low bit formula m & -m
        Partition the numbers into two groups: one group with bit_i == 1 and the other group with bit_i == 0.
        a is in one group and b is in the other.
        a is the only single number in its group.
        b is also the only single number in its group.
        XORing all numbers in a's group to get a
        XORing all numbers in b's group to get b
        Alternatively, XOR (a xor b) with a gets you b.
    */
    public int[] singleNumber(int[] nums) {
        // 1. Step one, Get the XOR of the two unique number
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        
        // get last set bit of XOR, using it as mask to split the numbers to two groups
        diff &= -diff;
        
        // step 2: XOR to the two groups separately.
        int[] res = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
}
