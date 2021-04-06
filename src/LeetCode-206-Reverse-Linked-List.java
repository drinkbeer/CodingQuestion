/*
LeetCode: https://leetcode.com/problems/reverse-linked-list/
LintCode: 
JiuZhang: 
ProgramCreek: 

Analysis: 
1.Iterative

2.Recursive

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
    // 1.Iterative
    // public ListNode reverseList(ListNode head) {
    //     if(head == null || head.next == null) return head;
        
    //     ListNode dummy = new ListNode(0);
    //     dummy.next = null;
        
    //     while(head != null){
    //         ListNode next = head.next;
    //         head.next = dummy.next;
    //         dummy.next = head;
    //         head = next;
    //     }
        
    //     return dummy.next;
    // }
    
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        
        ListNode prev = null;
        ListNode curr = head;
        
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
    
    // 2.Recursive
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode next = head.next;
        head.next = null;
        
        ListNode newHead = reverseList(next);
        next.next = head;
        
        return newHead;
    }
    
}
