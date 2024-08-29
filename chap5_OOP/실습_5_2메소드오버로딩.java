package chap5_OOP;

	class Person {
	    // 필드 (private)
		/*
		 * name은 String, age는 int, weight는 float로 필드들을 private 선언
		 * 교재 p198 Armor.java 참조
		 */
		private String name;
		private int age;
		private float weight;
		
		
	    // name 메소드: setter, getter 함수, 교재 p199
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getName() {
	    	return name;
	    }
	    public void setAge(int age) {
	        this.age = age;
	    }
	    public int getAge() {
	    	return age;
	    }
	    public void setWeight(float weight) {
	        this.weight = weight;
	    }
	    public float getweight() {
	    	return weight;
	    }
	    public void show(String msg) {
	    	System.out.println("이름 = "+name+",나이 = "+age+",몸무게 +"+weight);
	    }
	  
	    // age 메소드:setter, getter 함수 구현, 교재 p199
	    
	    // weight 메소드: setter, getter 함수 구현, 교재 p199

	    // 이름, 나이, 몸무게를 출력하는 show 메소드


	    // 오버로딩된 show 메소드 (message를 출력)
	  
	        // 이름, 나이, 몸무게를 출력하는 코드 작성
	    
	}
public class 실습_5_2메소드오버로딩 {
	    public static void main(String[] args) {
	        // 객체 생성
	        Person p = new Person();
	        p.name = "홍길동";
	        p.setName("홍길동");
	        p.setAge(25);
	        p.setWeight(62.123f);
	        //다음 코드를 디버깅
	        System.out.println("이름 = " + name + ", 나이 = " + age + ", 몸무게 = " + weight);

	        // 메소드 호출
	        p.show();
	        p.show("오버로딩");
	    }
	}
}
