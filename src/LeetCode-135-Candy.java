class Solution {
    /*
    https://leetcode.com/problems/candy/discuss/42770/One-pass-constant-space-Java-solution
    If you draw all the rating points on a graph, there are peaks and bottoms and apparently:

    All the bottoms should be given 1 candy in the final result.
    The neighbors of the bottoms should be given 1 more candy as we move from bottom point to peak point.
    For example if you have an array [1,2,4,3,2,1], bottoms are the 1s on both sides and the peak is 4, both 1s should be given 1 candy and their neighbors 2s should be given 1+1=2 candies. Likewise, 3 should be given 2+1=3 candies and 4 which is the peak should be given 4 candies. If we know the lengths from the peak to bottom on both sides, we can figure out how many candies should be given to the peak (Math.max(left, right)) and the total candies needed for the array. For the above example, the length on the left is 2 ([1,2] peak not included) and length on the right is 3([3,2,1] peak not included), thus the peak should be assign Math.max(left, right)+1 candies and the total candies needed for the array will be (1+left)*left/2 + (1+right)*right/2 + peak. In the codes below, we minus it by 1 because the left bottom was calculated once in the previous round.

    In real test cases, we can have array with multiple peaks and bottoms. For example: [1,2,4,3,2,1,5,6,9,4,2]. In this case, we just split the array by the bottoms and calculate each sub arr and merge the result.
    [1,2,4,3,2,1,5,6,9,4,2] -> [1,2,4,3,2,1] and [1,5,6,9,4,2]
    For rating with same value, we just add 1 to the result.
    
    
    */
//     public int candy(int[] ratings) {
//         int i = 0, s = 0, sum = 1;
//         int n = ratings.length;
//         while (i < n - 1) {
//             while (i < n - 1 && ratings[i] < ratings[i + 1]) i++;
//             int leftCount = i - s;
//             s = i;
            
//             while (i < n - 1 && ratings[i] > ratings[i + 1]) i++;
//             int rightCount = i - s;
//             s = i;
            
//             int maxCount = Math.max(leftCount, rightCount) + 1;
//             sum += leftCount * (leftCount + 1) / 2 + rightCount * (rightCount + 1) / 2 + maxCount - 1;
            
//             while (i < n - 1 && ratings[i] == ratings[i + 1]) {
//                 // if the next child has same rating with the previous one, we just give one candy to him.
//                 i++;
//                 sum++;
//             }
//             s = i;
//         }
        
//         return sum;
//     }
    
    // 2. Two Way Scan
    /*
    https://leetcode.com/problems/candy/discuss/42769/A-simple-solution
    https://leetcode.com/problems/candy/discuss/42774/Very-Simple-Java-Solution-with-detail-explanation
    */
//     public int candy(int[] ratings) {
//         int n = ratings.length, sum = 0;
//         int[] res = new int[n];
//         Arrays.fill(res, 1);
        
//         for (int i = 1; i < n; i++) {
//             // processing the case that ascending from left to right
//             if (ratings[i - 1] < ratings[i]) {
//                 res[i] = res[i - 1] + 1;
//             }
//         }
        
//         for (int i = n - 2; i >= 0; i--) {
//             // processing the case that ascending from right to left
//             if (ratings[i] > ratings[i + 1]) {
//                 res[i] = Math.max(res[i], res[i + 1] + 1);
//             }
//         }
        
//         for (int r : res) sum += r;
//         return sum;
//     }
    
    // 3. One-Pass Scan (Best Solution)
    /*
    https://leetcode.com/problems/candy/discuss/42770/One-pass-constant-space-Java-solution
    https://leetcode.com/problems/candy/discuss/161652/One-pass-O(n)-with-O(1)-space-shortest-solution-easy-to-understand
    */
    public int candy(int[] ratings) {
        int n = ratings.length, sum = 1, inc = 1, dec = 1;
        // sum = 1 is for the first element.
        
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                // means it's increasing
                if (i > 1 && ratings[i - 2] > ratings[i - 1]) {
                    // means i - 1 is the bottom, i has already counted in the previous tracing down
                    inc = 1;
                    dec = 1;
                }
                inc++;
                sum += inc;
            } else if (ratings[i - 1] > ratings[i]) {
                // means it's decreasing
                dec++;
                sum += dec - 1;     // the reason we add dec - 1, not dec, because peak one is already counted in the previous ascending. so we will add "dec - 1"
                if (dec > inc) sum++;   // we have to give peak one more candy if dec > inc.
            } else {
                // means it's an equal case, one candy for each child is enough
                sum++;
                inc = 1;
                dec = 1;
            }
            
        }
        return sum;
    }
}
