package com.suggest;

public class Test31 {

	/*
	 * 在接口中不要存在实现代码
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		B.s.doSomething();
	}

}

interface B{
	public static final S s=new S(){
		public void doSomething(){
			System.out.println("interface implement");
		}
	};
}

interface S{
	public void doSomething();
}















