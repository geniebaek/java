package chap4_array;

public class 실습4_1배열생성최대값 {

	public static void main(String[] args) {
	
		        // 1차원 배열 생성 및 초기화
				/*
				 * 정수 1차원 배열 price를 선언하고 5개 값으로 초기화
				 */
				int[]price= {1,2,3,4,5};
				int max = 0;
				for(int p : price) {
					if(max<p) {
						max=p;
						
					}
				}
						
						
				System.out.println("최대값 = "+max);
				System.out.print("[");
				for(int i=0;i<price.length;i++) {
					System.out.print(price[i]);
					if(i!=price.length-1)
					System.out.print(",");
					
				}
				System.out.println("]");
					//System.out.println("["+price[0]+","+price[1]+","+price[2]+","+price[3]+","+price[4]+"]");
				
		        // for문을 사용한 최대값 찾기
				/*
				 * 최대값 변수를 priceMax로 선언한 후에 for 문을 사용하여 최대값을 찾는다
				 * 배열 price는 확장형 for 문으로 출력, 출력 형태는 다음과 같다:
				 * [1,2,3,4,5]
				 * 최대값 출력은 다음과 같다
				 * 최대값 = **
				 * 
				 */
		    
		

	}

}
