class Solution {
    
    // 1. Build Graph + DFS (Time Limit Exceeded)
    /*
    Video: https://www.youtube.com/watch?v=lmypbtgdpuQ
    
    Build a neighborship Graph, and use DFS to search in the Graph.
    
    Building Graph: Time O(N^2), Space O(L*K), L is the size of wordList, K is the avg neighbors of each node in wordList
    
    DFS: Time O(N), Space O
    
    One thing to mention is that when using DFS to visit a double-direction graph, we must have a Set to record the visited nodes, otherwise it will have deadlock:
    
    A -> B -> A -> B ....
    
    */
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         List<List<String>> result = new ArrayList<List<String>>();
//         if (!wordList.contains(endWord)) return result;
        
//         // Step 1: build a Graph
//         HashMap<String, List<String>> map = buildMap(beginWord, wordList);
        
//         // Step 2: using DFS to visit the Graph
//         Set<String> usedString = new HashSet<>();
//         usedString.add(beginWord);
//         List<String> currList = new ArrayList<>();
//         currList.add(beginWord);
        
//         dfs(endWord, usedString, map, result, currList);
//         return result;
//     }
    
//     private void dfs(String endWord, Set<String> usedString, HashMap<String, List<String>> map, List<List<String>> result, List<String> currList) {
//         if (result.size() != 0 && currList.size() > result.get(0).size()) return;  // if the curr list is already larger than the existing list size in result
        
//         String currStr = currList.get(currList.size() - 1);
//         if (currStr.equals(endWord)) {
//             // means we find a List, but it may or may not be the shortest list
//             if (result.size() == 0 || currList.size() == result.get(0).size()) {
//                 result.add(new ArrayList<>(currList));
//             } else if (currList.size() < result.get(0).size()) {
//                 result.clear();
//                 result.add(new ArrayList<>(currList));
//             }
//         } else {
//             // means currList is not the target list
//             for (String str : map.get(currStr)) {
//                 if (usedString.contains(str)) continue;
//                 usedString.add(str);
//                 currList.add(str);
//                 dfs(endWord, usedString, map, result, currList);
//                 usedString.remove(str);
//                 currList.remove(currList.size() - 1);
//             }
//         }
//     }
    
//     // buid a graph
//     private HashMap<String, List<String>> buildMap(String beginWord, List<String> wordList) {
//         HashMap<String, List<String>> map = new HashMap<>();
//         for (String s1 : wordList) {
//             List<String> list = new ArrayList<>();
//             for (String s2 : wordList) {
//                 if (diff(s1, s2)) list.add(s2);
//             }
//             map.put(s1, list);
//         }
        
//         // build the beginWord in the graph
//         if (!map.containsKey(beginWord)) {
//             List<String> list = new ArrayList<>();
//             for (String s2 : wordList) {
//                 if (diff(beginWord, s2)) list.add(s2);
//             }
//             map.put(beginWord, list);
//         }
        
//         return map;
//     }
    
//     // if the two strings has only 1 diff
//     private boolean diff(String s1, String s2) {
//         if (s1.length() != s2.length()) return false;
//         int count = 0;
//         for (int i = 0; i < s1.length(); i++) {
//             if (s1.charAt(i) != s2.charAt(i)) count++;
//         }
//         return count == 1;
//     }
    
    // 2. Build Graph + BFS + DFS
    /*
    Video: https://www.youtube.com/watch?v=lmypbtgdpuQ
    
    Step 1: Build a neighborship Graph, and use DFS to search in the Graph.
    
    Building Graph: Time O(N^2), Space O(L*K), L is the size of wordList, K is the avg neighbors of each node in wordList
    
    DFS: Time O(N), Space O
    
    Step 2: Using a BFS to get the min length of the result list.
    
    
    Step 3: Using DFS to get the result.
    
    One thing to mention is that when using DFS to visit a double-direction graph, we must have a Set to record the visited nodes, otherwise it will have deadlock:
    
    A -> B -> A -> B ....
    
    Optimization compared to first solution is:
    
    1. Using BFS to get the deepMap and minLen of path
    2. In DFS, ignore the currList that > minLen
    3. In DFS, ignore the currList that has first element that "currDeep + deepMap.get(str) > minLen"
    4. In DFS, search from endWord to beginWord
    5. When building the Graph, convert the WordList to WordSet, as Set.contains() is much faster than List.contains()
    
    */
//     public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//         List<List<String>> result = new ArrayList<List<String>>();
//         if (!wordList.contains(endWord)) return result;
//         if (!wordList.contains(beginWord)) wordList.add(beginWord);  // adding the beginWord to wordList, which will make the building graph easier
        
//         // Step 1: build Graph
//         HashMap<String, List<String>> map = buildMap(wordList);
//         // System.out.println("Graph: " + map.toString());
        
//         // Step 2: bfs
//         HashMap<String, Integer> deepMap = new HashMap<>();
//         int minLen = bsf(map, deepMap, beginWord, endWord);
//         // System.out.println("minLen: " + minLen);
//         // System.out.println("deepMap: " + deepMap.toString());
        
//         // Step 3: dfs
//         Set<String> usedString = new HashSet<>();
//         usedString.add(endWord);
//         List<String> currList = new ArrayList<>();
//         currList.add(endWord);
//         dfs(beginWord, usedString, map, deepMap, minLen, 1, result, currList);
        
//         return result;
//     }
    
//     private void dfs(String beginWord, Set<String> usedString, HashMap<String, List<String>> map, HashMap<String, Integer> deepMap, int minLen, int currDeep, List<List<String>> result, List<String> currList) {
//         if (currList.size() > minLen) return;
        
//         // System.out.println("currList: " + currList.toString() + "  currList size: " + currList.size() + "  curr deep: " + currDeep);
//         String currStr = currList.get(0);
//         if (currList.size() == minLen) {
//             // System.out.println("currStr: " + currStr + " beginWord: " + beginWord);
//             if (currStr.equals(beginWord)) {
//                 // means we get one list whose size is minLen
//                 result.add(new ArrayList<>(currList));
//             }
//         } else {
//             for (String str : map.get(currStr)) {
                
//                 if (usedString.contains(str)) continue;
//                 if (!deepMap.containsKey(str)) continue;
//                 if (currDeep + deepMap.get(str) > minLen) continue; // ensure we are in the path that is in deepMap
//                 // System.out.println("str: " + str);
                
//                 // if (!usedString.contains(str) && deepMap.containsKey(str) && currDeep + deepMap.get(str) <= minLen) {
//                     currList.add(0, str);
//                     usedString.add(str);
//                     dfs(beginWord, usedString, map, deepMap, minLen, currDeep + 1, result, currList);
//                     currList.remove(0);
//                     usedString.remove(str);
//                 // }
//             }
//         }
//     }
    
//     private int bsf(HashMap<String, List<String>> map, HashMap<String, Integer> deepMap, String beginWord, String endWord) {
//         Queue<String> queue = new LinkedList<>();
//         queue.add(beginWord);
//         int level = 1;
//         deepMap.put(beginWord, level - 1);
        
//         while(!queue.isEmpty()) {
//             int size = queue.size();
            
//             for (int i = 0; i < size; i++) {
//                 String currStr = queue.poll();
//                 if (currStr.equals(endWord)) return level;
                
//                 for (String str : map.get(currStr)) {
//                     // in the deepMap, we make the beginWord as 0, as in the DFS, we want to check deep + currLevel <= minLen
//                     // we are also using deepMap to record those visited map in BFS. If visited, we skip it.
//                     if (!deepMap.containsKey(str)) {
//                         deepMap.put(str, level);
//                         queue.add(str);
//                     }
//                 }
//             }
            
//             level++;
//         }
        
//         return -1;
//     }
    
//     // buid a graph
//     private HashMap<String, List<String>> buildMap(List<String> wordList) {
//         // The tricky park here is. the time complexity of List.contains() is O(N), but Set.contains() is O(1), so we 
//         // want to convert the List to Set.
//         Set<String> wordSet = new HashSet<>();
//         for (String str : wordList) wordSet.add(str);
        
//         HashMap<String, List<String>> map = new HashMap<>();
//         for (String s1 : wordList) {
//             map.put(s1, new ArrayList<>());
//             diff(s1, wordSet, map);
//         }
//         return map;
//     }
    
//     private void diff(String str, Set<String> wordSet, HashMap<String, List<String>> map) {
//         char[] arr = str.toCharArray();
//         for (int i = 0; i < arr.length; i++) {
//             char temp = arr[i];
//             for (char ch = 'a'; ch <= 'z'; ch++) {
//                 if (ch == temp) continue; // skip duplicates
//                 arr[i] = ch;
//                 String newStr = new String(arr);
//                 if (wordSet.contains(newStr)) {
//                     map.get(str).add(newStr);
//                 }
//                 arr[i] = temp;
//             }
//         }
//     }
    
    // 3.Two end BFS
    /*
    https://leetcode.com/problems/word-ladder-ii/discuss/40477/Super-fast-Java-solution-(two-end-BFS)
    
    Runtime: 19 ms, faster than 93.54% of Java online submissions for Word Ladder II.

    */
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (!wordList.contains(end)) return res;

        Set<String> dict = new HashSet<>();
        dict.add(start);
        for (String str : wordList) dict.add(str);

        // hash set for both ends
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();

        // initial words in both ends
        set1.add(start);
        set2.add(end);

        // we use a map to help construct the final result
        Map<String, List<String>> map = new HashMap<String, List<String>>();

        // build the map
        helper(dict, set1, set2, map, false);


        List<String> sol = new ArrayList<String>(Arrays.asList(start));

        // recursively build the final result
        generateList(start, end, map, sol, res);

        return res;
    }

    private boolean helper(Set<String> dict, Set<String> set1, Set<String> set2, Map<String, List<String>> map, boolean flip) {
        if (set1.isEmpty()) {
          return false;
        }

        if (set1.size() > set2.size()) {
          return helper(dict, set2, set1, map, !flip);
        }

        // remove words on current both ends from the dict
        dict.removeAll(set1);
        dict.removeAll(set2);

        // as we only need the shortest paths
        // we use a boolean value help early termination
        boolean done = false;

        // set for the next level
        Set<String> set = new HashSet<String>();

        // for each string in end 1
        for (String str : set1) {
          for (int i = 0; i < str.length(); i++) {
            char[] chars = str.toCharArray();

            // change one character for every position
            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;

                String word = new String(chars);

                // make sure we construct the tree in the correct direction
                String key = flip ? word : str;
                String val = flip ? str : word;

                List<String> list = map.containsKey(key) ? map.get(key) : new ArrayList<String>();

                if (set2.contains(word)) {
                    done = true;

                    list.add(val);
                    map.put(key, list);
                }

                if (!done && dict.contains(word)) {
                    set.add(word);

                    list.add(val);
                    map.put(key, list);
                }
            }
          }
        }

        // early terminate if done is true
        return done || helper(dict, set2, set, map, !flip);
    }

    private void generateList(String start, String end, Map<String, List<String>> map, List<String> sol, List<List<String>> res) {
        if (start.equals(end)) {
          res.add(new ArrayList<String>(sol));
          return;
        }

        // need this check in case the diff between start and end happens to be one
        // e.g "a", "c", {"a", "b", "c"}
        if (!map.containsKey(start)) {
          return;
        }

        for (String word : map.get(start)) {
          sol.add(word);
          generateList(word, end, map, sol, res);
          sol.remove(sol.size() - 1);
        }
    }
    
}
