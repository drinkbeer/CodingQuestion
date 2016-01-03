/*
LeetCode: https://leetcode.com/problems/palindrome-linked-list/
LintCode: http://www.lintcode.com/problem/palindrome-linked-list/
JiuZhang: http://www.jiuzhang.com/solutions/palindrome-linked-list/
ProgramCreek: http://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/

Analysis: 
1.Reverse second part and compare
Time O(n)
Space O(1)

2.Reverse

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
    // 1.Reverse
    // public boolean isPalindrome(ListNode head) {
    //     if(head == null || head.next == null) return true;
        
    //     int len = 0;
    //     ListNode curr = head;
    //     while(curr != null){
    //         len++;
    //         curr = curr.next;
    //     }
        
    //     if(len == 2) return head.val == head.next.val;
        
    //     int lo = 0;
    //     if(len % 2 == 0){
    //         lo = len / 2 + 1;
    //     }else{
    //         lo = len / 2 + 2;
    //     }
        
    //     curr = head;
    //     int i = 1;
    //     while(i < lo){
    //         curr = curr.next;
    //         i++;
    //     }
        
    //     curr = reverse(curr);
        
    //     while(head != null && curr != null){
    //         if(head.val != curr.val) return false;
    //         head = head.next;
    //         curr = curr.next;
    //     }
        
    //     return true;
    // }
    
    // private ListNode reverse(ListNode head){
    //     ListNode dummy = new ListNode(-1);
    //     dummy.next = null;
        
    //     while(head != null){
    //         ListNode next = head.next;
    //         head.next = dummy.next;
    //         dummy.next = head;
    //         head = next;
    //     }
        
    //     return dummy.next;
    // }
    
    // 2.Reverse
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        
        ListNode mid = findMiddle(head);
        
        ListNode second = reverse(mid);
        
        while(head != null && second != null){
            if(head.val != second.val) return false;
            head = head.next;
            second = second.next;
        }
        
        return true;
    }
    
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head){
        ListNode dummy = new ListNode(-1);
        dummy.next = null;
        
        while(head != null){
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        
        return dummy.next;
    }
}