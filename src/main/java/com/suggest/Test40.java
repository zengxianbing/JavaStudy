package com.suggest;

public abstract class Test40 {

	/*
	 * 匿名类的构造函数很特殊
	 */
	public static void main(String[] args) {

		Calculator cl = new Calculator(1, 2) {
			{
				setOperator(Ops.ADD);
			}
		};

		System.out.println(cl.getResult());

	}

}

enum Ops {
	ADD, SUB
}

class Calculator {
	private int i, j, result;

	public Calculator() {
	}

	public Calculator(int _i, int _j) {
		i = _i;
		j = _j;
	}

	protected void setOperator(Ops _op) {
		result = _op.equals(Ops.ADD) ? i + j : i - j;
	}

	public int getResult() {
		return result;
	}

}

class Add extends Calculator {
	{
		setOperator(Ops.ADD);
	}

	public Add(int _i, int _j) {
		super(_i, _j);
	}
}
