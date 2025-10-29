package com.practices.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {
	
	private int id;
	private String name;
	private String dept;
	private String team;
	private double salary;
	private List<Address>  addresses;
	
	
	public Employee(int id, String name, String dept, String team, double salary, List<Address> addresses) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.team = team;
		this.salary = salary;
		this.addresses = addresses;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", " + (name != null ? "name=" + name + ", " : "")
				+ (dept != null ? "dept=" + dept + ", " : "") + (team != null ? "team=" + team + ", " : "") + "salary="
				+ salary + ", " + (addresses != null ? "addresses=" + addresses : "") + "]";
	}

	public static List<Employee> createEmployeeList() {
		return new ArrayList<Employee>() {
			private static final long serialVersionUID = 1L;
			{
                add(new Employee(1, "Emp1", "Sales", "A", 15000, new ArrayList<>()));
                add(new Employee(2, "Emp2", "Dev", "A", 5000, new ArrayList<>()));
                add(new Employee(3, "Emp3", "Sales", "B", 25000, new ArrayList<>()));
                add(new Employee(4, "Emp4", "Dev", "B", 15000, new ArrayList<>()));
                add(new Employee(5, "Emp5", "QA", "C", 8000, new ArrayList<>()));
                add(new Employee(6, "Emp6", "QA", "A", 9000, new ArrayList<>()));
                add(new Employee(7, "Emp7", "Dev", "A", 9000, Arrays.asList(new Address())));
            }
        };
	}
}
