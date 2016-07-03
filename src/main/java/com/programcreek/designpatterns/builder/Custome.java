package com.programcreek.designpatterns.builder;

class Starbucks {
	private String size;
	private String drink;

	public void setSize(String size) {
		this.size = size;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}
}

abstract class StarbucksBuilder {
	protected Starbucks starbucks;

	public Starbucks getStarbucks() {
		return starbucks;
	}

	public void createStarbucks() {
		starbucks = new Starbucks();
		System.out.println("a drink is created");
	}

	public abstract void buildSize();

	public abstract void buildDrink();
}

class TeaBuilder extends StarbucksBuilder {

	@Override
	public void buildSize() {

		starbucks.setSize("large");
		System.out.println("build large size");
	}

	@Override
	public void buildDrink() {

		starbucks.setDrink("tea");
		System.out.println("build tea");
	}

}

class CoffeeBuilder extends StarbucksBuilder {

	@Override
	public void buildSize() {

		starbucks.setSize("medium");
		System.out.println("build medium size");
	}

	@Override
	public void buildDrink() {

		starbucks.setDrink("coffee");
		System.out.println("build coffee");
	}

}

class Waiter {
	private StarbucksBuilder starbucksBuilder;

	public Starbucks getstarbucksDrink() {
		return starbucksBuilder.getStarbucks();
	}

	public void setStarbucksBuilder(StarbucksBuilder starbucksBuilder) {
		this.starbucksBuilder = starbucksBuilder;
	}

	public void constructStarbucks() {
		starbucksBuilder.createStarbucks();
		starbucksBuilder.buildDrink();
		starbucksBuilder.buildSize();
	}
}

public class Custome {

	public static void main(String[] args) {

		Waiter waiter = new Waiter();
		StarbucksBuilder coffeeBuilder = new CoffeeBuilder();
		waiter.setStarbucksBuilder(coffeeBuilder);
		waiter.constructStarbucks();

		Starbucks drink = waiter.getstarbucksDrink();
	}

}
