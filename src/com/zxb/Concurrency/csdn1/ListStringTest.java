package com.zxb.Concurrency.csdn1;

import java.util.List;

public class ListStringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static String listToString(List<String> stringList) {

		if (stringList == null) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (String string : stringList) {
			if (flag) {
				result.append(",");
			} else {
				flag = true;
			}
			result.append(string);
		}

		return result.toString();
	}

	public static String listToStringPerson(List<Person1> list, int age,
			String sep) {
		if (list == null)
			return null;
		StringBuilder result = new StringBuilder();
		boolean flag = false;
		for (Person1 person1 : list) {
			if (person1.getAge() < age) {
				continue;
			}
			if (flag) {
				result.append(sep == null ? "" : sep);
			} else {
				flag = true;
			}
			result.append(person1.toString());
		}
		return result.toString();
	}

}

class Person1 {
	private String name;
	private int age;

	public Person1() {
	}

	public Person1(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		if (name == null) {
			name = "";
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return getName();
	}
}
