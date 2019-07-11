

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
