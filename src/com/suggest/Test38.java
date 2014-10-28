package com.suggest;

public class Test38 {

	/*
	 * 使用静态内部类提高封装性
	 * 
	 * 静态内部类不持有外部类的引用
	 * 静态内部类不依赖外部类
	 * 普通内部类不能声明static的方法和变量
	 * 
	 */
	public static void main(String[] args) {

		Person2 person = new Person2();
		person.setHome(new Person2.Home("shanghai", "021"));
	}

}

class Person2 {
	private String name;
	private Home home;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public static class Home {
		private String address;
		private String tel;

		public Home(String address, String tel) {
			super();
			this.address = address;
			this.tel = tel;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getTel() {
			return tel;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}
	}
}
