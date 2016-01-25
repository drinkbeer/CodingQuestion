/*
LeetCode: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
LintCode: http://www.lintcode.com/problem/remove-duplicates-from-sorted-list/
JiuZhang: http://www.jiuzhang.com/solutions/remove-duplicates-from-sorted-list/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-list/

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
        
        ListNode lo = head, hi = head.next;
        while(hi != null){
            if(lo.val == hi.val) lo.next = hi.next;
            else {
                lo = hi;
            }
            hi = hi.next;
        }
        return head;
    }
}