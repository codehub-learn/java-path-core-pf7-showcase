package gr.codelearn.core.showcase.exception;

import gr.codelearn.core.showcase.exception.domain.exception.NegativeNumberException;
import gr.codelearn.core.showcase.exception.domain.exception.NumberIsZeroException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class ExceptionMechanismTester {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionMechanismTester.class);

	public static void main(String[] args) {
		logger.info("Program started.");
		//unhandledException();
		tryCatch();
		tryMultipleCatches();
		tryMultipleCatchesCollapsed();
		tryCatchFinally();
		logger.info("The result from the 'tryCatchFinallySpecialCase' method is: {}", tryCatchFinallySpecialCase());
		throwRuntimeException(4);
		// custom checked exception handler
		try {
			throwCheckedException(-3);
		} catch (IOException e) {
			logger.info("IOException thrown with message: {}", e.getMessage());
			//throw new RuntimeException("Chained exception", e);
		}

		// custom exceptions
		try {
			throwCustomExceptions(0);
		} catch (NumberIsZeroException e) {
			logger.info("Custom checked exception thrown with message: {}", e.getMessage());
		} catch (NegativeNumberException e){
			logger.info("Custom unchecked exception thrown with message: {}", e.getMessage());
		}
		logger.info("Program ended.");
	}

	public static void unhandledException(){
		int i = Integer.parseInt("a");
		logger.info("{}", i);
	}

	public static void tryCatch(){
		logger.info("tryCatch()");
		try{
			int i = Integer.parseInt("a");
			logger.info("The flow continues successfully.");
		}
		catch (NumberFormatException e){
			logger.info("NumberFormatException caught: {}", e.getMessage());
			logger.info("NumberFormatException caught: {}", e.toString());
			//e.printStackTrace();
		}
	}

	public static void tryMultipleCatches(){
		logger.info("tryMultipleCatches()");
		try{
			int i = Integer.parseInt("a");
			logger.info("The flow continues successfully.");
		}
		catch (NumberFormatException e){
			logger.info("NumberFormatException caught: {}", e.getClass().getSimpleName());
			logger.info("NumberFormatException caught: {}", e.toString());
		}
		catch (Exception e){
			logger.info("NumberFormatException caught: {}", e.getMessage());
		}
	}

	public static void tryMultipleCatchesCollapsed(){
		logger.info("tryMultipleCatchesCollapsed()");
		try{
			int i = Integer.parseInt("a");
			logger.info("The flow continues successfully.");
		}
		catch (NumberFormatException | ArithmeticException e){
			logger.info("NumberFormatException caught: {}", e.getMessage());
			logger.info("NumberFormatException caught: {}", e.toString());
		}
	}

	public static void tryCatchFinally(){
		logger.info("tryCatchFinally()");
		try{
			int i = Integer.parseInt("a");
			logger.info("The flow continues successfully.");
		}
		catch (NumberFormatException e){
			logger.info("NumberFormatException caught: {}", e.getMessage());
			logger.info("NumberFormatException caught: {}", e.toString());
		}
		finally {
			logger.info("finally executed.");
		}
	}

	public static int tryCatchFinallySpecialCase(){
		logger.info("tryCatchFinally()");
		try{
			int i = Integer.parseInt("5");
			logger.info("The flow continues successfully.");
			return 200;
		}
		catch (NumberFormatException e){
			logger.info("NumberFormatException caught: {}", e.getMessage());
			logger.info("NumberFormatException caught: {}", e.toString());
			return 400;
		}
		finally {
			logger.info("finally executed.");
			return 0;
		}
	}

	public static void throwRuntimeException(int size){
		if(size <= 0){
			throw new RuntimeException();
		}
		logger.info("Success! (throwRuntimeException)");
	}

	public static void throwCheckedException(int size) throws IOException {
		if(size <= 0){
			throw new IOException("I am an IOException. I do whatever I want.");
		}
		logger.info("Success! (throwCheckedException)");
	}


	public static void throwCustomExceptions(int size) throws NumberIsZeroException {
		if (size == 0){
			throw new NumberIsZeroException("Number is zero.");
		}
		else if(size < 0){
			throw new NegativeNumberException("Number is negative.");
		}
		logger.info("Success! (throwRuntimeException)");
	}
}
