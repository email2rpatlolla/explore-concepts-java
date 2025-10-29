# This page needs further edits - Made changes only for interview purpose


### String

New methods are introduced in String class

* strip, stripLeading, stripTrailing:
  * strip methods are used to remove whitespace characters from the leading and trailing part fo the string
  * It is similar to trim, but it will replace unicode whitespace characters as well
  * Internally, it uses Character.isWhitespace()  
    ```
    System.out.println("\n\t  Raja   \u2005".trim()); // Raja   \u2005
    System.out.println("\n\t  Raja   \u2005".strip()); // Raja
    ```
* isBlank:
  * It will check whether String is empty or not, will return true even if it contains all whitespace characters.
  * It can identify whitespace unicode characters as well
    ```
    System.out.println("\n\t\u2005  ".isBlank()) // true
    ```
* lines
  * This method will create a List of stream from the given string with the line terminations
  * A line terminator is one of the following: “\n”, “\r”, or “\r\n”.
    ```
    String multilineStr = "This is\n \n a multiline\n string.";

    long lineCount = multilineStr.lines()
      .filter(String::isBlank)
      .count();
    ```
* repeat
  * This method helps in repeating a string configurable number of times
    ```
    System.out.println("Hello ".repeat(3) + "Raja") // Hello Hello Hello Raja
    ```

### Files

Introduced new methods to read the string content from a file (Files.readString) and to write string content to a file (Files.writeString)


### Collection 

A new method toArray(x) is introduced to convert a collection type to an array

### not Predicate method

### Local variable syntax 

### HttpClient
* This http client library is introduced as preview feature in JDK 9 is standardized in Java 11

### Running java 
* No need to compile a java class. We can execute java command on .java file itself
```
java HelloWorld.java
```