package com.programcreek.designpatterns.proxy;

interface CheatingWife {
	public void seduceMan();

	public void happyWithMan();
}

class HouseWifeOne implements CheatingWife {

	@Override
	public void seduceMan() {
		System.out
				.println("HouseWifeOne secude men, such as making some sexy poses ...");
	}

	@Override
	public void happyWithMan() {
		System.out.println("HouseWifeOne is happy with man ...");
	}

}

class BusinessAgent implements CheatingWife {

	private CheatingWife cheatingWife;

	public BusinessAgent() {
		this.cheatingWife = new HouseWifeOne();
	}

	public BusinessAgent(CheatingWife cheatingWife) {
		this.cheatingWife = cheatingWife;
	}

	@Override
	public void seduceMan() {

		this.cheatingWife = cheatingWife;
	}

	@Override
	public void happyWithMan() {

		this.cheatingWife.happyWithMan();
	}

}

public class Proxy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BusinessAgent businessAgent = new BusinessAgent();
		businessAgent.seduceMan();
		businessAgent.happyWithMan();

	}

}
