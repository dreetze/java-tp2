package com.epsi.tp1;

public class Promote {

	public Promote() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		byte b = 42;
		char c ='a'; //a = 97
		short s = 1024;
		int i = 50000;
		//float f = 5.67;
		double f = 5.67;
		double d = .1234;
		double resultat = (f*b)+(i/c)-(d*s);
		
		System.out.println(c*2/2);
		
		System.out.print((f*b)+ " + "+ (i/c)+" - "+(d*s));
		System.out.println(" = "+ resultat);
		
		byte b2 = 10;
		//byte b3 = b2 * b;
		int b3 = b2 * b;
		
		System.out.println("b3= "+ b3);
		

	}
}
