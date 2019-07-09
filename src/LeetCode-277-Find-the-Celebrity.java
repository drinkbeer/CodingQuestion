/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    
    // 1. Using Two Stack
    /*
    Time O(N^2)
    Space O(N)
    */
//     public int findCelebrity(int n) {
        
//         HashMap<Integer, Integer> indegree = new HashMap<>();
//         HashMap<Integer, Integer> outdegree = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (i == j) continue;
                
//                 if (knows(i, j)) {
//                     indegree.put(j, indegree.getOrDefault(j, 0) + 1);
//                     outdegree.put(i, outdegree.getOrDefault(i, 0) + 1);
//                 }
//             }
//         }
        
//         for (int i = 0; i < n; i++) {
//             int in = indegree.getOrDefault(i, 0);
//             int out = outdegree.getOrDefault(i, 0);
            
//             if (in == n - 1 && out == 0) return i;
//         }
        
//         return -1;
        
//     }
    
    /*
    https://leetcode.com/problems/find-the-celebrity/discuss/71227/Java-Solution.-Two-Pass
    
    O(N)
    */
    public int findCelebrity(int n) {
        
        int possibleCelebrity = 0;
        for (int i = 1; i < n; i++) {
            // if true, then possibleCelebrity cannot be the real celebrity because real celebrity should know nobody
            // if false, then i cannot be the celebrity because celebrity should be known by all the other ones
            if (knows(possibleCelebrity, i)) {
                possibleCelebrity = i;
            }
        }
        
        for (int i = 0; i < n; i++) {
            // this possibleCelebrity do know i
            // real celebrity should know nobody, so the possibleCelebrity is not the real celebrity
            if (i != possibleCelebrity && knows(possibleCelebrity, i)) return -1;
            
            // this possibleCelebrity are not known by i
            // real celebrity should be known by all the other ones, so the possibleCelebrity is not the real celebrity
            if (i != possibleCelebrity && !knows(i , possibleCelebrity)) return -1;
        }
        
        return possibleCelebrity;
    }
}
