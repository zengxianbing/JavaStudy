package com.jvm;

import java.lang.reflect.Field;

/*
 * -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {

	private static final int _1MB=1024*1024;

	public static void main(String[] args) {

//		Field unsafeField=Unsafe.class.getDeclaredField()[0];
	}

}
class Unsafe{}
