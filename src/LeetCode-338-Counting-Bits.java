class Solution {
    // public int[] countBits(int num) {
    //     int[] res = new int[num + 1];
    //     for (int i = 1; i <= num; i++) {
    //         res[i] = countBits(i / 2) + (i & 1);
    //     }
    //     return res;
    // }
    
    /*
    https://leetcode.com/problems/counting-bits/discuss/79539/Three-Line-Java-Solution
    
    Explaination.
    Take number X for example, 10011001.
    Divide it in 2 parts:
    <1>the last digit ( 1 or 0, which is " i&1 ", equivalent to " i%2 " )
    <2>the other digits ( the number of 1, which is " f[i >> 1] ", equivalent to " f[i/2] " )
    
    
    https://leetcode.com/problems/counting-bits/discuss/79557/How-we-handle-this-question-on-interview-Thinking-process-%2B-DP-solution
    
    */
    // public int[] countBits(int num) {
    //     int[] f = new int[num + 1];
    //     for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
    //     return f;
    // }
    
    
    /*
    https://leetcode.com/problems/counting-bits/discuss/79557/How-we-handle-this-question-on-interview-Thinking-process-%2B-DP-solution
    */
    
    public int[] countBits(int num) {
        int result[] = new int[num + 1];
        int offset = 1;
        for (int index = 1; index < num + 1; ++index){
            if (offset * 2 == index){
                offset *= 2;
            }
            result[index] = result[index - offset] + 1;
        }
        return result;
    }
}
