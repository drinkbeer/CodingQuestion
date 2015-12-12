class Node {
     int data;
     Node next;
}

public class HR_Linkedlist_Reverse {
	
	static Node insertToHead(Node head, Node node){
		Node newHead = new Node();
		newHead.data = node.data;
		if(head == null){
			return newHead;
		}
		newHead.next = head;
		return newHead;
	}
	
	static Node Reverse(Node head) {
		if(head == null) return null;
		
		Node curr = head;
		Node newHead = null;
		while(curr != null){
			newHead = insertToHead(newHead, curr);
			curr = curr.next;
		}
		
		return newHead;
	}
	
	static void PrintList(Node head){
		StringBuffer sb = new StringBuffer();
		while(head != null){
			sb.append(head.data);
			sb.append(" ");
			head = head.next;
		}
		
		System.out.println(sb.toString());
	}
	
	public static void main(String[] args){
		Node n1 = new Node();
		n1.data = 1;
		Node n2 = new Node();
		n2.data = 2;
		Node n3 = new Node();
		n3.data = 3;
		n1.next = n2;
		n2.next = n3;
		PrintList(n1);
		
		Node newHead = Reverse(n1);
		PrintList(newHead);
	}
}