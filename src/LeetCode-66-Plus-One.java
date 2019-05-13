public class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0) return digits;
        int carry = 1;
        for(int i = digits.length - 1; i >= 0; i--){
            int digit = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = digit;
            if(carry == 0) return digits;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
    
    public int[] plusOne(int[] digits) {
        
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = digit;
        }
        
//         if (carry > 0) {
//             int[] arr = new int[digits.length + 1];
//             arr[0] = carry;
//             for (int i = 1; i < digits.length + 1; i++) {
//                 arr[i] = digits[i - 1];
//             }
            
//             return arr;
//         }
        if (carry == 0) return digits;
        
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}
