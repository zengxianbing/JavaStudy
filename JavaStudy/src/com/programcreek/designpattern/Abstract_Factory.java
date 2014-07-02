package com.programcreek.designpattern;

interface CPU {
	void process();
}

class IntelCPU implements CPU {

	@Override
	public void process() {
		System.out.println("Intel is processing...");
	}

}

class AMDCPU implements CPU {

	@Override
	public void process() {
		System.out.println("AMD is processing...");
	}

}

interface CPUFactory {
	CPU produceCPU();
}

class AMDFactory implements CPUFactory {

	@Override
	public CPU produceCPU() {
		// TODO Auto-generated method stub
		return new AMDCPU();
	}

}

class IntelFactory implements CPUFactory {

	@Override
	public CPU produceCPU() {
		// TODO Auto-generated method stub
		return new IntelCPU();
	}

}

public class Abstract_Factory {
	public static void main(String[] args) {

		createSpecificFactory();
	}

	public static CPUFactory createSpecificFactory() {
		int say = 0;
		if (say == 0)
			return new AMDFactory();
		else
			return new IntelFactory();
	}

}
