package gr.codelearn.core.showcase.oop;

import gr.codelearn.core.showcase.oop.model.Smartphone;
import gr.codelearn.core.showcase.oop.model.Smartwatch;

import java.math.BigDecimal;

public class Main {
	public static void main(String[] args) {
		Smartphone smartphone1 = new Smartphone();
		smartphone1.setName("RealYou");
		smartphone1.setPrice(BigDecimal.valueOf(259));
		smartphone1.setTypeOfScreen("OLED");
		System.out.println("The type of screen for " + smartphone1.getName() + " is " + smartphone1.getTypeOfScreen());
		System.out.println(smartphone1);

		Smartwatch smartwatch1 = new Smartwatch("GSM-123","Garmon",BigDecimal.valueOf(500),"420x350","AMOLED",true,
												"Plastic");
		System.out.println(smartwatch1);
	}
}
