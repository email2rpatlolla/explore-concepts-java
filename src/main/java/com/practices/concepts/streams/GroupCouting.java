package com.practices.concepts.streams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupCouting {

	public static void main(String[] args) {
		
		var name = "Learning Java Streams";
		
		var mName = Optional.ofNullable(name)
			.map(x -> x.replace(" ", ""))
			.map(String::toLowerCase)
			.orElse("");
		
		System.out.println(Arrays.stream(mName.split("")).collect(Collectors.groupingBy(x -> x)));
		
		var result = Arrays.stream(mName.split(""))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(result);


		
		System.out.println(Collections.max(result.entrySet(), Map.Entry.comparingByValue()));
        System.out.println(Collections.min(result.entrySet(), Map.Entry.comparingByValue()));
        System.out.println(result.entrySet().stream().max(Map.Entry.comparingByValue()));



        var x = result.entrySet().stream()
                .collect(Collectors.groupingBy(
                        entry -> entry.getValue(),
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ));

        var y = result.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getValue(),
                        entry -> entry.getKey(), (oldKey, newKey) -> newKey));
        System.out.println(x);
        System.out.println(y);
	}

}
