/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // Insert curr node to current node
//     public ListNode insertionSortList(ListNode head) {
//         ListNode dummy = new ListNode(-1);
//         dummy.next = head;
        
//         ListNode prevCurr = dummy;
//         while (prevCurr != null && prevCurr.next != null) {
//             ListNode curr = prevCurr.next;
            
//             ListNode prev = dummy;
//             while(prev.next != null && prev.next.val < curr.val) {
//                 prev = prev.next;
//             }
            
            
//             if (prev.next != curr) {
//                 ListNode next = curr.next;
//                 curr.next = prev.next;
//                 prev.next = curr;
//                 prevCurr.next = next;
//             } else {
//                 prevCurr = prevCurr.next;
//             }
//         }
        
//         return dummy.next;
//     }
    
    // Simple and easy. Insert curr node to a new list
    public ListNode insertionSortList(ListNode head) {
		if(head == null) return head;
		
        ListNode dummy = new ListNode(-1);  // the pre-head node of the new list
        ListNode curr = head;               // the current node to insert to new list
        
        while (curr != null) {
            ListNode next = curr.next;
            
            // find the location to insert in new list: between prev and prev.next
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val <= curr.val) prev = prev.next;
            
            // insert curr to prev and prev.next
            curr.next = prev.next;
            prev.next = curr;
            
            curr = next;
        }
        
        return dummy.next;
	}
    
    
    private void printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        
        while (head != null) {
            sb.append(head.val).append(" ");
            head = head.next;
        }
        
        System.out.println(sb.toString());
    }
    
}
