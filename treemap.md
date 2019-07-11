

https://www.geeksforgeeks.org/hashmap-treemap-java/   

### HashMap

HashMap is hashing based implementation. It stores <K, V> pair without orders.

Time complexity:
- get/put/containsKey(): `O(1)`

```
HashMap<K, V> hmap = new HashMap<K, V>();
```


### TreeMap

TreeMap in Java is used to implement Map interface as long as the **sorting according to the order of the keys**. Java TreeMap class is implemented by Red-Black Tree in the background, which makes sure that there are no duplicates; additionally it also maintains the elements in the sorted order.

https://www.geeksforgeeks.org/treemap-in-java/   


Time complexity:
- add/put(): `O(logN)`  - N is the number of elements in the TreeMap
- remove(): `O(logN)`
- containsKey(): `O(logN)`

```
TreeMap<Integer, Interval> tree = new TreeMap<>();

private static void TreeMapDemo1(){
  // Create a hash map
  TreeMap tm = new TreeMap();
  // Put elements to the map
  tm.put("Zara", new Double(3000));
  tm.put("Mahnaz", new Double(100));
  tm.put("Ayan", new Double(2000));
  tm.put("Daisy", new Double(50));
  tm.put("Qadir", new Double(-20));

  Set set = tm.entrySet();
  Iterator i = set.iterator();
  while(i.hasNext()) {
     Map.Entry me = (Map.Entry)i.next();
     System.out.println(me.getKey() + ": " + me.getValue());
  }
}
```


#### 352. Data Stream as Disjoint Intervals
https://leetcode.com/problems/data-stream-as-disjoint-intervals/

```
// 2. TreeMap based implementation.
/*
https://leetcode.com/problems/data-stream-as-disjoint-intervals/discuss/82553/Java-solution-using-TreeMap-real-O(logN)-per-adding.

Time O(log(N))
*/
TreeMap<Integer, Integer> map;
public SummaryRanges() {
    map = new TreeMap<>();
}

public void addNum(int val) {
    if (map.containsKey(val)) return;

    Integer l = map.lowerKey(val);  // the key that is just lower than val, could be null if no exist
    Integer h = map.higherKey(val); // the key that is just higher than val, could be null if no exist

    if (l != null && h != null && map.get(l) + 1 == val && val + 1 == h) {
        // means [l, lv], [val, val], [h, hv] could be merged
        map.put(l, map.get(h));
        map.remove(h);
    } else if (l != null && map.get(l) + 1 >= val) {
        // means [l, lv], [val, val] has overlap
        map.put(l, Math.max(map.get(l), val));
    } else if (h != null && val + 1 >= h) {
        // means [val, val] [h, hv] has overlap
        map.put(val, map.get(h));
        map.remove(h);
    } else {
        // means [l, lv], [val, val], [h, hv] have no overlapping
        map.put(val, val);
    }
}

public int[][] getIntervals() {
    int[][] res = new int[map.size()][2];

    int i = 0;
    for (Map.Entry e : map.entrySet()) {
        res[i][0] = (int) e.getKey();
        res[i++][1] = (int) e.getValue();
    }

    return res;
}
```
