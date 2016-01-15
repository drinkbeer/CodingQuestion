/*
LeetCode:  https://leetcode.com/problems/linked-list-cycle-ii/
LintCode:  http://www.lintcode.com/problem/linked-list-cycle-ii/
JiuZhang:  http://www.jiuzhang.com/solutions/linked-list-cycle-ii/
ProgramCreek:  not find

Analysis:  
1.Two Pointers

2.Two Pointers


*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // 1.Two Pointers
    // public ListNode detectCycle(ListNode head) {
    //     if(head == null || head.next == null) return null;
        
    //     ListNode slow = head, fast = head.next;
        
    //     while(fast != slow){
    //         if(fast == null || fast.next == null) return null;
    //         slow = slow.next;
    //         fast = fast.next.next;
    //     }
        
    //     //head != slow.next, as fast start from head.next
    //     while(head != slow.next){
    //         head = head.next;
    //         slow = slow.next;
    //     }
        
    //     return head;
    // }
    
    // 2.Two Pointers
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) return null;
        
        ListNode slow = head, fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        
        if(fast == null || fast.next == null) return null;
        
        while(head != slow){
            head = head.next;
            slow = slow.next;
        }
        
        return head;
    }
    
}