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
