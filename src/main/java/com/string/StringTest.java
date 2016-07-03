package com.string;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.junit.Test;

public class StringTest {

	@Test
	public void test1() {
		String s1 = "abc";
		String s2 = "abc";
		System.out.println(s1 == s2);
	}

	@Test
	public void test2() {
		String s1 = "abc";
		String s2 = "abc";
		String s3 = s1 + s2;
		String s4 = "abc" + "abc";
		String s5 = "ab" + "cabc";
		System.out.println(s3 == s4);
		System.out.println(s4 == s5);

		/*
		 * 输出：false true。上面的程序，"abc" + "abc"是常量运算表达式constant expression。
		 * 编译器就可以计算出值了，这就是编译时计算。同时这个表达式会被看做是string literal。 但是：String s3 =
		 * s1+s2；那么s3的值就只能在运行的时候才能确定， 这就是运行时计算。可见运行时会创建一个新的String，并且不会被当成string
		 * literal。
		 */
	}

	@Test
	public void test3() {
		String s1 = "abc";
		String s2 = "abc";
		String s3 = s1 + s2;
		String s4 = s3.intern();
		String s5 = "ab" + "cabc";
		System.out.println(s4 == s5);
		System.out.println(s3 == s5);
		System.out.println(s3.intern() == s3);
		System.out.println(s3.intern() == s4);
		System.out.println(s5.intern() == s5);
	}

	@Test
	public void test4() {
		Integer i1 = 6;
		Integer i2 = 6;
		Integer i3 = 3 + 3;
		Integer i4 = 3 * 2;
		System.out.println(i1 == i2);// true
		System.out.println(i3 == i2);// true
		System.out.println(i4 == i2);// true

		Integer i5 = 128;
		Integer i6 = 128;
		System.out.println(i5 == i6);// false
	}

	private static void BoolearnLiteral() {
		Boolean b1 = true;
		Boolean b2 = true;
		System.out.println(b1 == b2);// false
	}

	/** Creates a new instance of testssb */
	final static int ttime = 70000;// 测试循环次数

	public void test(String s) {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < ttime; i++) {
			s += "add";
		}
		long over = System.currentTimeMillis();
		System.out.println(" 操作 " + s.getClass().getName() + " 类型使用的时间为： "
				+ (over - begin) + " 毫秒 ");
	}

	public void test(StringBuffer s) {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < ttime; i++) {
			s.append("add");
		}
		long over = System.currentTimeMillis();
		System.out.println(" 操作 " + s.getClass().getName() + " 类型使用的时间为： "
				+ (over - begin) + " 毫秒 ");
	}

	public void test(StringBuilder s) {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < ttime; i++) {
			s.append("add");
		}
		long over = System.currentTimeMillis();
		System.out.println(" 操作 " + s.getClass().getName() + " 类型使用的时间为： "
				+ (over - begin) + " 毫秒 ");
	}

	// 对 String 直接进行字符串拼接的测试
	public void test21() {
		String s2 = "abadf";
		long begin = System.currentTimeMillis();
		for (int i = 0; i < ttime; i++) {
			String s = s2 + s2 + s2;
		}
		long over = System.currentTimeMillis();
		System.out.println(" 操作字符串对象引用相加类型使用的时间为： " + (over - begin) + " 毫秒 ");
	}

	public void test31() {
		long begin = System.currentTimeMillis();
		for (int i = 0; i < ttime; i++) {
			String s = "abadf" + "abadf" + "abadf";
		}
		long over = System.currentTimeMillis();
		System.out.println(" 操作字符串相加使用的时间为： " + (over - begin) + " 毫秒 ");
	}

	public static void main(String[] args) {
		String s1 = "abc";
		StringBuffer sb1 = new StringBuffer("abc");
		StringBuilder sb2 = new StringBuilder("abc");
		StringTest t = new StringTest();
		t.test(s1);
		t.test(sb1);
		t.test(sb2);
		t.test21();
		t.test31();
	}

	/*
	 * 1、String类不可变性的好处
	 * 
	 * 只有当字符串是不可变的，字符串池才有可能实现。字符串池的实现可以在运行时节约很多heap空间，
	 * 因为不同的字符串变量都指向池中的同一个字符串。但如果字符串是可变的，那么String interning将不能实现(译者注：String
	 * interning是指对不同的字符串仅仅只保存一个
	 * ，即不会保存多个相同的字符串。)，因为这样的话，如果变量改变了它的值，那么其它指向这个值的变量的值也会一起改变。
	 * 如果字符串是可变的，那么会引起很严重的安全问题
	 * 。譬如，数据库的用户名、密码都是以字符串的形式传入来获得数据库的连接，或者在socket编程中，主机名和端口都是以字符串的形式传入
	 * 。因为字符串是不可变的，所以它的值是不可改变的，否则黑客们可以钻到空子，改变字符串指向的对象的值，造成安全漏洞。
	 * 因为字符串是不可变的，所以是多线程安全的，同一个字符串实例可以被多个线程共享。这样便不用因为线程安全问题而使用同步。字符串自己便是线程安全的。
	 * 类加载器要用到字符串
	 * ，不可变性提供了安全性，以便正确的类被加载。譬如你想加载java.sql.Connection类，而这个值被改成了myhacked
	 * .Connection，那么会对你的数据库造成不可知的破坏。
	 * 因为字符串是不可变的，所以在它创建的时候hashcode就被缓存了，不需要重新计算。这就使得字符串很适合作为Map中的键
	 * ，字符串的处理速度要快过其它的键对象。这就是HashMap中的键往往都使用字符串。 以上就是我总结的字符串不可变性的好处。
	 */

	public static void method_Zhuanhuan_Qukong_Bijiao() {
		String s = "     hello Java    ";

		// 打印结果是：（hello和java前后门都有空格）hello java
		sop(s.toUpperCase());
		// 打印结果是：（HELLO和JAVA前后门都有空格）HELLO JAVA
		sop(s.toLowerCase());
		// 打印及结果是：不带空格的“hello java”
		sop(s.trim());
		// 比较数的大写，打印结果是：1，因为b对应ascii值是98，
		// a对应是97，所以b-a=1
		String s1 = "abc";
		String s2 = "aaa";
		sop(s1.compareTo(s2));
	}

	public static void method_sub() {
		String s = "abcdef";
		// 打印结果是：cdef，从指定位置开始到结尾。如果角标不存在，会出现字符串角标越界。
		sop(s.substring(2));
		// 打印结果是：cd，包含头，不包含尾。
		sop(s.substring(2, 4));
	}

	public static void method_split() {
		String s = "zhangsan,lisi,wangwu";
		String[] arr = s.split(",");
		for (int x = 0; x < arr.length; x++) {
			sop(arr[x]);
		}
	}

	public static void method_replace() {
		String s = "hello java";
		// String s1 = s.replace('a','n');
		// String s1 = s.replace('w','n'); 如果要替换的字符不存在，返回的还是原串

		String s1 = s.replace("java", "world");// 打印结果是：hello world
		sop("s=" + s); // 打印结果是：hello java因为字符串一旦被初始化，值就不可被改变
		sop("s1=" + s1);// 打印结果是：hello jnvn
	}

	public static void method_trans() {
		char[] arr = { 'a', 'b', 'c', 'd', 'e', 'f' };
		String s = new String(arr, 1, 3);
		sop("s=" + s);// 打印结果是：bcd
		String s1 = "zxcvbnm";
		char[] chs = s1.toCharArray();
		for (int x = 0; x < chs.length; x++) {
			sop("ch=" + chs[x]);// 打印结果是：ch=z，x,c,v,b,n,m
		}
	}

	public static void method_is() {
		String str = "ArrayDemo.java";
		// 判断文件名称是否是Array单词开头
		sop(str.startsWith("Array"));

		// 判断文件名称是否是.java的文件
		sop(str.endsWith(".java"));

		// 判断文件中是否包含Demo
		sop(str.contains("Demo"));
	}

	public static void method_get() {
		String str = "abcdeakpf";
		// 长度
		sop(str.length());
		// 根据索引获取字符
		sop(str.charAt(4));
		// sop(str.charAt(40));当访问到字符串中不存在的角标时会发生StringIndexOutOfBoundsException（字符串角标越界异常）
		// 根据字符获取索引
		// sop(str.indexOf('a'));
		sop(str.indexOf('a', 3));// 打印的是5，因为角标3是d，
		// 所以从d后面开始找a，第5个角标是a
		// sop(str.indexOf('t',3))打印：-1，如果没有找到角标，返回-1

		// 反向索引一个字符出现的位置(从右往左查找，但是角标还是从左开始)
		sop(str.lastIndexOf("a"));
	}

	public static void test5() {
		method_Zhuanhuan_Qukong_Bijiao();
		// method_sub();
		// method_split();
		// method_replace();
		// method_trans();
		// method_is();
		// method_get();

		/*
		 * String s1 = "abc"; String s2 = new String("abc"); String s3 = "abc";
		 * System.out.println(s1==s2); System.out.println(s1==s3);
		 */
	}

	public static void sop(Object obj) {
		System.out.println(obj);
	}

	public void test6() {
		List<String> list = new ArrayList<String>();  
        list.add("aString");  
        list.add("thrid");  
        list.add("aLongString");  
        list.add("twoString");  
		System.out.println(list);

		/*for (int i = list.size()-1; i >=0; i--) { 
		    if (((String) list.get(i)).startsWith("abcde")) { 
		     list.remove(i); 
		    } 
		} */
		
		
		/*for (int i = 0; i < list.size(); i++) { 
		    if (((String) list.get(i)).startsWith("abcde")) { 
		     list.remove(i); 
		     i=i-1; 

		   } 
		} */
		
		
		
		 /*  for (Iterator it = list.iterator(); it.hasNext();) { 
	            String str =  (String)it.next(); 
	            if (str.equals("chengang")){ 
	                it.remove(); 
	            } 
	        }*/
		// list = removeStartWithA(list);
		
		
		System.out.println(list);

	}
	
	  public static List<String> removeStartWithA(List<String> list){  
	        List<String> tempList = new ArrayList<String>();  
	        for(String str:list){  
	            if(!str.startsWith("a")){  
	                tempList.add(str);  
	            }  
	        }  
	        return tempList;  
	    }  
	  
	  
	  
	  
	  
	  @Test
	  public void testStringTokenizer(){
		  String str=" hello,java,delphi,asp,php";
		  StringTokenizer st=new StringTokenizer(str,",");
		  while(st.hasMoreElements()){
			  System.out.println(st.nextElement());
		  }
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  

}
