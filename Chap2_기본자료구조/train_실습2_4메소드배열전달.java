package Chap2_기본자료구조;

import java.util.Random;

/*
 * 2장과제1: 메소드 함수에 parameter 전달
 * 메소드에 배열 전달 실습: 교재 59 - 메소드의 매개변수로 배열 사용하기
 * function parameters를 작성할 수 있어야 한다 
 */


public class train_실습2_4메소드배열전달 {
	//static int top = 0; //for문의 범위
	//static final int MAX_LENGTH = 20; //data배열의 최대 길이
	public static void main(String[] args) {
		int []data = new int[10];//총 20칸중의 10칸만 사용
		inputData(data);
		showData("소스데이터",data);
		int max = findMax(data);
		System.out.println("\nmax = " + max);
		boolean existValue = findValue(data, 3);
		System.out.println("찾는 값 = " + 3 + ", 존재여부 = " + existValue);
		reverse(data);// 역순으로 출력 swap메서드를 먼저 구현해야한다.
		showData("역순 데이터", data);
		
	}
	static void showData(String s, int[]data) { //top 갯수까지 출력한다 [1,2,3]등으로 출력하도록 작성 확장형 for문
		System.out.println(s);
		for(int n : data) {
			System.out.print(n+" ");
		}
		System.out.println();
		
		
	}
	static void inputData(int[]arr) {//교재 63 - 난수의 생성
		//top이 배열에 저장된 갯수를 저장
//		int len = arr.length;
		Random r= new Random();
		
		for(int i = 0; i<arr.length;i++) {
			arr[i]=r.nextInt(10);
		}
		
		
	}
	static int findMax(int[]data) { 
		//최대값을 리턴한다 
		int m=data[0];
		for(int i = 0 ; i<data.length;i++) {
			if(data[i]>m)
				m=data[i];
		
		}
		return m;
	}
	static boolean findValue(int[]data, int d) {
		//items[]에 value 값이 있는지를 찾아 존재하면 true, 없으면 false로 리턴
		for(int i = 0; i<data.length;i++) {
			if(data[i] == d)
				return true;
		}
		return false;

	}
	static void swap(int [] data, int i , int j){ //p66
		int t = data[i];
		data[i]=data[j];
		data[j]=t;
	}
	static void reverse(int[] data) {
		for(int i = 0; i<data.length/2;i++) {
			swap(data,i,data.length-i-1); // swap메서드 : data[i]값과 data.length(데이터의 배열개수) 값이 바뀜
		}
	}

}
