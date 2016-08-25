/**
 * Created by chen on 15/5/26.
 * <p/>
 * Reference:
 * 1. http://willz.net/2013/11/29/sort-link-list/
 * "要求O(nlogn)和常数额外空间，我首先想到的是快排。实际上快排的普通版本是可以用在链表上了，取链表头作为pivot即可。如果是随机化版本，需
 * 要在整个链表中随机找一个节点作为pivot，那就略麻烦，效率也不高。而且快排是递归实现的，严格意义上说调用栈的空间也算是额外空间，并不满足题
 * 目的空间要求。"
 * 2. http://www.acmerblog.com/leetcode-sort-list-5982.html
 * "对链表进行排序，要求的时间复杂度为O(n log n)。nlogn的排序有快速排序、归并排序、堆排序。双向链表用快排比较适合，堆排序也可以用于链表，
 * 单向链表适合用归并排序"
 */
public class LintCode_98_SortList_QuickSort {
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

        // partition list into two parts
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        return dummy.next;

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
