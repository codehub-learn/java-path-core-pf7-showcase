package gr.codelearn.core.showcase.oop.interfaces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainInterfaces {

	private static final Logger logger = LoggerFactory.getLogger(MainInterfaces.class);

	public static void main(String[] args) {

//		TVControl tvControl = new TVControl();
//		tvControl.off();

//		LGControl lgControl = new LGControl();
//		lgControl.off();
//
//		SamControl samControl = new SamControl();
//		samControl.off();

		TVControl tvControl = new LGControl();
		tvControl.off();

		tvControl = new SamControl();
		tvControl.off();

	}
}
