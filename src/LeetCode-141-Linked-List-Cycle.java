/*
LeetCode:  https://leetcode.com/problems/linked-list-cycle/
LintCode:  http://www.lintcode.com/problem/linked-list-cycle/
JiuZhang:  http://www.jiuzhang.com/solutions/linked-list-cycle/
ProgramCreek:  http://www.programcreek.com/2012/12/leetcode-linked-list-cycle/

Analysis:  
Fast-slow node


Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
Memory Usage: 36.8 MB, less than 99.99% of Java online submissions for Linked List Cycle.

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
    
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        
        ListNode slow = head, fast = head.next;
        while (slow != null && fast != null) {
            if (slow.val == fast.val) return true;
            if (slow.next == null || fast.next == null || fast.next.next == null) return false;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }
}
