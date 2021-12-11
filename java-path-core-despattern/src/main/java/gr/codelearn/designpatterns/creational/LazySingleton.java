package gr.codelearn.designpatterns.creational;

public class LazySingleton {

	private static LazySingleton instance = null;

	private LazySingleton(){}

	public synchronized static LazySingleton getInstance(){
		if (instance == null){
			instance = new LazySingleton();
		}
		return instance;
	}
}
