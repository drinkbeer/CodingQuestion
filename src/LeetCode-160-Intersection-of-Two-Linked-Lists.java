/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    // 1.
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         int lenA = 0, lenB = 0;
//         ListNode nodeA = headA, nodeB = headB;
//         while(nodeA != null){
//             lenA++;
//             nodeA = nodeA.next;
//         }
//         while(nodeB != null){
//             lenB++;
//             nodeB = nodeB.next;
//         }
        
//         nodeA = headA;
//         nodeB = headB;
//         if(lenA < lenB){
//             while(lenA < lenB){
//                 lenB--;
//                 nodeB = nodeB.next;
//             }
//         }else{
//             while(lenA > lenB){
//                 lenA--;
//                 nodeA = nodeA.next;
//             }
//         }
        
//         while(nodeA != null || nodeB != null){
//             if(nodeA == nodeB) return nodeA;
//             nodeA = nodeA.next;
//             nodeB = nodeB.next;
//         }
        
//         return null;
//     }
    
    // 2.
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         int l1 = getLength(headA);
//         int l2 = getLength(headB);
        
//         if (l1 < l2) return getIntersectionNode(headB, headA);
//         int diff = l1 - l2;
//         for (int i = 0; i < diff; i++) {
//             headA = headA.next;
//         }
        
//         while(headA != null && headB != null) {
//             if (headA == headB) return headA;
//             headA = headA.next;
//             headB = headB.next;
//         }
        
//         return null;
//     }
    
//     private int getLength(ListNode n) {
//         if (n == null) return 0;
//         return 1 + getLength(n.next);
//     }
    
    // Using iterations without knowing the len (best solution)
    /*
    https://leetcode.com/problems/intersection-of-two-linked-lists/discuss/49785/Java-solution-without-knowing-the-difference-in-len!
    
    Explanation is in the link.
    */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null && headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        //if a & b have different len, then we will stop the loop after second iteration
        while (a != b) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        
        return a;
    }
}
