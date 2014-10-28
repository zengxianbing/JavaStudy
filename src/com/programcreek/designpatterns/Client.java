package com.programcreek.designpatterns;

interface CPU {
	void process();
}

interface CPUFactory {
	CPU produceCPU();
}

class IntelFactory implements CPUFactory {

	@Override
	public CPU produceCPU() {
		// TODO Auto-generated method stub
		return new IntelCPU();
	}

}

class AMDFactory implements CPUFactory {

	@Override
	public CPU produceCPU() {
		// TODO Auto-generated method stub
		return new AMDCPU();
	}

}

class AMDCPU implements CPU {

	@Override
	public void process() {
		System.out.println("AMD is processing...");
	}

}

class IntelCPU implements CPU {

	@Override
	public void process() {
		System.out.println("Intel is processing...");
	}

}

class Computer {
	CPU cpu;

	public Computer(CPUFactory factory) {
		cpu = factory.produceCPU();
		cpu.process();
	}
}

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		new Computer(createSpecificFactory());

	}

	public static CPUFactory createSpecificFactory() {
		int sys = 0;
		if (sys == 0)
			return new AMDFactory();
		else
			return new IntelFactory();
	}

}
