class Solution {
    // 1. HashTable
    /*
    Time O(N)
    */
//     public int firstUniqChar(String s) {
//         HashMap<Character, List<Integer>> map = new HashMap<>();
//         for (int i = 0; i < s.length(); i++) {
//             char ch = s.charAt(i);
//             map.computeIfAbsent(ch, k -> new ArrayList<>()).add(i);
//         }
        
//         int min = Integer.MAX_VALUE;
//         for (char ch : map.keySet()) {
//             if (map.get(ch).size() == 1) {
//                 min = Math.min(min, map.get(ch).get(0));
//             }
//         }
//         return min == Integer.MAX_VALUE ? -1 : min;
//     }
    
    // 2. Two Pass using frequency array
    public int firstUniqChar(String s) {
        int freq [] = new int[26];
        for(int i = 0; i < s.length(); i ++)
            freq [s.charAt(i) - 'a'] ++;
        for(int i = 0; i < s.length(); i ++)
            if(freq [s.charAt(i) - 'a'] == 1)
                return i;
        return -1;
    }
}
