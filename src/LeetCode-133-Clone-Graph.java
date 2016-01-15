/*
LeetCode:  https://leetcode.com/problems/clone-graph/
LintCode:  http://www.lintcode.com/problem/clone-graph/
JiuZhang:  http://www.jiuzhang.com/solutions/clone-graph/
ProgramCreek:  http://www.programcreek.com/2012/12/leetcode-clone-graph-java/
                Other: http://www.cnblogs.com/springfor/p/3874591.html

Analysis:  
Queue is used to BFS the original Graph.
HashMap is used to navigate the relationship between original Graph and new Graph.
*/
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return node;
        
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        map.put(node, newHead);
        queue.offer(node);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode curr = queue.poll();
            
            for(UndirectedGraphNode n : curr.neighbors){
                if(!map.containsKey(n)){
                    //if n is not visited
                    UndirectedGraphNode newCopy = new UndirectedGraphNode(n.label);
                    map.put(n, newCopy);
                    map.get(curr).neighbors.add(newCopy);
                    queue.offer(n);
                }else{
                    map.get(curr).neighbors.add(map.get(n));
                }
            }
        }
        
        return newHead;
    }
}