/*
LeetCode: https://leetcode.com/problems/reverse-linked-list-ii/
LintCode: http://www.lintcode.com/problem/reverse-linked-list-ii/
JiuZhang: http://www.jiuzhang.com/solutions/reverse-linked-list-ii/
ProgramCreek: http://www.programcreek.com/2014/06/leetcode-reverse-linked-list-ii-java/

Analysis: 
Use four pointers.
prev1 is m-1, curr1 is m, prev2 is n, curr is n+1.
Reverse nodes [m, n]
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    // 1.
//     public ListNode reverseBetween(ListNode head, int m, int n) {
//         if(head == null || m >= n) return head;
        
//         ListNode dummy = new ListNode(0);
//         dummy.next = head;
//         ListNode prev1 = dummy, curr1 = head, prev2 = dummy, curr2 = head;
//         int count = 1;
        
//         while(count <= n){
//             ListNode next = curr2.next;
            
//             if(count == m){
//                 prev1 = prev2;
//                 curr1 = curr2;
//             }
            
//             if(count >= m){
//                 curr2.next = prev2;
//             }
            
//             prev2 = curr2;
//             curr2 = next;
            
//             count++;
//         }
        
//         prev1.next = prev2;
//         curr1.next = curr2;
        
//         return dummy.next;
//     }    
    
    // 2.
    /*
    Similar to this one: https://leetcode.com/problems/reverse-nodes-in-k-group/
    */    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        
        for (int i = 1; i <= left - 1; i++) {
            prev = prev.next;
        }
        
        ListNode next = dummy;
        for (int i = 1; i <= right + 1; i++) {
            next = next.next;
        }
        
        reverse(prev, next);
        
        return dummy.next;
    }
    
    // prev -> last -> curr -> ...... -> kthNode -> next
    private ListNode reverse(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode curr = prev.next.next;
        
        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            
            curr = last.next;
        }
        
        return last;
    }
}
