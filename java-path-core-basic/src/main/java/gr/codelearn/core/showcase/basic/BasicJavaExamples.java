package gr.codelearn.core.showcase.basic;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.Scanner;

public class BasicJavaExamples {

	public static void main(String[] args) {
//		final int MAX_NUMBER_OF_ARG = 8;
//		boolean myVariable = true;
//		int myInteger = 0;
//		float myFloat = 3.14f;
//		long l = 3l;
//
//		var myVar = "hello";
//		//		myVar = 10;
//
//		System.out.println("Boolean variable: " + myVariable + " integerVariable: " + myInteger);
//
//		System.out.println("Hello " + 1 + 2);
//		System.out.println(1 + 2 + " Hello");
//
//		int aVariableInteger = 10;
//		aVariableInteger = aVariableInteger + 2;
//		aVariableInteger -= 2;
//		aVariableInteger++;
//		++aVariableInteger;
//
//		int a = 10;
//		int b = 20;
//		b = a++;  // b = a; a = a + 1
//		b = ++a;  // a = a + 1; b = a;
////		int c = ++a+b++;
//		/*System.out.println(c);
//		System.out.println(c++);
//		System.out.println(++c);*/
//		System.out.println(a * b);
//		System.out.println(b / a);
//		System.out.println(b % a);

//		int a = 5;
//		int b = 2;
//
//		System.out.println(5.0/2);
//		System.out.println( (double)a / b );
//		System.out.println(a % b);
//		System.out.println(b % a);

//		System.out.println( 60 % 60);

//		>= <= > < == != // Relational
//		System.out.println(5 < 3);
//
//		// && || ! // logical
//		int a = 5;
//		int b = 2;
//		System.out.println( (a < b && b > 0) );

		// & | ! >> <<
//		int bits = 5;
//		System.out.println(bits << 2);
//		System.out.println(bits >> 2);

//		int a = 5;
//		int b = 22;
//		//	System.out.println( (a < b && b > 0) );
//
////		if (a > b){
////			System.out.println(a);
////		}
//
//		if (a > b){
//			System.out.println(a);
//		} else {
//			System.out.println(b);
//		}
//
//		// condition ? code for true : false;
//		System.out.println(  a > b ? a : b  );
//
//
//		if (a > b){
//			System.out.println(a);
//		} else if (a < b){
//			System.out.println(b);
//		} else {
//			System.out.println("=");
//		}

//		int a = 5;
//		int b = 0;
//		if (a < b && ++b > 0){
//			System.out.println(a);
//		} else {
//			System.out.println(b);
//		}

//		int a = 5;
//		switch (a){
//			case 3:
//				System.out.println("3"); break;
//			case 5:
//				System.out.println("5"); break;
//			case 7:
//				System.out.println("7"); break;
//			default:
//				System.out.println("Error...");
//		}

//		String month = "Jan";
//		switch (month){
//			case "Jan":
//			case "Mar":
//			case"May": System.out.println(31); break;
//			case "Apr":
//			case "Jun":
//			case"Aug": System.out.println(30); break;
//			default:
//				System.out.println(27);
//
//		}
//		int i = 6;
//		while (i < 5){
//			System.out.println(i);
//			i++;
//		}
//
//		for(int j = 0; j < 5; j++){
//			System.out.println(j);
//		}
//
//		int k=6;
//		do {
//			System.out.println(k);
//			k++;
//		} while(k < 5);

//		Scanner in = new Scanner(System.in);
//		int number;
//		do {
//			System.out.print("Enter a number: ");
//			number = in.nextInt();
//		} while(number <= 0);
//
//		int t = 0;
//		while(t < 400){
//			int l = 9;
//			//....
//			t++;
//		}

		int res = sum(2,5);
		int res1 = sum(2,5) + 45 + sum(4,4);
		System.out.println(res);
		System.out.println(res1);
		System.out.println(sum(7,3));
		doSomething();
	}

	public static int sum(int num1, int num2){
//		int res = num1 + num2;
//		return res;
		return num1 + num2;
	}

	public static void doSomething(){
		System.out.println("Hello");
	}



}
