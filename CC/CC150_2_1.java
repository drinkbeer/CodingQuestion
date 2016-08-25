import java.util.HashSet;
import java.util.Hashtable;

/**
 * Created by chen on 15/5/3.
 * <p/>
 * 2.1 Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class CC150_2_1 {

    /*
    Using a Hashset as a tempory collection to maintain the node that appeared at least once in the list
    Time Complexity: O(n)
    Space Complexity: O(n)
     */
    public static void removeDups(Node head) {
        if (head == null) {
            return;
        }
        HashSet<Integer> sets = new HashSet<Integer>();
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (sets.contains(curr.data)) {
                prev.next = curr.next;
            } else {
                sets.add(curr.data);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    /*
    Using double pointer to mark the start and
    Time Complexity: O(n)
    Space Complexity: O(1)
     */
    public static void removeDups2(Node head) {
        if (head == null) {
            return;
        }

        Node curr = head;
        while (curr != null) {
            Node prevNext = curr;
            Node next = curr.next;
            while (next != null) {
                if (next.data == curr.data) {
                    prevNext.next = next.next;
                } else {
                    prevNext = next;
                }
                next = next.next;
            }
            curr = curr.next;
        }
    }

    private static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    /*
    Helper Function
     */
    private static void printList(Node node) {
        if (node == null) {
            return;
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(node.data);
        node = node.next;
        while (node != null) {
            stringBuffer.append(" -> ").append(node.data);
            node = node.next;
        }

        System.out.println(stringBuffer.toString());
    }

    private static Node buildList() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(2);
        Node n4 = new Node(2);
        Node n5 = new Node(3);
        Node n6 = new Node(3);
        Node n7 = new Node(4);
        Node n8 = new Node(5);
        Node n9 = new Node(6);
        Node n10 = new Node(6);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        n9.next = n10;

        return n1;
    }

    public static void main(String[] args) {

        Node n1 = buildList();
        System.out.print("Before Removing: ");
        printList(n1);
        removeDups(n1);
        System.out.print("After Removing: ");
        printList(n1);

        Node n2 = buildList();
        System.out.print("Before Removing: ");
        printList(n2);
        removeDups2(n2);
        System.out.print("After Removing: ");
        printList(n2);
    }

}
