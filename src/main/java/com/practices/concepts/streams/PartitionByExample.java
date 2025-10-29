package com.practices.concepts.streams;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PartitionByExample {
	
	public static void main(String[] args) {
		List<Integer> intList = List.of(1,2,3,4,5,6,7,8);
		
		var result = intList.stream()
				.collect(
						Collectors.partitioningBy(x-> x %2 ==0));

		System.out.println(result);
	}

}
