package com.programcreek.simpleJAVA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


public class FileTest {

	private static void readFile1(File fin) throws IOException{
		FileInputStream fis=new FileInputStream(fin);
		BufferedReader br=new BufferedReader(new InputStreamReader(fis));
		String line=null;
		
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
		br.close();
	}
	
	
	private static void readFile2(File fin) throws IOException{
		
		BufferedReader br=new 
				BufferedReader(new FileReader(fin));
		
		String line=null;
		while((line=br.readLine())!=null){
			System.out.println(line);
		}
		br.close();
	}
	
	public static void writeFile1() throws IOException{
		File fout=new File("out.txt");
		FileOutputStream fos=new FileOutputStream(fout);
		
		BufferedWriter bw=new BufferedWriter(
				new OutputStreamWriter(fos));
		for(int i=0;i<10;i++){
			bw.write("something");
			bw.newLine();
		}
		bw.close();
	}
	
	
	public static void writeFile2()throws IOException{
		FileWriter fw=new FileWriter("out.txt");
		for(int i=0;i<10;i++){
			fw.write("something");
			
		}
		fw.close();
	}
	
	public static void writeFile3() throws Throwable{
		PrintWriter pw=new PrintWriter(
				new FileWriter("out.txt"));
		for(int i=0;i<10;i++){
			pw.write("something");
		}
		pw.close();
	}
	
	

	public static void writeFile4() throws IOException{
		File fout=new File("out.txt");
		FileOutputStream fos=new FileOutputStream(fout);
		
		OutputStreamWriter osw=new OutputStreamWriter(fos);
		for(int i=0;i<10;i++){
			osw.write("something");
		}
		osw.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
