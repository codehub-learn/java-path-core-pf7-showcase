package gr.codelearn.core.showcase.basic;

public class BasicJavaExamples {
	public static void main(String[] args) {
		boolean myVariable = true;
		int myInteger = 0;
		float myFloat = 3.14f;

		var myVar = "hello";
		//		myVar = 10;

		System.out.println("Boolean variable: " + myVariable + " integerVariable: " + myInteger);

		System.out.println("Hello " + 1 + 2);
		System.out.println(1 + 2 + " Hello");

		int aVariableInteger = 10;
		aVariableInteger = aVariableInteger + 2;
		aVariableInteger -= 2;
		aVariableInteger++;
		++aVariableInteger;

		int a = 10;
		int b = 20;
//		int c = ++a+b++;
		/*System.out.println(c);
		System.out.println(c++);
		System.out.println(++c);*/
		System.out.println(a * b);
		System.out.println(b / a);
		System.out.println(b % a);

	}
}
