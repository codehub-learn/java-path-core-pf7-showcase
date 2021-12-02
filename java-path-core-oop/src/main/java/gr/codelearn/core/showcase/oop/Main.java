package gr.codelearn.core.showcase.oop;

import gr.codelearn.core.showcase.oop.model.Monitor;
import gr.codelearn.core.showcase.oop.model.Smartphone;
import gr.codelearn.core.showcase.oop.model.Smartwatch;
import gr.codelearn.core.showcase.oop.model.TypeOfScreen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		Smartphone smartphone1 = new Smartphone();
		smartphone1.setName("RealYou");
		smartphone1.setPrice(BigDecimal.valueOf(259));
		smartphone1.setTypeOfScreen(TypeOfScreen.AMOLED);

		logger.info("The type of screen for {} is {}", smartphone1.getName(), smartphone1.getTypeOfScreen());
		// Display smartphone1 attributes
		logger.info("{}", smartphone1);

		Smartphone smartphone2 = new Smartphone();
		smartphone2.setName("RealYou");
		smartphone2.setPrice(BigDecimal.valueOf(259));
		smartphone2.setTypeOfScreen(TypeOfScreen.AMOLED);

		// Check for object equality
		if (smartphone1.equals(smartphone2)) {
			logger.info("The smartphones {} and {} are equal", smartphone1.getName(), smartphone2.getName());
		} else {
			logger.info("The smartphones {} and {} are not equal", smartphone1.getName(), smartphone2.getName());
		}

		logger.info("|------------------------|");
		Smartwatch smartwatch1 = new Smartwatch();
		smartwatch1.setSerial("GSM-123");
		smartwatch1.setName("Garmon");
		smartwatch1.setPrice(BigDecimal.valueOf(500));
		smartwatch1.setResolution("420x350");
		smartwatch1.setTypeOfScreen(TypeOfScreen.AMOLED);
		smartwatch1.setWaterproof(true);
		smartwatch1.setTypeOfBracelet("Plastic");
		logger.info("{}", smartwatch1);

		logger.info("|------------------------|");
		Monitor monitor1 = new Monitor();
		monitor1.setSerial("MSG-321");
		monitor1.setName("LB");
		monitor1.setPrice(BigDecimal.valueOf(1500));
		monitor1.setResolution("3840 x 2160");
		monitor1.setTypeOfScreen(TypeOfScreen.OLED);
		monitor1.setRefreshRate(144);
		logger.info("{}", monitor1);

		logger.info("|------------------------|");
		//Method overriding
		logger.info("{}", smartphone1.greetings());
		logger.info("{}", smartwatch1.greetings());
		logger.info("{}", monitor1.greetings());

		logger.info("|------------------------|");
		//Method overloading
		smartphone1.doSomething("racecar");
		smartphone1.doSomething("racecar", "radar", "level");
	}
}
