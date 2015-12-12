public class LinkListUtil {
	
	static void printList(Node head){
		StringBuffer sb = new StringBuffer();
		while(head != null){
			sb.append(head.data);
			sb.append(" ");
			head = head.next;
		}
		
		System.out.println(sb.toString());
	}
	
	static Node getCopy(Node node){
		Node copy = new Node();
		copy.data = node.data;
		return copy;
	}
	
	static Node addToTail(Node head, Node node){
		Node copy = getCopy(node);
		if(head == null) {
			head = copy;
			return head;
		}
		
		Node curr = head;
		while(curr.next != null){
			curr = curr.next;
		}
		curr.next = copy;
		return head;
	}
	
	static Node buildListByArray(int[] datas){
		Node head = null;
		
		for(int d : datas){
			Node curr = new Node();
			curr.data = d;
			head = addToTail(head, curr);
		}
		return head;
	}
}