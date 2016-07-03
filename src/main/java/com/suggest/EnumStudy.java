package com.suggest;

enum Season {
	Spring, Summer, Autumn, Winter;

	public static boolean contains(String name) {
		Season[] season = values();
		for (Season s : season) {
			if (s.name().equals(name)) {
				return true;
			}

		}
		return false;
	}
}

interface Car {
};

class FordCar implements Car {
};

class BuickCar implements Car {
};

enum CarFactory {
	FordCar, BuickCar;

	public Car create() {
		switch (this) {
		case FordCar:
			return new FordCar();
		case BuickCar:
			return new BuickCar();

		default:
			throw new AssertionError("无效参数");
		}
	}
}

public class EnumStudy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
