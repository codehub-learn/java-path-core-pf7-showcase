package gr.codelearn.core.showcase.oop.model;

import java.math.BigDecimal;

public class Smartwatch {
	private String serial;
	private String name;
	private BigDecimal price;
	private String resolution;
	private String typeOfScreen;
	private Boolean waterproof;
	private String typeOfBracelet;

	public Smartwatch(final String serial, final String name, final BigDecimal price, final String resolution,
					  final String typeOfScreen, final Boolean waterproof, final String typeOfBracelet) {
		this.serial = serial;
		this.name = name;
		this.price = price;
		this.resolution = resolution;
		this.typeOfScreen = typeOfScreen;
		this.waterproof = waterproof;
		this.typeOfBracelet = typeOfBracelet;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(final String serial) {
		this.serial = serial;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(final BigDecimal price) {
		this.price = price;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(final String resolution) {
		this.resolution = resolution;
	}

	public String getTypeOfScreen() {
		return typeOfScreen;
	}

	public void setTypeOfScreen(final String typeOfScreen) {
		this.typeOfScreen = typeOfScreen;
	}

	public Boolean getWaterproof() {
		return waterproof;
	}

	public void setWaterproof(final Boolean waterproof) {
		this.waterproof = waterproof;
	}

	public String getTypeOfBracelet() {
		return typeOfBracelet;
	}

	public void setTypeOfBracelet(final String typeOfBracelet) {
		this.typeOfBracelet = typeOfBracelet;
	}

	@Override
	public String toString() {
		return "Smartwatch{" + "serial='" + serial + '\'' + ", name='" + name + '\'' + ", price=" + price +
				", resolution='" + resolution + '\'' + ", typeOfScreen='" + typeOfScreen + '\'' + ", waterproof=" +
				waterproof + ", typeOfBracelet='" + typeOfBracelet + '\'' + '}';
	}
}
