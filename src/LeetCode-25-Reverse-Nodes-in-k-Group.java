/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    // public ListNode reverseKGroup(ListNode head, int k) {
    //     if(head == null || head.next == null || k <= 1) return head;
        
    //     ListNode dummy = new ListNode(0);
    //     dummy.next = head;
    //     ListNode curr = dummy.next;
        
    //     while(curr.next != null) curr = reverseNextK(curr, k);
        
    //     return dummy.next;
    // }
    
    // private ListNode reverseNextK(ListNode head, int k){
    //     // check if there is enough k nodes
    //     ListNode temp = head;
    //     for(int i = 0; i < k; i++){
    //         if(temp.next == null) return temp;
    //         temp = temp.next;
    //     }
        
    //     ListNode prev = null;
    //     ListNode curr = head;

    //     for(int i = 0; i < k; i++){
    //         ListNode next = curr.next;
    //         curr.next = prev;
    //         prev = curr;
    //         curr = next;
    //     }
        
    //     head.next = curr;
        
    //     return curr;
    // }
    
    
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head ==null || k==1) return head;
        
        ListNode dummy = new ListNode (0);
        dummy.next = head;
        
        ListNode pre = dummy;
        
        int i = 0;
        while (head != null){
            i++;
            
            if (i % k == 0){
                pre = reverse(pre, head.next);
                head = pre.next;
            }
            else {
                head = head.next;
            }
        }
        
        return dummy.next;
    }
    /**
     * Reverse a link list between pre and next exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |   
     * pre        next
     * after call pre = reverse(pre, next)
     * 
     * 0->3->2->1->4->5->6
     *          |  |
     *          pre next
     * @param pre 
     * @param next
     * @return the reversed list's last node, which is the precedence of parameter next
     */
    public ListNode reverse(ListNode pre, ListNode next){
        ListNode last = pre.next;
        ListNode cur = last.next;
        
        while (cur != next){
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            
            cur = last.next;
        }
        
        return last;
    }
}