package com.suggest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;




class Foo1<T>{
	
	
	//不能初始化泛型参数和数组
	/*private T t=new T();
	private T[] tArray=new T[5];*/
	private List<T> list=new ArrayList<T>();
	
	
	private T t;
	private T[] tArray;
	public Foo1(){
		try {
			Class<?> tType=Class.forName("");
			try {
				t=(T)tType.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tArray=(T[])Array.newInstance(tType, 5);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


















public class GenericsReflection {

	public static void main(String[] args) {

		List<String> ls=new ArrayList<String>();
		List<Integer> li=new ArrayList<Integer>();
		System.out.println(li.getClass()==ls.getClass());
		
		//泛型数组初始化时不能声明泛型类型
//		List<String>[] listArray=new List<String>()[];
		
		
		
		List<String> list=new ArrayList<String>();
		//instanceof不允许存在泛型参数
//		System.out.println(list instanceof List<String>);
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	public static <T> T[] toArray(List<T> list,Class<T> tClass){
		T[] t=(T[])Array.newInstance(tClass, list.size());
		for (int i = 0; i <list.size(); i++) {
			t[i]=list.get(i);
		}
		return t;
	}
	
	
	
	
	
	
	
	/*
	 * 严格限定类型采用多重界限
	 */
	public static <T extends Staff & Passenger> void discount(T t){
		if(t.getSalary()<2500&&t.isStanding()){
			System.out.println("8折");
		}
	}
	
	
	
	
	
	
	
	
	
	public void arrayMethod(String[] strArray){}
	
	public void arrayMethod(Integer[] intArray){}
	
	
	public void listMethod(List<String> stringList){}
	
	//java的泛型是类型擦除
	/*public void listMethod(List<Integer> intList){
		
	}*/
	
	
	
	
	
	/*
	 * 泛型结构只参与读操作则限定上界(extends)
	 * 泛型结构只参与写操作则限定上界(super)
	 */
	public static <T> void copy(List<? super T> dest,List<? extends T> src){
		for (int i = 0; i < 10; i++) {
			dest.set(i, src.get(i));
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}















interface Staff{
	public int getSalary();
}

interface Passenger{
	public boolean isStanding();
}

class Me implements Staff,Passenger{
	public boolean isStanding(){
		return true;
	}

	@Override
	public int getSalary() {
		// TODO Auto-generated method stub
		return 2000;
	}
	
}



















