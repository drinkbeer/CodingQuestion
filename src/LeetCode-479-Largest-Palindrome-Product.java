class Solution {
    // 1. Brute Force (TLE)
    /*
    https://leetcode.com/problems/largest-palindrome-product/discuss/303742/Java-TLE-brute-force-solution
    */
//     public int largestPalindrome(int n) {
//         if (n == 1) return 9;
        
//         // n = 2, [10, 99], n = 3, [100, 999]
//         int upper = (int) Math.pow(10, n) - 1;
//         int lower = upper / 10 + 1;
        
//         for (int i = upper; i > lower; i--) {
//             for (int j = i; i > lower; i--) {
//                 long prod = i * j;
//                 if (isPalindrome(prod)) {
//                     return (int) prod % 1337;
//                 }
//             }
//         }
//         return 9;
//     }
    
//     private boolean isPalindrome(long prod) {
//         String str = String.valueOf(prod);
//         int i = 0, j = str.length() - 1;
//         while (i < j) {
//             if (str.charAt(i) != str.charAt(j)) {
//                 return false;
//             }
//         }
//         return true;
//     }
    
    // 2. Searching From palindrome to product
    /*
    https://leetcode.com/problems/largest-palindrome-product/discuss/96306/Java-solutions-with-two-different-approaches
    Step1: construct a palindrome
    
    These palindromes can be divided into two parts with equal number of digits (n for each part): left and right. And left will be a mirror image of right, and vice versa. Therefore each palindrome will be fully determined by either its left or right part.
    
    */
    public int largestPalindrome(int n) {
        if (n == 1) return 9;
        
        long max = (long) Math.pow(10, n) - 1;
        long min = max / 10 + 1;
        
        for (long h = max; h > min; h--) {
            // Step1: Construct the Palindromes and arrange them in descending order
            // For format of palindrome is  "h" + reverse("h")
            long left = h, right = 0;
            for (long i = h; i != 0; i /= 10) {
                left *= 10;     // shift 'left' one digit forward left, so give space for right (as finally we will do left + right)
                right = right * 10 + i % 10;
            }
            long palindrome = left + right;
            
            // Step2: Validate if the Palindromes are the product of two n-digit numbers
            for (long i = max; i > min; i--) {
                long j = palindrome / i;
                if (j > i) break;
                if (palindrome % i == 0) return (int) (palindrome % 1337);
            }
        }
        
        return 9;
    }
    
    // From product to palindrome (Not done)
    /*
    https://leetcode.com/problems/largest-palindrome-product/discuss/96306/Java-solutions-with-two-different-approaches
    
    */
}
