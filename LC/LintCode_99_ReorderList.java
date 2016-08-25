import org.junit.Test;

import java.util.List;

/**
 * Created by chen on 15/5/28.
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * <p/>
 * Example:
 * Given 1->2->3->4->null, reorder it to 1->4->2->3->null.
 * Solution:
 * 1. get mid point and split list into 2 chains
 * 2.
 */
public class LintCode_99_ReorderList {
    /**
     * @param head: The head of linked list.
     * @return: void
     */
    public void reorderList(ListNode head) {
        // write your code here
        if(head == null || head.next == null){
            return;
        }

        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        // split the list into two chains
        mid.next = null;

        // reverse the right chain
        right = reverse(right);

        while (left != null && right != null) {
            ListNode lnext = left.next;
            ListNode rnext = right.next;
            left.next = right;
            right.next = lnext;
            left = lnext;
            right = rnext;
        }

        printList(head);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    /**
     * odd number: mid is the just mid one
     * even number: mid is the left one of mid two points
     *
     * @param head
     * @return
     */
    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private void printList(ListNode head) {
        if (head == null) {
            return;
        }

        System.out.print(head.val);

        while (head.next != null) {
            head = head.next;
            System.out.print(" -> " + head.val);
        }
        System.out.println();
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        printList(n1);
        reorderList(n1);
        printList(n1);
    }

}
