
###[String](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html)
[Top 10 questions of Java Strings](http://www.programcreek.com/2013/09/top-10-faqs-of-java-strings/)

```Java

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
```

###[Array](http://www.programcreek.com/2013/09/top-10-methods-for-java-arrays/)
待整理
```Java
0. Declare an array
String[] aArray = new String[5];
String[] bArray = {"a","b","c", "d", "e"};
String[] cArray = new String[]{"a","b","c","d","e"};

1. Print an array in Java
int[] intArray = { 1, 2, 3, 4, 5 };
String intArrayString = Arrays.toString(intArray);
 
// print directly will print reference value
System.out.println(intArray);
// [I@7150bd4d
 
System.out.println(intArrayString);
// [1, 2, 3, 4, 5]

2. Create an ArrayList from an array
String[] stringArray = { "a", "b", "c", "d", "e" };
ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
System.out.println(arrayList);
// [a, b, c, d, e]

3. Check if an array contains a certain value
String[] stringArray = { "a", "b", "c", "d", "e" };
boolean b = Arrays.asList(stringArray).contains("a");
System.out.println(b);
// true

4. Concatenate two arrays
int[] intArray = { 1, 2, 3, 4, 5 };
int[] intArray2 = { 6, 7, 8, 9, 10 };
// Apache Commons Lang library
int[] combinedIntArray = ArrayUtils.addAll(intArray, intArray2);

5. Declare an array inline
method(new String[]{"a", "b", "c", "d", "e"});

6. Joins the elements of the provided array into a single String
// containing the provided list of elements
// Apache common lang
String j = StringUtils.join(new String[] { "a", "b", "c" }, ", ");
System.out.println(j);
// a, b, c

7. Covnert an ArrayList to an array
String[] stringArray = { "a", "b", "c", "d", "e" };
ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(stringArray));
String[] stringArr = new String[arrayList.size()];
arrayList.toArray(stringArr);
for (String s : stringArr)
    System.out.println(s);

8. Convert an array to a set
Set<String> set = new HashSet<String>(Arrays.asList(stringArray));
System.out.println(set);
//[d, e, b, c, a]

9. Reverse an array
int[] intArray = { 1, 2, 3, 4, 5 };
ArrayUtils.reverse(intArray);
System.out.println(Arrays.toString(intArray));
//[5, 4, 3, 2, 1]

10. Remove element of an array
int[] intArray = { 1, 2, 3, 4, 5 };
int[] removed = ArrayUtils.removeElement(intArray, 3);//create a new array
System.out.println(Arrays.toString(removed));

One more - convert int to byte array
byte[] bytes = ByteBuffer.allocate(4).putInt(8).array();
 
for (byte t : bytes) {
   System.out.format("0x%x ", t);
}
```

###[LinkedList](https://docs.oracle.com/javase/7/docs/api/java/util/LinkedList.html)
Double Linked List

```Java

LinkedList可以作为FIFO(先进先出)的队列
队列方法       等效方法
add(e)        addLast(e)
offer(e)      offerLast(e)
remove()      removeFirst()
poll()        pollFirst()
element()     getFirst()
peek()        peekFirst()

LinkedList可以作为LIFO(后进先出)的栈
栈方法        等效方法
push(e)      addFirst(e)
pop()        removeFirst()
peek()       peekFirst()


for(Iterator iter = list.iterator(); iter.hasNext();)
    iter.next();

for (Integer integ:list) 
    ;

int size = list.size();
for (int i=0; i<size; i++) {
    list.get(i);        
}
```

###[ArrayList](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html)
```Java
List<Integer> result = new ArrayList<Integer>();
result.add(a);

Integer value = null;
Iterator iter = list.iterator();
while (iter.hasNext()) {
    value = (Integer)iter.next();
}

Integer value = null;
int size = list.size();
for (int i=0; i<size; i++) {
    value = (Integer)list.get(i);        
}

Integer value = null;
for (Integer integ:list) {
    value = integ;
}
```

###[HashMap](https://docs.oracle.com/javase/7/docs/api/java/util/HashMap.html)
[Top 9 questions about Java Maps](http://www.programcreek.com/2013/09/top-9-questions-for-java-map/)

```Java
HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
map.put(key, value);    //If key exists, overwrite the former one

Iterator iter = map.keySet().iterator();
while(iter.hasNext()){
    int key = (int)iter.next();
    int value = (int)map.get(key);
}

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

###[HashTable]()

###[HashSet]()

###[Stack]()

###[Queue](https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html)
```Java
Queue<TreeNode> currLevel = new LinkedList<TreeNode>();
int len = currLevel.size();
boolean add(E e)    //return true is there is enough space, false if no space
boolean offer(E e)
E       peek()      //return top without removing
E       poll()      //remove top and then return it
E       remove()    //remove top and then return it
```
###[PriorityQueue(Heap)]()


###[Regular Express](https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html)
[Top 10 Questions for Java Regular Expression](http://www.programcreek.com/2013/10/top-10-questions-for-java-regular-expression/)





[Top 10 questions about Java Collections](http://www.programcreek.com/2013/09/top-10-questions-for-java-collections/)
[HashMap vs. TreeMap vs. Hashtable vs. LinkedHashMap](http://www.programcreek.com/2013/03/hashmap-vs-treemap-vs-hashtable-vs-linkedhashmap/)
[ArrayList vs. LinkedList vs. Vector](http://www.programcreek.com/2013/03/arraylist-vs-linkedlist-vs-vector/)

[Top 10 Books For Advanced Level Java Developers](http://www.programcreek.com/2013/08/top-books-for-advanced-level-java-developers/)
[8 Things Programmers Can Do at Weekends](http://www.programcreek.com/2012/10/8-things-programmers-can-do-at-weekends/)
[Resources for Preparing Coding Interview](http://www.programcreek.com/2013/02/resources-for-preparing-coding-interview/)
[The Most Widely Used Java Libraries](http://www.programcreek.com/2011/08/the-most-widely-used-java-apis/)
[5 Years Experience from a Java Blog](http://www.programcreek.com/2008/12/5-years-experience-of-java-blogging/)