package com.practices.concepts.functionalinterfaces;

/*
*  The behavior of lambda function will not depend on the FunctionalInterface.
*  Irrespective of the annotation, as long as it has only one abstract method, it is treated as functional interface
*
* Adding FunctionalInterface is to make sure only one abstract method exists.
*   1. If someone trying to add another abstract method, it will give compilation error
*   2. This will stop all the errors with lambda functions
* */
@FunctionalInterface
public interface CustomFunctionalInterface {
    int incrementCounter(int counter);

}

class Test {
    public static void main(String[] args) {
        CustomFunctionalInterface cfi = (n) -> n+1;
        System.out.println(cfi.incrementCounter(5));
    }
}
