
# Reverse List

Template:

```Java
    // prev -> last -> curr -> ...... -> kthNode -> next
    private void reverse(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode curr = prev.next.next;
        
        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            
            curr = last.next;
        }
    }
```

Problems:
https://leetcode.com/problems/reverse-linked-list-ii/  
https://leetcode.com/problems/reverse-nodes-in-k-group/  
