package gr.codelearn.core.showcase.maven.input;

import gr.codelearn.core.showcase.provider.MathOperationsProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class CalculatorInputHandler {
	private static final Logger logger = LoggerFactory.getLogger(CalculatorInputHandler.class);

	public static void main(String[] args) {

		logger.info("Waiting for user's input: ");
		Scanner input = new Scanner(System.in);

		System.out.println("Enter first number ");
		Integer firstArgument = input.nextInt();
		System.out.println(firstArgument);

		System.out.println("Enter second number ");
		Integer secondArgument = input.nextInt();
		System.out.println(secondArgument);

		logger.info(String.format("Provided numbers are %s and %s", firstArgument, secondArgument));
		logger.info("Calculated sum of provided arguments is: " + MathOperationsProvider.add(firstArgument,
																						   secondArgument));
		logger.info("Calculated product of provided arguments is: " + MathOperationsProvider.multiply(firstArgument,
																								secondArgument));
	}
}
