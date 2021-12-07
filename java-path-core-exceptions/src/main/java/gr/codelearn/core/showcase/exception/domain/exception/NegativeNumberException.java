package gr.codelearn.core.showcase.exception.domain.exception;

// runtime exception
public class NegativeNumberException extends RuntimeException {
	public NegativeNumberException(String message) {
		super(message);
	}

	public NegativeNumberException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
