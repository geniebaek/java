package com.ruby.java.ch13.boundGen;

class Bag<T extends Solid>{
	private T thing;
	
	
	public Bag(T thing) {
		this.thing=thing;
	}
	
	public T getThing() {
		return thing;
	}
	public void setThing(T thing) {
		this.thing=thing;
	}
	
	void showType() {
		System.out.println("T의 타입은 "+thing.getClass().getName());
	}
	
}

class Solid{}
class Liquid{}

class Book extends Solid{}
class PencilCase extends Solid{}
class Notebook extends Solid{}

class Water extends Liquid{}
class Coffee extends Liquid{}

public class BagTest2 {

	public static void main(String[] args) {
		Bag<Book>bag=new Bag<>(new Book());
		Bag<PencilCase>bag2=new Bag<>(new PencilCase());
		Bag<Notebook>bag3=new Bag<>(new Notebook());
		
		Bag<Water> bag4=new Bag<>(new Water());  //오류 발생 . 타입 매개변수에 Solid 계열만 받겠다고 선언했기 때문
		Bag<Coffee> bag5=new Bag<>(new Coffee()); // Coffee와 Water는 Liquid계열이라 Solid를 상속하지 않았기 때문에 사용할 수 없음.

	}

}
