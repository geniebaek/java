package com.ruby.java.ch13;

public class GenMethodTest2 {
	
	<T extends Number, V extends T>boolean isInclude(T num,V[] array){
		for(int i =0;i<array.length;i++) {
			if(array[i]==num)
				return true;
		}
		return false;
	}

	public static void main(String[] args) { //static 메소드는 static만 호출 가능
		Integer[] inum= {1,2,3,4,5,};
		Double[] dnum= {1.0,2.0,3.0,4.0,5.0};
		String[] snum= {"one","two","three","four","five"};
		
		GenMethodTest2 gt= new GenMethodTest2();//인스턴스를 생성해줘야함
		
		boolean b1=gt.isInclude(3,inum);
		System.out.println("결과 : "+b1);
		
		boolean b2=gt.isInclude(5.0,dnum);
		System.out.println("결과 : "+b2);
		
		//isInclude("one",snum);
		
//		GenMethodTest2.<Integer,Integer>isInclude(3,inum);//<Integer,Integer> 생략가능
//		GenMethodTest2.<Double,Double>isInclude(5.0,dnum);//<Double,Double> 생략가능
		//GenMethodTest.<String,String>isInclude("one",snum); //num으로 상속받은 클래스기 때문에 String"문자열"은 오류발생  

	}

}
