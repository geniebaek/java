package chap5_OOP;

public class 실습5_1클래스객체 {
	class Armor{
		String name; //field 정의
		int height;
		int speed;
		public int speedUp(int value) {//메소드
			speed += value;
			return speed;
		}
	
	
		class Person {
		    // 필드
			/*
			 * name은 String, age는 int, weight는 float로 필드 선언
			 */

		    // 메소드
		    void show() {
		    	/*
		    	 * name=**, age = **, weight = ** 형태로 출력
		    	 */
		    }
		}
	

		public class Main {
		    public static void main(String[] args) {
		        // 객체 생성
		    	int a=10;
		    	int arr[]=new int[5];
		    	Armor mark16=new Armor();
		    	int maxSpeed=mark16.speedUp(10);
		    	mark16.name = "강감찬"; //"강감찬" 스르링 리터럴 상수 문자열함수
		    	mark16.takeoff();
		    	
		        Person p = new Person();
		        p.name = "홍길동";
		        p.age = 25;
		        p.weight = 60.56f;

		        // 메소드 호출
		        p.show();
		        
		        /*
		         * [강감찬, 55, 62.34] 객체를 만들어
		         * name=**, age = **, weight = ** 형태로 출력
		         */
		
		    }
		}

	}

}
