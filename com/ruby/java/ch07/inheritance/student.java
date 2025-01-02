package com.ruby.java.ch07.inheritance;

public class student extends Person {
	private String major;
	
	public student() {
		super();
		System.out.println("student 생성자 실행!");
	}
	public student(String name,int age,String major) {
		super(name,age);
		this.major=major;
		System.out.println("student(name, age, major) 생성자 실행!");
		
	}
	
	
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major=major;
	}
	public String toString() {
		//return this.getName()+":"+this.getAge()+":"+major;
		return super.toString()+":"+major;
		
	}

}
