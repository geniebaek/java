package Chap2_기본자료구조;

/*
 * 3번째 실습
 * 교재 83 - 배열 처리 + function parameter 전달 숙달 훈련 
 *  함수에서 배열을 리턴할 때 리턴 타입 정의할 수 있어야 한다
 */

import java.util.Arrays;
import java.util.Random;
public class train_실습2_6다차원배열 {

	public static void main(String[] args) {
		int [][]A = new int[2][3];
		int [][]B = new int[3][4];
		int [][]C = new int[2][4];

		inputData(A);inputData(B);
		int [][]D = A.clone();//교재83 - 배열 복제
		System.out.println("A[2][3] = ");
		showData("행렬 A", A);
		System.out.println("D[2][3] = ");
		showData("행렬 D", D);
		System.out.println();
		System.out.println("B[3][4] = ");
		showData("행렬 B", B);
		int [][]E = addMatrix(A,D);
		System.out.println("E[2][3] = ");
		showData("행렬 E", E);
		C = multiplyMatrix(A,B);
		System.out.println("C[2][4] = ");
		showData("행렬 C", C);

		int [][]F = transposeMatrix(B);
		System.out.println("F[3][2] = ");
		showData("행렬 F", F);
		C= multiplyMatrixTransposed(A,F);
		showData("행렬 곱셈 결과-전치행렬 사용", C);
		boolean result = equals(A,C);
		if (result)
			System.out.println("행렬 A,C는 equal이다");
		else
			System.out.println("행렬 A,C는 equal 아니다");
	}
	static void inputData(int [][]data) {
	Random rand = new Random();
	
	for (int i = 0; i<data.length;i++) {
		
		for(int j = 0; j<data[i].length;j++) {
			//data[j]=rand.nextInt(10); error->type mismatch: cannot convert from int to int[] 
			data[i][j]=rand.nextInt(10); 
		}
	}
	}
	static void showData(String msg, int[][]items) {
		System.out.println(msg);
//		for(int i = 0 ; i< items.length;i++) {
//			for(int j = 0; j<items[i].length; j++) {
//				System.out.println(items[i][j]+" ");
//				
			for(int[] cols : items) {
				System.out.println(Arrays.toString(cols)); //배열에 문자열로 숫자를 넣어줌 배열 보기 좋게 하는 방법
		}
//		System.out.println();

	}
	static boolean equals(int[][]a, int[][]b) {
		//행렬 a,b의 행의 수, 열의 수가 같아야 하고 각 원소가 같아야 한다.
		
		if(a.length != b.length || a[0].length != b[0].length) {//a.length= a 행의 수 a[0].length=열의 수  둘중 하나라도 같지 않으면
			return false;//false를 반환
		}else {
			for(int row = 0; row<a.length;row++) { 
				for(int col=0; col<a[0].length;col++) {
					if(a[row][col]!=b[row][col]) {//a[][] 과 b[][] 가 같지 않다면 false를 반환
						return false;
					}
				}
			}
		}
		return true; //if문과 for문을 다 돌았다면 행과 열의 수가 같고 각 원소가 같다는 말이기 때문에 true를 반환

	}
	static int[][] addMatrix(int [][]X, int[][]Y) { //Y는 X를 복사한 거기 때문에 행과 열, 원소가 같음
		int rows = X.length; //X의 행의 수 만큼 rows 선언
		int cols = X[0].length; //X[0] 열의 수 만큼 cols 선언
		int [][] add = new int[rows][cols]; // rows와 cols의 크기 만큼 add라는 2차원 배열 선언
		for(int i = 0; i < rows;i++) {
			for(int j = 0; j<cols;j++) {
				add[i][j]=X[i][j]+Y[i][j]; //add 배열에 X의 행과 열 Y의 행과 열을 서로 더해줌 
			}
		}
		return add; //add 리턴
	}
	static int[][] multiplyMatrix(int [][]X, int[][]Y) {
		int [][] matrix = new int[X.length][Y[0].length];
		for(int i = 0; i<X.length;i++) { 
			for(int j = 0; j<Y[0].length;j++) {
				for(int k= 0; k < X[0].length;k++) {//k를 선언해줘야 k의 값이 커질때마다 열의 인덱스 값이 바껴서 행과 열을 하나씩 전부 곱할 수 있음 
					matrix[i][j]+=X[i][k]*Y[k][j];
				}
			}
		}
		return matrix;
	}
	static int[][] transposeMatrix(int [][]X) {
		int [][] tm= new int[X[0].length][X.length];
		for(int i = 0; i< X.length; i++) {
			for(int j=0; j<X[0].length;j++) {
				tm[j][i]=X[i][j];
			}
		}
		return tm;
		
	}
	static int[][] multiplyMatrixTransposed(int [][]X, int[][]Y){
		int[][] mmt= new int [X.length][Y.length];
		for(int i = 0; i<X.length; i++) {
			for(int j = 0 ; j<Y.length;j++) {
				for(int k= 0; k<X[0].length;k++) {
					mmt[i][j]+=X[i][k]*Y[j][k];
				}
			}
		}
		return mmt;
	}
}

