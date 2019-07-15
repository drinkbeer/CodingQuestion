class Solution {
    // 1. Using %
//     public List<String> fizzBuzz(int n) {
//         List<String> res = new ArrayList<>();
//         for (int i = 1; i <= n; i++) {
//             String str = "";
//             if (i % 3 != 0 && i % 5 != 0) {
//                 str = i + "";
//             } else {
//                 if (i % 3 == 0) {
//                     str += "Fizz";
//                 }
//                 if (i % 5 == 0) {
//                     str += "Buzz";
//                 }
//             }
//             res.add(str);
//         }
        
//         return res;
//     }
    
    // 2. Iterative
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1, fizz = 0, buzz = 0; i <= n; i++) {
            fizz++;
            buzz++;
            if (fizz == 3 && buzz == 5) {
                res.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if (fizz == 3) {
                res.add("Fizz");
                fizz = 0;
            } else if (buzz == 5) {
                res.add("Buzz");
                buzz = 0;
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
    
    // Follow-Up: How to make the approach more extensible?
    /*
    https://leetcode.com/problems/fizz-buzz/discuss/89936/Java-Fuzz-Buzz-Follow-up(no-if-else-and-extendable)
    */
}
