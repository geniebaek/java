package edu;

public class Test31_1 {
	public static void main(String[] args) {
	
		for(int i=2; i<10; i++) {
			for(int j=1; j<10; j++) {
				System.out.println(i+" * "+j+" = "+(i*j));
				
				if(j <10) { System.out.println("\n  ");
				} else { System.out.println("\t");
			}
			}
		}
	}
}
