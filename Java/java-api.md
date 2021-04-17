- [String](#String)
- [Array](#Array)
- [ArrayList](#ArrayList)
- [LinkedList](#LinkedList)
- [HashMap](#HashMap)
- [TreeMap](#TreeMap)
- [HashTable](#HashTable)
- [HashSet](#HashSet)
- [Stack](#Stack)
- [Queue](#Queue)
- [PriorityQueue](#PriorityQueue)

### [String](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html)
[Top 10 questions of Java Strings](http://www.programcreek.com/2013/09/top-10-faqs-of-java-strings/)

```text
int     indexOf(int ch)             //first occurance index
int     lastIndexOf(int ch)         //last occurance index
int     length()

char        charAt(int index)
char[]      toCharArray()
String[]    split(String regex)

String  toLowerCase()
String  toUpperCase()
String  trim()                      //head and tail whitespace trimmed
String  concat(String str)          //concate to the end

boolean startsWith(String prefix)
boolean endsWith(String suffix)

static String   valueOf(X i)        //convert char[], Integer, Object... to String
int n = Integer.parseInt("10");     //convert string to int
```

### [Array](http://www.programcreek.com/2013/09/top-10-methods-for-java-arrays/)

```text
0.Declare an array
String[] aArray = new String[5];
String[] bArray = {"a","b","c", "d", "e"};
String[] cArray = new String[]{"a","b","c","d","e"};

1.Print an array in Java
int[] intArray = { 1, 2, 3, 4, 5 };
String intArrayString = Arrays.toString(intArray);

// print directly will print reference value
System.out.println(intArray);       // [I@7150bd4d
System.out.println(intArrayString);     // [1, 2, 3, 4, 5]

2.Create an ArrayList from an array
String[] stringArray = { "a", "b", "c", "d", "e" };
ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
System.out.println(arrayList);      // [a, b, c, d, e]

3.Check if an array contains a certain value
String[] stringArray = { "a", "b", "c", "d", "e" };
boolean b = Arrays.asList(stringArray).contains("a");
System.out.println(b);      // true

4.Covnert between ArrayList and array
String[] stringArray = { "a", "b", "c", "d", "e" };
ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
String[] stringArr = new String[arrayList.size()];
arrayList.toArray(stringArr);

5.Convert an array to a set
Set<String> set = new HashSet<String>(Arrays.asList(stringArray));
System.out.println(set);    //[d, e, b, c, a]
```
### [ArrayList](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html)

implementation: array. ArrayList is not thread-safe; Vector is thread-safe.

[ArrayList Tutorial](http://www.cnblogs.com/skywang12345/p/3308556.html)

```text
List<Integer> result = new ArrayList<Integer>();
result.add(a);

Iterator iter = list.iterator();
while (iter.hasNext()) System.out.println(iter.next());

for(Iterator iter = list.iterator(); iter.hasNext();) System.out.println(iter.next());

int size = list.size();
for (int i=0; i<size; i++) System.out.println(list.get(i));

for (Integer elem:list) System.out.println(elem);

boolean         add(E object)
boolean         addAll(Collection<? extends E> collection)

boolean         contains(Object object)
boolean         containsAll(Collection<?> collection)
boolean         equals(Object object)
boolean         isEmpty()

Iterator<E>     iterator()

boolean         remove(Object object)
boolean         removeAll(Collection<?> collection)
boolean         retainAll(Collection<?> collection)

int             size()
<T> T[]         toArray(T[] array)
Object[]        toArray()
```

### [LinkedList](https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html)

implementation: Double Linked List

[LinkedList Tutorial](http://www.cnblogs.com/skywang12345/p/3308807.html)

```text
LinkedList list = new LinkedList();

Iterator iter = list.iterator();
while (iter.hasNext()) System.out.println(iter.next());

for(Iterator iter = list.iterator(); iter.hasNext();) System.out.println(iter.next());

int size = list.size();
for (int i=0; i<size; i++) System.out.println(list.get(i));

for (Integer elem:list) System.out.println(elem);

LinkedList可以作为FIFO(先进先出)的队列
LinkedList queue = new LinkedList();
队列方法       等效方法
add(e)        addLast(e)
offer(e)      offerLast(e)
remove()      removeFirst()     //get first and remove
poll()        pollFirst()
element()     getFirst()        //get first without removing
peek()        peekFirst()

LinkedList可以作为LIFO(后进先出)的栈
LinkedList stack = new LinkedList();
栈方法        等效方法
push(e)      addFirst(e)
pop()        removeFirst()
peek()       peekFirst()
```

### [HashMap](https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html)
[Top 9 questions about Java Maps](http://www.programcreek.com/2013/09/top-9-questions-for-java-map/)

No order in keys and values.

```text
HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
map.put(key, value);    //If key exists, overwrite the former one
System.out.println(map.size());

Iterator iter = map.keySet().iterator();
while(iter.hasNext()){
    int key = (int)iter.next();
    int value = (int)map.get(key);
}

for(Entry entry : hashMap.entrySet()) {
    System.out.println(entry.getKey().toString() + " - " + entry.getValue());
}

//0.HashMap is very useful when a counter is required.
HashMap<String, Integer> countMap = new HashMap<String, Integer>();
 
//.... a lot of a's like the following
if(countMap.keySet().contains(a)){
    countMap.put(a, countMap.get(a)+1);
}else{
    countMap.put(a, 1);
}

1. Loop Through HashMap
Iterator it = mp.entrySet().iterator();
while (it.hasNext()) {
    Map.Entry pairs = (Map.Entry)it.next();
    System.out.println(pairs.getKey() + " = " + pairs.getValue());
}
Map<Integer, Integer> map = new HashMap<Integer, Integer>();
for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
}

2. Print HashMap
public static void printMap(Map mp) {
    Iterator it = mp.entrySet().iterator();
    while (it.hasNext()) {
        Map.Entry pairs = (Map.Entry)it.next();
        System.out.println(pairs.getKey() + " = " + pairs.getValue());
        it.remove(); // avoids a ConcurrentModificationException(fast-fail iterator, means could remove during iterate)
    }
}

3. Sort HashMap by Value
//The following code example take advantage of a constructor of TreeMap here.
//There are different ways of sorting HashMap, this way has been voted the most in stackoverflow.
class ValueComparator implements Comparator<String> {
    Map<String, Integer> base;
 
    public ValueComparator(Map<String, Integer> base) {
        this.base = base;
    }
 
    public int compare(String a, String b) {
        if (base.get(a) >= base.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys
    }
}
HashMap<String, Integer> countMap = new HashMap<String, Integer>();
//add a lot of entries
countMap.put("a", 10);
countMap.put("b", 20);

ValueComparator vc =  new ValueComparator(countMap);
TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(vc);

sortedMap.putAll(countMap);
printMap(sortedMap);


boolean containsKey(Object key)
boolean containsValue(Object value)

V       get(Object key)
V       put(K key, V value)     //return old value
V       remove(Object key)      //return the removed value
void    putAll(Map<? extends K,? extends V> m)

Set<Map.Entry<K,V>> entrySet()
Set<K>              keySet()
Collection<V>       values()

int     size()
boolean isEmpty()
```

### [TreeMap](https://docs.oracle.com/javase/7/docs/api/java/util/TreeMap.html)
Order based on key. (Must ensure key has a comparator)
```Java
/*
sh-4.3$ java -Xmx128M -Xms16M HelloWorld
black dog - 15
yellow dog - 20
red dog - 10
white dog - 5
*/
class Dog implements Comparable<Dog>{
    String color;
    int size;
 
    public Dog(String c, int s) {
        color = c;
        size = s;
    }
    public boolean equals(Object o) {
        return ((Dog) o).color.equals(this.color);
    }
 
    public int hashCode() {
        return color.length();
    }
    
    public String toString(){   
        return color + " dog";
    }
    
    public int compareTo(Dog dog){
        return dog.size - this.size;
    }
}

public class TreeMapDemo2{
     public static void main(String []args){
        Dog d1 = new Dog("red", 30);
        Dog d2 = new Dog("black", 90);
        Dog d3 = new Dog("white", 10);
        Dog d4 = new Dog("yellow", 50);
 
        java.util.TreeMap<Dog, Integer> treeMap = new java.util.TreeMap<Dog, Integer>();
        treeMap.put(d1, 10);
        treeMap.put(d2, 15);
        treeMap.put(d3, 5);
        treeMap.put(d4, 20);
 
        for (java.util.Map.Entry<Dog, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
     }
}

```

### [HashTable](https://docs.oracle.com/javase/7/docs/api/java/util/Hashtable.html)

```text
Hashtable<String, Integer> numbers = new Hashtable<String, Integer>();
numbers.put("one", 1);
numbers.put("two", 2);
numbers.put("three", 3);
Integer n = numbers.get("two");
```

### [HashSet](https://docs.oracle.com/javase/7/docs/api/java/util/HashSet.html)

```text
HashSet<Dog> dset = new HashSet<Dog>();
dset.add(new Dog(2));
dset.add(new Dog(1));
dset.add(new Dog(3));
dset.add(new Dog(5));
dset.add(new Dog(4));
Iterator<Dog> iterator = dset.iterator();
while (iterator.hasNext()) {
    System.out.print(iterator.next() + " ");
}

boolean add(E e)
boolean contains(Object o)
boolean isEmpty()
boolean remove(Object o)

int     size()
Iterator<E> iterator()
```

### [Stack](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html)
```text
Stack<Integer> stack = new Stack<Integer>();

boolean empty()
E       peek()  //get first without removing 
E       pop()   //get first and remove
E       push(E item)
```

### [Queue](https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html)
```text
Queue<TreeNode> currLevel = new LinkedList<TreeNode>();
int len = currLevel.size();

boolean add(E e)    //return true is there is enough space, false if no space
boolean offer(E e)
E       peek()      //return top without removing
E       poll()      //remove top and then return it
E       remove()    //remove top and then return it
```

### [PriorityQueue(Heap)](http://docs.oracle.com/javase/7/docs/api/java/util/PriorityQueue.html)
```text
boolean add(E e)
boolean offer(E e)
boolean contains(Object o)
boolean remove(Object o)

E   peek()  //get top without removing
E   poll()  //get top and 

int size()
Object[]    toArray()


Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, listNodeComparator);

private Comparator<ListNode> listNodeComparator = new Comparator<ListNode>(){
    public int compare(ListNode l1, ListNode l2){
        if(l1 == null) return 1;
        else if(l2 == null) return -1;
        return l1.val - l2.val;
    }
};

```

Comparator interface
```text
https://leetcode.com/problems/merge-intervals/

java.util.Collections.sort(intervals, new IntervalComparator());


private class IntervalComparator implements Comparator<Interval>{
    public int compare(Interval p, Interval q){
        return p.start - q.start;
    }
}
```

### [Regular Express](https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html)
[Top 10 Questions for Java Regular Expression](http://www.programcreek.com/2013/10/top-10-questions-for-java-regular-expression/)

```text
// \s is whitespace in regex, and we need \\ to express \ 
s = s.replaceAll("[^a-zA-Z0-9]", "");
```

```text
Object to int
HashSet<Integer> set = new HashSet<Integer>();
Iterator iter = set.iterator();
while(iter.hasNext()){
    int num = (int)iter.next();
}

String to int
int num = Integer.parseInt(iter.next());
```





### Reference

[Top 10 questions about Java Collections](http://www.programcreek.com/2013/09/top-10-questions-for-java-collections/)

[Top 10 Books For Advanced Level Java Developers](http://www.programcreek.com/2013/08/top-books-for-advanced-level-java-developers/)

[8 Things Programmers Can Do at Weekends](http://www.programcreek.com/2012/10/8-things-programmers-can-do-at-weekends/)

[Resources for Preparing Coding Interview](http://www.programcreek.com/2013/02/resources-for-preparing-coding-interview/)

[The Most Widely Used Java Libraries](http://www.programcreek.com/2011/08/the-most-widely-used-java-apis/)

[5 Years Experience from a Java Blog](http://www.programcreek.com/2008/12/5-years-experience-of-java-blogging/)