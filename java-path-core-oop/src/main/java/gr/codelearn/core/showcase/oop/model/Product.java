package gr.codelearn.core.showcase.oop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
	private String serial;
	private String name;
	private BigDecimal price;

	public String greetings(){
		return "Hello "+ name+ " from class Product";
	}
}
