class Solution {
    // 1.
    /*
    https://leetcode.com/problems/remove-duplicate-letters/discuss/76766/Easy-to-understand-iterative-Java-solution
    
    The basic idea is to find out the smallest result letter by letter (one letter at a time). Here is the thinking process for input "cbacdcbc":

    find out the last appeared position for each letter;
    c - 7
    b - 6
    a - 2
    d - 4
    find out the smallest index from the map in step 1 (a - 2);
    the first letter in the final result must be the smallest letter from index 0 to index 2;
    repeat step 2 to 3 to find out remaining letters.
    the smallest letter from index 0 to index 2: a
    the smallest letter from index 3 to index 4: c
    the smallest letter from index 4 to index 4: d
    the smallest letter from index 5 to index 6: b
    so the result is "acdb"

    Notes:

    after one letter is determined in step 3, it need to be removed from the "last appeared position map", and the same letter should be ignored in the following steps
    in step 3, the beginning index of the search range should be the index of previous determined letter plus one
    */
//     public String removeDuplicateLetters(String s) {
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (int i = 0; i < s.length(); i++) {
//             map.put(s.charAt(i), i);
//         }
        
//         int begin = 0, end = findMinPos(map);
        
//         char[] res = new char[map.size()];
//         int k = 0;
//         while (k < res.length) {
//             char minChar = 'z' + 1;
//             for (int i = begin; i <= end; i++) {
//                 if (map.containsKey(s.charAt(i)) && s.charAt(i) < minChar) {
//                     minChar = s.charAt(i);
//                     begin = i + 1;
//                 }
//             }
//             res[k++] = minChar;
//             map.remove(minChar);
            
//             if (minChar == s.charAt(end)) end = findMinPos(map);
//         }
//         return new String(res);
//     }
    
//     private int findMinPos(HashMap<Character, Integer> map) {
//         int min = Integer.MAX_VALUE;
//         for (char key : map.keySet()) {
//             min = Math.min(min, map.get(key));
//         }
//         return min;
//     }
    
    /*
    https://leetcode.com/problems/remove-duplicate-letters/discuss/76769/Java-solution-using-Stack-with-comments
    */
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']--;
            if (visited[c - 'a']) continue;
            
            while (sb.length() > 0 && c < sb.charAt(sb.length() - 1) && count[sb.charAt(sb.length() - 1) - 'a'] != 0) {
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
            
            sb.append(c);
            visited[c - 'a'] = true;
        }
        
        return sb.toString();
    }
}
