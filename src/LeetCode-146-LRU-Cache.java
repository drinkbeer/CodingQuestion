/*
LeetCode: https://leetcode.com/problems/lru-cache/
LintCode: http://www.lintcode.com/problem/lru-cache/
JiuZhang: http://www.jiuzhang.com/solutions/lru-cache/
ProgramCreek: http://www.programcreek.com/2013/03/leetcode-lru-cache-java/

Analysis: 
Two key points to design a LRU cache:
    1.Get,Set,Remove in O(1) (Use HashMap)
    2.Maintain the order from latest and oldest (Use Double Linked List)
Use HashMap to search,delete,set: O(1)
List to keep order(like a queue, FILO)

Be carefully, every get, set operation, will cause operated node to the head of list.
Every set operation will affect both List and HashMap.


This Question could be extended to add some other API:

clear();            // clear the cache
delete(int key);    // delete one key-value in the cache
size();             // return size of the cache
*/

/*

tail <- prev <- Node -> next -> head
*/
class LRUCache {
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Map<Integer, Node> map;
    Node tail;
    Node head;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        if (map.keySet().contains(key)) {
            Node curr = map.get(key);
            removeNode(curr);
            addToHead(curr);
            return curr.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // simple case, if already exists, just update the value, and promote the node to head
        if (map.keySet().contains(key)) {
            Node curr = map.get(key);
            curr.value = value;
            removeNode(curr);
            addToHead(curr);
            return;
        }
        
        // going to add a new node, but check the capacity first
        if (map.size() == capacity) {
            // remove tail first
            map.remove(tail.key);
            removeNode(tail);
        }
        
        // first time to add this key-value pair
        Node curr = new Node(key, value);
        map.put(key, curr);
        addToHead(curr);
    }
    
    // Operation to Double LinkedList (has nothing to do with HashMap)
    private void removeNode(Node node) {
        if (node == tail) tail = tail.next;
        if (node == head) head = head.prev;
        if (node.next != null) node.next.prev = node.prev;
        if (node.prev != null) node.prev.next = node.next;
        node.next = null;
        node.prev = null;
    }
    
    // Operation to Double LInkedList (has nothing to do with HashMap)
    private void addToHead(Node node) {
        if (head == null) {
            head = node;
            tail = node;
            return;
        }
        
        head.next = node;
        node.prev = head;
        head = head.next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
