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
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord.equals(endWord)) return 0;
        
        Queue<String> queue = new LinkedList<String>();
        
        queue.offer(beginWord);
        int count = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            count++;
            for(int i = 0; i < size; i++){
                String curr = queue.poll();
                
                for(char c = 'a'; c < 'z'; c++){
                    
                    for(int j = 0; j < curr.length(); j++){
                        if(c == curr.charAt(j)) continue;
                        String temp = replace(curr, j, c);
                        if(temp.equals(endWord)) return count;
                        
                        if(wordList.contains(temp)){
                            queue.offer(temp);
                            wordList.remove(temp);
                        }
                    }
                    
                }
            }
            
        }
        
        return 0;
    }
    
    private static String replace(String str, int i, char c){
        char[] chars = str.toCharArray();
        chars[i] = c;
        return new String(chars);
    }
}