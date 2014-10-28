package com.suggest;

public class Test45 {

	/*
	 * 覆写equals方法时不要识别不出自己 equals应该考虑null值情景
	 * 
	 * 在equals中使用getClass进行类型判断
	 * 
	 * 覆写equals方法必须覆写hashcode方法
	 * 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Person4 {

	private String name;

	public Person4(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean equals(Object obj) {
		/*
		 * if(obj instanceof Person4){ Person4 p=(Person4)obj; return
		 * name.equalsIgnoreCase(p.getName().trim()); }
		 */
		if (obj instanceof Person4) {
			Person4 p = (Person4) obj;

			if (p.getName() == null || name == null) {
				return false;
			} else {
				return name.equalsIgnoreCase(p.getName());
			}

		}
		return false;
	}

}