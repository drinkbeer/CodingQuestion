/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 1. Iterative
//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         ListNode dummy = new ListNode(-1);
//         ListNode p = dummy;
        
//         while (l1 != null && l2 != null) {
//             if (l1.val < l2.val) {
//                 p.next = l1;
//                 l1 = l1.next;
                
//             } else {
//                 p.next = l2;
//                 l2 = l2.next;
//             }
//             p = p.next;
//         }
        
//         if (l1 != null) {
//             p.next = l1;
//         }
        
//         if (l2 != null) {
//             p.next = l2;
//         }
        
//         return dummy.next;
//     }
    
    // 2.Recurring
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        else if(l2 == null) return l1;
        
        if(l1.val > l2.val) {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }else{
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }
}
