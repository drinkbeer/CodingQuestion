
###[String](https://docs.oracle.com/javase/7/docs/api/java/lang/String.html)

```Java
char    charAt(int index)
String  concat(String str)          //concate to the end
boolean startsWith(String prefix)
boolean endsWith(String suffix)
int     indexOf(int ch)             //first occurance index
int     lastIndexOf(int ch)         //last occurance index
int     length()
String[]    split(String regex)
char[]  toCharArray()
String  toLowerCase()
String  toUpperCase()
String  trim()                      //head and tail whitespace trimmed
static String   valueOf(X i)        //convert char[], Integer, Object... to String

```

###[Array]()

###[Queue](https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html)
```Java
boolean add(E e)    //return true is there is enough space, false if no space
boolean offer(E e)
E       peek()      //return top without removing
E       poll()      //remove top and then return it
E       remove()    //remove top and then return it
```

###[Regular Express](https://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html)

