public class HR_LinkList_Merge {
	
	static Node MergeLists(Node headA, Node headB) {
		// This is a "method-only" submission. 
		// You only need to complete this method 
		Node n1 = headA;
		Node n2 = headB;
		Node head = null;
		while(n1 != null && n2 != null){
			if(n1.data < n2.data){
				head = LinkListUtil.addToTail(head, n1);
				n1 = n1.next;
			}else{
				head = LinkListUtil.addToTail(head, n2);
				n2 = n2.next;
			}
		}
		
		while(n1 != null){
			head = LinkListUtil.addToTail(head, n1);
			n1 = n1.next;
		}
		
		while(n2 != null){
			head = LinkListUtil.addToTail(head, n2);
			n2 = n2.next;
		}
		
		return head;
	}
	
	public static void main(String[] args){
		int[] datas = {1, 3, 5, 6};
		Node nodeA = LinkListUtil.buildListByArray(datas);
		int[] datas2 = {2, 4, 7};
		Node nodeB = LinkListUtil.buildListByArray(datas2);
		LinkListUtil.printList(nodeA);
		LinkListUtil.printList(nodeB);
		
		Node node = MergeLists(nodeA, nodeB);
		LinkListUtil.printList(node);
	}
}