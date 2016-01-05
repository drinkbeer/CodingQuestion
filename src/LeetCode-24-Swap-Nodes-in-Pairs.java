/*
LeetCode: https://leetcode.com/problems/swap-nodes-in-pairs/
LintCode: http://www.lintcode.com/problem/swap-nodes-in-pairs/
JiuZhang: http://www.jiuzhang.com/solutions/swap-nodes-in-pairs/
ProgramCreek: http://www.programcreek.com/2014/04/leetcode-swap-nodes-in-pairs-java/

Analysis: 
Two pointers
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        
        while(pre.next != null && pre.next.next != null){
            ListNode p1 = pre.next;
            ListNode p2 = pre.next.next;
            
            // Three stops:
            // 1.change p1's next node
            p1.next = p2.next;
            
            // 2.change p2's next node
            p2.next = p1;
            
            // 3.change pre node's next node
            pre.next = p2;
            
            // 4.change the pre node to next round's pre node
            pre = p1;
        }
        
        return dummy.next;
    }
}