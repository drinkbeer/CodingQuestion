class Solution {
    public int compress(char[] chars) {
        int s = 0, i = 0;
        while(i < chars.length) {
            int j = i;      // j is the last index of the substring
            while(j < chars.length - 1 && chars[j] == chars[j + 1]) j++;
            if (j != i) {
                int len = j - i + 1;
                chars[s++] = chars[i];
                String lenStr = String.valueOf(len);
                for (char c : lenStr.toCharArray()) chars[s++] = c;
                
            } else {
                // there is only one character in the substring, no need compression
                chars[s++] = chars[i];
            }
            i = j + 1;
        }
        return s;
    }
}
