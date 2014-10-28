package com.suggest;

public class Test5 {

	/*
	 * 别让null值和空值威胁到变长方法
	 */
	public void methodA(String str, Integer... is) {

	}

	public void methodB(String str, String... strs) {

	}

	public static void main(String[] args) {

		Test5 test5 = new Test5();
		test5.methodA("china", 0);
		//test5.methodA("china", "People");
		test5.methodA("china");
		test5.methodA("china", null);
		/*String[] strs=null;
		test5.methodA("china", strs);
*/
	}

}
