/*
This class implements a HashTable to store Process (avoid collision)

Note: collision means a process with the same id as another process already in the HashTable
*/
public class HashTable{
    public Bucket[] buckets;
    public int entryNum;
    public static final int DEFAULT_SIZE = 2029;

    public HashTable(){
        buckets = new Bucket[DEFAULT_SIZE];
        entryNum = 0;
    }

    public HashTable(int size){
        buckets = new Bucket[size];
        entryNum = 0;
    }

    /*
    Hash function using double hashing
    To avoid collision, we choose: 
        hash_2 = R - (k mod R)
        R is a prime number that is smaller than the size of HashTable

    We choose this collision resolution fucntion because it never evaluates to zero and all cells in the table can be probed.
    Besides, it's easy and quick to compute and achieve even in distrubution environment.
    Finally, it's popular hash function for double addressing.
    */
    public int hashFunction(Bucket b, int j){
        int i = b.getKey();
        int m = buckets.length;
        int hash_1 = i % m;
        int hash_2 = 2027 - (i % 2027);
        return (hash_1 + j * hash_2) % m;
    }

    public int insert(Bucket b){
        // If table is not large enough, rehashing. 0.5 here is load factor.
        if( 1.0 * entryNum / buckets.length >= 0.5) rehash();

        int i = 0;
        do{
            int j = hashFunction(b, i);
            // Find collision in table
            if(buckets[j] != null){
                if(b.getKey() == buckets[j].getKey()) return -1;
            }

            //Find right position to insert
            if(buckets[j] == null || buckets[j].getLive() == false){
                buckets[j] = b;
                entryNum++;
                return j;
            }
            // keep probing
            else{
                i++;
            }
        }while(i != buckets.length - 1);
        return -1;
    }

    // remove process from HashTable
    public void remove(Bucket b){
        // find index of the process to be removed
        int index = findIndex(b);
        // set bucket to dead
        if(isLive(index)){
            buckets[index].setLive(false);
            entryNum--;
        }
    }

    // search for a process
    public int search(Bucket b){
        int i = 0; 
        int j = hashFunction(b, i);
        while(buckets[i] != null || i != buckets.length - 1){
            // find success
            if(b.equals(buckets[i])){
                return j;
            }else{
                i++;
                j = hashFunction(b, j);
            }
        }
        return -1;
    }

    //find index of given bucket
    public int findIndex(Bucket b){
        int i = 0;

        int curr = hashFunction(b, i);
        while(buckets[curr] != null && !b.equals(buckets[curr])){
            i++;
            curr = hashFunction(b, i);
        }
        return curr;
    }

    public boolean isLive(int i){
        if(buckets[i] != null && buckets[i].getLive()){
            return true;
        }else{
            return false;
        }
    }

    //set hashtable empty
    public void makeEmpty(){
        entryNum = 0;
        for(int i = 0; i < buckets.length; i++){
            buckets[i] = null;
        }
    }

    //rehashing the table
    public void rehash(){
        Bucket[] oldBuckets = buckets;
        // enlarge the table to twice of old size
        buckets = new Bucket[2 * oldBuckets.length];
        for(int i = 0; i < oldBuckets.length; i++){
            if(oldBuckets[i] != null && oldBuckets[i].getLive()){
                insert(oldBuckets[i]);
            }
        }
    }

    public int getSize(){
        return entryNum;
    }
}
