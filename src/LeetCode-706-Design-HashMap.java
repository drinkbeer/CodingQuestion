/*
https://leetcode.com/problems/design-hashmap/discuss/270685/Java-Separate-Chaining-with-rehashing
https://www.geeksforgeeks.org/load-factor-and-rehashing/
*/
class MyHashMap {

    private class Node {
        int k, v;
        Node next;
        
        public Node(int k, int v, Node next) {
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }
    
    private static final double LOAD_FACTOR = 0.75;
    
    private Node[] nodes;
    private int size;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        this.nodes = new Node[1000];
        this.size = 0;
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = hash(key);
        
        // check if key exists
        for (Node x = nodes[idx]; x != null; x = x.next) {
            if (x.k == key) {
                x.v = value;
                return;
            }
        }
        
        // add a new node to the head of the list if key doesn't exist
        nodes[idx] = new Node(key, value, nodes[idx]);
        size++;
        
        // rehash if necessary
        double loadFactor = (double) size / nodes.length;
        if (loadFactor > LOAD_FACTOR) {
            rehash();
        }
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = hash(key);
        
        for (Node x = nodes[idx]; x != null; x = x.next) {
            if (x.k == key) {
                return x.v;
            }
        }
        
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = hash(key);
        
        Node dummy = new Node(-1, -1, nodes[idx]);
        
        for (Node prev = dummy; prev.next != null; prev = prev.next) {
            if (prev.next.k == key) {
                // find the destination
                prev.next = prev.next.next;
                size--;
                break;
            }
        }
        
        nodes[idx] = dummy.next;
    }
    
    private int hash(int k) {
        return k % nodes.length;
    }
    
    private void rehash() {
        Node[] temp = nodes;
        nodes = new Node[temp.length * 2];
        
        for (Node head : temp) {
            for (Node x = head; x != null; x = x.next) {
               put(x.k, x.v) ;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
