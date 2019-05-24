/*
LeetCode: https://leetcode.com/problems/remove-linked-list-elements/
LintCode: http://www.lintcode.com/problem/remove-linked-list-elements/
JiuZhang: http://www.jiuzhang.com/solutions/remove-linked-list-elements/
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-remove-linked-list-elements-java/

Analysis: 

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        while(prev.next != null){
            if(prev.next.val == val){
                ListNode next = prev.next.next;
                prev.next.next = null;
                prev.next = next;
            }else{
                prev = prev.next;
            }
        }
        return dummy.next;
    }
    
    // 2. Using two pointers.
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        
        ListNode dummy =  new ListNode(-1);
        ListNode prev = dummy;
        prev.next = head;
        ListNode curr = head;
        
        while (curr != null) {
            if (curr.val == val) {
                curr = remove(prev, curr);
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
    
    private ListNode remove(ListNode prev, ListNode curr) {
        prev.next = curr.next;
        curr.next = null;
        return prev.next;
    }
}
