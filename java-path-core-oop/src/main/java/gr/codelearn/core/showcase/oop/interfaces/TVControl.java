package gr.codelearn.core.showcase.oop.interfaces;

public interface TVControl {
	void on();
	void off();

	default void selectChannel(){
	}
}
