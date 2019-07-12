/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    // 1.DFS
    /*
    https://leetcode.com/problems/nested-list-weight-sum-ii/discuss/83642/Java-Two-Pass-DFS-solution
    https://leetcode.com/problems/nested-list-weight-sum-ii/discuss/83677/The-question-needs-to-be-re-defined.
    
        a
      /    \
     b      c
              \
               d
    for this case, the wight of a is 3, the weight of b is 2. It's weired.
    
    */
//     public int depthSumInverse(List<NestedInteger> nestedList) {
//         int[] sum = new int[1];
//         int depth = getMaxDepth(nestedList);
//         traverse(nestedList, depth, sum);
//         return sum[0];
//     }
    
//     private void traverse(List<NestedInteger> list, int d, int[] sum) {
        
//         for (NestedInteger ni : list) {
//             if (!ni.isInteger()) {
//                 traverse(ni.getList(), d - 1, sum);
//             }
//         }
        
//         for (NestedInteger ni : list) {
//             if (ni.isInteger()) {
//                 sum[0] += d * ni.getInteger();
//             }
//         }
//     }
    
//     private int getMaxDepth(List<NestedInteger> list) {
//         if (list == null || list.size() == 0) return 0;
        
//         int max = 1;
//         for (NestedInteger ni : list) {
//             if (!ni.isInteger()) {
//                 max = Math.max(max, getMaxDepth(ni.getList()) + 1);
//             }
//         }
//         return max;
//     }
    
    // 2. BFS
    /*
    https://leetcode.com/problems/nested-list-weight-sum-ii/discuss/83655/JAVA-AC-BFS-solution
    */
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int prevSum = 0, totalSum = 0;
        Deque<NestedInteger> queue = new ArrayDeque();
        for (NestedInteger ni : nestedList) {
            queue.offerLast(ni);
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size(), levelSum = 0;
            for (int i = 0; i < size; i++) {
                NestedInteger current = queue.pollFirst();
                if (current.isInteger()) {
                    levelSum += current.getInteger();
                } else {
                    for (NestedInteger ni: current.getList()) {
                        queue.offerLast(ni);
                    }
                }
            }
            prevSum += levelSum;
            totalSum += prevSum;
        }
        return totalSum;
    }
}
