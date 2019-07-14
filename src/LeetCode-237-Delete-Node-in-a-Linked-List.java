/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 1.
    // public void deleteNode(ListNode node) {
    //     ListNode prev = null;
    //     while (node.next != null) {
    //         node.val = node.next.val;
    //         prev = node;
    //         node = node.next;
    //     }
    //     prev.next = null;
    // }
    
    // 2.
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
