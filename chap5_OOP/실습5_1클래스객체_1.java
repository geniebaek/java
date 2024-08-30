package chap5_OOP;
class Person3{
	String name;
	int age;
	float weight;

	void show() {
		System.out.println("name = "+name+", age = "+age+", weight = "+weight);//name = **, age = **, ...
	}
}
public class 실습5_1클래스객체_1 {
	public static void main(String[] args) {
		Person3 p = new Person3();
		p.name = "홍길동";
		p.age=55;
		p.weight=62.34f;
		p.show();
	}
	
}
