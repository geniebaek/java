package com.ruby.java.ch06;

public class Member_1 {
	
	private String name;
	private int age;
	
	public Member_1() {
		this("guest");
	}
	public Member_1(String name) {
		this(name,0);
	}
	public Member_1(String name, int age) {
		this.name=name;
		this.age=age;
	}
	
	public String toString() {
		return name+":"+age;
	}
	public static void main(String[] args) {
		Member_1 m1=new Member_1();
		Member_1 m2=new Member_1("Amy");
		Member_1 m3=new Member_1("Amy",23);
		
		System.out.println(m1.toString());
		System.out.println(m2.toString());
		System.out.println(m3.toString());
		
	}

}
