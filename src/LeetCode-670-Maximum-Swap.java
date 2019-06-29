class Solution {
    // 1. Wrong Answer.
    /*
    The problem is converted to finding two indexes.
    num[i1] < num[i2]
    i1 < i2
    num[i1] and num[i2] is the two maximum value, i1 is the second maximum value, i2 is the maximun value
    */
//     public int maximumSwap(int num) {
//         if (num <= 10) return 0;
//         String str = new String(num);
//         char[] chs = str.toCharArray();
//         int v1 = Integer.MIN_VALUE, v2 = chs[0] - '0';
//         int i1 = 0, i2 = 0, n = chs.length;
        
//         for (int i = 1; i < n; i++) {
//             int val = chs[i] - '0';
//             if (val > v2) {
//                 i1 = i2;
//                 i2 = i;
//                 v1 = v2;
//                 v2 = val;
//             } else if (val > v1) {
//                 i1 = i;
//                 v1 = val;
//             }
//         }
        
//         if (v1 == Integer.MIN_VALUE || v2 = Integer.MIN_VALUE) return num;
        
//         char c = chs[i1];
//         chs[i1] = chs[i2];
//         chs[i2] = c;
        
//         int res = 0;
//         for (char ch : chs) {
//             res = 10 * res + ch - '0';
//         }
        
//         return res;
//     }
    
    // 2.Wrong Ans
//     public int maximumSwap(int num) {
//         // check the boundary
//         if (num <= 10) return num;
        
//         int s = 0, l = 0;
//         int maxDiff = 0;
//         String str = num + "";
//         char[] chs = str.toCharArray();
//         for (int i = 0; i < chs.length; i++) {
//             if (chs[i] < chs[s]) s = i;
//             /*
//             it has to be maxDiff <=, rather than <,
//             because 1993
//             <=  result is: 9913
//             <   result is: 9193
//             */
//             if (maxDiff <= chs[i] - chs[s]) {
//                 l = i;
//                 maxDiff = chs[i] - chs[s];
//             }
//         }
        
//         if (s == l) return num;
//         if (s < l && chs[s] < chs[l]) {
//             char temp = chs[s];
//             chs[s] = chs[l];
//             chs[l] = temp;
//         }
        
//         int res = 0;
//         for (char ch : chs) {
//             res = 10 * res + ch - '0';
//         }
//         return res;
//     }
    
    // 2. Scan
    /*
    From right to left, get the maximum right view array.
    From left to right, get the first char that is smaller than the back array.
    https://www.cnblogs.com/grandyang/p/7583875.html
    */
//     public int maximumSwap(int num) {
//         // check the boundary
//         if (num <= 10) return num;
        
//         char[] chars = (num + "").toCharArray();
//         int n = chars.length;
//         char[] back = new char[n];
//         back[n - 1] = chars[n - 1];
//         for (int i = n - 2; i >= 0; i--) {
//             if (chars[i] >= back[i + 1]) {
//                 back[i] = chars[i];
//             } else {
//                 back[i] = back[i + 1];
//             }
//         }
        
//         // chars[i] <= back[i]
//         for (int i = 0; i < n; i++) {
//             if (chars[i] == back[i]) continue;
            
//             // so now chars[i] < back[i]
//             int j = n - 1;
//             for (; j >= i; j--) {
//                 if (back[i] == chars[j]) break;
//             }
            
//             if (i != j) {
//                 char temp = chars[i];
//                 chars[i] = chars[j];
//                 chars[j] = temp;
//                 break;
//             }
//         }
        
//         int res = 0;
//         for (char c : chars) res = 10 * res + c - '0';
//         return res;
//     }
    
    // bucket sort
    /*
    https://www.cnblogs.com/grandyang/p/7583875.html
    */
    public int maximumSwap(int num) {
        // check the boundary
        if (num <= 10) return num;
        
        int[] bucket = new int[10];
        Arrays.fill(bucket, -1);
        
        char[] chars = (num + "").toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) bucket[chars[i] - '0'] = i;
        
        // System.out.println(Arrays.toString(bucket));
        
        for (int i = 0; i < n; i++) {
            // scan the bucket, trying to find a number which is larger than chars[i], but has the last index smaller than i
            for (int j = 9; j > chars[i] - '0'; j--) {
                if (i >= bucket[j]) continue;
                
                char temp = chars[i];
                chars[i] = chars[bucket[j]];
                chars[bucket[j]] = temp;
                int res = 0;
                for (char c : chars) res = 10 * res + c - '0';
                return res;
            }
        }
        
        return num;
    }
}
