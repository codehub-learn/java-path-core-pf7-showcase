package gr.codelearn.core.showcase.oop;

import gr.codelearn.core.showcase.oop.model.Smartphone;
import gr.codelearn.core.showcase.oop.model.Smartwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);
	public static void main(String[] args) {
		Smartphone smartphone1 = new Smartphone();
		smartphone1.setName("RealYou");
		smartphone1.setPrice(BigDecimal.valueOf(259));
		smartphone1.setTypeOfScreen("OLED");
		logger.info("The type of screen for {} is {}",smartphone1.getName(), smartphone1.getTypeOfScreen());
		logger.info("{}", smartphone1);

		Smartwatch smartwatch1 = new Smartwatch("GSM-123","Garmon",BigDecimal.valueOf(500),"420x350","AMOLED",true,
												"Plastic");
		logger.info("{}", smartwatch1);
	}
}
