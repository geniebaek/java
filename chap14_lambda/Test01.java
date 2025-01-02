package chap14_lambda;

import com.ruby.java.ch06.StaticMethodTest;

interface MyInterface{
	public void print();
}
class MyClass1 implements MyInterface{
	@Override
	public void print() {
		System.out.println("myclass1");
	}
}
public class Test01 {
	static void test(MyInterface m) {
		m.print();
	}
	static MyInterface test2() {
		MyInterface mi = new MyInterface() {
			@Override
			public void print() {
				System.out.println("익명클래스");
			
			}
		};
		return mi;
	}
	static MyInterface test3() {
		return new MyInterface() {
			public void print() {
				System.out.println("익명클래스3");
			
			}
		};
		
	}
public static void main(String[] args) {
	MyClass1 mc1 = new MyClass1();
	//mc1.print();
	test(mc1);
	
	MyInterface mi = new MyInterface() {
		@Override
		public void print() {
			System.out.println("익명클래스");
		
		}
	};//문장이 끝날때 세미콜론 
	test(mi);
	mi.print(); //방법 2 익명클래스 658pnew 
	
	new MyInterface() {
	@Override
	public void print() {
		System.out.println("익명클래스2");
	}
	}.print(); //mi.print();대신 방법3 선언 생성, 호출을 한번에 처리 위 클래스와 다른 새로운 클래스임. 참조변수 없는 클래스이기 때문에 print() 메서드 이후 가비지 컬렌션에서 사라짐
	MyInterface mi2 = test2();
	mi2.print();
	MyInterface mi3 = test3();
	mi3.print();
	}
}

