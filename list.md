List helper function:

```
    public void printList(ListNode head) {
        String str = head.val + "";
        head = head.next;
        while (head != null) {
            str += " -> " + head.val;
            head = head.next;
        }
        
        System.out.println(str);
    }
```
