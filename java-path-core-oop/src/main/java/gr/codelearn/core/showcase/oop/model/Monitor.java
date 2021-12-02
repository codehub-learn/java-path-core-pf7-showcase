package gr.codelearn.core.showcase.oop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(callSuper = true)
public class Monitor extends ElectronicDevices{
	private Integer refreshRate;
	private String resolution;
}
