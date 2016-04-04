public class Solution {
    // 1.Merge Sort(Divid and Conquer)
    // public ListNode mergeKLists(ListNode[] lists) {
    //     if(lists == null || lists.length < 1) return null;
    //     if(lists.length == 1) return lists[0];

    //     return mergeHelper(lists, 0, lists.length - 1);
    // }

    // private ListNode mergeHelper(ListNode[] lists, int start, int end){
    //     if(start == end) return lists[start];

    //     int mid = start + (end - start) / 2;
    //     ListNode left = mergeHelper(lists, start, mid);
    //     ListNode right = mergeHelper(lists, mid + 1, end);
    //     return mergeTwoLists(left, right);
    // }

    // private ListNode mergeTwoLists(ListNode left, ListNode right){
    //     ListNode dummy = new ListNode(-1);
    //     ListNode curr = dummy;

    //     while(left != null && right != null){
    //         if(left.val < right.val){
    //             curr.next = left;
    //             left = left.next;
    //         }else{
    //             curr.next = right;
    //             right = right.next;
    //         }
    //         curr = curr.next;
    //     }

    //     if(left != null) curr.next = left;
    //     if(right != null) curr.next = right;
    //     return dummy.next;
    // }

    // 2.Another Priority Queue (using Comparator class)
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;

        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, new ListNodeComparator());
        for(int i = 0; i < lists.length; i++){
            if(lists[i] == null) continue;
            heap.offer(lists[i]);
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!heap.isEmpty()){
            ListNode min = heap.poll();
            curr.next = min;
            curr = curr.next;

            if(min.next != null){
                heap.offer(min.next);
            }
        }
        return dummy.next;
    }

    private class ListNodeComparator implements Comparator<ListNode>{
        public int compare(ListNode l1, ListNode l2){
            if(l1 == null && l2 == null) return 0;
            if(l1 == null) return -1;
            if(l2 == null) return 1;
            if(l1.val == l2.val) return 0;
            else if(l1.val > l2.val) return 1;
            return -1;
        }
    }
}