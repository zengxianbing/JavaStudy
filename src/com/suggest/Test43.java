package com.suggest;

public class Test43 {

	/*
	 * 避免对象的浅拷贝
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Person3 implements Cloneable{
	
	private String name;
	
	private Person3 father;

	public String getName() {
		return name;
	}

	public Person3(String name, Person3 father) {
		super();
		this.name = name;
		this.father = father;
	}

	public Person3(String name) {
		super();
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person3 getFather() {
		return father;
	}

	public void setFather(Person3 father) {
		this.father = father;
	}
	
	
	public Person3 clone(){
		Person3 p=null;
		try {
			
			p=(Person3)super.clone();
			p.setFather(new Person3(p.getFather().getName()));
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}
	
	
}




















