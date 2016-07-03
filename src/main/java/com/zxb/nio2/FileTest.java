package com.zxb.nio2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FileTest {

	@Test
	public void test1() throws IOException{
	Iterable<Path> dirs=FileSystems.getDefault().getRootDirectories();
	for (Path name : dirs) {   
	     System.out.println(name);   
	} 
	
	
	Iterable<Path> dirs1=FileSystems.getDefault().getRootDirectories();
	ArrayList<Path> list=new ArrayList<Path>();
	for(Path name:dirs){
		list.add(name);
	}
	
	Path[] arr=new Path[list.size()];
	list.toArray(arr);
	
	for(Path path:arr){
		System.out.println(path);
	}
	
	
	
	File[] roots=File.listRoots();
	for(File root:roots){
		System.out.println(root);
	}
	
	/*Path newdir=FileSystems.getDefault().getPath("D://test2");
	Set<PosixFilePermission> persm=PosixFilePermissions.fromString("rwxr-x---");
	FileAttribute<Set<PosixFilePermission>> attr=PosixFilePermissions.asFileAttribute(persm);
	Files.createDirectory(newdir,attr);*/
	
	Path newdir=FileSystems.getDefault().getPath("D://test2//test2");
	Files.createDirectories(newdir);
	
	
	Path path=Paths.get("D:");
	DirectoryStream<Path> ds=Files.newDirectoryStream(path,"*.{txt}");
	for(Path file:ds){
		System.out.println(file.getFileName());
	}
	
	DirectoryStream.Filter<Path> size_filter=new DirectoryStream.Filter<Path>() {

		@Override
		public boolean accept(Path path) throws IOException {
			// TODO Auto-generated method stub
			return (Files.size(path)>204800L);
		}
	};
	
	
	
	
	
	
	
	
	}
	
	@Test
	public void fileTest() throws IOException{
		Path newfile=FileSystems.getDefault().getPath("D://test2//test2/test2.txt");
		Files.createFile(newfile);

		
	}
	
	@Test
	public void fileTest1(){
		Path ball_path = Paths.get("D://test2//test2", "ball.png");   
		  
		byte[] ball_bytes = new byte[]{              
		(byte)0x89,(byte)0x50,(byte)0x4e,(byte)0x47,(byte)0x0d,(byte)0x0a,(byte)0x1a,(byte)0x0a,   
		(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x0d,(byte)0x49,(byte)0x48,(byte)0x44,(byte)0x52,   
		(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x10,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x10,   
		(byte)0x08,(byte)0x02,(byte)0x00,               
		 
		(byte)0x49,(byte)0x45,(byte)0x4e,(byte)0x44,(byte)0xae,(byte)0x42,(byte)0x60,(byte)0x82    
		};   
		  
		try {   
		    Files.write(ball_path, ball_bytes);   
		} catch (IOException e) {   
		    System.err.println(e);   
		}
	}
	
	@Test
	public void fileTest2(){
	    Path rf_wiki_path = Paths.get("D://test2//test2", "wiki.txt");   
	    
	    String rf_wiki = "Rafael \"Rafa\" Nadal Parera (born 3 June 1986) is a Spanish professional   " +
	    		"tennis " + "player and a former World No. 1. As of 29 August 2011 (2011 -08-29)[update], he is ";
	 
	    try {   
	        byte[] rf_wiki_byte = rf_wiki.getBytes("UTF-8");   
	        Files.write(rf_wiki_path, rf_wiki_byte);   
	    } catch (IOException e) {   
	        System.err.println(e);   
	    }  
	}
	@Test
	public void fileTest3(){
	    Path rf_wiki_path = Paths.get("D://test2//test2", "wiki.txt");  
	     
	    Charset charset = Charset.forName("UTF-8");  
	    ArrayList<String> lines = new ArrayList<>();  
	    lines.add("\n");  
	    lines.add("Rome Masters - 5 titles in 6 years");  
	    lines.add("Monte Carlo Masters - 7 consecutive titles (2005-2011)");  
	    lines.add("Australian Open - Winner 2009");  
	    lines.add("Roland Garros - Winner 2005-2008, 2010, 2011");  
	    lines.add("Wimbledon - Winner 2008, 2010");  
	    lines.add("US Open - Winner 2010");  
	      
	    try {  
	    Files.write(rf_wiki_path, lines, charset, StandardOpenOption.APPEND);  
	    } catch (IOException e) {  
	    System.err.println(e);  
	    }  
	}
	
	@Test
	public void ReadTest(){
	    Path ball_path = Paths.get("D://test2//test2", "ball.png");   
	
	    try {   
	        byte[] ballArray = Files.readAllBytes(ball_path);               
	    } catch (IOException e) {   
	        System.out.println(e);   
	    }  
	    
	    Path wiki_path = Paths.get("D://test2//test2", "wiki.txt");   
	
	    Charset charset = Charset.forName("ISO-8859-1");   
	    try {   
	        List<String> lines = Files.readAllLines(wiki_path, charset);   
	        for (String line : lines) {   
	             System.out.println(line);   
	        }   
	    } catch (IOException e) {   
	        System.out.println(e);   
	    }  
	}
	
	
	@Test
	public void writerBufferTest() throws IOException{
		Path wiki_path=Paths.get("D://test2//test2", "wiki.txt"); 
		Charset charset=Charset.forName("UTF-8");
		String text="Hello";
		BufferedWriter writer=Files.newBufferedWriter(wiki_path, charset,  StandardOpenOption.APPEND);
		writer.write(text);
	}
	@Test
	public void readBufferTest() throws IOException{
		
		Path wiki_path=Paths.get("D://test2//test2", "wiki.txt"); 
		Charset charset=Charset.forName("UTF-8");
		BufferedReader reader=Files.newBufferedReader(wiki_path, charset);
		String line=null;
		while((line=reader.readLine())!=null){
			System.out.println(line);
		}
	}
	
	@Test
	public void OutputStreamTest() throws IOException{
		Path rn_racquet=Paths.get("D://test2//test2", "racquet.txt");
        String racquet="hello world!";
		byte[] data=racquet.getBytes();
		OutputStream outputStream=Files.newOutputStream(rn_racquet);
		outputStream.write(data);
	}
	

	@Test
	public void OutputStreamTest1() throws IOException{
		Path rn_racquet=Paths.get("D://test2//test2", "racquet.txt");
        String string="hello world!";
		OutputStream outputStream=Files.newOutputStream(rn_racquet, StandardOpenOption.APPEND);
		BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream));
	    writer.write(string);
	}
	@Test
	public void readBufferTest4() throws IOException{
		
		Path rn_racquet=Paths.get("D://test2//test2", "racquet.txt");
		InputStream in=Files.newInputStream(rn_racquet);
		BufferedReader reader=new BufferedReader(new InputStreamReader(in));
		String line=null;
		while((line=reader.readLine())!=null){
			System.out.println(line);
		}
	}
	
	 
	
	
	
	
	
	
}
