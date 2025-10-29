# This page needs further edits - Made changes only for interview purpose



### Sealed Classes

To restrict which classes can extend or implement the current class or interface

  ```java
    public sealed class Animal permits Dog, Cat, Bird {}
    public final class Dog extends Animal {}
    public final class Cat extends Animal {}
    public non-sealed class Bird extends Animal {}
  ```

1. The permitted subclasses of a sealed class must be either sealed, final or non-sealed. 
2. A sealed class can be declared without **permits** clause. In such case, all it's sub classes should be in the same compilation unit (source file)
3. Rules for sub classes location
   * They must be in same module as sealed class if it is in a named module
   * They must be in same package as sealed class if it is in unnamed module
   * They must be in same file if sealed class is without permits keyword
4. A sealed class without any subclass or permits throws **compilation error** (It was allowed in JDK 15 & 16 but removed from JDK 17)
5. **non-sealed** allows a regular class/interface to extend/implement from the permitted class/interface without any restrictions
6. **Key methods** in Class class related to sealed classes
   * ClassDesc[] permittedSubclasses()
   * boolean isSealed()

A usecase of sealed class:

  ```java
      public class PaymentProcessor {
          public void process(PaymentMethod method) {
              switch (method) {
                  case CreditCard cc -> System.out.println("Processing credit card");
                  case PayPal pp -> System.out.println("Processing PayPal");
                  case BankTransfer bt -> System.out.println("Processing bank transfer");
                  // No default needed — Java knows we've handled all cases!
                  case null -> System.out.println("No transfer"); //Optional case
              }
          }
      }
  ```
* In the above use case, PaymentMethod is a sealed class, CreditCard, PayPal, BankTransfer are subclasses
* No need to add default case when sealed class is used with switch
* If we don't have any case for the sub class type, then it throws compilation error
* null case is also optional, but can be used to avoid NullPointerException
* The switch pattern matching is in preview mode in JDK 17. It will work in JDK 21 without any issues

### Switch Expressions
* Traditional switch (case with break statements) is switch statement, but new switch with advanced features is switch expression
* switch statement cannot return a value, but switch expression can
* We cannot mix switch statement and switch expression together
* switch expression can have multiple case labels
  ```java
      case 1, 2, 3 -> System.out.println("Low range");
  ```
##### Does Switch Expression replaces switch statements? No
* switch expressions are useful when we need output from it
* switch statements are useful for side effects or flow control (Like executing void methods)

### Pattern Matching instanceof

1. Scope of pattern variables
   ```java
     public static double getPerimeter(Shape shape) {
        if (shape instanceof Rectangle s) {
            // You can use the pattern variable s (of type Rectangle) here.
        } else if (shape instanceof Circle s) {
            // You can use the pattern variable s of type Circle here
            // but not the pattern variable s of type Rectangle.
        } else {
            // You cannot use either pattern variable here.
        }
    }
   ```
2. Using pattern variable within the same if
   ```java
      // It will work
      if (shape instanceof Rectangle r && r.length() > 5) {
                // ...
            }
   ```
    ```java
    // It will give compilation error
      if (shape instanceof Rectangle r || r.length() > 5) {
              // ...
      }
   ```



### Pattern Matching for switch - Preview

1. Pattern Matching 

```java
    return switch (obj) {
        case Integer i -> "Integer: " + i;
        case String s  -> "String: " + s;
        case Double d  -> "Double: " + d;
        case null      -> "Null object";
        default        -> "Unknown";
    };
```
* Using null case is optional, not mandatory
* If we don't write the null case, but the obj is null, then it will throw null pointer exception irrespective of default is added

1. Multiple types in one case

```java
  case Integer i, Long l, Short s -> "Some kind of integer number";
```

3. Guarded Patterns - Conditions in case labels

```java
    static String classifyInteger(Object obj) {
    return switch (obj) {
        case Integer i when i > 0 -> "Positive Integer";
        case Integer i when i < 0 -> "Negative Integer";
        case Integer i            -> "Zero";
        default                   -> "Not an Integer";
    };
}

```

4. Parenthesized Patterns - Surrounding case labels with Parenthesis
   
```java
    static Function<Integer, String> testParen(Object obj) {
        boolean b = true;
        return switch (obj) {
            case (String s && b) -> t -> s; // First arrow part of case
            default              -> t -> "Default string";
        };
    }
```

5. case blocks with **yield**

```java
    String result = switch (value) {
        case 1 -> "One";
        case 2 -> "Two";
        default -> {
            // some logic here
            yield "Other";
        }
    };

```

* yield key word can be used to return a value from case block with more than one statements
* **Why yield and not return**: Using the return statement will be returned as method result and control exists from the method. Using yield will returns the value of switch expression to variable.

6. Pattern label dominance
   ```java
          static void error(Object obj) {
        switch(obj) {
            case CharSequence cs ->
                System.out.println("A sequence of length " + cs.length());
            case String s ->    // Error - pattern is dominated by previous pattern
                System.out.println("A string: " + s);
            default ->
                throw new IllegalStateException("Invalid argument");  
        }
    }
   ```
7. 

### java.util.random - New package 
* Provides a more flexible and extensible random number generation framework.
* Support for Random number generation with multiple algorithms
  ```java
    RandomGenerator rng = new L64X128MixRandom();
    int num = rng.nextInt(100);  // Generates a random number from 0 to 99
  ```
* The class names are unique based on the underlying algorithm 
  * L32X64MixRandom: A 32-bit LCG (Linear Congruential Generator) mixed with 64-bit XOR-based random generation.
  * L64X128MixRandom: A 64-bit LCG mixed with 128-bit XOR-based random generation.
  * Xoshiro256PlusPlus: Xorshift family
  * L64X128StarStarRandom, Xoroshiro128PlusPlus are 2 other new classes
  * SplittableRandom and Random are from previous versions

### ZGC and Shenandoah Garbage Collectors



ST22OT72523 - Udemy course coupon code

https://digital.fidelity.com/ftgw/digital/secureemail 

Turbine - For microservices to communicate with Hystrix dashboard


User Community:VZNE
CIM Worker Number:7683983
PIN:5481
VZID: patlora


Code with kepler
Code with katy