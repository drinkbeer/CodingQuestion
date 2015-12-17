/*
LeetCode: https://leetcode.com/problems/rotate-list/
LintCode: http://www.lintcode.com/problem/rotate-list/
JiuZhang: http://www.jiuzhang.com/solutions/rotate-list/
ProgramCreek: http://www.programcreek.com/2014/02/leetcode-find-minimum-in-rotated-sorted-array/

Analysis: 
Classic list operation.
1.Go the the position to cut the place
2.Rotate at the place
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
    
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k < 1 || head.next == null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        int len = getLength(head);
        k = len - k % len;
        
        // get the place to cur the list
        while(k > 0 && curr != null){
            ListNode next = curr.next;
            prev = curr;
            curr = next;
            
            k--;
        }
        
        // rotate
        if(curr == null){
            return dummy.next;
        }
        
        ListNode newHead = curr;
        while(newHead.next != null){
            newHead = newHead.next;
        }
        
        prev.next = null;
        newHead.next = dummy.next;
        
        return curr;
        
    }
    
    private int getLength(ListNode head){
        ListNode curr = head;
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }
}