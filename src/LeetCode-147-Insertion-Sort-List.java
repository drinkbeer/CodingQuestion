/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pp = dummy;
        while (pp.next != null) {
            ListNode curr = pp.next;
            
            ListNode prev = dummy;
            while(prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            if (prev.next != curr) {
                // inserr curr after prev
                pp.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            } else {
                pp = pp.next;
            }
        }
        
        return dummy.next;
    }
}
