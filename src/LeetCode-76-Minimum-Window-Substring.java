/*
Substring problem template: https://leetcode.com/discuss/72701/here-10-line-template-that-can-solve-most-substring-problems

If T include duplicate characters? If yes, it will be more complex.
For example: S = "ADAOBEACODEBANC"    T = "AABC"

This problem has too many solutions

1. Two HashMap + Two Pointers
http://www.programcreek.com/2014/05/leetcode-minimum-window-substring-java/
One HashMap + Two Pointers (merge two hashmap into one)
https://leetcode.com/discuss/51381/java-solution-using-two-pointers-hashmap
Explanations about this problem
http://articles.leetcode.com/finding-minimum-window-in-s-which

2. int array + Two Pointers
    1) Use two pointers: start and end to represent a window
    2) Move end to find a valid window
    3) When a valid window is found, move start to find a smaller window

3. HashMap + Two Pointers

*/
class Solution {
    
    // 1.Two HashMap + Two Pointers
//     public String minWindow(String s, String t) {
//         if(s == null || t == null || s.length() < t.length()) return "";
        
//         // character counter for T
//         HashMap<Character, Integer> target = new HashMap<>();
//         for(int i = 0; i < t.length(); i++){
//             char ch = t.charAt(i);
//             target.put(ch, target.getOrDefault(ch, 0) + 1);
//         }
        
//         // character counter for S
//         HashMap<Character, Integer> map = new HashMap<>();
//         int left = 0;   //left pointer of min window
//         int count = 0;  // the total of mapped characters
//         String result = "";
//         int minLen = s.length() + 1;
        
//         for(int right = 0; right < s.length(); right++){
//             char ch = s.charAt(right);
            
//             // if(!target.containsKey(ch)) continue;
            
//             // update S's character counter map
//             if(target.containsKey(ch)){
//                 if(!map.containsKey(ch)){
//                     map.put(ch, 1);
//                     count++;
//                 }else{
//                     // must be carefully here!!! if map.get(ch)>=target.get(ch), we will not increase count
//                     if(map.get(ch) < target.get(ch)) count++;
//                     map.put(ch, map.get(ch) + 1);
//                 }
//                 // count++;
//             }
            
//             // By now, if count==t.length(), means we get a Window. The next step is to check if it is min window.
//             if(count == t.length()){
//                 char sc = s.charAt(left);
                
//                 // means current window not the window we need
//                 // i.e. S="AABBCC" T="ABB", Window is "AAB", count==3  ==>  window will become "AB", which not violate the requirement
                
//                 while(!map.containsKey(sc) || map.get(sc) > target.get(sc)){
//                     if(map.containsKey(sc) && map.get(sc) > target.get(sc)){
//                         map.put(sc, map.get(sc) - 1);
//                         // count--; //here we don't need count--, as those redundancy 'A' is not added when calculating count
//                     }
//                     // move left pointer of window to right
//                     left++;
//                     sc = s.charAt(left);
//                 }
                
//                 // means we need update min window information
//                 if(right - left + 1 < minLen){
//                     result = s.substring(left, right + 1);
//                     minLen = right - left + 1;
//                 }
//             }
            
//         }
//         return result;
//     }
    
    
    // 2. int array + Sliding Window
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
    
    // 2.HashMap + Two Pointers (Sliding Window)
//     public String minWindow(String s, String t) {
//         if (s == null || t == null) return "";
        
//         HashMap<Character, Integer> map = new HashMap<>();
//         int sLen = s.length(), tLen = t.length();
//         for (int i = 0; i < sLen; i++) {
//              map.put(s.charAt(i), 0);
//         }
//         for (int i = 0; i < tLen; i++) {
//             if (!map.containsKey(t.charAt(i))) return "";
//             map.put(t.charAt(i), map.get(t.charAt(i)) + 1);
//         }
        
//         int sStart = 0, sEnd = 0, minStart = -1, minLen = Integer.MAX_VALUE, count = t.length();
//         while (sEnd < sLen) {
//             char ch = s.charAt(sEnd);
//             if (map.get(ch) > 0) count--;
//             map.put(ch, map.get(ch) - 1);
            
//             // We get a window substring, but not sure if it's the minimum, move sStart to shrink the window
//             while (count == 0) {
//                 // update the result of min window
//                 if (minLen > sEnd - sStart + 1) {
//                     minStart = sStart;
//                     minLen = sEnd - minStart + 1;
//                 }
                
//                 char ch2 = s.charAt(sStart);
//                 map.put(ch2, map.get(ch2) + 1);
//                 if (map.get(ch2) > 0) count++;
                
//                 sStart++;
//             }
            
//             sEnd++;
//         }
        
//         return minStart == -1 ? "" : s.substring(minStart, minStart + minLen);
//     }
}
