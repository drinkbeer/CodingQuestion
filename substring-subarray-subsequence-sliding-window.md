
### Template
```Java
int findSubstring(string s){
    vector<int> map(128,0);
    int counter; // check whether the substring is valid
    int begin=0, end=0; //two pointers, one point to tail and one  head
    int d; //the length of substring

    for() { /* initialize the hash map here */ }

    while(end<s.size()){

        if(map[s[end++]]-- ?){  /* modify counter here */ }

        while(/* counter condition */){ 
             
             /* update d here if finding minimum*/

            //increase begin to make it invalid/valid again
            
            if(map[s[begin++]]++ ?){ /*modify counter here*/ }
        }  

        /* update d here if finding maximum*/
    }
    return d;
}
```

[3. Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)  
```
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int start = 0, end = 0, max = Integer.MIN_VALUE;
        int[] arr = new int[256];
        while (end < s.length()) {
            if (arr[s.charAt(end)] == 0) {
                arr[s.charAt(end)] = 1;
                max = Math.max(max, end - start + 1);
                end++;
            } else {
                arr[s.charAt(start)] = 0;
                start++;
            }
        }
        
        return max;
    }
```

[5. Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring/)  
```
    public String longestPalindrome(String s) {
        int max = Integer.MIN_VALUE;
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindromic(s, i, j - 1)) {
                    if (max < j - i) {
                        max = j - i;
                        result = s.substring(i, j);
                    }
                }
            }
        }
        return result;
    }
    
    private boolean isPalindromic(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) return false;
        }
        return true;
    }
```

[30. Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)  

[76. Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)  
```
    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";
        
        int[] map = new int[256];
        for (char ch : t.toCharArray()) map[ch]++;
        
        int sLen = s.length(), tLen = t.length();
        int sStart = 0, sEnd = 0, minStart = -1, minLen = Integer.MAX_VALUE, count = t.length();
        while (sEnd < sLen) {
            char ch = s.charAt(sEnd);
            if (map[ch] > 0) count--;
            map[ch]--;
            
            while (count == 0) {
                // update the min window if necessary
                if (minLen > sEnd - sStart + 1) {
                    minLen = sEnd - sStart + 1;
                    minStart = sStart;
                }
                
                // try to move sStart to shrink the window
                char ch2 = s.charAt(sStart);
                map[ch2]++;
                if (map[ch2] > 0) count++;
                
                sStart++;
            }
            
            sEnd++;
        }
        return minStart == -1 ? "" : s.substring(minStart, minStart + minLen);
    }
```

[159. Longest Substring with At Most Two Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/)  

[209. Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
```
    public int minSubArrayLen(int s, int[] nums) {
        int start = 0, end = 0, minStart = -1, minLen = Integer.MAX_VALUE, sum = 0;
        while (end < nums.length) {
            sum += nums[end];
            
            while (sum >= s) {
                // successfully get one subarray sum >= s, but not sure if it's the smallest one
                if (minLen > end - start + 1) {
                    minStart = start;
                    minLen = end - minStart + 1;
                }
                
                // move start to get a smaller window
                sum -= nums[start];
                start++;
            }
            
            end++;
        }
        
        return minStart == -1 ? 0 : minLen;
    }
```

[340. Longest Substring with At Most K Distinct Characters](https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/)  

[395. Longest Substring with At Least K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/)  


### Reference
[Here is a 10-line template that can solve most 'substring' problems](https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems)  
[O(N)  template for Minimum Size Subarray Sum & Minimum Window Substring & Longest Substring Without Repeating Characters
](https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59110/O(N)-template-for-Minimum-Size-Subarray-Sum-and-Minimum-Window-Substring-and-Longest-Substring-Without-Repeating-Characters)  

