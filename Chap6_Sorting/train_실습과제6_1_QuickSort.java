package Chap6_Sorting;

import java.util.Stack;

//stack 1개를 사용한 non-recursve QuickSort() 구현

class Point {
	private int ix;
	private int iy;

	public Point(int x, int y) {
		ix = x;
		iy = y;
	}

	public int getX() {
		return ix;
	}

	public int getY() {
		return iy;
	}

	public void setX(int x) {
		ix = x;
	}

	public void setY(int y) {
		iy = y;
	}
}
public class train_실습과제6_1_QuickSort {


//퀵 정렬(비재귀 버전)

	// --- 배열 요소 a[idx1]와 a[idx2]의 값을 교환 ---//
	static void swap(int[] a, int idx1, int idx2) {
		int t = a[idx1];
		a[idx1] = a[idx2];
		a[idx2] = t;
	}

	// --- 퀵 정렬(비재귀 버전)---//
	static void quickSort(int[] a, int left, int right) {

		Stack<Point> st = new Stack<>();
		Point pt = new Point(left, right);
		st.push(pt);
		
		while(!st.isEmpty()) {
			pt =  st.pop(); //스택에서 Point 객체를 꺼내 left와 right 범위를 가져옴
			int pl = left = pt.getX(); //left 값을 pt.getX()로 설정. pl은 배열의 왼쪽 포인터로, 분할을 시작할 때의 초기값
			int pr = right = pt.getY();//right 값을 pt.getY()로 설정. pr은 배열의 오른쪽 포인터로, 분할을 시작할 때의 초기값
			int x =a[(left + right)/2];
			
			do {
				while(a[pl]<x)pl++;
				while(a[pr]>x)pr--;
				if(pl<=pr)
					swap(a,pl++,pr--);
			}while(pl<=pr);
			
			if(left<pr) {
				st.push(new Point(left,pr));//분할된 범위를 포인트 객체에 저장해서 푸쉬
				
			}
			if(pl<right) {
				st.push(new Point(pl,right));
			}
		}

	}

	public static void main(String[] args) {
		int nx = 10;
		int[] x = new int[10];
		for (int ix = 0; ix < 10; ix++) {
			double d = Math.random();
			x[ix] = (int) (d * 20);
		}
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
		System.out.println();

		quickSort(x, 0, nx - 1); // 배열 x를 퀵정렬

		System.out.println("오름차순으로 정렬했습니다.");
		for (int i = 0; i < nx; i++)
			System.out.print(" " + x[i]);
	}
}
