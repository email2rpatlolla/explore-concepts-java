# This page needs further edits - Made changes only for interview purpose


### Virtual Threads

* Virtual threads are lightweight threads managed by the JVM
* Traditional java threads are Operating System level platform threads which are
  * Each of the traditional thread needs one OS thread, a one to one mapping is established. So each thread blocks one OS thread
  * The number of threads will be limited by the number OS threads
  * Expensive in memory (Stack Size)
  * Context switch between the threads is slow 
* When a virtual thread encounters a blocking I/O operation (like waiting for the network response in fetchData), it doesn't block the underlying OS thread. Instead, the virtual thread is unmounted from the carrier OS thread, allowing the OS thread to be used by other running virtual threads. Once the I/O operation completes, the virtual thread is remounted onto an available OS thread to continue its execution.
* Benefits of Virtual Threads
  * Application can handle more concurrent requests - High Throughput
  * Scalability
  * Efficient use of system resources
  * Less memory usage
* In a sample test case where 10000 threads are executed with each thread having sleep time of 1 second
  * Traditional thread pool with 100 threads took around 101 seconds
  * Virtual threads took less than 2 seconds

### Sequenced Collections

* Sequenced Collections are introduced to create collections that preserves the insertion order 
  * With clear semantics (Like a clear contract)
  * New APIs to access first and last elements

    ```java
    SequencedCollection<String> list = new ArrayList<>();
    SequencedCollection<String> set = new LinkedHashSet<>();
    SequencedMap<String, Integer> map = new LinkedHashMap<>();
    ```
    ```java
        SequencedSet<String> sequencedSet = new LinkedHashSet<>();

        sequencedSet.add("red");
        sequencedSet.add("green");
        sequencedSet.addFirst("white");
        sequencedSet.addFirst("green");
        sequencedSet.addLast("blue");
        sequencedSet.add("yellow");
        sequencedSet.add("red"); // Will not alter the position as it already exists
        
        System.out.println("Sequenced Set: " + sequencedSet); // [green, white, red, blue, yellow]
    ```
* add() and addLast() will not show any difference if the element is not present in the Set collection. But if element is already present
  * add() - will do nothing
  * addLast() - Will make the element as the last element in the collection

### Pattern Matching for switch
* Refer java17 release notes [java17 Concepts](./java17.md)

### Record Patterns
* It is a pattern matching concept that also destruct the Record, so no need to access record fields separately

```java
    record Address(String street, String city) {}
    record Person(String name, int age, Address address) {}

    Object obj = new Person("Alice", 30, new Address("123 Main St", "Sandy Springs"));

    if (obj instanceof Person(String n, int a, Address(String s, String c))) {
        System.out.println("Name: " + n + ", Age: " + a + ", City: " + c);
    }
    if (obj instanceof Person(String n, int a, Address(String s, String c)) && a > 18) {
        System.out.println(n + " is over 18 and lives in " + c);
    }
```
```java
    sealed interface Shape {}
    record Circle(double radius) implements Shape {}
    record Rectangle(double width, double height) implements Shape {}

    public static double getArea(Shape s) {
        return switch (s) {
            case Circle(double r) -> Math.PI * r * r;
            case Rectangle(double w, double h) -> w * h;
        };
    }
```

### String Templates (Preview)
* Allows embedding of expressions within string literals eliminating different concat or append complexities

```java
    String name = "Alice";
    int age = 30;
    String message = STR."Hello, \{name}! You are \{age} years old.";
    System.out.println(message); // Output: Hello, Alice! You are 30 years old.
    String message = STR."The user says: \{user.getGreeting()}"; // We can call methods too
    System.out.println(message); // Output: The user says: Hello, Bob!

    int width = 10;
    int height = 5;
    String areaMessage = STR."The area is \{width * height} square units.";
    System.out.println(areaMessage); // Output: The area is 50 square units.

    java.time.LocalDate date = java.time.LocalDate.now();
    String formattedDate = STR."Today's date is \{date:%tD}";
```
* When we use void method in String template, the method will be called but the resulting string uses null as return value for the method
 ```java

    String message = STR."The user says: \{user.setGreeting()}"; // We can call methods too
    System.out.println(message); // Output: The user says: null

``` 

### Scoped Values (Preview)


### Unnamed Classes and Instance main Methods (Preview)
A simple "script-like" Java program without the need to declare a formal class with a static main method.

```java
    void main() {
        System.out.println("Hello, World!");
    }
```

* Launch protocol use the following main method priorities
  * A static void main(String[] args) method of non-private access declared in the launched class
  * A static void main() method of non-private access declared in the launched class
  * A void main(String[] args) instance method of non-private access declared in the launched class or inherited from a superclass
  * A void main() instance method of non-private access declared in the launched class or inherited from a superclass

### Unnamed Patterns and Variables (Preview)
* A pattern variable or a variable which are initialized but never used can be denoted with the _ character
* Using Unnamed pattern and variables, we no need to define the type and name for a variable which is not used in the subsequent code
* _ keyword is allowed to declare 
  * Unnamed patterns
  * Local variables
  * Exception parameters
  * Lambda parameters

* Unnamed pattern examples:
```java
    //------------Switch example
    void printSalary(Employee b) {
        switch (b) {
            case Salaried r   -> System.out.println("Salary: " + r.salary());
            case Freelancer _, Intern _  -> System.out.println("No Salary");
            case null  -> System.out.println("Invalid type"); // Unnamed variable
        }
    }
    Object obj = 10;
    switch (obj) {
        case String s -> System.out.println("It's a string: " + s);
        case Integer i -> System.out.println("It's an integer: " + i);
        case _ -> System.out.println("Something else."); // Exactly same as default, we cannot place default and _ both
    }
    //----------------instanceof example
    if (obj instanceof String _) {
        System.out.println("It's a String");
    }

//------------record patterns
    record Point(int x, int y) {}
    Point p = new Point(10, 20);
    if (p instanceof Point(int x, _)) {
        System.out.println("The x-coordinate is: " + x);
        // We don't need the y-coordinate
    }
    switch (p) {
        case Point(0, int y) -> System.out.println("On the y-axis, y = " + y);
        case Point(int x, _) -> System.out.println("x = " + x);
        default -> System.out.println("Neither on x nor y axis.");
    }
```


* Unnamed pattern cannot be used as top level pattern
```java
        if (obj1 instanceof _) { // compilation error
            // ...
        }
```

* Unnamed variables examples
```java
    var _ = new ArrayList();
    try (var _ = new FileReader(path)) {
       int[] orderIDs = {34, 45, 23, 27, 15};
        int total = 0;
        for (int _ : orderIDs) {
            total++;
        }
    } catch(IOException _) {

    }
```



### References

https://docs.oracle.com/en/java/javase/21/language/unnamed-variables-and-patterns.html 