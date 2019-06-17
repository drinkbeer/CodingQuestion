/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
//     public Node copyRandomList(Node head) {
//         if(head == null) return head;
        
//         HashMap<Node, Node> map = new HashMap<Node, Node>();
//         Node newHead = new Node(head.val);
//         Node p = head, q = newHead;
//         map.put(head, newHead);
        
//         p = p.next;
//         // 1.Copy Nodes
//         while(p != null){
//             Node temp = new Node(p.label);
//             map.put(p, temp);
//             q.next = temp;
            
//             q = q.next;
//             p = p.next;
//         }
        
//         p = head;
//         q = newHead;
//         // 2.Copy Random Pointer of each node
//         while(p != null){
//             if(p.random != null){
//                 q.random = map.get(p.random);
//             }else{
//                 q.random = null;
//             }
//             p = p.next;
//             q = q.next;
//         }
        
//         return newHead;
//     }
    
    /*
    https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
    */
    public Node copyRandomList(Node head) {
        if(head == null) return head;
        
        // Step 1. Copy each node, and link them together side by side  in a single-linked list.
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            
            // copy the node, and chain curr -> copy -> next in a single-linked list
            Node copy = new Node(curr.val);
            curr.next = copy;
            copy.next = next;
            
            curr = next;
        }
        
        // Step 2. assign random pointer to for the copied nodes.
        curr = head;
        while(curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        // Step 3. Restore the orignal list, and extract the copied list
        curr = head;
        Node dummyCopy = new Node(-1);
        Node copy, copyCurr = dummyCopy;
        while(curr != null) {
            Node next = curr.next.next;
            
            // extract the copied list
            copy = curr.next;
            copyCurr.next = copy;
            copyCurr = copyCurr.next;
            
            // restore the original list
            curr.next = next;
            
            curr = curr.next;
        }
        
        return dummyCopy.next;
    }
}
