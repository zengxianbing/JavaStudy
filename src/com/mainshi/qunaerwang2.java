package com.mainshi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class qunaerwang2 {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		   File f1 = new File("D://haha//about.jsp");  
	        File f2 = new File("D://haha//123.txt");  
	        File f3 = new File("D://haha//1234.txt");  
	        copyFile(f1,f2);  
	        copyFile(f1,f3);  
	        String str=new String("sdf sdf df");
	        String[] strArr=str.split(" ");
/*	        FileInputStream是字节流，BufferedInputStream是字节缓冲流，
	        使用BufferedInputStream读资源比FileInputStream读取资源的效率高（BufferedInputStream的read方法会读取尽可能多的字节）
	        ，且FileInputStream对象的read方法会出现阻塞*/
	}

	public static void copyFile(File src, File dest) throws Exception {
		InputStream input = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dest);
		int n = 0;
		long start = System.currentTimeMillis();
		while ((n = input.read()) != -1) {
			out.write(n);
		}
		long end = System.currentTimeMillis();
		System.out.println("总共用时：" + (end - start));
		System.out.println("复制完成");

		input.close();
		out.close();
	}

	public void copyFile2(File src, File dest) throws Exception{
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(src));

		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(dest));

		byte[] b = new byte[1024];
		long start = System.currentTimeMillis();
		while ((input.read(b)) != -1) {
			output.write(b);
		}

		long end = System.currentTimeMillis();
		System.out.println("总共用时：" + (end - start));
		System.out.println("复制完成");

		input.close();
		output.close();
		
	}

}
