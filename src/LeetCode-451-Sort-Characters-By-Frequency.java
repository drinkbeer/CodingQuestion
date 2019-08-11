class Solution {
    // 1. Using Arrays.sort(), time O(NlogN), there is some problem with the sorting algorithms
//     public String frequencySort(String s) {
//         char[] temp = s.toCharArray();
//         Character[] chars = new Character[temp.length];
//         for (int i = 0; i < temp.length; i++) {
//             chars[i] = temp[i];
//         }

//         HashMap<Character, Integer> map = new HashMap<>();
//         for (char c : chars) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }

//         Arrays.sort(chars, (a, b) -> map.getOrDefault(a, 0) == map.getOrDefault(b, 0) ? Character.compare(a, b) : map.get(b) - map.get(a));

// //        Arrays.sort(chars, new Comparator<Character>() {
// //            @Override
// //            public int compare(Character a, Character b) {
// //                if (map.getOrDefault(a, 0) == map.getOrDefault(b, 0)) {
// //                    return a - b;
// //                } else {
// //                    return map.get(b) - map.get(a);
// //                }
// //            }
// //        });


//          StringBuilder sb = new StringBuilder();
//          for (Character c : chars) {
//              sb.append(c);
//          }
//          return sb.toString();
        
// //         PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.getOrDefault(a, 0) == map.getOrDefault(b, 0) ? a - b : map.get(b) - map.get(a));
// //         for (char c : map.keySet()) {
// //             pq.offer(c);
// //         }
        
// //         StringBuilder sb = new StringBuilder();
// //         while (!pq.isEmpty()) {
// //             sb.append(pq.poll());
// //         }
// //         return sb.toString();
//     }
    
    // 2. Using PriorityQueue
    /*
    Time: O(NlogM)  - N is number of chars in the string, M is 26
    
    Runtime: 49 ms, faster than 30.14% of Java online submissions for Sort Characters By Frequency.
    Memory Usage: 38.2 MB, less than 96.30% of Java online submissions for Sort Characters By Frequency.
    */
//     public String frequencySort(String s) {
//         char[] chars = s.toCharArray();
//         HashMap<Character, Integer> map = new HashMap<>();
//         for (char c : chars) {
//             map.put(c, map.getOrDefault(c, 0) + 1);
//         }

//         PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.getOrDefault(a, 0) == map.getOrDefault(b, 0) ? a - b : map.get(b) - map.get(a));
//         for (char c : map.keySet()) {
//             pq.offer(c);
//         }
        
//         StringBuilder sb = new StringBuilder();
//         while (!pq.isEmpty()) {
//             char c = pq.poll();
//             for (int i = 0; i < map.get(c); i++) {
//                 sb.append(c);
//             }
//         }
//         return sb.toString();
//     }
    
    // 3. Bucket Sort
    /*
    Time: O(N)
    
    Runtime: 14 ms, faster than 87.32% of Java online submissions for Sort Characters By Frequency.
    Memory Usage: 38.7 MB, less than 88.89% of Java online submissions for Sort Characters By Frequency.
    */
    public String frequencySort(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<Character>[] bucket = new List[s.length() + 1];
        for (char c : map.keySet()) {
            if (bucket[map.get(c)] == null) {
                bucket[map.get(c)] = new ArrayList<>();
            }
            bucket[map.get(c)].add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for (char c : bucket[i]) {
                for (int k = 0; k < i; k++) {
                    sb.append(c);
                }
            }
        }
        return sb.toString();
        
    }
}
