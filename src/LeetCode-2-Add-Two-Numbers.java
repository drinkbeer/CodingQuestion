/*
LeetCode: https://leetcode.com/problems/add-two-numbers/
LintCode: http://www.lintcode.com/problem/add-two-numbers/
JiuZhang: http://www.jiuzhang.com/solutions/add-two-numbers/
ProgramCreek: http://www.programcreek.com/2012/12/add-two-numbers/

Analysis: 
Building a new list to store the result. Using a dummy node to record the pre-node of head in new list. Curr node to record the current pos.
Be careful: the last add of last two node may generate a '1', which need a new node.

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
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         if(l1 == null || l2 == null) return null;
        
//         ListNode dummy = new ListNode(0);
//         ListNode curr = dummy;
//         ListNode p1 = l1, p2 = l2;
        
//         int carry = 0;
        
//         while(p1 != null || p2 != null){
            
//             if(p1 != null){
//                 carry += p1.val;
//                 p1 = p1.next;
//             }
            
//             if(p2 != null){
//                 carry += p2.val;
//                 p2 = p2.next;
//             }
            
//             curr.next = new ListNode(carry % 10);
//             carry = carry / 10;
//             curr = curr.next;
//         }
        
//         if(carry == 1){
//             curr.next = new ListNode(1);
//             curr = curr.next;
//         }
        
//         return dummy.next;
//     }
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        
        while(l1 != null && l2 != null) {
            int temp = carry;
            carry = (l1.val + l2.val + temp) / 10;
            ListNode curr = new ListNode((l1.val + l2.val + temp) % 10);
            p.next = curr;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while (l1 != null) {
            int temp = carry;
            carry = (l1.val + temp) / 10;
            ListNode curr = new ListNode((l1.val + temp) % 10);
            p.next = curr;
            p = p.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            int temp = carry;
            carry = (l2.val + temp) / 10;
            ListNode curr = new ListNode((l2.val + temp) % 10);
            p.next = curr;
            p = p.next;
            l2 = l2.next;
        }
        
        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            p.next = curr;
        }
        
        return dummy.next;
    }
    
 
}
