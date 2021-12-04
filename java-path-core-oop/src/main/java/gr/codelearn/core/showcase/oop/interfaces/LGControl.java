package gr.codelearn.core.showcase.oop.interfaces;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LGControl implements TVControl {

	private static final Logger logger = LoggerFactory.getLogger(LGControl.class);

	public void on(){
		logger.info("LG On");
	}
	public void off(){
		logger.info("LG Off");
	}

	public void selectChannel(){
		logger.info("LG Control ... selects....");
	}
}
