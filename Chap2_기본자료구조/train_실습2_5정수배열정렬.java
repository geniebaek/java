package Chap2_기본자료구조;
/*
 * 2장 - 정수 배열 정렬
 */

import java.util.Arrays;
//교재 67 - 실습 2-5
//2번 실습
import java.util.Random;
public class train_실습2_5정수배열정렬 {
	public static void main(String[] args) {
		int []data = new int[10];
		inputData(data);
		showData("난수 입력", data);
		/*
		sortData(data);
		showData("정렬후", data);
		 */
		reverse(data);//역순으로 재배치 - 정렬 아님 
		showData("역순 재배치", data);

		reverseSort(data);//역순으로 재배치 - 정렬 아님 
		showData("역순 정렬후", data);
		sortData(data);
		int realData = 15;
		int []result = insertData(data, realData);//입력 실수보다 큰 숫자를 우측으로 이동
		showData("실수 삽입후", result);
	}

	static void showData(String msg, int[]data) {
		System.out.println(msg);
		for(int n:data) {
			System.out.print(n+" ");
		}
		System.out.println();
	}
	static void inputData(int []data) {
		Random rand= new Random();
		for(int i = 0; i< data.length;i++) {
			data[i]=rand.nextInt(20);
		}


	}
	static void swap(int[]arr, int ind1, int ind2) {//교재 67페이지
		int t= arr[ind1];
		arr[ind1]=arr[ind2];
		arr[ind2]=t;
	}
	static void sortData(int []arr) {
		Arrays.sort(arr);
	}
	static void reverse(int[] a) {//교재 67페이지
		for(int i = 0; i<a.length/2;i++) {
			swap(a,i,a.length-1-i);
		}
	}
	static void reverseSort(int []arr) {
		for(int i = 0; i<arr.length/2; i++) {
			swap(arr,i,arr.length-1-i);
		}
	}
	/*
	 * 난이도가 매우 높은 알고리즘 구현
	 * 정렬된 기존 배열에 임의 값을 추가하는 알고리즘 > 새 배열의 크기는 기존 배열보다 +1로 만들고 기존 배열을 copy할 때
	 * 삽입된 값이 중간에 들어가는 알고리즘 구현하기
	 */
	static int[] insertData(int []data, int value) {//insert되는 실수 값이 insert될 위치를 찾아 보다 큰 값은 우측으로 이동
		int newData[] = new int[data.length+1];
		boolean tag = false;
		int i = 0; //i는 data[]의 인덱스
		int j = 0; //j는 newData[]의 인덱스
		while(i<data.length) {
			if(!tag) { //tag(false)가 아니면 다음 if문 실행
				if (data[i]<value) { //data[i]가 value보다 작으면
					newData[j++]=data[i++]; // newdata[j]에 data[i]값을 그대로 복사 반복해서 돌아야 하니까 ++ 를 붙여줘야함
				}
				else { //data가 value 보다 크다면
					newData[j++]=value; //newdata[j]에 value값을 넣어줌
					tag=true;// value값을 newdata에 넣었으면 tag는 true로 반환해서 그 다음 인덱스는 이 if문을 빠져나가게 함
				}
			}
			else {//tag가 false가 아니면 data[i]는 
				newData[j++]=data[i++]; // newdata[j]에 data[i] 값을 넣어줌 
			}

		}
		if(tag == false) { //tag가 true 일때 if문을 빠져나가 return으로 돌아가기 때문에 if문을 하나 더써주고 value값을 집어넣어야함 
			newData[j]=value;
		}
		return newData;


	}

}
