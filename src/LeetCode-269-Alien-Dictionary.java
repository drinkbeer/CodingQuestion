class Solution {
    // 1. BFS
//     public String alienOrder(String[] words) {
//         int[] indegree = new int[26];
//         HashMap<Character, List<Character>> map = buildGraph(words, indegree);
        
//         Queue<Character>queue = new LinkedList<>();
//         for (char c : map.keySet()) {
//             if (indegree[c - 'a'] == 0) {
//                 queue.offer(c);
//             }
//         }
        
//         List<Character> res = new ArrayList<>();
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 char ch = queue.poll();
//                 res.add(ch);
                
//                 if (!map.containsKey(ch)) continue;
                
//                 for (char c : map.get(ch)) {
//                     indegree[c - 'a']--;
//                     if (indegree[c - 'a'] == 0) {
//                         queue.offer(c);
//                     }
//                 }
//             }
//         }
//         return res.size() != map.size() ? "" : res.stream().map(String::valueOf).collect(Collectors.joining());
//     }
    
//     private HashMap<Character, List<Character>> buildGraph(String[] words, int[] indegree) {
//         HashMap<Character, List<Character>> map = new HashMap<>();
//         for (String w : words) {
//             for (char c : w.toCharArray()) {
//                 map.put(c, new ArrayList<>());
//             }
//         }
        
//         for (int i = 0; i < words.length - 1; i++) {
//             String s1 = words[i], s2 = words[i + 1];
//             int idx = 0;
//             while (idx < s1.length() && idx < s2.length()) {
//                 if (s1.charAt(idx) != s2.charAt(idx)) {
//                     char from = s1.charAt(idx);
//                     char to = s2.charAt(idx);
                    
//                     indegree[to - 'a']++;
//                     map.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
//                     break;
//                 }
//                 idx++;
//             }
//         }
        
//         return map;
//     }
    
    
    // 2. DFS
    public String alienOrder(String[] words) {
        HashMap<Character, List<Character>> map = buildGraph(words);
        int[] visited = new int[26];
        
        List<Character> res = new ArrayList<>();
        for (char from : map.keySet()) {
            if (visited[from - 'a'] == 0 && hasCycle(map, visited, from, res)) {
                return "";
            }
        }
        // System.out.println(res.toString());
        return res.size() != map.size() ? "" : res.stream().map(String::valueOf).collect(Collectors.joining());
    }
    
    private boolean hasCycle(HashMap<Character, List<Character>> map, int[] visited, char from, List<Character> res) {
        if (visited[from - 'a'] == 1) return true;
        // if (visited[from - 'a'] == -1) return false;
        visited[from - 'a'] = 1;
        
        if (map.containsKey(from)) {
            for (char to : map.get(from)) {
                if (visited[to - 'a'] == 1) return true;
                if (visited[to - 'a'] == 0 && hasCycle(map, visited, to, res)) return true;
            }
        }
        
        res.add(0, from);
        visited[from - 'a'] = -1;   // finished visiting
        return false;
    }
    
    private HashMap<Character, List<Character>> buildGraph(String[] words) {
        HashMap<Character, List<Character>> map = new HashMap<>();
        for (String w : words) {
            for (char c : w.toCharArray()) {
                map.put(c, new ArrayList<>());
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i], s2 = words[i + 1];
            int idx = 0;
            while (idx < s1.length() && idx < s2.length()) {
                if (s1.charAt(idx) != s2.charAt(idx)) {
                    char from = s1.charAt(idx);
                    char to = s2.charAt(idx);
                    
                    map.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
                    break;
                }
                idx++;
            }
        }
        
        return map;
    }
    
    
//     private final int N = 26;
//     public String alienOrder(String[] words) {
//         boolean[][] adj = new boolean[N][N];
//         int[] visited = new int[N];
//         buildGraph(words, adj, visited);

//         StringBuilder sb = new StringBuilder();
//         for(int i = 0; i < N; i++) {
//             if(visited[i] == 0) {                 // unvisited
//                 if(!dfs(adj, visited, sb, i)) return "";
//             }
//         }
//         return sb.reverse().toString();
//     }

//     public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
//         visited[i] = 1;                            // 1 = visiting
//         for(int j = 0; j < N; j++) {
//             if(adj[i][j]) {                        // connected
//                 if(visited[j] == 1) return false;  // 1 => 1, cycle   
//                 if(visited[j] == 0) {              // 0 = unvisited
//                     if(!dfs(adj, visited, sb, j)) return false;
//                 }
//             }
//         }
//         visited[i] = 2;                           // 2 = visited
//         sb.append((char) (i + 'a'));
//         return true;
//     }

//     public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
//         Arrays.fill(visited, -1);                 // -1 = not even existed
//         for(int i = 0; i < words.length; i++) {
//             for(char c : words[i].toCharArray()) visited[c - 'a'] = 0;
//             if(i > 0) {
//                 String w1 = words[i - 1], w2 = words[i];
//                 int len = Math.min(w1.length(), w2.length());
//                 for(int j = 0; j < len; j++) {
//                     char c1 = w1.charAt(j), c2 = w2.charAt(j);
//                     if(c1 != c2) {
//                         adj[c1 - 'a'][c2 - 'a'] = true;
//                         break;
//                     }
//                 }
//             }
//         }
//     }
}
