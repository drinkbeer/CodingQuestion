##Java Questions

###Data Types
####Primitive Types：8 types
    | Primitive Type |  Length  |       Range       |
    |----------------|----------|-------------------|
    |   byte         |    1B    | -128 ~ 127        |
    |   short        |    2B    | -2^15 ~ 2^15-1    |
    |   int          |    4B    | -2^31 ~ 2^31-1    |
    |   long         |    8B    | -2^63 ~ 2^63-1    |
    |   float        |    4B    |                   |
    |   double       |    8B    |                   |
    |   char         |    2B    |                   |
    |   boolean      |    1B    |  true/false       |

###Java Keywords
1. Access modifiers

    | modifier | access in same class | access in same package | access in different package |
    | -------- | -------------------- | ---------------------- | --------------------------- |
    | private  |          yes         |         no             |          no                 |
    | default  |          yes         |         yes            |          no                 |
    | protected|          yes         |         yes            |     only in extend class    |  
    | public   |          yes         |         yes            |         yes                 |

2. Static
    + everything declared as `static` is related to class rather than object
    + can be declared before variable, method, not class
        - variable: multiple object of the class share the same instance of static variable
        - method: static can only call static method and access to static variables, but non-static method can call static method
    + use 'ClassName.ObjectName' to access to the object, object could be attributes, function, etc
    + static object will be instanced when the class is created, not in object is created

3. Final
    + can be declared before variable, method, class, object
    + if assigned
        - variable: behave like a constant and connot change value
        - method: cannot be overridden in its child class
        - class: no other class can extend it
        - object: only instantiate once

###Concepts
1. `object` vs. `class`
    + an object is an instance of a class
    + every object must belong to a class
    + object only live in a limited time, class doesn't have lifespan
    + properties of objects can change while they live

2. `static` and `instance` method
    + static method
        - belong to class itself
        - static binding
        - JVM selects the method to invoke based on the actual class of the object, known at compile time
    + instance method
        - belong to the instance of a class and require instantiate before it can be called
        - dynamic binding
        - JVM selects the method to invoke based on the type of object reference, known at run time

3. `abstract class` and `interface`
    + abstract class
        - contain at least one abstract method
        - can contain nubers of concrete methods
        - variable can be public, private, protected, default, or constants
        - a class can only extend one abstract class
        - not compulsory to implement all methods
        - if want to add a new feature, simply implement in the abstract class and call it from subclass
    + interface
        - only contain abstract methods
        - variable is by default `public final`, 
        - a class can implement multiple interfaces
        - compulsory to implement all methods
        - if want to add a new feature, need to implement the method in all classes implementing the interface

4. `instanceof` and `isInstance(Object obj)`
    + instanceof is a keyword but isInstance() is a method
    + instanceof checks whether the object is type of particular class or subclass
    + isInstance() only used to identify if object is of a particular class

5. pass by value and pass by reference
    + Java only supports pass by value, actual value is passed
    + Java passes the references by value, the pointer to the object is passed by value
    + references passed to the method are actually copies of the original references

6. `==` and `equals()`
    + == is used to compare the references of the objects
    + equals() can compare the values of two objects

7. `StringBuffer` and `StringBuilder`
    + StringBuffer is synchronized, but StringBuilder is not

8. `final`, `finally`, `finalize()`
    + final: a final variable acts like constant, a final method cannot be overriden, a final class is immutable
    + finally: handles exception, clean up after try block
    + finalize(): method helps in garbage collection, invoked before an object is discarded by the garbage collector, allowing it to clean up its state

9. object reflections
    + provide a way to get reflective information of class and object
    + perform operations such as
        - get information about methods and fields present inside the class at runtime
        - get a new instance of a class
        - get and set object fields directly by getting field reference, regardless what the access modifier is
    + advantage
        - help in observing or manipulating runtime behavior
        - help in debugging or testing programs
        - can call method by name when we do not know the method in advance

10. heap memory vs. stack memory
    + heap memory is memory that allocated to objects and classes
        - when an object is created, it is in heap memory
        - garbage collection runs on heap memory to free the memory of object without any reference
    + stack memory is memory that allocated to a funciton
        - hold local primitives, reference to other objects
        - created when function created; once the function returns, the stack memory is closed

###OOP
1. [polymorphism](http://www.java-made-easy.com/polymorphism-in-java.html)
    + define more than one function with the same name
    + compile time polymorphism(overloading) and runtime polymorphism(overriding)
    + [override](http://www.programcreek.com/2009/02/overriding-and-overloading-in-java-with-examples/): two methods with same name and parameters, but one in parent class, one in child class
        - `real object`, not `reference type` determines which overridden method is called at `run time`
    + overload: two or more methods in one class with same name, but different parameters
        - `reference type` deptermines which overloaded method is called at `compile time`

2. inheritance
    + allow a child class to inherit some properties from its parent class
    + use `extend` keyword
    + only public and protected access modifiers can be accessed in child class

3. multiple inheritance
    + Java does not support multiple inheritance
    + dismond problem
    + use of multiple interfaces (or extend a class and implement some interfaces)

4. encapsulation
    + achieved by combining the methods and attribute into a class
    + class acting like a container encapsulation the properties
    + hide how things work and expose the user requests

###Collections
1. ArrayList and Vector
    + synchronization
        - ArrayList is not thread-safe, but Vector is
        - each method in vector class is surrounded by synchronized block
    + data growth
        - both use arrays to store contents in underlying implementation
        - enlarge array if not enough space
    + performance
        - Vector is slower than ArrayList because of thread-safe

2. Sort objects in lists
    + implement Comparable interface for the object class and override compareTo() method
    + if object class is a jar file, create Comparator and override compare() method
    + call Collection.sort()

3. HashMap and HashTable
    + HashMap is not synchronized, but HashTable is
    + use Iterator for HashMap(fail-safe) and enumerator for HasbTable(not fail-safe)
    + HashMap allows null values and only one null key; HashTable does not allow null value and null key

4. List interface
    + ArrayList
        - resizable array implementation
        - dynamic size
        - not thread-safe
    + Vector
        - ArrayList implementation
        - thread-safe
    + LinkedList
        - also implements Queue interface
        - FIFO
        - faster for insertion and deletion(if know position)

5. Set interface
    + SortedSet
        - interface extends Set
        - allow data to be sorted
        - all elements inserted must implement Comparator or Comparable interface
    + TreeSet
        - implementation of SortedSet interface
        - O(logn) time for add, remove, contains operations
        - not synchronized
    + HashSet
        - implements Set interface
        - back up by hash table
        - no guarantee on constant order
        - allow null element
        - O(1) time for add, remove, contains

5. array and ArrayList
    + array is fixed size but ArrayList is dynamic
    + elements in ArrayList can be added or removed at runtime
    + array contains elements of same type but ArrayList can contain elements of different type

6. ArrayList and LinkedList
    + both fast in insertion, inserting into ArrayList and into first position of LinkedList takes O(1) time
    + random lookup in ArrayList is fast, but slow in LinkedList
    + remove is slow for ArrayList(elements need to be shifted) but fast for LinkedList

7. Advantage of iterator
    + used when no clue about object type
    + iterator allows updates

8. Preferred delcaration
    + `List<String> list = new ArrayList<String>()` not `ArrayList<String> list = new ArrayList<String>()`
    + because function may take List as parameter
    + more flexible

9. iterator access and index access
    + insert, update or delete is faster for iterator access for elements in middle of the structure
    + insert, update or delete is faster for index access for elements at the end
    + search is fast for index access

###Threading
1. Thread vs. Process
    + definition
        - process: executing instance of an application
        - thread: a path of execution within a process
    + relationship
        - a process can contain multiple threads
        - thread considered as lightweight process
    + comparison
        - thread for small tasks, process for heavy tasks
        - thread within the same process share the same address space(allow threads to read and write data to the same structure and variables, allow communication between threads), but different processes do not
        - threads are easier to create than processes because they do not require a separate address space
        - multi-threading: be careful that threads share structures that should be modified by one thread at a time
        - processes are independent of each other
