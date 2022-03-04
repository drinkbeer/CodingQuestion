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
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
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
            if (head == null) return null;
            
            // Step 1. Copy each node, and link them together side by side  in a single-linked list.
            Node curr = head;
            while (curr != null) {
                Node next = curr.next;
                Node copy = new Node(curr.val);
                
                curr.next = copy;
                copy.next = next;
                
                curr = next;
            }
            
            // Step 2. assign random pointer to for the copied nodes.
            curr = head;
            while (curr != null) {
                if (curr.random != null) {
                    curr.next.random = curr.random.next;
                }
                
                curr = curr.next.next;
            }
            
            // Step 3. Restore the orignal list, and extract the copied list
            curr = head;
            Node copyDummy = new Node(-1);
            Node copyPre = copyDummy;
            while (curr != null) {
                // Restore the copied list
                Node copy = curr.next;
                copyPre.next = copy;
                copyPre = copy;
                
                // Restore the original list
                Node next = copy.next;
                curr.next = next;
                curr = next;
            }
            
            return copyDummy.next;
        }
        
        private void printNode(Node node) {
            StringBuilder sb = new StringBuilder();
            sb.append("val: ").append(node.val);
            
            String next = null;
            if (node.next != null) {
                next = "" + node.next.val;
            }
            sb.append(" next: ").append(next);
            
            String random = null;
            if (node.random != null) {
                random = "" + node.random.val;
            }
            sb.append("  random: ").append(random);
            
            System.out.println(sb.toString());
        }
        
        private void printList(Node head) {
            StringBuilder sb = new StringBuilder();
            
            while (head != null) {
                int val = -1;
                if (head.random != null) {
                    val = head.random.val;
                }
                sb.append("[").append(head.val).append(",").append(val).append("],");
                head = head.next;
            }
            
            sb.deleteCharAt(sb.length() - 1);
            System.out.println(sb.toString());
        }

    /*
    My solution doesn't work because if we copy from left to right, and restore from left to right, the random could point to a previous node whose random pointer been restored.
    */
//     public Node copyRandomList(Node head) {
//         if (head == null) return null;
        
//         Node copyHead = new Node(head.val);
//         copyHead.random = head.random;
//         head.random = copyHead;
        
//         Node curr = head.next;
        
//         while (curr != null) {
//             Node copy = new Node(curr.val);
//             copy.random = curr.random;
//             curr.random = copy;
            
//             curr = curr.next;
//         }
        
//         curr = head;
//         while (curr != null) {
//             Node copy = curr.random;
//             Node random = copy.random;
            
//             // Fix the curr node
//             curr.random = random;
            
//             // Fix the copy node
//             if (curr.next != null) {
//                 copy.next = curr.next.random;
//             } else {
//                 copy.next = null;
//             }
            
//             if (random != null) {
//                 copy.random = random.random;
//             }
            
//             curr = curr.next;
//         }
        
//         return copyHead;
//     }
    
    
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        
        // 1. Copy nodes, and chain the nodes (original and copy) in one single linked list.
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            Node next = curr.next;
            curr.next = copy;
            copy.next = next;
            
            curr = next;
        }
        
        // 2. Set the random pointer for copied nodes
        curr = head;
        while (curr != null) {
            Node copy = curr.next;
            Node random = curr.random;
            if (random != null) copy.random = random.next;
            
            curr = curr.next.next;
        }
        
        // 3. Rebuild the two list
        Node copyDummy = new Node(-1);
        Node prev = copyDummy;
        curr = head;
        
        while (curr != null) {
            // Fix the copied list
            Node copy = curr.next;
            prev.next = copy;
            prev = copy;
            
            // Fix the original list
            Node next = copy.next;
            curr.next = next;
            curr = next;
        }
        
        return copyDummy.next;
    }
}