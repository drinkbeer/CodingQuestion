/*
https://leetcode.com/problems/insert-delete-getrandom-o1/discuss/85401/Java-solution-using-a-HashMap-and-an-ArrayList-along-with-a-follow-up.-(131-ms)

Follow-up of this question: How do you modify your code to allow duplicated number?
Ans: in locs, the value to be a set<> of Integer
*/

class RandomizedSet {

    private java.util.Random rand = new Random();
    
    List<Integer> vals;                 // list of vals
    HashMap<Integer, Integer> locs;     // <val, idx> pair
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        vals = new ArrayList<>();
        locs = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (locs.containsKey(val)) return false;
        
        locs.put(val, vals.size());
        vals.add(val);
        
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!locs.containsKey(val)) return false;
        
        int lastVal = vals.get(vals.size() - 1);
        int lastIdx = vals.size() - 1;
        
        int currIdx = locs.get(val);
        
        if (currIdx != lastIdx) {
            // swap lastVal and val
            locs.put(lastVal, currIdx);
            vals.set(currIdx, lastVal);
        }
        
        locs.remove(val);
        vals.remove(lastIdx);
        
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return vals.get(rand.nextInt(vals.size()));
    }
}


// Follow-up code: How do you modify your code to allow duplicated number?
// class RandomizedSet {

//     private java.util.Random rand = new Random();
    
//     List<Integer> vals;                     // list of vals
//     HashMap<Integer, Set<Integer>> locs;    // <val, set<idx>> pair
    
//     /** Initialize your data structure here. */
//     public RandomizedSet() {
//         vals = new ArrayList<>();
//         locs = new HashMap<>();
//     }
    
//     /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
//     public boolean insert(int val) {
//         if (!locs.containsKey(val)) locs.put(val, new HashSet<>());
        
//         locs.get(val).add(vals.size());
//         vals.add(val);
        
//         return true;
//     }
    
//     /** Removes a value from the set. Returns true if the set contained the specified element. */
//     public boolean remove(int val) {
//         if (!locs.containsKey(val)) return false;
        
//         int lastVal = vals.get(vals.size() - 1);
//         int lastIdx = vals.size() - 1;
        
//         int currIdx = locs.get(val).iterator().next();
        
//         if (currIdx != lastIdx) {
//             // swap lastVal and val
//             locs.get(lastVal).add(currIdx);
//             locs.get(val).remove(currIdx);
//             vals.set(currIdx, lastVal);
//         }
        
//         vals.remove(lastIdx);
//         locs.get(lastVal).remove(lastIdx);
//         if (locs.get(lastVal).isEmpty()) {
//             locs.remove(lastVal);
//         }
        
//         return true;
//     }
    
//     /** Get a random element from the set. */
//     public int getRandom() {
//         return vals.get(rand.nextInt(vals.size()));
//     }
// }

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
