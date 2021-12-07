package gr.codelearn.core.showcase.exception.domain.exception;

// checked exception
public class NumberIsZeroException extends Exception{
	public NumberIsZeroException(String message) {
		super(message);
	}
}
