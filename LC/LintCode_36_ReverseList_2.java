/**
 * Created by chen on 15/5/25.
 * Reverse a linked list from position m to n.
 * <p/>
 * Example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 * <p/>
 * Note:
 * Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * <p/>
 * Challenge:
 * Reverse it in-place and in one-pass
 */
public class LintCode_36_ReverseList_2 {
    /**
     * @param ListNode head is the head of the linked list
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code
        if (m >= n || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 1; i < m; i++) {
            // prev = point m - 1
            prev = prev.next;
        }
        ListNode curr = prev.next;
        ListNode tail = prev;  //mark as the tail of m-n chain

        for (int i = m; i <= n; i++) {
            if(curr == null){
                break;
            }

            ListNode temp = curr.next;
            curr.next = prev;
            // reset the condition before entering next loop
            prev = curr;
            curr = temp;
        }

        tail.next.next = curr;  //connect the new head of m-n chain to the 3rd part
        tail.next = prev;   //connect the first part to the m-n chain

        return dummy.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
