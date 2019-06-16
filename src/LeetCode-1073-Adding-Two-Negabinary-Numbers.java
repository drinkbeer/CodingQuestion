/*
https://leetcode.com/problems/adding-two-negabinary-numbers/discuss/303901/Python-beats-100This-is-my-first-question-I-contributed-on-leetcode-here-is-my-approach
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
