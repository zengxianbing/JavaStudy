package com.suggest;

import java.io.IOException;
import java.io.Serializable;

public class Test14 {

	/*
	 * 使用序列化的私有方法巧妙解决部分属性持久化问题
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}














class Salary implements Serializable{
	private static final long serialVersionUID=44466L;
	
	
	private int basePay;
	
	private int bonus;

	public Salary(int basePay, int bonus) {
		super();
		this.basePay = basePay;
		this.bonus = bonus;
	}

	public int getBasePay() {
		return basePay;
	}

	public void setBasePay(int basePay) {
		this.basePay = basePay;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	

}


class Person1 implements Serializable{
	private static final long serialVersionUID=446556L;
			
	private String name;
	
	private Salary salary;

	public Person1(String name, Salary salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	
	
	private void writeObject(java.io.ObjectOutputStream out) throws IOException{
		out.defaultWriteObject();
		out.writeInt(salary.getBasePay());
	}
	
	
	
	private void readObject(java.io.ObjectInputStream in) throws ClassNotFoundException, IOException{
		in.defaultReadObject();
		salary=new Salary(in.readInt(),0);
	}
	
	
	
	
	
	
	
	
	
	
	
			
			
}









































