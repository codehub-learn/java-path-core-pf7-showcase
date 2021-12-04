package gr.codelearn.core.showcase.oop.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SamControl implements TVControl {

	private static final Logger logger = LoggerFactory.getLogger(SamControl.class);

	public void on(){
		logger.info("Samsung On");
	}
	public void off(){
		logger.info("Samsung Off");
	}

	public void selectChannel(){
		logger.info("Samsung Control ... selects....");
	}
}
