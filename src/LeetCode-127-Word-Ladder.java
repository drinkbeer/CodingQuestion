/*
LeetCode: https://leetcode.com/problems/word-ladder/
LintCode: http://www.lintcode.com/problem/word-ladder/
JiuZhang: http://www.jiuzhang.com/solutions/word-ladder/
ProgramCreek: http://www.programcreek.com/2012/12/leetcode-word-ladder/
Other: http://shanjiaxin.blogspot.com/2014/04/word-ladder-leetcode.html

Analysis: 
BFS. 
It's just like Binary Tree Level Order Traversal. Each level
*/
public class Solution {
    // 1. BFS. Time Limit Exceeded as the wordList is too large.
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         if (beginWord == null || endWord == null || beginWord.length() != endWord.length()) return 0;
//         if (!wordList.contains(endWord)) return 0;
        
//         Queue<String> queue = new LinkedList<>();
//         queue.add(beginWord);
        
//         int count = 1;
//         while(!queue.isEmpty()) {
//             int len = queue.size();
//             count++;
//             for (int i = 0; i < len; i++) {
//                 String str = queue.poll();
//                 for (int j = 0; j < str.length(); j++) {
//                     for (char ch = 'a'; ch <= 'z'; ch++) {
//                         if (ch == str.charAt(j)) continue; // skip duplicate case;
//                         String temp = replace(str, j, ch);
                        
//                         if (temp.equals(endWord)) {
//                             // find one ladder
//                             return count;
//                         } 
                        
//                         if (wordList.contains(temp)) {
//                             queue.add(temp);
//                             wordList.remove(temp);
//                         }
//                     }
//                 }
//             }
            
//         }
        
//         return 0;
//     }
    
//     private String replace(String str, int i, char ch) {
//         char[] arr = str.toCharArray();
//         arr[i] = ch;
//         return new String(arr);
//     }
    
    // 2,BFS
    /*
    This will pass the OJ because the remove operation in Set is much faster than List.
    
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 1;
        
        Set<String> dict = new HashSet<>(wordList); // O(N) space        
        Queue<String> queue = new LinkedList<String>();
        
        queue.add(beginWord);
        int level = 1;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            
            for(int l=0; l < levelSize; l++) { // check level by level to find optimal path
                char[] current = queue.poll().toCharArray();
            
                for(int i=0; i < current.length; i++) { // check a new word by changing each char
                    char temp = current[i];
                    for (char chr = 'a'; chr <= 'z'; chr++) {
                        current[i] = chr; 
                        String result = new String(current);
                    
                        if(dict.contains(result)) { 
                            if(result.equals(endWord)) return level+1;
                        
                            queue.add(result);
                            dict.remove(result);
                        }
                    }
                    current[i] = temp; // restore changed character
                }
            }
            level++;
        }
        
        return 0;
    }
    
    
    
    // 3. Using a graph to mark neighborhood relationship
    /*
    https://www.youtube.com/watch?v=mgICIVXu2sQ
    It will TLE. But the idea is great.
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashMap<String, List<String>> map = buildMap(beginWord, wordList);
        
        Queue<String> queue = new LinkedList<>();
        Set<String> doneSet = new HashSet<>();
        queue.add(beginWord);
        int level = 0; // initialize the level to be 1
        
        while(!queue.isEmpty()) {
            // process a new level
            int size = queue.size();
            level++;
            for (int l = 0; l < size; l++) {
                String str = queue.poll();
                
                if (endWord.equals(str)) {
                    return level;
                }
                
                for (String nxt : map.get(str)) {
                    queue.add(nxt);
                }
            }
        }
        
        return 0;
    }
    
    private HashMap<String, List<String>> buildMap(String beginWord, List<String> wordList) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : wordList) {
            map.put(str, new ArrayList<>());
            for (String nxt : wordList) {
                if (diff(str, nxt)) map.get(str).add(nxt);
            }
        }
        // special case: have to add beginWord to the graph
        if (!map.containsKey(beginWord)) {
            map.put(beginWord, new ArrayList<>());
            for (String nxt : wordList) {
                if (diff(beginWord, nxt)) map.get(beginWord).add(nxt);
            }
        }
        return map;
    }
    
    private boolean diff(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }
        return count == 1;
    }
}
