package com.ruby.java.ch13.multiGen;

class Bag<T,N>{
	private T thing;
	private N name;
	
	
	public Bag(T thing, N name) {
		super();
		this.thing = thing;
		this.name = name;
	}
	
	public T getThing() {
		return thing;
	}
	public void setThing(T thing) {
		this.thing=thing;
	}
	
	public N getName() {
		return name;
	}

	public void setName(N name) {
		this.name = name;
	}

	void showType() {
		System.out.println("T의 타입은 "+thing.getClass().getName());
		System.out.println("N의 타입은 "+name.getClass().getName());
	}
	
	
}

class Book{
	public String toString() {
		return "책";
	}
}
class PencilCase{}
class Notebook{}

public class BagTest2 {
//기본생성자에 매개변수가 없기때문에 기존에 있던 매개변수를 지워버려야됨
//객체를 만들어줘야 하기 때문에 위에 만들어뒀던 세터를 이용하고 매개변수를 집어넣어야함.
	public static void main(String[] args) {
		Bag<Book,String>bag=new Bag<Book,String>(new Book(),"과학");
		
		bag.showType();
		Book book=bag.getThing();
		String name= bag.getName();
		
		System.out.println("Thing is :"+book);
		System.out.println("name is :"+name);

	}

}
