class ListDemo{
	private class Node {
		int val;
		Node next;

		public Node(int val){
			this.val = val;
		}
	}

	// 1.Get list length
	public static int getListLen(Node head){
		if(head == null) return 0;

		int len = 0;
		Node curr = head;
		while(curr != null){
			len++;
			curr = curr.next;
		}
		return len;
	}

	// 2.Reverse a list
	public static Node reverseListIte(Node head){
		if(head == null || head.next == null) return head;

		Node newHead = null;
		Node curr = head;

		while(curr != null){
			Node prev = curr;
			curr = curr.next;
			prev.next = newHead;
			newHead = prev;
		}
	}
}