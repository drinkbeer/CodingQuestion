class Solution {
//     public int compress(char[] chars) {
//         int s = 0, i = 0;
//         while(i < chars.length) {
//             int j = i;      // j is the last index of the substring
//             while(j < chars.length - 1 && chars[j] == chars[j + 1]) j++;
//             if (j != i) {
//                 int len = j - i + 1;
//                 chars[s++] = chars[i];
//                 String lenStr = String.valueOf(len);
//                 for (char c : lenStr.toCharArray()) chars[s++] = c;
                
//             } else {
//                 // there is only one character in the substring, no need compression
//                 chars[s++] = chars[i];
//             }
//             i = j + 1;
//         }
//         return s;
//     }
    
    
    public int compress(char[] chars) {
        int n = chars.length;
        int s = 0, i = 0;
        while (i < n) {
            int j = i, count = 0;
            while (j < n && chars[i] == chars[j]) {
                count++;
                j++;
            }
            chars[s++] = chars[i];
            if (count > 1) {
                char[] numChars = (count + "").toCharArray();
                for (char c : numChars) chars[s++] = c;
            }
            i = j;
        }
        
        return s;
    }
}
