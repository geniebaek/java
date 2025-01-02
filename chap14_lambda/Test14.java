package chap14_lambda;

import java.util.function.Function;

public class Test14 {

	public static void main(String[] args) {
		Function<String, Integer> f =(s) -> {
			int cnt = 0;
			return cnt;
			
			
		};
		int wordCnt = f.apply("good");
	}

}
