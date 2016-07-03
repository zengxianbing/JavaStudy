package com.suggest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test76 {

	public static void main(String[] args) {

		List<String> list1=new ArrayList<String>();
		list1.add("A");
		list1.add("B");

		List<String> list2=new ArrayList<String>();
		list2.add("C");
		list2.add("B");
		//并集
		list1.addAll(list2);
		
		//交集
		list1.retainAll(list2);
		
		//差集
		list1.retainAll(list2);
		
		
		//无重复的并集
		list2.removeAll(list1);
		list1.addAll(list2);
		
		
		
		
		
		
		
		//使用shuffle打乱列表
		
		int tagCloudNum=10;
		List<String> tagClouds=new ArrayList<String>(tagCloudNum);
		Random rand=new Random();
		for (int i = 0; i < tagCloudNum; i++) {
			int randomPosition=rand.nextInt();
			String temp=tagClouds.get(i);
			tagClouds.set(i,tagClouds.get(randomPosition));
			tagClouds.set(randomPosition, temp);
		}
		
		
		for (int i = 0; i < tagCloudNum; i++) {
			int randomPosition=rand.nextInt(tagCloudNum);
			Collections.swap(tagClouds, i, randomPosition);
			
		}
		
		
		
		
		Collections.shuffle(tagClouds);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
