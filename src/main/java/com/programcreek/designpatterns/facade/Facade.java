package com.programcreek.designpatterns.facade;

class CPU {
	public void processData(){}
}

class Memory {
	public void load() {
	}
}

class HardDrive {
	public void readdata() {
	}
}

class Computer {
	private CPU cpu;
	private Memory memory;
	private HardDrive hardDrive;

	public Computer() {
		super();
		this.cpu = cpu;
		this.memory = memory;
		this.hardDrive = hardDrive;
	}

	public void run() {
		cpu.processData();
		memory.load();
		hardDrive.readdata();
	}

}

public class Facade {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Computer computer = new Computer();
		computer.run();
	}

}
