package edu;

public class Test30_1 {

	public static void main(String[] args) {
		int cnt = 0;
		for (int i = 1; i <= 100; i++) {

			if ((i % 2) == 0 && i % 3 ==0) {
				System.out.println(i + " 2/3의 공배수");
				cnt ++;
			}
		}

	}

}
