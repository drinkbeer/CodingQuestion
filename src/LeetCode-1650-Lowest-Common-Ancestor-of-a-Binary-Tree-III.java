/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
//     // 1. Two list to record the path
//     public Node lowestCommonAncestor(Node p, Node q) {
//         List<Node> pPath = new LinkedList<>();
//         List<Node> qPath = new LinkedList<>();
        
//         while (p != null) {
//             pPath.add(0, p);
//             p = p.parent;
//         }
        
//         while (q != null) {
//             qPath.add(0, q);
//             q = q.parent;
//         }
        
//         Node prev = null;
//         for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
//             if (pPath.get(i) == qPath.get(i)) {
//                 prev = pPath.get(i);
//             } else {
//                 break;
//             }
            
//         }
        
//         return prev;
//     }
    
    
    // 2. One set to record the path
//     public Node lowestCommonAncestor(Node p, Node q) {
//         Set<Node> nodes = new HashSet<>();
        
//         while (p != null) {
//             nodes.add(p);
//             p = p.parent;
//         }
        
//         while (q != null) {
//             if (nodes.contains(q)) return q;
//             q = q.parent;
//         }
        
//         return null;
//     }
    
    // 3. Find intersection of two path (LinkedList)
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while (a != b) {
            a = a.parent != null ? a.parent : q;
            b = b.parent != null ? b.parent : p;
        }
        
        return a;
    }
    

}
