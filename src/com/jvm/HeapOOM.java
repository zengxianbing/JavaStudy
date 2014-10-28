package com.jvm;

import java.util.ArrayList;
import java.util.List;

/*
 * -xMs20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

	
	static class OOMObject{}
/*	java  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -
	XX:SurvivorRatio=8*/
	
	public static void main(String[] args) {

		List<OOMObject> list=new ArrayList<OOMObject>();
		while(true){
			list.add(new OOMObject());
		}
	}

}
