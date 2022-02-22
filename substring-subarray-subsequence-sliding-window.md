
# Template
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

Another Template:

```
public class Solution {
    public List<Integer> slidingWindowTemplateByHarryChaoyangHe(String s, String t) {
        //init a collection or int value to save the result according the question.
        List<Integer> result = new LinkedList<>();
        if(t.length()> s.length()) return result;
        
        //create a hashmap to save the Characters of the target substring.
        //(K, V) = (Character, Frequence of the Characters)
        Map<Character, Integer> map = new HashMap<>();
        for(char c : t.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //maintain a counter to check whether match the target string.
        int counter = map.size();//must be the map size, NOT the string size because the char may be duplicate.
        
        //Two Pointers: begin - left pointer of the window; end - right pointer of the window
        int begin = 0, end = 0;
        
        //the length of the substring which match the target string.
        int len = Integer.MAX_VALUE; 
        
        //loop at the begining of the source string
        while(end < s.length()){
            
            char c = s.charAt(end);//get a character
            
            if( map.containsKey(c) ){
                map.put(c, map.get(c)-1);// plus or minus one
                if(map.get(c) == 0) counter--;//modify the counter according the requirement(different condition).
            }
            end++;
            
            //increase begin pointer to make it invalid/valid again
            while(counter == 0 /* counter condition. different question may have different condition */){
                
                char tempc = s.charAt(begin);//***be careful here: choose the char at begin pointer, NOT the end pointer
                if(map.containsKey(tempc)){
                    map.put(tempc, map.get(tempc) + 1);//plus or minus one
                    if(map.get(tempc) > 0) counter++;//modify the counter according the requirement(different condition).
                }
                
                /* save / update(min/max) the result if find a target*/
                // result collections or result int value
                
                begin++;
            }
        }
        return result;
    }
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
```
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> map = new HashMap<>(); // char and the right most index of the char in the substring 
        
        int begin = 0, end = 0, maxLen = Integer.MIN_VALUE;
        while (end < s.length()) {
            if (map.keySet().size() <= 2) {
                map.put(s.charAt(end), end);
                end++;
            }
            
            if (map.keySet().size() > 2) {
                int leftMost = Integer.MAX_VALUE;
                for (char ch : map.keySet()) leftMost = Math.min(leftMost, map.get(ch));
                map.remove(s.charAt(leftMost));
                begin = leftMost + 1;
            }
            
            maxLen = Math.max(maxLen, end - begin);  // end is exclusive here
        }
        return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
    }
```


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

```
    // 1. Sliding Window (My Own solution using the Sliding Window Template, similar to Maximum Substring problem)
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        int start = 0, end = 0, maxStart = -1, maxLen = Integer.MIN_VALUE;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            if (map.size() <= k && end - start + 1 > maxLen) {
                maxStart = start;
                maxLen = end - start + 1;
            }
            
            while (start <= end && map.size() > k) {
                c = s.charAt(start);
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }
                start++;
            }
            
            end++;
        }
        
        return maxStart == -1 ? 0 : maxLen;
    }
```


[395. Longest Substring with At Least K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/)  



## Some problems cannot be solved by Sliding Window Template (the array contains negative value)

https://leetcode.com/problems/subarray-sum-equals-k/discuss/301242/General-summary-of-what-kind-of-problem-can-cannot-solved-by-Two-Pointers

#### 560. Subarray Sum Equals K
https://leetcode.com/problems/subarray-sum-equals-k/

```
    // 1. Brute Force for the culmulative sum array
    /*
    Time O(N^2)
    */
//     public int subarraySum(int[] nums, int k) {
//         if (nums == null || nums.length == 0) return 0;
        
//         int n = nums.length;
//         for (int i = 1; i < n; i++) nums[i] += nums[i - 1];
    
//         int res = 0;
//         for (int i = 0; i < n; i++) {
//             if (nums[i] == k) res++;
//             for (int j = i + 1; j < n; j++) {
//                 if (nums[i] + k == nums[j]) {
//                     res++;
//                 }
//             }
//         }
        
//         return res;
//     }
    
    // 2. HashMap to store culmulative sum frequency. So each time, we check if sum - k exists in the map.
    /*
    Time O(N)
    */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int res = 0, sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            res += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return res;
    }
```

### Reference
[Here is a 10-line template that can solve most 'substring' problems](https://discuss.leetcode.com/topic/30941/here-is-a-10-line-template-that-can-solve-most-substring-problems)  
[O(N)  template for Minimum Size Subarray Sum & Minimum Window Substring & Longest Substring Without Repeating Characters
](https://leetcode.com/problems/minimum-size-subarray-sum/discuss/59110/O(N)-template-for-Minimum-Size-Subarray-Sum-and-Minimum-Window-Substring-and-Longest-Substring-Without-Repeating-Characters)  
[Sliding Window algorithm template to solve all the Leetcode substring search problem](https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/49708/Sliding-Window-algorithm-template-to-solve-all-the-Leetcode-substring-search-problem.)  
[ZhiHu Sliding Window Template](https://zhuanlan.zhihu.com/p/390570255)
