/**
 * Created by chen on 15/5/25.
 * Reverse a linked list.
 * <p/>
 * Example:
 * For linked list 1->2->3, the reversed linked list is 3->2->1
 * <p/>
 * Challenge:
 * Reverse it in-place and in one-pass
 */
public class LintCode_35_ReverseList {
    /**
     * @param head: The head of linked list.
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here

        ListNode prev = null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
