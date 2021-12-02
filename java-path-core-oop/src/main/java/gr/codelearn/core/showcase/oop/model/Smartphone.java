package gr.codelearn.core.showcase.oop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
public class Smartphone extends ElectronicDevices{
	private static final Logger logger = LoggerFactory.getLogger(Smartphone.class);
	private Integer ram;
	private String cameraLocation;
	private int numberOfProcessors;

	@Override
	public String greetings(){
		return "Hello "+ super.getName() + " from class Smartphone";
	}

	public void doSomething(String value){
		logger.info("Do something with value {}", new StringBuilder(value).reverse());
	}

	public void doSomething(String... values){
		for (final String value : values) {
			logger.info("The length of {} is {}",value, value.length());
		}
	}

	public void doSomething(List<String> values){
		for (final String value : values) {
			logger.info("The value is {}",value);
		}
	}
}
