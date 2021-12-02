package gr.codelearn.core.showcase.oop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
public class Smartwatch extends ElectronicDevices{
	private String resolution;
	private Boolean waterproof;
	private String typeOfBracelet;

	@Override
	public String greetings(){
		return "Hello "+ super.getName() + " from class Smartwatch";
	}
}
