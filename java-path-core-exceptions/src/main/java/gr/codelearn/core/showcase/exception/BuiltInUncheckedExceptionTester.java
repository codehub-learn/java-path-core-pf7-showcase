package gr.codelearn.core.showcase.exception;

import gr.codelearn.core.showcase.exception.domain.Child;
import gr.codelearn.core.showcase.exception.domain.Parent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuiltInUncheckedExceptionTester {

	private static final Logger logger = LoggerFactory.getLogger(BuiltInUncheckedExceptionTester.class);

	public static void main(String[] args) {
		//divisionByZero();
		//arrayOutOfBounds();
		//stringOutOfBounds();
		//notANumberExample();
		//methodCallOnNull();
		//incorrectClassCast();
		//modifyUnmodifiableCollection1();
		//modifyUnmodifiableCollection2();
		//setWrongDataTypeToArray();
	}

	public static int divisionByZero(){
		return 5/0;
	}

	public static int arrayOutOfBounds(){
		int array[] = new int[20];
		return array[21];
	}

	public static int stringOutOfBounds(){
		String sentence = "Artemis is the goddess of the hunt.";
		return sentence.charAt(500);
	}

	public static void notANumberExample(){
		double sqrt = Math.sqrt(-3);
		logger.info("{}", sqrt * 10);
	}

	public static String methodCallOnNull(){
		Object o = null;
		return o.toString();
	}

	public static void incorrectClassCast(){
		Parent parent = new Parent();
		Child child = (Child) parent;
	}

	public static void modifyUnmodifiableCollection1(){
		ArrayList<Integer> myIntegerArray = new ArrayList<>();
		myIntegerArray.add(2);
		myIntegerArray.add(3);
		myIntegerArray.add(78);

		List<Integer> unmodifiableList = Collections.unmodifiableList(myIntegerArray);
		unmodifiableList.add(2);
	}

	public static void modifyUnmodifiableCollection2(){
		List<Integer> unmodifiableList = List.of();
		unmodifiableList.add(5);
	}

	public static void setWrongDataTypeToArray(){
		Object[] myArrays = new Integer[10];
		myArrays[2] = "5";
	}
}
