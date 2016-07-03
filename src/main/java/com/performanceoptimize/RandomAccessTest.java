package com.performanceoptimize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
/*
 * RandomAccess接口
 */
public class RandomAccessTest {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		Object o;
		if (list instanceof RandomAccess) {
			for (int i = 0; i < list.size(); i++) {
				o = list.get(i);

			}
		} else {

			Iterator itr = list.iterator();
			for (int i = 0; i < list.size(); i++) {
				o = itr.next();
			}

		}

	}

}
