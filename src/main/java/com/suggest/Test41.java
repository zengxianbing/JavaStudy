package com.suggest;

public class Test41 {

	/*
	 * 让多重继承成为现实
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

interface Father1 {
	public int strong();
}

interface Mother1 {
	public int kind();
}

class FatherImpl implements Father1 {

	@Override
	public int strong() {
		// TODO Auto-generated method stub
		return 8;
	}

}

class MotherImpl implements Mother1 {

	@Override
	public int kind() {
		// TODO Auto-generated method stub
		return 8;
	}

}

class Son1 extends FatherImpl implements Mother1 {

	@Override
	public int strong() {
		return super.strong() + 1;
	}

	@Override
	public int kind() {
		// TODO Auto-generated method stub
		return new MotherSpecial().kind();
	}

	private class MotherSpecial extends MotherImpl {

		public int kind() {
			return super.kind() - 1;
		}
	}
}

class Daughter extends MotherImpl implements Father1 {

	@Override
	public int strong() {
		return new FatherImpl() {
			public int strong() {
				return super.strong() - 2;
			}
		}.strong();
	}

}
