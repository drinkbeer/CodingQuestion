/*
Hash Table. Design and implement a hash table which uses chaining(linked lists) to handle collisions.

How to avoid collisions? Separate chaining.
Find a good hash funtion.

What construct a hash function? collection of <K, V> pairs.
    constructor: default, constructor with length
    attribute: array of Entry, table length(total length of table), size(# of entries)
    action: keySet, valueSet, entrySet, put, remove, containsKey, containsValue 

Entry:
    attribute: <K, V>
    action: equals,
*/

public class Entry<K, V>{
    public K key;
    public V value;
    public Entry next;

    public Entry(){...}
    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }

    public K getKey(){return key;}
    public void setKey(K key){this.key = key;}
    public V getValue(){return value;}
    public void setValue(V value){this.value = value;}
    public Entry getNext(){return next;}

    public boolean equals(Entry e){
        return this.key == e.key && this.value == e.value;
    }
}

public class HashTable{
    private static final int DEFAULT_LENGTH = 20;
    private static final float LOAD_FACTOR = 0.75;

    private Entry[] entries;
    private int len;
    private int size;

    public HashTable(){
        entries = new Entry[DEFAULT_LENGTH];
    }

    public HashTable(int len){
        entries = new Entry[len];
    }

    public int hashFunction(K key){
        return key.toString().length() % len;
    }

    public boolean put(K key, V value){
        if(size / len >= LOAD_FACTOR) reahsh();

        int hashCode = hashFunction(key);
        Entry newHead = new Entry(key, value);
        if(entries[hashCode] != null){
            // collision happens
            Entry e = entries[hashCode];
            if(hashFunction(e.key) != hashCode) return false;
            newHead.next = e;
            entries[hashCode] = newHead;
        }else{
            entries[hashCode] = newHead;
        }
        return true;
    }

    public boolean put(Entry e){
        return put(e.key, e.value);
    }

    public void reahsh(){
        oldlen = len;
        len *= 2;
        Entry[] newTable = new Entry[len];
        for(int i = 0; i < oldlen; i++){
            if(entries[i] != null) newTable.put(entries[i]);
        }
        entries = newTable;
    }

    public boolean remove(Entry e){
        int hashCode = hashFunction(e.key);
        if(entries[hashCode] != null){
            Entry head = entries[hashCode];
            if(head.equals(e)) {
                entries[hashCode] = head.next;
            }else{
                Entry prev = head;
                Entry curr = head.next;
                while(curr != null && !curr.equals(e)){
                    prev = prev.next;
                    curr = curr.next;
                }
                if(curr == null) return false;

                prev.next = curr.next;
                return true;
            }
        }
    }

    public boolean containsKey(K key){
        int hashCode = hashFunction(key);
        if(entries[hashCode] == null) return false;
        return true;
    }

    public boolean containsValue(V value){
        for(int i = 0; i < len; i++){
            if(entries[i] != null){
                Entry head = entries[i];
                while(head != null){
                    if(head.value == value) return true;
                    head = head.next;
                }
            }
        }
        return false;
    }

    public Set<K> keySet(){
        Set<K> sets = new HashSet<K>();
        for(int i = 0; i < len; i++){
            if(entries[i] != null){
                sets.add(entries[i].key);
            }
        }
        return sets;
    }

    public Set<V> valueSet(){...}
    public Entry[] entrySet(){return entries;}

    public int getSize(){return size;}

}