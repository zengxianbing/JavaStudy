package com.zxb.guava;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;

public class testGuavaImmutable extends TestCase {

	
	@Ignore
	public void testGuavaImmutable1() {

		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		System.out.println("list:" + list);

		ImmutableList<String> imList = ImmutableList.copyOf(list);
		System.out.println("imlist:" + imList);

		ImmutableList<String> imOflist = ImmutableList.of("peida", "jerry",
				"harry");
		System.out.println("imOfList:" + imOflist);

		ImmutableSortedSet<String> imSortList = ImmutableSortedSet.of("a", "b",
				"c", "a", "d", "b");
		System.out.println("imSortList:" + imSortList);

		list.add("baby");
		System.out.println("list add a item after list:" + list);
		System.out.println("list add a item after imlist:" + imList);

		ImmutableSet<Color> imColorSet = ImmutableSet.<Color> builder().add(
				new Color(0, 255, 255)).add(new Color(0, 255, 255)).build();

		System.out.println("imColorSet:" + imColorSet);
	}

	 
	@Ignore  
	public void testCotyXXXOf() {
		ImmutableSet<String> imSet = ImmutableSet.of("peida", "jerry", "harry",
				"lisa");
		System.out.println("imSet:" + imSet);
		ImmutableList<String> imList = ImmutableList.copyOf(imSet);
		System.out.println("imList:" + imList);
		ImmutableSortedSet<String> imSortSet = ImmutableSortedSet.copyOf(imSet);
		System.out.println("imSortSet:" + imSortSet);

		List<String> list = new ArrayList<String>();
		for (int i = 0; i < 20; i++) {
			list.add(i + "x");
		}

		System.out.println("list:" + list);
		ImmutableList<String> imInfoList = ImmutableList.copyOf(list.subList(2,
				18));

		System.out.println("imInfoList:" + imInfoList);

		int imInfoListSize = imInfoList.size();

		System.out.println("imInfoListSize" + imInfoListSize);

		ImmutableSet<String> imInfoSet = ImmutableSet.copyOf(imInfoList
				.subList(2, imInfoListSize - 3));
		System.out.println("imInfoSet:" + imInfoSet);

	}

	@Test
	public void testAsList() {
		ImmutableList<String> imList = ImmutableList.of("peida", "jerry",
				"harry", "lisa", "jerry");
		System.out.println("imList£º" + imList);
		ImmutableSortedSet<String> imSortList = ImmutableSortedSet
				.copyOf(imList);
		System.out.println("imSortList£º" + imSortList);
		System.out.println("imSortList as list£º" + imSortList.asList());
	}

}

class Color {
	public Color(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	private int a;
	private int b;
	private int c;

}
