package com.mainshi;

public class test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(func());
	}
	
	public static int func(){
		int val=0;
		try {
			val=1;
			System.out.println(val);
			return val;
		} catch (Exception e) {
			// TODO Auto-generated catch block

			val=2;
			
			return val;
		}finally{
			val=3;
			System.out.println(val);
			//return val;
		}
	}

}
