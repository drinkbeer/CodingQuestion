/**
 * Created by chen on 15/5/24.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p/>
 * Example:
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 */
public class LintCode_112_RemoveDuplicatesList {
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        ListNode curr = prev.next;

        while (curr != null) {
            if (curr.val != prev.val) {
                prev.next = curr;
                prev = prev.next;
            }
            curr = curr.next;
        }

        prev.next = null;
        return head;
    }

    /**
     * another accepted answer
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curr = head;

        while (curr.next != null) {
            if (curr.val != curr.next.val) {
                curr = curr.next;
            } else {
                curr.next = curr.next.next;
            }
        }

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
