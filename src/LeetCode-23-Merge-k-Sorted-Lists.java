/*
LeetCode: https://leetcode.com/problems/merge-k-sorted-lists/
LintCode: http://www.lintcode.com/problem/merge-k-sorted-lists/
JiuZhang: http://www.jiuzhang.com/solutions/merge-k-sorted-lists/
ProgramCreek: http://www.programcreek.com/2013/02/leetcode-merge-k-sorted-lists-java/

Analysis:
1.Merge Sort.
Using divid and conquer

Runtime: 1 ms, faster than 100.00% of Java online submissions for Merge k Sorted Lists.


2.Priority Queue
Time: O(N*logK), N is # of total nodes, K is # of lists

3.Merge lists two by two.
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
    // 1.Merge Sort(Divid and Conquer)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        return mergeHelper(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    
    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        
        while (left != null && right != null) {
            if (left.val < right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        
        if (left != null) p.next = left;
        if (right != null) p.next = right;
        
        return dummy.next;
    }
    
    // 2.PriorityQueue
//     public ListNode mergeKLists(ListNode[] lists) {
//         if(lists == null || lists.length == 0) return null;
        
//         Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, listNodeComparator);
//         for(int i = 0; i < lists.length; i++){
//             if(lists[i] != null){
//                 heap.add(lists[i]);
//             }
//         }
        
//         ListNode dummy = new ListNode(-1);
//         ListNode curr = dummy;
//         while(!heap.isEmpty()){
//             ListNode min = heap.poll();
//             curr.next = min;
//             curr = curr.next;
            
//             if(min.next != null){
//                 heap.add(min.next);
//             }
//         }
//         return dummy.next;
//     }
    
//     private Comparator<ListNode> listNodeComparator = new Comparator<ListNode>(){
//         public int compare(ListNode l1, ListNode l2){
//             if(l1 == null) return 1;
//             else if(l2 == null) return -1;
//             return l1.val - l2.val;
//         }
//     };
    
    // another way to write, which is simpler.
    /**
    Time: log(k) * n.
    k is number of list and n is number of total elements.
    */
//     public ListNode mergeKLists(ListNode[] lists) {
//         if (lists == null || lists.length == 0) return null;
        
//         PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
//         for(ListNode node : lists) {
//             if (node != null) queue.add(node);
//         }
        
//         ListNode dummy = new ListNode(-1);
//         ListNode p = dummy; // pointer
        
//         while(!queue.isEmpty()) {
//             ListNode curr = queue.poll();
            
//             p.next = curr;
//             p = p.next;
            
//             if(curr.next != null) queue.add(curr.next);
//         }
        
//         return dummy.next;
//     }
    
    // 3.Merge lists two by two (Like merge sort). Referred from JiuZhang.
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists == null || lists.length == 0) return null;
        
    // }
    
}
