package com.suggest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import java.util.TreeSet;

public class Test64 {

	/*
	 * 最值计算使用集合最简单 ，使用数组效率高
	 */
	enum Week {
		Sun, Mon, Tue, Wed, Thu, Fri, Sat
	}

	public static void main(String[] args) {

		Week[] workDays = { Week.Mon, Week.Tue, Week.Wed };
		List<Week> list = Arrays.asList(workDays);
		// asList方法产生的List对象不可更改，此时的ArrayList是一个私有静态类，没有add方法
		list.add(Week.Sat);

		// 判断集合是否相等时只须关注元素是否相等即可
		ArrayList<String> strs = new ArrayList<String>();
		strs.add("A");

		ArrayList<String> str2 = new ArrayList<String>();
		str2.add("A");
		System.out.println(strs.equals(str2));

		// subList产生的列表只是一个视图，所有的修改动作直接作用原列表
		List<String> c = new ArrayList<String>();
		c.add("A");
		c.add("B");
		List<String> c1 = new ArrayList<String>(c);
		List<String> c2 = c.subList(0, c.size());
		c2.add("c");
		System.out.println("c==c1?" + c.equals(c1));
		System.out.println("c==c2?" + c.equals(c2));

		// 推荐使用subList处理局部列表
		List<Integer> initData = Collections.nCopies(100, 0);
		List<Integer> list1 = new ArrayList<Integer>(initData);
		list1.subList(20, 30).clear();
		
		
		//subList生成子列表后，保持原列表的只读状态
		List<String> list2=new ArrayList<String>();
		list2.add("A");
		list2.add("B");
		list2.add("C");
		
		List<String> subList=list2.subList(0, 2);
		list2.add("D");
		System.out.println(list2.size());
		System.out.println(subList.size());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

	public static int max(int[] data) {
		int max = data[0];
		for (int i : data) {
			max = max > i ? max : i;
		}
		return max;
	}

	public static int max1(int[] data) {
		Arrays.sort(data.clone());
		return data[data.length - 1];
	}

	public static int getSecond(Integer[] data) {
		List<Integer> dataList = Arrays.asList(data);
		TreeSet<Integer> ts = new TreeSet<Integer>(dataList);
		return ts.lower(ts.last());
	}

	public static int average(List<Integer> list) {
		int sum = 0;
		if (list instanceof RandomAccess) {
			for (int i = 0; i < list.size(); i++) {
				sum += list.get(i);
			}
		} else {
			for (Integer integer : list) {
				sum += integer;
			}
		}
		return sum / list.size();

	}

}
