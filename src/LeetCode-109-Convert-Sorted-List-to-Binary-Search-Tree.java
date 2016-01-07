/*
LeetCode: https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
LintCode: http://www.lintcode.com/problem/convert-sorted-list-to-binary-search-tree/
JiuZhang: http://www.jiuzhang.com/solutions/convert-sorted-list-to-binary-search-tree/
ProgramCreek: http://www.programcreek.com/2013/01/leetcode-convert-sorted-list-to-binary-search-tree-java/

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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null || getLength(head) < 1) return null;
        
        int len = getLength(head);
        return DFS(head, 0, len - 1);
    }
    
    private TreeNode DFS(ListNode head, int start, int end){
        if(start > end) return null;
        
        int i = start;
        ListNode h = head;
        while(i < start + (end - start) / 2){
            h = h.next;
            i++;
        }
        
        TreeNode mid = new TreeNode(h.val);
        mid.left = DFS(head, start, i - 1);
        mid.right = DFS(h.next, i + 1, end);
        
        return mid;
    }
    
    private int getLength(ListNode head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }
}