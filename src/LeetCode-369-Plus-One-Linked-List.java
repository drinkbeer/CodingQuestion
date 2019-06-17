/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 1. Reverse List, and plus one and reverse back
//     public ListNode plusOne(ListNode head) {
//         if (head == null) return head;
        
//         ListNode curr = reverse(head);
//         printList(curr);
//         ListNode dummy = new ListNode(-1);
//         ListNode prev = dummy;
//         int carry = 1;
//         while(curr != null) {
//             prev.next = new ListNode((curr.val + carry) % 10);
//             carry = (curr.val + carry) / 10;
            
//             curr = curr.next;
//             prev = prev.next;
//         }
//         if (carry != 0) {
//             prev.next = new ListNode(carry);
//         }
        
//         return reverse(dummy.next);
//     }
    
//     private ListNode reverse(ListNode head) {
//         ListNode dummy = new ListNode(-1);
//         dummy.next = head;
//         ListNode prev = head, curr = head.next;
        
//         while (curr != null) {
//             prev.next = curr.next;
//             curr.next = dummy.next;
//             dummy.next = curr;
            
//             curr = prev.next;
//         }
        
//         return dummy.next;
//     }
    
//     public void printList(ListNode head) {
//         String str = head.val + "";
//         head = head.next;
//         while (head != null) {
//             str += " -> " + head.val;
//             head = head.next;
//         }
        
//         System.out.println(str);
//     }
    
    // 2.Two Pointers
    /*
    https://leetcode.com/problems/plus-one-linked-list/discuss/84125/Iterative-Two-Pointers-with-dummy-node-Java-O(n)-time-O(1)-space
    */
//     public ListNode plusOne(ListNode head) {
//         if (head == null) return head;
        
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         ListNode lastNonNineNode = dummy;
//         ListNode lastNode = dummy;
        
//         while (lastNode.next != null) {
//             lastNode = lastNode.next;
//             if (lastNode.val != 9) lastNonNineNode = lastNode;
//         }
        
//         if (lastNode.val != 9) {
//             lastNode.val++;
//         } else {
//             lastNonNineNode.val++;
            
//             while(lastNonNineNode.next != null) {
//                 lastNonNineNode = lastNonNineNode.next;
//                 lastNonNineNode.val = 0;
//             }
//         }
        
//         return dummy.val == 0 ? dummy.next : dummy;
//     }
    
    
    // 3.DFS
    /*
    https://leetcode.com/problems/plus-one-linked-list/discuss/84130/Java-recursive-solution
    */
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        helper(dummy);
        return dummy.val == 0 ? head : dummy;
    }

    private int helper(ListNode node){
        if(node == null) return 1;
        node.val += helper(node.next);
        if(node.val <= 9) return 0;
        node.val %= 10;
        return 1;
    }
    
}
