/*
LeetCode:  https://leetcode.com/problems/linked-list-cycle/
LintCode:  http://www.lintcode.com/problem/linked-list-cycle/
JiuZhang:  http://www.jiuzhang.com/solutions/linked-list-cycle/
ProgramCreek:  http://www.programcreek.com/2012/12/leetcode-linked-list-cycle/

Analysis:  
Fast-slow node


slow goes 1 step at a time,and fast goes 2 steps at a time.
If we think slow is still,then fast goes 1 step at a time.
So,the problem is just like a Chasing problem.
There is a time when fast catches slower if there is cycle.

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
        if (head == null) return false;
        
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }
}
