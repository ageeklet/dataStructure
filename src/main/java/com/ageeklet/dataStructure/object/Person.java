package com.ageeklet.dataStructure.object;

public class Person {
	private String lastName;
	private String firstName;
	private int age;
	public Person(String lastName, String firstName, int age) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.age = age;
	}
	public void displayPerson() {
		System.out.print("lastName:"+lastName+" ");
		System.out.print("firstName:"+firstName+" ");
		System.out.println("age:"+age);
	}
	
	public String getLast() {
		return lastName;
	}
	@Override
	public String toString() {
		return "Person [lastName=" + lastName + ", firstName=" + firstName + ", age=" + age + "]";
	}
	
}
