class Solution {
    // 1. My Solution (Wrong Answer because the order in the indexes array is not guaranteed)
//     public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
//         int idx = 0;
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < S.length();) {
//             if (idx < indexes.length && i == indexes[idx]) {
//                 // we started to check a new match
//                 if (isMatched(S, i, sources[idx])) {
//                     // we found a new match
//                     sb.append(targets[idx]);
//                     i += sources[idx].length();
//                 }
//                 idx++;
//             } else {
//                 sb.append(S.charAt(i));
//                 i++;
//             }
//         }
        
//         return sb.toString();
//     }
    
//     private boolean isMatched(String s, int idx, String target) {
//         for (int i = 0; i < target.length(); i++) {
//             if (s.charAt(idx + i) != target.charAt(i)) return false;
//         }
//         return true;
//     }
    
    // 1. String Append (Best)
    /*
    https://leetcode.com/problems/find-and-replace-in-string/discuss/134758/Java-O(n)-solution
    Time O(N)
    */
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        HashMap<Integer, Integer> map = new HashMap<>();    // store <idx_in_S, idx_in_indexes_arr> pair
        for (int i = 0; i < indexes.length; i++) {
            if (isMatched(S, indexes[i], sources[i])) {
                map.put(indexes[i], i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length();) {
            if (map.containsKey(i)) {
                sb.append(targets[map.get(i)]);
                i += sources[map.get(i)].length();
            } else {
                sb.append(S.charAt(i));
                i++;
            }
        }
        
        return sb.toString();
    }
   
    // We found use Java String API str.startsWith(targetStr, idx_in_str) to replace this method
    private boolean isMatched(String s, int idx, String target) {
        for (int i = 0; i < target.length(); i++) {
            if (s.charAt(idx + i) != target.charAt(i)) return false;
        }
        return true;
    }
}
