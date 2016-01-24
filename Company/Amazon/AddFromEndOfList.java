/*
1.Get length and add

2.Reverse and add

*/
class Node{
    int val;
    Node next;
    public Node(int val){
        this.val = val;
        this.next = null;
    }
}

class AddFromEndOfList{
    public static Node addFromEndOfList2(Node n1, Node n2){
        //if n1 or n2 == null?
        
        if(getLen(n1) < getLen(n2)) return addFromEndOfList2(n2, n1);
        Node h1 = reverse(n1);
        Node h2 = reverse(n2);
        
        Node head = h1;
        while(h1 != null && h2 != null){
            h1.val += h2.val;
            h1 = h1.next;
            h2 = h2.next;
        }
        
        return reverse(head);
    }
    
    private static Node reverse(Node head){
        if(head == null) return null;
        
        Node dummy = new Node(-1);
        dummy.next = null;
        while(head != null){
            Node next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
    
    public static Node addFromEndOfList(Node n1, Node n2){
        int l1 = getLen(n1);
        int l2 = getLen(n2);
        if(l1 < l2) return addFromEndOfList(n2, n1);

        Node curr = n1;
        while(l1 > l2) {
            curr = curr.next;
            l1--;
        }

        while(curr != null && n2 != null){
            curr.val += n2.val;
            curr = curr.next;
            n2 = n2.next;
        }
        return n1;
    }

    private static int getLen(Node head){
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        return len;
    }

    public static void main(String[] args){
        int[] arr1 = {1, 2, 3};
        Node n1 = createList(arr1);
        int[] arr2 = {5, 6};
        Node n2 = createList(arr2);
        printList(addFromEndOfList(n1, n2));
        
        int[] arr3 = {1, 2, 3};
        Node n3 = createList(arr3);
        int[] arr4 = {5, 6};
        Node n4 = createList(arr4);
        printList(addFromEndOfList2(n4, n3));
    }

    private static Node createList(int[] arr){
        if(arr == null || arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node pre = head;
        for(int i = 1; i < arr.length; i++){
            Node curr = new Node(arr[i]);
            pre.next = curr;
            pre = pre.next;
        }
        return head;
    }

    private static void printList(Node head){
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append(head.val);
            sb.append("->");
            head = head.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());
    }
}
