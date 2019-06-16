/*
https://leetcode.com/problems/adding-two-negabinary-numbers/discuss/303901/Python-beats-100This-is-my-first-question-I-contributed-on-leetcode-here-is-my-approach


https://leetcode.com/problems/adding-two-negabinary-numbers/discuss/307677/java-2ms-solution-with-explanation
The basic idea is sum bit by bit. The key is how to process carry. There are five situations for the bit sum:

sum = 0 -> carry = 0, result = 0
sum = 1 -> carry = 0, result = 1
sum = 2 -> carry = -1, result = 0
sum = 3 -> carry = -1, result = 1
sum = -1 -> carry = 1, result = 1
Here, carry will be added to the sum of next calculation and result is what we put on current bit. We can either enumerate all five situations or use bit manipulation:

carry = -1 * (sum >> 1)
result = sum & 1
to calculate carry and result quickly.
*/
class Solution {
    
    /*
    https://leetcode.com/problems/adding-two-negabinary-numbers/discuss/303751/C%2B%2BPython-Convert-from-Base-2-Addition
    
    */
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int carry = 0, i = arr1.length - 1, j = arr2.length - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) carry += arr1[i--];
            if (j >= 0) carry += arr2[j--];
            sb.append(carry & 1);
            carry = -1 * (carry >> 1);
        }
        
        /*
        Input
        [1]
        [1,1]
        Output
        [0,0]
        Expected
        [0]
        */
        String str = sb.reverse().toString();
        while (str.length() > 1 && str.charAt(0) == '0') {
            str = str.substring(1);
        }
        
        int[] res = new int[str.length()];
        for (int k = 0; k < str.length(); k++) {
            res[k] = Character.getNumericValue(str.charAt(k));
        }
        
        return res;
    }
}
