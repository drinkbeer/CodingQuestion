/*
LeetCode: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
LintCode: http://www.lintcode.com/problem/remove-nth-node-from-end-of-list/
JiuZhang: http://www.jiuzhang.com/solutions/remove-nth-node-from-end-of-list/
ProgramCreek: http://www.programcreek.com/2014/05/leetcode-remove-nth-node-from-end-of-list-java/

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        
        ListNode fast = head, slow = head;
        
        for(int i = 0; i < n; i++){
            fast = fast.next;
        }
        
        if(fast == null) return slow.next;
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return head;
    }

    // public ListNode removeNthFromEnd(ListNode head, int n) {
    //     if(head == null) return head;
            
            // get length of list
    //     int len = 0;
    //     ListNode curr = head;
    //     while(curr != null){
    //         len++;
    //         curr = curr.next;
    //     }
        
            // if head is nth, remove head
    //     int start = len - n + 1;    // the pointer of the destination point
    //     if(start < 0) return null;
    //     if(start == 1) return head.next;
        
            // remove non-first node
    //     curr = head;
    //     int i = 0;
    //     while(curr != null){
    //         i++;
    //         // if i is the prev pointer of the destination point
    //         if(i == start - 1){
    //             curr.next = curr.next.next;
    //         }
    //         curr = curr.next;
    //     }
        
    //     return head;
        
    // }
}