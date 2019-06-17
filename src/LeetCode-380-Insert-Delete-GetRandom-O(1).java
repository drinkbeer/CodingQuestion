class RandomizedSet {

    private java.util.Random random = new Random();
    
    List<Integer> vals;
    HashMap<Integer, Integer> valToIdx;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        vals = new ArrayList<>();
        valToIdx = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (valToIdx.containsKey(val)) return false;
        
        valToIdx.put(val, vals.size());
        vals.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!valToIdx.containsKey(val)) return false;
        
        int lastVal = vals.get(vals.size() - 1);
        int lastIdx = vals.size() - 1;
        int currIdx = valToIdx.get(val);
        if (currIdx != lastIdx) {
            // swap currIdx and lastIdx
            valToIdx.put(lastVal, currIdx);
            vals.set(currIdx, lastVal);
            valToIdx.put(val, lastIdx);
            vals.set(lastIdx, val);
        }
        
        // remove last idx
        valToIdx.remove(val);
        vals.remove(lastIdx);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return vals.get(random.nextInt(vals.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
