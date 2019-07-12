class RandomizedCollection {

    private java.util.Random rand = new Random();
    
    LinkedList<Integer> vals;                     // list of vals
    HashMap<Integer, Set<Integer>> locs;    // <val, set<idx>> pair
    
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        vals = new LinkedList<>();
        locs = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean notContains = !locs.containsKey(val);
        if (notContains) locs.put(val, new HashSet<>());
        // locs.computeIfAbsent(val, k -> new HashSet<>());
        
        locs.get(val).add(vals.size());
        vals.add(val);
        
        return notContains;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) return false;
        
        int lastIdx = vals.size() - 1;
        int lastVal = vals.get(lastIdx);
        
        if (lastVal != val) {
            // replace val with lastVal
            int currIdx = locs.get(val).iterator().next();
            locs.get(lastVal).add(currIdx);
            locs.get(val).remove(currIdx);
            
            vals.set(currIdx, lastVal);
        }
        
        locs.get(lastVal).remove(lastIdx);
        vals.remove(lastIdx);
        if (locs.get(val).isEmpty()) {
            locs.remove(val);
        }
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }
    
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
