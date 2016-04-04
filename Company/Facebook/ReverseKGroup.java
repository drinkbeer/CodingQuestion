
// 1.
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k <= 1) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;

        while(curr != null) curr = reverseNextK(curr, k);

        return dummy.next;
    }

    private ListNode reverseNextK(ListNode head, int k){
        int temp = head;
        for(int i = 0; i < k; i++){
            if(temp == null) return head;
            temp = temp.next;
        }

        ListNode prev = null;
        ListNode curr = head;
        for(int i = 0; i < k; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = curr;
        return curr;
    }
}