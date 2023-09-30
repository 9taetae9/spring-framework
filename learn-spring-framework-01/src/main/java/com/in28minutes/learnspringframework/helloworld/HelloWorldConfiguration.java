package com.in28minutes.learnspringframework.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


/*record?
Eliminate verbosity in creating Java Beans
Public accessor methods, constructor,
equals, hashcode and toString are automatically created.
Released in JDK 16.*/

record Person (String name, int age, Address address) {};
record Address(String firstLine, String city){};

@Configuration
public class HelloWorldConfiguration {
	@Bean
	public String name() {
		return "Ranga";
	}
	
	@Bean
	public int age() {
		return 24;
	}
	
	@Bean
	public Person person() {
		return new Person("Ravi", 20, new Address("Main Street", "Utrecht"));
	}
	
	@Bean
	public Person person2MethodCall() { //calling method directly
		return new Person(name(), age(), address()); //using exiting Bean
	}
	
	@Bean
	public Person person3Parameters(String name, int age, Address addy2) { //passing the parameters
		return new Person(name, age, addy2); //using exiting Bean
	}
	
	
	@Bean
	@Primary
	public Person person4Parameters(String name, int age, Address address) {
		return new Person(name,age,address);
	}
	
	@Bean
	public Person person5Qualifier(String name, int age,@Qualifier("address3qualifier") Address address) {
		return new Person(name,age,address);
	}
	@Bean(name = "addy") //renaming address =>addy
	@Primary
	public Address address() {
		return new Address("Dongjak","Seoul" );
	}
	@Bean(name = "addy2") //renaming address =>addy
	@Qualifier("address3qualifier")
	public Address address2() {
		return new Address("Motinagar","Hyderabad" );
	}
	
}
