package com.practices.concepts.streams;

import static java.util.stream.Collectors.*;

import java.util.Comparator;

import com.practices.pojo.Employee;

public class GroupingByUseCases {
	
	public static void main(String[] args) {
		
		var list = Employee.createEmployeeList();
		
		var groupByDept = list.stream()
				.collect(groupingBy(Employee::getDept));
		
		System.out.println("Group by dept: "+ groupByDept);
		
		var teamsInDept = list.stream()
				.collect(groupingBy(Employee::getDept, mapping(Employee::getTeam, toSet())));
		
		System.out.println("Teams in the dept: "+ teamsInDept);
		
		var groupByDeptTeam = list.stream()
				.collect(groupingBy(Employee::getDept, groupingBy(Employee::getTeam)));
		
		System.out.println("Group by dept and team: "+ groupByDeptTeam);
		
		var countByDept = list.stream()
				.collect(groupingBy(Employee::getDept, counting()));
		
		System.out.println("Count by dept: "+ countByDept);
		
		var salariesByDept = list.stream()
				.collect(groupingBy(Employee::getDept, summingDouble(Employee::getSalary)));
		
		System.out.println("Total Salaries by dept: "+ salariesByDept);
		
		var avgSalariesByDept = list.stream()
				.collect(groupingBy(Employee::getDept, averagingDouble(Employee::getSalary)));
		
		System.out.println("Average Salaries by dept: "+ avgSalariesByDept);
		
		var minSalaryByDept = list.stream()
				.collect(groupingBy(Employee::getDept, minBy(Comparator.comparing(Employee::getSalary))));
		
		System.out.println("Min Salary by dept: "+ minSalaryByDept);
		
		var maxSalaryByDept = list.stream()
				.collect(groupingBy(Employee::getDept, maxBy(Comparator.comparing(Employee::getSalary))));
		
		System.out.println("Max Salary by dept: "+ maxSalaryByDept);
		
		var nonEmptyAddressCountByDept = list.stream()
				.collect(groupingBy(Employee::getDept, filtering(x -> !x.getAddresses().isEmpty(), counting())));
		System.out.println("Count of emp addresses by each dept: "+ nonEmptyAddressCountByDept);
		
		var nonEmptyAddressByDept = list.stream()
				.collect(groupingBy(Employee::getDept, filtering(x -> !x.getAddresses().isEmpty(), toList())));
		System.out.println("Emp with addresses by each dept: "+ nonEmptyAddressByDept);
		
		var allAddressByDept = list.stream()
				.collect(groupingBy(Employee::getDept, flatMapping(emp -> emp.getAddresses().stream(), toList())));
		System.out.println("Addresses of all employees at dept: "+ allAddressByDept);
	}

}
