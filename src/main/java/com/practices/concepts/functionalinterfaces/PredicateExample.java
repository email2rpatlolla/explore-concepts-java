package com.practices.concepts.functionalinterfaces;

import java.util.function.Predicate;

public class PredicateExample {

	public static void main(String[] args) {
		
		Predicate<Integer> gt20NumberPred = num -> num > 20;
		
		System.out.println("Is the number greater than 20?: " + gt20NumberPred.test(25));
		System.out.println("Is the number greater than 20?: " + gt20NumberPred.test(2));
		System.out.println("Is the number less than 20?: " + gt20NumberPred.negate().test(2));
		
		Predicate<Integer> evenNumberPred = num -> num % 2 == 0;
		
		System.out.println("Is the number greater than 20 && even?: " + gt20NumberPred.and(evenNumberPred).test(28));
		
		System.out.println("Is the number greater than 20 && even?: " + gt20NumberPred.and(evenNumberPred).test(23));
		
		System.out.println("Is the number greater than 20 && even?: " 
				+ ((Predicate<Integer>)(num -> num > 20)).and((Predicate<Integer>)(num -> num % 2 == 0)).test(121));
	}

}
