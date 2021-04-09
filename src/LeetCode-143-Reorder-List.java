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
    /**
    https://leetcode.com/problems/reorder-list/discuss/45147/Java-solution-with-3-steps
    */
    public void reorderList(ListNode head) {
        ListNode p1 = head, p2 = head;
        
        // step 1: cut the list into two halves
        while (p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        
        
        // step 2: reverse second half
        reverse(p1, null);
        
        // step 3: rebuild the list
        p2 = p1.next;
        p1.next = null;
        merge(head, p2);
    }
    
    private void reverse(ListNode prev, ListNode next) {
        if (prev.next == null) return;
        
        ListNode last = prev.next;
        ListNode curr = prev.next.next;
        
        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            
            curr = last.next;
        }
    }
    
    private void merge(ListNode p1, ListNode p2) {
        while (p1 != null && p2 != null) {
            ListNode next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            
            p1 = p2.next;
            p2 = next;
        }
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
