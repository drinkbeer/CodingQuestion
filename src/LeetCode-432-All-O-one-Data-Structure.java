/*

tail <->    prev    <->     curr     <->    next    <->     head

Be very careful:

1. Update nodes (add or delete) by removing node or adding node, we have to update both the countToNode map, and the list.
2. When inc, the original node could be empty. Check if it's empty, if it is remove the Node from countToNode map and the list.
*/
// class AllOne {
    
//     private class Node {
//         int count;
//         Set<String> keys;
//         Node prev, next;
        
//         public Node(int count) {
//             this.count = count;
//             keys = new HashSet<>();
//         }
//     }

//     HashMap<String, Integer> keyToFreq;     // <key, freq> pair
//     HashMap<Integer, Node> freqToNode;      // <freq, Node> pair
//     Node head, tail;
    
//     /** Initialize your data structure here. */
//     public AllOne() {
//         keyToFreq = new HashMap<>();
//         freqToNode = new HashMap<>();
//         head = new Node(Integer.MAX_VALUE);
//         tail = new Node(Integer.MIN_VALUE);
//         head.prev = tail;
//         tail.next = head;
//     }
    
//     /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
//     public void inc(String key) {
//         int freq = 0;
//         if (keyToFreq.containsKey(key)) {
//             freq = keyToFreq.get(key);
//         }
//         keyToFreq.put(key, freq + 1);
        
//         Node curr;
//         if (freqToNode.containsKey(freq)) {
//             curr = freqToNode.get(freq);
//         } else {
//             curr = tail;
//         }
//         if (!freqToNode.containsKey(freq + 1)) {
//             freqToNode.put(freq + 1, new Node(freq + 1));
//             insertAfter(curr, freqToNode.get(freq + 1));
//         }
        
//         curr.keys.remove(key);
//         if (curr.keys.isEmpty() && curr != tail) {
//             deleteNode(curr);
//             freqToNode.remove(freq);
//         }
        
//         Node next = freqToNode.get(freq + 1);
//         next.keys.add(key);
//     }
    
//     /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
//     public void dec(String key) {
//         if (!keyToFreq.containsKey(key)) return;
        
//         int freq = keyToFreq.get(key);
//         keyToFreq.put(key, freq - 1);
//         if (keyToFreq.get(key) == 0) {
//             keyToFreq.remove(key);
//         }
        
//         Node curr = freqToNode.get(freq);
//         if (freq - 1 > 0 && !freqToNode.containsKey(freq - 1)) {
//             freqToNode.put(freq - 1, new Node(freq - 1));
//             insertBefore(curr, freqToNode.get(freq - 1));
//         }
        
//         if (freq - 1 > 0) {
//             Node prev = freqToNode.get(freq - 1);
//             prev.keys.add(key);
//         }
        
//         curr.keys.remove(key);
//         if (curr.keys.isEmpty()) {
//             deleteNode(curr);
//             freqToNode.remove(freq);
//         }
        
//     }
    
//     /** Returns one of the keys with maximal value. */
//     public String getMaxKey() {
//         // printList(tail);
//         // printListFromHead(head);
//         // System.out.println(head.prev.count + "-" + head.prev.keys.toString());
//         return head.prev.keys.iterator().hasNext() ? head.prev.keys.iterator().next() : "";
//     }
    
//     /** Returns one of the keys with Minimal value. */
//     public String getMinKey() {
//         return tail.next.keys.iterator().hasNext() ? tail.next.keys.iterator().next() : "";
//     }
    
//     private void insertAfter(Node curr, Node next) {
//         next.next = curr.next;
//         curr.next.prev = next;
//         curr.next = next;
//         next.prev = curr;
//     }
    
//     private void insertBefore(Node curr, Node prev) {
//         prev.prev = curr.prev;
//         curr.prev.next = prev;
//         curr.prev = prev;
//         prev.next = curr;
//     }
    
//     private void deleteNode(Node curr) {
//         if (curr.next != null) curr.next.prev = curr.prev;
//         if (curr.prev != null) curr.prev.next = curr.next;
//         curr.prev = null;
//         curr.next = null;
//     }
    
//     private void printList(Node tail) {
//         StringBuilder sb = new StringBuilder();
//         Node p = tail;
//         sb.append(p.count + "-" + p.keys.toString());
//         p = p.next;
//         while (p != null) {
//             sb.append(" -> ").append(p.count + "-" + p.keys.toString());
//             p = p.next;
//         }
//         System.out.println(sb.toString());
//     }
    
//     private void printListFromHead(Node head) {
//         StringBuilder sb = new StringBuilder();
//         Node p = head;
//         while (p != null) {
//             sb.insert(0, p.count + "-" + p.keys.toString());
//             sb.insert(0, "->");
//             p = p.prev;
//         }
//         System.out.println(sb.toString());
//     }
// }


// 2. A more concise approach (Using insertAfter to do inc and dec)
class AllOne {
    
    private class Node {
		int count;
		Set<String> keys;
		Node prev, next;

		public Node(int count) {
			this.count = count;
			this.keys = new HashSet<>();
		}
	}

	HashMap<String, Integer> keyToCount;		// store <key, count> pair
	HashMap<Integer, Node> countToNode;			// store <count, node> pair
	Node head, tail;
    
    /** Initialize your data structure here. */
    public AllOne() {
        this.keyToCount = new HashMap<>();
        this.countToNode = new HashMap<>();
        this.head = new Node(Integer.MAX_VALUE);
        this.tail = new Node(Integer.MIN_VALUE);
        head.prev = tail;
        tail.next = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
    	// 1. Prepare currCount and currNode
    	int currCount = 0;
        if (keyToCount.containsKey(key)) {
        	currCount = keyToCount.get(key);
        }
        Node currNode = tail;
        if (countToNode.containsKey(currCount)) {
        	currNode = countToNode.get(currCount);
        }

        // 2. Prepare newCount and newNode
        int newCount = currCount + 1;
        if (!countToNode.containsKey(newCount)) {
        	countToNode.put(newCount, new Node(newCount));
        	insertAfter(currNode, countToNode.get(newCount));
        }
        Node newNode = countToNode.get(newCount);

        // 3. Update the <key, count> pair and remove the key from original node, remove the original node if necessasry
        keyToCount.put(key, newCount);
        if (currNode != tail) {
        	currNode.keys.remove(key);
        }
        if (currNode != tail && currNode.keys.isEmpty()) {
    		deleteNode(currNode);
            countToNode.remove(currCount);
    	}

        // 4. Add the key to the new Node
        newNode.keys.add(key);
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!keyToCount.containsKey(key)) return;

        // 1. Prepare the currCount and currNode
        int currCount = keyToCount.get(key);
        Node currNode = countToNode.get(currCount);

        // 2. Prepare the newCount and newNode
        int newCount = currCount - 1;
        if (newCount != 0 && !countToNode.containsKey(newCount)) {
        	countToNode.put(newCount, new Node(newCount));
            insertAfter(currNode.prev, countToNode.get(newCount));
        }

        // 3. Update the <key, count> pair (remove if necessary), and remove the key from Nodes (remove node from countToNode pair and list if necessary)
        keyToCount.put(key, newCount);
        if (newCount == 0) {
        	keyToCount.remove(key);
        }
        currNode.keys.remove(key);
        if (currNode.keys.isEmpty()) {
        	deleteNode(currNode);
            countToNode.remove(currCount);
        }
        
        // 4. Add the key to the new node if necessary
        if (newCount != 0 && countToNode.containsKey(newCount)) {
        	countToNode.get(newCount).keys.add(key);
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
    	return this.head.prev.keys.iterator().hasNext() ? this.head.prev.keys.iterator().next() : "";
    }

	/** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        
    	return this.tail.next.keys.iterator().hasNext() ? this.tail.next.keys.iterator().next() : "";
    }

    private void insertAfter(Node curr, Node next) {
    	next.next = curr.next;
    	curr.next.prev = next;
    	curr.next = next;
        next.prev = curr;
    }

    private void deleteNode(Node curr) {
    	curr.prev.next = curr.next;
    	curr.next.prev = curr.prev;
    	curr.next = null;
    	curr.prev = null;
    }
    
//     private void printList(Node tail) {
//         StringBuilder sb = new StringBuilder();
//         Node p = tail;
//         sb.append(p.count + "-" + p.keys.toString());
//         p = p.next;
//         while (p != null) {
//             sb.append(" -> ").append(p.count + "-" + p.keys.toString());
//             p = p.next;
//         }
//         System.out.println(sb.toString());
//     }
    
//     private void printListFromHead(Node head) {
//         StringBuilder sb = new StringBuilder();
//         Node p = head;
//         while (p != null) {
//             sb.insert(0, p.count + "-" + p.keys.toString());
//             sb.insert(0, "->");
//             p = p.prev;
//         }
//         System.out.println(sb.toString());
//     }
}




/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
