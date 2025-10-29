### Streams

A stream process in java consist of 3 parts. They are
* Data source
* Intermediate operations/methods
* Terminal operations

##### Data source: 
* Provides the input to the stream pipeline
  
##### Intermediate operations:
* Intermediate operations are to perform processing on the stream data element by element
* These are lazy operations. Until a terminal operation is called on the stream, these will not evaluate
* Examples: map(), flatmap(), peek(), filter() etc 

Intermediate operations are again two types
* Stateless operations
* Stateful operations

_Stateless operations_: 
* Each element in the stream can be processed independent of other elements in the stream. They don't need any data and no need to maintain any state related to previously processed element to process the current element 
* Examples: map(), filter() etc...

_Stateful operations_: 
* The current processing element need data about the preciously processed element. They need data and should maintain state related to previously processed element to process the current element 
* Examples: sorted(), distinct() etc...
* These stateful operations need to process the entire input before producing the output.

###### Stateful operation VS Stateless operations:
* Stateful operations will break the stream optimization where as stateless operations will be evaluated based on the terminal operation
* Example: When findFirst() is called on a stream 
  * Irrespective of number of map and filter operations involved, stream is evaluated to return only first element result 
  * If we add sorted, then stream should process all the stream elements in natural sorting order and then return the first result.
* Use case:
    ```
    Stream.of("foo", "bar", "Alice", "Bob", "Carol")
    .filter(str -> !str.contains("r")) // lazy processing
    .peek(System.out::println)
    .map(String::toUpperCase)          // lazy processing
    .peek(System.out::println)
    .sorted()                          // <--- all data is being dumped into memory
    .peek(System.out::println)
    .filter(str -> str.length() > 3)   // lazy processing
    .peek(System.out::println)
    .findFirst();                      // <--- the terminal operation    
    ```
* In the above example, first filter and map will filter and map each element of the stream as sorted need all the elements. Once the sorted is completed, the remaining operations will perform on one of the element in the stream to return the first matching element
* If sorted is not used, then all the operations will be performed on the first matching item
* One exemption to the sorted() method can be seen in the below methods section

  
##### Terminal operations: 
* This is end of the stream which will give the result of the stream after processing it
* This operation will invoke the intermediate operations
* Examples: anyMatch(), noneMatch(), findFirst(), reduce(), collect() etc 
* Terminal operations that terminates the operation early (anyMatch, findFirst) are called **Short Circuiting** operations

### Important Methods:
#### peek()
* peek() is an intermediate operation in Java8 streams
* peek() helps in debugging the elements in a stream pipeline
* It is also useful to modify the stream element without returning it like map

##### Difference between peek() and map()
* map() is to perform transformations on the stream data where as peek() is to view the contents of the stream 
* A map should return the transformed element where as peek can be used to modify the property value without returning it.
* map can return a new type of object where as peek cannot

#### sorted()
* Refer the Stateful operation VS Stateless operations section
* sorted() method will make the stream as eager processing, but it will not in case the stream contents are already using the sorted structure
* IntStream.range(), will have the elements already in sorted way. So sorted will get the first element
* Stream on TreeSet where elements are already sorted, sorted will get the first element

### Difference between Stream of Integers and IntStream
* Stream of Integers will gives us boxed Integer values where as IntStream will produce stream of primitive int values
* IntStreams are faster in performance and occupies less space. 
  * Integers are boxed values of primitives. Boxing and unboxing requires some time along with garbage collection time
  * An int occupies 4 bytes where are Integer occupies 20 bytes (4 for reference + 16 for value)
* IntStream will have few methods specific to handle int values like sum(), average(), boxed() etc


