package chap1_기본알고리즘;

import java.util.Arrays;
import java.util.StringTokenizer;

public class 실습1_6_스트링토큰_과제 {
/*
 * StringTokenizer(input), countTokens(), hasMoreTokens(), nextToken()
 * parseDouble(stringArray[i])
 */
    // 문자열을 실수로 추출하여 배열에 저장하고 정렬하는 함수
    

    // 문자열 배열을 실수 배열로 변환한 후 정렬하는 함수
       
    // 문자열 배열을 실수 배열로 변환
        

    // 문자열 배열 출력 함수
    

    // 실수 배열 출력 함수
    

    public static void main(String[] args) {
        String msg = "3.24 3.34156 1141.56 214. 0.0314156 54.12f";
        
        // 실수를 문자열로 추출하고 정렬 후 출력
        String[] sortedStringArray = extractSortStrings(msg);
        System.out.println("정렬 스트링 배열:");
        printStringArray(sortedStringArray);
        
        // 문자열 배열을 실수 배열로 변환하고 정렬 후 출력
        double[] sortedDoubleArray = convertSortToDouble(sortedStringArray);
        System.out.println("정렬 실수 배열:");
        printDoubleArray(sortedDoubleArray);
    }
    public static String[] extractSortStrings(String m) {
    	StringTokenizer s = new StringTokenizer(m);
    	String[] a = new String[s.countTokens()];
    	System.out.println(s.countTokens());
    	int i = 0;
    	while (s.hasMoreTokens()) {  //for문 말고 while문으로 변경 이유는 못찾음..
    		a[i]=s.nextToken();
//    		System.out.println("test = " + a[i]);
    		i++;
    	}

    	Arrays.sort(a);
    	return a;
    }
    public static void printStringArray(String[] print) {
    	for(int i=0; i<print.length;i++) {
    		System.out.println(print[i]);
    	}
    }
    public static double[] convertSortToDouble(String[] d) {
    	double[] db= new double[d.length];
    	for(int i = 0; i<d.length;i++) {
    		db[i]=Double.parseDouble(d[i]);
    	}
    	Arrays.sort(db);
    	return db;
    	
    }
    public static void printDoubleArray(double[] d) {
    	for(int i = 0; i<d.length;i++) {
    		System.out.println(d[i]);
    	}
    }
}
