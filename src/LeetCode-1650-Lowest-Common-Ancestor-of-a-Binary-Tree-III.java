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
//     public Node lowestCommonAncestor(Node p, Node q) {
//         List<Node> pPath = new ArrayList<>();
//         List<Node> qPath = new ArrayList<>();
        
//         while (p != null) {
//             pPath.add(0, p);
//             p = p.parent;
//         }
        
//         while (q != null) {
//             qPath.add(0, q);
//             q = q.parent;
//         }
        
//         int i = 0, j = 0;
//         Node prev = null;
//         while (i < pPath.size() && j < qPath.size()) {
//             if (pPath.get(i) == qPath.get(j)) {
//                 prev = pPath.get(i);
//             } else {
//                 break;
//             }
            
//             i++;
//             j++;
//         }
        
//         return prev;
//     }
    
    
    // 2. Find intersection in two list
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while (a != b) {
            a = a != null ? a.parent : q;
            b = b != null ? b.parent : p;
        }
        return a;
    }
}
