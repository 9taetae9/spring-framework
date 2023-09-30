package com.in28minutes.test;

import java.io.Serializable;

class Pojo{
	private String text;
	
	private int number;
	
	public String toString() {
		return text+":"+number;
	}
}

class JavaBean implements Serializable{//EJB
	
	//1: public no-arg constructor
	public JavaBean() {}

	private String text;
	
	private int number;

	//2: getters and setters
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
}

public class SpringBeanVsJavaBean {

	public static void main(String[] args) {
		
		Pojo pojo = new Pojo();
		
		System.out.println(pojo);
		
	}
}
/*
Java Bean: Classes adhering to 3constraints:
1: Have public default(no-arg) constructors
2: Allow access to their properties using getter and setter methods
3: Implements java.io.Serializable

Pojo: Plain Old Java Object
-No contraints!
-Any Java objs are POJO!

Spring Bean: Any java object that is managed by Spring
-Spring uses IOC Container (Bean Factory or Application Context) 
to manage these objects





*/