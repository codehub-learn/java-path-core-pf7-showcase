package gr.codelearn.generics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
//		customGeneric();
//		logger.info("{}", genericMethod(5));
//		upperBound();
		lowerBound();
		ArrayList a = new ArrayList();
	}

	public static void lowerBound(){
		List<Integer> intList = new ArrayList<>();
		intList.add(5); intList.add(15); intList.add(25);

		List<Double> doubleList = new ArrayList<>();
		doubleList.add(3.5); doubleList.add(23.53); doubleList.add(34.45);

		List<Number> numberList = new ArrayList<>();
		numberList.add(3.5); numberList.add(23); numberList.add(45f);

		List<? super Integer> lowerBoundList;
		lowerBoundList = intList;
		lowerBoundList = numberList;
//		lowerBoundList = doubleList; // compilation error
	}


	public static void upperBound(){
		List<Integer> intList = new ArrayList<>();
		intList.add(5); intList.add(15); intList.add(25);

		List<Double> doubleList = new ArrayList<>();
		doubleList.add(3.5); doubleList.add(23.53); doubleList.add(34.45);

		logger.info("{}", avg(intList));
		logger.info("{}", avg(doubleList));
	}

	private static double avg(List<? extends Number> numbers){
		double av = 0;
		for (int i = 0; i < numbers.size() ; i++) {
			av += numbers.get(i).doubleValue();
		}
		return av/numbers.size();
	}





	private static void customGeneric() {
		Process<Integer, Double> mangProcess = new Process<>(1, "print", 2013, 8.9);
		Process<String, Integer> sysProcess = new Process("admin1", "print", 2013, 9);
		logger.info("{}", mangProcess);
		logger.info("{}", sysProcess);
	}
}
