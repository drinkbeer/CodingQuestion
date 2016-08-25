import com.sun.corba.se.impl.naming.cosnaming.NamingUtils;
import org.junit.Test;

/**
 * Created by chen on 15/5/25.
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or
 * equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p/>
 * For example,
 * Given 1->4->3->2->5->2->null and x = 3,
 * return 1->2->2->4->3->5->null.
 */
public class LintCode_96_PartitionList {
    /**
     * @param head: The first node of linked list.
     * @param x:    an integer
     * @return: a ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (x == 0 || head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);   //tail is the last point of the left part
        dummy.next = head;
        head = dummy;

        ListNode prev = dummy;
        ListNode curr = prev.next;

        while (curr != null) {
            if (dummy.next == curr && curr.val < x) {
                dummy = dummy.next;
                prev = prev.next;
            } else if (dummy.next != curr && curr.val < x) {
                prev.next = curr.next;
                curr.next = dummy.next;
                dummy.next = curr;
                dummy = dummy.next;
            } else {
                prev = prev.next;
            }
            curr = prev.next;
        }

        return head.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    private void printList(ListNode head) {
        System.out.print(head.val);
        head = head.next;
        while (head != null) {
            System.out.print(" -> " + head.val);
            head = head.next;
        }
        System.out.println();
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode head = partition(l1, 3);
        printList(head);
    }
}
