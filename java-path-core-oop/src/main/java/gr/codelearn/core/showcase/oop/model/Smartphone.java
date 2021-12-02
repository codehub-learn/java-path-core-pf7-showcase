package gr.codelearn.core.showcase.oop.model;

import java.math.BigDecimal;

public class Smartphone {
	private String serial;
	private String name;
	private BigDecimal price;
	private String typeOfScreen;
	private Integer ram;
	private String cameraLocation;
	private int numberOfProcessors;

	public Smartphone(final String serial, final String name, final BigDecimal price, final String typeOfScreen,
					  final Integer ram, final String cameraLocation, final int numberOfProcessors) {
		this.serial = serial;
		this.name = name;
		this.price = price;
		this.typeOfScreen = typeOfScreen;
		this.ram = ram;
		this.cameraLocation = cameraLocation;
		this.numberOfProcessors = numberOfProcessors;
	}

	public Smartphone() {
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
		if (price.equals(BigDecimal.ZERO)) {
			this.price = price.multiply(BigDecimal.valueOf(-1));
		} else {
			this.price = price;
		}
	}

	public String getTypeOfScreen() {
		return typeOfScreen;
	}

	public void setTypeOfScreen(final String typeOfScreen) {
		this.typeOfScreen = typeOfScreen;
	}

	public Integer getRam() {
		return ram;
	}

	public void setRam(final Integer ram) {
		this.ram = ram;
	}

	public String getCameraLocation() {
		return cameraLocation;
	}

	public void setCameraLocation(final String cameraLocation) {
		this.cameraLocation = cameraLocation;
	}

	public int getNumberOfProcessors() {
		return numberOfProcessors;
	}

	public void setNumberOfProcessors(final int numberOfProcessors) {
		this.numberOfProcessors = numberOfProcessors;
	}

	@Override
	public String toString() {
		return "Smartphone{" + "serial='" + serial + '\'' + ", name='" + name + '\'' + ", price=" + price +
				", typeOfScreen='" + typeOfScreen + '\'' + ", ram=" + ram + ", cameraLocation='" + cameraLocation +
				'\'' + ", numberOfProcessors=" + numberOfProcessors + '}';
	}
}
