import org.junit.Test;

/**
 * Created by chen on 15/5/25.
 * Sort a linked list in O(n log n) time using constant space complexity.
 * <p/>
 * Example:
 * Given 1-3->2->null, sort it to 1->2->3->null.
 */
public class LintCode_98_SortList_MergeSort {
    /**
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
     * using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode mid = findMid(head);

        // cut the list into two list
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        // sort left and right respectively
        left = sortList(left);
        right = sortList(right);

        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode l1, ListNode l2) {
        assert sorted(l1) == true;
        assert sorted(l2) == true;

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        if (l1 == null) {
            curr.next = l2;
        }
        if (l2 == null) {
            curr.next = l1;
        }

        return dummy.next;
    }

    private ListNode findMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head.next;  // 注意：是否加.next区别在于，不加的话，中点是奇数的中间一个，加的话，中点是偶数的中间的左边一个

        // 注意：这边一定要对fast和fast.next滤空
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private boolean sorted(ListNode head) {
        if (head == null) {
            return false;
        }

        while (head.next != null) {
            if (head.val > head.next.val) {
                return false;
            }
            head = head.next;
        }

        return true;
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

    @Test
    public void test() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(-1);
        n1.next = n2;
        printList(n1);
        printList(sortList(n1));
    }

    @Test
    public void test2() {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(-1);
        ListNode n3 = new ListNode(0);
        n1.next = n2;
        n2.next = n3;
        printList(n1);
        printList(sortList(n1));
    }
}
