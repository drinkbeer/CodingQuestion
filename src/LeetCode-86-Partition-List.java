/*
LeetCode: https://leetcode.com/problems/partition-list/
LintCode: http://www.lintcode.com/problem/partition-list/
JiuZhang: http://www.jiuzhang.com/solutions/partition-list/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-partition-list-java/

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
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;
        
        ListNode smallDummy = new ListNode(-1);
        ListNode small = smallDummy;
        ListNode bigDummy = new ListNode(-1);
        ListNode big = bigDummy;
        
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }
            head = head.next;
        }
        
        big.next = null;
        small.next = bigDummy.next;
        
        return smallDummy.next;
    }
}
