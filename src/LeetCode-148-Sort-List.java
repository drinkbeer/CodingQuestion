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
    // 1. Merge Sort
    /**
    https://leetcode.com/problems/sort-list/discuss/46714/Java-merge-sort-solution
    */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        // step 1: cut the list to two halves
        ListNode prev = null, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        
        prev.next = null;
        
        // step 2: sort the two lists
        ListNode p1 = sortList(head);
        ListNode p2 = sortList(slow);
        
        // step 3: merge the two lists
        return merge(p1, p2);
    }
    
    private ListNode merge(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                prev.next = p1;
                p1 = p1.next;
            } else {
                prev.next = p2;
                p2 = p2.next;
            }
            prev = prev.next;
        }
        
        if (p1 != null) {
            prev.next = p1;
        }
        
        if (p2 != null) {
            prev.next = p2;
        }
        
        return dummy.next;
    }
}
