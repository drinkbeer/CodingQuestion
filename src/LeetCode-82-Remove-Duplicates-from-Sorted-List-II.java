/*
LeetCode: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
LintCode: http://www.lintcode.com/problem/remove-duplicates-from-sorted-list-ii/
JiuZhang: http://www.jiuzhang.com/solutions/remove-duplicates-from-sorted-list-ii/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-remove-duplicates-from-sorted-list-ii-java/

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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        
        while(curr != null){
            while(curr != null && prev.next.val == curr.val) curr = curr.next;      // get the first node whose val is not equal to prev.next.val
            if(prev.next.next == curr) prev = prev.next;    // if the first node is just prev.next's right one
            else prev.next = curr;      // if the first node is not the prev.next's right one
        }
        
        return dummy.next;
       
    }
}